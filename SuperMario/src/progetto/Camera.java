package progetto;

public class Camera {
	
	int x;
	int y;
	
	public Camera(int x,int y) {
		this.x=x;
		this.y = y;
	}
	
	public void muovi(int x, int y) {
		this.x +=x;
		this.y += y;
	}

	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
