package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;

public class VCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNomUsu;
	private JButton btnNewButton;
	private JButton btnCerrar;
	private JButton btnmodificar;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblOrientacio;
	private JLabel lblZodiaco;
	private JLabel lblGustos;
	private JLabel lblQueBuscas;
	private JTextField textOrientacion;
	private JTextField textZodiaco;
	private JTextField textBusca;
	private Dao dao;
	private JTextField textGustos;
	private JLabel lblDescrip;
	private JTextField textDescrip;
	private JButton btnrefresh;
	private Usuario usu;
	

	/**
	 * Create the dialog.
	 * @param usu 
	 */
	public VCliente(Dao dao, Usuario usu) {
		this.dao=dao;
		this.usu = usu;
		setBounds(100, 100, 480, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textNomUsu = new JTextField();
			textNomUsu.setBounds(135, 28, 159, 30);
			contentPanel.add(textNomUsu);
			textNomUsu.setColumns(10);
		}
		
		btnNewButton = new JButton("New button");
		btnNewButton.setForeground(new Color(238, 83, 130));
		btnNewButton.setBackground(new Color(238, 83, 130));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\lupa-removebg-preview.png"));
		btnNewButton.setBounds(0, 481, 65, 53);
		btnNewButton.addActionListener(this);
		contentPanel.add(btnNewButton);
		
		btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.setBounds(59, 415, 113, 40);
		contentPanel.add(btnCerrar);
		
		btnmodificar = new JButton("Modificar Perfil");
		btnmodificar.setBounds(251, 415, 131, 40);
		
		contentPanel.add(btnmodificar);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\email-removebg-preview.png"));
		btnNewButton_3.setForeground(new Color(238, 83, 130));
		btnNewButton_3.setBackground(new Color(238, 83, 130));
		btnNewButton_3.setBounds(175, 481, 77, 53);
		contentPanel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\png-clipart-computer-icons-user-profile-circle-abstract-miscellaneous-rim-removebg-preview.png"));
		btnNewButton_4.setForeground(new Color(238, 83, 130));
		btnNewButton_4.setBackground(new Color(238, 83, 130));
		btnNewButton_4.setBounds(387, 469, 77, 65);
		contentPanel.add(btnNewButton_4);
		
		lblOrientacio = new JLabel("Orientacion sexual:");
		lblOrientacio.setForeground(Color.WHITE);
		lblOrientacio.setBackground(Color.WHITE);
		lblOrientacio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacio.setBounds(20, 95, 200, 30);
		contentPanel.add(lblOrientacio);
		
		lblZodiaco = new JLabel("Zodiaco:");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBackground(Color.WHITE);
		lblZodiaco.setBounds(20, 136, 136, 30);
		contentPanel.add(lblZodiaco);
		
		lblGustos = new JLabel("Gustos:");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBackground(Color.WHITE);
		lblGustos.setBounds(20, 182, 136, 30);
		contentPanel.add(lblGustos);
		
		lblQueBuscas = new JLabel("Que buscas:");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBackground(Color.WHITE);
		lblQueBuscas.setBounds(20, 234, 136, 30);
		contentPanel.add(lblQueBuscas);
		
		textOrientacion = new JTextField();
		textOrientacion.setColumns(10);
		textOrientacion.setBounds(193, 103, 200, 20);
		contentPanel.add(textOrientacion);
		
		textZodiaco = new JTextField();
		textZodiaco.setColumns(10);
		textZodiaco.setBounds(107, 144, 200, 20);
		contentPanel.add(textZodiaco);
		
		textGustos = new JTextField();
		textGustos.setColumns(10);
		textGustos.setBounds(107, 190, 200, 20);
		contentPanel.add(textGustos);
		
		textBusca = new JTextField();
		textBusca.setColumns(10);
		textBusca.setBounds(135, 242, 200, 20);
		contentPanel.add(textBusca);
		
		lblDescrip = new JLabel("Descripcion:");
		lblDescrip.setForeground(Color.WHITE);
		lblDescrip.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescrip.setBackground(Color.WHITE);
		lblDescrip.setBounds(20, 297, 136, 30);
		contentPanel.add(lblDescrip);
		
		textDescrip = new JTextField();
		textDescrip.setColumns(10);
		textDescrip.setBounds(166, 273, 200, 79);
		contentPanel.add(textDescrip);
		cargar();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnCerrar)) {
			cerrarSesion();
		}
	}

	private void cerrarSesion() {
		// TODO Auto-generated method stub
		Inicio ini=new Inicio(dao);
		ini.setVisible(true);
		this.dispose();
	}

	public void cargar() {
		
		DaoImplementacionBD bd = new DaoImplementacionBD();
		Relacion rela =	bd.cargarDatos(usu.getNomUsu());
		
		textNomUsu.setText(rela.getNomUsu());
		textOrientacion.setText(rela.getOrienSex());
		textZodiaco.setText(rela.getZodiaco());
		textGustos.setText(rela.getGustos());
		textBusca.setText(rela.getQueBuscas());
		textDescrip.setText(rela.getDescripcion());
		
	}
}
