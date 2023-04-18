package progetto.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import progetto.handler.Game;
import progetto.util.Azione;
import progetto.util.IdMappa;
import progetto.util.Stato;

public class Controller implements KeyListener, MouseListener {
	private Game game = null;

	public Controller() {

		game = Game.getInstance();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_1:
			if (game.getStato() == Stato.SELEZIONA_MAPPA) {
				game.setIdMappa(IdMappa.MAPPA_1);
				game.creaMappa();
			} else if (game.getStato() == Stato.SCHERMATA_INIZIALE) {
				game.setStato(Stato.SELEZIONA_MAPPA);
			}
			else if (game.getStato() == Stato.ISTRUZIONI) {
				game.setStato(Stato.SCHERMATA_INIZIALE);
			}else if (game.getStato() == Stato.PAUSA || game.getStato() == Stato.GAME_OVER || game.getStato() == Stato.VITTORIA) {
				game.setStato(Stato.SCHERMATA_INIZIALE);
			}
			break;
		case KeyEvent.VK_2:
			if (game.getStato() == Stato.SELEZIONA_MAPPA) {
				game.setIdMappa(IdMappa.MAPPA_2);
				game.creaMappa();
			} else if (game.getStato() == Stato.SCHERMATA_INIZIALE) {
				game.setStato(Stato.ISTRUZIONI);
			}else if (game.getStato() == Stato.ISTRUZIONI) {
				game.setStato(Stato.SELEZIONA_MAPPA);
			}
			break;
		case KeyEvent.VK_3:
			if (game.getStato() == Stato.SELEZIONA_MAPPA) {
				game.setStato(Stato.SCHERMATA_INIZIALE);
			}
			break;
		case KeyEvent.VK_UP:
			game.setAzione(Azione.SALTA);
			game.movimenti();
			break;
		case KeyEvent.VK_RIGHT:
			game.setAzione(Azione.VAI_A_DESTRA);
			game.movimenti();
			break;

		case KeyEvent.VK_LEFT:
			game.setAzione(Azione.VAI_A_SINISTA);
			game.movimenti();
			break;

		case KeyEvent.VK_ESCAPE:
			if (game.getStato() == Stato.START) {
				game.setStato(Stato.PAUSA);
			} else if (game.getStato() == Stato.PAUSA) {
				game.setStato(Stato.START);
			}
			break;
		
		case KeyEvent.VK_Q:
		{
			if(game.getStato()!= Stato.START)
			{
				System.exit(0);
			}
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
			game.setAzione(Azione.STOP_AZIONE);
			game.movimenti();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int y = e.getY();
		int x = e.getX();

		if (x >= 360 && x <= 460) {
			if (y >= 300 && y <= 380) {
				if (game.getStato() == Stato.SCHERMATA_INIZIALE) {
					game.setStato(Stato.SELEZIONA_MAPPA);
					return;
				} else if (game.getStato() == Stato.PAUSA) {
					game.setStato(Stato.START);
				}
			}
			if (y >= 430 && y <= 480) {
				if (game.getStato() == Stato.SCHERMATA_INIZIALE) {
					game.setStato(Stato.ISTRUZIONI);
				} else if (game.getStato() == Stato.PAUSA) {
					game.setStato(Stato.SCHERMATA_INIZIALE);
				}
			}
			if (y >= 530 && y <= 580) {
				if (game.getStato() == Stato.SCHERMATA_INIZIALE) {
					System.exit(0);
				} else if (game.getStato() == Stato.PAUSA) {
					System.exit(0);
				}

			}
		}

		if (x >= 360 && x <= 510) {
			if (y >= 332 && y <= 380) {
				if (game.getStato() == Stato.SELEZIONA_MAPPA) {
					game.setIdMappa(IdMappa.MAPPA_1);
					game.creaMappa();
				}
			}
			if (y >= 430 && y <= 480) {
				if (game.getStato() == Stato.SELEZIONA_MAPPA) {
					game.setIdMappa(IdMappa.MAPPA_2);
					game.creaMappa();
				}
			}
			if (y >= 530 && y <= 580) {
				if (game.getStato() == Stato.SELEZIONA_MAPPA) {
					game.setStato(Stato.SCHERMATA_INIZIALE);
				}

			}
		}

		if (x >= 360 && x <= 457) {
			if (y >= 612 && y <= 659) {
				if (game.getStato() == Stato.SELEZIONA_MAPPA) {
					System.exit(0);
				}
			}
		}
		if (y >= 612 && y <= 660) {
			if (x >= 60 && x <= 210) {
				if (game.getStato() == Stato.ISTRUZIONI) {
					game.setStato(Stato.SCHERMATA_INIZIALE);
				}
			}
			if (x >= 360 && x <= 460) {
				if (game.getStato() == Stato.ISTRUZIONI) {
					System.exit(0);
				}
			}
			if (x >= 589 && x <= 753) {
				if (game.getStato() == Stato.ISTRUZIONI) {
					game.setStato(Stato.SELEZIONA_MAPPA);
					return;
				}
			}
		}

		if(x>=360 && x<=460) {
			if(y>= 426 && y <=480) {
				if (game.getStato() == Stato.GAME_OVER || game.getStato() == Stato.VITTORIA) {
					game.setStato(Stato.SCHERMATA_INIZIALE);
				}
			}else if(y>= 530 && y <=580) {
				if (game.getStato() == Stato.GAME_OVER || game.getStato() == Stato.VITTORIA) {
					System.exit(0);
				}
			}
			
		}
			
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
