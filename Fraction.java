/**
 * Simulates a fraction with different methods
 * @author Lisa Yoo
 * @version 12.03.16
 */
public class Fraction implements Comparable<Fraction>
{
	private int numerator;
	private int denominator;
	
	/**
	 * Creates a fraction
	 * @param The numerator of the fraction
	 * @param The denominator of the fraction
	 */
	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Returns the inputed, unreduced fraction
	 * @return The inputed fraction
	 */
	public String getFrac()
	{
		return numerator + "/" + denominator;
	}
	
	/**
	 * Returns the inputed numerator of the fraction
	 * @return The inputed numerator of the fraction
	 */
	public int getNumerator()
	{
		return numerator;
	}
	
	/**
	 * Returns the inputed denominator of the fraction
	 * @return The inputed denominator of the fraction
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
	 * @return -1 if the fraction is smaller than frac
	 * @return 1 if the fraction is bigger than frac
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
}