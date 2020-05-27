/**
 * 快手面试题：实现标记回收，将数组中所有非0的值按原来的顺序移到数组前面，所有的0值移动到数组的后面
 * 如：{1,3,0,0,2,0,1}   -->   {1,3,2,1,0,0,0}
 */
public class KuaiShouArrayMove {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        /*
          {1,3,0,0,2,0,1}
        * {1,3,0,2,0,1,0}
        * {1,3,2,0,1,0,0}
        *
        */
        int[] array = {0, 0, 0, 2, 0, 0, 1};
        KuaiShouArrayMove.compactBak(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 低效解法
     *
     * @param array
     */
    static void compact(int[] array) {
        int count = -1;
        int i = 0;
        while (i < array.length) {
            if (array[i] == 0) {
                count++;
                int j = i;
                while (j < array.length - 1) {
                    array[j] = array[j + 1];
                    j++;
                }
                array[array.length - count - 1] = -1;
            } else {
                i++;
            }
        }
        int m = 0;
        while (m < array.length) {
            if (array[m] == -1) {
                array[m] = 0;
            }
            m++;
        }
    }

    /**
     * 高效算法
     * @param array
     */
    static void compactBak(int[] array) {
        int i = 0;
        int index = -1;
        while (i < array.length) {
            if (array[i] == 0) {
                if (index == -1) {
                    index = i;
                }
            }else{
                if(index != -1){
                    array[index] = array[i];
                    array[i] = 0;
                    index++;
                }
            }
            i++;
        }
    }
}


