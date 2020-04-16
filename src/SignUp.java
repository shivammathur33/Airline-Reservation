import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField tfu;
	private JTextField tfp;
	private JTextField tfm;
	private JTextField tfe;
	private JTextField tffn;
	private JTextField tfminit;
	private JTextField tfln;

	/**
	 * Launch the application.
	 */
	public void sign() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblu = new JLabel("Username");
		lblu.setBounds(10, 44, 76, 14);
		contentPane.add(lblu);
		
		tfu = new JTextField();
		tfu.setBounds(96, 41, 86, 20);
		contentPane.add(tfu);
		tfu.setColumns(10);
		
		JLabel lblp = new JLabel("Password");
		lblp.setBounds(10, 69, 63, 14);
		contentPane.add(lblp);
		
		tfp = new JTextField();
		tfp.setBounds(96, 72, 86, 20);
		contentPane.add(tfp);
		tfp.setColumns(10);
		
		JLabel lblm = new JLabel("Mobile No.:");
		lblm.setBounds(208, 44, 84, 14);
		contentPane.add(lblm);
		
		tfm = new JTextField();
		tfm.setBounds(302, 41, 86, 20);
		contentPane.add(tfm);
		tfm.setColumns(10);
		
		JLabel lble = new JLabel("Email:");
		lble.setBounds(208, 72, 46, 14);
		contentPane.add(lble);
		
		tfe = new JTextField();
		tfe.setBounds(302, 66, 86, 20);
		contentPane.add(tfe);
		tfe.setColumns(10);
		
		JLabel lblfn = new JLabel("First Name:");
		lblfn.setBounds(96, 121, 86, 14);
		contentPane.add(lblfn);
		
		tffn = new JTextField();
		tffn.setBounds(182, 118, 86, 20);
		contentPane.add(tffn);
		tffn.setColumns(10);
		
		JLabel lblminit = new JLabel("Middle  initial");
		lblminit.setBounds(96, 146, 86, 14);
		contentPane.add(lblminit);
		
		tfminit = new JTextField();
		tfminit.setBounds(182, 143, 86, 20);
		contentPane.add(tfminit);
		tfminit.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(96, 171, 86, 14);
		contentPane.add(lblLastName);
		
		tfln = new JTextField();
		tfln.setBounds(182, 168, 86, 20);
		contentPane.add(tfln);
		tfln.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WelcomePage wp = new WelcomePage();
	        	wp.welcome();
	        	
				//Login bf = new Login();
				//bf.main("abc");
				//frame.setVisible(false);
			}
		});
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl ", "system", "12345");
			        Statement stmt = con.createStatement();
				int update=stmt.executeUpdate(
						"Insert into user_info values("+Integer.parseInt(tfu.getText())+
						",'"+tfp.getText()+
						"',"+Long.parseLong(tfm.getText())+
						",'"+tffn.getText()+
						"','"+tfminit.getText()+
						"','"+tfln.getText()+
						"','"+tfe.getText()+"')");
				}
				
				catch (SQLException ex) {
					
				      ex.printStackTrace();
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				
//				Login lg = new Login();
//				lg.sign();
//				frame.setVisible(false);
				
			}
		});
		btnSignUp.setBounds(165, 215, 89, 23);
		contentPane.add(btnSignUp);
	}
}
