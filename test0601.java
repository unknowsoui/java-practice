class Test{
    int value;
    Test next;
    public Test(int num){
        value = num;
        next = null;
    }
}
public class test0601 {

    //链表格式显示
    public static void display(Test head){
        Test cur = head;
        for(;cur != null;cur = cur.next){
            System.out.printf("%d--->",cur.value);
        }
        System.out.println(cur);
    }

    //插入链表头
    public static Test pushfront(Test head,int value){
        Test newtest = new Test(value);
        newtest.next=head;
        return newtest;
    }
    //插入链表
    public static Test pushback(Test head,int value){
        Test newtest = new Test(value);
        if(head == null){
            newtest.next = head;
            return newtest;
        }
        else{
            Test last = getlast(head);
            last.next = newtest;
            return head;
        }
    }

    //获取链表最后一个数据的引用
    private static Test getlast(Test head){
        Test test = head;
        while(test.next != null){
            test = test.next;
        }
        return test;
    }

    //删除链表头
    public static Test popfront(Test head){
        head = head.next;
        return head;
    }
    //删除链表第一个碰到的value
    public static Test popback(Test head,int value){
        Test cur = head.next;
        Test prev = head;
        if(head == null){
            System.out.println("错误,链表中没有数据!");
            return head;
        }
        if(head.value == value){
          head = popfront(head);
          return head;
        }
        else{
            while(true){
                if(cur.value == value){
                    prev.next = cur.next;
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    //反转链表
    public static Test reverselist(Test head){
        Test newlist = null;//构建新链表以便保存反转
        Test cur = head;
        while(cur != null){
            Test next = cur.next;
            cur.next = newlist;
            newlist = cur;
            cur = next;
        }
        return newlist;
    }

    //删除链表中所有的value
    public static Test removelement(Test head,int value){
        Test newlist = null;
        Test last = null;
        Test cur = head;
        while(cur != null) {
            Test next = cur.next;
            if (cur.value != value) {
                if(newlist == null){
                    cur.next = newlist;
                    newlist = cur;
                }
                else{
                    last.next = cur;
                }
                last = cur;
            }
            cur = next;
        }
        last.next = null;
        return newlist;
    }
    public static void main(String[] args){
        Test head = null;
        head = pushback(head,1);
        head = pushback(head,2);
        head = pushback(head,3);
        display(head);
        head = reverselist(head);
        display(head);
        head = pushback(head,2);
        head = removelement(head,2);
        display(head);
    }
}
