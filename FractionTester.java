/**
 * Tests the Fraction class
 * @author lisayoo
 * @version 12.03.16
 */
public class FractionTester 
{
	public static void main(String[] args)
	{
		Fraction a = new Fraction(17, 51);
		Fraction b = new Fraction(64, 216);
		Fraction c = new Fraction(16, 18);
		Fraction d = new Fraction(4, 12);
		Fraction e = new Fraction(6, 6);
		
		System.out.println(a.reduce());
		System.out.println(e.reduce());
		System.out.println(a.compareTo(b));
		System.out.println(a.compareTo(c));
		System.out.println(a.compareTo(d));
		
		Fraction[] frac = new Fraction[3];
		for (int i = 0; i < 3; i++)
		{
			frac[i] = new Fraction((int) Math.random() * 100 + 1, (int) Math.random() * 100 + 1);
		}

		for (int j = 0; j < 3; j++)
		{
			frac[j] = (Fraction) frac[j].reduce();
		}
	}
}
