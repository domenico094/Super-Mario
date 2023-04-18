package progetto;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import progetto.util.StatoMario;

public class LoadResources {

	private static LoadResources instance = null;
	private BufferedImage source;
	public int w;
	public int h;
	private LoadResources() {
		source = getMyImage("resources" + File.separator + "mario.png");
		
	}

	public BufferedImage getMyImage(String str) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResourceAsStream(str));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return img;
	}

	
	
	
	public BufferedImage[] getMarioDestra(StatoMario stato) {

		BufferedImage[] img = new BufferedImage[5];
		int col=0, width=0, height=0;
		if(stato == StatoMario.NORMALE) 
		{col = 2;
		 width = 48; height = 48;

		}else	if (stato == StatoMario.GRANDE) { 
			col = 5;
			width = 48;
			height = 96;
		}  
			for (int i = 0; i < 5; i++) {
				img[i] = source.getSubimage((col-1) * width, (i) * height, width, height);
			}
		

		return img;
	}

	public BufferedImage[] getMarioSinistra(StatoMario stato) {
		BufferedImage[] img = new BufferedImage[5];

		int col = 1;
		int width = 48, height = 48;

		if (stato == StatoMario.GRANDE) { 
			col = 4;
			width = 48;
			height = 96;
		} 
			for (int i = 0; i < 5; i++) {
				img[i] = source.getSubimage((col - 1) * width, (i) * height, width, height);
			}
		
		return img;
	}
	
	

	public ArrayList<ArrayList<Integer>> getMappa(String file){
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader (file) ) ) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.isEmpty())
					continue;

				ArrayList<Integer> riga = new ArrayList<>();
				String[] val = linea.trim().split(" ");
				for (String str : val) {
					if (!str.isEmpty()) {
						int id = Integer.parseInt(str);
						riga.add(id);
					}
				}
				temp.add(riga);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static LoadResources getInstance() {
		if (instance == null)
			instance = new LoadResources();
		return instance;
	}
	
	

}
