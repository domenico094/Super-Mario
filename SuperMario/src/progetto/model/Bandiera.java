package progetto.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bandiera extends Entita{
	private boolean touched = false;
	BufferedImage img;
	public Bandiera(int x, int y,BufferedImage img) {
		super(x, y);
		this.img = img;
	}
	 @Override
	    public void update() {
	        if(touched){
	            if(getY() + getDim().getHeight() >= 576){
	                setCaduta(false);
	                setMuoviInY(0);
	                setY( 576 - getDim().height);
	            }
	            super.update();
	        }
	    }

	    public boolean isTouched() {
	        return touched;
	    }

	    public void setTouched(boolean touched) {
	        this.touched = touched;
	    }
	    
	    
	    public void draw(Graphics2D g2) {
	    	g2.drawImage(img,getX(),getY(),48,48,null);
	    	
	    }
}
