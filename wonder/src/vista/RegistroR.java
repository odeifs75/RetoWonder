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
import clase.Relacion;
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

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class RegistroR extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnVolver;
	private JComboBox comboOrientacion;
	private JLabel lblOrientacionSexual;
	private JLabel lblZodiaco;
	private JComboBox comboZodiaco;
	private JLabel lblGustos;
	private JComboBox comboGustos;
	private JComboBox comboQueBuscas;
	private JLabel lblQueBuscas;
	private JLabel lblDescripcion;
	private JTextField textField;
	private Dao dao;
	private Usuario usu;

	/**
	 * Create the dialog.
	 */
	public RegistroR(Dao dao, Usuario usu) {
		this.dao = dao;
		this.usu=usu;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 475, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(167, 451, 129, 38);
			btnAceptar.addActionListener(this);
			contentPanel.add(btnAceptar);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Registro");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setBounds(178, 0, 125, 38);
			contentPanel.add(lblNewLabel_4);
		}

		lblOrientacionSexual = new JLabel("Orientacion Sexual");
		lblOrientacionSexual.setForeground(Color.WHITE);
		lblOrientacionSexual.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacionSexual.setBounds(10, 65, 183, 21);
		contentPanel.add(lblOrientacionSexual);

		comboOrientacion = new JComboBox();
		comboOrientacion.setModel(new DefaultComboBoxModel(new String[] {"Heterosexual", "Homosexual"}));
		comboOrientacion.setSelectedIndex(-1);
		comboOrientacion.setBounds(10, 97, 183, 22);
		contentPanel.add(comboOrientacion);
		lblZodiaco = new JLabel("Zodiaco");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBounds(10, 130, 86, 21);
		contentPanel.add(lblZodiaco);

		lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(255, 130, 76, 21);
		contentPanel.add(lblGustos);

		lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(255, 65, 183, 21);
		contentPanel.add(lblQueBuscas);

		comboQueBuscas = new JComboBox();
		comboQueBuscas.setModel(new DefaultComboBoxModel(new String[] {"Una Relacion", "Amistad"}));
		comboQueBuscas.setSelectedIndex(-1);
		comboQueBuscas.setBounds(255, 97, 183, 22);
		contentPanel.add(comboQueBuscas);

		comboGustos = new JComboBox();
		comboGustos.setModel(new DefaultComboBoxModel(new String[] {"Videojuegos", "Fiesta", "Cine"}));
		comboGustos.setSelectedIndex(-1);
		comboGustos.setBounds(255, 162, 183, 22);
		contentPanel.add(comboGustos);

		comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] { "Aries", "Tauro", "Geminis", "Cancer", "Leo",
				"Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis" }));
		comboZodiaco.setSelectedIndex(-1);
		comboZodiaco.setBounds(10, 162, 183, 22);
		contentPanel.add(comboZodiaco);

		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescripcion.setBounds(167, 206, 136, 21);
		contentPanel.add(lblDescripcion);

		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 17));
		textField.setBounds(55, 238, 344, 150);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 448, 2);
		contentPanel.add(separator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnAceptar)) {
			relacion();
		}
	}

	private void volver() {
		// TODO Auto-generated method stub
		InicioSesion iniSe = new InicioSesion(dao);
		iniSe.setVisible(true);
		this.dispose();
	}



	// Metodo para crear nueva cuenta
	public void relacion() {
		DaoImplementacionBD bd = new DaoImplementacionBD();
			
				
				Relacion rela = new Relacion();
				// Recoger los datos de la relacion
				rela.setZodiaco(comboZodiaco.getSelectedItem().toString());
				rela.setOrienSex(comboOrientacion.getSelectedItem().toString());
				rela.setGustos(comboGustos.getSelectedItem().toString());
				rela.setQueBuscas(comboQueBuscas.getSelectedItem().toString());
				rela.setDescripcion(textField.getText());
				rela.setNomUsuCli(usu.getNomUsu());
				bd.insertarRelacion(rela);
				InicioSesion re = new InicioSesion(dao);
				re.setVisible(true);
				this.dispose();

				JOptionPane.showMessageDialog(this, "EL USUARIO SE HA REGISTRADO CORRECTAMENTE!");
	}
}
