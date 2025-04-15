package Calculator_Logic.scalar;

public interface Scalar {
    Scalar add(Scalar other);
    Scalar addInteger(IntegerScalar other);
    Scalar addRational(RationalScalar other);
    Scalar mul(Scalar other);
    Scalar mulInteger(IntegerScalar other);
    Scalar mulRational(RationalScalar other);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    @Override
    boolean equals(Object other);
}
