import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main extends PApplet {

  //Ship

  Ship s;
  boolean[] keys = new boolean[3];

  //Asteroids

  ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();

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

    //Asteroids

    for(int i = 0; i < 3; i++) {
      Asteroid a = new Asteroid(Asteroid.Size.SMALL, this);
      asteroids.add(a);
    }

  }

  public void draw() {
    background(255);

    //Ship

    s.move(keys);
    s.display();

    //Asteroids

    for(int i = 0; i < asteroids.size(); i++) {
      asteroids.get(i).Display(s.ship_center_x, s.ship_center_y);
    }

    sort();
    collision_detection();

  }

  public void collision_detection() {

    for(int i = 0; i <= 10; i++) {
      float x1 = lerp(s.ship_x1, s.ship_x2, i/10.0f);
      float y1 = lerp(s.ship_y1, s.ship_y2, i/10.0f);

      float x2 = lerp(s.ship_x1, s.ship_x3, i/10.0f);
      float y2 = lerp(s.ship_y1, s.ship_y3, i/10.0f);

      float x3 = lerp(s.ship_x2, s.ship_x3, i/10.0f);
      float y3 = lerp(s.ship_y2, s.ship_y3, i/10.0f);
      
      if(dist(x1, y1, asteroids.get(0).x, asteroids.get(0).y) < asteroids.get(0).radius + asteroids.get(0).limit) {
        // explode();
      }
      if(dist(x2, y2, asteroids.get(0).x, asteroids.get(0).y) < asteroids.get(0).radius + asteroids.get(0).limit) {
        // explode();
      }
      if(dist(x3, y3, asteroids.get(0).x, asteroids.get(0).y) < asteroids.get(0).radius + asteroids.get(0).limit) {
        // explode();
      }
    }

  }

  public void sort() {
    //Sorting asteroids based off of distance from ship

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