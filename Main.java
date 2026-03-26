import processing.core.PApplet;

public class Main extends PApplet {
  Ship s;
  boolean[] keys = new boolean[3];

  Projectile[] proj;
  int i = 1;
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

    //proj = new Projectile();
    proj = new Projectile[10];
    proj[0] = new Projectile(this);

    a = new Asteroid(Asteroid.Size.LARGE, this);
    b = new Asteroid(Asteroid.Size.MEDIUM, this);
    c = new Asteroid(Asteroid.Size.SMALL, this);
  }

  public void draw() {
    background(255);

    s.move(keys);
    s.display();

    ellipse(200,200,40,40);
    //proj[0].display();

    for(int index=0;index<i;index++) {
      proj[index].display(this);
    }

    if(keyPressed && key == 'z' && frameCount%6==0) {
      proj[i] = new Projectile(this);
      i = (i + 1)%10;
  }

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