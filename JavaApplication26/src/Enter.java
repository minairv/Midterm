
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.FlowView;

public class Enter extends JFrame //implements KeyListener
{		
		private JFrame frame = new JFrame();//my main frame
		private JPanel panel = new JPanel();//my main panel
		private JButton enrollbutton = new JButton("Enrollment");//in first page
		private JButton signinbutton = new JButton("sign in");//in first page
		private JTextField nametxt = new  JTextField();//for enroll and sign in
		private JTextField passtxt = new  JTextField();//for enroll and sign in
		private JButton confirmbutton = new JButton("enroll");//for confirming enrollment
		private JButton logginbutton = new JButton("login");//for confirming logging in
		private JLabel playinglabel = new JLabel("****** press Start to play! ****** ");
		private JLabel selectlabel = new JLabel("****** Choose level of playing! ****** ");
		private JLabel enterlabel1 = new JLabel("press 'Sign in' to get in your account");
		private JLabel enterlabel2 = new JLabel("press 'Enrollment' to create an account");
		private JButton easybutton = new JButton("Easy");
		private JButton hardbutton = new JButton("Hard");
		private JLabel namelbl = new JLabel("Enter your name");
		private JLabel passlbl = new JLabel("Enter your password");
		
		File file = new File("E:\\test\\myplayer.txt");
               
		
		ArrayList<String> ListOfPlayers= new ArrayList<String>();
		ArrayList <String> list = new ArrayList<String>();

