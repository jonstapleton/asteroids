import processing.core.PApplet;
import processing.core.PShape;

public class HUD extends PApplet {
  int score;
  int health;
  PShape s;
  
  HUD(int s, int h, PApplet p){ 
    score = s;
    health = h;
    this.s = p.createShape();
    this.s.beginShape();
    this.s.vertex(10, 10);
    this.s.vertex(20, 10);
    this.s.vertex(10, 20);
    this.s.endShape(p.CLOSE);
  }
 
  void addScore(int amount){
  score += amount;
  }
  
  void takeDamage(){
  health --;
  }
  
  void displayScore(PApplet p){
    p.fill(255);
    p.textSize(50);
    p.text(score, 24, 55);
    
    p.shape(this.s, 0, 0);
  }

  void displayHealth(PApplet p){
    for (int i = 0; i < health; i++) {
      p.fill(255, 0, 0);
      p.circle(50 + i * 60, 100, 40);
    }
  }
  
  boolean died() {
  return health < 1;
  }

}