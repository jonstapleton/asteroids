import processing.core.PShape;
import processing.core.PApplet;

class Asteroid {

  public static enum Size { LARGE, MEDIUM, SMALL };
  
  PShape s;
  
  float radius = 0;
  float x, y;
  
  float increment = 0.15f;
  int limit = 0;
  float minimum = 0;

  float dis_x, dis_y;
  float ship_distance;

  PApplet p;
  
  @SuppressWarnings("static-access")

  public Asteroid(Size type, PApplet p) {
        
    x = p.random(100, p.width - 100);
    y = p.random(100, p.height - 100);
    

    this.p = p;

    switch(type) {
    
      case LARGE:
        this.radius = 50;
        this.limit = 10;
        this.minimum = -2;
        break;
        
      case MEDIUM:
        this.radius = 30;
        this.limit = 10;
        this.minimum = -0.25f;
        break;
        
      case SMALL:
        this.radius = 15;
        this.limit = 5;
        this.minimum = -0.01f;
        break;
      
    }
    
    s = p.createShape();
    
    s.beginShape();
    
      for(float i = 0; i < p.TWO_PI; i += p.random(increment)) {
        float r1 = radius + p.random(minimum, limit);
        float vertex_x = r1 * p.cos(i);
        float vertex_y = r1 * p.sin(i);
        s.vertex(vertex_x, vertex_y);
      }
    
    s.endShape(p.CLOSE);
  }
  
  @SuppressWarnings("static-access")

  void Display(float dis_x, float dis_y) {
    // p.circle(x, y, radius * 2 + limit);
    p.shape(s, x, y);

    this.dis_x = dis_x;
    this.dis_y = dis_y;

    ship_distance = p.dist(dis_x, dis_y, x, y);

  }
  
}
