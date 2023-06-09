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

import clase.Relacion;
import clase.Usuario;
import modelo.Dao;
import modelo.DaoImplementacionBD;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class ModificarPerfil extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnContinuar;
	private JLabel lblNombre;
	private Dao dao;
	private JComboBox comboNom;
	private List<String> listadoCli;

	/**
	 * Create the dialog.
	 * @param dao 
	 */
	public ModificarPerfil(Dao dao) {
	
		this.dao=dao;
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(27, 397, 113, 40);
		contentPanel.add(btnCancelar);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(323, 397, 131, 40);
		btnContinuar.addActionListener(this);
		contentPanel.add(btnContinuar);

		lblNombre = new JLabel("Introducir el usuario que deseas modificar");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setBounds(27, 119, 427, 46);
		contentPanel.add(lblNombre);

		comboNom = new JComboBox();
		comboNom.setBounds(152, 192, 141, 22);
		contentPanel.add(comboNom);
		
		List<String> listadoCli=dao.listarUsuCli();
		for(String cli: listadoCli) {
			comboNom.addItem(cli);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnContinuar)) {
			continuar();
		}else if(e.getSource().equals(btnCancelar)){
			cerrar();
		}
	}

	


	/**
	 * 
	 */
	private void continuar() {
		DaoImplementacionBD bd=new DaoImplementacionBD();
		Relacion rela = bd.cargarDatos(comboNom.getSelectedItem().toString());
		Modificar mod = new Modificar(dao, rela);
		mod.setVisible(true);
		this.dispose();
	}

	// Boton de cerrar para volver a la venta anterior
	/**
	 * 
	 */
	private void cerrar() {
		
		VAdministrador vAdmin = new VAdministrador(dao);
		vAdmin.setVisible(true);
		this.dispose();
	}
}
