package t2.redes;

public class Point {
    
    private float inX;
    private float inY;
    private float outX;
    private float outY;
    private float x;
    private float y;

    public Point(float inX, float inY, float outX, float outY) {
        this.inX = inX;
        this.inY = inY;
        this.outX = outX;
        this.outY = outY;
    }
    
    public Point(int x, int y) {
        this.inX = x;
        this.inY = y;
    }

    public float getInX() {
        return inX;
    }

    public float getInY() {
        return inY;
    }

    public float getOutX() {
        return outX;
    }

    public float getOutY() {
        return outY;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
}