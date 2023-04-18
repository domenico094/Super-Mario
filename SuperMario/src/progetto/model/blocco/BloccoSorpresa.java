package progetto.model.blocco;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



import progetto.LoadResources;
import progetto.model.premio.Premio;


public class BloccoSorpresa extends Blocco{

	private Premio premio;
	BufferedImage img2=null;
	public LoadResources load = LoadResources.getInstance();
    public BloccoSorpresa(int x, int y, Premio premio,BufferedImage img,BufferedImage img2) {
        super(x, y,img);
        setrompibile(false);
        setVuoto(false);
        this.premio = premio;
        this.img2 = img2;
  
    }

    @Override
    public Premio rivela(){
        
        

        if(premio != null){
            premio.rivela();
        }

        setVuoto(true);
        setImg(img2);

        Premio p2 = this.premio;
        this.premio = null;
        return p2;
    }

    @Override
    public Premio getPremio(){
        return premio;
    }
	
    @Override
    public void draw(Graphics2D g2) {
    	g2.drawImage(img, getX(), getY(), img.getWidth(), img.getHeight(), null);
    	super.draw(g2);
    }
    
    
    public void setImg(BufferedImage img) {
    	this.img = img;
    }
}
