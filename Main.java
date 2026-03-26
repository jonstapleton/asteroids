import processing.core.PApplet;

public class Main extends PApplet {

  Asteroid a;
  Asteroid b;
  Asteroid c;

    public void settings() {
      size(800, 800);
    }

    public void setup() {
      a = new Asteroid(Asteroid.Size.LARGE, this);
      b = new Asteroid(Asteroid.Size.MEDIUM, this);
      c = new Asteroid(Asteroid.Size.SMALL, this);
    }

    public void draw() {
      background(255);
      a.Display(this);
      b.Display(this);
      c.Display(this);
    }

  public static void main(String[] args) {
    String[] processingArgs = {"MySketch"};
		Main mySketch = new Main();
		PApplet.runSketch(processingArgs, mySketch);
  }
}
