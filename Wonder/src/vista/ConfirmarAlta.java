package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import clase.Relacion;
import clase.Usuario;
import modelo.Dao;

import java.awt.Color;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class ConfirmarAlta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private List<Cliente> clientes;
	private List<Relacion> relaciones;
	private Dao dao;
	private JTable table;

	/**
	 * @param padre
	 * @param modal
	 * @param dao
	 */
	public ConfirmarAlta(VAdministrador padre,  Dao dao) {
		this.dao = dao;
		clientes = new ArrayList<>();
		setBounds(100, 100, 608, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);

		presentarTabla();

	}

	/**
	 * 
	 */
	private void presentarTabla() {
		JScrollPane scroll = new JScrollPane();
		table = this.cargarTabla();
		scroll.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apto();
			}

		});
		contentPanel.setLayout(null);

		contentPanel.add(scroll);
		scroll.setBounds(38, 10, 515, 427);

	}

	/**
	 * 
	 */
	private void apto() {
		
		int row=table.getSelectedRow();
		String nomUsu=(String) table.getValueAt(row, 0);
	}

	/**
	 * @return
	 */
	private JTable cargarTabla() {
		JTable tabla = new JTable();
		Relacion rel;

		// Columnas
		String[] columnNames = { "Nombre", "email", "genero", "Fecha de nacimiento", "Orientacion sexual", "zodiaco",
				"gustos", "Que buscas", "Descripcion" };
		String[] fila = new String[9];

		// Modelo de la Tabla
		DefaultTableModel model = new DefaultTableModel(null, columnNames);

		// data of the table
		clientes = dao.consultarClientes();
		relaciones = dao.consultarRelaciones();

		for (Cliente cli : clientes) {

			fila[0] = cli.getNomUsu();
			fila[1] = cli.getEmail();
			fila[2] = cli.getGenero();
			fila[3] = cli.getFechaNac().toString();
			rel = obtenerRelacion(cli.getNomUsu());

			fila[5] = rel.getOrienSex();
			fila[6] = rel.getZodiaco();
			fila[7] = rel.getQueBuscas();
			fila[8] = rel.getDescripcion();

			model.addRow(fila);
		}

		return new JTable(model);
	}

	/**
	 * @param nomUsu
	 * @return
	 */
	private Relacion obtenerRelacion(String nomUsu) {

		for (Relacion rel : relaciones) {
			if (nomUsu.equalsIgnoreCase(rel.getNomUsuCli())) {
				return rel;
			}
		}
		return null;
	}

}
