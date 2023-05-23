package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
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
public class VerPerfil extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private List<Cliente> clientes;
	private List<Relacion> relaciones;
	private Dao dao;
	private JScrollPane scrollPane;
	private Usuario usu;
	private JButton btnActividad;
	private JButton btnusu;
	private JButton btnlupa;
	private JButton btnmensaje;

	/**
	 * Create the dialog.
	 * @param dao 
	 * @param usu 
	 */
	public VerPerfil(Dao dao, Usuario usu) {
		this.usu = usu;
		this.dao = dao;
		clientes = new ArrayList<>();
		relaciones = new ArrayList<>();
		setBounds(100, 100, 625, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 590, 310);
		table = this.cargarTabla();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				like();
			}

		});
		contentPanel.setLayout(null);
		contentPanel.add(scrollPane);
		
		
		btnActividad = new JButton("");
		btnActividad.setBounds(175, 397, 65, 53);
		btnActividad.setBorder(null);
		btnActividad.setIcon(new ImageIcon(".\\.\\imagenes\\actividad.png"));
		btnActividad.setForeground(new Color(238, 83, 130));
		btnActividad.setBackground(new Color(238, 83, 130));
		btnActividad.addActionListener(this);
		contentPanel.add(btnActividad);
		
		btnusu = new JButton("");
		btnusu.setBounds(508, 397, 65, 53);
		btnusu.setBorder(null);
		btnusu.setIcon(new ImageIcon(".\\.\\imagenes\\usu.png"));
		btnusu.setForeground(new Color(238, 83, 130));
		btnusu.setBackground(new Color(238, 83, 130));
		btnusu.addActionListener(this);
		contentPanel.add(btnusu);
		
		btnlupa = new JButton("");
		btnlupa.setEnabled(false);
		btnlupa.setBounds(25, 397, 65, 53);
		btnlupa.setBorder(null);
		btnlupa.setForeground(new Color(238, 83, 130));
		btnlupa.setBackground(new Color(238, 83, 130));
		btnlupa.setIcon(new ImageIcon(".\\.\\imagenes\\lupa.png"));
		btnlupa.addActionListener(this);
		contentPanel.add(btnlupa);
		
		btnmensaje = new JButton("");
		btnmensaje.setBounds(351, 397, 65, 53);
		btnmensaje.setBorder(null);
		btnmensaje.setIcon(new ImageIcon(".\\.\\imagenes\\carta.png"));
		btnmensaje.setForeground(new Color(238, 83, 130));
		btnmensaje.setBackground(new Color(238, 83, 130));
		btnmensaje.addActionListener(this);
		contentPanel.add(btnmensaje);
		
	}

	/**
	 * 
	 */
	protected void like() {
		
		int row=table.getSelectedRow();
		String nomUsu=(String) table.getValueAt(row, 0);
		dao.crearQuiere(usu.getNomUsu(), nomUsu);

	}

	/**
	 * @return
	 */
	private JTable cargarTabla() {
		JTable tabla = new JTable();
		Cliente clie;
		Relacion rel, rela;

		// Columnas
		String[] columnNames = { "Nombre", "Fecha Nacimiento", "Orientacion Sexual", "Zodiaco", "Que Buscas",
				"Descripcion" };
		String[] fila = new String[6];

		clie = dao.cogerDatosCliente( usu.getNomUsu());
		rela = dao.cargarDatos(usu.getNomUsu());
		// Modelo de la Tabla
		DefaultTableModel model = new DefaultTableModel(null, columnNames);

		// data of the table
		clientes = dao.consultarClientes();
		relaciones = dao.consultarRelaciones();

		for (Cliente cli : clientes) {
			rel = new Relacion();

			fila[0] = cli.getNomUsu();
			fila[1] = cli.getFechaNac().toString();
			
			// Busco la Relación de este cliente
			rel = obtenerRelacion(cli.getNomUsu());

			fila[2] = rel.getOrienSex();
			fila[3] = rel.getZodiaco();
			fila[4] = rel.getQueBuscas();
			fila[5] = rel.getDescripcion();

			if (rela.getOrienSex().equalsIgnoreCase("Heterosexual")) {
				if (clie.getGenero().equalsIgnoreCase("hombre")) {

					if (cli.getGenero().equalsIgnoreCase("mujer")) {
						if (rel.getOrienSex().equalsIgnoreCase("Heterosexual")) {
							model.addRow(fila);
						}
					}
				} else {
					if (cli.getGenero().equalsIgnoreCase("hombre")) {
						if (rel.getOrienSex().equalsIgnoreCase("Heterosexual")) {
							model.addRow(fila);
						}
					}
				}
			} else {
				if (clie.getGenero().equalsIgnoreCase("hombre")) {
					if (cli.getGenero().equalsIgnoreCase("hombre")) {
						if (rel.getOrienSex().equalsIgnoreCase("Homosexual")) {
							model.addRow(fila);
						}
					}
				} else {

					if (cli.getGenero().equalsIgnoreCase("mujer")) {
						if (rel.getOrienSex().equalsIgnoreCase("Homosexual")) {
							model.addRow(fila);
						}
					}
				}
			}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnActividad)) {
			actividades();
		}else if(e.getSource().equals(btnmensaje)) {
			chat();
		}else if(e.getSource().equals(btnusu)){
			perfil();
		}
		
	}
	
	
	/**
	 * 
	 */
	private void perfil() {
		VCliente vcli =new VCliente(dao, usu);
		vcli.setVisible(true);
		this.dispose();
		
	}

	/**
	 * 
	 */
	private void actividades() {
		// TODO Auto-generated method stub
		VActividad acti=new VActividad(dao, usu);
		acti.setVisible(true);
		this.dispose();
	}
	
	private void chat() {
		Chat chat=new Chat( dao, usu);
		chat.setVisible(true);
		this.dispose();
		
	}
}
