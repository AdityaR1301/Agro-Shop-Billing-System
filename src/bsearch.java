package Agro;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class bsearch{
	JFrame f;
	JLabel jl,jl1,jl2,jl3,jl4,jl5,qu1,qu2,qu3,bl,bl1;
	JLabel l1,l2,l3,l4,l5,l6,l7,b,ll1,ll2,ll3,b13,ll4,ll5,ll6;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JPanel p,p1,p2,p3,p4,p5;
	JButton b1,b2,b3,b4,b5;
	Connection con;
	ResultSet rs,rs1,rs2,rsl;
	Statement stmt;
	PreparedStatement pstmt;
	int pid,cid,pid1,q=1,q1=1,co=1,q3=0;
	int ch1=0,ch2=0,last=0,i=0,j=0, l=0,s, v=0,m,m1,qua;
	String aa,pn,da;
	int pid2[]=new int[10];
	ArrayList typ2=new ArrayList();
	ArrayList pnam2=new ArrayList();
	int count=1;
	int CId,BId,PId;
	ResultSet r;
	Statement st;
	PreparedStatement ps;
	int llq=1,tot,sum=0;
	int	k=0,ii=1;
	String cname="";
	String caddr ="";
	String mob ="";
	String typ ="";
	String typ1 ="",pq;
	
	String pname="";
	String type ="";
	String quant ="";
	String price ="";
	DefaultTableCellRenderer cr;
	DefaultTableModel mod;
	JScrollPane scroll1;
	JTextField textbox;
	 JTable table,tb;
	String[] columnNames = {"Product_Name", "Price", "Quantity", "Total"};
	
	public bsearch() {
		f=new JFrame();
		mod = new DefaultTableModel();
		mod.setColumnIdentifiers(columnNames);
		tb = new JTable();
		tb.setModel(mod); 
		tb.setEnabled(false);

		tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tb.setFillsViewportHeight(true);
		scroll1 = new JScrollPane(tb);
		tb.setBackground(Color.white);
		tb.setRowHeight(40);
		tb.setFont(new Font("Arial",Font.BOLD,18));
		scroll1.setBounds(10,10,860,250);
		
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
	
	l7=new JLabel("Agro Shop Management System");
	l7.setBounds(240,10,500,22);
	l7.setForeground(Color.white);
	l7.setFont(new Font("Arial",Font.BOLD,20));
	f.add(l7);
	Border bor=BorderFactory.createLineBorder(Color.black, 4, true);
	Border bor2=BorderFactory.createLineBorder(Color.red, 6, true);

	p=new JPanel();
	p.setLayout(null);
	b=new JLabel("X");
	b.setBounds(870,5,28,30);
	b.setBackground(new Color(0,0,0,120));
	b.setForeground(Color.BLACK);
	b.setOpaque(false);
	b.setFont(new Font("Arial",Font.BOLD,30));
	b.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent ev) {
			f.setVisible(false);
			}
		});
	
	b13=new JLabel("-");
	b13.setBounds(840,5,28,30);
	b13.setBackground(new Color(0,0,0,120));
	b13.setForeground(Color.BLACK);
	b13.setOpaque(false);
	b13.setFont(new Font("Arial",Font.BOLD,30));
	b13.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent ev) {
			f.setState(JFrame.ICONIFIED);
			}
		});

	
	p.setBackground(new Color(0,0,0,100));
	p.setBounds(0, 0, 900,30);
	p.add(b);
	p.add(b13);
	f.add(p);
	
	p1=new JPanel();
	p1.setBounds(10,50,880,140);
	p1.setLayout(null);
	//p1.setFocusable(false);
	p1.setBackground(new Color(255,255,255,0));
	f.add(p1);
	p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Customer Info"));

l5=new JLabel();
l5.setBounds(80,20,350,30);
l5.setFont(new Font("Arial",Font.BOLD,20));
p1.add(l5);

l2=new JLabel("Customer Id:");
l2.setBounds(50,30,110,30);
l2.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l2);

t1=new JTextField();
t1.setBounds(180,30,90,30);
t1.setEditable(false);
t1.setFont(new Font("Arial",Font.BOLD,18));
t1.setBackground(new Color(255,255,255));
t1.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p1.add(t1);


l4=new JLabel("Customer Name:");
l4.setBounds(50,90,130,30);
l4.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l4);

t2=new JTextField();
t2.setEditable(false);
t2.setBorder(new MatteBorder(0,0,4, 0, Color.black));

t2.setBackground(new Color(255,255,255));

t2.setBounds(180,90,90,30);
t2.setFont(new Font("Arial",Font.BOLD,18));
p1.add(t2);


