// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // length returns the number of numbers in this sequence.
    public int length () {
		int size = 1;
		Node n = first;
		while(n.next != null){
		 n = n.next;
		 size++;
		}
		 
		
		return size;


	}

    // upperBound returns an upper bound for this sequence.
    public double upperBound () {
		Node n = first;
		double max = n.number;
		while(n.next != null){
			n = n.next;
		 if( n.number > max)
		  max = n.number;
		}
		

		return max;

	}

    // lowerBound returns a lower bound for this sequence.
    public double lowerBound () {
		Node n = first;
		double min = n.number;
		while(n.next != null) {
			n = n.next;
		 if( n.number < min)
		  min = n.number;
		}
		

		return min;
	}

    // numberAt returns the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    public double numberAt (int position) throws IndexOutOfBoundsException {
		if(position >= length() || position < 0)
		 throw new IndexOutOfBoundsException();
		
		 Node n = first;
		for(int i = 0; i< position; i++)
		 n = n.next;

		 return n.number;
			 
		}
	

    // positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
    public int positionOf (double number) {
		Node n = first;
		for(int i = 0; i< length(); i++, n = n.next){
			if(number == n.number)
			 return i;
		}
		return -1;

	}

    // isIncreasing returns true if this sequence is increasing,
    // else false is returned.
    public boolean isIncreasing () {
		
		for(Node n =  first; n.next != null; n = n.next){
			if(n.next.number <= n.number)
			 return false;
			
			 
		}
		return true;
	}
		 
	

    // isDecreasing returns true if this sequence is decreasing,
    // else false is returned.
    public boolean isDecreasing () {

		for(Node n =  first; n.next != null; n = n.next){
			if(n.next.number >= n.number)
			 return false;
			
			 
		}
		return true;
	}

    // contains returns true if this sequence contains the
    // specified number, else false is returned.
    public boolean contains (double number) {
		Node n = first;
		
		while(n != null){
		 if( number == n.number)
		  return true;
		  n = n.next;
		}
		return false;
	}

    // add adds the specified number to the end of this sequence.
    public void add (double number) {
		Node n = first;
		
		while( n.next != null)
		 n = n.next;
		
		n.next = new Node(number);
	}

    // insert inserts the given number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    public void insert (int position, double number){
		if(position >= length() || position < 0)
		 throw new IndexOutOfBoundsException();
		
		 if(position == 0){
		 Node newNum = new Node(number);
		 newNum.next = first;
		 first = newNum;
		}
		
		else{
		 Node n = first;
		
		for(int i = 0; i <position -1; i++)
		 n = n.next;
		
		 
		 Node newNum = new Node(number);
		 newNum.next = n.next;
		 n.next = newNum;
		 
		 }
	}
		
	


    // removeAt removes the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    // The method throws IllegalStateException if there are
    // just two numbers in the sequence.
    public void removeAt (int position) throws IndexOutOfBoundsException {
		if(position >= length() || position < 0)
		 throw new IndexOutOfBoundsException();

		 if(position == 0){
			first = first.next;

		 }
		 
		else {
		Node n = first;
		
		for(int i = 0; i <position -1; i++)
		 n = n.next;
		 
		 n.next = n.next.next;
		
		while(n != null)
		 n = n.next;
	}
}

    // asArray returns an array containing all of the numbers in
    // this sequence, in the same order as in the sequence.
    public double[] asArray () {
		Node n = first;
		double [] newNumbers = new double[length()];

		for(int i = 0; i < newNumbers.length; i++, n = n.next)
		 newNumbers[i] = n.number;

		return newNumbers;
	}
}