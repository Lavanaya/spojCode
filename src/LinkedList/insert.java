package LinkedList;

public class insert {
	public static Node root;
	
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void addNode(int data){
		 Node temp = new Node(data);
		 if(root == null)
			{
			 root=temp;
			 return;
			 }
		 
		 Node iterator = root;
		while(iterator.next!=null)
		{
		//	System.out.println(iterator.data);
			iterator = iterator.next;
		}
		iterator.next = temp;
	}
	
	public void deletNode(int data){
		Node current = root, prev=null;
		if(current==null)
			return;
		
		while(current.data != data){
			prev=current;
			current=current.next;
		}
		prev.next=current.next;
		
	}
	
	public void swapNodes(int data1,int data2){
		Node prev1=null, prev2=null, current1=root, current2=root;
		Node temp = root;
		if(root==null||data1==data2)
			return;
		
		while(temp != null && temp.data != data1){
			prev1=temp;
			current1=temp.next;
			temp=temp.next;
		}
		 temp=root;
		while(temp != null && temp.data != data2){
			prev2=temp;
			current2=temp.next;
			temp=temp.next;
		}
		
		if (current1 == null || current2 == null)
            return;
		if(prev1==null)
			root = current2;
		else
			prev1.next=current2;
		
		if(prev2 ==null)
			root = current1;
		else
			prev2.next=current1;
		
		Node temp2 = current1.next;
        current1.next = current2.next;
        current2.next = temp2;
		return;
		
	}
	public static void main(String args[]){
		root = null;
		insert ins=new insert();
		ins.addNode(5);
		ins.addNode(6);
		ins.addNode(7);
		ins.addNode(8);
		ins.deletNode(6);
		ins.addNode(9);
		ins.swapNodes(8, 5);
		Node temp=root;
		
	
		
		while(temp!=null)
		{
			System.out.println("data is : "+temp.data);
			temp=temp.next;
		}
		
	
	}

}
