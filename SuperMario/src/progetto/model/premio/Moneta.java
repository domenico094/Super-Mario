package progetto.model.premio;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import progetto.LoadResources;

public class Moneta {

	BufferedImage img;
	public LoadResources load = LoadResources.getInstance();
	private int x;
	private int y;

	public Moneta(int x, int y, BufferedImage img) {
		this.setX(x);
		this.setY(y);
		this.img = img;

	}

	public void draw(Graphics2D g) {
		g.drawImage(img, getX(), getY(), img.getWidth(), img.getHeight(), null);

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

	public Rectangle getRettangolo() {
		return new Rectangle(getX(), getY(), 48, 48);
	}

	public BufferedImage getImg() {
		return img;
	}

}
