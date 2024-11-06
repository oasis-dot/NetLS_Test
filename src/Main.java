
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Set<Point> vertices = new HashSet<>();
            System.out.println("Enter vertices coordinates (x, y). Example:  27, 4");
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter point " + (i + 1) + ": ");
                try {
                    String verticesString = sc.nextLine();
                    String[] verticesArray = verticesString.split(", ");
                    if (verticesArray.length > 2) {
                        throw new IllegalArgumentException("Invalid number of points: " + verticesArray.length);
                    }
                        int x = Integer.parseInt(verticesArray[0]);
                        int y = Integer.parseInt(verticesArray[1]);
                        vertices.add(new Point(x, y));
                }
                catch (NumberFormatException e) {
                    System.out.println("Must be a number");
                    break;
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    break;
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            Square square = new Square(vertices);
            System.out.println(square);

            System.out.println("Enter vertex that you want to check: ");
            String verticesString = sc.nextLine();
            String[] verticesArray = verticesString.split(", ");
            int x = Integer.parseInt(verticesArray[0]);
            int y = Integer.parseInt(verticesArray[1]);
            Point vertex = new Point(x, y);

            if (square.checkPoint(vertex)) {
                System.out.println("This point is in square");
            } else System.out.println("This point is out of square");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}