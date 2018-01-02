package vn;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements MouseListener{

	public static final int setTime = 18;
	
	private static final long serialVersionUID = 1L;
	private int ctr = setTime;
	private int hp = 100;
	private JLabel kraken;
	private JLabel rizal;
	private JLabel effect;
	private JLabel lHp;
	private JLabel lTimer;
	private JLabel lBG;
	private Timer clock;
	private int i = 0;
	private int ii = 1;
	public int sound = 0;
	public boolean rizalAlive;
	
	public GamePanel(){
		this.setBounds(0, 0, 1366, 768);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		clock = new Timer(1000, new TAtk());

		this.lBG = new JLabel(new ImageIcon("images/VN_ship.png"));
		this.lBG.setLayout(null);
		this.lBG.setBounds(0,0, this.lBG.getIcon().getIconWidth(), this.lBG.getIcon().getIconHeight());
		this.lBG.addMouseListener(this);
		
		this.lBG.setVisible(true);
		
		this.kraken = new JLabel(new ImageIcon("images/kraken_off.png"));
		this.kraken.setLayout(null);
		this.kraken.setBounds(305,110, this.kraken.getIcon().getIconWidth(), this.kraken.getIcon().getIconHeight());
		this.kraken.addMouseListener(this);
		
		this.kraken.setVisible(true);
		
		this.rizal = new JLabel(new ImageIcon("images/rizal_off_"+this.i+".png"));
		this.rizal.setLayout(null);
		this.rizal.setBounds(500,350+100, this.rizal.getIcon().getIconWidth(), this.rizal.getIcon().getIconHeight());
		this.rizal.addMouseListener(this);
		
		this.rizal.setVisible(true);
		
		this.effect = new JLabel(new ImageIcon("images/slash_"+this.i+".png"));
		this.effect.setLayout(null);
		this.effect.setBounds(450,300+100, this.effect.getIcon().getIconWidth(), this.effect.getIcon().getIconHeight());
		this.effect.addMouseListener(this);
		
		this.effect.setVisible(false);
		
		this.lHp = new JLabel(new ImageIcon("images/krakenHP_"+this.hp+".png"));
		this.lHp.setBounds(780,-50, this.lHp.getIcon().getIconWidth(), this.lHp.getIcon().getIconHeight());
		
		this.lHp.setVisible(true);
		
		this.lTimer = new JLabel("Time Left: "+this.ctr+" secs");
		this.lTimer.setBounds(100,10, 239, 39);
		this.lTimer.setForeground(Color.WHITE);
		this.lTimer.setFont(new Font("BEBASNEUE", Font.PLAIN, 40)); 
		
		this.lTimer.setVisible(true);
		
		this.add(this.lHp);
		
		this.add(this.rizal);
		
		this.add(this.effect);
		
		this.add(this.kraken);
		
		this.add(this.lTimer);
		
		this.add(lBG);
		
		this.setVisible(true);
		
	}
	
	
	private class TAtk implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ctr-= 1;
			lTimer.setText("Time Left: "+ctr+" secs");
				
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
		
		if(arg0.getSource() == this.kraken || arg0.getSource() == this.rizal){
			if(ctr > 0 && hp > 0){
				this.kraken.setIcon(new ImageIcon("images/kraken_on.png"));
				this.rizal.setIcon(new ImageIcon("images/rizal_on_"+this.ii+".png"));
				this.effect.setIcon(new ImageIcon("images/slash_"+this.i+".png"));
				switch(ii){
				case 0: this.ii= 1;break;
				case 1: this.ii= 0;break;
				}
			}
			if(!this.clock.isRunning()){
				this.clock.start();
				this.effect.setVisible(true);
			}
			if(this.clock.isRunning() && (ctr <= 0 || this.hp <= 0)){
				this.clock.stop();
				if(ctr <= 0)
					Frame.battle.rizalAlive = false;
				else
					Frame.battle.rizalAlive = true;
				this.effect.setVisible(false);
				Frame.cl.show(Frame.current, "First Scene");
			}
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getSource() == this.kraken|| arg0.getSource() == this.rizal)
			if(ctr > 0 && hp > 0){
				this.hp -= 1;
//				if(!Frame.krackenHurt1.getClip(). || !Frame.krackenHurt2.getClip().isActive() || !Frame.krackenHurt3.getClip().isActive() || !Frame.krackenHurt4.getClip().isActive())
//				{
//					switch(sound)
//					{
//					case 1: Frame.krackenHurt2.play(0);break;
//					case 2: Frame.krackenHurt3.play(0);break;
//					case 3: Frame.krackenHurt4.play(0);break;
//						default: Frame.krackenHurt1.play(0);
//					}
//					if(sound < 3)
//						sound = 0;
//					else sound++;
//				}
				if(Frame.krackenHurt1.getClip().isRunning())
					Frame.krackenHurt1.stop();
				if(Frame.krackenHurt2.getClip().isRunning())
					Frame.krackenHurt2.stop();
				if(Frame.krackenHurt3.getClip().isRunning())
					Frame.krackenHurt3.stop();
				if(Frame.krackenHurt4.getClip().isRunning())
					Frame.krackenHurt4.stop();
				switch(sound)
				{
				case 1: Frame.krackenHurt2.play(0);break;
				case 2: Frame.krackenHurt3.play(0);break;
				case 3: Frame.krackenHurt4.play(0);break;
					default: Frame.krackenHurt1.play(0);
				}
				if(sound > 3)
					sound = 0;
				else sound++;
				this.lHp.setIcon(new ImageIcon("images/krakenHP_"+this.hp+".png"));
				this.kraken.setIcon(new ImageIcon("images/kraken_off.png"));
				this.rizal.setIcon(new ImageIcon("images/rizal_off_"+this.i+".png"));
				this.effect.setIcon(new ImageIcon("images/slash_"+this.i+".png"));
				switch(i){
				case 0: this.i= 1;break;
				case 1: this.i= 0;break;
				}
			}
		if(this.clock.isRunning() && (ctr <= 0 || this.hp <= 0)){
			this.clock.stop();
			if(ctr <= 0)
				Frame.battle.rizalAlive = false;
			else
				Frame.battle.rizalAlive = true;
			System.out.println(rizalAlive);
			this.effect.setVisible(false);
			Frame.cl.show(Frame.current, "First Scene");
		}
	}



	public int getCtr() {
		return ctr;
	}



	public void setCtr(int ctr) {
		this.ctr = ctr;
	}



	public int getHp() {
		return hp;
	}



	public void setHp(int hp) {
		this.hp = hp;
	}



	public JLabel getKraken() {
		return kraken;
	}



	public void setKraken(JLabel kraken) {
		this.kraken = kraken;
	}



	public JLabel getRizal() {
		return rizal;
	}



	public void setRizal(JLabel rizal) {
		this.rizal = rizal;
	}



	public JLabel getEffect() {
		return effect;
	}



	public void setEffect(JLabel effect) {
		this.effect = effect;
	}



	public JLabel getlHp() {
		return lHp;
	}



	public void setlHp(JLabel lHp) {
		this.lHp = lHp;
	}



	public JLabel getlTimer() {
		return lTimer;
	}



	public void setlTimer(JLabel lTimer) {
		this.lTimer = lTimer;
	}



	public JLabel getlBG() {
		return lBG;
	}



	public void setlBG(JLabel lBG) {
		this.lBG = lBG;
	}



	public Timer getClock() {
		return clock;
	}



	public void setClock(Timer clock) {
		this.clock = clock;
	}



	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public int getIi() {
		return ii;
	}



	public void setIi(int ii) {
		this.ii = ii;
	}



	public static int getSettime() {
		return setTime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public boolean isRizalAlive() {
		return rizalAlive;
	}



	public void setRizalAlive(boolean rizalAlive) {
		this.rizalAlive = rizalAlive;
	}
	
}
