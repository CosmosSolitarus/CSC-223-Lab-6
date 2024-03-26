package geometry_objects.points;

import static org.junit.Assert.*;

import org.junit.Test;

import utilities.math.MathUtilities;

public class PointTest {
    @Test
    void getXTest() {
        Point pt0 = new Point(3, 12.12);
        assertTrue(MathUtilities.doubleEquals(3, pt0.getX()));

        Point pt1 = new Point("Josh", 3.12234234, -9.1111);
        assertTrue(MathUtilities.doubleEquals(3.12234, pt1.getX()));

        assertFalse(MathUtilities.doubleEquals(4, pt1.getX()));
    }

    @Test
    void getYTest() {
        Point pt0 = new Point(3, 12.12);
        assertTrue(MathUtilities.doubleEquals(12.12, pt0.getY()));

        Point pt1 = new Point("Josh", 3.12234234, -9.1111);
        assertTrue(MathUtilities.doubleEquals(-9.1111, pt1.getY()));

        assertFalse(MathUtilities.doubleEquals(4, pt1.getY()));
    }

    @Test
    void getNameTest() {
        Point pt0 = new Point(3, 12.12);
        assertEquals("__UNNAMED", pt0.getName());

        Point pt1 = new Point("Josh", 3.12234234, -9.1111);
        assertEquals("Josh", pt1.getName());

        assertNotEquals("NotJosh", pt1.getName());
    }

    @Test
    void isUnnamedTest() {
        Point pt0 = new Point(3, 12.12);
        assertTrue(pt0.isUnnamed());

        Point pt1 = new Point("Josh", 3.12234234, -9.1111);
        assertFalse(pt1.isUnnamed());
    }

    @Test
    void hashCodeTest() {
        Point pt0 = new Point(3, 12.12);
        Point pt1 = new Point("Josh", 3, 12.12);
        Point pt2 = new Point("Tyler", 2, -4);

        assertEquals(pt0.hashCode(), pt1.hashCode());

        assertNotEquals(pt0.hashCode(), pt2.hashCode());
    }

    @Test
    void LexicographicOrderingTest() {
        Point pt0 = new Point(3, 12.12);
        Point pt1 = new Point("Josh", 3, 12.12);
        Point pt2 = new Point("Tyler", 2, -4);
        Point pt3 = new Point(5.2, 2);
        Point pt4 = new Point(5.2, 1);
        Point pt5 = new Point(5.2, 3);
        Point pt6 = null;

        assertEquals(0, Point.LexicographicOrdering(pt0, pt0));
        assertEquals(0, Point.LexicographicOrdering(pt0, pt1));
        assertEquals(1, Point.LexicographicOrdering(pt0, pt2));
        assertEquals(1, Point.LexicographicOrdering(pt1, pt2));
        assertEquals(-1, Point.LexicographicOrdering(pt2, pt1));
        assertEquals(-1, Point.LexicographicOrdering(pt0, pt3));
        assertEquals(1, Point.LexicographicOrdering(pt3, pt4));
        assertEquals(-1, Point.LexicographicOrdering(pt3, pt5));
        assertEquals(1, Point.LexicographicOrdering(pt0, pt6));
        assertEquals(-1, Point.LexicographicOrdering(pt6, pt0));
        assertEquals(0, Point.LexicographicOrdering(pt6, pt6));
    }

