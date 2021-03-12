public class Rect extends Shape {
    public static void main(String args[]) {
        Rect obj = new Rect();
        obj.b = 200;
        obj.calculateArea();
    }
    public void calculateArea() {
        Rect ob=new Rect();
        System.out.println("Area is " + (ob.b * ob.b));
    }
}