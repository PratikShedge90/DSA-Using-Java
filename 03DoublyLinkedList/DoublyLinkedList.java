import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class DoublyLinkedList
{
	private Node first;
	private Node last;
	private int count;
	
    public DoublyLinkedList()
    {
    	this.first=null;
    	this.last=null;
    	this.count=0;
    }
    
    private static class Node
    {
    	private Node prev;
    	private int  data;
    	private Node next;

    	public Node(int data)        // public Node(Node prev, int data, Node next)
    	{                            // {
    		this.prev=null;          // }
    		this.data=data;          //    Node Z = new Node(S.prev, 99, T.next);
    		this.next=null;
    	} 	
    	
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
			T.prev = last;           // --> Added Line for prev node Linking
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
		StringJoiner sj = new StringJoiner(",","[","]"); // 1: Seperator(,), 2:Prefix( [ ), 3:Suffix(])
		
		for(Node T=first; T!=null; T=T.next)
		{
			sj.add(String.valueOf(T.data) );
		}
		return sj.toString();
	}
	
	public void reverseDisplay()
	{
		for(Node T=last; T!=null; T=T.prev)
		{
			System.out.print(T.data + "--> ");
		}
	}
 
	public void addFirst(int element)
	{
		if(first==null)
		{
			Node T = new Node(element);
			first=null;
			last=null;
			count++;
		}
		else
		{
			Node T = new Node(element);
			T.next = first;
			first.prev = T;
			first = first.prev;
			count++;	
		}
	}
	
	public void addLast(int element)
	{
		add(element);
	}
	
	private Node getNodeAt(int index)    // 0 , 1 , 2 , 3    count=4
	{                                    //11 , 22, 33, 44
		
		if(index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Index : " + index + ", Size: " + count);
		}
		else
		{
			Node T=first;
			
			for(int i=0; i<count; i++)
			{
				if(i == index)
				{
					return T;
				}
				T=T.next;
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
	
	// Now I want to Add My Data At Second Index
	
	public void add(int index , int element)
	{
		if(index < 0 || index > count)
		{
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + count);
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
			Node T = new Node(element);
			Node S = getNodeAt(index - 1); 
			
			T.next = S.next;
			S.next.prev = T;
			
			S.next = T;
			T.prev = S;	
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
		
		for(Node T = first; T!=null; T= T.next)
		{
			if(T.data == element) 
			{
				rindex = i;
			}
			i++;
		}
		return rindex;
	}
	
	public int remove()
	{
		if(first == null)
		{
			throw new NoSuchElementException("Linked List is Empty !!");
		}
		
		if(first==last)
		{
			int item = first.data;
			first=null;
			last=null;
			count--;
			return item;	
		}
		
		int item = first.data;
		Node T = first;
		first = first.next;
		first.prev= null;
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
		last = last.prev;
		last.next=null;
		count--;
		return item;
		
	}
	
	public int remove(int index)
	{
		if(first==null)
		{
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		if(index < 0 || index >= count)
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
			T.prev.next = T.next;
			T.next.prev = T.prev;
			
			T.next =null;
			T.prev =null;
			count --;
			return item;
		}		
		
	}
	
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
	
	public boolean removeAllOccurrence(int element)
	{
		boolean status=false;
		
		while(removeElement(element))
		{
			status = true;
		}
		return status;
	}	
	
}

