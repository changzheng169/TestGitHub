package HomeWorkTwo;
//结点类
public class Node{
    public Student data;//数据域
    public Node prev;//上一个结点
    public Node next;//下一个结点
    public Node(){
    }
    public Node(Student s,Node prev,Node next){
        data=s;
        this.prev=prev;
        this.next=next;
    }
}
