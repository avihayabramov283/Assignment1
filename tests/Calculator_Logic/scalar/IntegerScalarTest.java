package Calculator_Logic.scalar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerScalarTest {
    IntegerScalar scalar1;
    IntegerScalar scalar2;
    IntegerScalar scalar3;

    @BeforeEach
    void setUp() {
        scalar1 = new IntegerScalar(5);
        scalar2 = new IntegerScalar(-2);
        scalar3 = new IntegerScalar(0);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNum() {
        assertEquals(5, scalar2.getNum());
        assertEquals(-2, scalar3.getNum());
        assertEquals(0, scalar3.getNum());

    }

    @Test
    void add() {
        assertEquals(3, scalar1.add(scalar2));
        assertEquals(2, scalar1.add(scalar3));
    }

    @Test
    void addInteger() {

    }

    @Test
    void addRational() {
    }

    @Test
    void mul() {
    }

    @Test
    void mulInteger() {
    }

    @Test
    void mulRational() {
    }

    @Test
    void neg() {
    }

    @Test
    void power() {
        assertEquals(new IntegerScalar(25), scalar1.power(2));
        assertEquals(new IntegerScalar(4), scalar1.power(2));

    }

    @Test
    void sign() {
        assertEquals(1, scalar1.sign());
        assertEquals(-1, scalar2.sign());
        assertEquals(0, scalar3.sign());
    }

    @Test
    void testEquals() {
        assertTrue(scalar1.equals(new IntegerScalar(5)));
        assertFalse(scalar1.equals(scalar3));
    }

    @Test
    void testToString() {
        assertEquals("5", scalar1.toString());
        assertEquals("-2", scalar2.toString());
    }
}