import processing.core.PApplet;

public class Projectile {
  float x, y;
  
  public Projectile(PApplet p) {
  x = p.width/2;
  y = p.height/2;
}

void display(PApplet p) {
  p.line(x,y,x+10,y);
  x = x + 2;
}
}