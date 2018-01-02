package vn;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Scene extends JPanel implements MouseListener{
//	protected JPanel dialogueBox;
//	protected JLabel dialogue;
	protected TextBox dialogue;
	protected TextBox nameBox;
	protected JLabel bg;
	protected JLabel sprites;
	protected JLabel man, woman, woman2, woman3, woman4;
	protected int dialogueTurn = 439, ending;
	protected TextBox[] options;
	protected Animation animation;
	
	protected final static Icon brackenCasual = new ImageIcon("images/bracken_casual.png");
	protected final static Icon brackenHappy = new ImageIcon("images/bracken_happy.png");
	protected final static Icon brackenMad = new ImageIcon("images/bracken_mad.png");
	protected final static Icon brackenSad = new ImageIcon("images/bracken_sad.png");
	protected final static Icon brackenGhoul = new ImageIcon("images/bracken_ghoul.png");
	protected final static Icon brackenKracken = new ImageIcon("images/kraken_off.png");
	protected final static Icon gent = new ImageIcon("images/extras_boy_G.png");
	protected final static Icon katipunero = new ImageIcon("images/extras_boy_Bl.png");
	protected final static Icon gent2 = new ImageIcon("images/extras_boy_B.png");
	protected final static Icon priest = new ImageIcon("images/extras_priest.png");
	protected final static Icon guard = new ImageIcon("images/extras_guard.png");
	protected final static Icon lady = new ImageIcon("images/extras_girl_Y.png");
	protected final static Icon lady2 = new ImageIcon("images/extras_girl_B.png");
	protected final static Icon lady3 = new ImageIcon("images/extras_girl_Bl.png");
	protected final static Icon lady4 = new ImageIcon("images/extras_girl_R.png");
	
	protected final static Icon manila_docks = new ImageIcon("images/VN_ManilaDocks.png");
	protected final static Icon manila = new ImageIcon("images/VN_Manila.png");
	protected final static Icon inRizalHouse = new ImageIcon("images/VN_RizalHouseIn.png");
	protected final static Icon sunset = new ImageIcon("images/VN_DapitanSunset.png");
	protected final static Icon coastNight = new ImageIcon("images/VN_DapitanCoastNight.png");
	protected final static Icon outRizalHouse = new ImageIcon("images/VN_RizalHouseOut.png");
	protected final static Icon coast = new ImageIcon("images/VN_DapitanCoast.png");
	protected final static Icon poem = new ImageIcon("images/VN_LetterPoem.png");
	protected final static Icon rizalResidenceOut = new ImageIcon("images/VN_RizalResidence.png");
	protected final static Icon rizalResidenceIn = new ImageIcon("images/VN_RizalResidenceIn.png");
	protected final static Icon letter = new ImageIcon("images/VN_Letter.png");
	protected final static Icon execution = new ImageIcon("images/VN_execution.jpg");
	protected final static Icon prisonCell = new ImageIcon("images/VN_PrisonCell.png");
	protected final static Icon shipDeck = new ImageIcon("images/VN_ShipDeck.png");
	protected final static Icon bedroomTypical = new ImageIcon("images/VN_bedroomTypical.png");
	protected final static Icon blackscreen = new ImageIcon("images/blackscreen.png");
	protected final static Icon ghoulEat = new ImageIcon("images/ghoul eat.png");
	protected final static Icon trueEnding = new ImageIcon("images/Ending_True.png");
	protected final static Icon krackenEnding = new ImageIcon("images/Ending_Kraken.png");
	protected final static Icon ghoulEnding = new ImageIcon("images/Ending_Ghoul.png");
	
	protected int affection = 0;
	
	public Scene(int width, int height)
	{
		width *= 0.9;
		height *= 0.9;
		this.setBounds(0, 0, width, 875);
		this.setLayout(null);
		
		this.bg = new JLabel(manila_docks);
		this.bg.setBounds(0,0,1366,768);
		this.add(this.bg);
		
		this.options = new TextBox[3];
		this.options[0] = new TextBox(" ",25,200,95,988,60);
		this.bg.add(this.options[0]);
		this.options[0].addMouseListener(this);
		this.options[0].setVisible(false);
		
		this.options[1] = new TextBox(" ",25,200,185,988,60);
		this.bg.add(this.options[1]);
		this.options[1].addMouseListener(this);
		this.options[1].setVisible(false);
		
		this.options[2] = new TextBox(" ",25,200,275,988,60);
		this.bg.add(this.options[2]);
		this.options[2].addMouseListener(this);
		this.options[2].setVisible(false);
		
		this.sprites = new JLabel(brackenCasual);
		this.sprites.setBounds(this.bg.getWidth()-brackenMad.getIconWidth()-100, this.bg.getHeight()-brackenMad.getIconHeight(), brackenMad.getIconWidth(), brackenMad.getIconHeight());
		
		this.man = new JLabel(gent);
		this.man.setBounds(100, this.bg.getHeight()-gent.getIconHeight(), gent.getIconWidth(), gent.getIconHeight());
		
		this.woman = new JLabel(lady);
		this.woman.setBounds(100, this.bg.getHeight()-lady.getIconHeight(), lady.getIconWidth(), lady.getIconHeight());
		this.woman2 = new JLabel(lady2);
		this.woman2.setBounds(100, this.bg.getHeight()-lady.getIconHeight(), lady.getIconWidth(), lady.getIconHeight());
		this.woman3 = new JLabel(lady3);
		this.woman3.setBounds(100, this.bg.getHeight()-lady.getIconHeight(), lady.getIconWidth(), lady.getIconHeight());
		this.woman4 = new JLabel(lady4);
		this.woman4.setBounds(100, this.bg.getHeight()-lady.getIconHeight(), lady.getIconWidth(), lady.getIconHeight());
		
		this.nameBox = new TextBox("???",25,50,height*2/3-50,250,50);
		this.bg.add(this.nameBox);
		
		this.dialogue = new TextBox("", 25, 50, height*2/3, 1266, 256);
		this.setDialogue(dialogueTurn);
		this.dialogue.setFocusable(true);
		this.bg.add(this.dialogue);
		this.bg.add(this.sprites);
		this.bg.add(this.man);
		this.bg.add(this.woman);
		this.bg.add(this.woman2);
		this.bg.add(this.woman3);
		this.bg.add(this.woman4);
//		this.dialogueBox = new JPanel();
//		this.dialogueBox.setLayout(null);
//		this.dialogueBox.setBounds(50, height*2/3, width-100, height/3);
//		this.dialogueBox.setBackground(new Color((float) .01, (float) .01, (float).01, (float) .8));
//		this.bg.add(this.dialogueBox);
//		
//		this.dialogue = new JLabel();
//		this.dialogue.setLayout(null);
//		this.dialogue.setBounds(this.dialogueBox.getBounds());
//		this.dialogue.setFont(new Font(Font.SERIF,Font.PLAIN,25));
//		this.dialogue.setForeground(Color.BLACK);
//		this.bg.add(this.dialogue);
//		this.setDialogue(this.dialogueTurn);
		
		this.animation = new Animation();
		this.bg.add(this.animation);
		this.animation.setVisible(false);
		this.animation.setFocusable(false);
		
		this.addMouseListener(this);
		
//		this.dialogueBox.setVisible(true);
//		this.dialogue.setVisible(true);
		this.bg.setVisible(true);
		this.sprites.setVisible(false);
		this.man.setVisible(false);
		this.woman.setVisible(false);
		this.woman2.setVisible(false);
		this.woman3.setVisible(false);
		this.woman4.setVisible(false);
		this.dialogue.setVisible(true);
		this.nameBox.setVisible(false);
		this.setVisible(true);
	}

//	public JPanel getDialogueBox() {
//		return dialogueBox;
//	}
//	
//	public void setDialogueBox(JPanel dialogueBox)
//	{
//		this.dialogueBox = dialogueBox;
//	}
//
//	public JLabel getDialogue()
//	{
//		return this.dialogue;
//	}
//	
	/**
	 * @param dialogueNum
	 */
	public void setDialogue(int dialogueNum) {
		switch(dialogueNum)
		{
		case 0://Scene 1
			Frame.manilaBGM.play(999);
			this.dialogue.setText("<html>Ships line the docks of the port of Manila. Sailors, passengers, crewmen, and others roam about the area. Just from how they dress, one could tell what class they belong.</html>");
			break;
		case 1:
			this.man.setVisible(true);
			this.sprites.setVisible(true);
			this.dialogue.setText("<html>Two people in particular have just left the ship they came from. They were a father and daughter clearly of European origins.</html>");
			break;
		case 2:
			this.dialogue.setText("<html>The young girl was in her teens. Quite energetic just from how she moved. It didn’t bother her the slightest even if she wore a scarlet corset. However, she didn’t stood out from the crowd. Brown hair and blue eyes, her appearance was very common.</html>");
			break;
		case 3:
			this.nameBox.setVisible(true);
			this.bg.setIcon(manila);
			this.dialogue.setText("<html>\"So this is Manila!\"</html>");
			break;
		case 4:
			this.dialogue.setText("<html>\"Josephine...\"</html>");
			break;
		case 5:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Just as the girl named Josephine gazed at the sight of the capital’s port area, an old man walks closely behind her with cane in hand.</html>");
			break;
		case 6:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Don’t worry, father. Just a little more. We’ll get your eyes good and lookin’ in no time!\"</html>");
			break;
		case 7:
			this.nameBox.setText("Father");
			this.dialogue.setText("<html>\"Ah, yes… That’d be great but… Could you at least let me rest?...\"</html>");
			break;
		case 8:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>The old man tries to catch his breath.</html>");
			break;
		case 9:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Walking with my age and declining eyesight is already pushing my best…\"</html>");
			break;
		case 10:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("\"You can handle it! You’re a man!\"");
			break;
		case 11:
			this.nameBox.setText("Father");
			this.dialogue.setText("\"But!...\"");
			break;
		case 12:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("\"YOU. CAN. HANDLE. IT. RIGHT?\"");
			break;
		case 13:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Just then, a dark sinister aura slipped past her cheerful demeanor…");
			break;
		case 14:
			this.nameBox.setText("Father");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Yes, yes, I can… Heavens. You don’t have to remind me how you chased her out of the house…\"");
			break;
		case 15:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Huh? Whatever are you talking about, Father? I don’t remember us owning a bitch.\"");
			break;
		case 16:
			this.nameBox.setText("Father");
			this.dialogue.setText("\"Urk… Anyway, how are we supposed to find this Dr. Rizal?\"");
			break;
		case 17:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Well… According to the tip we got from Hong Kong, he should be at a place called Dapitan. And that’s supposed to be at an island south of this archipelago.\"</html>");
			break;
		case 18:
			this.nameBox.setText("Father");
			this.dialogue.setText("<html>\"Another boat ride, I see. Why don’t we have a snack before we look for one?\"</html>");
			break;
		case 19:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("\"Your health comes first!\"");
			break;
		case 20:
			this.nameBox.setVisible(false);
			this.dialogue.setText("*Stomach Growls*");
			break;
		case 21:
			this.nameBox.setVisible(true);
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("\"Ah! Look at those! They look scrumptious! We should go eat there!\"");
			break;
		case 22:
			this.nameBox.setText("Father");
			this.dialogue.setText("\"…\"");
			break;
		case 23://Scene 2
			this.nameBox.setVisible(false);
			this.sprites.setVisible(false);
			this.man.setVisible(false);
			this.bg.setIcon(inRizalHouse);
			Frame.manilaBGM.stop();
			Frame.solitudeTheme.play(999);
			this.dialogue.setText("Dapitan; Sunset…");
			break;
		case 24:
			this.nameBox.setText("???");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"… Here one cannot be honest and keep out of jail…\"");
			break;
		case 25:
			this.dialogue.setText("\"*sigh*\"");
			break;
		case 26:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>By the coast in a cottage, a man lets a long sigh as he pauses after reading a book. It was a book he himself authored. At its cover wrote ‘Noli Me Tangere’ and the name ‘J. Rizal’.</html>");
			break;
		case 27:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"It seems I am no different from my fiction…\"");
			break;
		case 28:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Another day in exile, Jose Rizal spends a life of relative tranquility here in Dapitan. Far from the chaos that has been plaguing the country and his life, this respite is nothing short of paradise… Except…</html>");
			break;
		case 29:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I’m bored…\"");
			break;
		case 30:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>He isn’t necessarily one that would get bored. But the absence of company or recreation in his paradise has left him like Adam when he first woke up in Eden.</html>");
			break;
		case 31:
			this.dialogue.setText("<html>Where he stayed was also his clinic. He served as a doctor after all. But today met no patient for him to treat. Indeed, he was a man left nothing to do…</html>");
			break;
		case 32:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"But I wonder…\"");
			break;
		case 33:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Jose looks to the sunset…");
			break;
		case 34:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"How fares my mother land while I remain here in tranquility? If only I could offer her a piece of this peace… But would it be enough?\"</html>");
			break;
		case 35:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Troubled, he shut his book and places it on the desk. He stood up for another walk along the coast.</html>");
			break;
		case 36:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Maybe a little sea breeze could busy my mind…\"");
			break;
		case 37:
			this.nameBox.setVisible(false);
			this.bg.setIcon(sunset);
			this.dialogue.setText("<html>And so a stroll by the shore he did. The salt in the air. The sand on his feet. His kicks on the earth send dust to the air. Playful it may seem but solitude’s cure is what he needs.</html>");
			break;
		case 38:
			this.dialogue.setText("<html>Eventually, he sat down on the sandy beach. From then on, he would gaze at the sunset till night wakes up the darkness…</html>");
			break;
		case 39:
			this.bg.setIcon(coastNight);
			break;
		case 40:
			this.dialogue.setText("In the midst of the nighttime shadows, he whispers…");
			break;
		case 41:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"If only God were to provide an Eve, then…\"");
			break;
		case 42://Scene 3
			Frame.solitudeTheme.stop();
			this.bg.setIcon(inRizalHouse);
			Frame.everydayTheme.play(999);
			this.nameBox.setVisible(false);
			this.dialogue.setText("February 5, 1895.");
			break;
		case 43:
			this.dialogue.setText("<html>Another day; another tranquil morning in exile. Jose goes about his morning as usual. With a cup of coffee and bread in his hands, he takes his breakfast while the morning sunshine blessed the new day.</html>");
			break;
		case 44:
			this.dialogue.setText("After finishing his breakfast, the solemn man prepares to start his plans for the day.");
			break;
		case 45:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"While the morning is fresh, I can take the liberty of checking the environment here.\"");
			break;
		case 46:
			this.dialogue.setText("\"There may be other species yet to be discovered in that area I checked.\"");
			break;
		case 47:
			this.nameBox.setVisible(false);
			this.dialogue.setText("As Jose was preparing his gear, a girl calls for his professional attendance.");
			break;
		case 48:
			this.nameBox.setText("Jospehine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Doctor Rizal!!! Is this the home of Doctor Rizal?!!!\"");
			break;
		case 49:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Her voice reverberated throughout the quiet hut where Jose lived.");
			break;
		case 50:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Doctor? A patient, I see.\"");
			break;
		case 51:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Jose places his gear on his desk and checks his would be patient.");
			break;
		case 52:
			this.bg.setIcon(outRizalHouse);
			this.man.setVisible(true);
			this.sprites.setIcon(brackenCasual);
			this.sprites.setVisible(true);
			this.dialogue.setText("<html>Upon arriving at his hut’s front steps, he spots an elderly man accompanied by a girl. In just one glance, Jose knew who the patient was.</html>");
			break;
		case 53:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Yes, I am the doctor here. What seems to be the problem with your eyes, sir?\"");
			break;
		case 54:
			this.nameBox.setText("Father");
			this.dialogue.setText("\"Ah, yes. You see-\"");
			break;
		case 55:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"He has double cataract and we want you to make his eyes better again.\"");
			break;
		case 56:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I… see. Come right in.\"");
			break;
		case 57:
			this.nameBox.setVisible(false);
			this.bg.setIcon(inRizalHouse);
			this.dialogue.setText("<html>The two are welcomed in. Jose leads the elderly man to his operating area while he asks for the man’s credentials.</html>");
			break;
		case 58:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Alright, good sir. May I ask for your name and age?\"");
			break;
		case 59:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Edward. Edward Taufer. 63 years old.\"");
			break;
		case 60:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("\"Marie Josephine Leopoldine Bracken. 17 years old!\"");
			break;
		case 61:
			this.nameBox.setVisible(false);
			this.options[0].setText("\"Hm? So you were adopted after all.\"");
			this.options[0].setVisible(true);
			this.options[1].setText("\"She’s your fling?\"");
			this.options[1].setVisible(true);
			this.options[2].setText("\"Shut up.\"");
			this.options[2].setVisible(true);
			this.dialogue.setText("Jose realizes that they do not share the same surname…");
			break;
		case 62:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Yes. I am her godfather. I took her in shortly after her biological mother died from giving birth to her.\"</html>");
			break;
		case 63:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenSad);
			this.dialogue.setText("<html>\"It wasn’t easy living with him, though. Especially having the luck of taking care of a dependent father that got widowed for the second time.\"</html>");
			break;
		case 64:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"It was the third.\"");
			break;
		case 65:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("\"*sigh* Father. I think it’s no longer your eyes that has problems but your brain instead.\"");
			break;
		case 66:
			this.dialogue.setText("\"We never owned a bitch, remember?\"");
			break;
		case 67:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Urk…\"");
			break;
		case 68:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("\"Anyway, you could tell we weren’t blood related?\"");
			break;
		case 69:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"I’ve been around the world. I could at least tell the differences between different kinds of people from different countries.\"</html>");
			break;
		case 70:
			this.dialogue.setText("\"Mr. Taufer is American, I presume?\"");
			break;
		case 71:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Yes.\"");
			break;
		case 72:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"And you seem to be Irish…\"");
			break;
		case 73:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("\"Wow! That’s amazing!\"");
			break;
		case 74:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"But if that’s the case, what of your biological father?\"");
			break;
		case 75:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenSad);
			this.dialogue.setText("\"I haven’t heard from him since the day I was adopted.\"");
			this.dialogueTurn = 81;
			break;
		case 76:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"What?\"");
			break;
		case 77:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("\"Do I look like a whore? Mighty rude of you don’t you think?\"");
			break;
		case 78:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"She’s my adopted daughter.\"");
			break;
		case 79:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Oh…\"");
			this.dialogueTurn = 81;
			break;
		case 80:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("\"No, you shut up! You’re checking on my father, aren’t you? Focus on your work!\"");
			break;
		case 81:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"It’s no use arguing with her. In fact, it’s best not to get on her wrong side…\"");
			break;
		case 82:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I see…\"");
			break;
		case 83:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>While Jose was chatting with the pair, he was checking up on Mr. Taufer’s eyes. As what Josephine mentioned, he does have a double cataract.</html>");
			break;
		case 84:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"From what I can see, there’s no hope in treating your cataract. But…\"");
			break;
		case 85:
			this.dialogue.setText("\"I may be able to improve your vision via operation.\"");
			break;
		case 86:
			this.nameBox.setText("Jospehine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("\"Really? That’s great news, father!\"");
			break;
		case 87:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"But how much improvement are we talking about?\"");
			break;
		case 88:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I wouldn’t get my hopes up. But I promise you that I will strive for the best outcome.\"");
			break;
		case 89:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Alright, I’d like to begin the operation.\"");
			break;
		case 90:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Very well. I’ll ready the medical equipment.\"");
			break;
		case 91:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Josephine, would you kindly help out the good doctor? I can ready myself alone.\"");
			break;
		case 92:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("<html>\"*sigh* Father, I’m not a genetically modified child made to obey unconditionally at the phrase<br>‘would you kindly.’ But…\"</html>");
			break;
		case 93:
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("\"Alright! Tell me what to do, doctor.\"");
			break;
		case 94:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Shortly after, the operation begins. Jose carefully operates on Mr. Taufer’s cataract while Josephine aids him as instructed.</html>");
			break;
		case 95:
			this.dialogue.setText("<html>The way Jose handles his job was close to that of clockworks. Every move was as smooth as water flowing down glass. Precision was as fine as a needle. Yet, there was no tense demeanor nor struggle to be felt. Truly a doctor worthy of respect.</html>");
			break;
		case 96:
			this.dialogue.setText("Though not really that keen on a doctor’s work, Josephine was awed by how the doctor moved.");
			break;
		case 97:
			this.dialogue.setText("<html>After the operation, Jose instructs the pair to stay in Dapitan for a while. He needed to see<br>how his eyes would improve from the treatment.</html>");
			break;
		case 98:
			Frame.everydayTheme.stop();
			Frame.gentleTheme.play(999);
			this.man.setVisible(false);
			this.sprites.setVisible(false);
			this.bg.setIcon(coast);
			this.dialogue.setText("<html>While Mr. Taufer and Josephine stayed in Dapitan, the latter and Jose found themselves chatting with each other from time to time.</html>");
			break;
		case 99:
			this.sprites.setBounds(683-brackenCasual.getIconWidth()/2, 768-brackenCasual.getIconHeight(), brackenCasual.getIconWidth(), brackenCasual.getIconHeight());
			this.sprites.setVisible(true);
			this.dialogue.setText("One day, along the coasts, Josephine was taking a stroll when Jose happens to be passing by.");
			break;
		case 100:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Coincidence meeting you here.\"");
			break;
		case 101:
			this.nameBox.setText("Josephine");
			if(this.affection == 10)
			{
				this.sprites.setIcon(brackenHappy);
				this.dialogue.setText("\"Good day to you! What brings you here?\"");
			}
			else if(this.affection == -10)
			{
				this.dialogue.setText("\"Hm? Oh, you again.\"");
			}
			else if(this.affection == -25)
			{
				this.sprites.setIcon(brackenMad);
				this.dialogue.setText("<html>\"Oh, look. A generic encounter with a generic man on a generic setting and it had to be by the shores. Great.\"</html>");
			}
			break;
		case 102:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I just happened by. The weather was good for a stroll by the seaside.\"");
			break;
		case 103:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Your stroll could’ve been anywhere else. Why the sea?\"");
			break;
		case 104:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Why, indeed?...\"");
			break;
		case 105:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose, after a few kicks on the sand, sits down on the sandy beach. With hands to both sides and gaze towards the horizon, the middle-aged man answers the first thing that came to his mind.</html>");
			break;
		case 106:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Because I could see the horizon…\"");
			break;
		case 107:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("\"Horizon?\"");
			break;
		case 108:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Yes. Looking at the horizon… Seeing it puts me at ease…\"");
			break;
		case 109:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"How? Is it because of the scenery?\"</html>");
			break;
		case 110:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"No. It’s because looking at it makes me certain of the uncertainty beyond it.\"</html>");
			break;
		case 111:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenSad);
			this.dialogue.setText("<html>\"Certain of the uncertainty? Please expound upon it. I only managed to study in a convent so philosophy isn’t quite what I can handle.\"</html>");
			break;
		case 112:
			this.nameBox.setVisible(false);
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("<html>Josephine is intrigued by the way this man speaks. He is a well-regarded doctor but she hasn’t heard of this man being like this. So she decides that his words are intriguing and that she wishes to listen more. Like Jose, she sits on the sand, eager ears at the ready.</html>");
			break;
		case 113:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Is that so? To put it bluntly, it reminds me of freedom.\"");
			break;
		case 114:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine is held up by that deep answer. Unable to reply, she nods implying that Jose continue.</html>");
			break;
		case 115:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"There are people that seek freedom, just like my countrymen.\"</html>");
			break;
		case 116:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Isn’t it natural? Like how the seagulls wish to fly over that horizon you speak of.\"</html>");
			break;
		case 117:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Yes. But even when the birds soar high, they still see the horizon even when they know they’ve long past the line we could see from here.\"</html>");
			break;
		case 118:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("<html>\"But at least, it is now in the place where it wanted to be.\"</html>");
			break;
		case 119:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"They may be getting somewhere, but the birds can only be safe only when they know where to go. Otherwise…\"</html>");
			break;
		case 120:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenSad);
			this.dialogue.setText("\"They would get lost…\"");
			break;
		case 121:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Much like seeking freedom. You may know how to be free but, without the proper knowledge in the direction you wish to be, you will be lost in the unknown.\"</html>");
			break;
		case 122:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>As Jose spoke those words, Josephine realized something about this man. About how he felt about his countrymen…</html>");
			break;
		case 123:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"When you mentioned your countrymen earlier, are you implying that…\"");
			break;
		case 124:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"To be honest, it scares me that, one day, my fellow countrymen would be free only to be lost in that sea of uncertainty…\"</html>");
			break;
		case 125:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Uncertainty can be scary…\"");
			break;
		case 126:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"I know. Especially when I see my countrymen seek that freedom as they are now. But I am hopeful…\"</html>");
			break;
		case 127:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose stands up and walks close to the sea. All the while, he said…</html>");
			break;
		case 128:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Just like the uncertainty beyond the horizon, the future is never determinate. The same thing may never be the same as when day and night differs every day.\"</html>");
			break;
		case 129:
			this.dialogue.setText("<html>\"The day isn’t always bright and sunny and the night isn’t always dark and gloomy. In crossing farther into the horizon, we escape either one. But at the end of the day, one can never be sure if the day on the other side will be bright and lovely.\"</html>");
			break;
		case 130:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("<html>\"That kind of uncertainty doesn’t seem reassuring, though.\"</html>");
			break;
		case 131:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"But we know it’s uncertain. And that reassures us. That’s why I gaze upon this view by the sea.\"</html>");
			break;
		case 132:
			this.dialogue.setText("\"It gives its beholder hope…\"");
			break;
		case 133:
			this.nameBox.setVisible(false);
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("<html>Josephine holds her breath for a short while. His philosophical speech and the gentle sea breeze stimulated her skin into having goosebumps. In that moment, she came to see something more about this man before her.</html>");
			break;
		case 134:
			this.dialogue.setText("<html>She stands up and goes to the sea. With feet in the water and her back to Jose, she holds her hands close together and lifts up a little bit of the sea. She holds it back a little and, with as much strength as she could…</html>");
			break;
		case 135:
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("SPLASH!!!");
			break;
		case 136:
			this.dialogue.setText("<html>Jose is splashed by a slap of seawater. The salty taste forces his tongue to reject the fluid.</html>");
			break;
		case 137:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"*spit* Okay, what was that for?\"</html>");
			break;
		case 138:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("\"I see now what kind of lonely man you are.\"");
			break;
		case 139:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"So you saw through my stern appearance…\"");
			break;
		case 140:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("\"Your words and tone carry subtle solitude, Sir Lonely.\"");
			break;
		case 141:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I guess. But perhaps it was boredom that made me so.\"");
			break;
		case 142:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("<html>\"*sigh* Well now I can see why you don’t remain all too sad. Alright. I’ve decided.\"</html>");
			break;
		case 143:
			this.nameBox.setVisible(false);
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("<html>With straightforward determination, she points her finger towards the soaked man.</html>");
			break;
		case 144:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"I’ll be your compass for the day!\"</html>");
			break;
		case 145:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Compass? And where will you guide me, fair lady?\"</html>");
			break;
		case 146:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("<html>\"Anywhere you like! Anywhere away from loneliness and boredom!\"</html>");
			break;
		case 147:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Hahaha! That’s great and all but how certain are you that this captain will follow you?\"</html>");
			break;
		case 148:
			this.nameBox.setVisible(false);
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("<html>From the sea, Josephine briskly approaches Jose splashing the water with every pace. Upon reaching the very front of Jose, the teen puts her face close to the man forcing them to look eye to eye.</html>");
			break;
		case 149:
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("<html>A slight moment of pause and Josephine smirked. As if she had confirmed something, she replies with reassurance.</html>");
			break;
		case 150:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"I am absolutely certain that you will. After all, your eyes give you away.\"</html>");
			break;
		case 151:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine caught Jose’s pupils changing the moment their eyes got close. Like a burglar caught in the act, Jose could only surrender to the persistent girl.</html>");
			break;
		case 152:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Alright, you got me. So, what shall we do for today, Ms. Compass?\"");
			break;
		case 153:
			this.nameBox.setVisible(false);
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("<html>Josephine giggles and pulls Jose towards where her interest piqued her.</html>");
			break;
		case 154:
			this.dialogue.setText("<html>That day and many that followed were partly spent with those two cavorting in the bounties of their paradise.</html>");
			break;
		case 155:
			Frame.gentleTheme.stop();
			Frame.suspicion.play(999);
			this.bg.setIcon(outRizalHouse);
			this.sprites.setVisible(false);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>But even when the skies smiled upon their joy, there were others not quite sure of their blooming relationship…</html>");
			break;
		case 156:
			this.woman4.setVisible(true);
			this.woman2.setBounds(300, 768-lady2.getIconHeight(), lady2.getIconWidth(), lady2.getIconHeight());
			this.woman2.setVisible(true);
			this.dialogue.setText("<html>Some of Jose’s relatives arrive. They see the intimate relationship that Jose had with Josephine. However, they aren’t all too warm about it.</html>");
			break;
		case 157:
			this.woman2.setVisible(false);
			this.woman4.setBounds(683-lady4.getIconWidth()/2, 768-lady4.getIconHeight(), lady4.getIconWidth(), lady4.getIconHeight());
			this.dialogue.setText("<html>One of Jose’s relatives, Maria seeks the audience of her brother for a serious conversation.</html>");
			break;
		case 158:
			this.bg.setIcon(inRizalHouse);
			this.nameBox.setText("Maria");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Brother…\"");
			break;
		case 159:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Ah, sister! You came to visit!\"");
			break;
		case 160:
			this.nameBox.setText("Maria");
			this.dialogue.setText("\"Yes, and it was good fortune that I did…\"");
			break;
		case 161:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"What do you mean?\"</html>");
			break;
		case 162:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>With slight hesitation, Maria thinks deep about what she has to say. She glances around to see if anybody is listening.</html>");
			break;
		case 163:
			this.nameBox.setText("Maria");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I shall be blunt. Be wary of that woman you are intimate with.\"");
			break;
		case 164:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Be wary? Why?\"");
			break;
		case 165:
			this.nameBox.setText("Maria");
			this.dialogue.setText("<html>\"Don’t you understand? Do I need to spell it out to you that she may very well be a spy?!\"</html>");
			break;
		case 166:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Maria tries to lower her volume so as not to spread her words across the house. Subtle worry and desperation abound from her tone.</html>");
			break;
		case 167:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I cannot agree with you. She is not that kind of woman.\"");
			break;
		case 168:
			this.nameBox.setText("Maria");
			this.dialogue.setText("<html>\"But what about the spy that was sent to you back then?! Do you think your enemies will sit idly by letting you stay here in exile? They’d rather have you dead!\"</html>");
			break;
		case 169:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"I am aware of that. But I also know that Josephine isn’t the kind you believe her to be. Besides, I made acquaintances with that spy that you mentioned.\"</html>");
			break;
		case 170:
			this.nameBox.setText("Maria");
			this.dialogue.setText("<html>\"Even if you say so, I cannot rest assured. That woman I simply cannot trust.\"</html>");
			break;
		case 171:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Then there is nothing I can tell you. I am firm with my beliefs and they tell me that she is of no grave threat to me.\"</html>");
			break;
		case 172:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose’s steel gaze pierces through Maria’s persistence. Even as his sister, she admits that she cannot persuade him anymore. Finally giving in with a sigh, Maria departs with one final piece of advice.</html>");
			break;
		case 173:
			this.nameBox.setText("Maria");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"At least, have someone else taste the food that she makes…\"</html>");
			break;
		case 174:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"You worry too much, sister. Don’t forget that I am a doctor and I also have experience to dictate me about the edibility of the food I eat.\"</html>");
			break;
		case 175:
			this.nameBox.setVisible(false);
			this.woman4.setVisible(false);
			this.dialogue.setText("<html>With that, Maria leaves…</html>");
			break;
		case 176:
			Frame.suspicion.stop();
			Frame.gentleTheme.play(999);
			this.bg.setIcon(outRizalHouse);
			this.man.setVisible(true);
			this.sprites.setBounds(this.bg.getWidth()-brackenMad.getIconWidth()-100, this.bg.getHeight()-brackenMad.getIconHeight(), brackenMad.getIconWidth(), brackenMad.getIconHeight());
			this.sprites.setIcon(brackenSad);
			this.sprites.setVisible(true);
			this.dialogue.setText("<html>Several days later, Mr. Taufer returns to the doctor. It was almost noon when Mr. Taufer, along with Josephine, returns as told by the doctor to get his eyes checked after a while but…</html>");
			break;
		case 177:
			this.bg.setIcon(inRizalHouse);
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"It seems the operation only had minimal effect.\"");
			break;
		case 178:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"I could at least see clearly within hand’s reach but…\"");
			break;
		case 179:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I’m sorry, Mr. Taufer.\"");
			break;
		case 180:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Jose bows in defeat before the elderly man.");
			break;
		case 181:
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"It’s okay, lad. I am in my sixties after all. A man’s weakening sight in my age is common.\"</html>");
			break;
		case 182:
			this.dialogue.setText("<html>\"Besides, a doctor can’t cure everything no matter how excellent he is in his profession.\"</html>");
			break;
		case 183:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Your comforting words are appreciated, Mr. Taufer.\"");
			break;
		case 184:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Well then. We must be going now.\"");
			break;
		case 185:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Sullen by the result of the operation, Mr. Taufer takes his fedora and prepares to depart. Disappointment was evident within his debilitated eyes as the prospect of him losing his sight became inevitable. Josephine, on the other hand, seems to be eager to say something. Hesitance in every glance could be noticed from the teen.</html>");
			break;
		case 186:
			this.dialogue.setText("The elderly man prompts the teen to hurry and accompany him.");
			break;
		case 187:
			Frame.gentleTheme.stop();
			this.dialogue.setText("Josephine and Mr. Taufer are about to leave…");
			this.options[0].setText("<html>Jose: \"Mr. Taufer, I’ve been meaning to ask permission something from you.\"</html>");
			this.options[1].setText("<html>Jose: \"Take care.\"</html>");
			this.options[2].setText("<html>Jose: \"...\"</html>");
			this.options[0].setVisible(true);
			this.options[1].setVisible(true);
			this.options[2].setVisible(true);
			break;
		case 188:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Out with it, then.\"");
			break;
		case 189:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Gulping before speaking, Jose tilts his head lower and asks for the one phrase that has been crossing his mind…</html>");
			break;
		case 190:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I would like to take your daughter’s hand in marriage…\"");
			break;
		case 191:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"What?!\"");
			break;
		case 192:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Surprised, Mr. Taufer almost lost his heart. On the other hand, Josephine’s eyes fill with gleams of elation. Dumbfounded, the two were almost left speechless but Mr. Taufer refuses to stay silent.</html>");
			break;
		case 193:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Ah! I see that you jest, young doctor.\"");
			break;
		case 194:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Do you see it in my eyes that I am joking? From the moment I first saw her, I was already smitten. I asked for an Eve and God provided.\"</html>");
			break;
		case 195:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"In all truth, we’ve been meaning to confess to you about this matter. Actually, I’d like to stay her with him…\"</html>");
			break;
		case 196:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>All of this overwhelmed the 60 year old senior. Dumbfounded, he thought, ‘who would take care of me when she leaves me? Never mind that I’m going blind. I might not make it when I’m at this kind of age!’</html>");
			break;
		case 197:
			Frame.darkTheme.play(999);
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Unfortunately, I’ll have to decline you proposal.\"");
			break;
		case 198:
			this.nameBox.setText("Josephine");
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("<html>\"Father! I’m the one he wants to marry! I should be the one to decide!\"</html>");
			break;
		case 199:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("<html>\"What foolishness are you talking about?! You’re 17 years old for God’s sake!\"</html>");
			break;
		case 200:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Yes, I am 17 years old. What of it? I managed your household together with your daughter and I was the one who drove out your useless wife! Don’t you see? I’m fine by my own!\"</html>");
			break;
		case 201:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("<html>\"Then what about me?! Are you telling me you’re going to leave the man that took you in?!\"</html>");
			break;
		case 202:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"That’s….\"");
			break;
		case 203:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>A tense pause stops their conversation for a while. As Josephine thinks deep as to what she should say next, Jose attempts to calm the two down when…</html>");
			break;
		case 204:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Both of you, calm down. We can find ways into this matter. Rest assured, when I marry her, we’ll take care of you, Mr. Taufer.\"</html>");
			break;
		case 205:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"NO!!!\"");
			break;
		case 206:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Infuriated and lost, Mr. Taufer grabs a nearby scalpel and draws its edge towards his throat. Ready to take his own miserable life, he threatens the two…</html>");
			break;
		case 207:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"If it’s going to be like this, then it’d be best to just end myself right here and now!\"</html>");
			break;
		case 208:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Alarmed by the man’s impulsive action, Jose and Josephine both attempt to pacify the desperate man. With the scalpel’s razor sharp edge, one stroke could spell the death of someone’s life.</html>");
			break;
		case 209:
			this.dialogue.setText("Thankfully, they managed to avert tragedy.");
			break;
		case 210:
			Frame.darkTheme.stop();
			this.dialogue.setText("<html>Mr. Taufer calms down. But as a result, Josephine is forced to accompany her father back to Manila where they would depart for Hong Kong. As hard it was for them to accept, it had to be done.</html>");
			this.dialogueTurn = 215;
			break;
		case 211:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.sprites.setIcon(brackenMad);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Aren’t you forgetting something?\"");
			break;
		case 212:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Ah, right.\"");
			this.dialogueTurn = 215;
			break;
		case 213:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.sprites.setIcon(brackenMad);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Do I have to remind you of what’s supposed to happen?!\"");
			break;
		case 214:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"I can’t help it. That’s what the player chose… Let's just move on.\"</html>");
			break;
		case 215:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"*sigh*\"");
			break;
		case 216:
			Frame.gentleTheme.play(999);
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"If it pleases you, would you mind if I give something to her before you leave?\"</html>");
			break;
		case 217:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("\"Hm…\"");
			break;
		case 218:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Mr. Taufer looks to his daughter and sees puppy eyes asking for one last favor. The old man gives in much to the delight of the 17 year old.</html>");
			break;
		case 219:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Here…\"");
			break;
		case 220:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Josephine receives a small paper and an envelope.");
			break;
		case 221:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"As you go, I want you to read what’s inside small paper as a remembrance of our love.\"</html>");
			break;
		case 222:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I will and I will treasure it.\"");
			break;
		case 223:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"As for the envelope, I want you to give it to my relatives over there. My sister, Narcissa, will be accompanying you to Manila. I’ve already informed her about the matter of introducing you to them.\"</html>");
			break;
		case 224:
			this.sprites.setIcon(brackenSad);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Do you think your relatives will approve?\"");
			break;
		case 225:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"You’ve had a hard life losing important things and running away from some things. They will understand…\"</html>");
			break;
		case 226:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I see. I’ll be optimistic as always! Well then…\"");
			break;
		case 227:
			this.sprites.setIcon(brackenSad);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>The two leave the presence of Jose. Though bitter, the teen carried with her the feelings of the man she holds dear.</html>");
			break;
		case 228:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Inside the small paper wrote:");
			break;
		case 229:
			this.sprites.setVisible(false);
			this.man.setVisible(false);
			this.dialogue.setVisible(false);
			this.bg.setIcon(poem);
			break;
		case 230:
			this.bg.setIcon(sunset);
			this.dialogue.setText("<html>Mr. Taufer and Josephine departs for Manila. Sentiments of disappointment echo through the minds of Jose and Josephine as they move apart 5 inches per second…</html>");
			this.dialogue.setVisible(true);
			break;
		case 231:
			Frame.gentleTheme.stop();
			Frame.manilaBGM.play(999);
			this.dialogue.setText("The day was March 14, 1895.");
			break;
		case 232:
			this.bg.setIcon(manila);
			this.dialogue.setText("Manila");
			break;
		case 233:
			this.man.setVisible(true);
			this.sprites.setIcon(brackenSad);
			this.sprites.setVisible(true);
			this.woman3.setBounds(1366-lady3.getIconWidth()-300, 768-lady3.getIconHeight(), lady3.getIconWidth(), lady3.getIconHeight());
			this.woman3.setVisible(true);
			this.dialogue.setText("Josephine and Mr. Taufer arrive at Manila together with Narcissa.");
			break;
		case 234:
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Alright. I think our ferry to Hong Kong will depart some time tomorrow.\"</html>");
			break;
		case 235:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Mr. Taufer sees Josephine sullen and dazed.</html>");
			break;
		case 236:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"*sigh* Do you really want to be with him that ba-\"");
			break;
		case 237:
			this.sprites.setIcon(brackenMad);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"YES. BADLY.\"");
			break;
		case 238:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine abruptly cuts Mr. Taufer’s sentence prematurely.</html>");
			break;
		case 239:
			this.dialogue.setText("<html>The old man goes into deep thought. He certainly didn’t want to be left alone but…</html>");
			break;
		case 240:
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Very well…\"");
			break;
		case 241:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Really?!\"");
			break;
		case 242:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"Well, isn’t that great!\"");
			break;
		case 243:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>The two girls dance along with joy as they place their hands together and merrily prance.</html>");
			break;
		case 244:
			this.nameBox.setText("Mr. Taufer");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"So what will be your plans?\"");
			break;
		case 245:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I’ll be heading for Jose’s relatives as mentioned.\"");
			break;
		case 246:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"Don’t worry, I’ll take care of her along the way, Mr. Taufer.\"");
			break;
		case 247:
			this.nameBox.setText("Mr. Taufer");
			this.dialogue.setText("<html>\"I’m not necessarily worried about her seeing as the kind of woman she is…\"</html>");
			break;
		case 248:
			this.dialogue.setText("<html>\"In any case, I’ll be leaving you to your own devices. Just so you know, there is always a room for you where I am.\"</html>");
			break;
		case 249:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"I know, Father. And I’ll be ready to handle any mess you leave by the time I return.\"</html>");
			break;
		case 250:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Mr. Taufer waves his fedora off, saluting his daughter and Narcissa on a safe trip.</html>");
			break;
		case 251:
			Frame.manilaBGM.stop();
			this.man.setVisible(false);
			this.bg.setIcon(rizalResidenceOut);
			this.dialogue.setText("<html>Josephine and Narcissa traverse through carriage on the way to the Rizal residence. It was quite a long ride but they eventually reach their destination safely.</html>");
			break;
		case 252:
			this.woman4.setVisible(true);
			this.woman2.setVisible(true);
			this.dialogue.setText("<html>Upon arriving at her loved one’s residence, they are greeted by a group of maidens. These were Jose’s sisters.</html>");
			break;
		case 253:
			this.dialogue.setText("<html>Stepping down from the carriage, Narcissa is immediately welcomed by her sisters. Josephine on the other hand…</html>");
			break;
		case 254:
			this.nameBox.setText("Jose's Sister");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"You must be Josephine…\"");
			break;
		case 255:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Yes, it is a pleasure to meet you all…\"");
			break;
		case 256:
			Frame.suspicion.play(999);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Awkward air fills the atmosphere as the women try a forced smile.</html>");
			break;
		case 257:
			this.sprites.setIcon(brackenCasual);
			this.dialogue.setText("<html>Josephine sees their effort and refrains from extending a hand. Instead, she does the same and smiles in an attempt to show them good intentions.</html>");
			break;
		case 258:
			this.woman2.setVisible(false);
			this.woman3.setVisible(false);
			this.woman4.setVisible(false);
			this.woman.setVisible(true);
			this.bg.setIcon(rizalResidenceIn);
			this.dialogue.setText("<html>They head for the Dona of the household who was Dona Teodora – Jose’s mother.</html>");
			break;
		case 259:
			this.dialogue.setText("<html>Seeing Josephine, the Dona wasn’t familiar as to who she was until one of her daughters whispers something in her ear. Her face remained stern but there was an air of reserve from the old lady.</html>");
			break;
		case 260:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Good day, I am Josephine.\"");
			break;
		case 261:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine then takes the Dona’s hand and subtly placed it on her forehead.</html>");
			break;
		case 262:
			this.nameBox.setText("Dona Teodora");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"So I heard…\"");
			break;
		case 263:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"I have a letter from your son. He says to present it to you when I have arrived.\"</html>");
			break;
		case 264:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine hands over the letter. All the while, Narcissa was quite sweaty as the tension overwhelmed her train of thought. To her, these women being at one place without her brother could be volatile…</html>");
			break;
		case 265:
			this.dialogue.setText("<html>The Dona read the letter. It was a recommendation letter by Jose. It wrote:</html>");
			break;
		case 266:
			this.sprites.setVisible(false);
			this.woman.setVisible(false);
			this.dialogue.setVisible(false);
			this.bg.setIcon(letter);
			break;
		case 267:
			this.bg.setIcon(rizalResidenceIn);
			this.sprites.setVisible(true);
			this.woman.setVisible(true);
			this.dialogue.setVisible(true);
			this.dialogue.setText("<html>The Dona folds the letter. She gazes at the Irish woman from head to toe.</html>");
			break;
		case 268:
			this.nameBox.setText("Dona Teodora");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"My son cares for you a lot. Consider yourself lucky, young woman.\"");
			break;
		case 269:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Indeed I am. And I am hoping that you would find in yourself the will to care for me as I would to your son.\"</html>");
			break;
		case 270:
			this.nameBox.setText("Dona Teodora");
			this.dialogue.setText("<html>\"Understand that I, as the mother of Jose, will do anything that I deem necessary for my son’s welfare.\"</html>");
			break;
		case 271:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"And I understand that I must do all I can to gain your trusts as my personality would dictate.\"</html>");
			break;
		case 272:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Right then and there, tension rose so high, only the two women could talk. Narcissa was already about to lose her fingernails.</html>");
			break;
		case 273:
			this.nameBox.setText("Dona Teodora");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Very well. You shall be under my wing for the time being. Know that we have household rules…\"</html>");
			break;
		case 274:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I was aware of them.\"");
			break;
		case 275:
			this.nameBox.setText("Don Teodora");
			this.dialogue.setText("\"Then do the utmost you can to please us…\"");
			break;
		case 276:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>And to please them she did. For months, Josephine lived with the Rizal’s. But even with the length, their relationship remained strained. Reservations within the family failed to subside as Dona Teodora and some others kept their distance.</html>");
			break;
		case 277:
			Frame.suspicion.stop();
			Frame.everydayTheme.play(999);
			this.bg.setIcon(outRizalHouse);
			this.woman.setVisible(false);
			this.dialogue.setText("<html>Eventually, Josephine would find herself back at Dapitan where she would reunite with her dear loved one…</html>");
			break;
		case 278:
			this.sprites.setVisible(false);
			this.dialogue.setText("July, 1895; Dapitan…");
			break;
		case 279:
			this.sprites.setIcon(brackenCasual);
			this.sprites.setVisible(true);
			this.dialogue.setText("<html>Josephine returns to Dapitan after some months with the Rizals. Eager to meet her beloved, she quickly heads for the house which Jose resided.</html>");
			break;
		case 280:
			this.dialogue.setText("<html>She tells of her experiences in her stay.</html>");
			break;
		case 281:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Is that so? I had hoped that your meeting with them would resolve any doubts they held…\"</html>");
			break;
		case 282:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"It’s fine. I at least believe I was acceptable before them since they never once pressed on anything. Anyway,\"</html>");
			break;
		case 283:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine, however, wasn’t eager to tell tales about her experiences with Jose’s relatives. She was awaiting news about what they had been planning to do for a long time now – marriage.</html>");
			break;
		case 284:
			this.dialogue.setText("<html>While Josephine was away, Jose had asked permission for marriage before the parish as what had been discussed by Josephine and him some time ago. It would be a joyous occasion if only it were to happen…</html>");
			break;
		case 285:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"I’ve asked for permission but the parish priest of this place wishes for me to retract my ‘anti-clerical’ views. As such,\"</html>");
			break;
		case 286:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine is sullen. Sitting down, she sighs in disappointment.</html>");
			break;
		case 287:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"But he hasn’t released any news yet. There may be a chance.\"");
			break;
		case 288:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"They say no news is good news so let’s be hopeful.\"");
			break;
		case 289:
			Frame.everydayTheme.stop();
			Frame.solitudeTheme.play(999);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>However, days would pass and still the parish would remain against their union. The parish priest even makes mention of Cebu’s Bishop’s disapproval as well, something that would almost crush the spirits of the couple.</html>");
			break;
		case 290:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Even the people over here reject our union. Quite funny, don’t you think?\"");
			break;
		case 291:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose remains silent. As if he never heard Josephine’s jest at their situation, Jose keeps his remark to himself…</html>");
			break;
		case 292:
			this.sprites.setIcon(brackenMad);
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Hrrm!\"");
			break;
		case 293:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>With puffed cheeks and both hands stretched wide, Josephine slaps Jose’s cheeks much to his surprise.</html>");
			break;
		case 294:
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Look, I know we’ve had the worst luck with all that’s happened but don’t let circumstance get the better of you.\"</html>");
			break;
		case 295:
			this.dialogue.setText("<html>\"Remember, I am here and I strictly discourage such a depressing look.\"</html>");
			break;
		case 296:
			this.nameBox.setVisible(false);
			this.dialogue.setText("How should Jose react?");
			this.options[0].setText("Stay silent.");
			this.options[0].setVisible(true);
			this.options[1].setText("How about we put matter into our own hands?");
			this.options[1].setVisible(true);
			this.options[2].setText("Maybe we should give up...");
			this.options[2].setVisible(true);
			break;
		case 297:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.sprites.setIcon(brackenMad);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"At least say something. That’s not how the man I fell for would act.\"</html>");
			break;
		case 298:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Sorry…\"");
			dialogueTurn = 312;
			break;
		case 299:
			Frame.solitudeTheme.stop();
			Frame.gentleTheme.play(999);
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Matters into our own hands? You mean marry ourselves?\"");
			break;
		case 300:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Yes. We only need two witnesses.\"");
			break;
		case 301:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine steps back in deep thought. His idea was daring considering how the Spaniards treated Jose. Regardless…</html>");
			break;
		case 302:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Let’s do it!\"");
			break;
		case 303:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>And so they did. Before two witnesses, Josephine and Jose marry each other. Sealing it with a kiss, they become a couple by their own standards.</html>");
			break;
		case 304:
			this.dialogue.setText("Some days later…");
			dialogueTurn = 312;
			break;
		case 305:
			this.options[0].setVisible(false);
			this.options[1].setVisible(false);
			this.options[2].setVisible(false);
			this.sprites.setIcon(brackenMad);
			this.dialogue.setText("<html>Josephine gets irritated with Jose’s hesitation.</html>");
			break;
		case 306:
			this.dialogue.setText("<html>She goes to a nearby table and picks up a syringe marked with the label, ‘Compa’s Mysterious Fluid.’ Whatever that is is anybody’s guess.</html>");
			break;
		case 307:
			this.dialogue.setText("Josephine raises her hand with the syringe.");
			break;
		case 308:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"Josephine, that is seriously NOT a good idea! I know you want to prove your strong will but at the cost of your safety-\"</html>");
			break;
		case 309:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose’s words fall into deaf ears. Before he could reach her, Josephine injects the crimson fluid into her anatomy…</html>");
			break;
		case 310:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Ah…\"");
			break;
		case 311:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Now do you still waver when your beloved is willing to push through?\"</html>");
			break;
		case 312:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Jose gives in and tries to undo what she just did…");
			break;
		case 313:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"You’re a strong woman…\"");
			break;
		case 314:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Naturally! I have to be if especially when things don’t always go well. But...\"</html>");
			break;
		case 315:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"What is it?\"");
			break;
		case 316:
			Frame.gentleTheme.stop();
			Frame.solitudeTheme.play(999);
			this.sprites.setIcon(brackenSad);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Honestly, you’re not the only one with doubts… I overheard one of your sister’s conversations back when she visited here. Her name was Maria, yes?\"</html>");
			break;
		case 317:
			this.dialogue.setText("<html>\"I’d be lying if it didn’t hurt me that your sisters are suspecting me of being a spy but…\"</html>");
			break;
		case 318:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"It’s okay to feel that way. It only proves that you harbor no ill intentions. Someday they'll understand.\"</html>");
			break;
		case 319:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Reassured, the two carry on with the day as usual.</html>");
			break;
		case 320:
			Frame.solitudeTheme.stop();
			this.bg.setIcon(inRizalHouse);
			this.dialogue.setText("<html>Later that night, they are together. In Jose’s bedroom they would intimately spend the night just as what any couple in love would most likely do alone in a tranquil place such as this.</html>");
			break;
		case 321:
			this.dialogue.setText("<html>Preparing their spirits and readying themselves, they…</html>");
			break;
		case 322:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"BREAK THE FOURTH WALL!\"");
			break;
		case 323:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Josephine, you shouldn’t be speaking right now!\"");
			break;
		case 324:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"So shouldn't the cameraman. We can’t show them a scene of us eloping.\"</html>");
			break;
		case 325:
			this.nameBox.setVisible(false);
			this.dialogue.setText("In any case, the two had sex afterwards…");
			break;
		case 326:
			this.bg.setIcon(inRizalHouse);
			this.sprites.setVisible(false);
			this.dialogue.setText("Eight months later…");
			break;
		case 327:
			this.sprites.setIcon(brackenCasual);
			this.sprites.setVisible(true);
			this.dialogue.setText("<html>Josephine was eight months into her pregnancy.</html>");
			break;
		case 328:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"If it were to be a boy, then my mother recommended it be Francisco while my sisters say Peter.\"</html>");
			break;
		case 329:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Well, Francisco sounds nice. Isn’t that your father’s name?\"");
			break;
		case 330:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Yes.\"");
			break;
		case 331:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Imagine if you mistakenly call your son ‘father’ someday!\"");
			break;
		case 332:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"That would be-\"");
			break;
		case 333:
			Frame.sadTheme.play(999);
			this.sprites.setIcon(brackenSad);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Suddenly, Josephine’s face went sour. With her brows furrowing, she feels an intense shock of pain…</html>");
			break;
		case 334:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I think… the water…\"");
			break;
		case 335:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"But it’s still eight months! Don’t tell me…\"");
			break;
		case 336:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>As bad as what Jose was thinking, he set it aside. His wife needed attention fast.</html>");
			break;
		case 337:
			this.dialogue.setText("Just as Jose expected, Josephine was about to go into labor. Prematurely…");
			break;
		case 338:
			this.sprites.setVisible(false);
			this.dialogue.setText("After an hour, Jose takes from Josephine a baby boy. Francisco was born.");
			break;
		case 339:
			this.dialogue.setText("Joyous it would have been... If only it would have been so…");
			break;
		case 340:
			this.bg.setIcon(sunset);
			this.dialogue.setText("<html>Jose sat on his desk sketching the baby boy. Afterwards, he would carry the cold baby. Not to the mother whence he came from but to Mother Earth and her earthly embrace…</html>");
			break;
		case 341:
			this.dialogue.setText("<html>It was a sad day for the couple. Josephine was in tears despite the kind of person she was. It would eventually reach to Jose’s relatives.</html>");
			break;
		case 342:
			this.dialogue.setText("<html>A moment of joy only to become mourning three hours later. Francisco Rizal y Bracken would come and go…</html>");
			break;
		case 343:
			Frame.sadTheme.stop();
			Frame.everydayTheme.play(999);
			this.bg.setIcon(inRizalHouse);
			this.dialogue.setText("<html>After some time, the couple recovers from their loss. Along with it came a letter addressed to him.</html>");
			break;
		case 344:
			this.dialogue.setText("<html>According to the letter, there was in need for volunteer physicians in Cuba to serve the Spaniards there.</html>");
			break;
		case 345:
			this.sprites.setIcon(brackenMad);
			this.sprites.setVisible(true);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Cuba?\"");
			break;
		case 346:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Yes, I’m planning to depart as soon as you would agree.\"");
			break;
		case 347:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I don’t see any problem.\"");
			break;
		case 348:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Even though she said so, there was a slight irritation in her words. Apparently, her forehead seems to be swollen…</html>");
			break;
		case 349:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I’m really sorry about that prank. I only intended to cheer you up.\"");
			break;
		case 350:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I WAS IN A DELICATE CONDITION BACK THEN!!!\"");
			break;
		case 351:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Once again, Jose apologizes.");
			break;
		case 352:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"In any case, now that you’ve approved, how does tomorrow sound?\"");
			break;
		case 353:
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Then I’ll help you get things ready.\"");
			break;
		case 354:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>The next day, July 31, 1896, the couple depart for Manila aboard a steamer named ‘Espana’ along with Narcissa, a niece, three nephews, and three of Josephine’s students. They would arrive at Manila six days later…</html>");
			break;
		case 355://True Ending
			Frame.everydayTheme.stop();
			Frame.manilaBGM.play(999);
			this.sprites.setVisible(false);
			this.bg.setIcon(manila_docks);
			this.dialogue.setText("August, 1896, Manila…");
			break;
		case 356:
			this.sprites.setIcon(brackenCasual);
			this.sprites.setVisible(true);
			this.woman3.setVisible(true);
			this.dialogue.setText("The time that Jose departed has come…");
			break;
		case 357:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Well then, I’ll be going.\"");
			break;
		case 358:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Have a safe trip.\"");
			break;
		case 359:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Take care of her.\"");
			break;
		case 360:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"She’s in safe hands.\"");
			break;
		case 361:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose boards the Castilla headed for Spain. The plan was for the volunteers to board a ship for Cuba there.</html>");
			break;
		case 362:
			this.sprites.setIcon(brackenHappy);
			this.dialogue.setText("<html>Castilla set sails and departs as the couple and other people in the area wave their good byes…</html>");
			break;
		case 363:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Well then, I guess I should do what I had planned.\"");
			break;
		case 364:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"You mean the English tutoring and piano playing?\"");
			break;
		case 365:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Mhm!\"");
			break;
		case 366:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>And so the now two each on their own paths make do with what they have. Josephine does all she can to get income while Jose travels once again for Europe and eventually to the Americas however…</html>");
			break;
		case 367:
			Frame.manilaBGM.stop();
			this.bg.setIcon(shipDeck);
			this.woman3.setVisible(false);
			this.sprites.setVisible(false);
			this.man.setIcon(guard);
			this.man.setVisible(true);
			this.nameBox.setText("Guardia");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Jose Rizal, I presume!\"");
			break;
		case 368:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Yes, what seems to be the problem?\"");
			break;
		case 369:
			this.nameBox.setText("Guardia");
			this.dialogue.setText("<html>\"We are here to apprehend you with charges of instigating rebellion as ringleader!\"</html>");
			break;
		case 370:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose is brought back to Manila aboard a ship. News reaches Josephine and Jose’s family about the arrest. Things wouldn’t go well as Jose’s fate is sealed…</html>");
			break;
		case 371:
			Frame.finalMoments.play(999);
			this.bg.setIcon(prisonCell);
			this.man.setVisible(false);
			this.dialogue.setText("December 30, 1896, Fort Santiago, Jose’s Prison Cell…");
			break;
		case 372:
			this.sprites.setIcon(brackenSad);
			this.sprites.setVisible(true);
			this.man.setIcon(priest);
			this.man.setVisible(true);
			this.woman2.setVisible(true);
			this.dialogue.setText("<html>After being sentenced to death by firing squad under dubious jurisdiction by the new Governor-General Camilo Polavieja, Jose meets with his betrothed for possibly the last time…</html>");
			break;
		case 373:
			this.dialogue.setText("<html>Along with a priest by the name of Vicente Balanguer and one of Jose’s sisters, Josefa, Josephine come to her betrothed emotionally. Tears were about to fall.</html>");
			break;
		case 374:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Well, this is a rather unfortunate meeting for us…\"");
			break;
		case 375:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"What are you talking about? We’re finally going to get married officially. How can this be unfortunate?\"</html>");
			break;
		case 376:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"You’re right. At the very least, we got one thing right.\"</html>");
			break;
		case 377:
			this.sprites.setIcon(brackenMad);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Everything was alright, you idiot!\"");
			break;
		case 378:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Hahaha!\"");
			break;
		case 379:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Though they momentarily smile, the inevitable loomed and their happiness is soon replaced by fear.</html>");
			break;
		case 380:
			this.sprites.setIcon(brackenSad);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Maybe we can call it off. You know, prove them wrong!\"");
			break;
		case 381:
			this.nameBox.setText("Guardia");
			this.dialogue.setText("\"If you don’t have anything else to say…\"");
			break;
		case 382:
			this.nameBox.setText("Priest");
			this.dialogue.setText("\"If I may-\"");
			break;
		case 383:
			this.woman2.setVisible(false);
			this.woman3.setVisible(false);
			this.sprites.setIcon(brackenCasual);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>What followed was Jose’s retraction of what the church considered his ‘anti-clerical’ beliefs. In it he submits to the church as her son and abominates Masonry. Whether he truly desired so is up to his inner beliefs. Afterwards, two hours before his execution, the moment they’ve all came for…</html>");
			break;
		case 384:
			this.nameBox.setText("Priest");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"And I pronounce you husband and wife…\"");
			break;
		case 385:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>At the end of the priest’s proclamation, Josephine and Jose, in their holy matrimony, complete the sacrament with a kiss.</html>");
			break;
		case 386:
			this.sprites.setVisible(false);
			this.man.setVisible(false);
			this.dialogue.setText("<html>After some tears and some farewells, Jose hands over to Josephine a book entitled, ‘Imitation of Christ.’ From there, they embrace for the last time. Jose walks away and, despite her defiance to let go, Josephine steps back allowing the Guardia to take him away.</html>");
			break;
		case 387:
			this.dialogue.setText("Moments later, on the morning of December 30, 1896…");
			break;
		case 388:
			Frame.finalMoments.stop();
			Frame.fuego.play(0);
			this.bg.setIcon(execution);
			this.dialogue.setVisible(false);
			break;
		case 389:
			this.bg.setIcon(inRizalHouse);
			this.dialogue.setText("Four days later…");
			this.dialogue.setVisible(true);
			break;
		case 390:
			this.man.setIcon(katipunero);
			this.man.setVisible(true);
			this.nameBox.setText("Katipunero");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"So you wanna join our cause?\"");
			break;
		case 391:
			this.sprites.setIcon(brackenMad);
			this.sprites.setVisible(true);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Yes.\"");
			break;
		case 392:
			this.nameBox.setText("Katipunero");
			this.dialogue.setText("<html>\"It is an honor for a hero’s wife to join the rebellion against those bastards, though Sir Bonifacio called him a coward.\"</html>");
			break;
		case 393:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"Rest assured, you will find no weak woman in me.\"</html>");
			break;
		case 394:
			Frame.finalMoments.play(999);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine joins the Katipunan just four days after her husband’s execution. Trained in horsemanship and marksmanship, she managed to earn the approval of Emilio Aguinaldo to join the fighting troops where she would earn a few kills.</html>");
			break;
		case 395:
			this.dialogue.setText("<html>When she wasn’t a warrior, she was a nurse treating wounded Katipuneros.</html>");
			break;
		case 396:
			this.man.setIcon(gent2);
			this.dialogue.setText("<html>Eventually, the Spanish rule would come to an end. She would get remarried to a Vicente Abad where she would get pregnant again and she would live the life of a teacher.</html>");
			break;
		case 397:
			this.sprites.setIcon(brackenSad);
			this.man.setVisible(false);
			this.dialogue.setText("<html>One day, she reminisces about the times she had with Jose. In some of her things, she sees the book that Jose gave him. On it wrote a note written on that fateful day…</html>");
			break;
		case 398:
			this.bg.setIcon(blackscreen);
			this.sprites.setVisible(false);
			this.dialogue.setText("<html>\"To my dear and unhappy wife, Josephine/ December 30th, 1896/ Jose Rizal…\"</html>");
			this.ending = 1;
			this.dialogueTurn = 457;
			break;
		case 399://Kracken Ending
			Frame.everydayTheme.stop();
			Frame.manilaBGM.play(999);
			this.sprites.setVisible(false);
			this.bg.setIcon(manila_docks);
			this.dialogue.setText("August, 1896, Manila…");
			break;
		case 400:
			this.sprites.setIcon(brackenCasual);
			this.sprites.setVisible(true);
			this.woman3.setVisible(true);
			this.dialogue.setText("The time that Jose departed has come…");
			break;
		case 401:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Well then, I’ll be going.\"");
			break;
		case 402:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Have a safe trip.\"");
			break;
		case 403:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"Take care of her.\"");
			break;
		case 404:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"She’s in safe hands.\"");
			break;
		case 405:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Jose boards the Castilla headed for Spain. The plan was for the volunteers to board a ship for Cuba there.</html>");
			break;
		case 406:
			this.bg.setIcon(shipDeck);
			this.sprites.setVisible(false);
			this.woman3.setVisible(false);
			this.dialogue.setText("Castilla...");
			break;
		case 407:
			this.dialogue.setText("<html>Aboard the ship, Jose enjoyed the view from the deck. The wonderful sea breeze and the scent of salt, the horizon just over there relaxed the middle aged man.</html>");
			break;
		case 408:
			Frame.manilaBGM.stop();
			this.dialogue.setText("<html>But just as he was enjoying, an unexpected guest calls for his attention…</html>");
			break;
		case 409:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Watching the horizon again, aren’t we?\"");
			break;
		case 410:
			this.sprites.setIcon(brackenCasual);
			this.sprites.setVisible(true);
			this.sprites.setBounds(683-brackenCasual.getIconWidth()/2, 768-brackenCasual.getIconHeight(), brackenCasual.getIconWidth(), brackenCasual.getIconHeight());
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"So you came…\"");
			break;
		case 411:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"You aren’t surprised?\"");
			break;
		case 412:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"Not as surprised as when I first saw you near the sea back then. It truly baffled me that you possessed the scent of the sea no matter where you go…\"</html>");
			break;
		case 413:
			this.sprites.setIcon(brackenMad);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"You say as if me being here is quite normal.\"");
			break;
		case 414:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"If you managed to swim all the way here then yes it is… Ms. Kracken…\"");
			break;
		case 415:
			Frame.krackenBattle.play(999);
			this.nameBox.setVisible(false);
			this.sprites.setVisible(false);
			this.dialogue.setText("<html>Just as Jose said that, Josephine steps to the deck’s edge and hops off of the ship. As she fell to the water, she began morphing into a creature with many tentacles.</html>");
			break;
		case 416:
			this.dialogue.setText("<html>Everyone save Jose panicked at the sight of the form Josephine took.</html>");
			break;
		case 417:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"What did you come here for?!\"");
			break;
		case 418:
			this.sprites.setIcon(brackenKracken);
			this.sprites.setBounds(683-Scene.brackenKracken.getIconWidth()/2, 768-Scene.brackenKracken.getIconHeight(), Scene.brackenKracken.getIconWidth(), Scene.brackenKracken.getIconHeight());
			this.sprites.setVisible(true);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"To rescue you! Those Spaniards are plotting to sentence you to death. I cannot allow that!\"</html>");
			break;
		case 419:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"And you think your actions justify that?!\"");
			break;
		case 420:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("<html>\"So you would remain as stubborn as ever… Very well. Then by force I shall take you!\"</html>");
			break;
		case 421:
			this.dialogue.setText("<html>\"Know that I won’t hold back! If I were to fail from rescuing you then I’d rather kill you myself!\"</html>");
			break;
		case 422:
			Frame.cl.show(Frame.current,"Kracken Battle");
