package Calculator_Logic.scalar;

public class IntegerScalar implements Scalar {
    //fields
    private int number;

    //constructors
    public IntegerScalar(int number) {
        this.number = number;
    }

    //getters and setters


    //methods

    public Scalar add(Scalar other) {
        return null;
    }

    public Scalar mul(Scalar other) {
        return null;
    }

    public Scalar neg(){
        return new IntegerScalar(-this.number);
    }

    public Scalar power(int exponent) {
        return new IntegerScalar(this.number * exponent);
    }

    public int sign(){
        int result;
        if (this.number == 0) result = 0;
        else if (this.number > 0) result = 1;
        else result = -1;
        return result;
    }

    @Override
    public boolean equals(Object other){
        boolean result = false;
        if(other instanceof IntegerScalar){
            result = this.number == ((IntegerScalar)other).number;
        }
        return result;
    }

    @Override
    public String toString(){
        return "" + this.number;
    }

}
