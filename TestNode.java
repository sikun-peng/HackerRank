import java.util.*;


public class TestNode {	
	
	public static class Node {
		int data;
		Node next;
		//Node prev;
		
		Node(int x){
			this.data = x;
		}
	}	
		public static void print(Node head){
			Node temp = head;
			while(temp != null){
				System.out.print(temp.data + "  ");
				temp = temp.next;
			}
			System.out.println();			
		}
		
		public static Node insert_tail(Node head, int data){		
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			
			temp.next = new Node(data);	
			return head;
		
		}
		
		public static Node insert_head(Node head, int data){
			Node new_head = new Node(data);
			new_head.next = head;
			return new_head;
		}
		
		public static Node insert_at(Node head, int data, int position){
			Node cur = head;
			Node insert = new Node(data);
			if(position == 0){
				return head = insert_head(head, data);				
			}
			int i = 1;
			while(i < position){
				if(cur.next == null){
					throw new IllegalArgumentException("index out of bounds");
				}
				cur = cur.next;
				i++;
			}
			Node temp = cur.next;
			cur.next = insert;
			insert.next = temp;
			
			return head;
		}
		
		public static Node remove_position(Node head, int position){
			Node cur = head;
			if (position == 0){
				return head.next;
			}
			int i = 1;
			
			while( i< position){
				if(cur.next.next == null){
					throw new IllegalArgumentException("index out of bounds");
				}				
				i++;
				cur = cur.next;
				
			}
			cur.next = cur.next.next;
				
			return head;
		}
		
		
		
		public static Node remove_data(Node head, int data){
			Node cur = head;
			Node pre = head;
		
			while( cur != null){
				if(cur.data == data){
					pre.next = cur.next;
					//cur = null;
					return head;
				}
				pre = cur;
				cur = cur.next;
			}
				
			return head;
		}
		
		public static Node reverse(Node head){
			Node reverse = null;
			Node cur = head;
			
			while(cur != null){
				Node temp = cur;
				reverse = insert_head(reverse, cur.data);
				cur = cur.next;
			}
			return reverse;
		}
		
		public static boolean equals(Node head1, Node head2){
			Node temp1 = head1;
			Node temp2 = head2;
			while(temp1 != null && temp2 != null){
				if(temp1.data != temp2.data){
					return false;
				}				
				temp1 = temp1.next;			
			    temp2 = temp2.next;								
			}
			return (temp1 == null && temp2 == null);
		}
	

	//没写
    public static Node sort(Node head){
		return head;
	}
	
	//没写
	public static Node merge(Node n1, Node n2){
		Node sorted1 = sort(n1);
		Node sorted2 = sort(n2);
		return sorted1;
	}
		
		
	public static void main(String[] args){
		Node test = new Node(5);
		test.next = new Node(4);
		test.next.next = new Node(3);
		test = insert_tail(test, 2);
	    test = insert_head(test, 7);
		test = insert_at(test, 10 , 5);
		print(test);
		test = remove_position(test, 5);
		test = remove_data(test, 4);
		test = reverse(test);
		print(test);
		
		
				
	}
	

}