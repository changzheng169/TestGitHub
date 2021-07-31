package HomeWorkSeven;
import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        val=data;
    }
}
public class ReverseList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int  listSize;
        System.out.println("输入链表长度：");
        listSize=sc.nextInt();
        ListNode head=createList(listSize);
        System.out.println("反转链表前：");
        print(head);
        head=reverseList(head);
        System.out.println("反转链表后：");
        print(head);
    }
    //创建链表
    public static ListNode createList(int listSize){
        int data;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入头节点数据：");
        data=sc.nextInt();
        ListNode head=new ListNode(data);
        //在声明一个节点，存放上一个节点
        ListNode pre=head;
        for(int i=0;i<listSize-1;i++){
            System.out.println("输入节点数据：");
            data=sc.nextInt();
            ListNode node=new ListNode(data);
            pre.next=node;
            pre=node;
            //该节点有可能是最后一个节点，所以每次都让node节点的next指向NULL
            node.next=null;
        }
        return head;
    }
    //反转链表
    public static ListNode reverseList(ListNode head){
       ListNode previous=null;
       ListNode current=head;
       ListNode temp=null;
       while(current!=null){
           ///保存后一个结点的位置
           temp=current.next;
           //将当前节点指向上一节点
           current.next=previous;
           previous=current;
           current=temp;
       }
       return previous;
    }
    //打印输出链表
    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("\n----------------");
    }
}
