package progetto.model.blocco;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import progetto.LoadResources;
import progetto.model.Entita;
import progetto.model.premio.Premio;


public class Blocco extends Entita {
	BufferedImage img;
	private boolean rompibile;
	private boolean vuoto;
	LoadResources load = LoadResources.getInstance();
	public Blocco(int x, int y,BufferedImage img) {
		super(x, y);

		vuoto = true;
	setImg(img);
		
		
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public void setVuoto(boolean vuoto) {
		this.vuoto = vuoto;
	}

	public boolean getVuoto() {
		return vuoto;
	}

	public void setrompibile(boolean rotto) {
		this.rompibile = rotto;
	}

	public boolean getRompibile() {
		return rompibile;
	}

	public Premio rivela() {
		return null;
	}

	public Premio getPremio() {
		return null;
	}
	

	public void draw(Graphics2D g) {
		g.drawImage(img,getX(),getY(),getDim().width,getDim().height,null);
		
	}
	
	

}
