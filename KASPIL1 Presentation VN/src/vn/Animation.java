package vn;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Animation extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final static Icon ghoulEnd0 = new ImageIcon("images/ghoul end_0.png");
	protected final static Icon ghoulEnd1 = new ImageIcon("images/ghoul end_1.png");
	protected JLabel bg;
	
	Timer timer = new Timer(1000/24, new TimerListener());
	
	protected int counter = 0;
	
	public Animation()
	{
		this.setLayout(null);
		this.setBounds(0, 0, 1366, 768);
//		this.setBackground(Color.BLACK);
		
		this.bg = new JLabel();
		this.bg.setIcon(ghoulEnd0);
		this.bg.setBounds(0, 0, 1366, 768);
		
		this.add(this.bg);
		this.setVisible(true);
		this.bg.setVisible(true);
	}
	
	public void start()
	{
		this.timer.start();
	}
	
	public void stop()
	{
		this.timer.stop();
	}
	
	private class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(counter)
			{
			case 2:
			case 4:
			case 8:
			case 10:
			case 11:
			case 15: bg.setVisible(false);break;
			case 1:
			case 3:
			case 5:
			case 6: 
			case 7: 
				bg.setVisible(true);
				bg.setIcon(ghoulEnd0);break;
			case 9:
			case 12:
			case 13:
			case 14: 
				bg.setVisible(true);
				bg.setIcon(ghoulEnd1);break;
			}
			if(counter < 15) counter++;
			else counter = 0;
			System.out.println(counter);
		}
		
	}
}
