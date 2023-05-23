package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import clase.Usuario;
import modelo.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class VActividad extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblActividades;
	private JButton btncrear;
	private JButton btninscribir;
	private JButton btnLupa;
	private JButton btnActividad;
	private JButton btnCarta;
	private JButton btnUsu;
	private Dao dao;
	private Usuario usu;

	
	/**
	 * Create the dialog.
	 * @param dao 
	 * @param usu 
	 */
	public VActividad(Dao dao, Usuario usu) {
		this.dao=dao;
		this.usu=usu;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		getContentPane().setBackground(new Color(238, 83, 130));
		setBounds(100, 100, 480, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblActividades = new JLabel("Actividades");
		lblActividades.setForeground(Color.WHITE);
		lblActividades.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblActividades.setBounds(170, 11, 184, 26);
		
		getContentPane().add(lblActividades);
		
		btncrear = new JButton("Crear actividad");
		btncrear.setFont(new Font("Verdana", Font.PLAIN, 11));
		btncrear.setBounds(144, 114, 165, 42);
		btncrear.setBackground(Color.WHITE);
		btncrear.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btncrear.addActionListener(this);
		getContentPane().add(btncrear);
		

		
		btninscribir = new JButton("Inscribirse en una actividad");	
		btninscribir.setFont(new Font("Verdana", Font.PLAIN, 11));
		btninscribir.setBounds(144, 254, 165, 42);
		btninscribir.setBackground(Color.WHITE);
		btninscribir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btninscribir.addActionListener(this);
		getContentPane().add(btninscribir);
		
		btnLupa = new JButton("");
		btnLupa.setBorder(null);
		btnLupa.setBackground(new Color(238, 83, 130));
		btnLupa.setForeground(Color.WHITE);
		btnLupa.setIcon(new ImageIcon(".\\.\\imagenes\\lupa.png"));
		btnLupa.setBounds(10, 394, 65, 53);
		btnLupa.addActionListener(this);
		getContentPane().add(btnLupa);
		
		btnActividad = new JButton("");
		btnActividad.setEnabled(false);
		btnActividad.setBackground(new Color(238, 83, 130));
		btnActividad.setBorder(null);
		btnActividad.setIcon(new ImageIcon(".\\.\\imagenes\\actividad.png"));
		btnActividad.setBounds(135, 394, 65, 53);
		btnActividad.addActionListener(this);
		getContentPane().add(btnActividad);
		
		btnCarta = new JButton("");
		btnCarta.setBorder(null);
		btnCarta.setBackground(new Color(238, 83, 130));
		btnCarta.setIcon(new ImageIcon(".\\.\\imagenes\\carta.png"));
		btnCarta.setBounds(265, 394, 65, 53);
		btnCarta.addActionListener(this);
		getContentPane().add(btnCarta);
		
		btnUsu = new JButton("");
		btnUsu.setBorder(null);
		btnUsu.setIcon(new ImageIcon(".\\.\\imagenes\\usu.png"));
		btnUsu.setBackground(new Color(238, 83, 130));
		btnUsu.setBounds(393, 394, 65, 53);
		btnUsu.addActionListener(this);
		getContentPane().add(btnUsu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 445, 2);
		getContentPane().add(separator);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btncrear)) {
			crear();
		
		}else if(e.getSource().equals(btninscribir)){
			inscribir();
		}if(e.getSource().equals(btnUsu)) {
			perfil();
		}else if (e.getSource().equals(btnLupa)) {
			buscarPersonas();
		}else if(e.getSource().equals(btnCarta)) {
			chat();
		}
	}


	/**
	 * 
	 */
	private void inscribir() {
		// TODO Auto-generated method stub
		VerActividad verActi=new VerActividad(this, true, dao);
		verActi.setVisible(true);
		this.dispose();
	}
	
	private void perfil() {
		VCliente vcli =new VCliente(dao, usu);
		vcli.setVisible(true);
		this.dispose();
		
	}
	
	private void buscarPersonas() {
		VerPerfil verPer=new VerPerfil(dao, usu);
		verPer.setVisible(true);
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
	private void crear() {
		// TODO Auto-generated method stub
		CrearActividades crearActi=new CrearActividades(true,dao, usu);
		crearActi.setVisible(true);
		this.dispose();
	}
}
