import processing.core.PApplet;
import java.util.Random;

public class Main extends PApplet {
Random r = new Random();
boolean sploded = false;
float[] xs = new float [3];
float[] ys = new float [3];
float [] xDir = new float [3];
float [] yDir = new float [3];
float [] speeds = new float [3];
boolean dir;
    public void settings() {
      size(400, 400);
      for(int i=0; i<3; i++){
        xs[i] = random(-100,100) + 200;
        ys[i] = random (-100,100) + 200;
        speeds [i] = random(1,5);
        dir = r.nextBoolean();
        if(dir){
          xDir[i] = 1;
        }else{
          xDir [i] = -1;
        }
        dir = r.nextBoolean();
        if (dir){
          yDir[i] = 1;
        }else{
          yDir [i] = -1;
        }
      }
    }

    public void draw() {
      background(255);
      if(sploded == false)
      circle(width/2, height/2, 50);
      else{
        for(int i=0; i<3; i++){
          circle(xs[i], ys[i], 30);
          xs[i] = xs[i] + speeds[i] * xDir[i];
          ys[i] = ys[i] + speeds[i] * yDir[i];
        }

      }
      if(keyCode == UP){
        sploded = true;
      }
    } 
      

    

  public static void main(String[] args) {
    String[] processingArgs = {"MySketch"};
		Main mySketch = new Main();
		PApplet.runSketch(processingArgs, mySketch);
  }
}
