import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import org.w3c.dom.Document;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
public class USAB {
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField;
	private static JTextArea textField_2;
	private static JTextField textField_3;
	private static JTextField textField_8;
	private static JTextField textField_9;
	private static JTextField textField_10;
	private static JTextField textField_12;
	private static JTextField textField_13;

	
	public static void main (String[] args) throws Exception { 
		
    	Socket socket = new Socket("localhost", 1234);
    	
	    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
	    BufferedWriter bufferedWriter =  new BufferedWriter(outputStreamWriter);
	    
	    Color myWhite = new Color(230,230,230);

	    


	
	    System.setProperty("sun.java2d.uiScale", "1.0");
    	

        

	    JFrame frame = new JFrame("Tampa Family Clinic Vendor Managment");
	    frame.setSize(800,600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    frame.addWindowListener(new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent e) {
	        	try {
	        		
	        		bufferedWriter.write("CLOSE");
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			
	        	outputStreamWriter.close();
	        	bufferedWriter.close();
	        	socket.close();
	        	}
	        	catch(IOException FailedToDischargeSocket) {
	        		System.out.println("Error 9");
	        	}
	        }
	    });
	    

	    JTextPane textPane = new JTextPane();
	    textPane.setEditable(false);
	    StyledDocument doc = textPane.getStyledDocument();
	    SimpleAttributeSet center = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	    doc.setParagraphAttributes(0, doc.getLength(), center, false);
	    textPane.setBackground(Color.LIGHT_GRAY);
	    textPane.setFont(new Font("SimSun", Font.PLAIN, 15));
	    textPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    textPane.setFocusable(false);
	    
	    JPanel Cardboard = new JPanel();
	    Cardboard.setLayout(new CardLayout(0, 0));
	    
	    JPanel addPanel = new JPanel();
	    addPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
	    Cardboard.add(addPanel, "name_935802778221000");
	    
	
	    
	    JLabel lblNewLabel = new JLabel("Vendor:");
	    
	    textField_4 = new JTextField();
	    textField_4.setFont(new Font("Cambria Math", Font.PLAIN, 14));
	    textField_4.setColumns(10);
	    
	    JLabel lblNewLabel_1 = new JLabel("Account:");
	    
	    textField_5 = new JTextField();
	    textField_5.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_5.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Number:");
	    
	    textField_6 = new JTextField();
	    textField_6.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_6.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("Info:");
	    
	    textField_7 = new JTextField();
	    textField_7.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_7.setColumns(10);
	    
	    JButton btnNewButton_1 = new JButton("Submit");
	    btnNewButton_1.setBackground(myWhite);
	    btnNewButton_1.setContentAreaFilled(false);
	    btnNewButton_1.setFocusPainted(false);
	    btnNewButton_1.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		System.out.println("Click");
	    		
	    		String vendorToAdd = textField_4.getText();
	    		String AccountToAdd = textField_5.getText();
	    		String numberToAdd = textField_6.getText();
	    		String InfoToAdd = textField_7.getText();
	    		boolean vendorCheckBoolean = true;
	    		
	    		if(vendorToAdd.equals("")) {
				    try
				    {
				        doc.insertString(0, "Error please enter a name \n", null );
				    }
				    catch(Exception FailedCheck2) { System.out.println(e); }
	    		vendorCheckBoolean = false;
	    		}

