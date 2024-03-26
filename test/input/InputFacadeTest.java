package input;

import org.junit.Test;

import geometry_objects.Segment;
import geometry_objects.points.PointDatabase;
import input.builder.GeometryBuilder;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.parser.JSONParser;
import input.visitor.UnparseVisitor;

import static org.junit.Assert.*;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class InputFacadeTest {
    @Test
    public void extractFigureTest() {

    }

    @Test
    public void toGeometryRepresentationTest() {
        FigureNode fig = InputFacade.extractFigure("single_triangle.json");


        Map.Entry<PointDatabase, Set<Segment>> map = InputFacade.toGeometryRepresentation(fig);

        PointDatabase pdb = map.getKey();
        Set<Segment> segments = map.getValue();

        assertEquals(3, pdb.size());
        assertEquals(3, segments.size());
    }
}
