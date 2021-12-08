package Agro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class Bill1 {
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
	String aa,pn;
	int pid2[]=new int[10];
	ArrayList typ2=new ArrayList();
	ArrayList pnam2=new ArrayList();
	int count=1;
	int CId;
	ResultSet r;
	Statement st;
	PreparedStatement ps;
	
	java.util.Date date;
	
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
	DefaultTableModel model,mod;
	JScrollPane scroll,scroll1;
	JTextField textbox;
	 JTable table,tb;
	String[] columnNames = {"Sr.No","Product_Name", "Price", "Quantity", "Total"};

	int cn=0;
	public Bill1() {
		f=new JFrame();
		
		
		
			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table = new JTable();
			table.setModel(model); 
			cr=new DefaultTableCellRenderer();
			cr.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(cr);
			table.setEnabled(false);
			//table.setHorizontalAlignment(JLabel.CENTER);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			scroll = new JScrollPane(table);
			table.setBackground(Color.white);
			table.setRowHeight(40);
			table.setFont(new Font("Arial",Font.BOLD,18));
			scroll.setBounds(10,10,860,250);
			
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		

			mod = new DefaultTableModel();
			mod.setColumnIdentifiers(columnNames);
			tb = new JTable();
			tb.setModel(model); 
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

		

ImageIcon bgimg1=new ImageIcon("src/Agro/img/logo2.jpg");
Image img1 =bgimg1.getImage();
Image tempi=img1.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
bgimg1=new ImageIcon(tempi);
JLabel bg=new JLabel("",bgimg1,JLabel.CENTER);
bg.setBackground(new Color(38,166,00));
bg.setBounds(270,10,300,75);
//p1.add(bg);


l2=new JLabel("Customer Id:");
l2.setBounds(50,30,110,30);
l2.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l2);

t1=new JTextField();
t1.setBounds(180,30,90,30);
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

t2.setBounds(180,90,130,30);
t2.setFont(new Font("Arial",Font.BOLD,18));
p1.add(t2);


l3=new JLabel("Bill No:");
l3.setBounds(600,30,60,30);
l3.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l3);



t3=new JTextField();
t3.setEditable(false);
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


l6=new JLabel("Date:");
l6.setBounds(600,90,50,30);
l6.setFont(new Font("Arial",Font.BOLD,16));
p1.add(l6);

t5=new JTextField();
t5.setEditable(false);
t5.setBounds(670,90,100,30);
t5.setBackground(new Color(255,255,255));
t5.setFont(new Font("Arial",Font.BOLD,18));
t5.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p1.add(t5);


DateFormat d=new SimpleDateFormat ("dd/MM/yyyy");
date=new java.util.Date();
t5.setText(d.format(date));





//panel3 .....................................................................................
	p3=new JPanel();
	p3.setBounds(10,200,880,300);
	p3.setLayout(null);
	p3.setBackground( new Color(250,250,250));
	f.add(p3);
	//p3.setFocusable(true);
//	p3.setVisible(false);

	ll3=new JLabel();
	//b3=new JLabel();
	ll3.setBounds(190,10,500,150);
	ll3.setBackground(new Color(0,238,0));
	ll3.setOpaque(true);
	ll3.setText("Select product");
	ll3.setFont(new Font("Arial",Font.BOLD,40));
	ll3.setBorder(bor);
	ll3.setForeground(Color.white);
	ll3.setVerticalAlignment(JLabel.CENTER);
	ll3.setHorizontalAlignment(JLabel.CENTER);
	p3.add(ll3);

	ImageIcon ue=new ImageIcon("src/Agro/img/b12.png");
	Image  ue11=ue.getImage();
	Image ue21=ue11.getScaledInstance(80,80, Image.SCALE_SMOOTH);
	ImageIcon uie1=new ImageIcon(ue21);

	ll1=new JLabel(uie1);
	ll1.setBounds(30, 50,80,80);
	ll1.setVisible(false);
	
	p3.add(ll1);
	

	ImageIcon ue1=new ImageIcon("src/Agro/img/b22.png");
	Image  ue12=ue1.getImage();
	Image ue22=ue12.getScaledInstance(80,80, Image.SCALE_SMOOTH);
	ImageIcon uie2=new ImageIcon(ue22);

	ll2=new JLabel(uie2);
	ll2.setBounds(770, 50,80,80);
	//b1.setText(uie1);
	p3.add(ll2);
	
	
	

	
