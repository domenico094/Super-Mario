package progetto.model.premio;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import progetto.LoadResources;
import progetto.handler.Game;
import progetto.model.mario.Mario;
import progetto.util.StatoMario;


public class SuperFungo extends Potenzia{
	
	LoadResources load = LoadResources.getInstance();
	BufferedImage img = null;
	 public SuperFungo(int x, int y) {
	        super(x, y);
	        setPunti(100);
	        img = load.getMyImage("resources"+File.separator+"superFungo.png");
	    }

	    @Override
	    public void collision(Mario mario) {
	        mario.aumentaPunti(getPunti());

Game.getInstance().playSuperFungo();

	        if(mario.getStato() == StatoMario.NORMALE){
	            

	           mario.setStato(StatoMario.GRANDE);
	        }
	    }
	    
	    @Override
	    public void draw(Graphics2D g) {
	    	g.drawImage(img,getX(),getY(),getDim().width,getDim().height,null);
	    	super.draw(g);
	    }

}
