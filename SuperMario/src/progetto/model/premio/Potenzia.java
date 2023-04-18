package progetto.model.premio;

import java.awt.Dimension;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import progetto.model.Entita;
import progetto.model.mario.Mario;

public abstract class Potenzia extends Entita implements Premio{

	BufferedImage img;
	public Potenzia(int x, int y) {
		super(x, y);
		
		Dimension dim = new Dimension(48,48);
		setDim(dim);
		setSpeed(2);
		
	}
	
	 private boolean mostra = false;
	    private int punti;

	    

	    public abstract void collision(Mario mario);

	    @Override
	    public int getPunti() {
	        return punti;
	    }
	    
	    @Override
	    public void update() {
	    	// TODO Auto-generated method stub
	    	if(mostra)
	    		super.update();
	    }
	    
	   

	    
	    public void draw(Graphics2D g){
	        if(mostra){
	            g.drawImage(img, (int)getX(), (int)getY(), null);
	        }
	    }

	    @Override
	    public void rivela(){
	        setY(getY()-48);
	        mostra = true;
	    }

	    public void setPunti(int punti) {
	        this.punti = punti;
	    }

}
