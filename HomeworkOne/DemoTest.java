package HomeworkOne;
import java.util.Scanner;
public class DemoTest {
    public static void main(String[] args){
        //计算器类12
        Calculator c1=new Calculator();
        Calculator c2=new Calculator();
        //为计算器赋值
        double number1,number2;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数据:");
        number1=sc.nextDouble();
        c1.setNumber(number1);
        System.out.println("请输入第二个数据:");
        number2= sc.nextDouble();
        c2.setNumber(number2);
        //进行加，减，乘，除运算
        Point p=new Point();
        //加法
        Calculator c3=p.add(c1,c2);
        System.out.println("两者相加结果为："+c1.getNumber()+"+"+c2.getNumber()+"="+c3.getNumber());
        //减法
        c3=p.minus(c1,c2);
        System.out.println("两者相减结果为："+c1.getNumber()+"-"+c2.getNumber()+"="+c3.getNumber());
        //乘法
        c3=p.multiply(c1,c2);
        System.out.println("两者相乘结果为："+c1.getNumber()+"*"+c2.getNumber()+"="+c3.getNumber());
        //除法
        if(c2.getNumber()!=0){
            c3=p.divide(c1,c2);
            System.out.println("两者相除结果为："+c1.getNumber()+"/"+c2.getNumber()+"="+c3.getNumber());
        }else{
            System.out.println("除数为0，不能运算！");
        }
        //复合运算
        c3=p.multiply(c1,p.add(c1,c2));
        System.out.println("复合运算结果为："+c1.getNumber()+"*"+"("+c1.getNumber()+"+"+c2.getNumber()+")"+"="+c3.getNumber());
    }
}