		public Enter() throws IOException
		{			
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			frame.setBounds(400,170, 800,800);
			frame.setTitle("*********WelCome To MaZe*********");
                    System.out.println("");	
			enrollbutton.setBackground(Color.green);
			enrollbutton.setFont(new Font(" ", 1, 18));
			
			signinbutton.setBackground(Color.green);
			signinbutton.setFont(new Font(" ", 1, 18));
			
			easybutton.setBackground(Color.magenta);
			easybutton.setFont(new Font(" ", 1, 18));
			
			hardbutton.setBackground(Color.magenta);
			hardbutton.setFont(new Font(" ", 1, 18));
			
			confirmbutton.setBackground(Color.lightGray);
			confirmbutton.setFont(new Font(" ", 1, 25));
			
			logginbutton.setBackground(Color.lightGray);
			logginbutton.setFont(new Font(" ", 1, 25));
			
			panel.setPreferredSize(new Dimension(50,50));
			panel.setBackground(Color.yellow);
			panel.setLayout(null);
			
			nametxt.setFont(new Font(" ",1,22));
			passtxt.setFont(new Font(" ",1,22));
			
			playinglabel.setBackground(Color.black);
			playinglabel.setBounds(230, -200, 500,500);
			playinglabel.setFont(new Font("", 1, 25));
			
			selectlabel.setBackground(Color.black);
			selectlabel.setBounds(200, -150, 500,500);
			selectlabel.setFont(new Font("", 1, 25));
			
			enterlabel1.setBackground(Color.black);
			enterlabel1.setBounds(200,-200, 800,800);
			enterlabel1.setFont(new Font("", 1, 25));
			
			enterlabel2.setBackground(Color.black);
			enterlabel2.setBounds(200, -230, 800,800);
			enterlabel2.setFont(new Font("", 1, 25));
			
			namelbl.setBackground(Color.black);
			namelbl.setBounds(100,-350, 800,800);
			namelbl.setFont(new Font("",1, 25));
			
			passlbl.setBackground(Color.black);
			passlbl.setBounds(100,-255, 800,800);
			passlbl.setFont(new Font("", 1, 25));
			
			logginbutton.setBounds(330, 300, 150, 150);
			confirmbutton.setBounds(330, 300, 150, 150);
			enrollbutton.setBounds(200,300,150,150);
			signinbutton.setBounds(470, 300,150,150);
			easybutton.setBounds(200,300,150,150);
			hardbutton.setBounds(470, 300,150,150);
			nametxt.setBounds(450, 30, 250, 50);
			passtxt.setBounds(450, 120, 250, 50);
			
			panel.add(namelbl);
			panel.add(passlbl);
			panel.add(enrollbutton);
			panel.add(signinbutton);
			panel.add(easybutton);
			panel.add(hardbutton);
			panel.add(nametxt);
			panel.add(passtxt);
			panel.add(confirmbutton);
			panel.add(logginbutton);
			panel.add(playinglabel);
			panel.add(selectlabel);
			panel.add(enterlabel1);
			panel.add(enterlabel2);

			frame.getContentPane().add(panel);
			
			frame.setVisible(true);

			namelbl.setVisible(false);
			passlbl.setVisible(false);
			nametxt.setVisible(false);
			passtxt.setVisible(false);
			logginbutton.setVisible(false);
			confirmbutton.setVisible(false);
			playinglabel.setVisible(false);
			selectlabel.setVisible(false);
			easybutton.setVisible(false);
			hardbutton.setVisible(false);
			
			Scanner s = null;
			try 
			{
				s = new Scanner(file);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			while(s.hasNext())
			{
				list.add(s.next());
			}
				
			s.close();
			
			enrollbutton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					panel.setBackground(Color.RED);
					frame.setTitle("**********EnrollMent**********");
					enrollbutton.setVisible(false);
					signinbutton.setVisible(false);
					enterlabel1.setVisible(false);
					enterlabel2.setVisible(false);
					nametxt.setVisible(true);
					passtxt.setVisible(true);
					namelbl.setVisible(true);
					passlbl.setVisible(true);
					confirmbutton.setVisible(true);
				}
			});
			
			signinbutton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					panel.setBackground(Color.RED);
					frame.setTitle("********Signing In***********");
					enrollbutton.setVisible(false);
					signinbutton.setVisible(false);
					enterlabel1.setVisible(false);
					enterlabel2.setVisible(false);
					nametxt.setVisible(true);
					passtxt.setVisible(true);
					namelbl.setVisible(true);
					passlbl.setVisible(true);
					logginbutton.setVisible(true);
				}
			});
			
			
			logginbutton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{						
					for(int i=0 ; i<list.size()-1 ; i+=2)
					{	
						if(nametxt.getText().matches(list.get(i)))
						{
							int j=i+1;
							if(passtxt.getText().matches(list.get(j)))
							{
								nametxt.setVisible(false);
								passtxt.setVisible(false);
								logginbutton.setVisible(false);
								namelbl.setVisible(false);
								passlbl.setVisible(false);
								selectlabel.setVisible(true);
								easybutton.setVisible(true);
								hardbutton.setVisible(true);	
								panel.setBackground(Color.pink);
								frame.setTitle("**********Choosing Level***********");								
								
							}
	
						}
		
					}
						
				}
			});

			easybutton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					playinglabel.setVisible(true);
					easybutton.setVisible(false);
					hardbutton.setVisible(false);
					panel.setBackground(Color.CYAN);
					frame.setTitle("***********Lets Play***********");
					frame.setVisible(false);
					frame.dispose();
					//game a = new game();
					EasyGame g = new EasyGame();
					
					//a.time();
					//g.setVisible(true);
				}
			});
			
			hardbutton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					playinglabel.setVisible(true);
					easybutton.setVisible(false);
					hardbutton.setVisible(false);
					panel.setBackground(Color.CYAN);
					frame.setTitle("***********Lets Play***********");
					HardGame h = new HardGame();
					h.setVisible(true);
				}
			});
			
			confirmbutton.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					nametxt.setVisible(false);
					passtxt.setVisible(false);
					confirmbutton.setVisible(false);
					namelbl.setVisible(false);
					passlbl.setVisible(false);
					selectlabel.setVisible(true);
					easybutton.setVisible(true);
					hardbutton.setVisible(true);	
					panel.setBackground(Color.pink);
					frame.setTitle("**********Choosing Level***********");
					
					ListOfPlayers.add(nametxt.getText() + "\n");
					ListOfPlayers.add(passtxt.getText() + "\n");
					
					
				
					FileWriter fw = null;
						try 
						{
							fw = new FileWriter(file.getAbsoluteFile(),true);
						} 
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
						BufferedWriter bw = new BufferedWriter(fw);
						
						   for(int i=0;i<ListOfPlayers.size();i++)
						   {
							   try
							   {
								   bw.append(ListOfPlayers.get(i).toString()); 
							   } 
							   catch (IOException e1) 
							   {
								e1.printStackTrace();
							   }
						   }

			
						   	try 
						   	{
							bw.close();
						   	}
						   	catch (IOException e1) 
						   	{
							e1.printStackTrace();
						   	}
				
				}
			});
			
		}
}