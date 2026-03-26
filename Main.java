
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
    size(600, 800);
    s = new Ship(300f, 300f, 0f, 0f, 4.71f, 20f, 2.7f, this);
    keys[0] = false;
    keys[1] = false;
    keys[2] = false;
  }

  public void setup() {
    myFont = createFont("PixelifySans-VariableFont_wght.ttf", 50);
    textFont(myFont);

    hud = new HUD(0, 3);  
  }

  public void draw() {
    background(0);
    s.move(keys);
    s.display();

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

  public void keyPressed() {
    
        if (key == 'h') {
        playerHit = true;
        }
    
        if (key == 's') {
        objectHit = true;
        }

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
    PApplet.main("Main");
    String[] processingArgs = { "MySketch" };
    Main mySketch = new Main();
    PApplet.runSketch(processingArgs, mySketch);
  }
}

// <<<<<<< HEAD
// =======
// // comment
// >>>>>>> Ben
