package Test;

import Calculator_Logic.poly.Polynomial;
import Calculator_Logic.scalar.IntegerScalar;
import Calculator_Logic.scalar.Scalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void testBuild() {
        Polynomial p = Polynomial.build("0 1 2 3");

        assertEquals("x+2x^2+3x^3", p.toString());
    }

    @Test
    void testAddPolynomials(){
        Polynomial p1 = Polynomial.build("0 1 2 3");
        Polynomial p2 = Polynomial.build("0 0 5 6");

        Polynomial p3 = p1.add(p2);
        assertEquals("x+7x^2+9x^3", p3.toString());
    }

    @Test
    void testMultiplyPolynomials(){
        Polynomial p1 = Polynomial.build("0 1 2 3");
        Polynomial p2 = Polynomial.build("0 0 5 6");

        Polynomial p3 = p1.mul(p2);
        assertEquals("5x^3+16x^4+27x^5+18x^6", p3.toString());
    }

    @Test
    void testEvaluatePolynomials(){
        Polynomial p1 = Polynomial.build("0 1 2 3");
        IntegerScalar s1 = new IntegerScalar(7);

        Scalar result = p1.evaluate(s1);
        assertEquals(new IntegerScalar(1134), (IntegerScalar)result);
    }

    @Test
    void testDerivePolynomial(){
        Polynomial p1 = Polynomial.build("0 1 2 3");
        Polynomial p2 = p1.derivative();

        assertEquals("1+4x+9x^2", p2.toString());
    }

    @Test
    void testEqualsPolynomials(){
        Polynomial p1 = Polynomial.build("0 1 2 3");
        Polynomial p2 = Polynomial.build("0 1 2 3");

        assertTrue(p1.equals(p2));
    }

    @Test
    void testToStringPolynomials(){
        Polynomial p = Polynomial.build("1 1 2 3");

        assertEquals("1+x+2x^2+3x^3", p.toString());
    }
}