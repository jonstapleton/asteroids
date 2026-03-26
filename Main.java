import processing.core.PApplet;

public class Main extends PApplet{

  Projectile[] proj;
  int i = 1;

  public void settings() {
    size(400,400);
  }

  public void setup() {
    //proj = new Projectile();
    proj = new Projectile[10];
    proj[0] = new Projectile(this);
  }

  public void draw() {
    background(255);
    ellipse(200,200,40,40);
  //proj[0].display();
    for(int index=0;index<i;index++) {
      proj[index].display(this);
    }
    
  if(keyPressed && key == 'z' && frameCount%6==0) {
      proj[i] = new Projectile(this);
      i = (i + 1)%10;
    }
  }

  public static void main(String[] args) {
    String[] processingArgs = { "MySketch" };
    Main mySketch = new Main();
    PApplet.runSketch(processingArgs, mySketch);
  }
}
