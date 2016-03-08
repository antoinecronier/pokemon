import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;


public class ApplicationSwing {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationSwing window = new ApplicationSwing();
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
	public ApplicationSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("New button");
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		frame.getContentPane().add(comboBox, BorderLayout.CENTER);
		
		JTextPane txtpnHezy = new JTextPane();
		txtpnHezy.setText("Hezy");
		frame.getContentPane().add(txtpnHezy, BorderLayout.EAST);
	}

}
