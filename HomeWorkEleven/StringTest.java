package HomeWorkEleven;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("输入想要测试的字符串：");
        String str=sc.nextLine();
        Solution solution=new Solution();
        System.out.println("\n结果为："+solution.irstUniqChar(str));
    }

}
