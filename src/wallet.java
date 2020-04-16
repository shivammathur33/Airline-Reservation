import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wallet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public  void myWal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wallet frame = new wallet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public wallet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bal = new JLabel("Balance:");
		bal.setFont(new Font("Tahoma", Font.BOLD, 11));
		bal.setBounds(129, 83, 52, 14);
		contentPane.add(bal);
		
		JLabel lblbal = new JLabel("");
		lblbal.setBounds(191, 83, 46, 14);
		contentPane.add(lblbal);
		
		JLabel lblWalletDetails = new JLabel("WALLET DETAILS");
		lblWalletDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWalletDetails.setBounds(111, 11, 182, 14);
		contentPane.add(lblWalletDetails);
		int num;
		Login lg = new Login();
		try {
			num = Integer.parseInt(lg.textField.getText());
		}
		catch(Exception e) {
			System.out.print("Running");
			num = 18001;
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		        // step2 create the connection object			
		        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "12345");
		        Statement stmt = con.createStatement();			
		        // step4 execute query	
		        
		        String qry = "SELECT balance, user_id FROM wallet WHERE user_id=?";
		        PreparedStatement stmt1 = con.prepareStatement(qry);
		        stmt1.setInt(1, num);
		        ResultSet rs = stmt1.executeQuery();
		        
		        
		        while(rs.next())
		        lblbal.setText(Integer.toString(rs.getInt(1)));
		        
			}
			
			catch (SQLException ex) {
				
			      ex.printStackTrace();
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage wp = new WelcomePage();
	        	wp.welcome();
	        	
			}
		});
		btnBack.setBounds(148, 143, 89, 23);
		contentPane.add(btnBack);
	}

}
