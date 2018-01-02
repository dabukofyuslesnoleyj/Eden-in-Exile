package vn;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Frame extends JFrame{
	protected JButton start,exit;
	protected JLabel bg;
	protected static GamePanel battle;
	protected static JPanel current, mainMenu;
	protected Scene scene;
	
	public static CardLayout cl = new CardLayout();
	
	public static Audio homeBG = new Audio("src/vn/main_BG.wav");
	public static Audio manilaBGM = new Audio("src/vn/Manila_Theme.wav");
	public static Audio solitudeTheme = new Audio("src/vn/Solitude_Theme.wav");
	public static Audio everydayTheme = new Audio("src/vn/Everyday_Theme.wav");
	public static Audio gentleTheme = new Audio("src/vn/Gentle_Theme.wav");
	public static Audio darkTheme = new Audio("src/vn/Dark_Theme.wav");
	public static Audio sadTheme = new Audio("src/vn/Sad_Theme.wav");
	public static Audio finalMoments = new Audio("src/vn/Final_Moments.wav");
	public static Audio suspicion = new Audio("src/vn/Suspicion.wav");
	public static Audio clicked = new Audio("src/vn/Button_Clicked.wav");
	public static Audio fuego = new Audio("src/vn/Fuego.wav");
	public static Audio krackenBattle = new Audio("src/vn/Kracken_Battle.wav");
	public static Audio unravel = new Audio("src/vn/unravel - Ghoul Ending.wav");
	public static Audio krackenHurt1 = new Audio("src/vn/VN_krackenHurt1.wav");
	public static Audio krackenHurt2 = new Audio("src/vn/VN_krackenHurt2.wav");
	public static Audio krackenHurt3 = new Audio("src/vn/VN_krackenHurt3.wav");
	public static Audio krackenHurt4 = new Audio("src/vn/VN_krackenHurt4.wav");
	public static Audio krackenEndingMusic = new Audio("src/vn/VN_krackenEndMusic.wav");
	
	protected final static Icon mainMenuBG = new ImageIcon("images/home_BG.png");
	protected final static Icon buttonBeginOn = new ImageIcon("images/bBegin_on.png");
	protected final static Icon buttonBeginOff = new ImageIcon("images/bBegin_off.png");
	protected final static Icon buttonExitOn = new ImageIcon("images/bExit_on.png");
	protected final static Icon buttonExitOff = new ImageIcon("images/bExit_off.png");
	
	public Frame()
	{
		this.setLayout(null);
		this.setTitle("Rizal VN");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		int xSize = ((int) tk.getScreenSize().getWidth());
//		int ySize = ((int) tk.getScreenSize().getHeight());
//		this.setSize(1366,875);
		this.setBounds(0, 0, 1366, 768);
		this.setUndecorated(true);
		
		this.mainMenu = new JPanel();
		this.mainMenu.setLayout(null);
		this.mainMenu.setBounds(0,0,1366,875);
		this.setVisible(true);
		
		this.bg = new JLabel(mainMenuBG);
		this.bg.setBounds(0,0,1366,768);
		
		this.start = new JButton(buttonBeginOff);
		this.start.setLayout(null);
		this.start.setBorder(null);
		this.start.setBounds(473, 483, buttonBeginOff.getIconWidth(), buttonBeginOff.getIconHeight());
		this.start.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				start.setIcon(buttonBeginOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				start.setIcon(buttonBeginOff);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				homeBG.stop();
				Frame.clicked.play(0);
				scene = new Scene(1366,768);
				battle = new GamePanel();
				
				current.add(battle,"Kracken Battle");
				current.add(scene,"First Scene");
				cl.show(current, "First Scene");
				
			}
		});
		this.mainMenu.add(this.start);
		
		this.exit = new JButton(buttonExitOff);
		this.exit.setLayout(null);
		this.exit.setBorder(null);
		this.exit.setBounds(473, 627, buttonExitOff.getIconWidth(), buttonExitOff.getIconHeight());
		this.exit.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				exit.setIcon(buttonExitOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				exit.setIcon(buttonExitOff);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				Frame.clicked.play(0);
				System.exit(0);
			}
		});
		this.mainMenu.add(this.exit);
		
		this.current = new JPanel();
		this.current.setLayout(cl);
		this.current.setBounds(this.getBounds());
		this.add(this.current);
		this.current.setVisible(true);
		
		
		this.setVisible(true);
		
		this.current.add(this.mainMenu,"Main Menu");
		
		this.cl.show(this.current, "Main Menu");
		
		this.mainMenu.add(this.bg);
		
		this.start.setVisible(true);
		this.exit.setVisible(true);
		this.bg.setVisible(true);
		this.setVisible(true);
		
		Frame.homeBG.play(999);
	}
	
	public static void main(String[] args)
	{
		Frame game = new Frame();
	}
}
