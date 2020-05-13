package sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


/**
 * 华为机试题，输入一个字符串 如 aaddfadfdaf，以 a:4;d:4;f:3; 这种形式返回每个字符的个数，
 * 注意按照字符出现次数的多少顺序从大到小排序，同时要保持每个字符的相对顺序。
 */
public class MainHuaWei {

    static class KeyValue{
        Character key;
        Integer value;

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
        HashMap<Character,Integer> map = new HashMap<>();
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

        LinkedList<KeyValue> resList = quickSort(list,0,list.size()-1);

        for(KeyValue item : resList){
            sb.append(item.getKey()).append(":").append(item.getValue()).append(";");
        }

        System.out.print(sb.toString());
    }

    // 快排，不稳定的排序，字母出现次数相同，会改变字母原来的相对顺序
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

    // 获取值
    private static Integer getByIndex(LinkedList<KeyValue> list, int index){
        return list.get(index).getValue();
    }

}

