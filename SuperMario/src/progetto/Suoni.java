package progetto;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Suoni {
	

	    public Suoni() {
	      
	    }

	    private AudioInputStream loadAudio(String str) {
	        try {
	            InputStream audioSrc = getClass().getResourceAsStream("resources"+File.separator + "suoni" +File.separator+ str + ".wav");
	            InputStream bufferedIn = new BufferedInputStream(audioSrc);
	            return AudioSystem.getAudioInputStream(bufferedIn);

	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }

	        return null;
	    }

	    private Clip getClip(AudioInputStream stream) {
	        try {
	            Clip clip = AudioSystem.getClip();
	            clip.open(stream);
	            return clip;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	  

	 

	    public void playJump() {
	        Clip clip = getClip(loadAudio("jump"));
	        clip.start();

	    }

	    public void playCoin() {
	        Clip clip = getClip(loadAudio("coin"));
	        clip.start();

	    }

	

	    public void playGameOver() {
	        Clip clip = getClip(loadAudio("gameOver"));
	        clip.start();

	    }

	    

	    public void playFungoVita() {
	        Clip clip = getClip(loadAudio("oneUp"));
	        clip.start();

	    }

	    public void playSuperFungo() {

	        Clip clip = getClip(loadAudio("superMushroom"));
	        clip.start();

	    }

	    public void playMarioDie() {

	        Clip clip = getClip(loadAudio("marioDies"));
	        clip.start();

	    }
}
