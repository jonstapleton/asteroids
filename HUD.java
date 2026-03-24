public class HUD {
  int score;
  int health;
  
  HUD(int s, int h){ 
  score = s;
  health = h;
  }
 
  void addScore(int amount){
  score += amount;
  }
  
  void takeDamage(){
  health --;
  }
  
  void displayScore(){
  fill(255);
  textSize(50);
  text(score, 24, 55);
  }

  void displayHealth(){
  for (int i = 0; i < health; i++) {
      fill(255, 0, 0);
      circle(50 + i * 60, 100, 40);
    }
  }
  
  boolean died() {
  return health < 1;
  }

}