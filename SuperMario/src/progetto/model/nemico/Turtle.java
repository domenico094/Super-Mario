package progetto.model.nemico;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Turtle extends Nemico {
	String tipo;
	BufferedImage right;
	BufferedImage left;
	BufferedImage morto2;
	 
	
	public Turtle(int x, int y,BufferedImage d,BufferedImage s,BufferedImage m) {
		super(x, y);
		setSpeed(7);
		

		left = s;
		right = d;
		morto2 = m;
		
		tipo = "TURTLE";

	}
	public void muore () {
		setCaduta(true);
		setDim(new Dimension(48,42));
		setSpeed(10);
		setMorto(true);		
		
	}
	public String getTipo() {
		return tipo;
	}
	
	
	public void draw(Graphics2D g) {
		
		if(getMorto()==true) 
		{
			g.drawImage(morto2, getX(), getY(), 48, 48, null);
		}
		
		else { 
			if (getSpeed() > 0)
			g.drawImage(right, getX(), getY(), 48, 48, null);
		else if (getSpeed() < 0) {
			g.drawImage(left, getX(), getY(), 48, 48, null);
		}
		}
	
	}	
		

}
