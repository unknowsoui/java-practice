class Node{
    int value;
    Node next;
    public Node(int num){
        value = num;
        next = null;
    }
}

public class test0604 {
    public static int getlength(Node head){
        int count = 0;
        Node cur = head;
        while(true){
            if(cur == null){
                break;
            }
            cur = cur.next;
            count++;
        }
        return count;
    }
    public static Node FindKthToTail(Node head,int k){
        int size = getlength(head)-k;
        int flag = 0;
        Node cur =head;
        if(size < 0)
        {
                System.out.println("错误，链表长度不够");
                return null;
        }
        else{
            while(flag == size){
                cur = cur.next;
                flag++;
            }
        }
        return cur;
    }
    public static Node FindKthTotail2(Node head,int k){
        Node front = head;
        Node cur = head;
        for(int i = 0;i < k;i++){
            if(front == null){
                return null;
            }
            front = front.next;
        }
        while(front != null){
            front = front.next;
            cur = cur.next;
        }
        return cur;
    }
    public static Node middleNode(Node head){
        Node front = head;
        Node cur = head;
        while(true){
            front = front.next;
            if(front == null){
                break;
            }
            cur = cur.next;
            front = front.next;
        }
        return  cur;
    }

    public static Node mergeTwoLists(Node n1,Node n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        Node cur1 = n1;
        Node cur2 = n2;
        Node result = null;
        Node last = null;
        while(cur1 != null&&cur2 != null){
            if(cur1.value <= cur2.value){
                if(result == null){
                    result = cur1;
                }
                else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = cur1.next;
            }
            else{
                if(result == null){
                    result = cur2;
                }
                else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            last.next = cur1;
        }
        if(cur2 != null){
            last.next =cur2;
        }
        return result;
    }
    public static void display(Node head){
        Node cur = head;
        for(;cur != null;cur = cur.next){
            System.out.printf("%d--->",cur.value);
        }
        System.out.println(cur);
    }
    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        Node n11 = new Node(1);
        Node n12 = new Node(2);
        Node n13 = new Node(3);
        Node n14 = new Node(4);
        Node n15 = new Node(5);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = null;
        Node head = mergeTwoLists(n1,n11);
        display(head);

    }
}
