package progetto;


import javax.swing.JFrame;

import progetto.controller.Controller;
import progetto.util.Setting;
import progetto.view.Pannello;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(Setting.WIDTH, Setting.HEIGTH); 
		Pannello pannello = new Pannello();
		Controller controller = new Controller();
		frame.addKeyListener(controller);
		frame.addMouseListener(controller);
		frame.add(pannello);
		frame.setLocationRelativeTo(null);	
		frame.setResizable(false);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameLoop loop = new GameLoop(pannello);
		Thread thread = new Thread(loop);
		thread.start();
	}
}
