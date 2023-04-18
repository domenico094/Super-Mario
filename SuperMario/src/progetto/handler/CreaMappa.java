package progetto.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import progetto.LoadResources;
import progetto.model.Mappa;
import progetto.model.blocco.Blocco;
import progetto.model.blocco.BloccoFragile;
import progetto.model.blocco.BloccoIndistruttibile;
import progetto.model.blocco.BloccoSorpresa;
import progetto.model.blocco.BloccoTerra;
import progetto.model.nemico.Goomba;
import progetto.model.nemico.Nemico;
import progetto.model.nemico.Turtle;
import progetto.model.premio.FungoVita;
import progetto.model.premio.Moneta;
import progetto.model.premio.Premio;
import progetto.model.premio.SuperFungo;

public class CreaMappa {

	private BufferedImage background;
	private BufferedImage terra;
	private BufferedImage goombaD;
	private BufferedImage goombaS;
	private BufferedImage goombaM;
	private BufferedImage turtleD;
	private BufferedImage turtleS;
	private BufferedImage turtleM;
	private BufferedImage bloccoI;
	private BufferedImage bloccoF;
	private BufferedImage bloccoS;
	private BufferedImage bloccoS2;
	private BufferedImage moneta;

	private BufferedImage b;

	LoadResources load = LoadResources.getInstance();

	public CreaMappa() {
	}

	private ArrayList<ArrayList<Integer>> map;

	public Mappa generaMappa(String resources, String pathFile) {
		Mappa mappa = new Mappa();
		initMatrix(pathFile);

		setImmagini(resources);
		mappa.setBackground(background);
		for (int y = 0; y < map.size(); y++) {
			for (int x = 0; x < map.get(0).size(); x++) {
				if (map.get(y).get(x) == 9) {
					Blocco bloccoTerra = new BloccoTerra(x * 48, y * 48, this.terra);
					mappa.addBlocco(bloccoTerra);
				} else if (map.get(y).get(x) == 2) {
					Blocco brick = new BloccoFragile(x * 48, y * 48, bloccoF);
					mappa.addBlocco(brick);
				} else if (map.get(y).get(x) == 1) {
					mappa.creaMario(x * 48, y * 48);

				} else if (map.get(y).get(x) == 6) {
					Blocco bloccoI = new BloccoIndistruttibile(x * 48, y * 48, this.bloccoI);
					mappa.addBlocco(bloccoI);
				} else if (map.get(y).get(x) == 4) {
					Nemico nemico = new Goomba(x * 48, y * 48, goombaD, goombaS, goombaM);

					mappa.addNemico(nemico);
				} else if (map.get(y).get(x) == 5) {
					Nemico nemico = new Turtle(x * 48, y * 48, turtleD, turtleS, turtleM);

					mappa.addNemico(nemico);
				}

				else if (map.get(y).get(x) == 3) {
					Premio premio = generaPremio(x * 48, y * 48);
					Blocco b = new BloccoSorpresa(x * 48, y * 48, premio, bloccoS, bloccoS2);
					mappa.addBlocco(b);
				}

				else if (map.get(y).get(x) == 8) {
					Moneta m2 = new Moneta(x * 48, y * 48, moneta);
					mappa.addMoneta(m2);
				} else if (map.get(y).get(x) == 7) {
					mappa.setBandiera((x * 48)+15, y * 48, b);
				}

			}
		}
		return mappa;
	}

	public void initMatrix(String file) {

		map = load.getMappa(file);

	}

	public void setImmagini(String str) {
		background = load.getMyImage(str + File.separator + "mappa.png");
		terra = load.getMyImage(str + File.separator + "terra.png");
		goombaD = load.getMyImage(str + File.separator + "goombaD.png");
		goombaS = load.getMyImage(str + File.separator + "goombaS.png");
		goombaM = load.getMyImage(str + File.separator + "goombaMorto.png");
		turtleD = load.getMyImage(str + File.separator + "turtleD.png");
		turtleS = load.getMyImage(str + File.separator + "turtleS.png");
		turtleM = load.getMyImage(str + File.separator + "turtleM.png");
		bloccoI = load.getMyImage(str + File.separator + "bloccoIndistruttibile.png");
		bloccoF = load.getMyImage(str + File.separator + "bloccoFragile.png");
		bloccoS = load.getMyImage(str + File.separator + "bloccoS.png");
		bloccoS2 = load.getMyImage(str + File.separator + "bloccoS2.png");
		moneta = load.getMyImage("resources" + File.separator + "moneta.png");
		b = load.getMyImage(str + File.separator + "bandiera.png");
	}

	private Premio generaPremio(int x, int y) {
		Premio premio = null;
		Random r = new Random();
		int random = r.nextInt(2);
		if (random == 0) {
			premio = new SuperFungo(x, y);
		} else if (random == 1) {
			premio = new FungoVita(x, y);
		}

		return premio;
	}

}
