package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Relacion;

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
	private JLabel lblNombreDeUsuario;
	private JTextField textField;

	

	/**
	 * Create the dialog.
	 */
	public Modificar(Dao dao) {
		this.dao=dao;
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblOrientacionSexual = new JLabel("Orientacion Sexual");
		lblOrientacionSexual.setForeground(Color.WHITE);
		lblOrientacionSexual.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacionSexual.setBounds(140, 123, 183, 21);
		contentPanel.add(lblOrientacionSexual);
		
		comboOrientacion = new JComboBox();
		comboOrientacion.setModel(new DefaultComboBoxModel(new String[] {"Heterosexual", "Homosexual", "Transexual", "Pansexual", "Asexual", "Bisexual", ""}));
		comboOrientacion.setSelectedIndex(-1);
		comboOrientacion.setBounds(140, 155, 183, 22);
		contentPanel.add(comboOrientacion);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(25, 399, 129, 38);
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
		lblZodiaco.setBounds(140, 188, 86, 21);
		contentPanel.add(lblZodiaco);
		
		lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(140, 253, 76, 21);
		contentPanel.add(lblGustos);
		
		comboGustos = new JComboBox();
		comboGustos.setModel(new DefaultComboBoxModel(new String[] {"Videojuegos", "Fiesta", "Cine"}));
		comboGustos.setSelectedIndex(-1);
		comboGustos.setBounds(140, 285, 183, 22);
		contentPanel.add(comboGustos);
		
		lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);
		
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(140, 318, 183, 21);
		contentPanel.add(lblQueBuscas);
		
		comboQueBuscas = new JComboBox();
		comboQueBuscas.setBounds(140, 350, 183, 22);
		comboQueBuscas.setModel(new DefaultComboBoxModel(new String[] {"Una Relacion", "Amistad"}));
		comboQueBuscas.setSelectedIndex(-1);
		contentPanel.add(comboQueBuscas);
		
		JComboBox comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Geminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		comboZodiaco.setBounds(140, 220, 183, 22);
		comboZodiaco.setSelectedIndex(-1);
		contentPanel.add(comboZodiaco);
		
		btnAceptar = new JButton("Aceptar");
	
		btnAceptar.setBounds(294, 399, 129, 38);
		contentPanel.add(btnAceptar);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreDeUsuario.setBounds(140, 55, 183, 21);
		contentPanel.add(lblNombreDeUsuario);
		
		textField = new JTextField();
		textField.setBounds(140, 87, 183, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCancelar)) {
			btncancelar();
		}
	}
	private void btncancelar() {
		// TODO Auto-generated method stub
		ModificarPerfil modiPer=new ModificarPerfil(dao);
		modiPer.setVisible(true);
		this.dispose();
	}
	
	
	
	
}
