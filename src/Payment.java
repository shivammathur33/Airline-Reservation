import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Payment {

	private JFrame frame;
	private JTextField tfUserId;
	private JTextField tfAcNo;

	/**
	 * Launch the application.
	 */
	public void pay() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(181, 11, 85, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setBounds(36, 55, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A/C No.");
		lblNewLabel_2.setBounds(36, 103, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfUserId = new JTextField();
		tfUserId.setBounds(92, 52, 86, 20);
		frame.getContentPane().add(tfUserId);
		tfUserId.setColumns(10);
		
		tfAcNo = new JTextField();
		tfAcNo.setBounds(92, 100, 156, 20);
		frame.getContentPane().add(tfAcNo);
		tfAcNo.setColumns(10);
		
		JButton btnNewButton = new JButton("Proceed With Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								

				 try {
					 	
						int id=Integer.parseInt(tfUserId.getText());
						String acno=(tfAcNo.getText());
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "12345");			
				        // step3 create the statement object	
				        Statement stmt = con.createStatement();			
				        // step4 execute query
				        /*String str = "begin\r\n" + 
				        		"dec_fare;\r\n" + 
				        		"end;\r\n" + 
				        		"/";
				        String str2="select dec_fare() from dual";
				        PreparedStatement c_stmt = con.prepareCall
				        	    ("{call dec_fare()}");
				        	    c_stmt.executeUpdate();*/
				        
				         //int update=stmt.executeUpdate("begin dec_fare; end;");
				        // String qry = "Delete  FROM new_pass";
					      //  PreparedStatement stmt2 = con.prepareStatement(qry);
					       
				        
				        System.out.println("connected!!");	
				        
				        // step5 close the connection object		
				      
				        
				        
				        con.close();
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				
				 Success sc = new Success();
					sc.suc();
					frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(102, 182, 164, 36);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
