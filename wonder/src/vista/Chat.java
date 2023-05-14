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
import clase.Usuario;
import modelo.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JSeparator;

public class Chat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private JTable table;
	private List<Cliente> clientes;

	/**
	 * Create the dialog.
	 */
	public Chat(Dao dao) {
		clientes = new ArrayList<>();
		this.dao = dao;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 480, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHAT");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(238, 83, 130));
		lblNewLabel.setBounds(190, 11, 102, 38);
		contentPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 444, 10);
		contentPanel.add(separator);
		
		JScrollPane scroll = new JScrollPane();
		table = this.cargarTabla();
		scroll.setViewportView(table);
		
		
	}

	private JTable cargarTabla() {
		// TODO Auto-generated method stub
		JTable tabla = new JTable();
		// Columnas
		String[] columnNames= {"Nombre", "Fecha Nacimiento", "Email"};
		String[] fila=new String[3];
		
		// Modelo de la Tabla
				DefaultTableModel model = new DefaultTableModel(null, columnNames);

				// data of the table
				clientes= dao.consultarClientes();

				for (Cliente cli : clientes) {

					fila[0] = cli.getNomUsu();
					fila[1] = cli.getFechaNac().toString();
					fila[2] = cli.getEmail();

					model.addRow(fila);
				}
		return new JTable(model);
	}
	
	
}