//panel2.................................................................................
	p2=new JPanel();
	p2.setBounds(10,200,880,300);
	p2.setFont(new Font("Arial",Font.BOLD,18));
	p2.setBackground(new Color(255,255,255));
	p2.setLayout(null);
	p2.setVisible(false);
	//p2.setFocusable(true);
	f.add(p2);



	b2=new JButton("Back");
	b2.setBounds(150,260,170,30);
	b2.setFont(new Font("Arial",Font.BOLD,18));
	p2.add(b2);
	
//10 50 440 300 
	
	ll4=new JLabel(uie1);
	ll4.setBounds(30, 50,80,80);
	p2.add(ll4);
	ll4.setVisible(false);

	
	ll5=new JLabel(uie2);
	ll5.setBounds(770, 50,80,80);
	//b1.setText(uie1);
	p2.add(ll5);
	
	ll6=new JLabel();
	
	ll6.setBounds(190,10,500,150);
	ll6.setBorder(bor);
	//ll6.setBackground(Color.orange);
	ll6.setOpaque(true);
	ll6.setForeground(Color.white);
	ll6.setVerticalAlignment(JLabel.CENTER);
	ll6.setHorizontalAlignment(JLabel.CENTER);
	ll6.setFont(new Font("Arial",Font.BOLD,40));
	p2.add(ll6);

	
	b1=new JButton("ADD");
	b1.setBounds(650,200,170,30);
	//b1.setBorder(bor);
	b1.setFont(new Font("Arial",Font.BOLD,18));
	p2.add(b1);
	b1.setVisible(false);

	b3=new JButton("BUY");
	b3.setBounds(630,260,170,30);
	//b1.setBorder(bor);
	b3.setFont(new Font("Arial",Font.BOLD,18));
	p2.add(b3);
	b3.setVisible(false);


jl=new JLabel("Product Id:");
jl.setBounds(40,200,110,30);
jl.setFont(new Font("Arial",Font.BOLD,18));
jl.setVisible(false);

p2.add(jl);


t6=new JTextField();
t6.setEditable(false);
t6.setBounds(140,200,80,30);
t6.setVisible(false);

t6.setBackground(new Color(255,255,255));
t6.setFont(new Font("Arial",Font.BOLD,18));
t6.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p2.add(t6);


jl1=new JLabel("Stock :"); 
jl1.setBounds(255,200,80,30);
jl1.setVisible(false);
jl1.setFont(new Font("Arial",Font.BOLD,18));
p2.add(jl1);

t7=new JTextField();
t7.setEditable(false);
t7.setBounds(320,200,80,30);
t7.setVisible(false);
t7.setBackground(new Color(255,255,255));
t7.setFont(new Font("Arial",Font.BOLD,18));
t7.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p2.add(t7);


jl2=new JLabel("Price :");
jl2.setBounds(420,200,80,30);
jl2.setVisible(false);
jl2.setFont(new Font("Arial",Font.BOLD,18));
p2.add(jl2);


t8=new JTextField();
t8.setEditable(false);
t8.setBounds(490,200,100,30);
t8.setBackground(new Color(255,255,255));
t8.setVisible(false);
t8.setFont(new Font("Arial",Font.BOLD,18));
t8.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p2.add(t8);

/*jl3=new JLabel("Quantity :");
jl3.setBounds(600,200,100,30);
jl3.setVisible(false);
jl3.setFont(new Font("Arial",Font.BOLD,18));
p2.add(jl3);*/



qu1=new JLabel("-"); 
qu1.setBounds(650,200,40,40);
qu1.setBackground(Color.red);
qu1.setBorder(bor2);
qu1.setVerticalAlignment(JLabel.CENTER);
qu1.setHorizontalAlignment(JLabel.CENTER);
qu1.setForeground(Color.red);

qu1.setVisible(false);
qu1.setFont(new Font("Arial",Font.BOLD,18));
p2.add(qu1);


qu2=new JLabel("1"); 
qu2.setBounds(690,200,50,40);
qu2.setBackground(Color.red);
qu2.setBorder(bor2);
//qu2.setForeground(Color.white);

qu2.setVerticalAlignment(JLabel.CENTER);
qu2.setHorizontalAlignment(JLabel.CENTER);

qu2.setVisible(false);
qu2.setFont(new Font("Arial",Font.BOLD,18));
p2.add(qu2);


qu3=new JLabel("+"); 
qu3.setBounds(740,200,40,40);
qu3.setBackground(Color.red);
qu3.setForeground(Color.red);
qu3.setBorder(bor2);
qu3.setVerticalAlignment(JLabel.CENTER);
qu3.setHorizontalAlignment(JLabel.CENTER);
qu3.setVisible(false);
qu3.setFont(new Font("Arial",Font.BOLD,18));
p2.add(qu3);




