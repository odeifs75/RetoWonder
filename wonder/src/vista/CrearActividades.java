package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

import clase.Actividad;
import clase.Cliente;
import clase.Usuario;
import modelo.Dao;
import modelo.DaoImplementacionBD;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import javax.swing.JTextPane;

public class CrearActividades extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JTextField textFieldNombre;
	private JButton btnCrear;
	private JButton btnCancelar;
	private Dao dao;
	private JDateChooser dateChooser;
	private Usuario usu;
	private JTextPane textPane;

	

	/**
	 * Create the dialog.
	 */
	public CrearActividades(Dao dao, Usuario usu) {
		this.dao=dao;
		this.usu=usu;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		setBounds(100, 100, 435, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre de la actividad");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 21));
		lblNombre.setBounds(50, 22, 264, 22);
		contentPanel.add(lblNombre);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 21));
		lblFecha.setBounds(50, 117, 122, 22);
		contentPanel.add(lblFecha);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 21));
		lblDescripcion.setBounds(50, 208, 154, 32);
		contentPanel.add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.WHITE);
		textFieldNombre.setBackground(new Color(238, 83, 130));
		textFieldNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldNombre.setBounds(50, 65, 205, 22);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCancelar.setBounds(10, 469, 95, 43);
		btnCancelar.addActionListener(this);
		contentPanel.add(btnCancelar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCrear.setBounds(314, 469, 95, 43);
		btnCrear.addActionListener(this);
		contentPanel.add(btnCrear);
		
		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(238, 83, 130));
		dateChooser.setBounds(50, 152, 205, 32);
		contentPanel.add(dateChooser);
		
		textPane = new JTextPane();
		textPane.setBounds(50, 251, 332, 164);
		contentPanel.add(textPane);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCrear)) {
			crearActividad();
		}else if(e.getSource().equals(btnCancelar)) {
			volver();
		}
	}



	private void volver() {
		// TODO Auto-generated method stub
		VActividad vActi= new VActividad(dao, usu);
		vActi.setVisible(true);
		this.dispose();
	}



	private void crearActividad() {
		// TODO Auto-generated method stub
		DaoImplementacionBD bd=new DaoImplementacionBD();
		
		Actividad acti = new Actividad();
		if(textFieldNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Faltan campos por rellenar!");
		}else {
			acti.setFecha(dateChooser.getDate().toLocaleString());
			acti.setDescripcion(textPane.getText());
			acti.setNomUsuCli(usu.getNomUsu());
			bd.crearActividad(acti);
			
			JOptionPane.showMessageDialog(this, "La actividad ha sido creada correctamente!");
		}
		//acti.setNomActividad(textFieldNombre.getText());
		
	}
}
