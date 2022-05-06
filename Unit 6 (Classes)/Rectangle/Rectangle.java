package Rectangle;

import java.util.*;

public class Rectangle {
    private int left;
    private int bottom;
    private int width;
    private int height;
    
    public Rectangle(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;
        return;
    }

    public Rectangle() {
        this.left = 0;
        this.bottom = 0;
        this.width = 0;
        this.height = 0;
        return;
    }
    
    public int getX() {
        return left;
    }
    
    public int getY() {
        return bottom;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public void set(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;
        return;
    }

    public int area() {
        return this.width * this.height;
    }

    public int perimeter() {
        return (this.width == 0 || this.height == 0) ? Math.max(this.width, this.height) : 2 * (this.width + this.height);
    }
    
    public boolean contains(Rectangle r) {
        return (r.left >= this.left && r.left + r.width <= this.left + this.width && r.bottom >= this.bottom && r.bottom + r.height <= this.bottom + this.height);
    }

    public static Rectangle intersection(Rectangle r, Rectangle s) {
        int x = Math.max(s.left, r.left);
        int y = Math.max(s.bottom, r.bottom);
        int width = Math.min(s.left + s.width, r.left + r.width) - x;
        int height = Math.min(s.bottom + s.height, r.bottom + r.height) - y;
        return new Rectangle(x, y, width, height);
    }

    public static int totalPerimeter(Rectangle r, Rectangle s) {
        if (r.contains(s)) return r.perimeter();
        else if (s.contains(r)) return s.perimeter();
        return r.perimeter() + s.perimeter() - 2 * Rectangle.intersection(r, s).perimeter();
    }
    
    public String toString() {
        return "base:(" + this.left + ", " + this.bottom + ") w:" + this.width + " h:" + this.height;
    }
}