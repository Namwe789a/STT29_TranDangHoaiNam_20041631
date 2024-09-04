package tuan3_Rational;

public class Rational {
	 private int numerator;
	 private int denominator;
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		if (denominator == 0) {
	        throw new IllegalArgumentException("Denominator cannot be zero.");
	    }else {
	    	this.numerator = numerator;
	    }
	
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public Rational(int numerator, int denominator) {
		if (denominator == 0) {
	        throw new IllegalArgumentException("Denominator cannot be zero.");
	    }
		this.numerator = numerator;
		this.denominator = denominator;
	}
	 
	 
}
