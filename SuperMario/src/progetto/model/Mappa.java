package progetto.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import progetto.LoadResources;
import progetto.model.blocco.Blocco;
import progetto.model.mario.Mario;
import progetto.model.nemico.Nemico;
import progetto.model.premio.Moneta;
import progetto.model.premio.Potenzia;
import progetto.model.premio.Premio;


public class Mappa {
	

	LoadResources load = LoadResources.getInstance();

	
	ArrayList<Blocco> blocchi = new ArrayList<Blocco>();
	ArrayList<Premio> premi = new ArrayList<Premio>();
	ArrayList<Nemico> nemici = new ArrayList<Nemico>();
	ArrayList<Moneta> monete = new ArrayList<Moneta>();
	Bandiera bandiera;
	ArrayList<ArrayList<Integer>> temp;
	BufferedImage background;
	public Mario mario;

	int w;
	int h;

	
	
	public Mappa() {
		
	}

	public void drawMappa(Graphics2D g2) {
		g2.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), null);

		drawMario(g2);
		drawBlocco(g2);
		drawPremi(g2);
		drawNemico(g2);
		drawMoneta(g2);
	
		drawBandiera(g2);
		
	}

	public void setBandiera(int x, int y, BufferedImage img) {
		bandiera = new Bandiera(x, y, img);
	}

	public void drawBandiera(Graphics2D g2) {
		
		bandiera.draw(g2);
	}

	public Bandiera getBandiera() {
		return bandiera;
	}

	

	public void drawMoneta(Graphics2D g) {
		for (Moneta n : monete)
			n.draw(g);

	}

	public void rimuoviBlocco(Blocco b) {
		blocchi.remove(b);
	}

	public void drawNemico(Graphics2D g) {
		for (Nemico n : nemici)
			n.draw(g);

	}

	public void aggiornaPremi() {
		for (Premio p : premi) {
			Potenzia p2 = (Potenzia) p;
			p2.update();

		}
	}

	
	

	
	

	public ArrayList<Premio> getPremi() {
		return premi;
	}

	private void drawPremi(Graphics2D g) {
		for (Premio p : premi)
			if (p instanceof Potenzia) {
				((Potenzia) p).draw(g);
			}
	}

	public void addPremio(Premio p) {
		premi.add(p);
	}

	public void addBlocco(Blocco b) {
		blocchi.add(b);
	}

	public ArrayList<Blocco> getBlocchi() {
		return blocchi;
	}

	public void drawBlocco(Graphics2D g) {
		for (Blocco b : blocchi)
			b.draw(g);
	}

	public void drawMario(Graphics2D g) {
		mario.drawMario(g);
	}

	public void aggiorna() {

		aggiornaMario();
		aggiornaNemico();
		aggiornaPremi();
	
		if(bandiera!=null)
			bandiera.update();
	

	}

	public void creaMario(int x, int y) {
		this.mario = new Mario(x, y);
	}

	public void aggiornaMario() {
		if (mario != null)
			mario.update();

	}

	public void aggiornaBlocco() {
		for (Blocco blocco : blocchi) {
			blocco.update();
		}
	}

	public void aggiornaNemico() {
		for (Nemico n : nemici)
			n.update();
	}

	public ArrayList<Nemico> getNemici() {
		return nemici;
	}

	public void addNemico(Nemico nemico) {

		nemici.add(nemico);

	}

	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	public void rimuoviNemico(Nemico n) {
		nemici.remove(n);
	}

	public Mario getMario() {
		return mario;
	}

	public void rimuoviPremi(Premio p) {
		premi.remove(p);

	}


	public void addMoneta(Moneta m) {
		monete.add(m);
	}

	public ArrayList<Moneta> getMonete() {
		return monete;
	}

	public void rimuoviMoneta(Moneta m) {
		monete.remove(m);
	}

	

	
}
