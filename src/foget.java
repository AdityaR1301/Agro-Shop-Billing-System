package Agro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class foget {

	Connection con=null;
	Statement st=null;
	ResultSet rs;
	PreparedStatement ps=null;
	JFrame f2;
	JPanel p1,p2;
	JLabel l,l1,l2,l3,l4,l5,b2,b3;
	JTextField t1,t2;
	JPasswordField t3,t4;
	JButton b1;
	
	
	public foget()
	{
	
		
	f2=new JFrame();
	p1=new JPanel();
	p2=new JPanel();

	b2=new JLabel("X");
	b2.setBounds(770,0,28,30);
	b2.setBackground(new Color(0,0,0,120));
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
	b3.setBackground(new Color(0,0,0,120));
	b3.setForeground(Color.black);
	b3.setOpaque(false);
	b3.setFont(new Font("Arial",Font.BOLD,30));
	b3.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent ev) {
			f2.setState(JFrame.ICONIFIED);
			}
		});
	
	
	//Panel 2............................


	ImageIcon ui=new ImageIcon("src/Agro/img/user.png");
	Image  ui1=ui.getImage();
	Image ui2=ui1.getScaledInstance(100,100, Image.SCALE_SMOOTH);
	ImageIcon uii=new ImageIcon(ui2);

	l=new JLabel(uii);
	l.setBounds(125, 10, 100, 100);
	l.setForeground(Color.WHITE);	
	
