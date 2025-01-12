// ArrayNumberSequence.java

/****************************************************************
 * 
 * ArrayNumberSequence represents a sequence of real numbers.
 * Such a sequence is defined by the interface NumberSequence.
 * The class uses an array to store the numbers in the sequence.
 * 
 * Author
 * Fadil Galjic
 * 
 ****************************************************************/

public class ArrayNumberSequence implements NumberSequence {
	// numbers in the sequence
	private double[] numbers;

	// create the sequence
	public ArrayNumberSequence(double[] numbers) {
		if (numbers.length < 2)
			throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			this.numbers[i] = numbers[i];
			
	}

	// toString returns the character string representing this
	// sequence
	public String toString() {
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
			s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

	@Override
	public int length() {
		
	
	 return numbers.length;
}

	@Override
	public double upperBound() {
		double max = numbers[0];
		for(int i = 1; i< numbers.length; i++)
		 if(numbers[i] > max)
		  max = numbers[i];
		  
	 return max;
}

	@Override
	public double lowerBound() {
		double min = numbers[0];
		for(int i = 1; i< numbers.length; i++)
		 if(numbers[i] < min)
		  min = numbers[i];
	
	return min;
}

	@Override
	public double numberAt(int position) throws IndexOutOfBoundsException {
	  /*if(position < 0 || position > numbers.length-1)
	   throw new IndexOutOfBoundsException("Invalid postion");*/


	 return numbers[position];

	}

	@Override
	public int positionOf(double number) {
		for(int i = 0; i< numbers.length; i++)
		 if(numbers[i] == number)
		  return i;

	return -1;
	}

	@Override
	public boolean isIncreasing() {
		for(int i = 0; i< numbers.length -1; i++)
		 if(numbers[i + 1] <= numbers[i])
		  return false;
		
	return true;
	}

	@Override
	public boolean isDecreasing() {
		for(int i = 0; i< numbers.length -1; i++)
		 if(numbers[i + 1] >= numbers[i])
		  return false;

	return true;
	}

	@Override
	public boolean contains(double number) {
		for(int i = 0; i< numbers.length; i++)
		 if(numbers[i] == number)
		  return true;

	return false;
	}

	@Override
	public void add(double number) {
		double [] newNum = new double[numbers.length + 1];
		 for(int i = 0; i <numbers.length; i++)
		  newNum[i] = numbers[i];
		newNum[newNum.length - 1] = number;
		numbers = newNum;
	}

	@Override
	public void insert(int position, double number) {
		if(position < 0 || position > numbers.length)
		 throw new IndexOutOfBoundsException("Invalid position");
		
	     double [] newNum = new double[numbers.length + 1];
		 
		for(int i = 0; i< position; i++)
		 newNum[i] = numbers[i];

		for(int i = position; i <numbers.length; i++)
		 newNum[i + 1] = numbers[i];
		
		newNum[position] = number;

		numbers = newNum;
		
		
	}

	@Override
	public void removeAt(int position) throws IndexOutOfBoundsException {
		if(numbers.length <= 2)
		throw new IllegalStateException("Not a sequence");

		if(position < 0 || position >= numbers.length)
		 throw new IndexOutOfBoundsException("Invalid position");

		double [] newNum = new double[numbers.length - 1];
		
		for(int i = 0; i <position; i++)
		 newNum[i] = numbers[i];

		for(int i = position; i <newNum.length; i++)
		 newNum[i] = numbers[i + 1];

		numbers = newNum;
	}

	@Override
	public double[] asArray() {
		return numbers.clone();
		

	}

}