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
import clase.Relacion;
import modelo.Dao;

import java.awt.Color;

public class VerPerfil extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private List<Cliente> clientes;
	private List<Relacion> relaciones;
	private Dao dao;
	private JScrollPane scrollPane;
	/**
	 * Create the dialog.
	 */
	public VerPerfil(Dao dao) {
		this.dao=dao;
		clientes=new ArrayList<>();
		relaciones=new ArrayList<>();
		setBounds(100, 100, 738, 688);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		table = this.cargarTabla();
		scrollPane.setViewportView(table);
		
	
		scrollPane.setBounds(38, 39, 643, 310);
		contentPanel.add(scrollPane);
	}

	
	private JTable cargarTabla() {
		JTable tabla=new JTable();
		
		// Columnas
		String[] columnNames = { "Nombre", "Fecha Nacimiento", "Orientacion Sexual", "Zodiaco", "Que Buscas", "Descripcion", "Like" };
		String[] fila = new String[6];
		
		//Modelo de la Tabla
		DefaultTableModel model = new DefaultTableModel(null, columnNames);

		// data of the table
		clientes = dao.consultarPerfil();

		for (Cliente cli : clientes) {
			fila[0] = cli.getNomUsu();
			fila[1] = cli.getFechaNac().toString();
			for(Relacion rela: relaciones) {
				fila[0] = rela.getOrienSex();
				fila[1] = rela.getZodiaco();
				fila[2] = rela.getGustos();
				fila[3] = rela.getQueBuscas();
				fila[4] = rela.getDescripcion();
			}

			

			model.addRow(fila);
		}

		return new JTable(model);
	}
}
