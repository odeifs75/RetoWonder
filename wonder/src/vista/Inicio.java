package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import modelo.DaoImplementacionBD;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;

public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRegistro;
	private JButton btnIniciarSesion;
	private JLabel lblServicioCondici;
	private Dao dao;
	private JLabel lblMatch;
	/**
	 * Create the frame.
	 * @param dao2 
	 */
	public Inicio(Dao dao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\imagenes\\logo.png"));
		this.dao = dao;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 83, 130));
		contentPane.setForeground(new Color(247, 168, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Wonder");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 21));
		lblTitulo.setBounds(195, 30, 119, 26);
		contentPane.add(lblTitulo);
		
		JLabel lblSlogan = new JLabel("Todo empieza con un");
		lblSlogan.setForeground(Color.WHITE);
		lblSlogan.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblSlogan.setBounds(81, 94, 314, 74);
		contentPane.add(lblSlogan);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBorder(new CompoundBorder(new CompoundBorder(), null));
		btnRegistro.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRegistro.setBackground(Color.WHITE);
		btnRegistro.setBounds(161, 179, 119, 42);
		btnRegistro.addActionListener(this);
		contentPane.add(btnRegistro);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.setBounds(162, 266, 119, 42);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(new Color(238, 83, 130));
		chckbxNewCheckBox.setBounds(120, 399, 21, 21);
		contentPane.add(chckbxNewCheckBox);
		
		lblServicioCondici = new JLabel("Aceptar Servicios y condiciones");
		lblServicioCondici.setForeground(Color.WHITE);
		lblServicioCondici.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblServicioCondici.setBounds(151, 399, 244, 21);
		contentPane.add(lblServicioCondici);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\RetoFinal\\RetoWonder\\wonder\\imagenes\\wonder.png"));
		lblNewLabel.setBounds(161, 18, 44, 42);
		contentPane.add(lblNewLabel);
		
		lblMatch = new JLabel("Match");
		lblMatch.setForeground(new Color(255, 255, 255));
		lblMatch.setBackground(new Color(255, 255, 255));
		lblMatch.setFont(new Font("Verdana", Font.BOLD, 21));
		lblMatch.setBounds(304, 113, 77, 34);
		contentPane.add(lblMatch);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnIniciarSesion)) {
			iniciarSesion();
		}else if(e.getSource().equals(btnRegistro)) {
			registro();
		}
	}
	private void registro() {
		// TODO Auto-generated method stub
		Registro regis= new Registro(dao);
		regis.setVisible(true);
		this.dispose();
	}
	private void iniciarSesion() {
		// TODO Auto-generated method stub
		InicioSesion iniSesi= new InicioSesion(dao);
		iniSesi.setVisible(true);
		this.dispose();
	}
}
