package progetto.model;


import java.awt.Dimension;



public class Entita extends Tiles {

	private int speed;
	private int muoviInY;

	private boolean salto, caduta;

	public Entita(int x, int y) {
		super(x, y);
		setDim(new Dimension(48, 48));

		salto = false;
		caduta = true;

	}

	public int getMuoviInY() {
		return muoviInY;
	}

	public void setMuoviInY(int muoviInY) {
		this.muoviInY = muoviInY;
	}

	public void update() {
		if (getSalto() && muoviInY <= 0) {
			setSalto(false);
			setCaduta(true);
		} else if (getSalto()) {
			setMuoviInY(getMuoviInY() - 2);
			setY(getY() - getMuoviInY());
		}

		if (getCaduta()) {
			setY(getY() + getMuoviInY());
			setMuoviInY(getMuoviInY() + 2);
		}

		setX(getX() + getSpeed());
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean getSalto() {
		return salto;
	}

	public void setSalto(boolean salto) {
		this.salto = salto;
	}

	public boolean getCaduta() {
		return caduta;
	}

	public void setCaduta(boolean caduta) {
		this.caduta = caduta;
	}

}
