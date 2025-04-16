package Test;

import Calculator_Logic.mono.Monomial;
import Calculator_Logic.scalar.IntegerScalar;
import Calculator_Logic.scalar.Scalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    @Test
    void testAddSameExponent(){
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        IntegerScalar s1 = new IntegerScalar(13);
        Monomial m1 = new Monomial( 3, s1);

        Monomial m2 = m1.add(m);
        assertEquals(new IntegerScalar(20), m2.getCoefficient());
    }


    @Test
    void testMull() {
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        IntegerScalar s1 = new IntegerScalar(13);
        Monomial m1 = new Monomial( 7, s1);

        Monomial newMonomial = m1.mul(m);
        assertEquals(new IntegerScalar(91), newMonomial.getCoefficient());
    }

    @Test
    void testEvaluate(){
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        IntegerScalar s1 = new IntegerScalar(4);
        Scalar result = m.evaluate(s1);
        assertEquals(new IntegerScalar(448), ((IntegerScalar)result));
    }

    @Test
    void testDerivative(){
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        Monomial m1 = m.derivative();

        assertEquals(2, m1.getExponent());
        assertEquals(new IntegerScalar(21), m1.getCoefficient());
    }

    @Test
    void testSign() {
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        assertEquals(1, m.sign());
    }

    @Test
    void equalsMonomials(){
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        IntegerScalar s1 = new IntegerScalar(7);
        Monomial m1 = new Monomial( 3, s1);

        assertTrue(m.equals(m1));
    }

    @Test
    void testToString(){
        IntegerScalar s = new IntegerScalar(7);
        Monomial m = new Monomial( 3, s);

        assertEquals("7x^3", m.toString());
    }
}

