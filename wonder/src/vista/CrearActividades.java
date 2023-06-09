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

public class CrearActividades extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JButton btnCrear;
	private JButton btnCancelar;
	private Dao dao;
	private JDateChooser dateChooser;
	private Usuario usu;

	

	/**
	 * Create the dialog.
	 */
	public CrearActividades(Dao dao, Usuario usu) {
		this.dao=dao;
		this.usu=usu;
		setBounds(100, 100, 514, 581);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 83, 130));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre de la actividad");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(140, 22, 242, 22);
		contentPanel.add(lblNombre);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setBounds(140, 117, 122, 22);
		contentPanel.add(lblFecha);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcion.setBounds(140, 211, 154, 22);
		contentPanel.add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(140, 55, 205, 32);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(89, 254, 328, 160);
		contentPanel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(33, 487, 95, 43);
		contentPanel.add(btnCancelar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(352, 487, 95, 43);
		btnCrear.addActionListener(this);
		contentPanel.add(btnCrear);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(140, 150, 205, 32);
		contentPanel.add(dateChooser);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCrear)) {
			crearActividad();
		}
	}



	private void crearActividad() {
		// TODO Auto-generated method stub
		DaoImplementacionBD bd=new DaoImplementacionBD();
		Actividad acti=new Actividad();
		
		acti.setNomActividad(textFieldNombre.getText());
		acti.setFecha(dateChooser.getDate().toLocaleString());
		acti.setDescripcion(textFieldDescripcion.getText());
		acti.setnomUsuCliCr(usu.getNomUsu());
		bd.crearActividad(acti);
		
		JOptionPane.showMessageDialog(this, "Se ha creado la actividad");
	}
}
