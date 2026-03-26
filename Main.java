
  //   public void settings() {
  //     size(400, 400);
  //   }
  //   public void draw() {
  //     background(255);
  //     circle(width/2, height/2, 50);
  //   }

  // public static void main(String[] args) {
  //   String[] processingArgs = {"MySketch"};
	// 	Main mySketch = new Main();
	// 	PApplet.runSketch(processingArgs, mySketch);
  // }
  
import processing.core.PApplet;
import processing.core.PFont;


public class Main extends PApplet {

    PFont myFont;

    HUD hud;
    
    boolean playerHit = false;
    boolean objectHit = false;

  public void settings() {
    size(600, 800);
  }

  public void setup() {
    myFont = createFont("PixelifySans-VariableFont_wght.ttf", 50);
    textFont(myFont);

    hud = new HUD(0, 3);  
  }

  public void draw() {
    background(0);

    hud.displayScore(this);

    if (objectHit) {
      hud.addScore(5);
      objectHit = false;
    }

    if (playerHit) {
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

  public static void main(String[] args) {
    PApplet.main("Main");
  }

    public void keyPressed() {
    
        if (key == 'h') {
        playerHit = true;
        }
    
        if (key == 's') {
        objectHit = true;
        }
    }
}

