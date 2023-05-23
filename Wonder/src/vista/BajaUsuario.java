package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Usuario;
import modelo.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.MatteBorder;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class BajaUsuario extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldBorrar;
	private JLabel lblborrar;
	private JButton btnCancelar;
	private JButton btnBorrar;
	private Dao dao;


	/**
	 * Create the frame.
	 * @param padre 
	 * @param modal 
	 * @param dao 
	 */
	public BajaUsuario(VAdministrador padre, boolean modal, Dao dao) {
		super(padre);
		this.setModal(modal);
		this.dao=dao;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 536, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 83, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblborrar = new JLabel("Introduce el usuario \r\nque deseas borrar");
		lblborrar.setForeground(Color.WHITE);
		lblborrar.setFont(new Font("Verdana", Font.BOLD, 17));
		lblborrar.setBounds(26, 100, 391, 26);
		contentPane.add(lblborrar);
		
		textFieldBorrar = new JTextField();
		textFieldBorrar.setForeground(Color.WHITE);
		textFieldBorrar.setBackground(new Color(238, 83, 130));
		textFieldBorrar.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		textFieldBorrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldBorrar.setColumns(10);
		textFieldBorrar.setBounds(99, 146, 221, 26);
		contentPane.add(textFieldBorrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCancelar.setBounds(10, 285, 129, 38);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnBorrar.setBounds(300, 285, 129, 38);
		btnBorrar.addActionListener(this);
		contentPane.add(btnBorrar);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnBorrar)) {
			borrarUsuario();
		}else if(e.getSource().equals(btnCancelar)) {
			cancelar();
		}
	}


	/**
	 * 
	 */
	private void cancelar() {
		VAdministrador vAdmin= new VAdministrador(dao);
		vAdmin.setVisible(true);
		this.dispose();
		
	}


	/**
	 * 
	 */
	private void borrarUsuario() {
		// TODO Auto-generated method stub
		String nombreUsuario = textFieldBorrar.getText();

	    int opcion = JOptionPane.showConfirmDialog(this, "�Est�s seguro de que deseas eliminar al usuario " + nombreUsuario + "?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);

	    if (opcion == JOptionPane.YES_OPTION) {
	        Usuario usu = new Usuario();
	        usu.setNomUsu(nombreUsuario);
	        dao.eliminarUsuario(usu);
	        JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
	    }
		
	}
}
