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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
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
	 * 
	 * @param modal
	 * @param dao
	 */
	public InicioSesion( Dao dao) {
		this.dao = dao;
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		setBounds(100, 100, 480, 500);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		getContentPane().setBackground(new Color(238, 83, 130));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblnomUsu = new JLabel("Nombre de Usuario");
		lblnomUsu.setBounds(140, 140, 200, 25);
		lblnomUsu.setForeground(new Color(255, 255, 255));
		lblnomUsu.setFont(new Font("Verdana", Font.BOLD, 17));
		getContentPane().add(lblnomUsu);

		textFieldnomUsu = new JTextField();
		textFieldnomUsu.setBounds(140, 170, 160, 25);
		textFieldnomUsu.setForeground(Color.WHITE);
		textFieldnomUsu.setFont(new Font("Verdana", Font.PLAIN, 17));
		textFieldnomUsu.setCaretColor(Color.WHITE);
		textFieldnomUsu.setBackground(new Color(238, 83, 130));
		textFieldnomUsu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldnomUsu.setColumns(10);
		getContentPane().add(textFieldnomUsu);

		lblcontra = new JLabel("Contrase\u00F1a");
		lblcontra.setBounds(140, 230, 146, 25);
		lblcontra.setForeground(new Color(255, 255, 255));
		lblcontra.setFont(new Font("Verdana", Font.BOLD, 17));
		getContentPane().add(lblcontra);

		lbltitulo = new JLabel("Inicio de Sesion");
		lbltitulo.setBounds(120, 0, 210, 40);
		lbltitulo.setForeground(new Color(255, 255, 255));
		lbltitulo.setFont(new Font("Verdana", Font.BOLD, 22));
		getContentPane().add(lbltitulo);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAceptar.setBounds(293, 396, 129, 38);
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnVolver.setBounds(37, 396, 129, 38);
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);

		password = new JPasswordField();
		password.setBounds(140, 260, 160, 25);
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Verdana", Font.PLAIN, 17));
		password.setBackground(new Color(238, 83, 130));
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		getContentPane().add(password);

		separator = new JSeparator();
		separator.setBounds(10, 50, 444, 2);
		getContentPane().add(separator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(btnVolver)) {
			volver();
		} else if (e.getSource().equals(btnAceptar)) {
			iniciar();
		}
	}

	// Boton aceptar
	/**
	 * 
	 */
	private void iniciar() {
		
		Usuario usu = new Usuario();
		// recoger nombre de usuario y contraseña
		usu.setNomUsu(textFieldnomUsu.getText());
		usu.setContrasena(new String(password.getPassword()));

		usu = dao.login(usu);

		// si falta algun campo vacio
		if (textFieldnomUsu.getText().equals("") || password.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Faltan campos por rellenar");
		} else {
			// comprobar si el usuario es correcto
			if (usu != null) {
				if (usu instanceof Cliente) {
					VCliente cli = new VCliente(dao, usu);
					cli.setVisible(true);
					this.dispose();
				} else {
					VAdministrador admin = new VAdministrador(dao);
					admin.setVisible(true);
					this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseina incorrecto ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/**
	 * 
	 */
	private void volver() {
		
		Inicio ini = new Inicio(dao);
		ini.setVisible(true);
		this.dispose();
	}
}
