package vn;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	public static int LOOP = Clip.LOOP_CONTINUOUSLY;
	private Clip clip;
	private String source;

	public Audio(String soundAddress) {
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip.flush();
			clip.open(AudioSystem.getAudioInputStream(new File(soundAddress)));
			source = soundAddress;
		} catch(Exception e) {
			source = null;
			e.printStackTrace();
		}
	}
	public String getSource() {
		return source;
	}
	public Clip getClip() {
		return clip;
	}
	public void play(int rep) {
		clip.loop(rep);
	}
	public void stop() {
		clip.stop();
		clip.setFramePosition(0);
	}
}