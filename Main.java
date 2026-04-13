import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import processing.core.PFont;

public class Main extends PApplet {

  //Ship

  Ship s;
  boolean[] keys = new boolean[4];

  //Projectile

  ArrayList<Projectile> proj = new ArrayList<Projectile>(20);
  ArrayList<Projectile> to_remove_proj = new ArrayList<>();

  //Asteroids

  ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
  ArrayList<Asteroid> to_remove_asteroids = new ArrayList<>();

  //Hud

  PFont myFont;

  HUD hud;
    
  boolean playerHit = false;
  boolean objectHit = false;

  public void settings() {
    size(1000, 1000);
  }

  public void setup() {
    stroke(255);
    fill(0);

    //Ship

    s = new Ship(300f, 300f, 0f, 0f, 4.71f, 20f, 2.7f, this);
    for(int i = 0; i < keys.length; i++) {
      keys[i] = false;
    }

    //Asteroids

    for(int i = 0; i < 3; i++) {
      Asteroid a = new Asteroid(Asteroid.Size.LARGE, this);
      asteroids.add(a);
    }

    //Hud
    myFont = createFont("PixelifySans-VariableFont_wght.ttf", 50);
    textFont(myFont);

    hud = new HUD(0, 3);  

  }

  public void draw() {
    background(0);

    //Ship

    s.move(keys);
    s.display();

    //Projectile
    
    for(int index = 0; index < proj.size(); index++) {
      proj.get(index).display(this);
    }
    
                                                                          
    if(keys[3] && frameCount%6==0) {
      proj.add(new Projectile(s, this));
    }

    //Asteroids

    for(int i = 0; i < asteroids.size(); i++) {
      asteroids.get(i).Display(s);
    }

    sort();
    collision_detection();

    //Hud

    hud.displayScore(this);

    if (objectHit == true) {
      hud.addScore(5);
      objectHit = false;
    }

    if (playerHit == true) {
      hud.takeDamage();
    }
    
    hud.displayHealth(this);

    playerHit = false;
    
    if (hud.died()) {
      fill(255);
      textSize(70);
      text("GAME OVER", 120, 400);
      noLoop();
    }

  }

  public void collision_detection() {

    //Collision detection for laser and asteroids

    for(Projectile p : proj) {
      for(Asteroid a : asteroids) {
        if(dist(p.x + cos(s.ship_angle) * 8, p.y + sin(s.ship_angle) * 8, a.x, a.y) < a.radius + a.limit) {
          to_remove_proj.add(p);
          to_remove_asteroids.add(a);
        }
      }
    }
    proj.removeAll(to_remove_proj);
    asteroids.removeAll(to_remove_asteroids);
    to_remove_proj.clear();
    to_remove_asteroids.clear();

    for(int i = 0; i <= 10; i++) {

      //Collision detection for ship and asteroids

      float x1 = lerp(s.ship_x1, s.ship_x2, i/10.0f);
      float y1 = lerp(s.ship_y1, s.ship_y2, i/10.0f);

      float x2 = lerp(s.ship_x1, s.ship_x3, i/10.0f);
      float y2 = lerp(s.ship_y1, s.ship_y3, i/10.0f);

      float x3 = lerp(s.ship_x2, s.ship_x3, i/10.0f);
      float y3 = lerp(s.ship_y2, s.ship_y3, i/10.0f);
      
      if(dist(x1, y1, asteroids.get(0).x, asteroids.get(0).y) < asteroids.get(0).radius + asteroids.get(0).limit) {
        s.ship_center_x = width/2;
        s.ship_center_y = height/2;
        s.ship_velocity_x = 0;
        s.ship_velocity_y = 0;
      }
      if(dist(x2, y2, asteroids.get(0).x, asteroids.get(0).y) < asteroids.get(0).radius + asteroids.get(0).limit) {
        s.ship_center_x = width/2;
        s.ship_center_y = height/2;
        s.ship_velocity_x = 0;
        s.ship_velocity_y = 0;
      }
      if(dist(x3, y3, asteroids.get(0).x, asteroids.get(0).y) < asteroids.get(0).radius + asteroids.get(0).limit) {
        s.ship_center_x = width/2;
        s.ship_center_y = height/2;
        s.ship_velocity_x = 0;
        s.ship_velocity_y = 0;
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

    if (key == 'h') {
      playerHit = true;
    }
    
    if (key == 's') {
      objectHit = true;
    }

    int[] dirs = { UP, LEFT, RIGHT, SHIFT };
    for (int i = 0; i < dirs.length; i++) {
      if (keyCode == dirs[i]) {
        keys[i] = true;
      }
    }
  }
  
  public void keyReleased() {
    int[] dirs = { UP, LEFT, RIGHT, SHIFT };
    for (int i = 0; i < dirs.length; i++) {
      if (keyCode == dirs[i]) {
        keys[i] = false;
      }
    }
  }
  public static void main(String[] args) {
    PApplet.main("Main");
    String[] processingArgs = { "MySketch" };
    Main mySketch = new Main();
    PApplet.runSketch(processingArgs, mySketch);
  }
}