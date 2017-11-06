import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.text.*;
import java.awt.Font.*;
public class main_game extends Panel  //change standAlone to your file name
{
	private Image offScreenImage;
	private Dimension offScreenSize;
	private Graphics offScreenGraphics;
	final boolean RESIZEABLE = false;
	int width = 1280-10;
	int height = 1024-10;
	Image virtualMem;
	Graphics2D gBuffer;
	InputHandler keyboard;
	public static void main(String[] args)
	{
  		Frame f = new Frame();
  		f.addWindowListener(new java.awt.event.WindowAdapter() {
       		public void windowClosing(java.awt.event.WindowEvent e) {
       		System.exit(0);
       		};
     	});
  		main_game window = new main_game();  //change standAlone to your file name
  		window.setSize(1050,650);
		f.add(window);
		f.pack();
		window.init();
		f.setSize(1050,650);/*size of frame*/
		f.show();
	}
	//required for user input
	public boolean mouseMove(Event e, int x, int y){return InputHandler.mouseUpdate(x,y);}
	public boolean mouseDrag(Event e, int x, int y){return InputHandler.mouseUpdate(x,y);}
	public boolean mouseDown(Event e, int x, int y){return InputHandler.mouseChange(e,true );}
	public boolean mouseUp  (Event e, int x, int y){return InputHandler.mouseChange(e,false);}
	public boolean keyDown(Event e, int key){return InputHandler.keyChange(e,key,true);}
	public boolean keyUp  (Event e, int key){return InputHandler.keyChange(e,key,false);}
	public void resizeWindow()  //Does not let the use resize the window
	{
		if(RESIZEABLE)
		{
			if(getHeight() != height + 10 || getWidth() != width + 10 )	//check if window has been resized
			{
				height = getHeight() - 10;		//set height/width variables
				width = getWidth() - 10;
				virtualMem = createImage(width+20,height+20);	//change buffer size
				gBuffer = (Graphics2D)virtualMem.getGraphics();
				gBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
		}else
			setSize(width+10,height+10);
	}
	public void update(Graphics g)
	{
		Dimension d = size();
		if((offScreenImage == null) || (d.width != offScreenSize.width) || (d.height != offScreenSize.height)) {
			 offScreenImage = createImage(d.width, d.height);
			 offScreenSize = d;
			 offScreenGraphics = offScreenImage.getGraphics();
		}
		offScreenGraphics.clearRect(0, 0, d.width, d.height);
		paint(offScreenGraphics);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	//declare static variables here
	ArrayList<letters> list = new ArrayList<letters>();
	row1 field = new row1(0,0);
	heart hearts = new heart();

	public void init()  //runs once at the beginning of the program
	{
		requestFocus();
list.add(new letters(70,800,"assests/A_key.png"));
list.add(new letters(70,800,"assests/B_key.png"));
list.add(new letters(70,800,"assests/C_key.png"));
list.add(new letters(70,800,"assests/D_key.png"));
list.add(new letters(70,800,"assests/E_key.png"));
list.add(new letters(70,800,"assests/F_key.png"));
list.add(new letters(70,800,"assests/G_key.png"));
list.add(new letters(70,800,"assests/H_key.png"));
list.add(new letters(70,800,"assests/I_key.png"));
list.add(new letters(70,800,"assests/J_key.png"));
list.add(new letters(70,800,"assests/K_key.png"));
list.add(new letters(70,800,"assests/L_key.png"));
list.add(new letters(70,800,"assests/M_key.png"));
list.add(new letters(70,800,"assests/N_key.png"));
list.add(new letters(70,800,"assests/O_key.png"));
list.add(new letters(70,800,"assests/P_key.png"));
list.add(new letters(70,800,"assests/Q_key.png"));
list.add(new letters(70,800,"assests/R_key.png"));
list.add(new letters(70,800,"assests/S_key.png"));
list.add(new letters(70,800,"assests/T_key.png"));
list.add(new letters(70,800,"assests/U_key.png"));
list.add(new letters(70,800,"assests/V_key.png"));
list.add(new letters(70,800,"assests/W_key.png"));
list.add(new letters(70,800,"assests/X_key.png"));
list.add(new letters(70,800,"assests/Y_key.png"));
list.add(new letters(70,800,"assests/Z_key.png"));

	}
int paco=0;
	public void paint(Graphics g)//makes pretty pictures
	{

		field.draw(g,this);
		field.letterGen();
		hearts.draw(g,this,field.lives);
//System.out.println(field.listofLetters.size());
		try{Thread.sleep(4);} catch(Exception e){}
		repaint();
	}


}

class InputHandler	//class to handle input
{
	public InputHandler()
	{
	}
	//ids for keys
public static final int id_UP		= 1004;
	public static final int id_DOWN		= 1005;
	public static final int id_LEFT		= 1006;
	public static final int id_RIGHT	= 1007;
	public static final int id_SPACE	= 32;
	public static final int id_ESC		= 27;


	public static final int id_A		= 65;
	public static final int id_B		= 66;
	public static final int id_C		= 67;
	public static final int id_D		= 68;
	public static final int id_E		= 69;
	public static final int id_F		= 70;
	public static final int id_G		= 71;
	public static final int id_H		= 72;
	public static final int id_I		= 73;
	public static final int id_J		= 74;
	public static final int id_K		= 75;
	public static final int id_L		= 76;
	public static final int id_M		= 77;
	public static final int id_N		= 78;
	public static final int id_O		= 79;
	public static final int id_P		= 80;
	public static final int id_Q		= 81;
	public static final int id_R		= 82;
	public static final int id_S		= 83;
	public static final int id_T		= 84;
	public static final int id_U		= 85;
	public static final int id_V		= 86;
	public static final int id_W		= 87;
	public static final int id_X		= 88;
	public static final int id_Y		= 89;
	public static final int id_Z		= 90;


	//boolean values determine if key is pressed
	public static boolean UP	= false;
	public static boolean DOWN	= false;
	public static boolean LEFT	= false;
	public static boolean RIGHT	= false;

	public static boolean SPACE = false;
	public static boolean X 	= false;

	public static boolean W		= false;
	public static boolean A		= false;
	public static boolean S		= false;
	public static boolean D		= false;

	public static boolean I		= false;
	public static boolean J		= false;
	public static boolean K		= false;
	public static boolean L		= false;

	public static boolean P		= false;
	public static boolean ESC	= false;

	public static boolean B		= false;
	public static boolean C		= false;
	public static boolean E		= false;
	public static boolean F		= false;
	public static boolean G		= false;
	public static boolean H		= false;
	public static boolean M		= false;
	public static boolean N		= false;
	public static boolean O		= false;
	public static boolean Q		= false;
	public static boolean R		= false;
	public static boolean T		= false;
	public static boolean U		= false;
	public static boolean V		= false;
	public static boolean Y		= false;
	public static boolean Z		= false;



	//mouse info
	public static boolean MOUSE_LEFT	= false;
	public static boolean MOUSE_RIGHT	= false;

	public static int MOUSE_X	= 0;
	public static int MOUSE_Y	= 0;

	public static boolean keyChange(Event e, int key, boolean newKeyState)
	{		//changes key state variables to correct values
		switch(key)
		{
				case id_UP:// Up
			InputHandler.UP = newKeyState;
			// System.out.println("Yup");
			break;
		case InputHandler.id_DOWN:// Down
			InputHandler.DOWN = newKeyState;
			break;
		case InputHandler.id_LEFT:// Left
			InputHandler.LEFT = newKeyState;
			break;
		case InputHandler.id_RIGHT:// Right
			InputHandler.RIGHT = newKeyState;
			break;

		case InputHandler.id_SPACE:// space
			InputHandler.SPACE = newKeyState;
			break;
		case InputHandler.id_X:// space
			InputHandler.X = newKeyState;
			break;

		case InputHandler.id_W:// Up
			InputHandler.W = newKeyState;
			break;
		case InputHandler.id_S:// Down
			InputHandler.S = newKeyState;
			break;
		case InputHandler.id_A:// Left
			InputHandler.A = newKeyState;
			break;
		case InputHandler.id_D:// Right
			InputHandler.D = newKeyState;
			break;

		case InputHandler.id_I:// Up
			InputHandler.I = newKeyState;
			break;
		case InputHandler.id_J:// Down
			InputHandler.J = newKeyState;
			break;
		case InputHandler.id_K:// Left
			InputHandler.K = newKeyState;
			break;
		case InputHandler.id_L:// Right
			InputHandler.L = newKeyState;
			break;

		case InputHandler.id_P:
			InputHandler.P = newKeyState;
			break;
		case InputHandler.id_ESC:
			InputHandler.ESC = newKeyState;
			break;

		case InputHandler.id_B:// B
			InputHandler.B = newKeyState;
			break;

		case InputHandler.id_C:// C
			InputHandler.C = newKeyState;
			break;

		case InputHandler.id_E:// E
			InputHandler.E = newKeyState;
			break;

		case InputHandler.id_F:// F
			InputHandler.F = newKeyState;
			break;

		case InputHandler.id_G:// G
			InputHandler.G = newKeyState;
			break;

		case InputHandler.id_H:// H
			InputHandler.H = newKeyState;
			break;

		case InputHandler.id_M:// M
			InputHandler.M = newKeyState;
			break;

		case InputHandler.id_N:// N
			InputHandler.N = newKeyState;
			break;

		case InputHandler.id_O:// O
			InputHandler.O = newKeyState;
			break;

		case InputHandler.id_Q:// Q
			InputHandler.Q = newKeyState;
			break;

		case InputHandler.id_R:// R
			InputHandler.R = newKeyState;
			break;

		case InputHandler.id_T:// T
			InputHandler.T = newKeyState;
			break;

		case InputHandler.id_U:// U
			InputHandler.U = newKeyState;
			break;

		case InputHandler.id_V:// V
			InputHandler.V = newKeyState;
			break;

		case InputHandler.id_Y:// Y
			InputHandler.Y = newKeyState;
			break;

		case InputHandler.id_Z:// Z
			InputHandler.Z = newKeyState;
			break;



		default:
			System.out.print(key);	//print any unbound key presses- may spam console
			if(newKeyState)
				System.out.println(" down");
			else
				System.out.println(" up");
			break;
		}
		return true;
	}

	public static boolean mouseUpdate(int x, int y)	//handles mouse movement
	{
		InputHandler.MOUSE_X = x;
		InputHandler.MOUSE_Y = y;
		//System.out.println("\n\n\n\n"+x+"   "+y);
		return true;
	}

	public static boolean mouseChange(Event e, boolean newKeyState)	//handles mouse clicks
	{
		if(e.metaDown())
			InputHandler.MOUSE_RIGHT	= newKeyState;
		else
			InputHandler.MOUSE_LEFT		= newKeyState;
		return true;
	}
}

	//write additional methods here
class letters
{
	Image pic;
	int x;
	int	y;
	int xd=-3;
	int speedTimer = 0;
	String value="";
	int charValue;
	Font leFont = new Font("TimesRoman", Font.BOLD,90);


	public letters(int ex, int why, String let)
	{
		x = ex;
		y = why;
		value=let;
		charValue=(int)(let.charAt(0));
		try{pic=ImageIO.read(getClass().getResource(let));}catch(Exception e){}
	}
	public void draw(Graphics g, main_game e)
	{
//System.out.println("letters draw");
	//	g.drawImage(pic,x,y,60,60,e);
		g.setFont(leFont);
		g.drawString(""+(char)charValue,x,y+60);
		move();

//System.out.println("letters stop");
	}
	public void move()
	{
//System.out.println("letters move");
		x+=xd;

		if(speedTimer<=3050)
			speedTimer++;

		if(speedTimer>=1000)
			xd=-4;
		if(speedTimer>=2000)
			xd=-5;
		if(speedTimer>=3000)
			xd=-6;

		//System.out.println(speedTimer);
//System.out.println("letters stop");
	}

}
class row1
{
	ArrayList<letters> listofLetters = new ArrayList<letters>();
	int x;
	int y;
	int exitTimer=0;
	Color t = new Color(115,142,172);
	int score=0;
	Font myFont = new Font("TimesRoman", Font.BOLD, 20);
	Font gaFont = new Font("TimesRoman", Font.BOLD,200);
	int lives=3;
	int exciteA=0;


	public row1(int ex, int why)
	{
		x=ex;
		y=why;
	}


	public void draw(Graphics g,main_game e)
	{
//System.out.print("row1 draw");

	exitTimer--;

	g.setColor(new Color(0,0,0));
	g.setFont(myFont);
	g.drawString(""+score,x+350,y+36);
	g.drawString("Type Type Revolution",x+650,y+36);

	g.setColor(t);
	g.fillRect(x,y+59,1285,60);
	g.setColor(Color.black);
	g.fillRect(60,59,7,60);
	g.fillRect(300,59,7,60);
	g.setColor(t);
	g.fillRect(x,y+178,1285,60);
	g.setColor(Color.black);
	g.fillRect(60,178,7,60);
	g.fillRect(300,178,7,60);
	g.setColor(t);
	g.fillRect(x,y+297,1285,60);
	g.setColor(Color.black);
	g.fillRect(60,297,7,60);
	g.fillRect(300,297,7,60);
	g.setColor(t);
	g.fillRect(x,y+416,1285,60);
	g.setColor(new Color(0,0,0));
	g.fillRect(60,416,7,60);
	g.fillRect(300,416,7,60);
	g.setColor(t);
	g.fillRect(x,y+535,1285,60);
	g.setColor(new Color(0,0,0));
	g.fillRect(60,535,7,60);
	g.fillRect(300,535,7,60);
	g.setColor(t);
	g.fillRect(x,y+654,1285,60);
	g.setColor(new Color(0,0,0));
	g.fillRect(60,654,7,60);
	g.fillRect(300,654,7,60);
	g.setColor(t);
	g.fillRect(x,y+773,1285,60);
	g.setColor(new Color(0,0,0));
	g.fillRect(60,773,7,60);
	g.fillRect(300,773,7,60);
	g.setColor(t);
	g.fillRect(x,y+892,1285,60);
	g.setColor(new Color(0,0,0));
	g.fillRect(60,892,7,60);
	g.fillRect(300,892,7,60);


//	if(lives<=-1)
//		g.setColor(Color.black);
//		g.setFont(gaFont);
//		g.drawString("GAME OVER",0,500);



		//System.out.println(exitTimer);


		for (int a = 0; a<listofLetters.size();a++)
	{
			listofLetters.get(a).draw(g,e);
			listofLetters.get(a).move();
			if(listofLetters.get(a).x<=-60)
			{	lives--;
				listofLetters.remove(a--);continue;}


		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.A&&exciteA==0)
					{score++;
					exciteA=0;
					listofLetters.remove(a--);continue;}}

		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.B)
				{score++;
				listofLetters.remove(a--);continue;}}

