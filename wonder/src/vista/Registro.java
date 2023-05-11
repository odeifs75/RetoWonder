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
import clase.Ubicacion;
import clase.Usuario;
import modelo.Dao;
import modelo.DaoImplementacionBD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.MatteBorder;

public class Registro extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSiguiente;
	private JButton btnVolver;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblFechaNAc;
	private JLabel lblGenero;
	private JComboBox comboGenero;
	private Dao dao;
	private JSeparator separator;
	private JTextField textFieldfechaNac;
	private JLabel lblPais;
	private JLabel lblCiudad;
	private JLabel lblCodPostal;
	private JTextField textFieldPais;
	private JTextField textFieldCiudad;
	private JTextField textFieldCodigoPostal;
	private JLabel lbl;
	private JLabel lblNewLabel;
	private JLabel lblRegistro;
	private JTextField textFieldEmail;
	private JTextField textFieldnomUsu;

	/**
	 * Create the dialog.
	 */
	public Registro(Dao dao) {
		this.dao = dao;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbl = new JLabel("Nombre de usuario");
			lbl.setFont(new Font("Verdana", Font.BOLD, 17));
			lbl.setForeground(new Color(255, 255, 255));
			lbl.setBounds(10, 50, 193, 38);
			contentPanel.add(lbl);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Email");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(227, 50, 65, 38);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNewLabel = new JLabel("Contrase\u00F1a");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 140, 136, 26);
			contentPanel.add(lblNewLabel);
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
			btnSiguiente.setBounds(17, 508, 129, 38);
			btnSiguiente.addActionListener(this);
			contentPanel.add(btnSiguiente);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(298, 508, 129, 38);
			contentPanel.add(btnVolver);
		}
		{
			lblRegistro = new JLabel("Registro");
			lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblRegistro.setForeground(new Color(255, 255, 255));
			lblRegistro.setBounds(140, 0, 129, 38);
			contentPanel.add(lblRegistro);
		}

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(new Color(238, 83, 130));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 17));
		passwordField.setBounds(10, 177, 136, 26);
		contentPanel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		passwordField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordField_1.setBackground(new Color(238, 83, 130));
		passwordField_1.setBounds(227, 177, 143, 26);
		contentPanel.add(passwordField_1);
		lblFechaNAc = new JLabel("Fecha de nacimiento");
		lblFechaNAc.setForeground(Color.WHITE);
		lblFechaNAc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFechaNAc.setBounds(227, 223, 200, 21);
		contentPanel.add(lblFechaNAc);

		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenero.setBounds(10, 223, 76, 21);
		contentPanel.add(lblGenero);

		comboGenero = new JComboBox();
		comboGenero.setModel(new DefaultComboBoxModel(new String[] { "Mujer", "Hombre", "Otro" }));
		comboGenero.setSelectedIndex(-1);
		comboGenero.setBounds(10, 259, 183, 22);
		contentPanel.add(comboGenero);
		{
			separator = new JSeparator();
			separator.setBounds(10, 41, 494, 2);
			contentPanel.add(separator);
		}

		textFieldfechaNac = new JTextField();
		textFieldfechaNac.setForeground(Color.WHITE);
		textFieldfechaNac.setFont(new Font("Verdana", Font.PLAIN, 17));
		textFieldfechaNac.setBackground(new Color(238, 83, 130));
		textFieldfechaNac.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldfechaNac.setBounds(227, 260, 176, 26);
		contentPanel.add(textFieldfechaNac);
		textFieldfechaNac.setColumns(10);

		lblPais = new JLabel("Pais");
		lblPais.setForeground(Color.WHITE);
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPais.setBounds(10, 300, 85, 38);
		contentPanel.add(lblPais);

		lblCodPostal = new JLabel("Codigo Postal");
		lblCodPostal.setForeground(Color.WHITE);
		lblCodPostal.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCodPostal.setBounds(152, 403, 136, 26);
		contentPanel.add(lblCodPostal);

		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCiudad.setBounds(227, 309, 76, 21);
		contentPanel.add(lblCiudad);

		textFieldPais = new JTextField();
		textFieldPais.setForeground(Color.WHITE);
		textFieldPais.setFont(new Font("Verdana", Font.PLAIN, 17));
		textFieldPais.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldPais.setBackground(new Color(238, 83, 130));
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(10, 340, 169, 26);
		contentPanel.add(textFieldPais);

		textFieldCiudad = new JTextField();
		textFieldCiudad.setForeground(Color.WHITE);
		textFieldCiudad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldCiudad.setBackground(new Color(238, 83, 130));
		textFieldCiudad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(227, 340, 176, 26);
		contentPanel.add(textFieldCiudad);

		textFieldCodigoPostal = new JTextField();
		textFieldCodigoPostal.setForeground(Color.WHITE);
		textFieldCodigoPostal.setFont(new Font("Verdana", Font.PLAIN, 17));
		textFieldCodigoPostal.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldCodigoPostal.setBackground(new Color(238, 83, 130));
		textFieldCodigoPostal.setColumns(10);
		textFieldCodigoPostal.setBounds(152, 440, 136, 26);
		contentPanel.add(textFieldCodigoPostal);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Verdana", Font.PLAIN, 17));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldEmail.setBackground(new Color(238, 83, 130));
		textFieldEmail.setBounds(227, 90, 160, 26);
		contentPanel.add(textFieldEmail);
		
		textFieldnomUsu = new JTextField();
		textFieldnomUsu.setForeground(Color.WHITE);
		textFieldnomUsu.setFont(new Font("Verdana", Font.PLAIN, 17));
		textFieldnomUsu.setColumns(10);
		textFieldnomUsu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldnomUsu.setBackground(new Color(238, 83, 130));
		textFieldnomUsu.setBounds(10, 90, 160, 26);
		contentPanel.add(textFieldnomUsu);
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
		Cliente cli = new Cliente(); // Crear una instancia de Cliente
		Ubicacion ubi = new Ubicacion(); // Crear una instancia de Ubicacion
		// Verificar si la fecha de nacimiento corresponde a una persona menor de 18
		LocalDate fechaNac = LocalDate.parse(textFieldfechaNac.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate hoy = LocalDate.now();
		String contrasena1 = new String(passwordField.getPassword());
		String contrasena2 = new String(passwordField_1.getPassword());
		String codPostal = textFieldCodigoPostal.getText();

		if (codPostal.length() > 5) {
			JOptionPane.showMessageDialog(this, "El código postal no puede tener más de 5 dígitos");
			return;
		}

		int edad = Period.between(fechaNac, hoy).getYears();
		if (edad < 18) {
			// muestra el mensaje en caso de que la persona no sea mayor de 18
			JOptionPane.showMessageDialog(this, "Debe ser mayor de 18 anios para crear una cuenta");
			return;
		}

		DaoImplementacionBD bd = new DaoImplementacionBD();

		// VALIDAR QUE NO FALTA CAMPOS POR RELLENAR
		if (textFieldnomUsu.getText().equals("") || textFieldEmail.getText().equals("")
				|| passwordField.getText().equals("") || passwordField_1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Faltan campos por rellenar!");
		} else {
			// Comprobar si existe el usuario
			if (bd.existeUsuario(textFieldnomUsu.getText()) == 0) {
				// Verificar que es un email
				if (bd.esEmail(textFieldEmail.getText())) {

					// Recoger los datos del usuario
					cli.setNomUsu(textFieldnomUsu.getText());
					cli.setEmail(textFieldEmail.getText());
					// comprueba si las dos contraseñas son igual
					if (contrasena1.equals(contrasena2)) {
						cli.setContrasena(contrasena1);
					} else {
						JOptionPane.showMessageDialog(this, "Las contraseinas no coinciden");
						return;
					}

					cli.setFechaNac(fechaNac);
					cli.setGenero(comboGenero.getSelectedItem().toString());
					ubi.setPais(textFieldPais.getText());
					ubi.setCiudad(textFieldCiudad.getText());
					ubi.setCodPostal(Integer.parseInt(codPostal));

					bd.insertarUsuario(cli, ubi);

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