t9=new JTextField();
t9.setEditable(false);
t9.setVisible(false);
t9.setBounds(690,200,100,30);
t9.setBackground(new Color(255,255,255));
t9.setFont(new Font("Arial",Font.BOLD,18));
t9.setBorder(new MatteBorder(0,0,4, 0, Color.black));
p2.add(t9);






//panel4.................................................................................
	p4=new JPanel();
	p4.setBounds(10,520,880,300);
	p4.setFont(new Font("Arial",Font.BOLD,18));
	p4.setBackground(new Color(255,255,255,0));
	p4.setLayout(null);
	p4.setVisible(false);

	f.add(p4);

	

	b4=new JButton("Generate Bill");
	b4.setBounds(650,260,170,30);
	//b1.setBorder(bor);
	b4.setFont(new Font("Arial",Font.BOLD,18));
	p4.add(b4);
	b4.setVisible(false);

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




try
{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
		stmt=con.createStatement();
		st=con.createStatement();
	
		String sql;
		sql="Select * from bill";
		rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			count=rs.getInt(1);
			count++;
		}
		t3.setText(String.valueOf(count));
	
}catch(Exception e){System.out.println(e);}



t1.addFocusListener(new FocusListener() {
	public void focusGained(FocusEvent e2)
	{
		
		t1.setFont(new Font("Arial",Font.BOLD,16));
	}
	public void focusLost(FocusEvent e2) {			
	try
		{
			int j=0;
			CId=Integer.parseInt(t1.getText());
			pstmt=con.prepareStatement("Select * from Customer ");
			//pstmt.setInt(1,CId);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				cid = rs.getInt("CId");

				if(CId==cid)
				{
				cname = rs.getString("CName");
				caddr = rs.getString("CAddr");
				mob = rs.getString("CMbNo"); 
				
				j++;
					t2.setText(cname);
					t4.setText(mob);
					//p3.setVisible(true);
				}				 
				}
			if(j==0)
			{
				JOptionPane.showMessageDialog(t4,"Incorrect Customer ID");

			}
		
		t2.setFont(new Font("Arial",Font.ITALIC,16));
		}
		catch(Exception aa)
		{
			JOptionPane.showMessageDialog(t4,"Incorrect Customer ID");
}
		}
	});

try
{

String sql;
sql="Select * from product";
rs2=stmt.executeQuery(sql);
rs2.last();
last=rs2.getInt(1);
rs2=null;

}catch(Exception ae){System.out.println(ae);}

ll1.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {
		try
		{
				
			s=typ2.size();
			if(s==k)
			{
				k--;
			}
				String p=typ2.get(k).toString();
				 if(p==ll3.getText())
				 {

						k--;
				 }
				 p=typ2.get(k).toString();
				ll3.setText(p);
				k--;
				if(k<0)
				{
				k=0;
				ll2.setVisible(true);
				ll1.setVisible(false);
				}
			}
			catch(Exception ae)
		{
				System.out.println(ae);
		}
	}
	});
ll2.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {
	
		try
		{
			ll1.setVisible(true);
			pstmt=con.prepareStatement("Select * from product");
			rs2=pstmt.executeQuery();
			
			while(rs2.next())
			{
				typ= rs2.getString("Type");
				
					if(!typ2.contains(typ))
					{
						typ2.add(typ);
					}
				
				
			}
			s=typ2.size();
		 String p=typ2.get(k).toString();
		 if(p==ll3.getText())
		 {
			 k++;
		 }
		 p=typ2.get(k).toString();
		 ll3.setText(p);
		 k++;
			if(s<=k)
			{
				ll2.setVisible(false);
				k=typ2.size();
			}
			}

			catch(Exception ae)
		{
				
				System.out.println(ae);
		}
		}
});

