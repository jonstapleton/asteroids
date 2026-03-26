import processing.core.PApplet;


public class HUD {
  int score;
  int health;
  // add text color
  
  HUD(int score, int h){ //add text color
  // add text color
  }
 
  public void addScore(int amount){
  score += amount;
  }
  
  public void takeDamage(){
    if (health > 0) {
        health--;
    }
  }
  
  public void displayScore(PApplet p){
  p.fill(255);
  p.textSize(50);
  p.text(score, 24, 55);
  }

  public void displayHealth(PApplet p){
  for (int i = 0; i < health; i++) {
      p.fill(255, 0, 0);
      p.circle(50 + i * 60, 100, 40);
    }
  }
  
  boolean died() {
  return health < 1;
  }

}