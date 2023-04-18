package progetto.model.nemico;

import java.awt.Graphics2D;

import progetto.model.Entita;

public class Nemico extends Entita{
	String tipo="";
	private boolean morto = false;
	public Nemico(int x, int y) {
		super(x, y);
		
	}
	
	public void setMorto(boolean morto) {
		this.morto = morto;
	}
	public void muore () { 
		setCaduta(true);
		morto=true;
	}
	public boolean getMorto() {
		return morto;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void draw(Graphics2D g2) {}
}
