package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Usuario;
import modelo.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class VActividad extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblActividades;
	private JButton btncrear;
	private JButton btninscribir;
	private JButton btnVolver;
	private JButton btnlupa;
	private JButton btnNewButton_1;
	private JButton btncarta;
	private JButton btnusu;
	private Dao dao;
	private Usuario usu;

	
	/**
	 * Create the dialog.
	 */
	public VActividad(Dao dao, Usuario usu) {
		this.dao=dao;
		getContentPane().setBackground(new Color(238, 83, 130));
		setBounds(100, 100, 487, 555);
		getContentPane().setLayout(null);
		
		lblActividades = new JLabel("Actividades");
		lblActividades.setForeground(Color.WHITE);
		lblActividades.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblActividades.setBounds(170, 11, 184, 26);
		
		getContentPane().add(lblActividades);
		
		btncrear = new JButton("Crear actividad");
		btncrear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btncrear.setBounds(153, 84, 163, 53);
		btncrear.addActionListener(this);
		getContentPane().add(btncrear);
		
		btninscribir = new JButton("Inscribirse en una actividad");
		btninscribir.setToolTipText("");
		btninscribir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btninscribir.setBounds(115, 193, 258, 53);
		getContentPane().add(btninscribir);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(153, 304, 163, 53);
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);
		
		btnlupa = new JButton("");
		btnlupa.setBackground(new Color(238, 83, 130));
		btnlupa.setForeground(Color.WHITE);
		btnlupa.setIcon(new ImageIcon("RetoWonder\\wonder\\imagenes\\lupa.png"));
		btnlupa.setBounds(10, 457, 72, 48);
		getContentPane().add(btnlupa);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(130, 482, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		btncarta = new JButton("");
		btncarta.setBackground(new Color(238, 83, 130));
		btncarta.setIcon(new ImageIcon("RetoWonder\\wonder\\imagenes\\carta.png"));
		btncarta.setBounds(276, 457, 62, 48);
		getContentPane().add(btncarta);
		
		btnusu = new JButton("");
		btnusu.setIcon(new ImageIcon("RetoWonder\\wonder\\imagenes\\usu.png"));
		btnusu.setBackground(new Color(238, 83, 130));
		btnusu.setBounds(389, 446, 72, 59);
		getContentPane().add(btnusu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 461, 2);
		getContentPane().add(separator);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btncrear)) {
			crear();
		}else if(e.getSource().equals(btnVolver)) {
			volver();
		}
	}


	private void volver() {
		// TODO Auto-generated method stub
		VCliente cli=new VCliente(dao, usu);
		cli.setVisible(true);
		this.dispose();
	}


	private void crear() {
		// TODO Auto-generated method stub
		CrearActividades crearActi=new CrearActividades(dao);
		crearActi.setVisible(true);
		this.dispose();
	}
}