/*	l1=new JLabel("LOGIN");
	l1.setBounds(105,110, 140,80);
	l1.setFont(new Font("Arial",Font.BOLD,42));
	//l1.setForeground(Color.WHITE);
	l1.setForeground(Color.BLACK);
	*/

	l1=new JLabel();
	l1.setText("Username");
	l1.setBounds(50, 115,80,20);
	//l1.setForeground(Color.WHITE);
	l1.setForeground(Color.BLACK);
	l1.setFont(new Font("Arial",Font.BOLD,14));
	
	t1=new JTextField(" Enter Username ");
	
	t1.setBounds(50, 135, 250, 30);
	t1.setFont(new Font("Arial",Font.ITALIC,14));
	t1.setForeground(new Color(0,0,0,80));
	t1.setBackground(new Color(255,255,255));
	t1.setBorder(new MatteBorder(0,0,3, 0, Color.GREEN));
	//t1.setBackground(Color.WHITE);
	//t1.setBorder(null);
	
	t1.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e1)
		{
			t1.setText("");
			t1.setFont(new Font("Arial",Font.BOLD,16));
			t1.setForeground(new Color(0,0,0));
		}
	public void focusLost(FocusEvent e1) {
		if(t1.getText().trim().equals(""))
		{
			t1.setText(" Enter Username ");
			t1.setFont(new Font("Arial",Font.ITALIC,14));
			t1.setForeground(new Color(0,0,0,80));
		}
	}
	});
	

	l2=new JLabel();
	l2.setText("Mob Number");
	l2.setBounds(50, 175,100,20);
	//l2.setForeground(Color.WHITE);
	l2.setForeground(Color.BLACK);
	l2.setFont(new Font("Arial",Font.BOLD,14));
	
	t2=new JTextField(" Enter Mobile Number ");
	t2.setBackground(new Color(255,255,255));
	t2.setBounds(50, 195, 250, 30);
	t2.setForeground(new Color(0,0,0,80));
	t2.setBorder(new MatteBorder(0,0,3, 0, Color.GREEN));
	t2.setFont(new Font("Arial",Font.ITALIC,14));
	t2.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e1)
		{
			t2.setText("");
			t2.setForeground(new Color(0,0,0));
			t2.setFont(new Font("Arial",Font.BOLD,16));

		}
	public void focusLost(FocusEvent e1) {
		if(t2.getText().trim().equals(""))
		{
			t2.setText(" Enter Mobile Number ");
			t2.setForeground(new Color(0,0,0,80));
			t2.setFont(new Font("Arial",Font.ITALIC,14));

		}
	}
	});
	

	l3=new JLabel(" New Password");
	//l3.setForeground(Color.WHITE);
	l3.setForeground(Color.black);
	l3.setBounds(50, 235, 180, 20);
	l3.setFont(new Font("Arial",Font.BOLD,14));
	
	t3=new JPasswordField();
	t3.setBounds(50, 255, 250, 30);
	char pa=t3.getEchoChar();
	t3.setEchoChar((char)0);
	t3.setText(" Enter New Password ");
	t3.setFont(new Font("Arial",Font.ITALIC,14));
	t3.setForeground(new Color(0,0,0,80));
    //t3.setBackground(Color.WHITE);
	t3.setBackground(new Color(255,250,250));
	t3.setBorder(new MatteBorder(0,0,3,0,Color.GREEN));
	t3.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e2)
		{
			t3.setFont(new Font("Arial",Font.BOLD,16));

			t3.setForeground(new Color(0,0,0));
			t3.setText("");
			t3.setEchoChar(pa);
			t3.setFocusable(true);
			
		}
		@SuppressWarnings("deprecation")
		public void focusLost(FocusEvent e2) {			
			if(t3.getText().equals(""))
			{
				t3.setFont(new Font("Arial",Font.ITALIC,14));
				t3.setForeground(new Color(0,0,0,80));
				t3.setEchoChar((char)0);
				t3.setText(" Enter New Password ");
			}}
		});
	

	l4=new JLabel(" Confirm Password");
	//l4.setForeground(Color.WHITE);
	l4.setForeground(Color.black);
	l4.setBounds(50, 295, 180, 20);
	l4.setFont(new Font("Arial",Font.BOLD,14));
	
	t4=new JPasswordField();
	t4.setBounds(50, 315, 250, 30);
	char pp=t4.getEchoChar();
	t4.setEchoChar((char)0);
	t4.setText(" Confirm Password ");
	t4.setFont(new Font("Arial",Font.ITALIC,14));
	t4.setForeground(new Color(0,0,0,80));
    //t4.setBackground(Color.WHITE);
	t4.setBackground(new Color(255,250,250));
	t4.setBorder(new MatteBorder(0,0,3,0,Color.GREEN));
	t4.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e2)
		{

			t4.setText("");
			t4.setEchoChar(pp);		
			t4.setForeground(new Color(0,0,0));
			t4.setFont(new Font("Arial",Font.BOLD,16));


		}
		@SuppressWarnings("deprecation")
		public void focusLost(FocusEvent e2) {			
			if(t4.getText().equals(""))
			{
				t4.setFont(new Font("Arial",Font.ITALIC,14));

				t4.setEchoChar((char)0);
				t4.setForeground(new Color(0,0,0,80));
				t4.setText(" Confirm Password ");
			}}
		});
	
	

	
	b1=new JButton("Change Password");
	b1.setBounds(50, 370, 250, 30);	
	b1.setBackground(new Color(0,230,64));
	b1.setForeground(Color.BLACK);
	b1.setBorder(new LineBorder(Color.BLACK,1));
	b1.setBorderPainted(true);
	b1.setFont(new Font("Arial",Font.BOLD,14));
	b1.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent ev) {
			//b1.setBackground(new Color(38,166,00));
			//b1.setForeground(Color.WHITE);
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
	
	// Heading......
			p1.setBackground(new Color(0,0,0,0));
			p1.setBounds(0, 0, 800,30);
			p1.add(b2);
			p1.add(b3);
			p1.setLayout(null);
	//main.........
			//p3.setBackground(Color.WHITE);
			p2.setBackground(new Color(255,255,255,20));
			p2.setBounds(400,70, 350,480);
			p2.add(l);
			p2.add(l1);
			p2.add(t1);
			p2.add(l2);
			p2.add(t2);
			p2.add(l3);
			p2.add(t3);
			p2.add(l4);
			p2.add(t4);
			p2.add(b1);
			
			
			p2.setFocusable(true);
			p2.setLayout(null);
			//p1.setMaximumSize(f.getMaximumSize());;
			
			f2.add(p1);
			f2.add(p2);	
			//f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//f1.getContentPane().setBackground(Color.black);
			f2.setUndecorated(true);
			//Background...........................................................
	ImageIcon bgimg=new ImageIcon("src/Agro/img/bg4.jpeg");

	Image img =bgimg.getImage();
	Image tempi=img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
	bgimg=new ImageIcon(tempi);
	JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
	bg.setBackground(new Color(38,166,00));
	bg.setBounds(0,0,800,600);
	f2.add(bg);
	
	//Frame..................................................
	f2.setSize(800,600);
	f2.getContentPane().requestFocusInWindow();
	f2.setLayout(null);
	f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f2.setResizable(false);
	f2.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f2.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - f2.getHeight())/2);
	f2.setVisible(true);
	
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			String u=t1.getText();
			String m=t2.getText();
			@SuppressWarnings("deprecation")
			String p=t3.getText();
			@SuppressWarnings("deprecation")
			String cp=t4.getText();
						
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
		System.out.println(p);
		st=con.createStatement();
		
		String q1="select * from login";
		rs=st.executeQuery(q1);
		if(p.equals(cp))
		{
		while(rs.next())
		{
			String user=rs.getString("user");
			String mob=rs.getString("mob");
			//System.out.println(mob);
			if(user.equals(u) && mob.equals(m))
			{
				String q2="update login set pass=? where user=? and mob=?";
				ps=con.prepareStatement(q2);
				ps.setString(1, p);
				ps.setString(2, u);
				ps.setString(3, m);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Password Successfully changed");
				new login();
				f2.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Wrong User or Mobile");
			}
		}
		}
		else
		{
			t4.setEchoChar((char)0);
			t4.setForeground(Color.red);
			t4.setText(" Confirm Password ");

			//JOptionPane.showMessageDialog(null,"Confim Your password");		
		}
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
			
		}
	});
	
	
	
	}
	
	
public static void main(String args[])
	{
		new foget();
	}
}
