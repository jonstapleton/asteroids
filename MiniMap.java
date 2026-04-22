import processing.core.PApplet;

public class MiniMap {

    PApplet p;

    public MiniMap() {
    }

    public void display(PApplet p) {
        p.square(p.width - 110, 10, 100);
    }

    @SuppressWarnings("static-access")
    public void displayAsteroids(PApplet p, Asteroid a) {
        float m_x = p.map(a.x, 0, p.width, p.width - 110, p.width - 10);
        float m_y = p.map(a.y, 0, p.height, 10, 100);
        p.push();
        p.fill(255);
        p.square(m_x, m_y, 5);
        p.pop();
    }

    @SuppressWarnings("static-access")
    public void displayShip(PApplet p, Ship s) {
        float m_x = p.map(s.ship_center_x, 0, p.width, p.width - 110, p.width - 20);
        float m_y = p.map(s.ship_center_y, 0, p.height, 10, 100);
        p.push();
        p.fill(255, 0, 0);
        p.square(m_x, m_y, 10);
        p.pop();
    }
}
