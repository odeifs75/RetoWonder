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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class VerActividad extends JDialog implements ActionListener {

	private JTable table;
	private List<Actividad> actividades;
	private Dao dao;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JButton btnNewButton;
	private final JTable table_1 = new JTable();

	/**
	 * @param padre
	 * @param modal
	 * @param dao
	 */
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
		setLocationRelativeTo(null);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(255, 474, 121, 43);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);

		JScrollPane scrollPane = new JScrollPane();
		table = this.cargarTabla();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apuntarse();
			}

			private void apuntarse() {
				int row = table.getSelectedRow();
				Actividad act = new Actividad();
				act.setNomActividad(table.getValueAt(row, 0).toString());
					
				dao.apuntarseActividad(act);

			}

		});
		scrollPane.setBounds(73, 42, 485, 310);
		contentPanel.add(scrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	/**
	 * 
	 */
	private void volver() {
		// TODO Auto-generated method stub
		VActividad vActi = new VActividad(dao, null);
		vActi.setVisible(true);
		this.dispose();
	}

	/**
	 * @return
	 */
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
			fila[1] = act.getFecha().toString();
			fila[2] = act.getDescripcion();
			
			
			model.addRow(fila);

		}
		return new JTable(model);
	}

}
