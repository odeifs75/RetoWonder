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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class BajaUsuario extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldBorrar;
	private JLabel lblborrar;
	private JButton btnCancelar;
	private JButton btnBorrar;
	private Dao dao;


	/**
	 * Create the frame.
	 */
	public BajaUsuario(Dao dao) {
		setBounds(100, 100, 455, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 83, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblborrar = new JLabel("Introduce el usuario \r\nque deseas borrar");
		lblborrar.setForeground(Color.WHITE);
		lblborrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblborrar.setBounds(46, 92, 359, 26);
		contentPane.add(lblborrar);
		
		textFieldBorrar = new JTextField();
		textFieldBorrar.setColumns(10);
		textFieldBorrar.setBounds(99, 151, 221, 32);
		contentPane.add(textFieldBorrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 285, 99, 32);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(330, 285, 99, 32);
		btnBorrar.addActionListener(this);
		contentPane.add(btnBorrar);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnBorrar)) {
			borrarUsuario(dao);
			
		}
	}


	private void borrarUsuario(Dao dao) {
		// TODO Auto-generated method stub
		Usuario  usu =new Usuario();
		
		usu.setNomUsu(textFieldBorrar.getText());
		dao.eliminarUsuario(usu);
		
		JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
	}
}
