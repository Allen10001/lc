import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 自己实现一个阻塞队列,并实现 生产者和消费者的计数
public class MyBlockingQueue<E> {
    // 队列容器
    private LinkedList<E> container = new LinkedList<E>();
    // 当前队列长度
    public static int length;
    // 声明锁
    private Lock lock = new ReentrantLock();
    // 锁标志
    private final Condition conditionNull = lock.newCondition();

    public void add(E item){
        try{
            lock.lockInterruptibly();
            container.add(item);
            length++;
            conditionNull.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public E take(){
        E res = null;
        try{
            lock.lockInterruptibly();
            if(length==0){
                try{
                    // 队列长度为0，进入等待
                    conditionNull.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            res = container.remove(0);
            length--;
            return res;
        }catch (InterruptedException e){
            e.printStackTrace();
            return res;
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args){
        MyBlockingQueue<Integer> queue = new MyBlockingQueue();
        Thread preducer = new Thread(new Runnable() {
            @Override
            public void run() {
                for(Integer i=0;i<1000;i++){
                    queue.add(i);
                    System.out.println("add i to queue,i="+i);
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            volatile int count = 0;
            Integer res = null;
            @Override
            public void run() {
                while(1==1){
                    if((res=queue.take())!=null){
                        count++;
                    }
                    System.out.println("count:"+count);

                }
            }
        });

        preducer.start();
        consumer.start();
    }
}
