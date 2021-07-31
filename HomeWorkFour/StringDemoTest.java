package HomeWorkFour;

import java.util.Arrays;

//字符串工具
public class StringDemoTest {
    public static void main(String[] args) {
        String s="acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";
        String[] sArray=s.split(",");
        String s1=sArray[0];
        String s2=sArray[1];
        String s3=sArray[2];
        String s4=sArray[3];
        String s5=sArray[4];
        String s6=sArray[5];
        String s7=sArray[6];
        String s8=sArray[7];
        function1(s1);
        function1(s2);
        function2(s3);
        function3(s4);
        function4(s7);
        function5(s6);
        function6(s7);
    }
//判断字符串是否全是数字
    public static void function1(String ss){
        int flag=1;
        for(int i=0;i<ss.length();i++){
            char ch=ss.charAt(i);
            if(!(ch>='0'&& ch<='9')){
                flag=0;
                break;
            }
        }
        if(flag==1){
            System.out.println(ss+":"+"字符串是由数字组成！");
        }else{
            System.out.println(ss+":"+"字符串不都是由数字组成！");
        }
    }
 //判断字符串是否是大写字母
    public static void function2(String ss){
        int flag=1;
        for(int i=0;i<ss.length();i++){
            char ch=ss.charAt(i);
            if(!(ch>='A'&& ch<='Z')){
                flag=0;
                break;
            }
        }
        if(flag==1){
            System.out.println(ss+":"+"字符串是由大写字母组成！");
        }else{
            System.out.println(ss+":"+"字符串不都是由大写字母组成！");
        }
    }
    //判断字符串是否全是小写字母
    public static void function3(String ss){
        int flag=1;
        for(int i=0;i<ss.length();i++){
            char ch=ss.charAt(i);
            if(!(ch>='a'&& ch<='z')){
                flag=0;
                break;
            }
        }
        if(flag==1){
            System.out.println(ss+":"+"字符串是由小写字母组成！");
        }else{
            System.out.println(ss+":"+"字符串不都是由小写字母组成！");
        }
    }
    //如果字符串全是字母，将其中所有小写字母转换为大写字母
    public static void function4(String ss) {
        int flag = 1;
        for (int i = 0; i < ss.length(); i++) {
            char ch = ss.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z')||(ch>='a'&& ch<='z'))) {
                flag = 0;
                break;
            }
        }
        if(flag==1){
            System.out.println(ss+":"+"是由字母组成"+","+"转换后："+ss.toUpperCase());
        }
        else{
            System.out.println(ss+":"+"不符合全是字母的条件，不能转换！");
        }
    }
    //如果字符串全是数字组成，则按照数字大小升序排序并装入整型数组中。最后按升序打印出该数组
    public static void function5(String ss){
        int[] array=new int[ss.length()];
        int flag=1;
        for(int i=0;i<ss.length();i++){
            char ch=ss.charAt(i);
            if(!(ch>='0'&& ch<='9')){
                flag=0;
                break;
            }
        }
        if(flag==1){
          for(int i=0;i<ss.length();i++){
              //减去’0‘，可转换为数字
              array[i]=ss.charAt(i)-'0';
          }
          //排序,升序
          Arrays.sort(array);
          System.out.print(ss+":"+"放入数组，升序排列：");
          System.out.print("[");
          for(int i=0;i<array.length;i++){
             if(i==array.length-1){
                 System.out.print(array[i]);
             }else{
                 System.out.print(array[i]+",");
             }

          }
            System.out.println("]");
        }else{
            System.out.println(ss+":"+"字符串不都是由数字组成！"+"不能实现排序");
        }
    }
    //如果字符串全是字母组成，则按照字母排序装入字符数组中，并按字母顺序打印出该数组。
    public static void function6(String ss) {
        Character[] characters=new Character[ss.length()];
        int flag = 1;
        for (int i = 0; i < ss.length(); i++) {
            char ch = ss.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z')||(ch>='a'&& ch<='z'))) {
                flag = 0;
                break;
            }
        }
        if(flag==1){
            for(int i=0;i<ss.length();i++){
                //自动装箱
                characters[i]=ss.charAt(i);
            }
            Arrays.sort(characters);
            System.out.print(ss+":"+"放入字符数组，升序排列：");
            for(int i=0;i<characters.length;i++){
                System.out.print(characters[i]);
            }
        }
        else{
            System.out.println(ss+":"+"字符串不都是由字母组成！"+"不能实现排序");
        }
    }
}
