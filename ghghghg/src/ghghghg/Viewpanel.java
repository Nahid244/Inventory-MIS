package ghghghg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Viewpanel extends JPanel  {
	private JTable table;
	 private JScrollPane scrollpane;
	 private DefaultTableModel dtm;
	 
	 private JComboBox box;
	 private JTextField textfield,textfield1,textfield2;
		private JLabel label,label1,label2;
		private JButton but,but1;
		private Font font;
   public Viewpanel(){
	   init();
   }
   public void init(){

   	table=new JTable();
    scrollpane=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   	  dtm=new DefaultTableModel();
   	Constants.tableloader("Pricing", table, scrollpane, dtm);
   	
	 box=new JComboBox(Constants.functions);
	 box.setBounds(30,300,300,25);
	 font=new Font("Arial",Font.BOLD,20);
 	label=new JLabel();
 	label1=new JLabel();
 	label2=new JLabel();
 	textfield=new JTextField();
 	textfield1=new JTextField();
 	textfield2=new JTextField();
 	but=new JButton("GO");
 	but1=new JButton("Search");
 	//init
 	label.setFont(font);
     label.setText("FROM(YY/MM/DD):");
     label.setBounds(400,300,200,25);
 	textfield.setBounds(600,300,200,25);
 	label1.setFont(font);
     label1.setText("To(YY/MM/DD):");
     label2.setText("search product:");
     label1.setBounds(400,350,200,25);
     label2.setBounds(50,350,250,25);
 	textfield1.setBounds(600,350,200,25);
 	textfield2.setBounds(150,350,200,25);
 	but.setBounds(600,400,200,25);
 	but1.setBounds(150,400,200,25);
 	but.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
        	String d1=textfield.getText().toString();
        	String d2=textfield1.getText().toString();
        	
        	String s=String.valueOf(box.getSelectedItem());
        	if(s==Constants.functions[0]){
        		String qry="select distinct product.name,SUM(Production.productioncost) as cost from Production"
        				+ " join product on Production.p_id=product.p_id where"
        				+ " mfgdate between '"+d1+"' and '"+d2+"'  group by product.name";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[1]){
        		String qry="select distinct product.name,SUM(Production.productionquantity)as quantity from Production"
        				+ " join product on Production.p_id=product.p_id where "
        				+ "mfgdate between '"+d1+"' and '"+d2+"'  group by product.name";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[2]){

        		DateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd");
        		Date date=new Date();
        		String cdate=dateformat.format(date);
        		System.out.println(cdate);
        		String qry="select name as RawMaterials from RawMaterials where datee+besttousewithin='"+cdate+"'";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        		
        	}
        	else if(s==Constants.functions[3]){
        		String qry="select product.name,COUNT(Production.p_id) as Times from Production  "
        				+ "join product on Production.p_id=product.p_id where "
        				+ "mfgdate between '"+d1+"' and '"+d2+"'  group by product.name";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[4]){
        		String qry="select product.name,(SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)as Profits from Production"
        				+ " join product on Production.p_id=product.p_id"
        				+ " join Pricing on product.p_id=Pricing.p_id "
        				+ "where mfgdate between '"+d1+"' and '"+d2+"'  group by product.name,Pricing.price";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[5]){
        		String qry= "select top 3 product.name,(SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)"
        				+ "as profits from Production "
        				+ "join product on Production.p_id=product.p_id"
        				+ " join Pricing on product.p_id=Pricing.p_id where"
        				+ " mfgdate between '"+d1+"' and '"+d2+"'  group by product.name,Pricing.price order by "
        				+ " ((SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)) desc";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[6]){
        		String qry="select RawMaterials.rm_id,RawMaterials.name,RawMaterials.quantity,RawMaterials.datee from RawMaterials "
        				+ "left join Production on RawMaterials.rm_id=Production.rm_id"
        				+ " where Production.production_id is null";
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[7]){
        		String qry ="select product.name as productname,AVG(Production.productionquantity) "
        				+ "as AVGproductionquantity from Production "
        				+ " join product on	Production.p_id=product.p_id "
        				+ "where production.mfgdate between	'"+d1+"' and '"+d2+"' group by product.name"; 
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[8]){
        		String qry ="select product.name as productname,AVG(Production.productioncost) "
        				+ "as AVGproductioncost from Production "
        				+ " join product on	Production.p_id=product.p_id "
        				+ "where production.mfgdate between	'"+d1+"' and '"+d2+"' group by product.name"; 
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	
        	else if(s==Constants.functions[9]){
        		String qry="select product.name as productname,(SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)"
        				+ " as Profits from Production join product on Production.p_id=product.p_id"
        				+ " join Pricing on product.p_id=Pricing.p_id	"
        				+ " where mfgdate between '"+d1+"' and '"+d2+"'  group by product.name,Pricing.price "
        						+ " having ((SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost))> "
        						+ "(     select AVG(prof) from  "
        						+ "(select ((SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)) "
        						+ "as prof from Production join product on Production.p_id=product.p_id	"
        						+ " join Pricing on product.p_id=Pricing.p_id where mfgdate between '"+d1+"' and '"+d2+"'"
        								+ "  group by product.name,Pricing.price )  profit  )";
        				   
        				
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	else if(s==Constants.functions[10]){
        		String qry="select product.name as productname,(SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)"
        				+ " as Profits ,Supervisor.name as supervisor  from Production join product on Production.p_id=product.p_id"
        				+ " join Pricing on product.p_id=Pricing.p_id	"
        				+ " join Supervisor on Production.supervisor_id=Supervisor.supervisor_id "
        				+ " where mfgdate between '"+d1+"' and '"+d2+"'  group by product.name,Pricing.price,Supervisor.name "
        						+ " having ((SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost))< "
        						+ "(     select AVG(prof) from  "
        						+ "(select ((SUM(Production.productionquantity)*Pricing.price)-SUM(Production.productioncost)) "
        						+ "as prof from Production join product on Production.p_id=product.p_id	"
        						+ " join Pricing on product.p_id=Pricing.p_id where mfgdate between '"+d1+"' and '"+d2+"'"
        								+ "  group by product.name,Pricing.price )  profit  )";
        				   
        				
        		Constants.tableloader1(qry, table, scrollpane, dtm);
        	}
        	
        }
   });
 	but1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String s1="%"+textfield2.getText().toString()+"%";
			String qry="select distinct product.name as productname,Pricing.price"
					+ " from product	left join Pricing on product.p_id=Pricing.p_id"
					+ "	where	 product.name=ANY	"
					+ "(   select name from product"
					+ " where name like '"+s1+"'	)";
			Constants.tableloader1(qry, table, scrollpane, dtm);		
			textfield2.setText("");
		}
 		
 		
 	});
	 
	     this.add(scrollpane);
   	      this.add(box); 
   	   this.add(but);
   	 this.add(but1);
   	this.add(label);
   	this.add(label1);
	this.add(label2);
   	this.add(textfield);
   	this.add(textfield1);
   	this.add(textfield2);
	  	  this.setBounds(10, 0, 920, 720);
	        this.setBackground(new Color(135,168,180));
	      this.setVisible(false);
	        this.setLayout(null);
	   
   }
}
