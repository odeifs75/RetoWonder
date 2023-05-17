package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import clase.Usuario;
import clase.Cliente;
import modelo.Dao;
import modelo.DaoImplementacionBD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
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
	private JSeparator separator;

	/**
	 * Create the dialog.
	 * @param dao 
	 */
	public InicioSesion(Dao dao) {
		this.dao= dao;
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		setBounds(100, 100, 480, 487);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		getContentPane().setBackground(new Color(238, 83, 130));
		getContentPane().setLayout(null);
		{
			lblnomUsu = new JLabel("Nombre de Usuario");
			lblnomUsu.setBounds(140, 100, 200, 26);
			lblnomUsu.setForeground(new Color(255, 255, 255));
			lblnomUsu.setFont(new Font("Verdana", Font.BOLD, 17));
			getContentPane().add(lblnomUsu);
		}
		{
			textFieldnomUsu = new JTextField();
			textFieldnomUsu.setForeground(Color.WHITE);
			textFieldnomUsu.setBounds(140, 140, 136, 26);
			textFieldnomUsu.setFont(new Font("Verdana", Font.PLAIN, 17));
			textFieldnomUsu.setCaretColor(Color.WHITE);
			textFieldnomUsu.setBackground(new Color(238, 83, 130));
			textFieldnomUsu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			textFieldnomUsu.setColumns(10);
			getContentPane().add(textFieldnomUsu);
		}
		{
			lblcontra = new JLabel("Contrase\u00F1a");
			lblcontra.setBounds(140, 200, 146, 26);
			lblcontra.setForeground(new Color(255, 255, 255));
			lblcontra.setFont(new Font("Verdana", Font.BOLD, 17));
			getContentPane().add(lblcontra);
		}
		{
			lbltitulo = new JLabel("Inicio de Sesion");
			lbltitulo.setBounds(140, 11, 219, 38);
			lbltitulo.setForeground(new Color(255, 255, 255));
			lbltitulo.setFont(new Font("Verdana", Font.BOLD, 22));
			getContentPane().add(lbltitulo);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(325, 399, 129, 38);
			btnAceptar.setBackground(Color.WHITE);
			btnAceptar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnAceptar.addActionListener(this);
			getContentPane().add(btnAceptar);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(10, 399, 129, 38);
			btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnVolver.setBackground(Color.WHITE);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);
		}

		password = new JPasswordField();
		password.setForeground(Color.WHITE);
		password.setBounds(140, 240, 136, 26);
		password.setFont(new Font("Verdana", Font.PLAIN, 17));
		password.setBackground(new Color(238, 83, 130));
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		getContentPane().add(password);
		
		separator = new JSeparator();
		separator.setBounds(10, 51, 444, 2);
		getContentPane().add(separator);
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
						VCliente cli =new VCliente(dao, usu);
						cli.setVisible(true);
						this.dispose();
					}else{
						VAdministrador admin=new VAdministrador(dao);
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
