package HomeWorkTwelve;

import java.util.Scanner;

public class MyLink {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入链表节点数：");
        int val = sc.nextInt();
        ListNode head = createList(val);
        print(head);
        System.out.print("\n输入要删除的节点数据：");
        int data = sc.nextInt();
        head = deleteNode(head, data);
        print(head);
    }

    //创建链表
    public static ListNode createList(int val) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入头节点数据：");
        int data = sc.nextInt();
        ListNode head = new ListNode(data);
        ListNode pre = head;
        for (int i = 0; i < val - 1; i++) {
            System.out.print("输入头节点数据：");
            data = sc.nextInt();
            ListNode node = new ListNode(data);
            pre.next = node;
            pre = node;
            node.next = null;
        }
        return head;
    }

    //删除链表指定节点
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                if (pre != null) {
                    pre.next = cur;
                } else {
                    return cur;
                }
            }
            //该if是为了：如果删除的是尾结点的话，判断cur是否为null
            if (cur == null) {
                break;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
    //打印链表
    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
