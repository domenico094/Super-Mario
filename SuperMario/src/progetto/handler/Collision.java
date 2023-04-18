package progetto.handler;

import java.util.ArrayList;

import progetto.util.StatoMario;
import progetto.model.Entita;
import progetto.model.Mappa;
import progetto.model.blocco.Blocco;
import progetto.model.mario.Mario;
import progetto.model.nemico.Nemico;
import progetto.model.premio.Moneta;
import progetto.model.premio.Potenzia;
import progetto.model.premio.Premio;

public class Collision {
	private Mappa mappa;
	private Mario mario;
	private Game game;
	boolean vittoria = false;

	public Collision(Mappa mappa) {
		this.mappa = mappa;
		mario = mappa.getMario();
		game = Game.getInstance();
	}
	

	public void update() {
		collisioniCheck();
		mappa.aggiorna();
	}

	public boolean getVittoria() {
		return vittoria;
	}

	private void collisionMarioBandiera() {
		if (mappa.getBandiera() != null) {
			if (mario.getX() >= mappa.getBandiera().getX()) {
				mappa.getBandiera().setTouched(true);

			}

			if (mario.getX() >= mappa.getBandiera().getX() + 300) {

				vittoria = true;
			}
		}
	}
	private void collisionMarioBlocchi(ArrayList<Entita> rimuoviEntita) {

		
		ArrayList<Blocco> blocchi = mappa.getBlocchi();
		for (Blocco blocco : blocchi) {
			if ((mario.getRettangloGambe().intersects(blocco.getRettangloTesta()) && mario.getCaduta())) {
				mario.setY(blocco.getY() - mario.getDim().height + 1);
				mario.setCaduta(false);
				mario.setMuoviInY(0);
			} else if (mario.getRettanglobs().intersects(blocco.getRettanglobd())) {

				mario.setX(blocco.getX() + blocco.getDim().width);
				mario.setSpeed(0);
			} else if (mario.getRettanglobd().intersects(blocco.getRettanglobs())) {
				mario.setX(blocco.getX() - blocco.getDim().width);
				mario.setSpeed(0);

			} else if (mario.getRettangloTesta().intersects(blocco.getRettangloGambe())) {
				mario.setMuoviInY(0);
				if (blocco.getVuoto() == true) {
					if (mario.getStato() == StatoMario.GRANDE )
						rimuoviEntita.add(blocco);
				}
				mario.setY(blocco.getY() + blocco.getDim().height);
				Premio p = blocco.rivela();
				if (p != null)
					mappa.addPremio(p);
			}

		}

	}
	private void collisionMarioBase() {
		if (!mario.getSalto()) {
			mario.setCaduta(true);
		}
	}
	private void collisionNemicoBase() {
		ArrayList<Nemico> nemici = mappa.getNemici();
		for (Nemico n : nemici) {
			if (n.getY() + n.getDim().height >= 720 - 96 ) {
				n.setY(720 - 96 - n.getDim().height);
				n.setCaduta(false);
			}

		}
	}
	private void collisionMarioNemico(ArrayList<Entita> rimuoviEntita) {
		ArrayList<Nemico> nemici = mappa.getNemici();
		for (Nemico n : nemici) {
			if (!n.getMorto()) {

				if (mario.getRettangloTesta().intersects(n.getRettangloGambe())) {
					mario.setVita(mario.getVita() - 1);
					
					mario.resetPosizione();
				} else if (mario.getRettanglobd().intersects(n.getRettanglobs())) {
					mario.setVita(mario.getVita() - 1);

					mario.resetPosizione();
					break;
				} else if (mario.getRettanglobs().intersects(n.getRettanglobd())) {
					mario.setVita(mario.getVita() - 1);

					mario.resetPosizione();
				} else if (mario.getRettangloGambe().intersects(n.getRettangloTesta())) {

					n.muore();

					mario.aumentaPunti(80);

				}
			}
			if ((mario.getX() - n.getX() >= 600 && n.getMorto()) || (n.getX() - mario.getX() >= 600 && n.getMorto())) {
				rimuoviEntita.add(n);
			}

		}
	}
	private void collisionNemicoBlocchi() {
		ArrayList<Blocco> blocchi = mappa.getBlocchi();
		ArrayList<Nemico> nemici = mappa.getNemici();
		for (Nemico n : nemici) {
			boolean rimani = false;
			for (Blocco b : blocchi) {
				if (n.getRettanglobd().intersects(b.getRettanglobs())) {
					n.setSpeed(-n.getSpeed());
				} else if (n.getRettanglobs().intersects(b.getRettanglobd())) {
					n.setSpeed(-n.getSpeed());
				}

				if (n.getRettangloGambe().intersects(b.getRettangloTesta()) ) {
					n.setCaduta(false);
					n.setMuoviInY(0);
					n.setY(b.getY() - n.getDim().height);
					rimani = true;
				}
			}
			if (((n.getY() + n.getDim().height >= 720 - 96))) {
				n.setCaduta(false);
				n.setMuoviInY(0);
				n.setY((720 - 96) - n.getDim().height);
			}

			if (!rimani && n.getY() < (720 - 96)) {
				n.setCaduta(true);
			}

		}
	}
	private void collisionPremioBlocchi() {
		ArrayList<Blocco> blocchi = mappa.getBlocchi();
		ArrayList<Premio> premi = mappa.getPremi();

		for (Premio p : premi) {
			if (p instanceof Potenzia) {
				Potenzia p2 = (Potenzia) p;
				p2.setCaduta(true);

				for (Blocco b : blocchi) {

					if (p2.getCaduta() == true) {

						if (b.getRettangloTesta().intersects(p2.getRettangloGambe())) {
							p2.setCaduta(false);
							p2.setMuoviInY(0);

							p2.setY(b.getY() - p2.getDim().height + 1);
							if (b.getMuoviInY() == 0)
								b.setSpeed(+2);
						}
					}

					if (p2.getSpeed() > 0) {

						if (b.getRettanglobs().intersects(p2.getRettanglobd())) {
							p2.setSpeed(-p2.getSpeed());
						}
					} else if (p2.getSpeed() < 0) {

						if (b.getRettanglobd().intersects(p2.getRettanglobs())) {

							p2.setSpeed(+p2.getSpeed());
						}
					}
				}

				if (p2.getY() + p2.getDim().height >= 720 - 96) {
					p2.setCaduta(false);
					p2.setMuoviInY(0);
					p2.setY((720 - 96) - p2.getDim().height);
					if (p2.getSpeed() == 0)
						p2.setSpeed(2);
				}

			}
		}
	}
	private void collisionMarioPremi(ArrayList<Entita> rimuoviEntita) {
		ArrayList<Premio> premi = mappa.getPremi();
		for (Premio p : premi) {
			Potenzia p2 = (Potenzia) p;

			if (p2.getRettanglo().intersects(mario.getRettanglo())) {
				p2.collision(mario);
				rimuoviEntita.add(p2);
			}
		}
	}
	private void collisionMarioMonete(ArrayList<Moneta> monetaDaRimuovere) {
		
		for (Moneta m : mappa.getMonete()) {
			if (mario.getRettanglo().intersects(m.getRettangolo())) {

				
				game.monataSound();
				mario.aggiungiMonete();
				mario.aumentaPunti(30);
				monetaDaRimuovere.add(m);

			}
		}
	}
	
	private void collisioniCheck() {
		collisionMarioBase();
		ArrayList<Entita> rimuoviEntita = new ArrayList<>();
		ArrayList<Moneta> monetaDaRimuovere = new ArrayList<Moneta>();
		collisionMarioBandiera();
		collisionMarioBlocchi(rimuoviEntita);
		
		collisionNemicoBase();
		collisionMarioNemico(rimuoviEntita);
		collisionNemicoBlocchi();
		collisionPremioBlocchi();
		collisionMarioPremi(rimuoviEntita);
		collisionMarioMonete(monetaDaRimuovere);
		
		
		
		

	

		
		rimuovi(rimuoviEntita, monetaDaRimuovere);
	}

	public void rimuovi(ArrayList<Entita> rimuoviEntita, ArrayList<Moneta> monete) {
		for (Entita e : rimuoviEntita) {
			if (e instanceof Nemico) {
				mappa.rimuoviNemico((Nemico) e);
			} else if (e instanceof Blocco) {
				mappa.rimuoviBlocco((Blocco) e);
			} else if (e instanceof Premio) {
				mappa.rimuoviPremi((Premio) e);
			}

		}
		for (Moneta moneta : monete) {
			mappa.rimuoviMoneta(moneta);
		}

	}
}
