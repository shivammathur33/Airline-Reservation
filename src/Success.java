import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Success {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void suc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Success window = new Success();
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
	public Success() {
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
		
		JLabel lblNewLabel = new JLabel("Booking Successful!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(134, 45, 177, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage wp = new WelcomePage();
	        	wp.welcome();
	        	frame.setVisible(false);
			}
			
		});
		btnHome.setBounds(155, 130, 89, 23);
		frame.getContentPane().add(btnHome);
	}
}
