package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Actividad;
import modelo.Dao;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerActividad extends JDialog implements ActionListener {

	private JTable table;
	private List<Actividad> actividades;
	private Dao dao;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JButton btnNewButton;

	public VerActividad(VActividad padre, boolean modal, Dao dao) {
		super(padre);
		this.setModal(modal);

		this.dao = dao;
		actividades = new ArrayList<>();

		getContentPane().setBackground(new Color(238, 83, 130));
		getContentPane().setLayout(null);
		setBounds(100, 100, 665, 567);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(255, 474, 121, 43);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);

//		presentarTabla();
		JScrollPane scroll = new JScrollPane();
//		table = this.cargarTabla();
		scroll.setViewportView(table);

		contentPanel.add(scroll);
		scroll.setBounds(110, 90, 412, 100);

	}

//	private void presentarTabla() {
//		//Construir la tabla
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	private void volver() {
		// TODO Auto-generated method stub
		VActividad vActi = new VActividad(dao, null);
		vActi.setVisible(true);
		this.dispose();
	}

	private JTable cargarTabla() {
		JTable tabla = new JTable();

		// Columnas
		String[] columnNames = { "Nombre", "Fecha", "Descripcion" };
		String[] fila = new String[3];

		// Modelo de la Tabla
		DefaultTableModel model = new DefaultTableModel(null, columnNames);

		// data of the table
		actividades = dao.consultarActividades();

		for (Actividad act : actividades) {

			fila[0] = act.getNomActividad();
			fila[1] = act.getFecha();
			fila[2] = act.getDescripcion();

			model.addRow(fila);
		}

		return new JTable(model);
	}

}
