package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.ZoneView;

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
import java.awt.Toolkit;

import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

public class VCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNomUsu;
	private JButton btnlupa;
	private JButton btnCerrar;
	private JButton btnmodificar;
	private JButton btnActividad;
	private JButton btnusu;
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
	private JButton btnmensaje;
	

	/**
	 * Create the dialog.
	 * @param usu 
	 */
	public VCliente(Dao dao, Usuario usu) {
		this.dao=dao;
		this.usu = usu;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 480, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textNomUsu = new JTextField();
			textNomUsu.setEditable(false);
			textNomUsu.setBorder(null);
			textNomUsu.setFont(new Font("Tahoma", Font.BOLD, 21));
			textNomUsu.setForeground(Color.WHITE);
			textNomUsu.setBackground(new Color(238, 83, 130));
			textNomUsu.setBounds(172, 29, 135, 30);
			contentPanel.add(textNomUsu);
			textNomUsu.setColumns(10);
		}
		
		btnlupa = new JButton("");
		btnlupa.setBorder(null);
		btnlupa.setForeground(new Color(238, 83, 130));
		btnlupa.setBackground(new Color(238, 83, 130));
		btnlupa.setIcon(new ImageIcon(".\\.\\imagenes\\lupa.png"));
		btnlupa.setBounds(0, 481, 65, 53);
		btnlupa.addActionListener(this);
		contentPanel.add(btnlupa);
		
		btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.setBounds(59, 415, 113, 40);
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);
		
		btnmodificar = new JButton("Modificar Perfil");
		btnmodificar.setBounds(251, 415, 131, 40);
		
		contentPanel.add(btnmodificar);
		
		btnActividad = new JButton("");
		btnActividad.setBorder(null);
		btnActividad.setIcon(new ImageIcon(".\\.\\imagenes\\actividad.png"));
		btnActividad.setForeground(new Color(238, 83, 130));
		btnActividad.setBackground(new Color(238, 83, 130));
		btnActividad.setBounds(107, 481, 65, 53);
		btnActividad.addActionListener(this);
		contentPanel.add(btnActividad);
		
		btnusu = new JButton("");
		btnusu.setBorder(null);
		btnusu.setEnabled(false);
		btnusu.setIcon(new ImageIcon(".\\.\\imagenes\\usu.png"));
		btnusu.setForeground(new Color(238, 83, 130));
		btnusu.setBackground(new Color(238, 83, 130));
		btnusu.setBounds(387, 469, 77, 65);
		contentPanel.add(btnusu);
		
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
		lblGustos.setBackground(new Color(238, 83, 130));
		lblGustos.setBounds(20, 182, 136, 30);
		contentPanel.add(lblGustos);
		
		lblQueBuscas = new JLabel("Que buscas:");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBackground(Color.WHITE);
		lblQueBuscas.setBounds(20, 234, 136, 30);
		contentPanel.add(lblQueBuscas);
		
		textOrientacion = new JTextField();
		textOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textOrientacion.setEditable(false);
		textOrientacion.setForeground(Color.WHITE);
		textOrientacion.setBorder(null);
		textOrientacion.setBackground(new Color(238, 83, 130));
		textOrientacion.setColumns(10);
		textOrientacion.setBounds(193, 103, 200, 20);
		contentPanel.add(textOrientacion);
		
		textZodiaco = new JTextField();
		textZodiaco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textZodiaco.setEditable(false);
		textZodiaco.setBorder(null);
		textZodiaco.setForeground(Color.WHITE);
		textZodiaco.setBackground(new Color(238, 83, 130));
		textZodiaco.setColumns(10);
		textZodiaco.setBounds(107, 144, 200, 20);
		contentPanel.add(textZodiaco);
		
		textGustos = new JTextField();
		textGustos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textGustos.setEditable(false);
		textGustos.setBorder(null);
		textGustos.setForeground(Color.WHITE);
		textGustos.setBackground(new Color(238, 83, 130));
		textGustos.setColumns(10);
		textGustos.setBounds(107, 190, 200, 20);
		contentPanel.add(textGustos);
		
		textBusca = new JTextField();
		textBusca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textBusca.setEditable(false);
		textBusca.setBorder(null);
		textBusca.setForeground(Color.WHITE);
		textBusca.setBackground(new Color(238, 83, 130));
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
		textDescrip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDescrip.setEditable(false);
		textDescrip.setBorder(null);
		textDescrip.setForeground(Color.WHITE);
		textDescrip.setBackground(new Color(238, 83, 130));
		textDescrip.setColumns(10);
		textDescrip.setBounds(135, 300, 319, 73);
		contentPanel.add(textDescrip);
		
		btnmensaje = new JButton("");
		btnmensaje.setBorder(null);
		btnmensaje.setIcon(new ImageIcon(".\\.\\imagenes\\carta.png"));
		btnmensaje.setForeground(new Color(238, 83, 130));
		btnmensaje.setBackground(new Color(238, 83, 130));
		btnmensaje.setBounds(251, 481, 77, 53);
		contentPanel.add(btnmensaje);
		cargar();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnCerrar)) {
			cerrarSesion();
		}else if(e.getSource().equals(btnActividad)) {
			actividades();
		}
	}

	private void actividades() {
		// TODO Auto-generated method stub
		VActividad acti=new VActividad(dao, usu);
		acti.setVisible(true);
		this.dispose();
	}

	private void cerrarSesion() {
		// TODO Auto-generated method stub
		
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
