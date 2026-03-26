import processing.core.PApplet;
import processing.core.PFont;

public class Main extends PApplet {
  Ship s;
  boolean[] keys = new boolean[3];

  PFont myFont;
  HUD hud;
  boolean playerHit = false;
  boolean objectHit = false;

  public void settings() {
    size(600, 700);
    s = new Ship(300f, 300f, 0f, 0f, 4.71f, 20f, 2.7f, this);
    keys[0] = false; // up
    keys[1] = false; // left
    keys[2] = false; // right
  }

  public void setup() {
    myFont = createFont("PixelifySans-VariableFont_wght.ttf", 50);
    textFont(myFont);
    hud = new HUD(0, 3);  
  }

  public void draw() {
    background(0); // black backround (Change fill for ship?)
    hud.displayScore(this);
    if (objectHit) {
      hud.addScore(5);
      objectHit = false;
    }
    if (playerHit) {
      hud.takeDamage();
      playerHit = false;
    }
    
    hud.displayHealth(this);

    if (hud.died()) {
      fill(255);
      textSize(70);
      text("GAME OVER", 120, 400);
      noLoop();
    }

    s.move(keys);
    s.display();
  }

  public void keyPressed() {
    int[] dirs = { UP, LEFT, RIGHT };
    for (int i = 0; i < dirs.length; i++) {
      if (keyCode == dirs[i]) {
        keys[i] = true;
      }
    }
    if (key == 'h') {
      playerHit = true;
    }
    
    if (key == 's') {
      objectHit = true;
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