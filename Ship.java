import processing.core.PApplet;

public class Ship{
  float ship_center_x;
  float ship_center_y;
  float ship_velocity_x;
  float ship_velocity_y;
  float ship_angle;
  float ship_size;
  float ship_adjust;

  float ship_x1;
  float ship_y1;
  float ship_x2;
  float ship_y2;
  float ship_x3;
  float ship_y3;

  PApplet p;

  public Ship(float Tship_center_x, float Tship_center_y, float Tship_velocity_x, float Tship_velocity_y, float Tship_angle, float Tship_size, float Tship_adjust, PApplet p) {
    ship_center_x = Tship_center_x;
    ship_center_y = Tship_center_y;
    ship_velocity_x = Tship_velocity_x;
    ship_velocity_y = Tship_velocity_y;
    ship_angle = Tship_angle;
    ship_size = Tship_size;
    ship_adjust = Tship_adjust;
    this.p = p;
  }
  
  // keys must be at least length 3
  @SuppressWarnings("static-access")
  public void move(boolean[] keys) {
    if (keys[0]) {
      ship_velocity_x += 0.4*p.cos(ship_angle);
      ship_velocity_y += 0.4*p.sin(ship_angle);
    }
    if (keys[1]) {
      ship_angle -= 0.08; // angle it turns by, radians
    }
    if (keys[2]) {
      ship_angle += 0.08;
    }

    // change position
    ship_center_x += ship_velocity_x;
    ship_center_y += ship_velocity_y;

    //wrap around
    if (ship_center_x > (p.width + ship_size/2)) {
      ship_center_x = -(ship_size/2);
    }
    if (ship_center_y > (p.height + ship_size/2)) {
      ship_center_y = -(ship_size/2);
    }
    if (ship_center_x < -(ship_size/2)) {
      ship_center_x = (p.width + ship_size/2);
    }
    if (ship_center_y < -(ship_size/2)) {
      ship_center_y = (p.height + ship_size/2);
    }

    // slow down ship
    ship_velocity_x *= 0.97;
    ship_velocity_y *= 0.97;
  }
  @SuppressWarnings("static-access")
  public void display() {
    this.ship_x1 = (ship_size * p.cos(ship_angle)) + ship_center_x;
    this.ship_y1 = (ship_size * p.sin(ship_angle)) + ship_center_y;
    this.ship_x2 = (ship_size * p.cos(ship_angle+ship_adjust)) + ship_center_x;
    this.ship_y2 = (ship_size * p.sin(ship_angle+ship_adjust)) + ship_center_y;
    this.ship_x3 = (ship_size * p.cos(ship_angle-ship_adjust)) + ship_center_x;
    this.ship_y3 = (ship_size * p.sin(ship_angle-ship_adjust)) + ship_center_y;
    p.triangle(ship_x1, ship_y1, ship_x2, ship_y2, ship_x3, ship_y3);
  }
}