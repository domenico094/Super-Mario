package progetto.handler;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import progetto.Camera;
import progetto.LoadResources;
import progetto.Suoni;
import progetto.model.Mappa;
import progetto.model.mario.Mario;
import progetto.util.Azione;
import progetto.util.IdMappa;
import progetto.util.Setting;
import progetto.util.Stato;
import progetto.view.MenuGame;

public class Game {
	private static Game instance = null;
	private Stato stato;
	private MenuGame menu;
	private IdMappa idMappa;
	private Azione azione;
	private Mappa mappa;
	private Mario mario;
	private Collision collision;
	private Camera camera;
	private Suoni suoni;
	LoadResources load;
	CreaMappa crea;

	private Game() {
		setStato(Stato.SCHERMATA_INIZIALE);
		setIdMappa(IdMappa.NESSUNA_MAPPA);
		setAzione(Azione.NESSUNA_AZIONE);
		menu = new MenuGame();

		suoni = new Suoni();
		load = LoadResources.getInstance();
	}

	public void creaMappa() {

		switch (getIdMappa()) {
		case MAPPA_1:
			initWorld(Setting.MAPPA_1, "mappa" + File.separator + "mappa1.txt");
			camera = new Camera(0, 0);
			setStato(Stato.START);
			break;
		case MAPPA_2:
			initWorld(Setting.MAPPA_2, "mappa" + File.separator + "mappa2.txt");
			camera = new Camera(0, 0);
			setStato(Stato.START);
			break;

		default:
			break;
		}
	}

	public void marioDieSound() {
		suoni.playMarioDie();
	}

	public void initWorld(String str, String c) {
		CreaMappa crea = new CreaMappa();
		mappa = crea.generaMappa(str, c);
		collision = new Collision(mappa);
	}

	public void gameOverSound() {
		suoni.playGameOver();
	}
	public void playSuperFungo() {
		suoni.playSuperFungo();
	}
	public void playFungo() {
		suoni.playFungoVita();
	}

	public void aggiorna() {

		if (getStato() == Stato.START) {
			collision.update();
			updateCamera();
		}
		if (collision.getVittoria() == true) {
			setStato(Stato.VITTORIA);
		}
		if (mario.getVita() <= 0) {
			setStato(Stato.GAME_OVER);
			gameOverSound();
		}
	}

	public Camera getCamera() {
		return camera;
	}

	public void jumpSound() {
		suoni.playJump();
	}

	private void updateCamera() {
		mario = mappa.getMario();

		if (  mario.getX() - getCamera().getX() >=350) {

			camera.muovi(mario.getSpeed(), 0);
		}
	}


	public void drawGame(Graphics2D g2) {
		mappa.drawMappa(g2);
	}


	public void movimenti() {
		if (getStato() == Stato.START) {

			mario = mappa.getMario();

			if (azione == Azione.SALTA) {

				mario.salta();

			} else if (azione == Azione.VAI_A_DESTRA) {

				mario.muovi(true);

			} else if (azione == Azione.VAI_A_SINISTA) {

				mario.muovi(false);
			}

			else if (getAzione() == Azione.STOP_AZIONE) {
				mario.setSpeed(0);
			}
		}

		setAzione(Azione.NESSUNA_AZIONE);
	}


	public void setAzione(Azione azione) {
		this.azione = azione;
	}

	public Azione getAzione() {
		return azione;
	}


	public void setIdMappa(IdMappa idMappa) {
		this.idMappa = idMappa;
	}

	public IdMappa getIdMappa() {
		return idMappa;
	}


	public void drawSchermataIniziale(Graphics2D g2) {
		menu.drawMenuIniziale(g2);
	}


	public void drawSelezionaMappa(Graphics2D g2) {
		menu.drawMenuMappa(g2);
	}


	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public void monataSound() {
		suoni.playCoin();
	}

	public int getMonete() {
		return mappa.getMario().getMonete();
	}

	public int getMarioVita() {
		return mappa.getMario().getVita();
	}

	public void drawPausa(Graphics2D g2) {
		menu.drawPausa(g2);
	}

	public void drawIstruzioni(Graphics2D g2) {
		menu.drawIstruzioni(g2);
	}

	public int getMarioPunti() {
		return mappa.getMario().getPunti();
	}

	public BufferedImage getImgMoneta() {
		return load.getMyImage("resources" + File.separator + "moneta.png");
	}


	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}

	public void drawGameOver2(Graphics2D g) {
		menu.drawGameOver2(g);
	}

	public void drawVittoria2(Graphics2D g) {
		menu.drawVittoria2(g);
	}
}
