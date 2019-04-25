package ghghghg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

public class Product extends JPanel {
	private JTable table;
	 private JScrollPane scrollpane;
	 private DefaultTableModel dtm;
	 
	 private JTable table1;
	 private JScrollPane scrollpane1;
	 private DefaultTableModel dtm1;
	 
	 private JTextField textfield,textfield1,textfield2,
	 textfield3,textfield4,textfield5;
		private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8;
		private JButton but,but1,but2;
		private Font font;
	 
	 
	public Product(){
	  	  init();
	    }
	    public void init(){
	    	
	    	table=new JTable();
	    	  scrollpane=new JScrollPane();
	    	  dtm=new DefaultTableModel();
	    	  
	    	  table1=new JTable();
	    	  scrollpane1=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    	  table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    	  dtm1=new DefaultTableModel();
	    	  
	    	  Constants.tableloader("product",table,scrollpane,dtm);

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
	    	   label2=new JLabel();
	           label3=new JLabel();
	            label4=new JLabel();
	    	  ///update
	          ///insert
	              label5=new JLabel();
	              but2 =new JButton("Insert");
	        	  textfield3=new JTextField();
	       	   textfield4=new JTextField();
	       	   textfield5=new JTextField();
	       	 label6=new JLabel();
	          label7=new JLabel();
	           label8=new JLabel();
	       	  design();
	        	  
	          ///insert 
	       	  insert();
	       	  delete();
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
	    	  
	    	  this.add(textfield);
	    	  this.add(textfield1);
	    	  this.add(textfield2);
	    	  this.add(textfield3);
	    	  this.add(textfield4);
	    	  this.add(textfield5);
	    	
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
	    	   
	    	   
	     	  label2.setFont(new Font("Arial",Font.BOLD,10));
	           label2.setText("productid:");
	           label2.setBounds(20, 300, 80, 25);
	           
	           
	      	  label3.setFont(new Font("Arial",Font.BOLD,10));
	            label3.setText("name:");
	            label3.setBounds(150, 300, 80, 25);
	            
	            
	        	  label4.setFont(new Font("Arial",Font.BOLD,10));
	              label4.setText("timeperiod(days):");
	              label4.setBounds(280, 300, 80, 25);
	    	  ///update
	          ///insert
	              
	        	  label5.setFont(font);
	              label5.setText("Insert:");
	              label5.setBounds(20,350,220,25);
	              
	        	  but2.setBounds(240,350,120,25);
	              
	        	 
	       	   textfield3.setBounds(20, 400, 80, 25);
	       	   
	       	   textfield4.setBounds(150, 400, 80, 25);
	       	   
	       	   textfield5.setBounds(280, 400, 80, 25);
	        	
	       	 
	    	  label6.setFont(new Font("Arial",Font.BOLD,10));
	          label6.setText("productid:");
	          label6.setBounds(20, 430, 80, 25);
	          
	          
	     	  label7.setFont(new Font("Arial",Font.BOLD,10));
	           label7.setText("name:");
	           label7.setBounds(150, 430, 80, 25);
	           
	           
	       	  label8.setFont(new Font("Arial",Font.BOLD,10));
	             label8.setText("timeperiod:");
	             label8.setBounds(280, 430, 80, 25);
	        	  
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
	                	
	    				String qry="select product.name as productname,Pricing.price as productprice"
	    						+ " from product join Pricing on product.p_id=Pricing.p_id"
	    						+ " where product.p_id='"+s1+"'";
	    				
	    				textfield.setText(table.getModel().getValueAt(index, 0).toString());	
	    				textfield1.setText(table.getModel().getValueAt(index, 1).toString());
	    				textfield2.setText(table.getModel().getValueAt(index, 2).toString());	
	    					
	    				
	    				Constants.tableloader2(qry,table1,scrollpane1,dtm);
	    				}catch(Exception ex){
	    					System.out.println(ex);
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
	                
	       statement.executeUpdate(" delete from product where p_id='"+s1+"' and name='"+s2+"' ");
	      ResultSet resultSet=null;
//	      resultSet.close();
//	      statement.close();
	     
	    //table.clearSelection();  
	      Constants.tableloader("product", table, scrollpane, dtm);
	    JOptionPane.showMessageDialog(null,"Records deleted");
	    
	  
	           
	          } catch (Exception ex) {  
	        	  JOptionPane.showMessageDialog(null,"Product is in use");
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
	              	int s3=Integer.parseInt(textfield5.getText());
	       
	         
	         
	        	                             
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	     Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
	    
	      Statement statement = connection.createStatement();  
	                
	      statement.execute(" insert into product "  + " values ( '"+s1+"', '"+s2+"',"+s3+" )");
	      ResultSet resultSet=null;
//	      resultSet.close();
//	      statement.close();
	      System.out.println(s1+s2+s3);
	    //table.clearSelection();  
	   
	    Constants.tableloader("product", table, scrollpane, dtm);
	    textfield3.setText("");
	    textfield4.setText("");
	    textfield5.setText("");
	  
	           
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
	              	int s3 = Integer.valueOf(textfield2.getText());
	                  
	         try{ 
	        	                             
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	     Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
	    
	      Statement statement = connection.createStatement();  
	     
	      
	      statement.execute(" update product set p_id='"+s1+"',name='"+s2+"',timeperiod(days)="+s3+" where p_id='"+s1+"'"); 
	      ResultSet resultSet=null;
//	      resultSet.close();
//	      statement.close();
	      
	    //table.clearSelection();  
	   
	    Constants.tableloader("product ", table, scrollpane, dtm);
	    
	           
	          } catch (Exception ex) {  
	        	 // ex.printStackTrace();  
	          }  
	              	
	              	
	            
	              
	             }

	  			  	
	         });
	      
	      } 
}
