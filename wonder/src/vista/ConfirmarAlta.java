package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Actividad;
import clase.Cliente;
import modelo.Dao;

import java.awt.Color;

public class ConfirmarAlta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private List<Cliente> clientes;
	private Dao dao;
	private JTable table;

	public ConfirmarAlta(Dao dao) {
		this.dao=dao;
		clientes=new ArrayList<>();
		setBounds(100, 100, 608, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		presentarTabla();
		
		
	}

	private void presentarTabla() {
		JScrollPane scroll = new JScrollPane();
		table = this.cargarTabla();
		scroll.setViewportView(table);
		
		contentPanel.add(scroll);
		scroll.setBounds(110, 90, 412, 100);
		
	}
	
	private JTable cargarTabla() {
		JTable tabla=new JTable();
		
		// Columnas
		String[] columnNames = { "Nombre", "email", "FechaNac" };
		String[] fila = new String[3];
		
		//Modelo de la Tabla
		DefaultTableModel model = new DefaultTableModel(null, columnNames);

		// data of the table
		clientes = dao.consultarClientes();

		for (Cliente cli : clientes) {

			fila[0] = cli.getNomUsu();
			fila[1] = cli.getFechaNac().toString();
			fila[2] = cli.getEmail();

			model.addRow(fila);
		}

		return new JTable(model);
	}

}