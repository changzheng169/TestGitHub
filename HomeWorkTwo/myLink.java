package HomeWorkTwo;
//链表类
public class myLink {
    public Node head;//头指针
    public Node end;//尾结点
    int size;//记录链表长度
    public myLink(){
       end=new Node(null,null,null);
        head=new Node(null,null,end);
        end.prev=head;
        end.next=head;
        size=0;
   }
   //获取长度
    public int length(){
        return size;
    }
    //获取节点
    public Node getNode(int index){
        Node temp;
        if(index>=length()/2){
            temp=end;
            for(int i=length();i>index;i--){
                temp=temp.prev;
            }
            return temp;
        }else{
            temp=head;
            for(int i=0;i<=index;i++){
                temp=temp.next;
            }
            return temp;
        }
    }
   //添加元素
    public void add(Student s){
        //添加结点
        Node pNode=new Node(s,getNode(size-1),end);
        pNode.next.prev=pNode;
        pNode.prev.next=pNode;
        size++;
    }
    //插入元素
    public void insert(int i,Student s){
        //原本索引位置的结点
        Node n=getNode(i);
        //建立即将插入的结点
        Node pNode=new Node(s,n.prev,n);
        n.prev.next=pNode;
        n.prev=pNode;
        size++;
    }
    //删除元素，返回删除的数据
    public Student remove(int i){
        //原本索引位置的结点
        Node n=getNode(i);
        //删除结点
        Student s=n.data;
        n.prev.next=n.next;
        n.next.prev=n.prev;
        size--;
        return s;
    }
    //修改指定位置的数据,返回原本数据
    public Student reset(int i,Student s){
        Node n=getNode(i);
        Student oldS=n.data;
        n.data=s;
        return oldS;
    }
    //查找指定位置的数据
    public Student getStudent(int i){
        Node n=getNode(i);
        Student s=n.data;
        return s;
    }
    //打印链表中的内容
    public void print(){
        for(int i=0;i<size;i++){
            Student s=getNode(i).data;
            System.out.println(s.getName()+","+s.getAge());
        }
    }
}
