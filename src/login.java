package Agro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

class login {

	Connection con=null;
	Statement st=null;
	ResultSet rs;
	String u,p;
	JCheckBox ch1;
    ImageIcon icon;
	JFrame f1;
	JPanel p1,p2,p3;
	JLabel l1,l2,l3,l4,l5,l,b2,b3;
	JTextField t1;
	JPasswordField t2;
	JButton b1;
	public login()
	{
	
			
	f1=new JFrame("Login");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();

	b2=new JLabel("X");
	b2.setBounds(770,0,28,30);
	b2.setBackground(new Color(0,0,0,120));
	b2.setForeground(Color.BLACK);
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
	b3.setForeground(Color.BLACK);
	b3.setOpaque(false);
	b3.setFont(new Font("Arial",Font.BOLD,30));
	b3.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent ev) {
			f1.setState(JFrame.ICONIFIED);
			}
		});

	
	
	ImageIcon ui=new ImageIcon("src/Agro/img/user.png");
	Image  ui1=ui.getImage();
	Image ui2=ui1.getScaledInstance(100,100, Image.SCALE_SMOOTH);
	ImageIcon uii=new ImageIcon(ui2);

	l=new JLabel(uii);
	l.setBounds(525, 20, 100, 100);
	l.setForeground(Color.WHITE);	
	
	
	
	
	l1=new JLabel("LOGIN");
	l1.setBounds(105,110,150,80);
	l1.setFont(new Font("Serif",Font.BOLD,45));
	//l1.setForeground(Color.WHITE);
	l1.setForeground(Color.BLACK);
	p2.add(l1);

	l2=new JLabel();
	l2.setText("Username");
	l2.setBounds(50, 205,80,20);
	//l2.setForeground(Color.WHITE);
	l2.setForeground(Color.BLACK);
	
	l2.setFont(new Font("Arial",Font.BOLD,12));
	
	t1=new JTextField(" Enter Username ");
	t1.setBackground(new Color(255,255,255));
	t1.setBounds(50, 225, 250, 30);
	t1.setForeground(new Color(0,0,0,80));
	t1.setBorder(new MatteBorder(0,0,3, 0, Color.GREEN));
	t1.setFont(new Font("Arial",Font.ITALIC,14));
	t1.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e1)
		{
			t1.setText("");
			t1.setForeground(new Color(0,0,0));
			t1.setFont(new Font("Arial",Font.BOLD,16));
		}
	public void focusLost(FocusEvent e1) {
		if(t1.getText().trim().equals(""))
		{
			t1.setText(" Enter Username ");
			t1.setForeground(new Color(0,0,0,80));
			t1.setFont(new Font("Arial",Font.ITALIC,14));

		}
	}
	});
	
	l3=new JLabel("Password");
	//l3.setForeground(Color.WHITE);
	l3.setForeground(Color.black);
	l3.setBounds(50, 275, 80, 20);
	l3.setFont(new Font("Arial",Font.BOLD,12));
	
	t2=new JPasswordField();
	t2.setBounds(50, 295, 250, 30);
	char pa=t2.getEchoChar();
	t2.setEchoChar((char)0);
	t2.setText(" Enter Password ");
	t2.setFont(new Font("Arial",Font.ITALIC,14));
	t2.setForeground(new Color(0,0,0,80));
	t2.setBorder(new MatteBorder(0,0,3,0,Color.GREEN));
	t2.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e2)
		{
			t2.setText("");
			t2.setEchoChar(pa);
			t2.setForeground(new Color(0,0,0));
			t2.setFont(new Font("Arial",Font.BOLD,16));
		}
		public void focusLost(FocusEvent e2) {			
			if(t2.getText().equals(""))
			{

				t2.setEchoChar((char)0);
				t2.setText(" Enter Password ");
				t2.setForeground(new Color(0,0,0,80));
				t2.setFont(new Font("Arial",Font.ITALIC,14));

			}}
		});
	
	
	/*t2.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent ev) {
			t2.setForeground(new Color(0,0,0,60));
		}
	});
	t2.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent ev) {
			t2.setForeground(new Color(255,255,255,100));
		}
	});
*/
	ch1=new JCheckBox();
	ch1.setBorder(null);
	ch1.setOpaque(false);
	ch1.setSelected(false);
	ch1.setBorderPainted(false);
	ch1.setBounds(50, 337, 15, 15);
	ch1.setBackground(Color.black);
	ch1.setForeground(Color.black);
	ch1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e)
		{
			if(ch1.isSelected())
			{
				@SuppressWarnings("deprecation")
				String a=t2.getText();
				t2.setEchoChar((char)0);
				t2.setText(a);	
			}
			else
			{
				t2.setEchoChar('*');
			}
		}
	
	});
	l5=new JLabel("Show Password");
	l5.setBounds(65,330,200,30);
	//l5.setForeground(Color.WHITE);
	l5.setForeground(Color.black);
	l5.setFont(new Font("Arial",Font.BOLD,14));
	
	b1=new JButton("Submit");
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
			b1.setForeground(new Color(0,230,64));
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
	
	
	l4=new JLabel("Forget Password?");
	l4.setBounds(145, 440, 108,12);
	//l4.setForeground(Color.WHITE);
	l4.setForeground(Color.black);
	l4.setFont(new Font("Arial",Font.BOLD,12));
	l4.setBorder(new MatteBorder(0,0,1,0,Color.black));
	l4.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent ev) {
			new foget();
			f1.setVisible(false);
		}
	});
	
	
	// Heading......
			p1.setBackground(new Color(0,0,0,0));
			p1.setBounds(0, 0, 800,30);
			p1.add(b2);
			p1.add(b3);
			p1.setLayout(null);
	/*login....................
			p2.setBackground(new Color(0,0,0,80));
			p2.setBounds(0,30, 500,80);
			p2.add(l1);
			p2.setLayout(null);
		*/
	//main..........................
			//p3.setBackground(Color.WHITE);
			p3.setBackground(new Color(255,255,255,100));
			p3.setBounds(400,70, 350,480);
			//p3.setBorder(new LineBorder(Color.BLACK));
			f1.add(l);
			p3.add(l1);
			p3.add(l2);
			p3.add(t1);
			p3.add(l3);
			p3.add(t2);
			p3.add(b1);
			p3.add(l4);
			p3.add(l5);
			p3.setFocusable(true);
			p3.setLayout(null);
			p3.add(ch1);
			//p3.add(s);
			f1.add(p1);
			f1.add(p2);	
			f1.add(p3);
			//p1.setMaximumSize(f.getMaximumSize());;
			//f.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//f.getContentPane().setBackground(Color.black);
			
			f1.setUndecorated(true);
//Background...........................................................
	ImageIcon bgimg=new ImageIcon("src/Agro/img/bg4.jpeg");

	Image img =bgimg.getImage();
	Image tempi=img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
	bgimg=new ImageIcon(tempi);
	JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
	bg.setBackground(new Color(38,166,00));
	bg.setBounds(0,0,800,600);
	f1.add(bg);
	
	
	//Frame..................................................
	f1.setSize(800,600);
	f1.getContentPane().requestFocusInWindow();
	f1.setLayout(null);
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f1.setResizable(false);
	f1.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f1.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - f1.getHeight())/2);
	f1.setVisible(true);
	
	
	
	//connection........................................
	
	b1.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent ev) {
			u=t1.getText();
			p=t2.getText();
	try
	{
		//new test();
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
		System.out.println(p);
		
		String q1="select * from login";
		st=con.createStatement();
		rs=st.executeQuery(q1);
		
		while(rs.next())
		{
			String user=rs.getString("user");
			String pass=rs.getString("pass");
			if(user.equals(u) && pass.equals(p))
			{
				JOptionPane.showMessageDialog(null,"Login Successfull");
				new main_f();
				f1.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Wrong User OR password");
			}
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
		new login();
	}	
}
