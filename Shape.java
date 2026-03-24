import processing.core.PApplet;
import processing.core.PShape;

public class Shape {
    PShape shape;
    public Shape(PApplet p) {
        this.shape = p.createShape();
        this.shape.beginShape();
        this.shape.vertex(0, 0);
        this.shape.vertex(20, 10);
        this.shape.vertex(10, 20);
        this.shape.endShape(p.CLOSE);
    }
    public void display(PApplet p) {
        p.shape(this.shape, 0, 0);
    }
}
