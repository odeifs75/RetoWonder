package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import clase.Usuario;
import clase.Cliente;
import modelo.Dao;
import modelo.DaoImplementacionBD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InicioSesion extends JDialog implements ActionListener {
	private JTextField textFieldnomUsu;
	private JLabel lblcontra;
	private JPasswordField password;
	private JLabel lbltitulo;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JLabel lblnomUsu;
	private Dao dao;
	// Recorremos la informacion
	private static List<Usuario> datos = new ArrayList<Usuario>();

	/**
	 * Create the dialog.
	 * @param dao 
	 */
	public InicioSesion(Dao dao) {
		this.dao= dao;
		getContentPane().setBackground(new Color(238, 83, 130));
		getContentPane().setLayout(null);
		{
			lblnomUsu = new JLabel("Nombre de Usuario");
			lblnomUsu.setForeground(new Color(255, 255, 255));
			lblnomUsu.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblnomUsu.setBounds(141, 92, 178, 47);
			getContentPane().add(lblnomUsu);
		}
		{
			textFieldnomUsu = new JTextField();
			textFieldnomUsu.setColumns(10);
			textFieldnomUsu.setBounds(151, 139, 136, 26);
			getContentPane().add(textFieldnomUsu);
		}
		{
			lblcontra = new JLabel("Contrase\u00F1a");
			lblcontra.setForeground(new Color(255, 255, 255));
			lblcontra.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblcontra.setBounds(154, 199, 146, 17);
			getContentPane().add(lblcontra);
		}
		{
			lbltitulo = new JLabel("Inicio de Sesion");
			lbltitulo.setForeground(new Color(255, 255, 255));
			lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
			lbltitulo.setBounds(130, 29, 219, 38);
			getContentPane().add(lbltitulo);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(33, 399, 129, 38);
			btnAceptar.addActionListener(this);
			getContentPane().add(btnAceptar);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(283, 399, 129, 38);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);
		}

		password = new JPasswordField();
		password.setBounds(154, 243, 136, 26);
		getContentPane().add(password);
		setBounds(100, 100, 480, 487);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnVolver)) {
			volver();
		} else if (e.getSource().equals(btnAceptar)) {
			iniciar();
		}
	}

	//Boton aceptar
	private void iniciar() {
		// TODO Auto-generated method stub
		Usuario usu = new Usuario();
		Cliente clie=new Cliente();
		// recoger nombre de usuario y contraseña
		usu.setNomUsu(textFieldnomUsu.getText());
		usu.setContrasena(new String(password.getPassword()));
		
		usu = dao.login(usu);

		// si falta algun campo vacio
		if (textFieldnomUsu.getText().equals("") || password.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Faltan campos por rellenar");
		} else {
			// comprobar si el usuario es correcto
			if (usu != null ) {
					if(usu instanceof Cliente) {
						VCliente cli =new VCliente(dao);
						cli.setVisible(true);
						this.dispose();
					}else{
						VAdministrador admin=new VAdministrador();
						admin.setVisible(true);
						this.dispose();
					}
			}else {
				JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseina incorrecto ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void volver() {
		// TODO Auto-generated method stub
		Inicio ini = new Inicio(dao);
		ini.setVisible(true);
		this.dispose();
	}
}