l3=new JLabel("Bill No:");
l3.setBounds(600,30,60,30);
l3.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l3);



t3=new JTextField();
t3.setBounds(670,30,100,30);
t3.setBackground(new Color(255,255,255));
t3.setBorder(new MatteBorder(0,0,4, 0, Color.black));
t3.setFont(new Font("Arial",Font.BOLD,18));
p1.add(t3);

l5=new JLabel("Mob No:");
l5.setBounds(320,90,70,30);
l5.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l5);

t4=new JTextField();
t4.setBounds(400,90,160,30);
t4.setEditable(false);
t4.setBorder(new MatteBorder(0,0,4, 0, Color.black));
t4.setBackground(new Color(255,255,255));
t4.setFont(new Font("Arial",Font.BOLD,18));
p1.add(t4);

b1=new JButton("SHOW BILL");
b1.setBounds(600, 90,150, 30);

p1.add(b1);

l6=new JLabel("Date:");
l6.setBounds(600,90,50,30);
l6.setVisible(false);
l6.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l6);

t5=new JTextField();
t5.setVisible(false);
t5.setEditable(false);
t5.setBounds(670,90,100,30);
t5.setBackground(new Color(255,255,255));
t5.setFont(new Font("Arial",Font.BOLD,18));
t5.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p1.add(t5);
//panel5.................................................................................
		p5=new JPanel();
		p5.setBounds(10,190,880,600);
		p5.setFont(new Font("Arial",Font.BOLD,18));
		p5.setBackground(Color.white);
		p5.setLayout(null);
		p5.setVisible(false);
		f.add(p5);

		b5=new JButton("New Bill");
		b5.setBounds(350,520,180,30);
		//b1.setBorder(bor);
		b5.setFont(new Font("Arial",Font.BOLD,18));
		p5.add(b5);

bl=new JLabel("Total:");
bl.setBounds(650,280,80,40);
bl.setFont(new Font("Arial",Font.BOLD,22));
p5.add(bl);

bl1=new JLabel();
bl1.setBounds(730,280,100,40);
bl1.setFont(new Font("Arial",Font.BOLD,22));
p5.add(bl1);

//Background...........................................................
ImageIcon bgimg=new ImageIcon("src/Agro/img/bb.jpeg");
Image img =bgimg.getImage();
Image tempi1=img.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
bgimg=new ImageIcon(tempi1);
JLabel bg1=new JLabel("",bgimg,JLabel.CENTER);
bg1.setBackground(new Color(38,166,00));
bg1.setBounds(0,0,900,800);
f.add(bg1);


//f.setBackground(Color.white);
f.setUndecorated(true);
f.setSize(900,800);
f.setLayout(null);
f.setVisible(true);
//f.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - f.getHeight())/2);
f.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f.getWidth())/2,0);

f.setResizable(false);
f.toFront();
f.requestFocus();
f.setState(Frame.NORMAL);


b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ev) {
		t5.setVisible(true);
		l6.setVisible(true);
		b1.setVisible(false);
		BId=Integer.parseInt(t3.getText());

try
{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
		stmt=con.createStatement();
		st=con.createStatement();
		
		pstmt=con.prepareStatement("Select * from bill where BNo=? ");
		pstmt.setInt(1,BId);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			PId=rs.getInt("PId");
			CId=rs.getInt("CId");
			da=rs.getString("Date");
			quant=rs.getString("Quantity");
			tot=rs.getInt("Total");
			
		}
		t1.setText(String.valueOf(CId));
		
		pstmt=con.prepareStatement("Select * from product where PId=? ");
		pstmt.setInt(1,PId);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			cid = rs.getInt("CId");
			cname = rs.getString("CName");
			caddr = rs.getString("CAddr");
			mob = rs.getString("CMbNo"); 
			
				t2.setText(cname);
				t4.setText(mob);
				
							 
		}
		pstmt=con.prepareStatement("Select * from Customer where CId=? ");
		pstmt.setInt(1,CId);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			cid = rs.getInt("CId");
			cname = rs.getString("CName");
			caddr = rs.getString("CAddr");
			mob = rs.getString("CMbNo"); 
			
				t2.setText(cname);
				t4.setText(mob);
				
							 
		}
		mod.addRow(new Object[] {pn, price,qua,tot});

		p5.add(scroll1);
		p5.setVisible(true);			
		
		
}catch(Exception e) {
	System.out.println(e);
}

	}
	});
		
		
		
		
	}
	
	public static void main(String[] args) {
		new bsearch();

	}

}
