import java.util.*;

class RemovingCycle{
	public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}
	} 
	public static boolean isCycle(Node head){
		Node slow=head;
		Node fast=head.next;
		//detecting cycle using slow pointer and fast pointer
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){  //both slow and fast pointer matches means cycle detected
				return true;
			}
		}
		
		//else return false no cycle detected
		return false;
	}
	public static void removeCycle(Node head)
	{
		Node slow=head;
		Node fast=head;
		//detecting point of intersection of slow and fast pointer
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				break;
			}
		}
		//find point of cycle 
		
		Node prev=null;
		slow=head;
		while(slow!=fast){
			slow=slow.next;
			prev=fast;
			fast=fast.next;
		}
		prev.next=null;
	}
	public static Node head=null;
	public static void main(String args[]){
		//1->2->3->4->5->2
		Node n1=new Node(1);
		head=n1;
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n2;
		//removing cycle in linked list
		if(isCycle(head))
		{
			System.out.println(isCycle(head));  //it returns true that means cycle detected
			removeCycle(head);					//removing cycle
			System.out.println(isCycle(head));		//It returns flase that means no cycle
		}
	}
}