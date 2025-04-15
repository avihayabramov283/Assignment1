package Calculator_Logic.scalar;

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


    //methods

    public Scalar add(Scalar other) {
        return other.addRational(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar other) {
        return new RationalScalar(
                this.numerator + other.getNum() * this.denominator,
                this.denominator
        ).reduce();
    }

    @Override
    public Scalar addRational(RationalScalar other) {
        return null;
    }

    public Scalar mul(Scalar other) {
        return null;
    }


    public Scalar neg(){
        return null;
    }

    public Scalar power(int exponent) {
        return null;
    }

    public int sign(){
        return 0;
    }

    public RationalScalar reduce(){
        return null;
    }

    @Override
    public boolean equals(Object other){
        return false;
    }

    @Override
    public String toString(){
        return "RationalScalar";
    }

}
