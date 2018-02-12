import java.util.Scanner;

public class UserGuesses 
{
	public static void main(String[] args)
	{
		int number = (int) (Math.random() * 100) + 1;
		boolean correct = false;
		int count = 1;
		
		System.out.println("What's my number?");
		System.out.println("Guess a number from 1 to 100.");
		Scanner sc = new Scanner(System.in);
		while (!correct)
		{
			int userGuess = Integer.parseInt(sc.next());
			if (userGuess == number)
			{
				System.out.println("You guessed my number!");
				System.out.println("Number of guesses: " + count);
				correct = false;
			}
			if (userGuess < number)
			{
				System.out.println("higher");
				count++;
			}
			if (userGuess > number)
			{
				System.out.println("lower");
				count++;
			}
		}
		sc.close();
	}
}
