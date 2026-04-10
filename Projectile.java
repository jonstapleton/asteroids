import processing.core.PApplet;

public class Projectile {
    float x, y; 
    float angle;
    double velocity_x, velocity_y;

    public Projectile(Ship ship, PApplet p) {
        this.x = ship.ship_x1;
        this.y = ship.ship_y1;
        this.angle = ship.ship_angle;
    }

    @SuppressWarnings("static-access")
    public void display(PApplet p) {
    
        p.line(x, y, x + p.cos(angle) * 10, y + p.sin(angle) * 10);
        velocity_x = 6*p.cos(angle);
        velocity_y = 6*p.sin(angle);

        x += velocity_x;
        y += velocity_y;
    }

}