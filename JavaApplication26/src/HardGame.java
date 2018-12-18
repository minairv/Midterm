import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class HardGame extends game
{
	public HardGame() //throws InterruptedException
	{
		super();
		
		System.out.println(this.time);
		
		this.time=this.time-100;
		
		while(this.time>=0)
		{
			this.time=this.time-1;
			timebtn.setText("time = " + this.time);
			System.out.println("");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}//end of constructor
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.RED);
	
		Random randomnumber = new Random();
		this.obsnum= randomnumber.nextInt(18)+5;
	
		this.x=new int [this.obsnum];
		this.y=new int [this.obsnum];
	
		if(obsnum>18)
		{
			obsnum=18;
		}
	
		for(int i=0; i<obsnum ; i++)
		{
			Random randx=new Random();
			this.x[i] = randx.nextInt(410)+80;
		
			Random randy = new Random();
			this.y[i] = randy.nextInt(510)+80;
		
			if(x[i]>410)
			{
				x[i]=370;
			}
		
			if( y[i]>510)
			{
				y[i]=490;
			}	
		
			if(i<obsnum/2)
			{
				g.fillRect(this.x[i],this.y[i],20,150);
				g.setColor(Color.RED);
			}
			else
			{
				g.fillRect(this.x[i],this.y[i],150,20);
				g.setColor(Color.RED);
			}
		
		}	
    }	
	
	@Override
	public void  moveup(Graphics g1)
	{
		super.moveup(g1);
		goalAcc(getGraphics());
	}
	
	@Override
	public void  movedown(Graphics g2)
	{
		super.movedown(g2);
		goalAcc(getGraphics());
	}
	
	@Override
	public void  moveright(Graphics g3)
	{
		super.moveright(g3);
		goalAcc(getGraphics());
	}
	
	@Override
	public void  moveleft(Graphics g4)
	{
		super.moveleft(g4);
		goalAcc(getGraphics());
	}
	
	public void goalAcc(Graphics g5)
	{
		if(this.userx>=this.xo-30 && this.userx<=this.xo+30 &&//barkhord ba hadaf
			this.usery>=this.yo-30 && this.usery<=this.yo+30)
		  {
			this.score=this.score+2;
			Scorebtn.setText("Score=" + this.score);
			this.time=this.time+10;
			timebtn.setText("time=" + this.time);
			
			g5.setColor(Color.white);
			g5.fillOval(this.xo,this.yo,30,30);
			
			Random randomx = new Random();
			this.xo=randomx.nextInt(500)+60;
			
			Random randomy = new Random();
			this.yo= randomy.nextInt(660)+60;
			
			if(this.xo>500)
			{
				this.xo=500;
			}
			
			
			if(this.yo>660)
			{
				this.yo=660;
			}

			if(this.time>0)
			{
				g5.setColor(Color.BLACK);
				g5.fillOval(this.xo,this.yo, 30, 30);
			}
			
		}		
	}
	
}
