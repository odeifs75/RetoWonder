package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class Chat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	

	/**
	 * Create the dialog.
	 */
	public Chat() {
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(50, 77, 367, 225);
		contentPanel.add(table);
		
		JLabel lblNewLabel = new JLabel("CHAT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(238, 83, 130));
		lblNewLabel.setBounds(190, 11, 208, 38);
		contentPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 444, 10);
		contentPanel.add(separator);
	}
}
