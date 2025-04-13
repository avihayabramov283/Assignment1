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
        return null;
    }

    public Scalar power(int exponent) {
        return null;
    }

    public int sign(){
        return 0;
    }

    @Override
    public boolean equals(Object other){
        return false;
    }

}
