import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void welcome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
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
	public WelcomePage() {
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
		
		JLabel lblWelc = new JLabel("Welcome!");
		lblWelc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblWelc.setBounds(151, 48, 83, 32);
		frame.getContentPane().add(lblWelc);
		
		JButton btnBook = new JButton("Book a flight");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BookAFlight bf = new BookAFlight();
				bf.BookFlight();
				frame.setVisible(false);
			}
		});
		btnBook.setBounds(120, 91, 141, 23);
		frame.getContentPane().add(btnBook);
		
		JButton btnWallet = new JButton("Wallet Status");
		btnWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wallet wp = new wallet();
	        	wp.myWal();
	        	frame.setVisible(false);
			}
		});
		btnWallet.setBounds(120, 125, 141, 23);
		frame.getContentPane().add(btnWallet);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Login bf = new Login();
				//bf.main();
				//frame.setVisible(false);
			}
		});
		btnLogOut.setBounds(151, 159, 89, 23);
		frame.getContentPane().add(btnLogOut);
	}
}
