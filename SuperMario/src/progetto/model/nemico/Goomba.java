package progetto.model.nemico;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;




public class Goomba extends Nemico {

	BufferedImage right;
	BufferedImage left;
	BufferedImage[] img;
	BufferedImage i;
	int indice = 0;
	

	public Goomba(int x, int y, BufferedImage d, BufferedImage s,BufferedImage m) {
		super(x, y);
		setSpeed(9);
		

		img = new BufferedImage[3];
		img[0] = s;
		img[1] = d;
		img[2] = m;
		indice = 0;
	}

	public void muore() {
		setCaduta(true);
		setMorto(true);
		setY(getY() + getSpeed());
		setDim(new Dimension(48, 22));
		setSpeed(0);

	}

	public void draw(Graphics2D g) {

		i = getImage();
		g.drawImage(i, getX(), getY(), i.getWidth(), i.getHeight(), null);

	}

	public BufferedImage getImage() {
		if (getMorto() == false) {
			if (indice >= 2)
				indice = 0;
			i = img[indice];
			indice++;
		} else
			i = img[2];
		return i;
	}
}
