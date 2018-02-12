import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
    public static final int SIZE = 200;          // Size of array to be sorted
    private static int[] values = new int[SIZE];  // Values to be sorted
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        Random rand = new Random(560);
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
    }
    
    public static boolean isSorted()
    // Determine whether the array values are sorted
    {
        boolean sorted = true;
        for (int i = 0; i < values.length - 1; i++)
            if (values[i] > values[i + 1])
                sorted = false;
        return sorted;   
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    
    public static void printValues()
    // Prints all the values integers
    {
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("the values array is:");
        for (int index = 0; index < SIZE; index++)
        {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    /**
     * Returns the index of the minimum value in the array
     * @param startIndex The starting index in the array
     * @param endIndex The ending index in the array
     * @return The index of the minimum value in the array
     */
    public static int minIndex(int startIndex, int endIndex)
    {
    	int minIndex = 0;
    	for (int i = 0; i < endIndex; i++)
    	{
    		if (values[i] < values[i + 1])
    		{
    			minIndex = i;
    		}
    	}
    	return minIndex;
    }
    
    /**
     * Sorts the array according to Selection Sort
     */
    public static void selectionSort()
    {
    	int current = 0;
    	while (current < values.length)
    	{
    		swap(current, minIndex(0, SIZE - 1));
    		current++;
    	}
    }
    
    /**
     * Inserts an item where it should be in chronological order
     * @param startIndex The starting index
     * @param endIndex The ending index
     */
    public static void insertItem(int startIndex, int endIndex)
    {
    	boolean finished = false;
    	int current = endIndex;
    	boolean moreToSearch = true;
    	
    	while (moreToSearch && !finished)
    	{
    		if (values[current] < values[current - 1] && current != 0)
    		{
    			swap(current, current - 1);
    			current--;
    			moreToSearch = (current != startIndex);
    		}
    		
    		else
    		{
    			finished = true;
    		}
    	}
    }
    
    /**
     * Sorts the array using Insertion Sort
     */
    public static void insertionSort()
    {
    	for (int count = 1; count <= SIZE - 1; count++)
    	{
    		insertItem(0, count);
    	}
    }
    
    public static void mergeSort(int start, int end)
    {
    	int middle = (start + end) / 2;
    	if (start < end)
    	{
    		mergeSort(start, middle);
    		mergeSort(middle + 1, end);
    		merge(start, middle, middle + 1, end);
    	}
    }
    
    public static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
    {
    	int saveFirst = leftFirst;
    	int index = leftFirst;
    	int[] tempArray = new int[SIZE];
    	while (leftFirst <= leftLast && rightFirst <= rightLast)
    	{
    		if (values[leftFirst] < values[rightFirst])
    		{
    			tempArray[index] = values[leftFirst];
    			leftFirst++;
    		}
    		else
    		{
    			tempArray[index] = values[rightFirst];
    			rightFirst++;
    		}
    		index++;
    	}
    	for (int i = leftFirst; i <= leftLast; i++)
    	{
    		tempArray[index] = values[i];
    		index++;
    	}
    	for (int j = rightFirst; j <= rightLast; j++)
    	{
    		tempArray[index] = values[j];
    		index++;
    	}
    	for (int k = saveFirst; k <= rightLast; k++)
    	{
    		values[k] = tempArray[k];
    	}
    }
    
    /**
     * Sorts the array using Quick Sort
     * @param from The starting index of the array
     * @param to The ending index of the array
     */
    public static void quickSort(int from, int to)
    {
    	if (from < to)
    	{
    		int p = split(from, to);
    		quickSort(from, p - 1);
    		quickSort(p + 1, to);
    	}
    }
    
    /**
     * Splits and sorts the array 
     * @param from The starting index of the array
     * @param to The ending index of the array
     * @return last The index at which the array is split
     */
    public static int split(int from, int to)
    {
    	int pivot = values[from];
    	int first = from;
    	int last = to;
    	
    	while (first < last)
    	{
    		first++;
    		while (first < SIZE && values[first] < pivot)
    		{
    			first++;
    		}
    		while (values[last] > pivot)
    		{
    			last--;
    		}
    		if (first < last)
    		{
    			swap(first, last);
    		}
    	}
    	swap(from, last);
    	return last;
    }
    
    /**
     * Sorts the array using Cocktail Sort technique
     */
    public static void cocktailSort()
    {
    	boolean swapped = true;
    	int i = 0;
    	int current = values.length - 1;
   		while(i < current && swapped)
   		{
   			for(int k = i; k < current; k++)
   			{
   				if(values[k] > values[k+1])
   				{
   					int temp = values[k];
   					swap(k, k+1);
   					values[k+1] = temp;
   					swapped = true;
   				}
   			}
   			current--;
   			if(swapped)
   			{
   				swapped = false;
   				for(int k = current; k > i; k--)
   				{
   					if(values[k] < values[k - 1])
   					{
   						int temp = values[k];
   						swap(k, k-1);
   						values[k-1] = temp;
   						swapped = true;
   					}
   				}
   		
   			}
   		}
   		i++;
    }
    
    public static void main(String[] args) throws IOException
	// Tests the other methods of the Sorts class
	{
    	initValues();
//    	printValues();
//    	System.out.println("values is sorted: " + isSorted());
//    	System.out.println();
    	long total = 0;
    	for(int i = 1; i<= 30; i++)
    	{
    		long startTime = System.nanoTime();
    		quickSort(0, SIZE - 1);
    		long endTime = System.nanoTime();
    		long duration = (endTime - startTime);
    		total += duration;
    	}
    	System.out.println(total / 30);
	}
}