import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
//
public class Solution02 {

    volatile static boolean open=true;
    volatile static int index_lower=97;
    volatile static int index_upper=65;

    public static void main(String[] args){
        ArrayList<Character> resList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(new MyRun1(resList,latch),"thread1");
        Thread thread2 = new Thread(new MyRun2(resList,latch),"thread2");
        try{
            System.out.println("task begin:"+System.currentTimeMillis());
            thread1.start();
            thread2.start();
            latch.await();
            System.out.println("task end:"+System.currentTimeMillis());
        }catch(Exception e){
            System.out.println("error"+e);
        }

        StringBuilder sb = new StringBuilder();
        for(char item :resList){
            sb.append(item);
        }
        System.out.println(sb.toString());
    }



    static class MyRun1 implements Runnable{
        ArrayList<Character> resList;
        CountDownLatch latch;
        public MyRun1(ArrayList<Character> resList,CountDownLatch latch) {
            this.resList = resList;
            this.latch = latch;
        }

        @Override
        public void run(){
            System.out.println("MyRun1 开始时间:" + new java.util.Date().getTime());
            while(index_lower < 123){
                synchronized (latch){
                    if(open){
                        resList.add((char)index_lower++);
                        open = false;
                        latch.notify();
                        try{
                            latch.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("MyRun1 结束时间:" + new java.util.Date().getTime());
            latch.countDown();
        }
    }

    static class MyRun2 implements Runnable{
        ArrayList<Character> resList;
        CountDownLatch latch;
        public MyRun2(ArrayList<Character> resList,CountDownLatch latch) {
            this.resList = resList;
            this.latch = latch;
        }
        @Override
        public void run(){
            System.out.println("MyRun2 开始时间:" + new java.util.Date().getTime());
            while(index_upper < 91){
                synchronized (latch){
                    if(!open){
                        resList.add((char)index_upper++);
                        open = true;
                        latch.notify();
                        try{
                            if(index_upper < 91){  //如果 index_upper 到达 Z(90) 时，不需等待直接退出
                                latch.wait();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("MyRun2 结束时间:" + new java.util.Date().getTime());
            latch.countDown();
        }
    }
}