	    		if(AccountToAdd.equals("")) {
	    			AccountToAdd = "NO DATA";
	    		}
	    		if(numberToAdd.equals("")) {
	    			numberToAdd = "NO DATA";
	    		}
	    		if(InfoToAdd.equals("")) {
	    			InfoToAdd = "NO DATA";
	    		}
	    		System.out.println("Vendor Boolean: " + vendorCheckBoolean);
	    		if(vendorCheckBoolean==true) {
	    			
	    			System.out.println("Venor Check boolean passed");
	    			System.out.println("Vendor Check:" + vendorToAdd);
	    		try {    		
	    			bufferedWriter.write("add");
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			System.out.println("Finished Sending Identifying Command");
	    			
	    			bufferedWriter.write(vendorToAdd);
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			System.out.println("Finished Sending Vendor");
	    			
	    			bufferedWriter.write(AccountToAdd);
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			System.out.println("Finished Sending Account");
	    			
	    			bufferedWriter.write(numberToAdd);
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			System.out.println("Finished Sending Number");
	    			
	    			bufferedWriter.write(InfoToAdd);
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			System.out.println("Finished Sending Info");
	    			
	    			textField_4.setText("");
	    			textField_5.setText("");
	    			textField_6.setText("");
	    			textField_7.setText("");
	    			
	    		}
	    		catch(IOException d) {
	    			System.out.println("Error 1");
	    		}
	    	}
	    		 
	    		
	    		
	    	}
	    });
	    
	    JLabel lblNewLabel_7 = new JLabel("Add a Vendor");
	    lblNewLabel_7.setFont(new Font("Rockwell Condensed", Font.PLAIN, 26));
	    GroupLayout gl_addPanel = new GroupLayout(addPanel);
	    gl_addPanel.setHorizontalGroup(
	    	gl_addPanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(8)
	    			.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(8)
	    			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    			.addGap(9)
	    			.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
	    			.addGap(323))
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(8)
	    			.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
	    			.addGap(3)
	    			.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
	    			.addGap(323))
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(2)
	    			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
	    			.addGap(9)
	    			.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
	    			.addGap(323))
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(25)
	    			.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	    			.addGap(3)
	    			.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
	    			.addGap(323))
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(76)
	    			.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(501, Short.MAX_VALUE))
	    );
	    gl_addPanel.setVerticalGroup(
	    	gl_addPanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_addPanel.createSequentialGroup()
	    			.addGap(9)
	    			.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	    			.addGap(66)
	    			.addGroup(gl_addPanel.createParallelGroup(Alignment.LEADING, false)
	    				.addGroup(gl_addPanel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblNewLabel))
	    				.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	    			.addGap(29)
	    			.addGroup(gl_addPanel.createParallelGroup(Alignment.LEADING, false)
	    				.addGroup(gl_addPanel.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(lblNewLabel_2))
	    				.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(34)
	    			.addGroup(gl_addPanel.createParallelGroup(Alignment.LEADING, false)
	    				.addGroup(gl_addPanel.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(lblNewLabel_1))
	    				.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(31)
	    			.addGroup(gl_addPanel.createParallelGroup(Alignment.LEADING, false)
	    				.addGroup(gl_addPanel.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(lblNewLabel_3))
	    				.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(78)
	    			.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(66, Short.MAX_VALUE))
	    );
	    addPanel.setLayout(gl_addPanel);
	    
	    JPanel searchPanel = new JPanel();
	    searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    Cardboard.add(searchPanel, "name_948954628366200");
	    
	    Cardboard.removeAll();
		Cardboard.add(searchPanel);
		Cardboard.repaint();
		Cardboard.revalidate();
		
		bufferedWriter.write("search_combo_request");
		System.out.println("Request Sent: search_combo_request");
		bufferedWriter.newLine();
		bufferedWriter.flush();
	    
	    JLabel lblNewLabel_4 = new JLabel("Vendor:");
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField.setColumns(10);
	    textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    
	    JLabel lblNewLabel_5 = new JLabel("Vendor Search:");
	    
	    JLabel lblNewLabel_6 = new JLabel("VENDOR");
	    lblNewLabel_6.setFont(new Font("Nirmala UI", Font.BOLD, 14));
	    lblNewLabel_6.setVisible(false);
	    
	    JLabel lblNewLabel_8 = new JLabel("Account Data");
	    
	    textField_2 = new JTextArea();
	    textField_2.setLineWrap(true);
	    textField_2.setWrapStyleWord(true);
	    textField_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	    textField_2.setEditable(false);
	    textField_2.setColumns(10);
	    textField_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    textField_2.setFocusable(false);
	    
	    JLabel lblNewLabel_9 = new JLabel("Number:");
	    
	    textField_3 = new JTextField();
	    textField_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
	    textField_3.setEditable(false);
	    textField_3.setColumns(10);
	    textField_3.setFocusable(false);
	    
	    JLabel lblNewLabel_10 = new JLabel("Information Data");
	    
	    JTextArea textArea = new JTextArea();
	    textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    textArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	    textArea.setEditable(false);
	    textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    textArea.setFocusable(false);
	    
	    JButton btnNewButton_2 = new JButton("Search");
	    btnNewButton_2.setBackground(myWhite);
	    btnNewButton_2.setContentAreaFilled(false);
	    btnNewButton_2.setFocusPainted(false);
	    btnNewButton_2.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		String vendorToSearch = textField.getText();
	    		System.out.println("Vendor to Search: " + vendorToSearch);
	    		boolean vendorCheck = true;
	    		
	    		
	    		if(vendorToSearch.equals("")) {
	    			 vendorCheck = false;
					    try
					    {
					        doc.insertString(0, "Error please enter a name \n", null );
					    }
					    catch(Exception FailedCheck) { System.out.println(e); }
	    		}
	    		
	    		if(vendorCheck==true) {
	    		try {
	    			
		    		bufferedWriter.write("search");
	    			bufferedWriter.newLine();
	    			bufferedWriter.flush();
	    			
	    		bufferedWriter.write(vendorToSearch);
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			System.out.println("Finished Sending Location");
	    		} catch(IOException failedToSearch) { }
	    		
	    	}
	    	}
	    });
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBackground(myWhite);

	    
	    comboBox.addItem("Select");
	    comboBox.setSelectedItem("Select");
 comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String a = "hi";
	    		if(a.equals("hi")) {
	    			System.out.println("a1");
	    		}
	    		if(!a.equals("hi")) {
	    			System.out.println("b2");
	    		}
	    		
	    		
	    		String vendorToSearchCombo = String.valueOf(comboBox.getSelectedItem());
	    		vendorToSearchCombo = vendorToSearchCombo.toString();
				System.out.println("Combo Initiater: " + vendorToSearchCombo);	
				
				
	    		if(!vendorToSearchCombo.equals("Select") && !vendorToSearchCombo.equals("null")) {
	    		    lblNewLabel_6.setVisible(true);
					System.out.println("Combo Initiater passed");
	    		
	    		try {
	    		bufferedWriter.write("search");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
    		bufferedWriter.write(vendorToSearchCombo);
			bufferedWriter.newLine();
			bufferedWriter.flush();
	    		}
	    		catch(IOException failedCombo) {
	    			
	    		}
	    	}
	    		else {
	    			System.out.println("Did not pass");
	    		}
	    		
	    	}
	    });
	    
	    JLabel lblNewLabel_15 = new JLabel("Search");
	    lblNewLabel_15.setFont(new Font("Rockwell Condensed", Font.PLAIN, 26));
	    
	    JButton btnNewButton_2_1 = new JButton("Enable Selecting");
	    btnNewButton_2_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		
	    		String determiningFactor = btnNewButton_2_1.getText();
	    		
	    		if(determiningFactor.equals("Enable Selecting")) {
		    		textArea.setFocusable(true);
		    		textField_2.setFocusable(true);
		    		textField_3.setFocusable(true);
		    		btnNewButton_2_1.setText("Disable Selecting");
	    		}
	    		if(determiningFactor.equals("Disable Selecting")) {
		    		textArea.setFocusable(false);
		    		textField_2.setFocusable(false);
		    		textField_3.setFocusable(false);
		    		btnNewButton_2_1.setText("Enable Selecting");
	    		}

	    		
	    	}
	    });
	    int width = textArea.getWidth();
	    btnNewButton_2_1.setFocusPainted(false);
	    btnNewButton_2_1.setContentAreaFilled(false);
	    btnNewButton_2_1.setBorder(new LineBorder(Color.BLACK));
	    btnNewButton_2_1.setBackground(new Color(230, 230, 230));
	    GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
	    gl_searchPanel.setHorizontalGroup(
	    	gl_searchPanel.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(gl_searchPanel.createSequentialGroup()
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblNewLabel_9)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(textField_3, 0, 157, Short.MAX_VALUE)
	    					.addGap(416))
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addContainerGap()
	    					.addGroup(gl_searchPanel.createParallelGroup(Alignment.TRAILING)
	    						.addGroup(gl_searchPanel.createSequentialGroup()
	    							.addGap(0)
	    							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
	    							.addGap(0, 104, Short.MAX_VALUE))
	    						.addComponent(textArea, 0, 299, Short.MAX_VALUE))
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_searchPanel.createSequentialGroup()
	    							.addComponent(textField_2, 0, 298, Short.MAX_VALUE)
	    							.addGap(15))
	    						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addGap(8)
	    					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(gl_searchPanel.createSequentialGroup()
	    							.addGap(48)
	    							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)))
	    					.addGap(10)
	    					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
	    					.addGap(8)
	    					.addComponent(comboBox, 0, 155, Short.MAX_VALUE))
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addContainerGap()
	    					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(gl_searchPanel.createSequentialGroup()
	    							.addGap(88)
	    							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))))
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
	    					.addGap(18)
	    					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap())
	    );
	    gl_searchPanel.setVerticalGroup(
	    	gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_searchPanel.createSequentialGroup()
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(68)
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addGap(1)
	    					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_searchPanel.createSequentialGroup()
	    							.addGap(3)
	    							.addComponent(lblNewLabel_4))
	    						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
	    				.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_searchPanel.createSequentialGroup()
	    					.addGap(11)
	    					.addComponent(lblNewLabel_5))
	    				.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
	    			.addGap(32)
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(textField_3, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(31)
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_10)
	    				.addComponent(lblNewLabel_8))
	    			.addGap(6)
	    			.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
	    				.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
	    			.addGap(6))
	    );
	    searchPanel.setLayout(gl_searchPanel);

	    
	    JPanel deletePanel = new JPanel();
	    deletePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    Cardboard.add(deletePanel, "name_953067968620000");
	    
	    JLabel lblNewLabel_11 = new JLabel("Vendor:");
	    
	    textField_8 = new JTextField();
	    textField_8.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_8.setColumns(10);
	    textField_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    
	    JButton btnNewButton_4 = new JButton("Submit");
	    btnNewButton_4.setBackground(myWhite);
	    btnNewButton_4.setContentAreaFilled(false);
	    btnNewButton_4.setFocusPainted(false);
	    btnNewButton_4.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		Boolean confirm = false;
	    	    int result = JOptionPane.showConfirmDialog(frame,"Confirm \n This action cannot be undone", "Confirm Deletion",
	    	               JOptionPane.YES_NO_OPTION,
	    	               JOptionPane.QUESTION_MESSAGE);
	    	            if(result == JOptionPane.YES_OPTION){
	    	            	confirm = true;
	    	            }
	    	            else {
	    	            	
	    	            }
	    		
	    	            if(confirm == true) {
	    		String vendorToDelete = textField_8.getText();
	    		
	    		try {
	    		bufferedWriter.write("Delete");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
	    		bufferedWriter.write(vendorToDelete);
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
	    		}
	    		catch(IOException failToDelete) {
	    			System.out.println("Error 404");
	    		}
	    	}
	    	}
	    });
	    
	    JLabel lblNewLabel_16 = new JLabel("Delete a Vendor");
	    lblNewLabel_16.setFont(new Font("Rockwell Condensed", Font.PLAIN, 26));
	    GroupLayout gl_deletePanel = new GroupLayout(deletePanel);
	    gl_deletePanel.setHorizontalGroup(
	    	gl_deletePanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_deletePanel.createSequentialGroup()
	    			.addGap(8)
	    			.addGroup(gl_deletePanel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_deletePanel.createSequentialGroup()
	    					.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 44, 44*3)
	    					.addContainerGap())
	    				.addGroup(gl_deletePanel.createSequentialGroup()
	    					.addGroup(gl_deletePanel.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(gl_deletePanel.createSequentialGroup()
	    							.addGap(52)
	    							.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
	    						.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
	    					.addGap(254))))
	    );
	    gl_deletePanel.setVerticalGroup(
	    	gl_deletePanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_deletePanel.createSequentialGroup()
	    			.addGap(9)
	    			.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
	    			.addGap(49)
	    			.addGroup(gl_deletePanel.createParallelGroup(Alignment.LEADING)
	    				.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(gl_deletePanel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblNewLabel_11)))
	    			.addGap(34)
	    			.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 35, 45)
	    			.addGap(285))
	    );
	    deletePanel.setLayout(gl_deletePanel);
	    
	    JPanel editPanel = new JPanel();
	    editPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    Cardboard.add(editPanel, "name_953472696748000");
	    
	    JLabel lblNewLabel_12 = new JLabel("Vendor:");
	    
	    textField_9 = new JTextField();
	    textField_9.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_9.setColumns(10);
	    
	    JTextArea textArea_1 = new JTextArea();
	    textArea_1.setLineWrap(true);
	    textArea_1.setBackground(myWhite);
	    textArea_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
	    textArea_1.setEditable(false);
	    textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	    
	    
	    
	    
	    
	    
	    JButton btnNewButton_6 = new JButton("Submit Edits");
	    btnNewButton_6.setBackground(myWhite);
	    btnNewButton_6.setContentAreaFilled(false);
	    btnNewButton_6.setFocusPainted(false);
	    btnNewButton_6.setBorder(new LineBorder(Color.BLACK));
	    btnNewButton_6.setEnabled(false);
	    btnNewButton_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String editSubject = textField_9.getText();
	    		
	    		try {
	    		bufferedWriter.write("edit");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
	    		bufferedWriter.write(editSubject);
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
    			
    			
    			String areaEdits = textArea_1.getText();
    			System.out.println(areaEdits);
    			
    			
   
    			String[] arr = areaEdits.split("\n");    

    			for ( String ss : arr) {
    				System.out.println("Sending: " + ss);
    	    		bufferedWriter.write(ss);
        			bufferedWriter.newLine();
        			bufferedWriter.flush();
    			    
    			}
	    		bufferedWriter.write("END_EDIT NULL");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
    			
    			
	    		}
	    		catch(IOException failToEdit) {
	    			System.out.println("Error 2");
	    		}
	    		
	    		textArea_1.setText("");
	    		btnNewButton_6.setEnabled(false);
	    		textField_9.setText("");
	    	}
	    });
	    
	    JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Delete");
	    
	    textField_10 = new JTextField();
	    textField_10.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_10.setColumns(10);
	    
	    JLabel lblNewLabel_14 = new JLabel("Info:");
	    
	    JButton btnNewButton_7 = new JButton("Submit");
	    btnNewButton_7.setBackground(myWhite);
	    btnNewButton_7.setContentAreaFilled(false);
	    btnNewButton_7.setFocusPainted(false);
	    btnNewButton_7.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String AddressEdit = textField_10.getText();
	    		String determinent = "+Info ";
	    			if(chckbxNewCheckBox_1.isSelected()){
	    				determinent = "-Info ";
	    			}
	    			textArea_1.append(determinent + AddressEdit  + "\n");
	    			
	    			textField_10.setText("");
	    			chckbxNewCheckBox_1.setSelected(false);
	    	}
	    });
	    
	    JLabel lblNewLabel_18 = new JLabel("Number:");
	    
	    textField_12 = new JTextField();
	    textField_12.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_12.setColumns(10);
	    
	    JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Delete");
	    
	    JButton btnNewButton_9 = new JButton("Submit");
	    btnNewButton_9.setBackground(myWhite);
	    btnNewButton_9.setContentAreaFilled(false);
	    btnNewButton_9.setFocusPainted(false);
	    btnNewButton_9.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_9.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String NumberEdit = textField_12.getText();
	    		String determinent = "+Number ";
	    			if(chckbxNewCheckBox_3.isSelected()){
	    				determinent = "-Number ";
	    			}
	    			textArea_1.append(determinent + NumberEdit  + "\n");
	    			
	    			
	    			textField_12.setText("");
	    			chckbxNewCheckBox_3.setSelected(false);
	    	}
	    });
	    
	    JLabel lblNewLabel_20 = new JLabel("Account:");
	    
	    textField_13 = new JTextField();
	    textField_13.setFont(new Font("Cambria Math", Font.PLAIN, 11));
	    textField_13.setColumns(10);
	    
	    JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Delete");
	    
	    JButton btnNewButton_10 = new JButton("Submit\r\n");
	    btnNewButton_10.setBackground(myWhite);
	    btnNewButton_10.setContentAreaFilled(false);
	    btnNewButton_10.setFocusPainted(false);
	    btnNewButton_10.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_10.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String AccountEdit = textField_13.getText();
	    		String determinent = "+Account ";
	    			if(chckbxNewCheckBox_4.isSelected()){
	    				determinent = "-Account ";
	    			}
	    			textArea_1.append(determinent + AccountEdit  + "\n");
	    			textField_13.setText("");
	    			chckbxNewCheckBox_4.setSelected(false);
	    	}
	    });
	    
	    JButton btnNewButton_11 = new JButton("Check");
	    btnNewButton_11.setBackground(myWhite);
	    btnNewButton_11.setContentAreaFilled(false);
	    btnNewButton_11.setFocusPainted(false);
	    btnNewButton_11.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_11.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		String vendorToCheck = textField_9.getText();
	    		
	    		try {
	    		bufferedWriter.write("check");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
	    		bufferedWriter.write(vendorToCheck);
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			
    			
    			
	    		}
	    		catch(IOException failedToCheckEdit) {
	    			System.out.println("Error 3");
	    		}
	    		
	    		
	    		
	    	}
	    });
	    
	    JLabel lblNewLabel_21 = new JLabel("Edit");
	    lblNewLabel_21.setFont(new Font("Rockwell Condensed", Font.PLAIN, 26));
	    
	    JComboBox comboBox_1 = new JComboBox();
	    comboBox_1.setBackground(myWhite);
	    GroupLayout gl_editPanel = new GroupLayout(editPanel);
	    gl_editPanel.setHorizontalGroup(
	    	gl_editPanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(Alignment.TRAILING, gl_editPanel.createSequentialGroup()
	    			.addContainerGap(478, Short.MAX_VALUE)
	    			.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
	    			.addGap(48))
	    		.addGroup(gl_editPanel.createSequentialGroup()
	    			.addGap(8)
	    			.addGroup(gl_editPanel.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(gl_editPanel.createSequentialGroup()
	    					.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    								.addGroup(gl_editPanel.createSequentialGroup()
	    									.addComponent(lblNewLabel_20, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
	    									.addPreferredGap(ComponentPlacement.UNRELATED)
	    									.addComponent(textField_13, GroupLayout.DEFAULT_SIZE, 249, 385)
	    									.addGap(26)
	    									.addComponent(chckbxNewCheckBox_4, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
	    								.addGroup(gl_editPanel.createSequentialGroup()
	    									.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    										.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
	    										.addGroup(gl_editPanel.createSequentialGroup()
	    											.addPreferredGap(ComponentPlacement.RELATED)
	    											.addComponent(lblNewLabel_18, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
	    											.addPreferredGap(ComponentPlacement.RELATED)
	    											.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    												.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 253, 385)
	    												.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 253, 385))))
	    									.addGap(6)
	    									.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    										.addComponent(chckbxNewCheckBox_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
	    										.addComponent(chckbxNewCheckBox_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
	    									.addPreferredGap(ComponentPlacement.RELATED))
	    								.addGroup(gl_editPanel.createSequentialGroup()
	    									.addGap(148)
	    									.addComponent(btnNewButton_7, GroupLayout.DEFAULT_SIZE, 89, 178)
	    									.addGap(177)))
	    							.addGap(6))
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGap(148)
	    							.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, 89, 178)
	    							.addGap(183))
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGap(148)
	    							.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 89, 178)
	    							.addGap(183)))
	    					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE))
	    				.addGroup(gl_editPanel.createSequentialGroup()
	    					.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGap(51)
	    							.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
	    						.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
	    					.addGap(6)
	    					.addComponent(btnNewButton_11, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
	    					.addGap(74)
	    					.addComponent(comboBox_1, 0, 192, Short.MAX_VALUE)))
	    			.addGap(18))
	    		.addGroup(gl_editPanel.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lblNewLabel_21, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(494, Short.MAX_VALUE))
	    );
	    gl_editPanel.setVerticalGroup(
	    	gl_editPanel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_editPanel.createSequentialGroup()
	    			.addComponent(lblNewLabel_21, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
	    			.addGap(36)
	    			.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_editPanel.createSequentialGroup()
	    					.addGap(3)
	    					.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGap(1)
	    							.addComponent(lblNewLabel_12))))
	    				.addGroup(gl_editPanel.createSequentialGroup()
	    					.addGap(2)
	    					.addComponent(btnNewButton_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
	    				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(20)
	    			.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_editPanel.createSequentialGroup()
	    					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 322, Short.MAX_VALUE)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 17, 36))
	    				.addGroup(gl_editPanel.createSequentialGroup()
	    					.addGap(40)
	    					.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGap(1)
	    							.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    								.addGroup(gl_editPanel.createSequentialGroup()
	    									.addGap(3)
	    									.addComponent(lblNewLabel_14))))
	    						.addComponent(chckbxNewCheckBox_1))
	    					.addGap(21)
	    					.addComponent(btnNewButton_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	    					.addGap(52)
	    					.addGroup(gl_editPanel.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(chckbxNewCheckBox_3)
	    						.addComponent(lblNewLabel_18)
	    						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	    					.addGap(62)
	    					.addGroup(gl_editPanel.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_editPanel.createSequentialGroup()
	    							.addGap(1)
	    							.addComponent(lblNewLabel_20))
	    						.addGroup(gl_editPanel.createParallelGroup(Alignment.BASELINE)
	    							.addComponent(chckbxNewCheckBox_4)
	    							.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap())
	    );
	    editPanel.setLayout(gl_editPanel);
	    
	    JLabel lblNewLabel_22 = new JLabel("v1.0");
	    
	    JPanel panel = new JPanel();
	    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(10)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(Cardboard, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
	    					.addGap(8)
	    					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
	    					.addContainerGap())
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(lblNewLabel_22, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(54))))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(Cardboard, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
	    				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lblNewLabel_22))
	    			.addGap(13))
	    );
	    GridLayout layout = new GridLayout(0,1);
	    panel.setLayout(layout);
	    layout.setVgap(4);
	    

	    
	    JButton dltButton = new JButton("Delete");
	    panel.add(dltButton);
	    dltButton.setBackground(myWhite);
	    dltButton.setContentAreaFilled(false);
	    dltButton.setFocusPainted(false);
	    dltButton.setBorder(new LineBorder(Color.BLACK));
	    

	    
	    dltButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Cardboard.removeAll();
	    		Cardboard.add(deletePanel);
	    		Cardboard.repaint();
	    		Cardboard.revalidate();;
	    	}
	    });
	    
	    
	    JButton btnNewButton = new JButton("Add");
	    panel.add(btnNewButton);
	    
	    	    btnNewButton.setBackground(myWhite);
	    	    btnNewButton.setContentAreaFilled(false);
	    	    btnNewButton.setFocusPainted(false);
	    	    btnNewButton.setBorder(new LineBorder(Color.BLACK));
	    	    
	    	    
	    	    btnNewButton.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent e) {
	    	    		Cardboard.removeAll();
	    	    		Cardboard.add(addPanel);
	    	    		Cardboard.repaint();
	    	    		Cardboard.revalidate();;
	    	    	}
	    	    });
	    
	    JButton btnNewButton_5 = new JButton("Edit");
	    panel.add(btnNewButton_5);
	    btnNewButton_5.setBackground(myWhite);
	    btnNewButton_5.setContentAreaFilled(false);
	    btnNewButton_5.setFocusPainted(false);
	    btnNewButton_5.setBorder(new LineBorder(Color.BLACK));
	    
	    btnNewButton_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox_1.removeAllItems();
	    	    comboBox_1.addItem("Select");
	    		Cardboard.removeAll();
	    		Cardboard.add(editPanel);
	    		Cardboard.repaint();
	    		Cardboard.revalidate();
	    		
    			try {
	    		bufferedWriter.write("search_combo_request");
	    		System.out.println("Request Sent: search_combo_request");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			}
    			catch(IOException failedSearchComboRequest) {
    				System.out.println("Error 3");
    			}
    			
	    		
	    	}
	    });
	    
	    
	    JButton btnSearch = new JButton("Search");
	    panel.add(btnSearch);
	    btnSearch.setSize(200,800);
	    btnSearch.setBackground(myWhite);
	    btnSearch.setContentAreaFilled(false);
	    btnSearch.setFocusPainted(false);
	    btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
	    
	    btnSearch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		comboBox.removeAllItems();
	    	    comboBox.addItem("Select");
    			try {
	    		bufferedWriter.write("search_combo_request");
	    		System.out.println("Request Sent: search_combo_request");
    			bufferedWriter.newLine();
    			bufferedWriter.flush();
    			}
    			catch(IOException failedSearchComboRequest) {
    				System.out.println("Error 3");
    			}
	    		
	    		
	    		
	    		
	    		Cardboard.removeAll();
	    		Cardboard.add(searchPanel);
	    		Cardboard.repaint();
	    		Cardboard.revalidate();;
	    	}
	    });
	    frame.getContentPane().setLayout(groupLayout);
	    

	    
	    
	    frame.validate();
	    frame.setResizable(true);
	    frame.setVisible(true);
		
	    //------------------------------------------------------------------------------------------------------------------------------------------------------------------
	     class readingThread implements Runnable {

		        public void run(){
		           System.out.println("Clinic Reading Active");

		    try {
	 
	   	InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());	
	   	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		    
		    while(true) {
		    	
		    	
		    	
		    	
		    	
		    	String messageFromServer = bufferedReader.readLine();
		    	System.out.println("Packet Recieved: " + messageFromServer);
		    	String arr[] = messageFromServer.split(" ", 2);

		    	String identifier = arr[0]; 
		    	System.out.println("Identifier: " + identifier);
		    	
		    	String data = arr[1];   
		    	
		    	if(identifier.equals("Console_Appendation:")) {

			    
			    	
			    	
			    	
			    	
				  
				    
				    try
				    {
				        doc.insertString(0, data + "\n", null );
				    }
				    catch(Exception e) { System.out.println(e); }
				    
				    
			    	
			    	
		    	}
		    	if(identifier.equals("Target_Search")) {
		    		String AccountID = bufferedReader.readLine();
		    		String VendorID =  bufferedReader.readLine();
		    		String InfoID =  bufferedReader.readLine();
		    		String NumberID =  bufferedReader.readLine();
		    		
		    		InfoID = InfoID.replace(",", "\n");
		    		AccountID = AccountID.replace(", ", "\n");
		    		
		    		System.out.println("Account: " + AccountID );
		    		System.out.println("Vendor: " + VendorID );
		    		System.out.println("Info: " + InfoID );
		    		System.out.println("Number: " + NumberID );
		    		
		    		//textField_1.setText(VendorID);
		    		textField_2.setText(AccountID);
		    		textField_3.setText(NumberID);
		    		textArea.setText(InfoID);
		    		lblNewLabel_6.setText(VendorID);
	    		    lblNewLabel_6.setVisible(true);
		    	}
		    	 
		    	if(identifier.equals("search_combo_request:")) {
		    		
		    		
		        	System.out.println("Combo Request: " + data);      	
		    	    comboBox.addItem(data);
		    	    comboBox_1.addItem(data);
		    	}

		    	if(identifier.equals("Edit_Enabled")) {
		    		btnNewButton_6.setEnabled(true);
		    	}
 
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	if(inputStreamReader.equals("Close")) {
		    		System.out.println("Stopping");
		    		break;
 
		    	}
		    	
		    	
		    	
		    }//while
		    
		    socket.close();
		    inputStreamReader.close();
		    bufferedReader.close();
		    
		    }//try
		    
		   
		    
		    
		    catch(IOException Inet) {System.out.println("Error 2");}
		        }
		      }//THREAD
	   	 Thread t1 = new Thread(new readingThread());
		 t1.start();
	     //------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	}
}
