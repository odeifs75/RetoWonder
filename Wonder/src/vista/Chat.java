package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Actividad;
import clase.Cliente;
import clase.Relacion;
import clase.Usuario;
import modelo.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JSeparator;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollBar;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Chat extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private JTable table;
	private List<Cliente> clientes;
	private JScrollPane scroll;
	private JLabel lblchat;
	private JButton btnLupa;
	private JButton btnCerrar;
	private JButton btnmodificar;
	private JButton btnActividad;
	private JButton btnUsu;
	private JButton btnCarta;
	private Usuario usu;

	/**
	 * Create the dialog.
	 * 
	 * @param padre
	 * @param modal
	 * @param dao
	 * @param usu
	 */
	public Chat( Dao dao, Usuario usu) {
		this.usu = usu;
		this.dao = dao;
		clientes = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 480, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("CHAT");
		lblNewLabel.setBounds(190, 11, 102, 38);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(238, 83, 130));
		contentPanel.add(lblNewLabel);

		btnLupa = new JButton("");
		btnLupa.setBorder(null);
		btnLupa.setForeground(new Color(238, 83, 130));
		btnLupa.setBackground(new Color(238, 83, 130));
		btnLupa.setIcon(new ImageIcon(".\\.\\imagenes\\lupa.png"));
		btnLupa.setBounds(10, 395, 65, 53);
		btnLupa.addActionListener(this);
		contentPanel.add(btnLupa);

		btnActividad = new JButton("");
		btnActividad.setBorder(null);
		btnActividad.setIcon(new ImageIcon(".\\.\\imagenes\\actividad.png"));
		btnActividad.setForeground(new Color(238, 83, 130));
		btnActividad.setBackground(new Color(238, 83, 130));
		btnActividad.setBounds(135, 395, 65, 53);
		btnActividad.addActionListener(this);
		contentPanel.add(btnActividad);

		btnUsu = new JButton("");
		btnUsu.setBorder(null);
		btnUsu.setIcon(new ImageIcon(".\\.\\imagenes\\usu.png"));
		btnUsu.setForeground(new Color(238, 83, 130));
		btnUsu.setBackground(new Color(238, 83, 130));
		btnUsu.setBounds(393, 395, 65, 53);
		btnUsu.addActionListener(this);
		contentPanel.add(btnUsu);

		btnCarta = new JButton("");
		btnCarta.setEnabled(false);
		btnCarta.setBorder(null);
		btnCarta.setIcon(new ImageIcon(".\\.\\imagenes\\carta.png"));
		btnCarta.setForeground(new Color(238, 83, 130));
		btnCarta.setBackground(new Color(238, 83, 130));
		btnCarta.setBounds(265, 395, 65, 53);
		btnCarta.addActionListener(this);
		contentPanel.add(btnCarta);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 444, 10);
		contentPanel.add(separator);

		JScrollPane scroll = new JScrollPane();
		table = this.cargarTabla();
		scroll.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chatear();
			}

		});
		scroll.setBounds(37, 77, 376, 310);
		contentPanel.add(scroll);

	}

	/**
	 * @return
	 */
	private JTable cargarTabla() {
		JTable tabla = new JTable();
		Relacion rel;

		// Columnas
		String[] columnNames = { "Nombre", "email", "edad" };
		String[] fila = new String[3];

		// Modelo de la Tabla
		DefaultTableModel model = new DefaultTableModel(null, columnNames);

		clientes = dao.match(usu.getNomUsu());

		for (Cliente cli : clientes) {
			fila[0] = cli.getNomUsu();
			fila[1] = cli.getEmail();
			fila[2] = cli.getGenero();

			
				model.addRow(fila);
			

		}

		return new JTable(model);
	}

	/**
	 * 
	 */
	private void chatear() {

		int row = table.getSelectedRow();
		String nomUsu = (String) table.getValueAt(row, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnActividad)) {
			actividades();
		}
		if (e.getSource().equals(btnUsu)) {
			perfil();
		} else if (e.getSource().equals(btnLupa)) {
			buscarPersonas();
		}

	}

	private void actividades() {
		// TODO Auto-generated method stub
		VActividad acti = new VActividad(dao, usu);
		acti.setVisible(true);
		this.dispose();
	}
	
	private void perfil() {
		VCliente vcli =new VCliente(dao, usu);
		vcli.setVisible(true);
		this.dispose();
		
	}
	
	private void buscarPersonas() {
		VerPerfil verPer=new VerPerfil(dao, usu);
		verPer.setVisible(true);
		this.dispose();
		
	}
	
	

}
