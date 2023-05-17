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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VAdministrador extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnBaja;
	private Dao dao;


	/**
	 * Create the dialog.
	 */
	public VAdministrador(Dao dao) {
		this.dao=dao;
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Modificar ");
			btnNewButton.setBounds(155, 154, 192, 32);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Alta");
			btnNewButton_1.setBounds(155, 99, 192, 32);
			contentPanel.add(btnNewButton_1);
		}
		{
			btnBaja = new JButton("Baja");
			btnBaja.setBounds(155, 220, 192, 32);
			btnBaja.addActionListener(this);
			contentPanel.add(btnBaja);
		}
		{
			JButton btnNewButton_1 = new JButton("Cerrar Sesion");
			btnNewButton_1.setBounds(155, 384, 192, 32);
			contentPanel.add(btnNewButton_1);
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
		}
	}


	private void baja() {
		// TODO Auto-generated method stub
		BajaUsuario bajaUsu=new BajaUsuario(dao);
		bajaUsu.setVisible(true);
		this.dispose();
	}

}
