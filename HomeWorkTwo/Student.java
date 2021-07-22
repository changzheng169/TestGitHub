package HomeWorkTwo;
//学生类
public class Student {
    private String  name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(){
    }
    void setName(String name){
        this.name=name;
    }
    void setAge(int age){
        this.age=age;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
}
