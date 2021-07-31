package HomeworkOne;
//实现加，减，乘，除等运算
public class Point {
    //加法运算
    public Calculator add(Calculator c1,Calculator c2){
        return new Calculator(c1.getNumber()+c2.getNumber());
    }
    //减法运算
    public Calculator minus(Calculator c1,Calculator c2){
        return new Calculator(c1.getNumber()-c2.getNumber());
    }
    //乘法运算
    public Calculator multiply(Calculator c1,Calculator c2){
        return new Calculator(c1.getNumber()*c2.getNumber());
    }
    //除法运算
    public Calculator divide(Calculator c1,Calculator c2){
        return new Calculator(c1.getNumber()/c2.getNumber());
    }
}
