package test;

public class TestApp {


    public static void main(String[] args) {
        System.out.println("Hello World");

        Point point = new Point(100, 100);

        Point point2 = new Point(3, 4);

        point.setX(50);
        point.setY(120);

        Point p1 = point.add(point2).add(new Point(23, 45)).add(30, 50);

        System.out.println(p1);
        System.out.println(point2);

    }
}
