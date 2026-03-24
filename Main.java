import processing.core.PApplet;

public class Main extends PApplet {

    public Shape t;
    public void settings() {
      size(400, 400);
    }
    public void setup() {
      t = new Shape(this);
    }
    public void draw() {
      background(0);
      t.display(this);
    }

  public static void main(String[] args) {
    String[] processingArgs = {"MySketch"};
		Main mySketch = new Main();
		PApplet.runSketch(processingArgs, mySketch);
  }
}
