package progetto.view;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import progetto.LoadResources;




public class MenuGame {
	private LoadResources load;
	
	public MenuGame() {
		load = LoadResources.getInstance();

	}

	BufferedImage img = null;
	public Rectangle inizio = new Rectangle(350, 300, 100, 50);
	public Rectangle aiuto = new Rectangle(350, 400, 100, 50);
	public Rectangle esci = new Rectangle(350, 500, 100, 50);

	public Rectangle mappa1 = new Rectangle(350, 300, 150, 50);
	public Rectangle mappa2 = new Rectangle(350, 400, 150, 50);
	public Rectangle indietro = new Rectangle(350, 500, 150, 50);
	public Rectangle esci2 = new Rectangle(350, 580, 100, 50);

	public Rectangle otherIndietro = new Rectangle(50, 580, 150, 50);
	public Rectangle continua = new Rectangle(580, 580, 164, 50);
	
	public Rectangle riprendi =new Rectangle(350, 300, 100, 50);
	public Rectangle menu =new Rectangle(350, 300, 100, 50);
	
	public void drawMenuIniziale(Graphics2D g) {
		img = load.getMyImage("resources"+File.separator+"menuIniziale.png");

		g.drawImage(img, 0, 0,img.getWidth(), img.getHeight(), null);

		Font font1 = new Font("arial", Font.BOLD, 30);
		g.setFont(font1);
		g.setColor(Color.WHITE);

		g.draw(inizio);
		g.drawString("1", 320, 340);
		g.drawString("INIZIA", inizio.x + 10, inizio.y + 38);

		g.draw(aiuto);
		g.drawString("2", 320, 440);
		g.drawString("AIUTO", aiuto.x + 5, aiuto.y + 38);

		g.draw(esci);
		g.drawString("q", 320, 540);
		g.drawString("ESCI", esci.x + 12, esci.y + 38);

	}

	public void drawMenuMappa(Graphics2D g) {
		img = load.getMyImage("resources"+File.separator+"SelezionaMappa.png");

		g.drawImage(img, 0, 0,img.getWidth(), img.getHeight(), null);
		g.setBackground(Color.RED);

		Font font1 = new Font("arial", Font.BOLD, 30);
		g.setFont(font1);
		g.setColor(Color.WHITE);

		g.draw(mappa1);
		g.drawString("1", 320, 340);
		g.drawString("MAPPA 1", mappa1.x + 10, mappa1.y + 38);

		g.draw(mappa2);
		g.drawString("2", 320, 440);
		g.drawString("MAPPA 2", mappa2.x + 10, mappa2.y + 38);

		g.draw(indietro);
		g.drawString("3", 320, 540);
		g.drawString("INDIETRO", indietro.x + 6, indietro.y + 38);

		g.draw(esci2);
		g.drawString("q", 320, 600);
		g.drawString("ESCI", esci2.x + 10, esci2.y + 38);

	}

	public void drawPausa(Graphics2D g2) {
		img = load.getMyImage("resources"+File.separator+"pausa.png");

		g2.drawImage(img, 0, 0,img.getWidth(), img.getHeight(), null);
		Font font1 = new Font("arial", Font.BOLD, 30);
		g2.setFont(font1);
		g2.setColor(Color.WHITE);
		
		
		
 
		g2.draw(riprendi);
		g2.drawString("ESC",280,340);
		g2.drawString("GAME", inizio.x + 10, inizio.y + 38);

		g2.draw(aiuto);
		g2.drawString("1", 320, 440);
		g2.drawString("MENU", aiuto.x + 5, aiuto.y + 38);

		g2.draw(esci);
		g2.drawString("q", 320, 540);
		g2.drawString("ESCI", esci.x + 12, esci.y + 38);

		
	}
	
	public void drawIstruzioni(Graphics2D g) {
		img = load.getMyImage("resources"+File.separator+"istruzioni.png");

		g.drawImage(img, 0, 0,img.getWidth(), img.getHeight(), null);
		g.setBackground(Color.RED);

		Font font1 = new Font("arial", Font.BOLD, 30);
		g.setFont(font1);
		g.setColor(Color.WHITE);

		g.draw(otherIndietro);
		g.drawString("1", 20, 620);
		g.drawString("INDIETRO", otherIndietro.x + 6, otherIndietro.y + 38);

		g.draw(continua);
		g.drawString("2", 520, 620);
		g.drawString("CONTINUA",continua.x +6 , continua.y + 38);

	

		g.draw(esci2);
		g.drawString("q", 320, 620);
		g.drawString("ESCI", esci2.x + 10, esci2.y + 38);

	}
	
	public void drawGameOver2(Graphics2D g2) {
		img = load.getMyImage("resources"+File.separator+"gameOver.png");

		g2.drawImage(img, 0, 0,img.getWidth(), img.getHeight(), null);
		Font font1 = new Font("arial", Font.BOLD, 30);
		g2.setFont(font1);
		g2.setColor(Color.WHITE);
		g2.draw(aiuto);
		g2.drawString("1", 320, 440);
		g2.drawString("MENU", aiuto.x + 5, aiuto.y + 38);

		g2.draw(esci);
		g2.drawString("q", 320, 540);
		g2.drawString("ESCI", esci.x + 12, esci.y + 38);
	}
	
	public void drawVittoria2(Graphics2D g2) {
		img = load.getMyImage("resources"+File.separator+"vittoria.png");

		g2.drawImage(img, 0, 0,img.getWidth(), img.getHeight(), null);
		Font font1 = new Font("arial", Font.BOLD, 30);
		g2.setFont(font1);
		g2.setColor(Color.WHITE);
		g2.draw(aiuto);
		g2.drawString("1", 320, 440);
		g2.drawString("MENU", aiuto.x + 5, aiuto.y + 38);

		g2.draw(esci);
		g2.drawString("q", 320, 540);
		g2.drawString("ESCI", esci.x + 12, esci.y + 38);
	}
	
	
	
}
