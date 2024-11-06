
import java.util.*;

public class Square {
    double side;
    List<Point> vertices;
    public Square(Set<Point> vertices) {
        List<Point> listOfVertices = new ArrayList<>(vertices);
        Collections.sort(listOfVertices);
        if(vertices.size() > 4){
            throw new IllegalArgumentException("You gave too many vertices");
        } else if (vertices.size() < 4) {
            throw new IllegalArgumentException("You gave too few vertices");
        } else if (!checkDistances(listOfVertices)) {
            throw new IllegalArgumentException("Wrong vertices");
        }
        else {
            this.side = listOfVertices.get(0).distance(listOfVertices.get(1));

            this.vertices = listOfVertices;

        }
    }

    public boolean checkDistances(List<Point> vertices) {
        Set<Double> points = new HashSet<>();

        for(int i = 0; i < vertices.size(); i++){
            for(int j = i + 1; j < vertices.size(); j++){
                if(vertices.get(i).isNeighboor(vertices.get(j))) {
                    points.add(vertices.get(i).distance(vertices.get(j)));
                }
            }
        }
        return points.size() == 1;

    }

    public boolean checkPoint(Point point) {
        if(point.getX() <= this.vertices.getLast().getX() && point.getY() <= this.vertices.getLast().getY()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Your square with side " + side + " have this coordinates:\n");
        vertices.forEach(point -> sb.append("(").append(point.getX()).append(", ").append(point.getY()).append(")\n"));
        return sb.toString();
    }

    public double getSide() {
        return side;
    }

    public List<Point> getVertices() {
        return vertices;
    }
}
