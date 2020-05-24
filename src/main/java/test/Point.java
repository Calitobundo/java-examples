package test;

public class Point {

    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point add(Point p){
        return add(p.x, p.y);
    }

    public Point add(double x, double y){
        return new Point(this.x + x, this.y +y);
    }

    @Override
    public String toString() {
        return "hallo"+x+" "+y;
    }
}
