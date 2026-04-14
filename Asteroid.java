import processing.core.PShape;
import processing.core.PVector;
import processing.core.PApplet;

class Asteroid {

  public static enum Size { LARGE, MEDIUM, SMALL };
  
  PShape s;
  
  float radius = 0;
  float x, y;
  PVector velocity = PVector.random2D();
  
  float increment = 0.15f;
  int limit = 0;
  float minimum = 0;

  float dis_x, dis_y;
  float ship_distance;

  boolean is_large = false;
  boolean is_medium = false;
  boolean is_small = false;

  PApplet p;
  
  @SuppressWarnings("static-access")

  public Asteroid(Size type, float x, float y, PApplet p) {
        
    this.x = x;
    this.y = y;

    this.p = p;

    switch(type) {
    
      case LARGE:
        this.radius = 50;
        this.limit = 10;
        this.minimum = -2;
        this.is_large = true;
        break;
        
      case MEDIUM:
        this.radius = 30;
        this.limit = 10;
        this.minimum = -0.25f;
        this.is_medium = true;
        break;
        
      case SMALL:
        this.radius = 15;
        this.limit = 5;
        this.minimum = -0.01f;
        this.is_small = true;
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

  public void Display(Ship ship) {
    // p.circle(x, y, radius * 2 + limit);
    p.shape(s, x, y);

    x += velocity.x;
    y += velocity.y;

    if(x > p.width + (radius + limit)) {
      x = 0 - (radius + limit);
    }
    if(y > p.height + (radius + limit)) {
      y = 0 - (radius + limit);
    }
    if(x < 0 - (radius + limit)) {
      x = p.width + (radius + limit);
    }
    if(y < 0 - (radius + limit)) {
      y = p.height + (radius + limit);
    }

    this.dis_x = ship.ship_center_x;
    this.dis_y = ship.ship_center_y;

    ship_distance = p.dist(dis_x, dis_y, x, y);

  }
  
}
