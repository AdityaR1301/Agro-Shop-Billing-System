package Agro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import javax.swing.*;

public class main_f {
 	JFrame f3;
	JLabel l,b1,b2,b3;
	//JButton b1,b2;
	JPanel p1,p2,p3;
	JMenuBar menu;
	JMenu h,i,ii,bb,lo;
	JMenuItem i1,i2,i3,i4,ii1,ii2,ii3,ii4,bb1,bb2,lo1;
	ImageIcon sa[];
	int j,l1,x=0;
	Timer tm;
		
	public main_f() {
		
		f3=new JFrame();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		f3.setBackground(Color.white);
		p1.setBackground(new Color(255,255,255));
		p1.setBounds(0, 0,Toolkit.getDefaultToolkit().getScreenSize().width,150);
		
		ImageIcon bgimg=new ImageIcon("src/Agro/img/logo2.jpg");
		Image img =bgimg.getImage();
		Image tempi=img.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
		bgimg=new ImageIcon(tempi);
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.setBackground(new Color(38,166,00));
		bg.setBounds(0,0,300,150);
		p1.add(bg);
		

		ImageIcon ui=new ImageIcon("src/Agro/img/icon_as.png");

		Image  ui1=ui.getImage();
		Image ui2=ui1.getScaledInstance(150,150, Image.SCALE_SMOOTH);
		ImageIcon uii=new ImageIcon(ui2);
		
		
		l=new JLabel(uii);
		l.setBounds(40, 10, 150, 150);
		l.setForeground(Color.WHITE);
		f3.add(l);
		
		
		ImageIcon ul=new ImageIcon("src/Agro/img/icon_as1.png");
		Image  ul11=ul.getImage();
		Image ul21=ul11.getScaledInstance(150,150, Image.SCALE_SMOOTH);
		ImageIcon uii1=new ImageIcon(ul21);

		l=new JLabel(uii1);
		l.setBounds(1340, 10, 150, 150);
		l.setForeground(Color.WHITE);
		f3.add(l);
		/*p2.setBackground(new Color(238,76,49));
		p2.setBounds(0, 150,Toolkit.getDefaultToolkit().getScreenSize().width,80);
		p2.setLayout(null);*/
		menu=new JMenuBar();
		menu.setBounds(0, 150,Toolkit.getDefaultToolkit().getScreenSize().width,60);
		menu.setLayout(null);
		menu.setBackground(new Color(30,130,76));
		menu.setForeground(Color.white);
		menu.setFont(new Font("Serif",Font.BOLD,45));

		h=new JMenu(" HOME |");
		h.setForeground(Color.white);
		h.setBounds(10, 10, 125, 40);
		h.setFont(new Font("Serif",Font.BOLD,30));
		
//--------------CUSTOMER-------------------------------
		
		i=new JMenu("   CUSTOMER    |");
		i.setForeground(Color.white);
		i.setBounds(135, 10, 240, 40);
		i.setFont(new Font("Serif",Font.BOLD,30));

		i1=new JMenuItem(" Add Customer");
		i1.setFont(new Font("Serif",Font.BOLD,28));
		//i1.setBackground(Color.DARK_GRAY);
		//i1.setForeground(Color.yellow);
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			Customer1 in=new Customer1();
				f3.add(in);
			in.setVisible(true);
			

			}	
			});
		i2=new JMenuItem(" Search Customer");
		i2.setFont(new Font("Serif",Font.BOLD,28));
		//i2.setBackground(Color.DARK_GRAY);
		//i2.setForeground(Color.yellow);
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			csearch in1=new csearch();
				f3.add(in1);
			in1.setVisible(true);

			}	
			});
		i3=new JMenuItem(" Update Customer");
		i3.setFont(new Font("Serif",Font.BOLD,28));
		//i3.setBackground(Color.DARK_GRAY);
		//i3.setForeground(Color.yellow);
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			Customer2 in2=new Customer2();
				f3.add(in2);
			in2.setVisible(true);

			}	
			});
		i4=new JMenuItem(" Delete Customer");
		i4.setFont(new Font("Serif",Font.BOLD,28));
		//i4.setBackground(Color.DARK_GRAY);
		//i4.setForeground(Color.yellow);
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			cdelete in3=new cdelete();
				f3.add(in3);
			in3.setVisible(true);
			}	
			});
		
		
		
		//..............PRODUCT///////////////////////////
		
		ii=new JMenu("   PRODUCT    |");
		ii.setForeground(Color.white);
		ii.setBounds(375, 10, 215, 40);
		ii.setFont(new Font("Serif",Font.BOLD,30));

		ii1=new JMenuItem(" Add Product");
		ii1.setFont(new Font("Serif",Font.BOLD,28));
		ii1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				product pr=new product();
			}	
			});
		
		ii2=new JMenuItem(" Search Product");
		ii2.setFont(new Font("Serif",Font.BOLD,28));
		ii2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				psearch pr=new psearch();
			}	
			});
		
		ii3=new JMenuItem(" Update Product");
		ii3.setFont(new Font("Serif",Font.BOLD,28));
		ii3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				pupdate pr=new pupdate();
			}	
			});
		
		ii4=new JMenuItem(" Delete Product");
		ii4.setFont(new Font("Serif",Font.BOLD,28));
		ii4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				pdelete pr=new pdelete();
			}	
			});
		
		bb=new JMenu("        Bill        |");
		bb.setForeground(Color.white);
		bb.setBounds(590, 10, 190, 40);
		bb.setFont(new Font("Serif",Font.BOLD,30));

		bb1=new JMenuItem("Generate Bill");
		bb1.setFont(new Font("Serif",Font.BOLD,30));
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			
				Bill1 pr=new Bill1();

			}	
			});
		bb2=new JMenuItem("Search Bill");
		bb2.setFont(new Font("Serif",Font.BOLD,30));
		bb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			
				Bill1 pr=new Bill1();

			}	
			});
		lo=new JMenu("   LOGOUT   |");
		lo.setForeground(Color.white);
		lo.setBounds(780, 10, 190, 40);
		lo.setFont(new Font("Serif",Font.BOLD,30));
		lo1=new JMenuItem("logout");
		lo1.setFont(new Font("Serif",Font.BOLD,30));
		lo1.setBackground(Color.DARK_GRAY);
		lo1.setForeground(Color.yellow);
		lo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			   f3.setVisible(false);
				Agro pr=new Agro();

			}	
			});
		i.add(i1);
		i.add(i2);
		i.add(i3);
		i.add(i4);
		
		bb.add(bb1);
		bb.add(bb2);
		
		ii.add(ii1);
		ii.add(ii2);
		ii.add(ii3);
		ii.add(ii4);
		
		lo.add(lo1);
		
		
		
		menu.add(lo);
		menu.add(h);
		menu.add(i);
		menu.add(ii);
		menu.add(bb);
		
		
		
		
		f3.add(menu);
		p3.setBackground(new Color(255,255,255));
		p3.setSize(900,400);
		p3.setLayout(null);
		p3.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - p3.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - p3.getHeight())/2);
		f3.add(p1);
		//f3.add(p2);
		f3.add(p3);
		
		ImageIcon ue=new ImageIcon("src/Agro/img/b12.png");
		Image  ue11=ue.getImage();
		Image ue21=ue11.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		ImageIcon uie1=new ImageIcon(ue21);

		b1=new JLabel(uie1);
		b1.setBounds(10, 180,50,50);
		//b1.setText(uie1);
		p3.add(b1);
		

		ImageIcon ue1=new ImageIcon("src/Agro/img/b22.png");
		Image  ue12=ue1.getImage();
		Image ue22=ue12.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		ImageIcon uie2=new ImageIcon(ue22);

		b2=new JLabel(uie2);
		b2.setBounds(840, 180,50,50);
		//b1.setText(uie1);
		p3.add(b2);
		
		
		sa=new ImageIcon[3];

		sa[0]=new ImageIcon("src/Agro/img/s1.jpeg");
		sa[1]=new ImageIcon("src/Agro/img/s2.jpeg");
		sa[2]=new ImageIcon("src/Agro/img/s3.jpg");
		Image  se11=sa[j].getImage();
		Image se21=se11.getScaledInstance(900,400, Image.SCALE_SMOOTH);
		ImageIcon sie1=new ImageIcon(se21);
		b3=new JLabel(sie1);
		//b3=new JLabel();
		b3.setBounds(0,0,900,400);
		//b1.setText(uie1);
		p3.add(b3);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(j==0)
				{
				j=2;
				setImagesize(j);
				}
				else
				{
					j=j-1;

					setImagesize(j);
					//b3.setIcon(sa[j]);
				}
				}
			});
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(j==sa.length-1)
				{
					j=0;
					setImagesize(j);
				}
				else
				{
					j=j+1;
					setImagesize(j);
					//b3.setIcon(sa[j]);
				}
				}
			});

		tm=new Timer(3000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setImagesize(x);
				x+=1;
				if(x>=sa.length)
					x=0;
				setImagesize(x);
				
				
			}
		});
		tm.start();
	
		//frame
		f3.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//f3.setMinimumSize(new Dimension(800,600));
		f3.getContentPane().requestFocusInWindow();
		f3.setLayout(null);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f3.setResizable(false);
		f3.setVisible(true);
	
	}
	public void setImagesize(int i)
	{

		Image  se11=sa[i].getImage();
		Image se21=se11.getScaledInstance(900,400, Image.SCALE_SMOOTH);
		ImageIcon sie1=new ImageIcon(se21);
		b3.setIcon(sie1);
	}

	public static void main(String[] args) {
		new main_f();
	}

}
