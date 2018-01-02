package vn;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class TextBox extends JPanel{
	protected JLabel bg, textField;
	protected int x,y;
	protected final static Icon dialogueBox = new ImageIcon("images/DialogueBox.png");
//	private final static Color COLOR_TRANSLUCENTBLACK = new Color((float) .01, (float) .01, (float).01, (float) .8);
//	private final static Color COLOR_TRANSLUCENTWHITE = new Color((float) .99, (float) .99, (float).99, (float) .5);
	
	public TextBox(String txt, int fontSize, int x, int y, int width, int height)
	{
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);
		
		textField = new JLabel(txt);
		textField.setBounds(50,1,width-100,height);
		textField.setLayout(null);
		textField.setBorder(null);
		textField.setFont(new Font(Font.SANS_SERIF,Font.BOLD,fontSize));
		textField.setForeground(Color.CYAN);
//		textField.setIcon(dialogueBox);
//		textField.setIconTextGap(-(this.getWidth()*99/100));
		
		this.bg = new JLabel(dialogueBox);
		this.bg.setBorder(null);
		this.bg.setBounds(0,0,width,height);
		
//		this.bg.add(this.textField);
		this.add(this.textField);
		this.add(bg);
	}
	
	public void setText(String txt)
	{
		textField.setText(txt);
	}
}