				if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.C)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.D)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.E)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.F)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.G)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.H)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.I)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.J)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.K)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.L)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.M)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.N)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.O)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.P)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.Q)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.R)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.S)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.T)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.U)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.V)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.W)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.X)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.Y)
				{score++;
				listofLetters.remove(a--);continue;}}
		if(listofLetters.get(a).x<300&&key(listofLetters.get(a).charValue))
			{if(InputHandler.Z)
				{score++;
				listofLetters.remove(a--);continue;}}

	}//System.out.println("row1 stop");
	}
public boolean key(int i)
{

	if(InputHandler.A&&i==65)
		return true;

	if(InputHandler.B&&i==66)
		return true;

	if(InputHandler.C&&i==67)
		return true;

	if(InputHandler.D&&i==68)
		return true;

	if(InputHandler.E&&i==69)
		return true;

	if(InputHandler.F&&i==70)
		return true;

	if(InputHandler.G&&i==71)
		return true;

	if(InputHandler.H&&i==72)
		return true;

	if(InputHandler.I&&i==73)
		return true;

	if(InputHandler.J&&i==74)
		return true;

	if(InputHandler.K&&i==75)
		return true;

	if(InputHandler.L&&i==76)
		return true;

	if(InputHandler.M&&i==77)
		return true;

	if(InputHandler.N&&i==78)
		return true;

	if(InputHandler.O&&i==79)
		return true;

	if(InputHandler.P&&i==80)
		return true;

	if(InputHandler.Q&&i==81)
		return true;

	if(InputHandler.R&&i==82)
		return true;

	if(InputHandler.S&&i==83)
		return true;

	if(InputHandler.T&&i==84)
		return true;

	if(InputHandler.U&&i==85)
		return true;

	if(InputHandler.V&&i==86)
		return true;

	if(InputHandler.W&&i==87)
		return true;

	if(InputHandler.X&&i==88)
		return true;

	if(InputHandler.Y&&i==89)
		return true;

	if(InputHandler.Z&&i==90)
		return true;

		return false;
}

