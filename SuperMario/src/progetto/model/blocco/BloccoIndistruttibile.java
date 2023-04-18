package progetto.model.blocco;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BloccoIndistruttibile extends Blocco {

	public BloccoIndistruttibile(int x, int y, BufferedImage img) {
		super(x, y, img);
		
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
	}
}
