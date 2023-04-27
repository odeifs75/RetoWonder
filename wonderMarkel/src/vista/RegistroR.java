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
	private JTextField textFieldcodrela;

	/**
	 * Create the dialog.
	 */
	public RegistroR(Dao dao, Usuario usu) {
		this.dao = dao;
		setBounds(100, 100, 475, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(10, 451, 129, 38);
			btnAceptar.addActionListener(this);
			contentPanel.add(btnAceptar);
		}
		{
			btnVolver = new JButton("Volver");
			
			btnVolver.setBounds(309, 451, 129, 38);
			contentPanel.add(btnVolver);
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
		lblOrientacionSexual.setBounds(10, 128, 183, 21);
		contentPanel.add(lblOrientacionSexual);

		comboOrientacion = new JComboBox();
		comboOrientacion.setModel(new DefaultComboBoxModel(new String[] { "Heterosexual", "Homosexual", "Transexual", "Pansexual", "Asexual", "Bisexual", "" }));
		comboOrientacion.setBounds(10, 160, 183, 22);
		contentPanel.add(comboOrientacion);
		lblZodiaco = new JLabel("Zodiaco");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBounds(10, 193, 86, 21);
		contentPanel.add(lblZodiaco);

		lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(255, 193, 76, 21);
		contentPanel.add(lblGustos);

		lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(255, 128, 183, 21);
		contentPanel.add(lblQueBuscas);

		comboQueBuscas = new JComboBox();
		comboQueBuscas.setModel(new DefaultComboBoxModel(new String[] {"Una Relacion", "Amistad"}));
		comboQueBuscas.setBounds(255, 160, 183, 22);
		contentPanel.add(comboQueBuscas);

		comboGustos = new JComboBox();
		comboGustos.setModel(new DefaultComboBoxModel(new String[] {"Videojuegos", "Fiesta", "Cine"}));
		comboGustos.setBounds(255, 225, 183, 22);
		contentPanel.add(comboGustos);

		comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] { "Aries", "Tauro", "Geminis", "Cancer", "Leo",
				"Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis" }));
		comboZodiaco.setBounds(10, 225, 183, 22);
		contentPanel.add(comboZodiaco);

		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescripcion.setBounds(167, 258, 136, 21);
		contentPanel.add(lblDescripcion);

		textField = new JTextField();
		textField.setBounds(56, 290, 344, 150);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 448, 2);
		contentPanel.add(separator);
		
		JLabel lblCodigoDe = new JLabel(" Codigo de relacion");
		lblCodigoDe.setForeground(Color.WHITE);
		lblCodigoDe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCodigoDe.setBounds(148, 60, 183, 21);
		contentPanel.add(lblCodigoDe);
		
		textFieldcodrela = new JTextField();
		textFieldcodrela.setBounds(148, 92, 160, 20);
		contentPanel.add(textFieldcodrela);
		textFieldcodrela.setColumns(10);
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
				rela.setCodRela(textFieldcodrela.getText());
				rela.setZodiaco(comboZodiaco.getSelectedItem().toString());
				rela.setOrienSex(comboOrientacion.getSelectedItem().toString());
				rela.setGustos(comboGustos.getSelectedItem().toString());
				rela.setQueBuscas(comboQueBuscas.getSelectedItem().toString());
				rela.setDescripcion(textField.getText());
				bd.insertarRelacion(rela);
				InicioSesion re = new InicioSesion(dao);
				re.setVisible(true);
				this.dispose();

				JOptionPane.showMessageDialog(this, "EL USUARIO SE HA REGISTRADO CORRECTAMENTE!");
	}
}
