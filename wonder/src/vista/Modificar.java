package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class Modificar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JComboBox comboOrientacion;
	private JLabel lblOrientacionSexual;
	private JLabel lblNewLabel;
	private JButton btnAceptar;

	

	/**
	 * Create the dialog.
	 */
	public Modificar() {
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblOrientacionSexual = new JLabel("Orientacion Sexual");
		lblOrientacionSexual.setForeground(Color.WHITE);
		lblOrientacionSexual.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacionSexual.setBounds(140, 55, 183, 21);
		contentPanel.add(lblOrientacionSexual);
		
		comboOrientacion = new JComboBox();
		comboOrientacion.setModel(new DefaultComboBoxModel(new String[] {"Heterosexual", "Homosexual", "Transexual", "Pansexual", "Asexual", "Bisexual", ""}));
		comboOrientacion.setBounds(140, 87, 183, 22);
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
		
		JLabel lblZodiaco = new JLabel("Zodiaco");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBounds(140, 120, 86, 21);
		contentPanel.add(lblZodiaco);
		
		JLabel lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBounds(140, 185, 76, 21);
		contentPanel.add(lblGustos);
		
		JComboBox comboGustos = new JComboBox();
		comboGustos.setBounds(140, 217, 183, 22);
		contentPanel.add(comboGustos);
		
		JLabel lblQueBuscas = new JLabel("Que buscas");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBounds(140, 250, 183, 21);
		contentPanel.add(lblQueBuscas);
		
		JComboBox comboQueBuscas = new JComboBox();
		comboQueBuscas.setBounds(140, 282, 183, 22);
		contentPanel.add(comboQueBuscas);
		
		JComboBox comboZodiaco = new JComboBox();
		comboZodiaco.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Geminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		comboZodiaco.setBounds(140, 152, 183, 22);
		contentPanel.add(comboZodiaco);
		
		btnAceptar = new JButton("Cancelar");
		btnAceptar.setBounds(294, 399, 129, 38);
		contentPanel.add(btnAceptar);
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
		ModificarPerfil modiPer=new ModificarPerfil();
		modiPer.setVisible(true);
		this.dispose();
	}
}
