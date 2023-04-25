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
import javax.swing.JTextField;

public class InicioSesion extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InicioSesion dialog = new InicioSesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InicioSesion() {
		getContentPane().setBackground(new Color(238, 83, 130));
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre de Usuario");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(160, 121, 178, 47);
			getContentPane().add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(170, 186, 136, 26);
			getContentPane().add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(170, 283, 136, 26);
			getContentPane().add(textField_1);
		}
		{
			lblNewLabel_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_1.setBounds(160, 255, 146, 17);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Inicio de Sesion");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel_2.setBounds(130, 29, 219, 38);
			getContentPane().add(lblNewLabel_2);
		}
		{
			btnNewButton = new JButton("Aceptar");
			btnNewButton.setBounds(33, 399, 129, 38);
			getContentPane().add(btnNewButton);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(283, 399, 129, 38);
			getContentPane().add(btnVolver);
		}
		setBounds(100, 100, 480, 487);
	}

}
