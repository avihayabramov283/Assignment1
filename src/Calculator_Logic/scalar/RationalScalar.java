package Calculator_Logic.scalar;
import java.lang.Math;


public class RationalScalar implements Scalar {
    //fields
    private int numerator;
    private int denominator;

    //constructors
    public RationalScalar(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //getters and setters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    //methods

    public Scalar add(Scalar other) {
        return other.addRational(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar other) {
        return new RationalScalar(
                this.numerator + other.getNum() * this.denominator,
                this.denominator).reduce();
    }

    @Override
    public Scalar addRational(RationalScalar other) {
        int newNumerator = this.denominator * other.numerator + other.denominator * this.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalScalar(newNumerator, newDenominator).reduce();
    }

    public Scalar mul(Scalar other) {
        return other.mulRational(this);
    }

    @Override
    public Scalar mulInteger(IntegerScalar other) {
        return new RationalScalar(this.numerator * other.getNum(), this.denominator).reduce();
    }

    @Override
    public Scalar mulRational(RationalScalar other) {
        return new RationalScalar(this.numerator * other.numerator, this.denominator * other.denominator).reduce();
    }

    public Scalar neg(){
        return new RationalScalar(-this.numerator, this.denominator);
    }

    public Scalar power(int exponent) {
        int newNum = (int)Math.pow(this.numerator, exponent);
        int newDen = (int)Math.pow(this.denominator, exponent);
        return new RationalScalar(newNum, newDen).reduce();
    }

    public int sign(){
        int result;
        if(this.numerator > 0 && this.denominator > 0){ result = 1; }
        else if((this.numerator < 0 && this.denominator > 0) ||
                (this.numerator > 0 && this.denominator < 0) ){ result = -1; }
        else { result = 0; }
        return result;
    }

    public RationalScalar reduce(){
        if (numerator == 0) {
            return new RationalScalar(0, 1); 
        }

        int gcd = Math.abs(gcd(numerator, denominator));
        int reducedNumerator = numerator / gcd;
        int reducedDenominator = denominator / gcd;

        if (reducedDenominator < 0) {
            reducedNumerator = -reducedNumerator;
            reducedDenominator = -reducedDenominator;
        }
        return new RationalScalar(reducedNumerator, reducedDenominator); 
    }

    private int gcd(int numerator, int denominator) {
        return numerator;
    }

    @Override
    public boolean equals(Object other){
        boolean result = false;
        if(other instanceof RationalScalar){
            if(this.numerator == ((RationalScalar)other).numerator &&
            this.denominator == ((RationalScalar)other).denominator) {result = true; }
        }
        return result;
    }

    @Override
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

}
