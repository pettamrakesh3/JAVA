import java.util.*;
public class Linked_List{
    public class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=tail.next;
        return;
    }
    public void addIndex(int i,int data)
    {
        if(head==null)
        {
            addFirst(data);
            return;
        }
        if(i==1)
        {
            addFirst(data);
            return;
        }
        if(i==size()+1)
        {
            addLast(data);
            return;
        }
        Node temp=head;
        Node newNode=new Node(data);
        while(i>2)
        {
            temp=temp.next;
            i--;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return;
    }
    public void removeFirst()
    {
        if(head==null)
        {
            System.out.println("LinkedList is empty.");
            return;
        }
        if(head.next==null)
        {
            head=tail=null;
        }
        head=head.next;
        return;
    }
    public void removeLast()
    {
        if(tail==null)
        {
            System.out.println("LinkedList is empty.");
            return;
        }
        if(head.next==null)
        {
            head=tail=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return;
    }
    public void removeIndex(int i)
    {
        if(head==null)
        {
            System.out.println("Linked list is empty");
            return;
        }
        if(i==1)
        {
            removeFirst();
            return;
        }
        if(i==size())
        {
            removeLast();
            return;
        }
        Node temp=head;
        while(i>2)
        {
            temp=temp.next;
            i--;
        }
        temp.next=temp.next.next;   
        return;
    }
    public void display()
    {
        if(head==null)
        {
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
        return;
    }
    public int size()
    {
        if(head==null)
        {
            return 0;
        }
        int l=0;
        Node temp=head;
        while(temp!=null)
        {
            l++;
            temp=temp.next;
        }
        return l;
    }
    public int search(int key)
    {
        if(head==null)
        {
            return -1;
        }
        Node temp=head;
        int c=1;
        while(temp!=null)
        {
            if(temp.data==key)
            {
                return c;
            }
            temp=temp.next;
            c++;
        }
        return -1;
    }
    public int Recurse(Node head,int key)
    {
        if(head==null)
        {
            return -1;
        }
        if(head.data==key)
        {
            return 1;
        }
        int idx=Recurse(head.next,key);
        if(idx==-1)
        {
            return -1;
        }
        return idx+1;
    }
    public int RecursiveSearch(int key)
    {
        return Recurse(head,key);
    }
    public void reverse()
    {
        if(head==null || head.next==null)
        {
            return;
        }
        Node curr=head;
        Node prev=null;
        Node next;
        tail=head;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String args[])
    {
        Linked_List ll=new Linked_List();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addLast(5);
        ll.addLast(6);
        ll.addIndex(1,1);
        ll.addIndex(2, 2);
        ll.addLast(7);
        ll.addIndex(8, 8);
        ll.display();
        System.out.println("Size of Linked_list: "+ll.size());
        ll.removeFirst();
        ll.removeLast();
        ll.removeIndex(4);
        ll.display();
        System.out.println("Size of Linked_list: "+ll.size());
        ll.addFirst(1);
        ll.addLast(8);
        ll.addIndex(5, 5);
        ll.display();
        System.out.println("key Found at index: "+ll.search(4));
        System.out.println("Key Found at index: "+ll.RecursiveSearch(7));
        ll.reverse();
        ll.display();
        ll.reverse();
        ll.display();
    }
}