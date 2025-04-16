package Calculator_Logic.scalar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerScalarTest {

    @Test
    void getNum() {
        IntegerScalar zero = new IntegerScalar(0);
        IntegerScalar positive = new IntegerScalar(2);
        IntegerScalar negative = new IntegerScalar(-7);

        assertEquals(0, zero.getNum());
        assertEquals(2, positive.getNum());
        assertEquals(-7, negative.getNum());
    }

    @Test
    void add() {
        IntegerScalar a = new IntegerScalar(0);
        IntegerScalar b = new IntegerScalar(2);
        Scalar result = a.add(b);
        assertEquals(new IntegerScalar(2), result);
    }

    @Test
    void addInteger() {
        IntegerScalar a = new IntegerScalar(0);
        IntegerScalar b = new IntegerScalar(-2);
        Scalar result = a.addInteger(b);
        assertEquals(new IntegerScalar(-2), result);
    }

    @Test
    void addRational() {
        IntegerScalar a = new IntegerScalar(-2);
        RationalScalar b = new RationalScalar(5, 2);
        Scalar result = a.addRational(b);
        assertEquals(new RationalScalar(1, 2), result);
    }

    @Test
    void mul() {
        IntegerScalar a = new IntegerScalar(3);
        IntegerScalar b = new IntegerScalar(4);
        Scalar result = a.mul(b);
        assertEquals(new IntegerScalar(12), result);
    }

    @Test
    void mulInteger() {
        IntegerScalar a = new IntegerScalar(-2);
        IntegerScalar b = new IntegerScalar(3);
        Scalar result = a.mulInteger(b);
        assertEquals(new IntegerScalar(-6), result);
    }

    @Test
    void mulRational() {
        IntegerScalar a = new IntegerScalar(3);
        RationalScalar b = new RationalScalar(1, 2);
        Scalar result = a.mulRational(b);
        assertEquals(new RationalScalar(3, 2), result);
    }

    @Test
    void neg() {
        IntegerScalar a = new IntegerScalar(5);
        Scalar negA = a.neg();
        assertEquals(new IntegerScalar(-5), negA);

        IntegerScalar b = new IntegerScalar(-8);
        Scalar negB = b.neg();
        assertEquals(new IntegerScalar(8), negB);
    }

    @Test
    void power() {
        IntegerScalar base1 = new IntegerScalar(2);
        Scalar result1 = base1.power(3);
        assertEquals(new IntegerScalar(8), result1);

        IntegerScalar base2 = new IntegerScalar(5);
        Scalar result2 = base2.power(0);
        assertEquals(new IntegerScalar(1), result2);

        IntegerScalar base3 = new IntegerScalar(-2);
        Scalar result3 = base3.power(2);
        assertEquals(new IntegerScalar(4), result3);
    }

    @Test
    void sign() {
        IntegerScalar zero = new IntegerScalar(0);
        IntegerScalar positive = new IntegerScalar(3);
        IntegerScalar negative = new IntegerScalar(-9);

        assertEquals(0, zero.sign());
        assertEquals(1, positive.sign());
        assertEquals(-1, negative.sign());
    }

    @Test
    void testEquals() {
        IntegerScalar a = new IntegerScalar(4);
        IntegerScalar b = new IntegerScalar(4);
        IntegerScalar c = new IntegerScalar(5);

        assertEquals(a, b);
        assertNotEquals(a, c);
        assertNotEquals(a, null);
        assertNotEquals(a, "string");
    }

    @Test
    void testToString() {
        IntegerScalar a = new IntegerScalar(7);
        assertEquals("7", a.toString());

        IntegerScalar b = new IntegerScalar(-2);
        assertEquals("-2", b.toString());
    }
}
