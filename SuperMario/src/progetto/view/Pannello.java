package progetto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import progetto.handler.Game;


public class Pannello extends JPanel {
	private static final long serialVersionUID = 1253609563438755128L;

	private Game game;
	private BufferedImage img;

	public Pannello() {
		game = Game.getInstance();
		img = game.getImgMoneta();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		switch (game.getStato()) {
		case SCHERMATA_INIZIALE:
			game.drawSchermataIniziale(g2);
			break;
		case SELEZIONA_MAPPA:
			game.drawSelezionaMappa(g2);
			break;
		case ISTRUZIONI:
			game.drawIstruzioni(g2);

			break;

		case START:

			g2.translate(-game.getCamera().getX(), -game.getCamera().getY());
			game.drawGame(g2);
			g2.translate(game.getCamera().getX(), game.getCamera().getY());
			drawMonetePrese(g2);
			drawVita(g2);
			drawPunti(g2);
			break;
		case VITTORIA:
			drawVittoria(g2);
			break;
		case PAUSA:
			drawPausa(g2);
			break;
		case GAME_OVER:
			drawGameOver(g2);
			break;
		default:
			
			break;
		}

	}

	public void aggiorna() {
		repaint();
	}

	private void drawVita(Graphics2D g2) {
		Font font1 = new Font("arial", Font.BOLD, 30);
		g2.setFont(font1);

		g2.setColor(Color.WHITE);
		String str = "Vita : " + game.getMarioVita();

		g2.drawString(str, 100, 50);
	}

	private void drawMonetePrese(Graphics2D g2) {
		Font font1 = new Font("arial", Font.BOLD, 30);
		g2.setFont(font1);
		g2.setColor(Color.WHITE);
		String str = "" + game.getMonete();
		g2.drawImage(img, getWidth() - 115, 10, null);
		g2.drawString(str, getWidth() - 65, 50);
	}

	private void drawPausa(Graphics2D g2) {
		drawVita(g2);
		drawMonetePrese(g2);
		drawPunti(g2);
		game.drawPausa(g2);
	}
	
	private void drawGameOver(Graphics2D g2) {
		
		drawVita(g2);
		drawMonetePrese(g2);
		drawPunti(g2);
		game.drawGameOver2(g2);
		
	}

	public void drawPunti(Graphics2D g2) {
		Font font1 = new Font("arial", Font.BOLD, 30);
		g2.setFont(font1);
		g2.setColor(Color.WHITE);
		String str = "Punti :" + game.getMarioPunti();
		g2.drawString(str, 300, 50);
	}
	
	public void drawVittoria(Graphics2D g2) {
		
		drawVita(g2);
		drawMonetePrese(g2);
		drawPunti(g2);
		
		game.drawVittoria2(g2);
	}
}
