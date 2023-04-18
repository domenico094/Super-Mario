package progetto.model.blocco;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BloccoTerra extends Blocco {

	public BloccoTerra(int x, int y, BufferedImage img) {
		super(x, y, img);

	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img, getX(), getY(), getDim().width, getDim().height, null);

	}
}
