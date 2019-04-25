package ghghghg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class RawMaterials extends JPanel {
	private JTable table;
	 private JScrollPane scrollpane;
	 private DefaultTableModel dtm;
	 
	 private JTable table1;
	 private JScrollPane scrollpane1;
	 private DefaultTableModel dtm1;
	 
	 private JTextField textfield,textfield1,textfield2,
	 textfield3,textfield4,textfield5,textfield6,textfield7,textfield8
	 ,textfield9,textfield10,textfield11,textfield12,textfield13;
		private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,
		label9,label10,label11,
		label12,label13,label14,
		label15,label16;
		private JButton but,but1,but2;
		private Font font;
	public RawMaterials(){
  	  init();
    }
    public void init(){
    	
    	table=new JTable();
  	  scrollpane=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  	  dtm=new DefaultTableModel();
  	  
  	table1=new JTable();
	  scrollpane1=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	  table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  dtm1=new DefaultTableModel();
  	  Constants.tableloader("RawMaterials",table,scrollpane,dtm);
  	  
  	  

  	  
  	font=new Font("Arial",Font.BOLD,21);
	  
	  label=new JLabel();

    but =new JButton("DELETE");

	  ///delete
	  //update
	  label1=new JLabel();
    but1 =new JButton("UPDATE");
	  
	   textfield=new JTextField();
	   textfield1=new JTextField();
	   textfield2=new JTextField();
	   textfield6=new JTextField();
	   textfield7=new JTextField();
	   textfield8=new JTextField();
	   textfield12=new JTextField();
	   label2=new JLabel();
     label3=new JLabel();
      label4=new JLabel();
      label9=new JLabel();
      label10=new JLabel();
       label11=new JLabel();
       label12=new JLabel();
	  ///update
    ///insert
        label5=new JLabel();
        but2 =new JButton("Insert");
  	  textfield3=new JTextField();
 	   textfield4=new JTextField();
 	   textfield5=new JTextField();
 	  textfield9=new JTextField();
	   textfield10=new JTextField();
	   textfield11=new JTextField();
	   textfield13=new JTextField();
 	 label6=new JLabel();
    label7=new JLabel();
     label8=new JLabel();
     label13=new JLabel();
     label14=new JLabel();
      label15=new JLabel();
      label16=new JLabel();
 	  design();
 	  delete();
  	  insert();
  	  selected();
  	update();
  	 
  	  this.add(scrollpane);
  	 this.add(scrollpane1);
  	this.add(but);
	  this.add(but1);
	  this.add(but2);
	  this.add(label);
	  this.add(label1);
	  this.add(label2);
	  this.add(label3);
	  this.add(label4);
	  this.add(label5);
	  
	  this.add(label6);
	  this.add(label7);
	  this.add(label8);
	  this.add(label9);
	  this.add(label10);
	  this.add(label11);
	  this.add(label12);
	  
	  this.add(label13);
	  this.add(label14);
	  this.add(label15);
	  this.add(label16);
	  
	  this.add(textfield);
	  this.add(textfield1);
	  this.add(textfield2);
	  this.add(textfield3);
	  this.add(textfield4);
	  this.add(textfield5);
	  this.add(textfield6);
	  this.add(textfield7);
	  this.add(textfield8);
	  this.add(textfield9);
	  this.add(textfield10);
	  this.add(textfield11);
	  this.add(textfield12);
	  this.add(textfield13);
    	
  	  this.setBounds(10, 0, 920, 720);
        this.setBackground(new Color(135,168,180));
      this.setVisible(false);
        this.setLayout(null);
    }
    public void design(){
  	  //delete
  	  
  	  label.setFont(font);
        label.setText("DELETE SELECTED:");
        label.setBounds(20,220,220,25);
        
   	  but.setBounds(240,220,120,25);
  	  ///delete
  	  //update
  	  
  	  label1.setFont(font);
        label1.setText("UPDATE SELECTED:");
        label1.setBounds(20,250,220,25);
        
  	  but1.setBounds(240,250,120,25);
  	   
  	   textfield.setBounds(20, 280, 80, 25);
  	   
  	   textfield1.setBounds(150, 280, 80, 25);
  	   
  	   textfield2.setBounds(280, 280, 80, 25);
  	 textfield6.setBounds(410, 280, 80, 25);
	   
	   textfield7.setBounds(540, 280, 80, 25);
	   
	   textfield8.setBounds(670, 280, 80, 25);
	   textfield12.setBounds(800, 280, 80, 25);
  	   
  	   
   	  label2.setFont(new Font("Arial",Font.BOLD,10));
         label2.setText("RMid:");
         label2.setBounds(20, 300, 80, 25);
         
         
    	  label3.setFont(new Font("Arial",Font.BOLD,10));
          label3.setText("supplierid:");
          label3.setBounds(150, 300, 80, 25);
          
          
      	  label4.setFont(new Font("Arial",Font.BOLD,10));
            label4.setText("name:");
            label4.setBounds(280, 300, 80, 25);
            label9.setFont(new Font("Arial",Font.BOLD,10));
            label9.setText("quantity:");
            label9.setBounds(410, 300, 80, 25); 
            
            
            label10.setFont(new Font("Arial",Font.BOLD,10));
            label10.setText("cost:");
            label10.setBounds(540, 300, 80, 25);
            
            label11.setFont(new Font("Arial",Font.BOLD,10));
            label11.setText("YY/MM//dd:");
            label11.setBounds(670, 300, 80, 25);
            
            label12.setFont(new Font("Arial",Font.BOLD,10));
            label12.setText("besttousewithin:");
            label12.setBounds(800, 300, 80, 25);
  	  ///update
        ///insert
            
      	  label5.setFont(font);
            label5.setText("Insert:");
            label5.setBounds(20,350,220,25);
            
      	  but2.setBounds(240,350,120,25);
            
      	 
     	   textfield3.setBounds(20, 400, 80, 25);
     	   
     	   textfield4.setBounds(150, 400, 80, 25);
     	   
     	   textfield5.setBounds(280, 400, 80, 25);
     	  textfield9.setBounds(410, 400, 80, 25);
    	   
    	   textfield10.setBounds(540, 400, 80, 25);
    	   
    	   textfield11.setBounds(670, 400, 80, 25);
    	   textfield13.setBounds(800, 400, 80, 25);
      	
     	 
  	  label6.setFont(new Font("Arial",Font.BOLD,10));
        label6.setText("RMid:");
        label6.setBounds(20, 430, 80, 25);
        
        
   	  label7.setFont(new Font("Arial",Font.BOLD,10));
         label7.setText("supplierid:");
         label7.setBounds(150, 430, 80, 25);
         
         
     	  label8.setFont(new Font("Arial",Font.BOLD,10));
           label8.setText("name:");
           label8.setBounds(280, 430, 80, 25);
           
           label13.setFont(new Font("Arial",Font.BOLD,10));
           label13.setText("quantity:");
           label13.setBounds(410, 430, 80, 25); 
           
           
           label14.setFont(new Font("Arial",Font.BOLD,10));
           label14.setText("cost:");
           label14.setBounds(540, 430, 80, 25);
           
           label15.setFont(new Font("Arial",Font.BOLD,10));
           label15.setText("YY/MM/DD:");
           label15.setBounds(670, 430, 80, 25);
           
           label16.setFont(new Font("Arial",Font.BOLD,10));
           label16.setText("besttousewithin:");
           label16.setBounds(800, 430, 80, 25);
      	  
        ///insert    
    }
    public void selected(){
  	  table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
			
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(e.getValueIsAdjusting()){
					return;
				}
				try{
				int index=table.getSelectedRow();
            	String s1=table.getModel().getValueAt(index,0).toString();
            	System.out.println(s1);
				String qry="select RawMaterials.name as Rawmaterialname,Suppliers.addresss as Supplieraddres, Suppliers.phone as SupplierPhone "
						+ " from RawMaterials join Suppliers on RawMaterials.supplier_id=Suppliers.supplier_id"
						+ " where RawMaterials.rm_id='"+s1+"'";
				
				textfield.setText(table.getModel().getValueAt(index, 0).toString());	
				textfield1.setText(table.getModel().getValueAt(index, 1).toString());
				textfield2.setText(table.getModel().getValueAt(index, 2).toString());	
				textfield6.setText(table.getModel().getValueAt(index, 3).toString());	
				textfield7.setText(table.getModel().getValueAt(index, 4).toString());
				textfield8.setText(table.getModel().getValueAt(index, 5).toString());	
				textfield12.setText(table.getModel().getValueAt(index, 6).toString());	
				
				Constants.tableloader2(qry,table1,scrollpane1,dtm);
              }catch(Exception ex){
  				
  			}
				
		}    	
       });
  	  
    }
    public void delete(){
  	  but.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
          	  
                
            	int index=table.getSelectedRow();
            	String s1=table.getModel().getValueAt(index,0).toString();
            	
            	String s2=table.getModel().getValueAt(index,1).toString();
            	
     
       
       try{ 
      	                             
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
   Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
  
    Statement statement = connection.createStatement();  
              
     statement.executeUpdate(" delete from RawMaterials where rm_id='"+s1+"' and supplier_id='"+s2+"'  ");
    ResultSet resultSet=null;

    Constants.tableloader("RawMaterials", table, scrollpane, dtm);
  JOptionPane.showMessageDialog(null,"Records deleted");
  

         
        } catch (Exception ex) {  
      	  JOptionPane.showMessageDialog(null,"Rawmaterial is in use");
        }  
            	
            	
          
            
           }    	
       });
    
    }
    public void insert(){
  	  but2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
          	  
            	try{ 
            	
            	String s1=textfield3.getText().toString();
            	
            	String s2=textfield4.getText().toString();
            	String s3=textfield5.getText().toString();
                int s4=Integer.parseInt(textfield9.getText());
            	
                int s5=Integer.parseInt(textfield10.getText());
            	String s6=textfield11.getText().toString();
            	int s7=Integer.parseInt(textfield13.getText());
     
       
       
      	                             
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
   Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
  
    Statement statement = connection.createStatement();  
              
    statement.execute(" insert into RawMaterials "  + " values ( '"+s1+"', '"+s2+"','"+s3+"',"+s4+","+s5+",'"+s6+"',"+s7+" )");
    ResultSet resultSet=null;
//    resultSet.close();
//    statement.close();
    System.out.println(s1+s2+s3);
  //table.clearSelection();  
 
  Constants.tableloader("RawMaterials", table, scrollpane, dtm);
  textfield3.setText("");
  textfield4.setText("");
  textfield5.setText("");
  textfield9.setText("");
  textfield10.setText("");
  textfield11.setText("");
  textfield13.setText("");

         
        } catch (Exception ex) {  
        	JOptionPane.showMessageDialog(null,"Please enter valid info");
        }  
            	
            	
          
            
           }

			  	
       });
    
    }
    public void update(){
    	  but1.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e) {
            	  
                  
              	
              	String s1=textfield.getText().toString();
              	
              	String s2 = textfield1.getText().toString();
              	String s3 = textfield2.getText().toString();
                  int s4 = Integer.parseInt(textfield6.getText());
              	
                  int s5 = Integer.parseInt(textfield7.getText());
              	String s6 = textfield8.getText().toString();
              	
              	
              	
              	String s7=textfield12.getText().toString();
       
              	System.out.println(s1+s2+s3+s4+s5+s6+s7);
         try{ 
        	                             
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
    
      Statement statement = connection.createStatement();  
     
      
      statement.execute(" update RawMaterials set rm_id='"+s1+"',supplier_id='"+s2+"',name='"+s3+"',quantity="+s4+",cost="+s5+",datee='"+s6+"',besttousewithin="+s7+" where rm_id='"+s1+"'"); 
      ResultSet resultSet=null;
//      resultSet.close();
//      statement.close();
      
    //table.clearSelection();  
   
    Constants.tableloader("RawMaterials ", table, scrollpane, dtm);
    
           
          } catch (Exception ex) {  
        	 // ex.printStackTrace();  
          }  
              	
              	
            
              
             }

  			  	
         });
      
      }
}