public void letterGen()
{
//System.out.println("row1 letterGen");

if(exitTimer<0)
	{
	char letterChar=(char)(Math.random()*26+65);
	String f = ""+letterChar+"_key.png";
    //System.out.println(f);

	int rowLetterChar = (int)(Math.random()*9);
	//System.out.println(rnd2);

	if(rowLetterChar==1)
		listofLetters.add(new letters(x+1285,y+59,f));
		exitTimer=30;
	if(rowLetterChar==2)
		listofLetters.add(new letters(x+1285,y+178,f));
		exitTimer=30;
	if(rowLetterChar==3)
		listofLetters.add(new letters(x+1285,y+297,f));
		exitTimer=30;
	if(rowLetterChar==4)
		listofLetters.add(new letters(x+1285,y+416,f));
		exitTimer=30;
	if(rowLetterChar==5)
		listofLetters.add(new letters(x+1285,y+535,f));
		exitTimer=30;
	if(rowLetterChar==6)
		listofLetters.add(new letters(x+1285,y+654,f));
		exitTimer=30;
	if(rowLetterChar==7)
		listofLetters.add(new letters(x+1285,y+773,f));
		exitTimer=50;
	if(rowLetterChar==8)
		listofLetters.add(new letters(x+1285,y+892,f));
		exitTimer=50;
		}
//System.out.println("row1 stop");
}
}
class heart
{
	Image pic;
	int x;
	int y;

	public heart()
	{
		try{pic=ImageIO.read(getClass().getResource("assests/heartsl.png"));}catch(Exception e){System.out.println("oops");}
	}
	public void draw(Graphics g, main_game e,int lives)
	{
//System.out.println("heart draw");
		//System.out.println(lives);
		for(int a=0;a<lives;a++)
		g.drawImage(pic,x+55,10,50,50,e);
		if (lives>=2)
		g.drawImage(pic,x+155,10,50,50,e);
		if (lives==3)
		g.drawImage(pic,x+255,10,50,50,e);


//System.out.println("heart stop");

	}
}









//write additional classes here