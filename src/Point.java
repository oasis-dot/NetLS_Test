import java.util.Objects;

public class Point implements Comparable<Point>{
    Integer x;
    Integer y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Point o) {
        if(x.equals(o.x)) {
            return y.compareTo(o.y);
        }
        return x.compareTo(o.x);
    }

    public double distance(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

    public boolean isNeighboor(Point p) {
        int xDiff = x - p.x;
        int yDiff = y - p.y;
        return (xDiff != 0 && yDiff == 0) || (xDiff == 0 && yDiff != 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
