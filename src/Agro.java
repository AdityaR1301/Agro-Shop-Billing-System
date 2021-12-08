package Agro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Agro {
	JFrame f;
	JPanel p1,p2;
	JLabel b3,b2,l1,l2,l3;
	JButton b1;
	public Agro()
	{
		f=new JFrame();
		p1=new JPanel();
		p2=new JPanel();

		b2=new JLabel("X");
		b2.setBounds(770,0,28,30);
		b2.setBackground(new Color(0,0,0));
		b2.setForeground(Color.black);
		b2.setOpaque(false);
		b2.setFont(new Font("Arial",Font.BOLD,30));
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				System.exit(0);
				}
			});
		
		b3=new JLabel("-");
		b3.setBounds(740,0,28,30);
		b3.setBackground(new Color(0,0,0));
		b3.setForeground(Color.black);
		b3.setOpaque(false);
		b3.setFont(new Font("Arial",Font.BOLD,30));
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				f.setState(JFrame.ICONIFIED);
				}
			});
		//panel2
		l1=new JLabel("AGRO SHOP");
		l1.setBounds(175,10,350,50);
		l1.setFont(new Font("Serif",Font.BOLD,50));
		//l1.setForeground(Color.WHITE);
		l1.setForeground(Color.green);
		//p2.add(l1);
		l2=new JLabel("MANAGEMENT");
		l2.setBounds(150,60,400,50);
		l2.setFont(new Font("Serif",Font.BOLD,50));
		//l2.setForeground(Color.green);
		l2.setForeground(new Color(0,230,64));
		//p2.add(l2);
		l3=new JLabel("SYSTEM");
		l3.setBounds(225,110,250,50);
		l3.setFont(new Font("Serif",Font.BOLD,50));
		l3.setForeground(Color.green);
		

		b1=new JButton("Click Here To LOGIN");
		b1.setBounds(210, 370, 200, 30);	
		b1.setBackground(new Color(0,230,64));
		b1.setForeground(Color.BLACK);
		
		b1.setBorder(new LineBorder(Color.BLACK,1));
		b1.setBorderPainted(true);
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent ev) {
				b1.setBackground(Color.BLACK);
				b1.setForeground(Color.green);
				b1.setBorder(new LineBorder(Color.green,2));
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent ev) {
				b1.setBackground(new Color(0,230,64));
				b1.setForeground(Color.BLACK);
				b1.setBorder(new LineBorder(Color.BLACK,1));
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				new login();
				f.setVisible(false);
			}
		});
		p2.add(b1);

		p2.setLayout(null);
		p2.setBackground(new Color(255,255,255,0));
		p2.setBounds(50,60,700,480);
		f.add(p2);
		// heading
		p1.setBackground(new Color(0,0,0,20));
		p1.setBounds(0, 0, 800,30);
		p1.add(b2);
		p1.add(b3);
		p1.setLayout(null);
		f.add(p1);
		
		

		
		//Background...........................................................
		ImageIcon bgimg=new ImageIcon("src/Agro/img/loginppt1.jpg");

		Image img =bgimg.getImage();
		Image tempi=img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		bgimg=new ImageIcon(tempi);
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.setBackground(new Color(38,166,00));
		bg.setBounds(0,0,800,600);
		f.add(bg);
		Image icon1=Toolkit.getDefaultToolkit().getImage("src/Agro/img/icon_as.png");
		f.setIconImage(icon1);

		//Frame..................................................
		f.setUndecorated(true);
		f.setSize(800,600);
		f.getContentPane().requestFocusInWindow();
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - f.getHeight())/2);
		f.setVisible(true);
	}
	public static void main(String args[]) {
		new Agro();
		
	}
}
