package geometry_objects.points;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointNamingFactoryTest {
    @Test
    public void sizeTest() {
        PointNamingFactory pnf = new PointNamingFactory();

        assertEquals(0, pnf.size());

        pnf.put(new Point(0, 0));
        assertEquals(1, pnf.size());

        pnf.put(new Point(0, 0));
        assertEquals(1, pnf.size());

        pnf.put(new Point(0.001, 2));
        assertEquals(2, pnf.size());

        pnf.clear();
        assertEquals(0, pnf.size());

        pnf.put(new Point(-4, 2.005));
        assertEquals(1, pnf.size());
    }
    
    @Test
    public void putPTTest() {

    }

    @Test
    public void putXYest() {
        
    }

    @Test
    public void putTest() {
        
    }

    @Test
    public void getXYTest() {
        
    }

    @Test
    public void getPTTest() {
        
    }

    @Test
    public void containsXYTest() {
        
    }

    @Test
    public void containsPTTest() {
        
    }

    @Test
    public void getAllPoints() {
        
    }
}
