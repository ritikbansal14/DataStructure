import java.util.Scanner;

class Node
{
	int value;
	Node next;
}

public class LinkedList
{
	public static void main(String[] args) {
		// define size
		int size;
		/*make a head for linked list*/
		Node head = null;
		//taking size of array
		System.out.println("Enter Size Of Array ");
		Scanner sc = new Scanner(System.in);
		size= sc.nextInt();
		//making iterations 
		for(int i= 0;i<size;i++)
		{
			//new node to add at the end
			Node newnode = new Node();
			newnode.value= sc.nextInt();
			//if no head then create one 
			if (head==null) {
				head = newnode;
			}
			else
			{
				Node temp = head;
				while (temp.next!=null) {
					temp = temp.next;
				}
				temp.next = newnode;
			}
		}
		Node temp = head;
		System.out.println("Values");
		while(temp!=null)
		{
			System.out.println(temp.value);
			temp= temp.next;
		}
		sc.close();
	}
}