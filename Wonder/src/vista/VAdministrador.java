package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class VAdministrador extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnBaja;
	private Dao dao;
	private JButton btnModificar;
	private JButton btnAlta;
	private JButton btnCerrarSesion;


	/**
	 * Create the dialog.
	 * @param dao 
	 */
	public VAdministrador(Dao dao) {
		this.dao=dao;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			btnModificar = new JButton("Modificar ");
			btnModificar.setBounds(155, 154, 192, 32);
			btnModificar.addActionListener(this);
			contentPanel.add(btnModificar);
		}
		{
			btnAlta = new JButton("Alta");
			btnAlta.setBounds(155, 99, 192, 32);
			btnAlta.addActionListener(this);
			contentPanel.add(btnAlta);
		}
		{
			btnBaja = new JButton("Baja");
			btnBaja.setBounds(155, 220, 192, 32);
			btnBaja.addActionListener(this);
			contentPanel.add(btnBaja);
		}
		{
			btnCerrarSesion = new JButton("Cerrar Sesion");
			btnCerrarSesion.setBounds(155, 384, 192, 32);
			btnCerrarSesion.addActionListener(this);
			contentPanel.add(btnCerrarSesion);
		}
		{
			JLabel lblNewLabel = new JLabel("Gestion");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(203, 22, 97, 46);
			contentPanel.add(lblNewLabel);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnBaja)) {
			baja();
		}else if (e.getSource().equals(btnModificar)){
			modificar();
		}else if(e.getSource().equals(btnAlta)) {
			alta();
		}else if(e.getSource().equals(btnCerrarSesion)) {
			cerrarSesion();
		}
	}


	/**
	 * 
	 */
	private void cerrarSesion() {
		// TODO Auto-generated method stub
		InicioSesion iniSe=new InicioSesion(dao);
		iniSe.setVisible(true);
		this.dispose();
	}


	/**
	 * 
	 */
	private void alta() {
		// TODO Auto-generated method stub
		ConfirmarAlta conAl=new ConfirmarAlta(this,dao);
		conAl.setVisible(true);
		this.dispose();
	}


	/**
	 * 
	 */
	private void baja() {
		// TODO Auto-generated method stub
		BajaUsuario bajaUsu=new BajaUsuario(this,true,dao);
		bajaUsu.setVisible(true);
		this.dispose();
	}
	/**
	 * 
	 */
	private void modificar() {
		// TODO Auto-generated method stub
		ModificarPerfil modi=new ModificarPerfil(dao);
		modi.setVisible(true);
		this.dispose();
	}

}
