import java.awt.EventQueue;
import java.sql.*;
import java.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.ScrollPane;
import java.awt.List;
import java.awt.Scrollbar;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;

import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookAFlight {

	private JFrame frame;
	public JTextField tfDeptDate;
	public JTextField tfFrom;
	public JTextField tfTo;
	public JTable tableResults;
	public String d_time;
	public String a_time;
	public String f_no;
	public String air_line;
	public String seats_rem;
	public JLabel lblFlt;
	public JLabel lblAirline;
	public JLabel lblDeptTime;
	public JLabel lblArvlTime;
	public int row;
	

	/**
	 * Launch the application.
	 */
	public void BookFlight() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAFlight window = new BookAFlight();
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
	
	public BookAFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblDept = new JLabel("Departure Date (dd-MONTH-yy)");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDept.setBounds(130, 31, 165, 27);
		frame.getContentPane().add(lblDept);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(140, 54, 47, 30);
		frame.getContentPane().add(lblFrom);
		
		
		
		JLabel lblBookYourFlight = new JLabel("Book Your Flight");
		lblBookYourFlight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBookYourFlight.setBounds(222, -3, 140, 23);
		frame.getContentPane().add(lblBookYourFlight);
		
		JList list = new JList();
		list.setBounds(130, 83, 1, 1);
		frame.getContentPane().add(list);
		
		JList list_2 = new JList();
		list_2.setBounds(118, 128, 92, -17);
		frame.getContentPane().add(list_2);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(293, 62, 34, 14);
		frame.getContentPane().add(lblTo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage wp = new WelcomePage();
				wp.welcome();
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
		JButton btnShowFlts = new JButton("Show Flights");
		btnShowFlts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					String from=tfFrom.getText();
					String to=tfTo.getText();
					String DeptDate=tfDeptDate.getText();
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "12345");			
			        // step3 create the statement object				        
			       
			        String qry = " select dept_time,arvl_time,flight_no,Airline,seats_rem from flight natural join trip "
			        				+ "where origin=? and destn=? and ddate=? and status='Available'";
			        PreparedStatement stmt = con.prepareStatement(qry);
			        stmt.setString(1, from);
			        stmt.setString(2, to);
			        stmt.setString(3, DeptDate);
			        
			        ResultSet rs = stmt.executeQuery();
			        
			        
			        
			        System.out.println(d_time);
			        System.out.println(d_time);
			        
			        
			        tableResults.setModel(DbUtils.resultSetToTableModel(rs));
			        
			       
					 
				}catch (SQLException ex) {
					
			      ex.printStackTrace();
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
								
				
				
			}
		});
		btnShowFlts.setBounds(222, 95, 117, 23);
		frame.getContentPane().add(btnShowFlts);
		
		tfDeptDate = new JTextField();
		tfDeptDate.setBounds(293, 34, 140, 20);
		frame.getContentPane().add(tfDeptDate);
		tfDeptDate.setColumns(10);
		
		tfFrom = new JTextField();
		tfFrom.setBounds(168, 59, 117, 20);
		frame.getContentPane().add(tfFrom);
		tfFrom.setColumns(10);
		
		tfTo = new JTextField();
		tfTo.setBounds(315, 59, 118, 20);
		frame.getContentPane().add(tfTo);
		tfTo.setColumns(10);
		
		 lblFlt = new JLabel("n/a");
		lblFlt.setBounds(164, 235, 69, 14);
		frame.getContentPane().add(lblFlt);
		
		 lblAirline = new JLabel("n/a");
		lblAirline.setBounds(254, 235, 73, 14);
		frame.getContentPane().add(lblAirline);
		
		 lblDeptTime = new JLabel("n/a");
		lblDeptTime.setBounds(344, 235, 66, 14);
		frame.getContentPane().add(lblDeptTime);
		
		 lblArvlTime = new JLabel("n/a");
		lblArvlTime.setBounds(434, 235, 69, 14);
		frame.getContentPane().add(lblArvlTime);
		
		JLabel lblFare = new JLabel("n/a");
		lblFare.setBounds(541, 235, 46, 14);
		frame.getContentPane().add(lblFare);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		scrollPane.setBounds(52, 128, 547, 61);
		frame.getContentPane().add(scrollPane);
		
		tableResults = new JTable();
		tableResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				 row = tableResults.getSelectedRow();
				
				 d_time = (tableResults.getModel().getValueAt(row,0)).toString();
		         a_time = (tableResults.getModel().getValueAt(row,1)).toString();
		         f_no = (tableResults.getModel().getValueAt(row,2)).toString();
		         air_line = (tableResults.getModel().getValueAt(row,3)).toString();
		         seats_rem = (tableResults.getModel().getValueAt(row,4)).toString();
		        
		       
		        (lblDeptTime).setText(d_time);
		        (lblArvlTime).setText(a_time);
		        (lblFlt).setText(f_no);
		        (lblAirline).setText(air_line);
		        System.out.println("setText Done");
		        
		        
		       
	        	frame.setVisible(true);		        
		        
				
			}
		});
		scrollPane.setViewportView(tableResults);
		
		JButton btnProceed = new JButton("Confirm");
		btnProceed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PassengerDetails pd = new PassengerDetails();
	        	pd.passDets();
	        	frame.setVisible(true);
			}
		});
		btnProceed.setBounds(273, 278, 100, 42);
		frame.getContentPane().add(btnProceed);
		
		JLabel lblYourSelection = new JLabel("Your Selection:");
		lblYourSelection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYourSelection.setBounds(10, 235, 121, 14);
		frame.getContentPane().add(lblYourSelection);
		
		
		
		
	}
}
