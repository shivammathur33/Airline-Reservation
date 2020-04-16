import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PassengerDetails {

	private JFrame frame;
	private JTextField tfFname;
	private JTextField tfMinit;
	private JTextField tfLName;
	private JTextField tfAge;
	JLabel lblFlight;
	JLabel lblAirline;
	private JTextField tfGender;
	private JTextField tfUserId;
	private JTextField tfAdhr;
	
	/**
	 * Launch the application.
	 */
	 void passDets() {
		EventQueue.invokeLater(new Runnable() {
			 public void run() {
				try {
					PassengerDetails window = new PassengerDetails();
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
	public PassengerDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPassengerDetails = new JLabel("Passenger Details");
		lblPassengerDetails.setBounds(215, 0, 154, 28);
		lblPassengerDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblPassengerDetails);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(69, 84, 66, 17);
		frame.getContentPane().add(lblFName);
		
		JLabel lblMInit = new JLabel("Middle Initial");
		lblMInit.setBounds(69, 125, 66, 14);
		frame.getContentPane().add(lblMInit);
		
		JLabel lblLName = new JLabel("Last Name");
		lblLName.setBounds(69, 160, 66, 14);
		frame.getContentPane().add(lblLName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(69, 185, 46, 14);
		frame.getContentPane().add(lblAge);
		
		tfFname = new JTextField();
		tfFname.setBounds(145, 82, 86, 20);
		frame.getContentPane().add(tfFname);
		tfFname.setColumns(10);
		
		tfMinit = new JTextField();
		tfMinit.setBounds(145, 122, 86, 20);
		frame.getContentPane().add(tfMinit);
		tfMinit.setColumns(10);
		
		tfLName = new JTextField();
		tfLName.setBounds(145, 157, 86, 20);
		frame.getContentPane().add(tfLName);
		tfLName.setColumns(10);
		
		tfAge = new JTextField();
		tfAge.setBounds(145, 182, 34, 20);
		frame.getContentPane().add(tfAge);
		tfAge.setColumns(10);
		
		tfGender = new JTextField();
		tfGender.setBounds(145, 218, 18, 20);
		frame.getContentPane().add(tfGender);
		tfGender.setColumns(10);
		
		tfAdhr = new JTextField();
		tfAdhr.setBounds(145, 255, 164, 20);
		frame.getContentPane().add(tfAdhr);
		tfAdhr.setColumns(10);
		
		Button btnPrcdPymt = new Button("Proceed To Payment");
		btnPrcdPymt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "12345");			
			        // step3 create the statement object			
			        Statement stmt = con.createStatement();			
			        // step4 execute query
			        int fare=4000;
			        int update=stmt.executeUpdate("Insert into passenger values("+Integer.parseInt(tfUserId.getText())+",'"+tfAdhr.getText()+"','"+tfFname.getText()+"','"+tfMinit.getText()+"','"+tfLName.getText()+"',"+Integer.parseInt(tfAge.getText())+",'"+tfGender.getText()+"',"+fare+")");
			        System.out.println("connected");	
			        System.out.println(update+"Row Inserted");
			        // step5 close the connection object			
			        con.close();			
			    } catch (SQLException ex) {
	
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
				
				Payment py = new Payment();
	        	py.pay();
	        	frame.setVisible(false);
				
				
			}
		});
		btnPrcdPymt.setBounds(246, 304, 177, 22);
		frame.getContentPane().add(btnPrcdPymt);
		
		Button btnBack = new Button("Back");
		btnBack.setBounds(0, 0, 70, 22);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAFlight bf = new BookAFlight();
				bf.BookFlight();
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnBack);
		
		JLabel lb1 = new JLabel("");
		lb1.setBounds(454, 57, 70, 14);
		frame.getContentPane().add(lb1);
		
				
		
		JLabel lblNewLabel = new JLabel("Gender(M/F)l");
		lblNewLabel.setBounds(69, 221, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setBounds(69, 57, 46, 14);
		frame.getContentPane().add(lblUserId);
		
		tfUserId = new JTextField();
		tfUserId.setBounds(145, 51, 86, 20);
		frame.getContentPane().add(tfUserId);
		tfUserId.setColumns(10);
		
		JLabel lblAadhaarNo = new JLabel("Aadhaar No.");
		lblAadhaarNo.setBounds(69, 258, 66, 14);
		frame.getContentPane().add(lblAadhaarNo);
		
		
	}
}
