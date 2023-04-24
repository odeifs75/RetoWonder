package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class RegistroE extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JLabel lblZodiaco;
	private JComboBox comboZodiaco;
	private JLabel lblGustos;
	private JComboBox comboGustos;
	private JComboBox comboQueBuscas;
	private JLabel lblQueBuscas;
	private JLabel lblDescripcion;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public RegistroE() {
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblZodiaco = new JLabel("Zodiaco");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBounds(140, 11, 86, 21);
		contentPanel.add(lblZodiaco);
		
		lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(140, 76, 76, 21);
		contentPanel.add(lblGustos);
		
		lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(140, 141, 183, 21);
		contentPanel.add(lblQueBuscas);
		
		comboQueBuscas = new JComboBox();
		comboQueBuscas.setBounds(140, 173, 183, 22);
		contentPanel.add(comboQueBuscas);
		
		comboGustos = new JComboBox();
		comboGustos.setBounds(140, 108, 183, 22);
		contentPanel.add(comboGustos);
		
		comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Geminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		comboZodiaco.setBounds(140, 43, 183, 22);
		contentPanel.add(comboZodiaco);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(162, 399, 129, 38);
		contentPanel.add(btnAceptar);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescripcion.setBounds(140, 206, 183, 21);
		contentPanel.add(lblDescripcion);
		
		textField = new JTextField();
		textField.setBounds(75, 238, 344, 150);
		contentPanel.add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAceptar)) {
			aceptar();
		}
	}

	private void aceptar() {
		// TODO Auto-generated method stub
		InicioSesion iniSesi=new InicioSesion();
		iniSesi.setVisible(true);
		this.dispose();
	}
}
