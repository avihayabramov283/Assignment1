package Test;

import Calculator_Logic.scalar.IntegerScalar;
import Calculator_Logic.scalar.RationalScalar;
import Calculator_Logic.scalar.Scalar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RationalScalarTest {

    @Test
    void getNumerator() {
        RationalScalar r = new RationalScalar(5, 7);
        assertEquals(5, r.getNumerator());
    }

    @Test
    void getDenominator() {
        RationalScalar r = new RationalScalar(5, 7);
        assertEquals(7, r.getDenominator());
    }

    @Test
    void constructorStoresValuesCorrectly() {
        RationalScalar r = new RationalScalar(3, 4);
        assertEquals(3, r.getNumerator());
        assertEquals(4, r.getDenominator());
    }

    @Test
    void constructorThrowsWhenDenominatorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RationalScalar(5, 0);
        });
    }



    @Test
    void add() {
        RationalScalar r1 = new RationalScalar(1, 2);
        IntegerScalar i1 = new IntegerScalar(2);
        Scalar result = r1.add(i1);
        assertEquals(new RationalScalar(5, 2), result);
    }

    @Test
    void addInteger() {
        RationalScalar r = new RationalScalar(1, 2);
        IntegerScalar i = new IntegerScalar(2);
        Scalar result = r.addInteger(i);
        assertEquals(new RationalScalar(5, 2), result);
    }

    @Test
    void addRational() {
        RationalScalar r1 = new RationalScalar(1, 3);
        RationalScalar r2 = new RationalScalar(1, 6);
        Scalar result = r1.addRational(r2);
        assertEquals(new RationalScalar(1, 2), result);
    }

    @Test
    void mul() {
        RationalScalar r1 = new RationalScalar(2, 3);
        IntegerScalar i1 = new IntegerScalar(4);
        Scalar result = r1.mul(i1);
        assertEquals(new RationalScalar(8, 3), result);
    }

    @Test
    void mulInteger() {
        RationalScalar r = new RationalScalar(2, 5);
        IntegerScalar i = new IntegerScalar(3);
        Scalar result = r.mulInteger(i);
        assertEquals(new RationalScalar(6, 5), result);
    }

    @Test
    void mulRational() {
        RationalScalar r1 = new RationalScalar(2, 3);
        RationalScalar r2 = new RationalScalar(3, 4);
        Scalar result = r1.mulRational(r2);
        assertEquals(new RationalScalar(1, 2), result);
    }

    @Test
    void neg() {
        RationalScalar r = new RationalScalar(2, 3);
        Scalar neg = r.neg();
        assertEquals(new RationalScalar(-2, 3), neg);
    }

    @Test
    void power() {
        RationalScalar r1 = new RationalScalar(2, 3);
        Scalar result1 = r1.power(2);
        assertEquals(new RationalScalar(4, 9), result1);

        RationalScalar r2 = new RationalScalar(5, 7);
        Scalar result2 = r2.power(0);
        assertEquals(new RationalScalar(1, 1), result2);
    }

    @Test
    void sign() {
        assertEquals(1, new RationalScalar(3, 5).sign());
        assertEquals(-1, new RationalScalar(-3, 5).sign());
        assertEquals(-1, new RationalScalar(3, -5).sign());
        assertEquals(0, new RationalScalar(0, 5).sign());
    }

    @Test
    void reduce() {
        RationalScalar r = new RationalScalar(6, 8);
        RationalScalar reduced = r.reduce();
        assertEquals(new RationalScalar(3, 4), reduced);
    }

    @Test
    void testEquals() {
        RationalScalar r1 = new RationalScalar(2, 4);
        RationalScalar r2 = new RationalScalar(1, 2);
        RationalScalar r3 = new RationalScalar(3, 4);
        assertEquals(r1.reduce(), r2.reduce());
        assertNotEquals(r1, r3);
        assertNotEquals(r1, null);
        assertNotEquals(r1, "string");
    }

    @Test
    void testToString() {
        RationalScalar r = new RationalScalar(2, 3);
        assertEquals("2/3", r.toString());
    }
}