    @Test
    void equalsTest() {
		// NAMING SCHEME
		// u = unnamed
		// n = named
		// z = integer
		// q = decimal
		// Q = decimal (shortened)
		// r = irrational
		
		// unnamed Point with integers only
		Point uzz = new Point(12, -2);
		assertEquals(new Point(12, -2), uzz);
		
		// unnamed Point with integer and decimal
		Point uzq = new Point(0, -7.7);
		assertEquals(new Point(0, -7.7), uzq);
		
		// unnamed Point with integer and long decimal
		Point uzQ = new Point(-4, 0.1234567);
		assertEquals(new Point(-4, 0.12345), uzQ);
		
		// unnamed Point with integer and irrational
		Point uzr = new Point(9, Math.sqrt(3));
		assertEquals(new Point(9, 1.73205), uzr);
		
		// unnamed Point with decimals only
		Point uqq = new Point(-8.47, 0.001);
		assertEquals(new Point(-8.47, 0.001), uqq);
		
		// unnamed Point with decimal and long decimal
		Point uqQ = new Point(11.42, 1.0 / 7);
		assertEquals(new Point(11.42, 0.14285), uqQ);
		
		// unnamed Point with decimal and irrational
		Point uqr = new Point(-0.13, Math.PI);
		assertEquals(new Point(-0.13, 3.14159), uqr);
		
		// unnamed Point with long decimals only
		Point uQQ = new Point(89.00000003, 14.298565645);
		assertEquals(new Point(89, 14.29856), uQQ);
		
		// unnamed Point with long decimal and irrational
		Point uQr = new Point(6, Math.E);
		assertEquals(new Point(6, 2.71828), uQr);
		
		// unnamed Point with irrationals only
		Point urr = new Point(Math.cbrt(13), Math.log(2));
		assertEquals(new Point(2.35133, 0.69314), urr);
		
		
		// names + a decent into madness
		// named Point with integers only
		Point nzz = new Point("A", 12, -2);
		assertEquals(new Point("A", 12, -2), nzz);
		
		// named Point with integer and decimal
		Point nzq = new Point("", 0, -7.7);
		assertEquals(new Point("", 0, -7.7), nzq);
		
		// named Point with integer and long decimal
		Point nzQ = new Point("Paul", -4, 0.1234567);
		assertEquals(new Point("Paul", -4, 0.12345), nzQ);
		
		// named Point with integer and irrational
		Point nzr = new Point("__UNNAMED", 9, Math.sqrt(3));
		assertEquals(new Point("__UNNAMED", 9, 1.73205), nzr);
		
		// named Point with decimals only
		Point nqq = new Point("sdfsdf", -8.47, 0.001);
		assertEquals(new Point("sdfsdf", -8.47, 0.001), nqq);
		
		// named Point with decimal and long decimal
		Point nqQ = new Point("42", 11.42, 1.0 / 7);
		assertEquals(new Point("42", 11.42, 0.14285), nqQ);
		
		// named Point with decimal and irrational
		Point nqr = new Point("Try Minecraft", -0.13, Math.PI);
		assertEquals(new Point("Try Minecraft", -0.13, 3.14159), nqr);
		
		// named Point with long decimals only
		Point nQQ = new Point("Wake Up!", 89.00000003, 14.298565645);
		assertEquals(new Point("Wake Up!", 89, 14.29856), nQQ);
		
		// named Point with long decimal and irrational
		Point nQr = new Point("EEEEEEEEEE", 6, Math.E);
		assertEquals(new Point("EEEEEEEEEE", 6, 2.71828), nQr);
		
		// named Point with irrationals only
		Point nrr = new Point("DefinitelyNotAZipBomb.zip", Math.cbrt(13), Math.log(2));
		assertEquals(new Point("DefinitelyNotAZipBomb.zip", 2.35133, 0.69314), nrr);

		// named Point against an unnamed Point
		Point named = new Point("a name", 2, 2);
		assertEquals(new Point(2, 2), named);
		
		//tests that fail equals
		//swapped x and y
		assertNotEquals(new Point(2, 3), new Point(3, 2));

		//decimal vs integer
		assertNotEquals(new Point(2.2, 3), new Point(2, 3));

		//each decimal is 0.00001 off, just enough to count
		assertNotEquals(new Point(1.23456, 9.87654), new Point(1.23457, 9.87653));
		
		//same as last, but with an irrational
		assertNotEquals(new Point(2, Math.sqrt(3)), new Point(2, 1.73204));
    }

