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

import clase.Cliente;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class VCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNomUsu;
	private JButton btnLupa;
	private JButton btnCerrar;
	private JButton btnmodificar;
	private JButton btnActividad;
	private JButton btnUsu;
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
	private JButton btnMensaje;
	

	/**
	 * Create the dialog.
	 * @param dao 
	 * @param usu 
	 * 
	 */
	public VCliente(Dao dao, Usuario usu) {
		this.dao=dao;
		this.usu = usu;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 480, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			textNomUsu = new JTextField();
			textNomUsu.setHorizontalAlignment(SwingConstants.CENTER);
			textNomUsu.setEditable(false);
			textNomUsu.setBorder(null);
			textNomUsu.setFont(new Font("Verdana", Font.BOLD, 22));
			textNomUsu.setForeground(Color.WHITE);
			textNomUsu.setBackground(new Color(238, 83, 130));
			textNomUsu.setBounds(107, 0, 230, 40);
			contentPanel.add(textNomUsu);
			textNomUsu.setColumns(10);
		}
		
		btnLupa = new JButton("");
		btnLupa.setBorder(null);
		btnLupa.setForeground(new Color(238, 83, 130));
		btnLupa.setBackground(new Color(238, 83, 130));
		btnLupa.setIcon(new ImageIcon(".\\.\\imagenes\\lupa.png"));
		btnLupa.setBounds(10, 397, 65, 53);
		btnLupa.addActionListener(this);
		contentPanel.add(btnLupa);
		
		btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCerrar.setBounds(37, 334, 113, 40);
		btnCerrar.setBackground(Color.WHITE);
		btnCerrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);
		
		btnmodificar = new JButton("Modificar Perfil");
		btnmodificar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnmodificar.setBounds(293, 334, 131, 40);
		btnmodificar.setBackground(Color.WHITE);
		btnmodificar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnmodificar.addActionListener(this);
		contentPanel.add(btnmodificar);
		
		btnActividad = new JButton("");
		btnActividad.setBorder(null);
		btnActividad.setIcon(new ImageIcon(".\\.\\imagenes\\actividad.png"));
		btnActividad.setForeground(new Color(238, 83, 130));
		btnActividad.setBackground(new Color(238, 83, 130));
		btnActividad.setBounds(135, 397, 65, 53);
		btnActividad.addActionListener(this);
		contentPanel.add(btnActividad);
		
		btnUsu = new JButton("");
		btnUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUsu.setBorder(null);
		btnUsu.setEnabled(false);
		btnUsu.setIcon(new ImageIcon(".\\.\\imagenes\\usu.png"));
		btnUsu.setForeground(new Color(238, 83, 130));
		btnUsu.setBackground(new Color(238, 83, 130));
		btnUsu.setBounds(393, 397, 65, 53);
		contentPanel.add(btnUsu);
		
		lblOrientacio = new JLabel("Orientacion sexual:");
		lblOrientacio.setForeground(Color.WHITE);
		lblOrientacio.setBackground(Color.WHITE);
		lblOrientacio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrientacio.setBounds(20, 90, 170, 25);
		contentPanel.add(lblOrientacio);
		
		lblZodiaco = new JLabel("Zodiaco:");
		lblZodiaco.setForeground(Color.WHITE);
		lblZodiaco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZodiaco.setBackground(Color.WHITE);
		lblZodiaco.setBounds(20, 140, 80, 25);
		contentPanel.add(lblZodiaco);
		
		lblGustos = new JLabel("Gustos:");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGustos.setBackground(new Color(238, 83, 130));
		lblGustos.setBounds(20, 190, 80, 25);
		contentPanel.add(lblGustos);
		
		lblQueBuscas = new JLabel("Que buscas:");
		lblQueBuscas.setForeground(Color.WHITE);
		lblQueBuscas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQueBuscas.setBackground(Color.WHITE);
		lblQueBuscas.setBounds(20, 240, 113, 25);
		contentPanel.add(lblQueBuscas);
		
		textOrientacion = new JTextField();
		textOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textOrientacion.setEditable(false);
		textOrientacion.setForeground(Color.WHITE);
		textOrientacion.setBorder(null);
		textOrientacion.setBackground(new Color(238, 83, 130));
		textOrientacion.setColumns(10);
		textOrientacion.setBounds(193, 90, 200, 25);
		contentPanel.add(textOrientacion);
		
		textZodiaco = new JTextField();
		textZodiaco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textZodiaco.setEditable(false);
		textZodiaco.setBorder(null);
		textZodiaco.setForeground(Color.WHITE);
		textZodiaco.setBackground(new Color(238, 83, 130));
		textZodiaco.setColumns(10);
		textZodiaco.setBounds(107, 140, 200, 25);
		contentPanel.add(textZodiaco);
		
		textGustos = new JTextField();
		textGustos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textGustos.setEditable(false);
		textGustos.setBorder(null);
		textGustos.setForeground(Color.WHITE);
		textGustos.setBackground(new Color(238, 83, 130));
		textGustos.setColumns(10);
		textGustos.setBounds(107, 190, 200, 25);
		contentPanel.add(textGustos);
		
		textBusca = new JTextField();
		textBusca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textBusca.setEditable(false);
		textBusca.setBorder(null);
		textBusca.setForeground(Color.WHITE);
		textBusca.setBackground(new Color(238, 83, 130));
		textBusca.setColumns(10);
		textBusca.setBounds(135, 240, 200, 25);
		contentPanel.add(textBusca);
		
		lblDescrip = new JLabel("Descripcion:");
		lblDescrip.setForeground(Color.WHITE);
		lblDescrip.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescrip.setBackground(Color.WHITE);
		lblDescrip.setBounds(20, 290, 113, 25);
		contentPanel.add(lblDescrip);
		
		textDescrip = new JTextField();
		textDescrip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDescrip.setEditable(false);
		textDescrip.setBorder(null);
		textDescrip.setForeground(Color.WHITE);
		textDescrip.setBackground(new Color(238, 83, 130));
		textDescrip.setColumns(10);
		textDescrip.setBounds(135, 290, 319, 25);
		contentPanel.add(textDescrip);
		
		btnMensaje = new JButton("");
		btnMensaje.setBorder(null);
		btnMensaje.setIcon(new ImageIcon(".\\.\\imagenes\\carta.png"));
		btnMensaje.setForeground(new Color(238, 83, 130));
		btnMensaje.setBackground(new Color(238, 83, 130));
		btnMensaje.setBounds(265, 397, 65, 53);
		btnMensaje.addActionListener(this);
		contentPanel.add(btnMensaje);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 444, 2);
		contentPanel.add(separator);
		cargar();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnCerrar)) {
			cerrarSesion();
		}else if(e.getSource().equals(btnActividad)) {
			actividades();
		}else if (e.getSource().equals(btnLupa)) {
			buscarPersonas();
		}else if(e.getSource().equals(btnMensaje)) {
			chat();
		}else if (e.getSource().equals(btnmodificar)) {
			modificar();
		}
	}

	private void modificar() {
		DaoImplementacionBD bd=new DaoImplementacionBD();
		Relacion rela = bd.cargarDatos(usu.getNomUsu());
		ModificarCli modCli = new ModificarCli(dao, rela, usu);
		modCli.setVisible(true);
		this.dispose();
		
	}

	private void chat() {
		Chat chat=new Chat( dao, usu);
		chat.setVisible(true);
		this.dispose();
		
	}

	/**
	 * 
	 */
	private void buscarPersonas() {
		VerPerfil verPer=new VerPerfil(dao, usu);
		verPer.setVisible(true);
		this.dispose();
		
	}


	/**
	 * 
	 */
	private void actividades() {
		// TODO Auto-generated method stub
		VActividad acti=new VActividad(dao, usu);
		acti.setVisible(true);
		this.dispose();
	}

	/**
	 * 
	 */
	private void cerrarSesion() {
		// TODO Auto-generated method stub
		Inicio ini = new Inicio(dao);
		ini.setVisible(true);
		this.dispose();
	}

	/**
	 * 
	 */
	public void cargar() {
		
		DaoImplementacionBD bd = new DaoImplementacionBD();
		/*
		 * Al principio de esta clase llamamos a la clase Usuario en la cual hemos
		 * guardado los datos que han introducido en el login, le pasamos por parametro
		 * el metodo en el que conseguimos el nombre de usuario (En el
		 * DaoImplementaciones explico porque)
		 */
		// En el objeto rela le pasamos los datos del metodo
		Relacion rela =	bd.cargarDatos(usu.getNomUsu());
		// Cogemos los datos del DAOImplementaciones
		textNomUsu.setText(rela.getNomUsuCli());
		textOrientacion.setText(rela.getOrienSex());
		textZodiaco.setText(rela.getZodiaco());
		textGustos.setText(rela.getGustos());
		textBusca.setText(rela.getQueBuscas());
		textDescrip.setText(rela.getDescripcion());
		
	}
	}
