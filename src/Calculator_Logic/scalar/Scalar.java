package Calculator_Logic.scalar;

public interface Scalar {
    Scalar add(Scalar other);
    Scalar mul(Scalar other);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    @Override
    boolean equals(Object other);
}
