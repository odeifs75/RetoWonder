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

public class VAdministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VAdministrador dialog = new VAdministrador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VAdministrador() {
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Modificar ");
			btnNewButton.setBounds(155, 154, 192, 32);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Alta");
			btnNewButton_1.setBounds(155, 99, 192, 32);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_1 = new JButton("Baja");
			btnNewButton_1.setBounds(155, 220, 192, 32);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_1 = new JButton("Cerrar Sesion");
			btnNewButton_1.setBounds(155, 384, 192, 32);
			contentPanel.add(btnNewButton_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Gestion");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(203, 22, 97, 46);
			contentPanel.add(lblNewLabel);
		}
	}

}
