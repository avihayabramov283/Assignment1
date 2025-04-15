package Calculator_Logic.mono;

import Calculator_Logic.poly.Polynomial;
import Calculator_Logic.scalar.IntegerScalar;
import Calculator_Logic.scalar.Scalar;

import java.util.ArrayList;

public class Monomial {
    //fields
    private int exponent;
    private Scalar coefficient;

    //constructors
    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    //getters and setters
    public int getExponent() {
        return this.exponent;
    }

    public Scalar getCoefficient() {
        return this.coefficient;
    }

    //methods
    public Monomial add(Monomial monomial) {

        int otherExponent = monomial.getExponent();
        Scalar otherCoefficient = monomial.getCoefficient();

        if(otherExponent != this.exponent)
            return null;
        Monomial newMonomial = new Monomial(otherExponent, this.coefficient.add(otherCoefficient));
        return newMonomial;
    }

    public Monomial mul(Monomial monomial) {

        int otherExponent = monomial.getExponent();
        Scalar otherCoefficient = monomial.getCoefficient();

        Monomial newMonomial = new Monomial(otherExponent + this.getExponent(), this.coefficient.mul(otherCoefficient));
        return newMonomial;
    }

    public Scalar evaluate(Scalar scalar) {

        int functionExp = this.exponent;
        Scalar functionCoef = this.coefficient;

        scalar = scalar.power(functionExp);
        scalar = scalar.mul(functionCoef);

        return scalar;
    }

    public Monomial derivative() {
        int functionExp = this.exponent;
        Scalar functionCoef = this.coefficient;

        int derivativeExponent = functionExp - 1;
        IntegerScalar functionOriginalExpon = new IntegerScalar(functionExp);
        Scalar derivativeCoef = functionCoef.mul(functionOriginalExpon);

        Monomial derMono = new Monomial(derivativeExponent, derivativeCoef);
        return derMono;
    }

    public int sign()
    {
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Monomial))
            return false;

        if(this.coefficient.equals(((Monomial)obj).getCoefficient()) && this.exponent == ((Monomial)obj).getExponent())
            return true;

        return false;
    }

    public String toString() {
        IntegerScalar scalarOne = new IntegerScalar(1);
        IntegerScalar scalarNegOne = new IntegerScalar(-1);

        if(this.exponent == 0)
        {
            return this.coefficient.toString();
        }
        else if(this.exponent == 1 && this.coefficient.equals(scalarOne))
        {
            return "x";
        }
        else if(this.exponent == 1 && this.coefficient.equals(scalarNegOne))
        {
            return "-x";
        }
        else if(this.exponent == 1 )
        {
            return this.coefficient.toString() + "x";
        }
        else
        {
            return this.coefficient.toString() + "x^" + this.exponent;
        }
    }
}
