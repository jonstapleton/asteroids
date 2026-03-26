import processing.core.PApplet;

public class Main extends PApplet {
  Ship s;
  boolean[] keys = new boolean[3];

  Asteroid a;
  Asteroid b;
  Asteroid c;

  public void settings() {
    size(1000, 700);
    s = new Ship(300f, 300f, 0f, 0f, 4.71f, 20f, 2.7f, this);
    keys[0] = false;
    keys[1] = false;
    keys[2] = false;
  }

  public void setup() {
    a = new Asteroid(Asteroid.Size.LARGE, this);
    b = new Asteroid(Asteroid.Size.MEDIUM, this);
    c = new Asteroid(Asteroid.Size.SMALL, this);
  }

  public void draw() {
    background(255);
    s.move(keys);
    s.display();

    //Asteroids
    a.Display(this);
    b.Display(this);
    c.Display(this);
  }

public void keyPressed() {
    int[] dirs = { UP, LEFT, RIGHT };
    for (int i = 0; i < dirs.length; i++) {
      if (keyCode == dirs[i]) {
        keys[i] = true;
      }
    }
  }

  public void keyReleased() {
    int[] dirs = { UP, LEFT, RIGHT };
    for (int i = 0; i < dirs.length; i++) {
      if (keyCode == dirs[i]) {
        keys[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    String[] processingArgs = { "MySketch" };
    Main mySketch = new Main();
    PApplet.runSketch(processingArgs, mySketch);
  }
}

// comment