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

public class RegistroR extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSiguiente;
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

	/**
	 * Create the dialog.
	 */
	public RegistroR(Dao dao) {
		this.dao = dao;
		setBounds(100, 100, 819, 829);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(0, 741, 129, 38);
			btnSiguiente.addActionListener(this);
			contentPanel.add(btnSiguiente);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(313, 725, 129, 38);
			contentPanel.add(btnVolver);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Registro");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setBounds(329, 11, 246, 38);
			contentPanel.add(lblNewLabel_4);
		}

		lblOrientacionSexual = new JLabel("Orientacion Sexual");
		lblOrientacionSexual.setForeground(Color.WHITE);
		lblOrientacionSexual.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacionSexual.setBounds(44, 120, 183, 21);
		contentPanel.add(lblOrientacionSexual);

		comboOrientacion = new JComboBox();
		comboOrientacion.setModel(new DefaultComboBoxModel(
				new String[] { "Heterosexual", "Homosexual", "Transexual", "Pansexual", "Asexual", "Bisexual", "" }));
		comboOrientacion.setBounds(44, 167, 183, 22);
		contentPanel.add(comboOrientacion);
		lblZodiaco = new JLabel("Zodiaco");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBounds(79, 239, 86, 21);
		contentPanel.add(lblZodiaco);

		lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(306, 239, 76, 21);
		contentPanel.add(lblGustos);

		lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(275, 120, 183, 21);
		contentPanel.add(lblQueBuscas);

		comboQueBuscas = new JComboBox();
		comboQueBuscas.setBounds(275, 167, 183, 22);
		contentPanel.add(comboQueBuscas);

		comboGustos = new JComboBox();
		comboGustos.setBounds(275, 286, 183, 22);
		contentPanel.add(comboGustos);

		comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] { "Aries", "Tauro", "Geminis", "Cancer", "Leo",
				"Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis" }));
		comboZodiaco.setBounds(44, 286, 183, 22);
		contentPanel.add(comboZodiaco);

		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescripcion.setBounds(167, 350, 183, 21);
		contentPanel.add(lblDescripcion);

		textField = new JTextField();
		textField.setBounds(79, 415, 344, 150);
		contentPanel.add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnSiguiente)) {
			relacion();
		}
	}

	private void volver() {
		// TODO Auto-generated method stub
		Inicio ini = new Inicio(null);
		ini.setVisible(true);
		this.dispose();
	}



	// Metodo para crear nueva cuenta
	public void relacion() {
		DaoImplementacionBD bd = new DaoImplementacionBD();
			

				Relacion rela = new Relacion();
				// Recoger los datos de la relacion
				
				rela.setZodiaco(comboZodiaco.getSelectedItem().toString());
				rela.setGustos(comboGustos.getSelectedItem().toString());
				rela.setQueBuscas(comboQueBuscas.getSelectedItem().toString());
				rela.setDescripcion(textField.getText());
				
				
				

				bd.insertarRelacion(rela);

				InicioSesion re = new InicioSesion(null);
				re.setVisible(true);
				this.dispose();

				JOptionPane.showMessageDialog(this, "EL USUARIO SE HA REGISTRADO CORRECTAMENTE!");
			

		
	}
}
