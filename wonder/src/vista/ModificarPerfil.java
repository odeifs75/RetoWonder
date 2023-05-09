package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clase.Usuario;
import modelo.Dao;
import modelo.DaoImplementacionBD;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

public class ModificarPerfil extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnContinuar;
	private JLabel lblNombre;
	private Dao dao;
	private JComboBox comboBox;
	private List<Usuario> usuario;

	/**
	 * Create the dialog.
	 */
	public ModificarPerfil(Dao dao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(27, 397, 113, 40);
		contentPanel.add(btnCancelar);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(323, 397, 131, 40);
		contentPanel.add(btnContinuar);

		lblNombre = new JLabel("Introducir el usuario que deseas modificar");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setBounds(27, 119, 427, 46);
		contentPanel.add(lblNombre);

		comboBox = new JComboBox();
		comboBox.setBounds(152, 192, 141, 22);
		contentPanel.add(comboBox);
		
		List<String> listadoCli=dao.listarUsuCli();
		for(String cli: listadoCli) {
			comboBox.addItem(cli);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	


	// Boton de cerrar para volver a la venta anterior
	private void cerrar() {
		// TODO Auto-generated method stub
		VAdministrador vAdmin = new VAdministrador(dao);
		vAdmin.setVisible(true);
		this.dispose();
	}
}
