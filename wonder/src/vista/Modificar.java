package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Modificar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JComboBox comboOrientacion;
	private JLabel lblOrientacionSexual;
	private JLabel lblNewLabel;
	private JButton btnAceptar;
	private Dao dao;
	private JComboBox comboGustos;
	private JComboBox comboQueBuscas;
	private JLabel lblGustos;
	private JLabel lblQueBuscas;
	private JLabel lblZodiaco;
	private JTextField textNomUsu;
	private Relacion rela;
	private JComboBox comboZodiaco;

	/**
	 * Create the dialog.
	 */
	public Modificar(Dao dao, Relacion rela) {
		this.rela = rela;
		this.dao = dao;
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblOrientacionSexual = new JLabel("Orientacion Sexual");
		lblOrientacionSexual.setForeground(Color.WHITE);
		lblOrientacionSexual.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacionSexual.setBounds(140, 98, 183, 21);
		contentPanel.add(lblOrientacionSexual);

		comboOrientacion = new JComboBox();
		comboOrientacion.setModel(new DefaultComboBoxModel(
				new String[] { "Heterosexual", "Homosexual", "Transexual", "Pansexual", "Asexual", "Bisexual", "" }));
		comboOrientacion.setBounds(140, 130, 183, 22);
		contentPanel.add(comboOrientacion);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(25, 399, 95, 43);
		contentPanel.add(btnCancelar);

		lblNewLabel = new JLabel("Modificar Perfil");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(161, 11, 129, 21);
		contentPanel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 43, 444, 1);
		contentPanel.add(separator);

		lblZodiaco = new JLabel("Zodiaco");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBounds(140, 163, 86, 21);
		contentPanel.add(lblZodiaco);

		lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);

		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(140, 228, 76, 21);
		contentPanel.add(lblGustos);

		comboGustos = new JComboBox();
		comboGustos.setModel(new DefaultComboBoxModel(new String[] { "Videojuegos", "Fiesta", "Cine" }));
		comboGustos.setBounds(140, 260, 183, 22);
		contentPanel.add(comboGustos);

		lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);

		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(140, 293, 183, 21);
		contentPanel.add(lblQueBuscas);

		comboQueBuscas = new JComboBox();
		comboQueBuscas.setBounds(140, 325, 183, 22);
		comboQueBuscas.setModel(new DefaultComboBoxModel(new String[] { "Una Relacion", "Amistad" }));

		contentPanel.add(comboQueBuscas);

		comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] { "Aries", "Tauro", "Geminis", "Cancer", "Leo",
				"Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis" }));
		comboZodiaco.setBounds(140, 195, 183, 22);
		contentPanel.add(comboZodiaco);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(347, 399, 95, 43);
		contentPanel.add(btnAceptar);

		textNomUsu = new JTextField();
		textNomUsu.setEditable(false);
		textNomUsu.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textNomUsu.setForeground(Color.WHITE);
		textNomUsu.setBackground(new Color(238, 83, 130));
		textNomUsu.setBorder(null);
		textNomUsu.setBounds(195, 55, 157, 32);
		contentPanel.add(textNomUsu);
		textNomUsu.setColumns(10);
		cargar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			aceptar();
		} else if (e.getSource().equals(btnCancelar)) {
			btncancelar();
		}
	}

	private void aceptar() {

		modificar();
	}

	private void btncancelar() {

		ModificarPerfil modiPer = new ModificarPerfil(dao);
		modiPer.setVisible(true);
		this.dispose();
	}

	public void cargar() {

		DaoImplementacionBD bd = new DaoImplementacionBD();

		textNomUsu.setText(rela.getNomUsuCli());

	}

	public void modificar() {
		DaoImplementacionBD bd = new DaoImplementacionBD();
		// Recoger los datos de la relacion
		rela.setZodiaco(comboZodiaco.getSelectedItem().toString());
		rela.setOrienSex(comboOrientacion.getSelectedItem().toString());
		rela.setGustos(comboGustos.getSelectedItem().toString());
		rela.setQueBuscas(comboQueBuscas.getSelectedItem().toString());
		bd.modificarRelacion(rela);
		ModificarPerfil md = new ModificarPerfil(dao);
		md.setVisible(true);
		this.dispose();

		JOptionPane.showMessageDialog(this, "EL USUARIO SE HA MODIFICADO CORRECTAMENTE!");
	}

}
