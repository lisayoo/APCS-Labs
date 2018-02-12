import java.util.Scanner;

public class GuessingGame 
{
	public static void main(String[] args)
	{
		int number = (int) (Math.random() * 100) + 1;
		boolean correct = false;
		
		System.out.println("What's my number?");
		System.out.println("Guess a number from 1 to 100.");
		Scanner sc = new Scanner(System.in);
		while (!correct)
		{
			int userGuess = Integer.parseInt(sc.next());
			if (userGuess == number)
				System.out.println("You guessed my number!");
				correct = false;
			if (userGuess < number)
				System.out.println("higher");
			if (userGuess > number)
				System.out.println("lower");
		}
		sc.close();
	}
}
