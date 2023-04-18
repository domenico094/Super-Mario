package progetto.model.premio;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import progetto.LoadResources;
import progetto.handler.Game;
import progetto.model.mario.Mario;

public class FungoVita extends Potenzia {
	BufferedImage img;
	LoadResources load = LoadResources.getInstance();
	 public FungoVita( int x,int y ) {
		super(x,y );
		img= load.getMyImage("resources"+File.separator+"fungoVita.png");
		setPunti(100);
	 }
	@Override
	public void collision(Mario mario) {
		Game.getInstance().playFungo();
		mario.aumentaPunti(getPunti());
		mario.aumentaVita(1);
	}
	 
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img,getX(),getY(),getDim().width,getDim().height,null);
		super.draw(g);
	}
	
	
    }

