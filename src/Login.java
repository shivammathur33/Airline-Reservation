import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	 public JTextField textField;
	private JTextField passwordField;
	public int num;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 283);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(135, 153, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(104, 90, 69, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setBounds(104, 115, 69, 14);
		frame.getContentPane().add(lblPwd);
		
		textField = new JTextField();
		textField.setBounds(186, 87, 136, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFlightBook = new JLabel("Flight Booking Portal ");
		lblFlightBook.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlightBook.setBounds(152, 23, 157, 32);
		frame.getContentPane().add(lblFlightBook);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 112, 134, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sp = new SignUp();
				sp.sign();
				frame.setVisible(false);
				num = Integer.parseInt(textField.getText());
			
			}
			
			
		});
		btnSignUp.setBounds(255, 153, 89, 23);
		frame.getContentPane().add(btnSignUp);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
					 	
						String name=textField.getText();
						String pass=passwordField.getText();
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "12345");			
				        // step3 create the statement object	
				        
				        String qry = "SELECT * FROM user_info where user_id =? and pwd=?";
				        PreparedStatement stmt = con.prepareStatement(qry);
				        stmt.setString(1, name);
				        stmt.setString(2, pass);
				        		
				        ResultSet rs = stmt.executeQuery();
				        if(rs.next())
				        {
				        	WelcomePage wp = new WelcomePage();
				        	wp.welcome();
				        	frame.setVisible(false);
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null, "Invalid username or password");
				        }
				        
				        System.out.println("connected");
				        
				        con.close();
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				
				
			}
		});
	}
}
