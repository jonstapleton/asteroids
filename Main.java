import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main extends PApplet {

  //Ship

  Ship s;
  boolean[] keys = new boolean[3];
  
  //----

  //Asteroids

  ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
  float distance;

  //----

  public void settings() {
    size(1000, 1000);
  }

  public void setup() {

    //Ship

    s = new Ship(300f, 300f, 0f, 0f, 4.71f, 20f, 2.7f, this);
    keys[0] = false;
    keys[1] = false;
    keys[2] = false;

    //----

    //Asteroids

    for(int i = 0; i < 3; i++) {
      Asteroid a = new Asteroid(Asteroid.Size.LARGE, this);
      asteroids.add(a);
    }

  }

  public void draw() {
    background(255);

    //Ship

    s.move(keys);
    s.display();

    //----

    //Asteroids

    for(int i = 0; i < asteroids.size(); i++) {
      asteroids.get(i).Display(s.ship_center_x, s.ship_center_y);
    }

    Comparator<Asteroid> com = new Comparator<Asteroid>() {
      public int compare(Asteroid i, Asteroid j) {
        if(i.ship_distance > j.ship_distance) {
          return 1;
        } else {
          return -1;
        }
      }
    };

    Collections.sort(asteroids, com);

    line(asteroids.get(0).x, asteroids.get(0).y, s.ship_center_x, s.ship_center_y);

    //----

  }

  //Ship

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

  //-----------------------------------------------------

  public static void main(String[] args) {
    String[] processingArgs = { "MySketch" };
    Main mySketch = new Main();
    PApplet.runSketch(processingArgs, mySketch);
  }
}

// comment