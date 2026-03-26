import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
  
PImage img1;
PImage img2;
PImage img3;
float odd = 0;

    public void settings() {
      size(400, 400);
      img1 = loadImage("./frame1.png");
      img2 = loadImage("./frame2.png");
      img3 = loadImage("./still.png");
}
    
    public void draw() {
      background(255);
      image(img3, 125, 125);
      if (keyCode == UP){
        odd = odd + 0.3f;
        PImage img;
      if (floor(odd) % 2 == 0) {
        img = img1;
  }
      else {
        img = img2;
  }
  image(img, 125, 125);
 }
    }

  public static void main(String[] args) {
    String[] processingArgs = {"MySketch"};
		Main mySketch = new Main();
		PApplet.runSketch(processingArgs, mySketch);
  }
}
