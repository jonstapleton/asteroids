import processing.core.PApplet;
import processing.core.PImage;

public class spaced_ship extends PApplet {
    
PImage img1;
PImage img2;
PImage img3;
float odd = 0;

void setup() {
  size (400,400);
  img1 = loadImage("./frame1.png");
  img2 = loadImage("./frame2.png");
  img3 = loadImage("./still.png");
}
 
void draw() {
    background(255);
    image(img3, 0, 0);
 if (keyCode == UP){
  odd = odd + 0.3;
  PImage img;
  if (floor(odd) % 2 == 0) {
    img = img1;
  }
  else {
    img = img2;
  }
  image(img, 0, 0);
 }
}
}
