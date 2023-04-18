package progetto;

import progetto.handler.Game;
import progetto.util.Stato;
import progetto.view.Pannello;

public class GameLoop extends Thread{
	
	private Pannello pannello;
	private Game game = Game.getInstance();
	public GameLoop(Pannello pannello) {
		this.pannello = pannello;
		
	}
	
	@Override
	public void run() {
		while(true) {
			pannello.aggiorna();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(game.getStato() == Stato.START) {
				game.aggiorna();
			}
		}
	}
}
