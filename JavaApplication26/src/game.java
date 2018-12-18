import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.FlowView;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;

public class game extends JFrame
{
	
protected int score=0;
protected int time=200;
protected int userx=70;
protected int usery=685;
protected int xo;
protected int yo;
protected int x[];
protected int y[];
protected int obsnum;
JPanel panel = new JPanel();
JButton upbutton = new JButton("Up");
JButton dnbutton = new JButton("down");
JButton rbutton = new JButton("right");
JButton lbutton = new JButton("left");
JButton Scorebtn = new JButton("Score = " + this.score);
JButton timebtn = new JButton("time = " + this.time);
JLabel scorelbl = new JLabel("you lost!!!!!\n your Score is : " + this.score);

//constructor....................

public game()
{
	this.setBounds(400,170, 800,800);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle("<<<<<<<<MAZE>>>>>>>>");
	
	upbutton.setBackground(Color.green);
	upbutton.setFont(new Font("",1,20));
	
	rbutton.setBackground(Color.YELLOW);
	rbutton.setFont(new Font("",1,20));
	
	lbutton.setBackground(Color.MAGENTA);
	lbutton.setFont(new Font("",1,20));
	
	dnbutton.setBackground(Color.CYAN);
	dnbutton.setFont(new Font("",1,20));
	
	Scorebtn.setFont(new Font("",1,25));
	
	timebtn.setFont(new Font("",1,25));
	
	scorelbl.setBackground(Color.BLACK);
	scorelbl.setBounds(200, 200, 200, 200);
	scorelbl.setFont(new Font("", 1, 30));
	
	
	dnbutton.setBounds(620,400,100,80);
	lbutton.setBounds(560,300,100,80);
	rbutton.setBounds(665,300,100,80);
	upbutton.setBounds(620,200,100,80);
	Scorebtn.setBounds(580,20,170,50);
	timebtn.setBounds(580,90,170,50);
	
	this.setLayout(null);
	this.add(upbutton);
	this.add(rbutton);
	this.add(lbutton);
	this.add(dnbutton);
	this.add(Scorebtn);
	this.add(scorelbl);
	this.add(timebtn);
	
	//scorelbl.setVisible(false);
	
	upbutton.addActionListener(new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			moveup(getGraphics());
		}
	});

	dnbutton.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			movedown(getGraphics());
		}
	});
	
	rbutton.addActionListener(new ActionListener() 
		{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			moveright(getGraphics());
		} 

	});

	lbutton.addActionListener(new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
				moveleft(getGraphics());
		} 
	});
	
	this.setVisible(true);

}//end of constructor

	public void paint(Graphics g)
	{
		
		//border..........................................
		g.setColor(Color.RED);
		g.drawRect(60,60, 500, 660);
		
		
		//user............................................
		g.setColor(Color.blue);
		g.fillOval(userx,usery,30,30);
	System.out.println("");
		
		//aim...............................................
		Random randomx = new Random();
		this.xo=randomx.nextInt(500)+60;
		
		Random randomy = new Random();
		this.yo = randomy.nextInt(660)+60;
		
		if(this.xo>500)
		{
			this.xo=500;
		}
		
		
		if(this.yo>660)
		{
			this.yo=660;
		}
		
		g.setColor(Color.black);
		g.fillOval(xo,yo,30,30);
       
		
		//obstacle...........................

	}
	
	
	public void moveup(Graphics g1) 
	{
		g1.setColor(Color.white);//user
		g1.fillOval(this.userx,this.usery,30,30);	
		
		this.usery=this.usery-30;
		
		g1.setColor(Color.blue);
		g1.fillOval(this.userx,this.usery,30,30);
		
		wallAcc();
		obsAcc();
	}
	
	public void movedown(Graphics g2)
	{
		g2.setColor(Color.WHITE);
		g2.fillOval(this.userx,this.usery,30,30);
		
		this.usery=usery+30;

		
		g2.setColor(Color.blue);
		g2.fillOval(this.userx,this.usery,30,30);
		
		wallAcc();
		obsAcc();
	}
	
	public void moveright(Graphics g3)
	{
		g3.setColor(Color.WHITE);
		g3.fillOval(this.userx,this.usery,30,30);
		
		this.userx=userx+30;
		
		g3.setColor(Color.blue);
		g3.fillOval(this.userx,this.usery,30,30);
		
		wallAcc();
		obsAcc();
	}
	
	public void moveleft(Graphics g4)
	{
		g4.setColor(Color.WHITE);
		g4.fillOval(this.userx,this.usery,30,30);
		
		this.userx=userx-30;
			
		g4.setColor(Color.blue);
		g4.fillOval(this.userx,this.usery,30,30);
		
		wallAcc();
		obsAcc();
	}


	public void wallAcc()
	{
		if(this.userx< 60|| this.userx>530 || this.usery>685 || this.usery<60 )//barkhord ba divare
		{
			try
			{
				//scorelbl.setVisible(true);
				//scorelbl.setText("you lost!!!!!\n your Score is : " + this.score);
				Thread.sleep(2000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	public void obsAcc()
	{
		for(int i = 0 ; i<this.obsnum/2 ; i++)//vertical//barkhord ba mane
		{
			if(this.userx>=this.x[i]-30  && this.userx<=this.x[i]+20 &&
					this.usery>=this.y[i]-30 && this.usery<=this.y[i]+150)
			{
				//try
				//{
					//scorelbl.setVisible(true);
					//scorelbl.setText("you lost!!!!!\n your Score is : " + this.score);
					//Thread.sleep(2000);
				//} 
				//catch (InterruptedException e)
				//{
					//e.printStackTrace();
				//}
				System.exit(0);
			}
		}
		
		for(int i =this.obsnum/2 ; i<this.obsnum ; i++)//Horizon
		{
			if(this.userx>=this.x[i]-30  && this.userx<=this.x[i]+150 &&
					this.usery>=this.y[i]-30 && this.usery<=this.y[i]+20)
			{
				//try 
				//{
					//scorelbl.setVisible(true);
					//scorelbl.setText("you lost!!!!!\n your Score is : " + this.score);
					//Thread.sleep(2000);
				//}
				//catch (InterruptedException e) 
				//{
					//e.printStackTrace();
				//}
				System.exit(0);
			}
		}
	}
		

	
}//end of class