    @Test
    void toStringTest() {
		// NAMING SCHEME
		// u = unnamed
		// n = named
		// z = integer
		// q = decimal
		// Q = decimal (shortened)
		// r = irrational
		
		// unnamed Point with integers only
		Point uzz = new Point(12, -2);
		assertEquals("(12, -2)", uzz.toString());
		
		// unnamed Point with integer and decimal
		Point uzq = new Point(0, -7.7);
		assertEquals("(0, -7.7)", uzq.toString());
		
		// unnamed Point with integer and long decimal
		Point uzQ = new Point(-4, 0.1234567);
		assertEquals("(-4, 0.12345)", uzQ.toString());
		
		// unnamed Point with integer and irrational
		Point uzr = new Point(9, Math.sqrt(3));
		assertEquals("(9, 1.73205)", uzr.toString());
		
		// unnamed Point with decimals only
		Point uqq = new Point(-8.47, 0.001);
		assertEquals("(-8.47, 0.001)", uqq.toString());
		
		// unnamed Point with decimal and long decimal
		Point uqQ = new Point(11.42, 1.0 / 7);
		assertEquals("(11.42, 0.14285)", uqQ.toString());
		
		// unnamed Point with decimal and irrational
		Point uqr = new Point(-0.13, Math.PI);
		assertEquals("(-0.13, 3.14159)", uqr.toString());
		
		// unnamed Point with long decimals only
		Point uQQ = new Point(89.00000003, 14.298565645);
		assertEquals("(89, 14.29856)", uQQ.toString());
		
		// unnamed Point with long decimal and irrational
		Point uQr = new Point(6, Math.E);
		assertEquals("(6, 2.71828)", uQr.toString());
		
		// unnamed Point with irrationals only
		Point urr = new Point(Math.cbrt(13), Math.log(2));
		assertEquals("(2.35133, 0.69314)", urr.toString());
		
		
		// names + a decent into madness
		// named Point with integers only
		Point nzz = new Point("A", 12, -2);
		assertEquals("A(12, -2)", nzz.toString());
		
		// named Point with integer and decimal
		Point nzq = new Point("", 0, -7.7);
		assertEquals("(0, -7.7)", nzq.toString());
		
		// named Point with integer and long decimal
		Point nzQ = new Point("Paul", -4, 0.1234567);
		assertEquals("Paul(-4, 0.12345)", nzQ.toString());
		
		// named Point with integer and irrational
		Point nzr = new Point("__UNNAMED", 9, Math.sqrt(3));
		assertEquals("__UNNAMED(9, 1.73205)", nzr.toString());
		
		// named Point with decimals only
		Point nqq = new Point("sdfsdf", -8.47, 0.001);
		assertEquals("sdfsdf(-8.47, 0.001)", nqq.toString());
		
		// named Point with decimal and long decimal
		Point nqQ = new Point("42", 11.42, 1.0 / 7);
		assertEquals("42(11.42, 0.14285)", nqQ.toString());
		
		// named Point with decimal and irrational
		Point nqr = new Point("Try Minecraft", -0.13, Math.PI);
		assertEquals("Try Minecraft(-0.13, 3.14159)", nqr.toString());
		
		// named Point with long decimals only
		Point nQQ = new Point("Wake Up!", 89.00000003, 14.298565645);
		assertEquals("Wake Up!(89, 14.29856)", nQQ.toString());
		
		// named Point with long decimal and irrational
		Point nQr = new Point("EEEEEEEEEE", 6, Math.E);
		assertEquals("EEEEEEEEEE(6, 2.71828)", nQr.toString());
		
		// named Point with irrationals only
		Point nrr = new Point("DefinitelyNotAZipBomb.zip", Math.cbrt(13), Math.log(2));
		assertEquals("DefinitelyNotAZipBomb.zip(2.35133, 0.69314)", nrr.toString());
    }
}
