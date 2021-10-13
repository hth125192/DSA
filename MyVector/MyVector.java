public class MyVector {
    public int x;
    public int y;

    public MyVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyVector add(MyVector other) {
        return new MyVector(x + other.x,y + other.y);
    }

    public String toString() {
        return x + ", " + y;
    }
}
