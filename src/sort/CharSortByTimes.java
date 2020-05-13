package sort;

import java.security.Key;
import java.util.*;


/**
 * 华为机试题，输入一个字符串 如 aaddfadfdaf，以 a:4;d:4;f:3; 这种形式返回每个字符的个数，
 * 注意按照字符出现次数的多少顺序从大到小排序，同时要保持每个字符的相对顺序。
 */
public class CharSortByTimes {

    static class KeyValue{
        private Character key;
        private Integer value;

        public KeyValue(Character key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Character getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setKey(Character key) {
            this.key = key;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> map = new LinkedHashMap<>();
        String str = sc.next();
        for(int i=0;i<str.length();i++){
            Character item = (Character)str.charAt(i);
            if(item.charValue()<'A' || item.charValue()>'z'){
                System.out.println( sb.toString());
            }
            if(map.containsKey(item)){
                map.put(item,map.get(item)+1);
            }else{
                map.put(item,1);
            }
        }

        LinkedList<KeyValue> list = new LinkedList<>();

        for(Map.Entry entry : map.entrySet()){
            KeyValue keyValue = new KeyValue((Character)entry.getKey(),(Integer)entry.getValue());
            list.add(keyValue);
        }

        // LinkedList<KeyValue> resList = quickSort(list,0,list.size()-1);

        LinkedList<KeyValue> listCopy = new LinkedList<>();
        for(int i=0;i<list.size();i++){
            listCopy.add(list.get(i));
        }

        mergeSort(list,listCopy,0,list.size()-1);

        for(KeyValue item : list){
            sb.append(item.getKey()).append(":").append(item.getValue()).append(";");
        }

        System.out.print(sb.toString());
    }

    /**
     * 快排，不稳定的排序，字母出现次数相同，会改变字母原来的相对顺序,不适用与本题
     * @param list
     * @param start
     * @param end
     * @return
     */
    @Deprecated
    private static LinkedList<KeyValue> quickSort(LinkedList<KeyValue> list, int start, int end){

        int i = start;
        int j = end;

        if(i>=j){
            return list;
        }

        Integer label = getByIndex(list,end);
        while(i!=j){
            while(getByIndex(list,i)>=label && i<j){
                i++;
            }
            while(getByIndex(list,j)<=label && i<j){
                j--;
            }
            KeyValue temp = list.get(i);
            list.set(i,list.get(end));
            list.set(end,temp);
        }

        quickSort(list,start,i-1);
        quickSort(list,i+1,end);

        return list;
    }

    /**
     * 归并排序, 稳定的排序，字母出现次数相同，不会改变字母原来的相对顺序
     * @param list
     * @param listCopy
     * @param start
     * @param end
     * @return
     */
    private static void mergeSort(LinkedList<KeyValue> list, LinkedList<KeyValue> listCopy, int start, int end){

        if(start == end){
            return;
        }else{
            int mid = (start+end)/2;
            mergeSort(list, listCopy, start, mid);
            mergeSort(list, listCopy,mid+1, end);
            merge(list,listCopy,start,end);
        }
        return;
    }

    // 合并两个有序数组
    private static LinkedList<KeyValue> merge(LinkedList<KeyValue> list, LinkedList<KeyValue> listCopy,
                                              int start, int end){
        int i=start;
        int mid = (start+end)/2;
        int j=mid+1;
        int index=start;

        while(i<=mid && j<=end){
            if(getByIndex(list,i)>=getByIndex(list,j)){
                listCopy.set(index,list.get(i));
                i++;
            }else{
                listCopy.set(index,list.get(j));
                j++;
            }
            index++;
        }

        // 拼接上剩余的
        if(i<=mid){
            while(index<=end){
                listCopy.set(index,list.get(i));
                i++;
                index++;
            }
        }
        if(j<=end){
            while(index<=end){
                listCopy.set(index,list.get(j));
                j++;
                index++;
            }
        }

        // 使用 copyList 暂存排好序的列表，但是每次排序都是使用对局部排好序的list进行整体排序，所以使用copyList的值更新list
        for(int m=start;m<=end;m++){
            list.set(m,listCopy.get(m));
        }
        return list;
    }

    /**
     * 获取值
     * @param list
     * @param index
     * @return
     */
    private static Integer getByIndex(LinkedList<KeyValue> list, int index){
        return list.get(index).getValue();
    }

}

