package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class Cliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cliente dialog = new Cliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cliente() {
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(139, 84, 159, 30);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		btnNewButton = new JButton("New button");
		btnNewButton.setForeground(new Color(238, 83, 130));
		btnNewButton.setBackground(new Color(238, 83, 130));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\lupa-removebg-preview.png"));
		btnNewButton.setBounds(0, 395, 65, 53);
		btnNewButton.addActionListener(this);
		contentPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cerrar Sesion");
		btnNewButton_1.setBounds(31, 304, 113, 40);
		contentPanel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modificar Perfil");
		btnNewButton_2.setBounds(256, 304, 131, 40);
		contentPanel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\email-removebg-preview.png"));
		btnNewButton_3.setForeground(new Color(238, 83, 130));
		btnNewButton_3.setBackground(new Color(238, 83, 130));
		btnNewButton_3.setBounds(177, 395, 77, 53);
		contentPanel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\png-clipart-computer-icons-user-profile-circle-abstract-miscellaneous-rim-removebg-preview.png"));
		btnNewButton_4.setForeground(new Color(238, 83, 130));
		btnNewButton_4.setBackground(new Color(238, 83, 130));
		btnNewButton_4.setBounds(387, 383, 77, 65);
		contentPanel.add(btnNewButton_4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