//			System.out.println(Frame.battle.rizalAlive);
			this.nameBox.setVisible(false);
			this.dialogue.setVisible(false);
			break;
		case 423:
			this.dialogue.setVisible(true);
			this.nameBox.setVisible(true);
			if(Frame.battle.rizalAlive)
			{
				this.nameBox.setText("Josephine");
				this.nameBox.setVisible(true);
				this.dialogue.setText("\"Argh!!!\"");
			}
			else if(!Frame.battle.rizalAlive)
			{
				this.nameBox.setText("Jose");
				this.nameBox.setVisible(true);
				this.dialogue.setText("\"Graagh!!!\"");
				this.dialogueTurn = 436;
			}
			break;
		case 424:
			Frame.krackenBattle.stop();
			this.sprites.setVisible(true);
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I don’t understand… With my powers, I can help you avoid your fate…\"");
			break;
		case 425:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I ask you this: in what purpose will I being alive will do?\"");
			break;
		case 426:
			Frame.finalMoments.play(999);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"You could encourage more people to seek reform in this government.\"");
			break;
		case 427:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"I can encourage as much people as I can but if they themselves don’t change then it will never matter…\"</html>");
			break;
		case 428:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"…\"");
			break;
		case 429:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"My desire is for change by the will of the individual not by force. I appreciate your thought in saving me but if I were to be saved by you now would be going against my own ideals…\"</html>");
			break;
		case 430:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Josephine sees the resolve in the man’s eyes. Amongst the wreckage giving away, the will burns ever strongly inside this man before her.</html>");
			break;
		case 431:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("<html>\"This is your last chance. There is a Spanish ship that will be arriving here shortly. I do not wish to be spotted…\"</html>");
			break;
		case 432:
			this.nameBox.setText("Jose");
			this.dialogue.setText("\"I stand firm.\"");
			break;
		case 433:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Then I bid you adieu…\"");
			break;
		case 434:
			this.nameBox.setVisible(false);
			this.sprites.setVisible(false);
			this.dialogue.setText("Josephine recedes within the waters bidding farewell to her beloved.");
			break;
		case 435:
			this.dialogue.setText("<html>A ship passes by shortly after and Jose is arrested for charges of inciting rebellion.</html>");
			break;
		case 436:
			this.bg.setIcon(execution);
			this.dialogue.setText("<html>And on December 30, 1896, Jose would be executed.</html>");
			break;
		case 437:
			Frame.finalMoments.stop();
			Frame.krackenBattle.stop();
			Frame.krackenEndingMusic.play(0);
			this.sprites.setVisible(false);
			this.nameBox.setVisible(false);
			this.bg.setIcon(manila_docks);
			this.dialogue.setText("<html>With the death of her beloved, Josephine goes to the Katipuneros to lend her strength. Unbeknownst to them is that a powerful entity had just sided with them.</html>");
			break;
		case 438:
			this.dialogue.setText("<html>And by the might of the titans, these foolish humans would be smitten by storm and lightning…</html>");
			this.ending = 2;
			this.dialogueTurn = 457;
			break;
		case 439://Ghoul Ending
			this.bg.setIcon(bedroomTypical);
			Frame.everydayTheme.stop();
			this.sprites.setVisible(false);
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>Upon arriving at Manila, the couple decided to stay for a while due to Josephine suddenly falling ill.</html>");
			break;
		case 440:
			this.sprites.setIcon(brackenSad);
			this.sprites.setVisible(true);
			this.woman3.setVisible(true);
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Perhaps it was the mysterious fluid that you injected yourself with…\"");
			break;
		case 441:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Haha… I’m sorry about that…\"");
			break;
		case 442:
			this.nameBox.setText("Jose");
			this.dialogue.setText("<html>\"It’s fine. I’ll try to neutralize that mysterious fluid out of your anatomy. Sister, would you mind helping me?\"</html>");
			break;
		case 443:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"Certainly.\"");
			break;
		case 444:
			this.sprites.setIcon(brackenSad);
			this.woman3.setVisible(false);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"Wait…\"");
			break;
		case 445:
			this.nameBox.setVisible(false);
			this.dialogue.setText("Josephine calls for the two to come near her.");
			break;
		case 446:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"What is it?\"");
			break;
		case 447:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"I’m… hungry…\"");
			break;
		case 448:
			this.nameBox.setText("Narcissa");
			this.dialogue.setText("\"Ah, I’ll prepare food then…\"");
			break;
		case 449:
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"There’s no need for that…\"");
			break;
		case 450:
			this.sprites.setIcon(brackenHappy);
			this.nameBox.setVisible(false);
			this.dialogue.setText("Josephine stands up…");
			break;
		case 451:
			this.nameBox.setText("Jose");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"Josephine?\"");
			break;
		case 452:
			this.sprites.setIcon(brackenGhoul);
			this.nameBox.setText("Josephine");
			this.dialogue.setText("\"You will suffice…\"");
			break;
		case 453:
			this.sprites.setVisible(false);
			this.woman3.setVisible(false);
			this.nameBox.setVisible(false);
			this.setBackground(Color.BLACK);
			this.bg.setIcon(ghoulEat);
			this.dialogue.setText("<html>With red eyes and mouth watering, Josephine pounces on Jose devouring the unsuspecting man. Narcissa would attempt to scream only to be swiftly silenced.</html>");
			break;
		case 454:
			Frame.unravel.play(0);
			this.animation.setVisible(true);
			this.animation.start();
			this.bg.setIcon(blackscreen);
			this.dialogue.setText("<html>Days later, rumors about a deadly man eating monster would strike fear into the hearts of both the Spaniards and the Filipinos. So much that the rebellion would come to a halt in fear that the monster would come and intervene.</html>");
			break;
		case 455:
			this.nameBox.setText("Josephine");
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"I want… more…\"");
			break;
		case 456:
			this.nameBox.setVisible(false);
			this.dialogue.setText("<html>After gorging upon what seems to be a Japanese woman, Josephine takes a liking to the flesh of her recent prey.</html>");
			break;
		case 457:
			this.nameBox.setVisible(true);
			this.dialogue.setText("\"The Land of the Rising Sun, eh?\"");
			this.ending = 3;
			break;
		case 458:
			if(ending == 1)//True Ending
			{
				this.nameBox.setVisible(false);
				this.dialogue.setVisible(false);
				this.bg.setIcon(trueEnding);
			}
			else if(ending == 2)//Kracken Ending
			{
				this.nameBox.setVisible(false);
				this.dialogue.setVisible(false);
				this.bg.setIcon(krackenEnding);
			}
			else if(ending == 3)//Ghoul Ending
			{
				this.animation.setVisible(false);
				this.nameBox.setVisible(false);
				this.dialogue.setVisible(false);
				this.bg.setIcon(ghoulEnding);
			}
			break;
		case 459:
			System.exit(0);
		}
	}

	public JLabel getBg() {
		return bg;
	}

	public void setBg(JLabel bg) {
		this.bg = bg;
	}

	public JLabel getSprites() {
		return sprites;
	}

	public void setSprites(JLabel sprites) {
		this.sprites = sprites;
	}

	public JLabel getMan() {
		return man;
	}

	public void setMan(JLabel man) {
		this.man = man;
	}
	
	public JLabel getWoman() {
		return woman;
	}

	public void setWoman(JLabel woman) {
		this.woman = woman;
	}

	public JLabel getWoman2() {
		return woman2;
	}

	public void setWoman2(JLabel woman2) {
		this.woman2 = woman2;
	}

	public JLabel getWoman3() {
		return woman3;
	}

	public void setWoman3(JLabel woman3) {
		this.woman3 = woman3;
	}

	public JLabel getWoman4() {
		return woman4;
	}

	public void setWoman4(JLabel woman4) {
		this.woman4 = woman4;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(dialogueTurn == 61)
		{
			if(e.getSource() == options[0])
			{
				dialogueTurn = 62;
				this.setDialogue(this.dialogueTurn);
				this.affection += 10;
			}
			else if(e.getSource() == options[1])
			{
				dialogueTurn = 76;
				this.setDialogue(this.dialogueTurn);
				this.affection -= 25;
			}
			else if(e.getSource() == options[2])
			{
				dialogueTurn = 80;
				this.setDialogue(this.dialogueTurn);
				this.affection -= 10;
			}
		}
		else if(dialogueTurn == 187)
		{
			if(e.getSource() == options[0])
			{
				dialogueTurn = 188;
				this.setDialogue(this.dialogueTurn);
				this.affection += 10;
			}
			else if(e.getSource() == options[1])
			{
				dialogueTurn = 211;
				this.setDialogue(this.dialogueTurn);
				this.affection -= 10;
			}
			else if(e.getSource() == options[2])
			{
				dialogueTurn = 213;
				this.setDialogue(this.dialogueTurn);
				this.affection -= 25;
			}
		}
		else if(dialogueTurn == 296)
		{
			if(e.getSource() == options[0])
			{
				dialogueTurn = 297;
				this.setDialogue(this.dialogueTurn);
				this.affection -= 10;
			}
			else if(e.getSource() == options[1])
			{
				dialogueTurn = 299;
				this.setDialogue(this.dialogueTurn);
				this.affection += 100;
			}
			else if(e.getSource() == options[2])
			{
				dialogueTurn = 305;
				this.setDialogue(this.dialogueTurn);
				this.affection -= 999;
			}
		}
		else if(dialogueTurn == 354)
		{
			if(affection > 50)//True
			{
				dialogueTurn = 355;
				this.setDialogue(this.dialogueTurn);
			}
			else if(affection < 50 && affection > -100)//Kracken
			{
				dialogueTurn = 399;
				this.setDialogue(this.dialogueTurn);
			}
			else if(affection < -99)//Ghoul
			{
				dialogueTurn = 439;
				this.setDialogue(this.dialogueTurn);
			}
		}
		else
		{
			dialogueTurn++;
			this.setDialogue(this.dialogueTurn);
		}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
