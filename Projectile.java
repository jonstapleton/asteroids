import processing.core.PApplet;

public class Projectile {
    float x, y; 
    float angle;
    double velocity_x, velocity_y;

    public Projectile(float angle, float x, float y, PApplet p) {
    this.x = x;
    this.y = y;
    this.angle = angle;
}


@SuppressWarnings("static-access")
void display(PApplet p) {
    
    p.line(x, y, x + p.cos(angle) * 10, y + p.sin(angle) * 10);
    velocity_x = 7*p.cos(angle);
    velocity_y = 7*p.sin(angle);

    x += velocity_x;
    y += velocity_y;
    }
}