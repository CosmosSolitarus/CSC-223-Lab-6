package geometry_objects.points;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PointDatabaseTest {
    @Test
    public void getPointsTest() {
        PointDatabase pd = new PointDatabase();

        Point pt0 = new Point("Bryan", 0, 0);
        Point pt1 = new Point("Sarah", 4, -3.3);
        Point pt2 = new Point("Thomas", -1, 0.0000001);

        pd.put("Bryan", 0, 0);
        pd.put("Sarah", 4, -3.3);
        pd.put("Thomas", -1, 0.0000001);

        Set<Point> pts = new LinkedHashSet<Point>();

        pts.add(pt0);
        pts.add(pt1);
        pts.add(pt2);

        assertTrue(pts.equals(pd.getPoints()));
    }

    @Test
    public void sizeTest() {
        PointDatabase pd = new PointDatabase();
        assertEquals(0, pd.size());

        pd.put("Bryan", 0, 0);
        assertEquals(1, pd.size());

        pd.put("Sarah", 4, -3.3);
        assertEquals(2, pd.size());

        pd.put("Thomas", -1, 0.0000001);
        assertEquals(3, pd.size());
    }

    @Test
    public void getNameTest() {
        PointDatabase pd = new PointDatabase();

        Point pt0 = new Point("Bryan", 0, 0);
        Point pt1 = new Point("Sarah", 4, -3.3);
        Point pt2 = new Point("Thomas", -1, 0.0000001);

        pd.put("Bryan", 0, 0);
        pd.put("Sarah", 4, -3.3);
        pd.put("Thomas", -1, 0.0000001);

        assertEquals(pt0.getName(), pd.getName(pt0.getX(), pt0.getY()));
        assertNotEquals("", pd.getName(pt0.getX(), pt0.getY()));

        assertEquals(pt1.getName(), pd.getName(pt1));

        assertNotEquals(pt2.getName(), pd.getName(null));
    }

    @Test
    public void getPointNameTest() {
        PointDatabase pd = new PointDatabase();

        Point pt0 = new Point("Bryan", 0, 0);
        Point pt1 = new Point("Sarah", 4, -3.3);
        Point pt2 = new Point("Thomas", -1, 0.0000001);

        pd.put("Bryan", 0, 0);
        pd.put("Sarah", 4, -3.3);
        pd.put("Thomas", -1, 0.0000001);

        assertEquals(pt0, pd.getPoint("Bryan"));
        assertEquals(pt1, pd.getPoint("Sarah"));
        assertEquals(pt2, pd.getPoint("Thomas"));

        assertNotEquals(pt0, pd.getPoint(""));
    }

    @Test
    public void getPointPTTest() {
        PointDatabase pd = new PointDatabase();

        Point pt0 = new Point("Bryan", 0, 0);
        Point pt1 = new Point("Sarah", 4, -3.3);
        Point pt2 = new Point("Thomas", -1, 0.0000001);

        pd.put("Bryan", 0, 0);
        pd.put("Sarah", 4, -3.3);
        pd.put("Thomas", -1, 0.0000001);

        assertEquals(pt0, pd.getPoint(pt0));
        assertEquals(pt1, pd.getPoint(pt1));
        assertEquals(pt2, pd.getPoint(pt2));

        assertNotEquals(pt0, pd.getPoint(new Point(-1000, 4)));
    }

    @Test
    public void getPointXYTest() {
        PointDatabase pd = new PointDatabase();

        Point pt0 = new Point("Bryan", 0, 0);
        Point pt1 = new Point("Sarah", 4, -3.3);
        Point pt2 = new Point("Thomas", -1, 0.0000001);

        pd.put("Bryan", 0, 0);
        pd.put("Sarah", 4, -3.3);
        pd.put("Thomas", -1, 0.0000001);

        assertEquals(pt0, pd.getPoint(0, 0));
        assertEquals(pt1, pd.getPoint(4, -3.3));
        assertEquals(pt2, pd.getPoint(-1, 0.0000001));

        assertNotEquals(pt0, pd.getPoint(new Point(-1000, 4)));
    }
}