ll3.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {
		k=0;
		aa=ll3.getText();
		ll5.setVisible(true);
		ll4.setVisible(false);
		if(aa.equals("Select product"))
		{
		}
		else
		{
		p3.setVisible(false);
		p2.setVisible(true);
		try
		{
			pstmt=con.prepareStatement("Select * from product where Type=?");
			pstmt.setString(1,aa);
			rs=pstmt.executeQuery();
		
			while(rs.next())
			{
				while(ch1==0)
				{
				pid1 = rs.getInt("PId");
			if(pid1==q)
			{
				pstmt=con.prepareStatement("Select * from product where Type=? and PId=?");
				pstmt.setString(1,aa);
				pstmt.setInt(2,q);
				rs1=pstmt.executeQuery();
				
			while(rs1.next())
			{
				pid = rs1.getInt("PId");
				pname = rs1.getString("PName");
				type = rs1.getString("Type");
				quant = rs1.getString("quantity"); 
				price=rs1.getString("price"); 
				}
			if(type.equals("seed"))
			{
				ll6.setBackground(new Color(255,140,0));

			}else if(type.equals("Fertilizer")){
				ll6.setBackground(new Color(255,20,147));
			}
			else if(type.equals("pesticide"))
			{
				ll6.setBackground(new Color(255,48,48));

			}
			ll6.setText(pname);
			ch1=1;
			
			}
			
			else
			{
			q++;
			ch1=0;
			
			}
			}
		}
		}
			catch(Exception ae)
		{
				System.out.println(ae);
		}
	
		}
		rs=null;
		rs1=null;
		}
});


try
{
String sql;
sql="Select * from product";
rsl=stmt.executeQuery(sql);
rsl.last();
co=rsl.getInt(1);
}catch(Exception ae){System.out.println(ae);}

ll4.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {
		try
		{
				
			s=pnam2.size();
			if(s==ii)
			{
				ii--;
			}
				pq=pnam2.get(ii).toString();
				 if(pq==ll6.getText())
				 {

						ii--;
				 }
				 pq=pnam2.get(ii).toString();
				ll6.setText(pq);
				ii--;
				if(ii<0)
				{
				ii=0;
				ll5.setVisible(true);
				ll4.setVisible(false);
				}
			}
			catch(Exception ae)
		{
				System.out.println(ae);
		}

		}
	});

ll5.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {
	try
		{	
			ll4.setVisible(true);
			pstmt=con.prepareStatement("Select * from product where Type=?");
			pstmt.setString(1,aa);
			rs=pstmt.executeQuery();
			String a=ll6.getText();
			while(rs.next())
			{
				pid1= rs.getInt("PId");
				String pname1 = rs.getString("PName");

				if(!pnam2.contains(pname1))
				{
					pnam2.add(pname1);
				}
				
			}
			s=pnam2.size();
		 pq=pnam2.get(ii).toString();
		 
		 if(pq==ll6.getText())
		 {
			 ii++;
		 }
		pq=pnam2.get(ii).toString();
		 ll6.setText(pq);

		 ii++;
		
			if(s<=ii)
			{
				ll5.setVisible(false);
				ii=pnam2.size();
				
			}
			 if(pq==a)
			 {
				 ii++;
				 pq=pnam2.get(ii).toString();
				 ll6.setText(pq);
			 }
			
			
			
		}
		

			catch(Exception ae)
		{
				
				System.out.println(ae);
		}
	
	}
});


ll6.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {
		t6.setVisible(true);
		t7.setVisible(true);
		t8.setVisible(true);
		jl.setVisible(true);
		jl1.setVisible(true);
		jl2.setVisible(true);
		p3.setVisible(false);
		ll5.setVisible(false);
		ll4.setVisible(false);
		b1.setVisible(true);

	
		String aa2=ll6.getText();
		b2.setText("New");
		
try {
	pstmt=con.prepareStatement("Select * from product where PName=?");
	pstmt.setString(1,aa2);
	
	rs1=pstmt.executeQuery();
	
while(rs1.next())
{
	pid = rs1.getInt("PId");
	pname = rs1.getString("PName");
	type = rs1.getString("Type");
	quant = rs1.getString("quantity"); 
	price=rs1.getString("price"); 
	}
t6.setText(String.valueOf(pid));
t7.setText(quant);
t8.setText(price);
//ll6.setText(pname);
}
catch(Exception e)
{
	
}

	}});


qu1.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {

		m=Integer.parseInt(qu2.getText());
		if(m==1)
		{
			
		}
		else
		{
			m--;
			
		}
		qu2.setText(String.valueOf(m));
		
		
		

	}});




qu3.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent ev) {

		m1=Integer.parseInt(quant);

		m=Integer.parseInt(qu2.getText());
	if(m1>m)
	{
			m++;
	}	else
	{
		JOptionPane.showMessageDialog(null,"unavailable stock");

	}
		
		qu2.setText(String.valueOf(m));
		
		

	}});


