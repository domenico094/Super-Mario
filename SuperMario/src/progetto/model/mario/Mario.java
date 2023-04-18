package progetto.model.mario;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import progetto.LoadResources;
import progetto.handler.Game;
import progetto.util.StatoMario;

import progetto.model.Entita;

public class Mario extends Entita {

	StatoMario stato;

	LoadResources load = LoadResources.getInstance();
	int indice = 1;
	int count = 0, index = 0;
	BufferedImage[] leftFrames;
	BufferedImage[] rightFrames;
	BufferedImage img;
	private int vita = 3;
	int punti = 0;
	int monete = 0;

	public int getMonete() {
		return monete;
	}

	public Mario(int x, int y) {
		super(x, y);
		aDestra = true;
		setStato(StatoMario.NORMALE);

		rightFrames = load.getMarioDestra(getStato());
		leftFrames = load.getMarioSinistra(getStato());
		img = getADestra() ? rightFrames[indice] : leftFrames[indice];

	}

	public void aggiungiMonete() {
		monete++;
	}

	public LoadResources getLoad() {
		return load;
	}

	public void setLoad(LoadResources load) {
		this.load = load;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public BufferedImage[] getLeftFrames() {
		return leftFrames;
	}

	public void setLeftFrames(BufferedImage[] leftFrames) {
		this.leftFrames = leftFrames;
	}

	public BufferedImage[] getRightFrames() {
		return rightFrames;
	}

	public void setRightFrames(BufferedImage[] rightFrames) {
		this.rightFrames = rightFrames;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public boolean isaDestra() {
		return aDestra;
	}

	public void setaDestra(boolean aDestra) {
		this.aDestra = aDestra;
	}

	public static void setMario(Mario mario) {
		Mario.mario = mario;
	}

	static Mario mario = null;

	public boolean aDestra;

	public void salta() {

		if (!getSalto() && !getCaduta()) {
			setSalto(true);
			setMuoviInY(24);

			Game.getInstance().jumpSound();
		}

	}

	public void aumentaVita(int v) {
		vita += v;
	}

	public void setPosizione(int x, int y) {
		setX(x);
		setY(y);
	}

	public void drawMario(Graphics2D g) {

		setImage();

		g.drawImage(img, getX(), getY(), getDim().width, getDim().height, null);

	}

	public void setImage() {
		if (getSalto() == true) {
			img = getADestra() ? rightFrames[0] : leftFrames[0];
		} else if (getCaduta() == true) {
			img = getADestra() ? rightFrames[0] : leftFrames[0];
		} else if (getCaduta() == false && getSalto() == false && getSpeed() != 0) {
			img = animate(getSpeed(), aDestra);
		} else if (getCaduta() == false && getSalto() == false && getSpeed() == 0) {
			img = getADestra() ? rightFrames[1] : leftFrames[1];
		}

	}

	public void muovi(boolean aDestra) {
		
		if (aDestra) {
			setSpeed(10);
		} else if(  getX() > Game.getInstance().getCamera().getX()) {
			setSpeed(-10);
		}

		this.aDestra = aDestra;
	}

	public boolean getADestra() {
		return aDestra;
	}

	public StatoMario getStato() {
		return stato;
	}

	public void setStato(StatoMario stato) {
		this.stato = stato;
		if (stato == StatoMario.GRANDE) {
			Dimension dim = new Dimension(48, 96);
			this.setDim(dim);
			rightFrames = load.getMarioDestra(StatoMario.GRANDE);
			leftFrames = load.getMarioSinistra(StatoMario.GRANDE);
		} else if (stato == StatoMario.NORMALE) {
			Dimension dim = new Dimension(48, 48);
			this.setDim(dim);
			rightFrames = load.getMarioDestra(StatoMario.NORMALE);
			leftFrames = load.getMarioSinistra(StatoMario.NORMALE);
		}

	}

	public BufferedImage animate(int speed, boolean toRight) {
		count++;

		BufferedImage[] frames = toRight ? rightFrames : leftFrames;

		if (count >= speed && !toRight) {
			nextFrame(frames);
			count = 0;
		} else if (count <= speed && toRight) {
			nextFrame(frames);
			count = 0;
		}

		return img;
	}

	private void nextFrame(BufferedImage[] frames) {

		if (index >= frames.length)
			index = 0;

		img = frames[index];
		index++;
	}

	public void aumentaPunti(int punti) {
		this.punti += punti;
	}

	public void resetPosizione() {

		if (this.getX() < 200) {

			setX(0);
			Game.getInstance().getCamera().setX(0);
			setStato(StatoMario.NORMALE);
		} else {

			setX(0);
			setY(50);
			Game.getInstance().getCamera().setX(0);

		}

		setSalto(false);
		setCaduta(true);
		setSpeed(0);
		setMuoviInY(0);
		setStato(StatoMario.NORMALE);
		Game.getInstance().marioDieSound();

	}

}
