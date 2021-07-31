package HomeWorkEight;
public class Stack {
    private int[] intArray; //由一个数组来实现栈
    private int top; //栈顶索引
    private int maxsize; //栈的容量
    Stack(int maxsize){
     if(maxsize>0) {
         this.maxsize = maxsize;
         intArray = new int[maxsize];
         for (int i = 0; i < maxsize; i++) {
             intArray[i] = 0;
         }
     }else{
         this.maxsize=0;
         intArray=new int[0];
     }
     top=0;
    }
    //压栈
    public void push(int data){
        if(data>=-999&&data<=999) {
            if (top < maxsize) {
                intArray[top] = data;
                top++;
            } else {
                System.out.println("堆栈已满，不能再压入数据:" + data);
            }
        }
        else{
            System.out.println(data+"不在-999到999之间，不能压入");
        }
    }
    //判断栈是否为空
    public void isEmpty(){
        if(top<=0){
            System.out.println("栈已空！");
        }else{
            System.out.println("目前栈不为空");
        }
    }
    //判断元素elem是否在栈中
    public void search(int num){
        int flag=0;
        for(int i=0;i<top;i++){
            if(num==intArray[i]){
                System.out.println(num+"元素已在栈中！");
                flag=1;
            }
        }
        if(flag==0){
            System.out.println(num+"不在栈中!");
        }
    }
    //获取栈顶值,不返回
    public void peek(){
        if(top>0){
            System.out.println("peek获取栈顶数据："+intArray[top - 1]);
        }else{
            System.out.println("请检查是否栈已空！");
        }
    }
    //获取栈顶值，并返回
    public int pop(){
        if (top > 0) {
            int t = intArray[top - 1];
            top--;
            return t;
        } else{
            System.out.println("请检查是否栈已空！");
            return 1000;
        }
    }
    //以二进制、八进制、十六进制打印输出
    public void print(){
        if(top>0) {
            System.out.println("以二进制输出：");
            for (int i=top-1;i>=0;i--){
                System.out.println(Integer.toBinaryString(intArray[i]));
            }
            System.out.println("---------------");
            System.out.println("以八进制输出：");
            for (int i=top-1;i>=0;i--){
                System.out.println(Integer.toOctalString(intArray[i]));
            }
            System.out.println("---------------");
            System.out.println("以十六进制输出：");
            for (int i=top-1;i>=0;i--){
                System.out.println(Integer.toHexString(intArray[i]));
            }
        }
    }
}

