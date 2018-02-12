import java.util.Scanner;

public class CompGuesses 
{
	public static void main(String[] args)
	{
		int upperLim = 100;
		int lowerLim = 0;
		int mid = (upperLim + lowerLim) / 2;
		boolean correct = false;
		int count = 1;
		
		System.out.print("Think of a number from 1 to 100. ");
		System.out.println("I'm going to guess your number!");
		System.out.println("Type higher, lower, or yes");
		System.out.println("Is it 50?");
		Scanner sc = new Scanner(System.in);
		while (!correct)
		{
			String prompt = sc.next();
			if (prompt.equals("yes"))
			{
				System.out.println("Yay! I won the game!");
				System.out.println("Number of guesses: " + count);
				correct = true;
			}
			else if (prompt.equals("lower"))
			{
				upperLim = mid - 1;
				mid = (upperLim + lowerLim) / 2;
				System.out.println("Is it " + mid + "?");
				count++;
			}
			else if (prompt.equals("higher"))
			{
				lowerLim = mid + 1;
				mid = (upperLim + lowerLim) / 2;
				System.out.println("Is it " + mid + "?");
				count++;
			}
			else
			{
				System.out.println("Please type higher, lower, or yes");
			}
		}
		sc.close();
	}
}