//add........................	
	b1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent ev) {
			b1.setVisible(false);
			b3.setVisible(true);
			p3.setVisible(false);
			qu1.setVisible(true);
			qu2.setVisible(true);
			qu3.setVisible(true);
		}});
	
	//Back//////////////////////////////////////////////////////
		b2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent ev) {
				
				if(b2.getText()=="Back")
				{
						co=1;
				ll3.setText("Select product");
				ll6.setText("");
				q1=1;
				i=0;
				q=1;
				ch1=0;
				for(int x=0;x<pid2.length;x++)
				{
					pid2[x]=0;
				}
			
				pnam2.clear();
				ii=1;
				ll1.setVisible(false);
				ll2.setVisible(true);
				ch2=0;
				rs=null;
				rs1=null;
				p3.setVisible(true);
				p2.setVisible(false);
				b3.setVisible(false);
				qu1.setVisible(false);
				qu2.setVisible(false);
				qu3.setVisible(false);
				}
				
				if(b2.getText()=="New")
				{
					qu2.setText("1");
					ll4.setVisible(false);
					ll5.setVisible(true);
					ii=0;
					qu1.setVisible(false);
					qu2.setVisible(false);
					qu3.setVisible(false);
					b3.setVisible(false);
					t6.setVisible(false);
					t7.setVisible(false);
					t8.setVisible(false);
					jl.setVisible(false);
					jl1.setVisible(false);
					jl2.setVisible(false);
					
					b2.setText("Back");
				}
			}
			});
		

//buy........................................
b3.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent ev) {
		p4.setVisible(true);
		p3.setVisible(false);
		b4.setVisible(true);
		pn=ll6.getText();
		
		qua=Integer.parseInt(qu2.getText());
		int pr=Integer.parseInt(price);
		tot=(qua * pr);
		sum+=tot;
		model.addRow(new Object[]{llq,pn, price,qua,tot});
		mod.addRow(new Object[]{llq,pn, price,qua,tot});
		
		llq++;
		System.out.println(sum);

	}
	});
p4.add(scroll);


p5.add(scroll1);
//generate bil.....................................
b4.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent ev) {
		
		
		try
		{
			t1.setEditable(false);
			p5.setVisible(true);
			p4.setVisible(false);
			p3.setVisible(false);

			
			p2.setVisible(false);
			bl1.setText(String.valueOf(sum));


			String d=t5.getText();
			//int da=Integer.parseInt(date);
			pstmt=con.prepareStatement("insert into bill values(?,?,?,?,?,?)");
			pstmt.setInt(1,count);
			pstmt.setInt(2,cid);
			pstmt.setInt(3,pid);
			pstmt.setString(4,d);
			pstmt.setString(5,quant);
			pstmt.setInt(6,sum);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(p5,"Bill Searched Successfully");

				}catch(Exception ae){
					System.out.println(ae);
				}
		
		p1.setBackground(new Color(255,255,255));

	
	
	
	
	
	
	}});
//new bill.........................
b5.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent ev) {
		p1.setBackground(new Color(255,255,255,0));

		p1.setVisible(true);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		t1.setText("");
		t2.setText("");
		t4.setText("");
				
		t1.setEditable(true);
		while(model.getRowCount()>0) 
		{
			model.removeRow(0);

		}
		while(mod.getRowCount()>0) 
		{
			mod.removeRow(0);

		}
		co=1;
		ll3.setText("Select product");
		ll6.setText("");
		q1=1;
		i=0;
		q=1;
		ch1=0;
		for(int x=0;x<pid2.length;x++)
		{
			pid2[x]=0;
		}
	
		pnam2.clear();
		ii=1;
		ll1.setVisible(false);
		ll2.setVisible(true);
		ch2=0;
		rs=null;
		rs1=null;
		b4.setVisible(false);
		b1.setVisible(false);
		
		b3.setVisible(false);
		qu1.setVisible(false);
		qu2.setVisible(false);
		qu3.setVisible(false);
		
		
		qu2.setText("1");
		ll4.setVisible(false);
		ll5.setVisible(true);
		ii=0;
		qu1.setVisible(false);
		qu2.setVisible(false);
		qu3.setVisible(false);
		b3.setVisible(false);
		t6.setVisible(false);
		t7.setVisible(false);
		t8.setVisible(false);
		jl.setVisible(false);
		jl1.setVisible(false);
		jl2.setVisible(false);
		b2.setText("Back");
		try{
		
		String sql;
		sql="Select * from bill";
		rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			count=rs.getInt(1);
			count++;
		}
		t3.setText(String.valueOf(count));
		}
		catch(Exception e)
		{}
	}});
	}

	public static void main(String[] args) {
		new Bill1();

	}

}
