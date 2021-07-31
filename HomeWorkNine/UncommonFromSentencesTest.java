package HomeWorkNine;
import java.util.*;
class Solution{
    public String[] uncommonFromSentences(String s1,String s2){
        String[] str1=s1.split(" ");
        String[] str2=s2.split(" ");
        HashMap<String,Integer> hm=new HashMap<>();
        List<String> list=new ArrayList<>();
        for(String key:str1){
            Integer value=hm.get(key);
            if(value==null){
                hm.put(key,1);
            }else{
                value++;
                hm.put(key,value);
            }
        }
        for(String key:str2){
            Integer value=hm.get(key);
            if(value==null){
                hm.put(key,1);
            }else{
                value++;
                hm.put(key,value);
            }
        }
        Set<Map.Entry<String,Integer>> set=hm.entrySet();
        for(Map.Entry<String,Integer> me:set){
            if(me.getValue()==1){
                list.add(me.getKey());
            }
        }
        //将List集合转化数组
        return list.toArray(new String[list.size()]);
    }
}
public class UncommonFromSentencesTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一条语句：");
        String s1=sc.nextLine();
        System.out.println("请输入第二条语句：");
        String s2=sc.nextLine();
        Solution solution=new Solution();
        String[] result=solution.uncommonFromSentences(s1,s2);
        System.out.println("两条语句中的不常见单词为：");
        for(String s:result){
            System.out.println(s);
        }
    }
}
