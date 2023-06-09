package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Cliente;
import clase.Usuario;
import modelo.Dao;
import modelo.DaoImplementacionBD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class Registro extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldnomUsu;
	private JTextField textFieldEmail;
	private JButton btnSiguiente;
	private JButton btnVolver;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblEdad;
	private JLabel lblGenero;
	private JComboBox comboGenero;
	private JSpinner spinner;
	private Dao dao;
	private JSeparator separator;

	/**
	 * Create the dialog.
	 */
	public Registro(Dao dao) {
		this.dao = dao;
		setBounds(100, 100, 441, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl = new JLabel("Nombre de usuario");
			lbl.setFont(new Font("Tahoma", Font.BOLD, 17));
			lbl.setForeground(new Color(255, 255, 255));
			lbl.setBounds(10, 54, 169, 38);
			contentPanel.add(lbl);
		}
		{
			textFieldnomUsu = new JTextField();
			textFieldnomUsu.setBounds(10, 93, 136, 26);
			contentPanel.add(textFieldnomUsu);
			textFieldnomUsu.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Email");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(227, 54, 65, 38);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setBounds(227, 93, 136, 26);
			contentPanel.add(textFieldEmail);
			textFieldEmail.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setBounds(10, 140, 136, 26);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Repetir Contrase\u00F1a");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(227, 140, 176, 26);
			contentPanel.add(lblNewLabel_3);
		}
		{
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(10, 341, 129, 38);
			btnSiguiente.addActionListener(this);
			contentPanel.add(btnSiguiente);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(286, 341, 129, 38);
			contentPanel.add(btnVolver);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Registro");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setBounds(152, 0, 129, 38);
			contentPanel.add(lblNewLabel_4);
		}

		passwordField = new JPasswordField();
		passwordField.setBounds(10, 177, 136, 26);
		contentPanel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(227, 177, 143, 26);
		contentPanel.add(passwordField_1);
		lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEdad.setBounds(227, 214, 51, 21);
		contentPanel.add(lblEdad);

		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenero.setBounds(10, 223, 76, 21);
		contentPanel.add(lblGenero);

		comboGenero = new JComboBox();
		comboGenero.setModel(new DefaultComboBoxModel(new String[] { "Mujer", "Hombre", "Otro" }));
		comboGenero.setBounds(10, 259, 183, 22);
		contentPanel.add(comboGenero);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(18, null, 100, 1));
		spinner.setBounds(227, 260, 76, 21);
		contentPanel.add(spinner);
		{
			separator = new JSeparator();
			separator.setBounds(10, 41, 405, 2);
			contentPanel.add(separator);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnSiguiente)) {
			nuevaCuenta();
		} else if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	private void volver() {
		// TODO Auto-generated method stub
		Inicio ini = new Inicio(null);
		ini.setVisible(true);
		this.dispose();
	}


	// Metodo para crear nueva cuenta
	public void nuevaCuenta() {
		DaoImplementacionBD bd = new DaoImplementacionBD();

		// VALIDAR QUE NO FALTA CAMPOS POR RELLENAR
		if (textFieldnomUsu.getText().equals("") || textFieldEmail.getText().equals("")
				|| passwordField.getText().equals("") || passwordField_1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Faltan campos por rellenar!");
		} else {
			// COmprobar si existe el usuario
			if (bd.existeUsuario(textFieldnomUsu.getText()) == 0) {
				// Verificar que es un email
				if (bd.esEmail(textFieldEmail.getText())) {
					
					Cliente cli = new Cliente();
					// Recoger los datos del usuario
					cli.setNomUsu(textFieldnomUsu.getText());
					cli.setEmail(textFieldEmail.getText());
					// Pasar contraseina a string
					cli.setContrasena(new String(passwordField.getPassword()));
					cli.setContrasena(new String(passwordField_1.getPassword()));
					
					cli.setEdad(spinner.getValue().toString());
					cli.setGenero(comboGenero.getSelectedItem().toString());
						
					
					bd.insertarUsuario(cli);
					
					RegistroR re = new RegistroR(dao, cli);
					re.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "ESTO NO ES UN EMAIL!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "EL USUARIO YA EXISTE!");
			}
		}
	}
}
