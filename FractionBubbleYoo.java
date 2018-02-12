import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class FractionBubbleYoo 
{
	public static final int SIZE = 20; 
	private static ArrayList<Fraction> values = new ArrayList<Fraction>();
	
	private static void initValues()
    // Initializes the values ArrayList with random Fractions 
	// The numerator and denominator values range from 0 to 99
    {
        Random rand = new Random(560);
        int i = 0;
        while (i < SIZE)
        {
        	values.add(new Fraction(Math.abs(rand.nextInt()) % 100, Math.abs(rand.nextInt()) % 100));
        	i++;
        }
    }
	
	public static boolean isSorted()
    // Determine whether the ArrayLst is sorted
    {
        boolean sorted = true;
        for (int i = 0; i < SIZE - 1; i++)
            if (values.get(i).compareTo(values.get(i + 1)) > 0)
                sorted = false;
        return sorted;   
    }
	
	public static void swap(int index1, int index2)
    // Swaps the Fractions at locations index1 and index2 of ArrayList values
    // Precondition:  index1 and index2 are less than size
    {
		Fraction temp = new Fraction(values.get(index1).getNumerator(), values.get(index1).getDenominator());
        values.set(index1, values.get(index2));
        values.set(index2, temp);
    }
	
	public static void printValues()
    // Prints all the elements in values
    {
        System.out.println("the values ArrayList is:");
        for (int index = 0; index < SIZE; index++)
        {
           System.out.print(values.get(index).toString() + " ");
        }
        System.out.println();
    }
	
	/**
	 * Sorts values using the bubble sorting technique
	 */
	public static void bubbleSort()
	{
		int current = 0;
		while (current < SIZE)
		{
			bubbleUp(current);
			current++;
		}
	}
	
	/**
	 * Performs a single run of bubbling up
	 * @param current The index of the last element in the unsorted part of values
	 */
	public static void bubbleUp(int current)
	{
		int index = SIZE - 1;
		while (index >= current && current != 0)
		{
			if (values.get(index).compareTo(values.get(index - 1)) < 0)
			{
				swap(index, index - 1);
			}
			index--;
		}
	}
	
	/**
	 * Simulates a fraction with different methods
	 * @author Lisa Yoo
	 * @version 12.03.16
	 */
	private static class Fraction implements Comparable<Fraction>
	{
		private int numerator;
		private int denominator;
		
		/**
		 * Creates a fraction given numerator and denominator
		 * @param The numerator of the fraction
		 * @param The denominator of the fraction
		 */
		public Fraction(int numerator, int denominator)
		{
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		/**
		 * Returns the inputted numerator of the fraction
		 * @return The inputted numerator of the fraction
		 */
		public int getNumerator()
		{
			return numerator;
		}
		
		/**
		 * Returns the inputted denominator of the fraction
		 * @return The inputted denominator of the fraction
		 */
		public int getDenominator()
		{
			return denominator;
		}
		
		/**
		 * Reduces and returns the given fraction to simplest terms
		 * @return The given fraction in simplest terms
		 */
		public String reduce()
		{
			int dividend = numerator;
			int divisor = denominator;
			int rem = dividend % divisor;
			int oldRem = 0;
			
			if (numerator == denominator)
			{
				return "1";
			}
			else
			{
				while (rem != 0)
				{
					dividend = divisor;
					divisor = rem;
					oldRem = rem;
					rem = dividend % divisor;
				}
			
				numerator /= oldRem;
				denominator /= oldRem;
				
				return numerator + "/" + denominator;
			}
		}
		
		/**
		 * Compares a fraction to another
		 * @param otherFrac the fraction to compare to
		 * @return -1 if the fraction is smaller than otherFrac
		 * @return 1 if the fraction is bigger than otherFrac
		 * @return 0 if the fractions are equal
		 */
		public int compareTo(Fraction otherFrac)
		{
			double fracVal = (double) numerator / denominator;
			double otherFracVal = (double) otherFrac.numerator / otherFrac.denominator;
			if (fracVal < otherFracVal)
			{
				return -1;
			}
			else if (fracVal > otherFracVal)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		/**
		 * Returns a string of the fraction
		 * @return A string of the fraction
		 */
		public String toString()
		{
			return getNumerator() + "/" + getDenominator();
		}
	}
	
	 public static void main(String[] args) throws IOException
	    // Tests the other methods of the FractionBubbleYoo class
	    {
	        initValues();
	        printValues();
	        System.out.println("values is sorted: " + isSorted());
	        System.out.println();
	        
	        System.out.println("bubbleSort method:");
	        bubbleSort();
	        printValues();
	        System.out.println("values is sorted: " + isSorted());
	        System.out.println();
	    }
}