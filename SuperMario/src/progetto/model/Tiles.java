package progetto.model;

import java.awt.Dimension;
import java.awt.Rectangle;

public class Tiles {
	private int x, y;
	private Dimension dim;

	public Tiles(int x, int y) {
		this.setX(x);
		this.setY(y);
		dim = new Dimension(48,48);
	}
	public Dimension getDim() {
		return dim;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setDim(Dimension dim) {
		this.dim = dim;
	}
	public Rectangle getRettanglo() {
		return new Rectangle(this.getX(), this.getY(), this.getDim().width, this.getDim().height);
	}

	public Rectangle getRettangloTesta() {
		return new Rectangle(this.getX() + 4, this.getY(), this.getDim().width - 8, this.getDim().height / 2);
	}

	public Rectangle getRettangloGambe() {
		return new Rectangle(this.getX() + 6, this.getY() + (getDim().height / 2), this.getDim().width - 12,
				this.getDim().height / 2);
	}

	public Rectangle getRettanglobd() {
		return new Rectangle(this.getX() + 36, this.getY() + 12, this.getDim().width / 4, (this.getDim().height) - 18);
	}

	public Rectangle getRettanglobs() {
		return new Rectangle(this.getX(), this.getY() + 12, this.getDim().width / 4, (this.getDim().height) - 18);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

}
