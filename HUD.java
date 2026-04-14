import processing.core.PApplet;
import processing.core.PShape;

public class HUD {
  int score;
  int health;

  PShape s;
  
  @SuppressWarnings("static-access")
  HUD(int score, int health, PApplet p) {
    // add text color
    this.health = health;
    this.score = score;

    s = p.createShape();

    s.beginShape();

    s.fill(255, 0, 0);
    s.curveVertex(0, 30);
    s.curveVertex(-30, 0);
    s.curveVertex(-30, -10);
    s.curveVertex(-25, -20);
    s.curveVertex(-20, -25);
    s.curveVertex(-10, -25);
    s.curveVertex(-5, -20);
    s.curveVertex(0, -15);
    s.curveVertex(5, -20);
    s.curveVertex(10, -25);
    s.curveVertex(20, -25);
    s.curveVertex(25, -20);
    s.curveVertex(30, -10);
    s.curveVertex(30, 0);
    s.scale(0.75f);

    s.endShape(p.CLOSE);
  }
 
  public void addScore(int amount){
    score += amount;
  }
  
  public void takeDamage(){
    if (health > 0) {
      health -= 1;
    }
  }

  public void displayHealth(PApplet p){
  for (int i = 0; i < health; i++) {
    p.shape(s, 50 + i * 60, 100);
  }
  }

  public void displayScore(PApplet p) {
    p.push();
    p.fill(255);
    p.textSize(50);
    p.text(score, 24, 55);
    p.pop();
  }

  boolean died() {
    return health < 1;
  }

}