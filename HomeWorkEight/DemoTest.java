package HomeWorkEight;
import java.util.Scanner;
public class DemoTest {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入栈容量:");
        int stackSize=sc.nextInt();
        Stack stack=new Stack(stackSize);
        //压栈
        for(int i=0;i<stackSize;i++){
            System.out.println("栈中数据：");
            int stackData=sc.nextInt();
            stack.push(stackData);
        }
        //获取栈顶值,不返回
        stack.peek();
        //判断元素是否在栈中
        System.out.println("输入想要判断的数据：");
        int myData=sc.nextInt();
        stack.search(myData);
        //出栈
        int result=stack.pop();
        if(result==1000){
            System.out.println("栈已空，无法出栈");
        }else{
            System.out.println("pop获取栈顶数据："+result);
        }
        //判断栈是否已空
        stack.isEmpty();
        //打印数据
        stack.print();
    }
}
