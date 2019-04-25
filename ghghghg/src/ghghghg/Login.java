package ghghghg;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Login extends JFrame{
	private Container c;
	//panel
	private LoginPanel loginpanel;
	private Suppliers supplierspanel;
	private RawMaterials rawmaterialspanel;
	private Supervisor supervisorpanel;
	private Production productionpanel;
	private Product productpanel;
	private Pricing pricingpanel;
	private Viewpanel viewpanel;
	//panel
	 private JMenuBar menubar;
	private JMenu filemenu;
	private JMenuItem newMenuitem,newMenuitem1,newMenuitem2,
	newMenuitem3,newMenuitem4,newMenuitem5,newMenuitem6,newMenuitem7,newMenuitem8;
	;
	public Login(){
		init();
	}
	public void init(){
		c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(195,195,195));
        //init
        
        loginpanel=new LoginPanel();
        supplierspanel=new Suppliers();
        rawmaterialspanel=new RawMaterials();
        supervisorpanel=new Supervisor();
        productionpanel=new Production();
        productpanel=new Product();
        pricingpanel=new Pricing();
        viewpanel =new Viewpanel();
        //init
        newMenuitem=new JMenuItem("LOGOUT");
        newMenuitem1=new JMenuItem("Suppliers");
        newMenuitem2=new JMenuItem("RawMaterials");
        newMenuitem3=new JMenuItem("product");
        newMenuitem4=new JMenuItem("production");
        newMenuitem5=new JMenuItem("Supervisor");
        newMenuitem6=new JMenuItem("Loginpage");
        newMenuitem7=new JMenuItem("Pricing");
        newMenuitem8=new JMenuItem("AdminView");
        ///manu item actions
        newMenuitem.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
            	 loginpanel.getBut().setEnabled(true);
                 loginpanel.getTextfield().setEnabled(true);
                 loginpanel.getTextfield1().setEnabled(true);
                 pricingpanel.setVisible(false);
                	viewpanel.setVisible(false);
                	supervisorpanel.setVisible(false);
                 Constants.log=0;
             }   
        });
        newMenuitem1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(true);
           	rawmaterialspanel.setVisible(false);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(false);
           	productpanel.setVisible(false);
           	pricingpanel.setVisible(false);
           	viewpanel.setVisible(false);
            }   
       });
        newMenuitem2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(true);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(false);
           	productpanel.setVisible(false);
           	pricingpanel.setVisible(false);
           	viewpanel.setVisible(false);
            }   
       });
        newMenuitem3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(false);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(false);
           	productpanel.setVisible(true);
           	pricingpanel.setVisible(false);
           	viewpanel.setVisible(false);
            }   
       });
        newMenuitem4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(false);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(true);
           	productpanel.setVisible(false);
           	pricingpanel.setVisible(false);
           	viewpanel.setVisible(false);
            }   
       });
        newMenuitem5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(false);
           	if(Constants.log==1){
           	supervisorpanel.setVisible(true);
           	}
           	productionpanel.setVisible(false);
           	productpanel.setVisible(false);
           	pricingpanel.setVisible(false);
           	viewpanel.setVisible(false);
            }   
       });
        newMenuitem6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(true);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(false);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(false);
           	productpanel.setVisible(false);
           	pricingpanel.setVisible(false);
           	viewpanel.setVisible(false);
            }   
       });
        newMenuitem7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(false);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(false);
           	productpanel.setVisible(false);
           	if(Constants.log==1){
           	pricingpanel.setVisible(true);
           	}
            viewpanel.setVisible(false);
           	 
            }   
       });
        newMenuitem8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
           	 loginpanel.setVisible(false);
           	 supplierspanel.setVisible(false);
           	rawmaterialspanel.setVisible(false);
           	supervisorpanel.setVisible(false);
           	productionpanel.setVisible(false);
           	productpanel.setVisible(false);
           	pricingpanel.setVisible(false);
           	if(Constants.log==1){
           	 viewpanel.setVisible(true);
           	}
            }   
       });
        
        ///menu item actions
        menubar=new JMenuBar();
        filemenu=new JMenu("MENU");
        
        filemenu.add(newMenuitem);
        filemenu.add(newMenuitem1);
        filemenu.add(newMenuitem2);
        filemenu.add(newMenuitem3);
        filemenu.add(newMenuitem4);
        filemenu.add(newMenuitem5);
        filemenu.add(newMenuitem6);
        filemenu.add(newMenuitem7);
        filemenu.add(newMenuitem8);
        menubar.add(filemenu);
        
        
        
        
        
  
        
        
        
        c.add(loginpanel);
        c.add(supplierspanel);
        c.add(rawmaterialspanel);
        c.add(productpanel);
        c.add(productionpanel);
        c.add(supervisorpanel);
        c.add(pricingpanel);
        c.add(viewpanel);
        this.setJMenuBar(menubar);
        this.setTitle("MIS");
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
       this.setLocation(20, 20);
        this.setPreferredSize(new Dimension(950, 630));
        this.pack();
        this.setVisible(true);
         this.setResizable(false);
		
	}

}
