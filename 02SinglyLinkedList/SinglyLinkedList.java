import java.util.StringJoiner;
import java.util.NoSuchElementException;

public class SinglyLinkedList
{
	private Node first;
	private Node last;
	private int count;
	
	private static class Node
	{
		private int data;
		private Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public SinglyLinkedList()
	{
		first = null;
		last  = null;
		count = 0;
	}
	
	public void add(int element)
	{
		if(first == null)
		{
			Node T = new Node(element);
			first = T;
			last = T;
			count++;
		}
		else
		{
			Node T = new Node(element);
			last.next = T;
			last = last.next;
			count++;
		}
	}
	
	public int size() 
	{
		return count;
	}
	
	public int length()
	{
		return count;
	}
		
	public void display()
	{
		for(Node T=first; T!=null; T=T.next)
		{
			System.out.print(T.data + " -> ");
		}
	}
	
	public String toString()
	{
		/*
		  
		Attempt 1 : Bad Attempt  -->
	    No. Of times you are creating object and immediately you are destroying it.
		
		String s = "[";
		
		for(Node T=first; T!=null; T=T.next)
		{
			s = s + T.data + ",";
		}
		s = s.substring(0,s.length()-1);
		s = s + "]";
	
		return s;

		*/
		
		StringJoiner sj = new StringJoiner(",","[","]"); //1: Seperator(,), 2:Prefix( [ ), 3:Suffix(])
		
		for(Node T=first; T!=null; T=T.next)
		{
			sj.add(String.valueOf(T.data) );
		}
		return sj.toString();
	}
	
	public void addFirst(int element)
	{
		if(first==null)            // LinkedList is empty & you are Trying to Add node for First time
		{
			Node T = new Node(element);
			first = T;
			last  = T;
			count++;
		}
		else                       // LinkedList is having atleast one node in it
		{
			Node T = new Node(element);
			T.next = first;
			first = T;
			count++;		
		}
	}
	
	public void addLast(int element)
	{
		add(element);
	}
	
	private Node getNodeAt(int index)  // Helper Function or utility function
	{                                 //  0  1  2
		if(index<0 || index>=count)   // 11 22 33 
		{
			throw new IndexOutOfBoundsException("Index : " + index + ", Size: " + count);
		}
		else
		{
			Node T = first;
			for(int i=0; i<count; i++)
			{
				if(i==index)
				{
					return T;
				}
				T = T.next;
			}
			return null;
		}
	}
		
	public int getElement(int index)
	{
		Node T = getNodeAt(index);
		return T.data;
	}
	
	public int setElement(int index, int element)
	{
		Node T = getNodeAt(index);	
		int item = T.data;
		T.data = element;
		return item;
	}
	
	/* Now I want to Add My Data At Second Index */
	public void add(int index, int element)
	{
		if(index < 0 || index > count)
		{
			throw new IndexOutOfBoundsException("Index :" + index + ", Size: " + count);
		}
		
		if(index==0)
		{
			addFirst(element);
		}
		else if(index==count)
		{
			addLast(element);
		}
		else
		{
			// now we Wants to add element in-between first and Last Node
			Node T = new Node(element);
			Node S = getNodeAt(index-1);   // 3-1 = 2  --> 11 22 33 (99) 44 55
			
			T.next = S.next;               // Link Joda ani mgg Toda
			S.next = T;
			count++;
		}
	}
	
	public int indexOf(int element)
	{
		int i=0;
		
		for(Node T=first; T!=null; T=T.next)
		{
			if(T.data == element)
			{
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public int lastIndexOf(int element)
	{
		int i=0;
		int rindex=-1;
		
		for(Node T=first; T!=null; T=T.next)
		{
			if(T.data == element)
			{
				 rindex = i;
			}
			i++;
		}
		return rindex;
	}
	
	/* This method Removes First Node of a List */
	
	public int remove()
	{
		if(first==null)
		{
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		
		if(first==last)
		{
			int item = first.data;
			first = null;
			last  = null;
			count = 0;
			return item;
		}
		
		int item = first.data;
		Node T = first;
		first = first.next;
		T.next = null;
		count--;
		return item;
		
	}
	
	public int removeFirst()
	{
		return remove();
	}
	
	public int removeLast()
	{
		if(first==null)
		{
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		
		if(first==last)
		{
			int item = last.data;
			first=null;
			last=null;
			count=0;
			return item;
		}
		
		int item = last.data;
		last = getNodeAt(count-2);
		last.next = null;
		count--;
		return item;
		
	}
	
	/* It removes node from given index */
	
	public int remove(int index) 
	{
		if(first==null)
		{
			throw new NoSuchElementException("List is Empty !!");
		}
		
		if(index<0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Index :" + index + ", Size: " + count);
		}
		
		if(index==0)
		{
			return removeFirst();
		}
		else if(index == count-1)
		{
			return removeLast();
		}
		else
		{
			Node T = getNodeAt(index);
			int item = T.data;
			
			Node S = getNodeAt(index-1);
			S.next = T.next;
			T.next = null;
			count--;
			return item;
			
		}
	}
	
	/*It will remove the First found element from list */
	
	public boolean removeElement(int element)
	{
		int index = indexOf(element);
		
		if(index==-1)
		{
			return false;
		}

		remove(index);
		return true;
	}
	
	public boolean removeFirstOccurrence(int element)
	{
		return removeElement(element);
	}
	
	public boolean removeLastOccurrence(int element)
	{
		int index = lastIndexOf(element);
		
		if(index==-1)
		{
			return false;
		}
		
		remove(index);
		return true;
	}
	
	public boolean removeAllOccurrences(int element)
	{
		boolean status=false;
		
		while(removeElement(element))
		{
			status = true;
		}
		return status;
	}
	
	/* Q.If i want to Search 2nd Occurrence of Given Element Not Add this Function in LL its UserDefied*/
	
	public int indexOf(int occurrence, int element)  // 11 22 33 44 22 55 22  --> I should return 4
	{
		if(occurrence < 1)
		{
			throw new NoSuchElementException("Occurrence is Empty !!");
		}
		if(first==null)
		{
			throw new NoSuchElementException("List is Empty !!");
		}
		
		int cnt=0;
		int i=0;
		
		for(Node T = first; T!=null; T=T.next)
		{
			if(T.data == element)
			{
				cnt++;
				if(cnt == occurrence)
				{
					return i;
				}
			}
			i++;
		}
		return -1;
	}
}
