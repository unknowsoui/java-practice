class Node{
    int value;
    Node next;
    Node random;
    public Node(int val){
        value = val;
    }
}

public class test0614 {
    public static Node copyRandomList(Node head){
        Node cur = head;
        while(cur != null){
            Node node = new Node(cur.value);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            else{
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node newhead = head.next;
        while(cur != null){
            Node node = cur.next;
            cur.next = node.next;
            if(node.next != null){
                node.next = node.next.next;
            }
            cur = cur.next;
        }
        return newhead;
    }
    public static Node removeValue(Node head,int val){
        Node cur = head.next;
        Node prev = head;
        while(cur != null){
            if(cur.value == val){
                prev.next = cur.next;
            }
            else{
            prev = cur;
            }
            cur = cur.next;
        }
        if(head.value == val){
            head = head.next;
        }
        return head;
    }
    public static Node reverseList(Node head){
        Node newnode = null;
        Node cur = head;
        while(cur != null){
            Node last = cur.next;
            cur.next = newnode;
            newnode= cur;
            cur = last;
        }
        return newnode;
    }
    public static Node mergeTwoList(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        Node result = null;
        Node last = null;
        while(cur1 != null&&cur2 != null){
            if(cur1.value < cur2.value){
                if(result == null){
                    result = cur1;
                    last = result;
                }
                else{
                    last.next = cur1;
                    last = cur1;
                }
                cur1 = cur1.next;
            }
            else{
                if(result == null){
                    result = cur2;
                    last = result;
                }
                else{
                    last.next = cur2;
                    last = cur2;
                }
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
    public static Node deleteDuplicated(Node head){
        Node fast = head;
        Node slow = head;
        while()
    }
    public static void display(Node head){
        Node cur = head;
        for(;cur != null;cur = cur.next){
            System.out.printf("%d--->",cur.value);
        }
        System.out.println(cur);
    }
    public static void main(String[] args){
        Node head =null;
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
        head = mergeTwoList(n1,n11);
        display(head);
        n11 = reverseList(n11);
        display(n11);
        n11 = removeValue(n11,1);
        display(n11);
    }
}