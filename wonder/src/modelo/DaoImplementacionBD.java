package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.exceptions.RSAException;

import clase.Actividad;
import clase.Administrador;
import clase.Cliente;
import clase.Relacion;
import clase.Ubicacion;
import clase.Usuario;

public class DaoImplementacionBD implements Dao {

	private Connection con;
	private PreparedStatement stmt;

	// Estos atributos son los necesarios para recoger los valores del fichero de
	// configuracion
	private ResourceBundle configFichero;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	// Sentencias sql
	final String LOGIN = "select * from usuario where nomUsu=? and contraseina=?";
	final String COMPROBAR_ADMIN = "select * from administrador where nomUsuAd=?";
	final String COMPROBAR_CLIENTE = "select * from usuario where nomUsu=?";
	final String MODIFICAR_USUARIO = "update cliente set orienSex=?, zodiaco=?, gustos=?, queBuscas=? where nomUsu=?";
	final String INSERTAR_USUARIO = "insert into usuario (nomUsu, email, contraseina) values (?, ?, ?)";
	final String INSERTAR_CLIENTE = "insert into cliente (nomUsuCli, genero, fechaNac) values (?, ?, ?)";
	final String INSERTAR_RELACION = "insert into relacion (orienSex, zodiaco, gustos, queBuscas, descrip, nomUsuCli) values (?, ?, ?, ?, ?, ?)";
	final String INSERTAR_UBICACION = "insert into ubicacion (pais, ciudad, codPostal) values (?, ?, ?)";
	final String CARGAR_RELACION = "select * from relacion where codRela=?";
	final String ELIMINAR_USUARIO = "delete from usuario where nomUsu=?";
	final String PILLAR_NOM = "select codRela from relacion where NomUsuCli=?";
	final String SELECCIONAR_USUARIO = "select nomUsuCli from cliente";
	final String SELECCIONAR_RELACION = "select * from relacion where nomUsuCli=?";
	final String CREAR_ACTIVIDAD = "insert into actividad (nomActividad, descripcion, fecha, nomUsuCli) values (?, ?, ?, ?)";
	final String MODIFICAR_RELACION = "update relacion set orienSex=?, zodiaco=?, gustos=?, queBuscas=? where nomUsuCli=?";
	final String SELECCIONAR_ACTIVIDAD = " select * from actividad";
	final String SELECCIONAR_CLIENTE = "select fechaNac from cliente";
	final String SELECCIONAR_RELACION2 = "select * from relacion";
	final String SELECCIONAR_CLIENTES="select * from cliente"; 

	public DaoImplementacionBD() {
		// TODO Auto-generated constructor stub
		this.configFichero = ResourceBundle.getBundle("modelo.config");
		this.driverBD = this.configFichero.getString("Driver");
		this.urlBD = this.configFichero.getString("Conn");
		this.userBD = this.configFichero.getString("DBUser");
		this.passwordBD = this.configFichero.getString("DBPass");
	}

	// Abrimos la conexion
	public void openConnection() {
		try {
			con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha abierto la base de datos");
			e.printStackTrace();
		}
	}

//cerramos la conexion
	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	// Metodo para saber si existe el usuario
	@Override
	public int existeUsuario(String usuario) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		String registrar = "select count(nomUsu) from usuario where nomUsu=?";
		this.openConnection();

		try {
			stmt = con.prepareStatement(registrar);
			stmt.setString(1, usuario);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}

	// metodo para loguearse
	@Override
	public Usuario login(Usuario usu) {
		ResultSet rs;
		Usuario usuario = null;
		String email, contrasena;

		this.openConnection();

		try {
			stmt = con.prepareStatement(LOGIN);
			stmt.setString(1, usu.getNomUsu());
			stmt.setString(2, usu.getContrasena());
			rs = stmt.executeQuery();

			if (rs.next()) {
				// recogemos los datos del usuario
				email = rs.getString(2);
				contrasena = rs.getString(3);

				// Comprobar si es admin o Cliente
				stmt = con.prepareStatement(COMPROBAR_ADMIN);
				stmt.setString(1, usu.getNomUsu());
				rs = stmt.executeQuery();
				if (rs.next()) {
					usuario = new Administrador();
					usuario.setNomUsu(rs.getString(1));
					usuario.setEmail(email);
					usuario.setContrasena(contrasena);
				} else {
					stmt = con.prepareStatement(COMPROBAR_CLIENTE);
					stmt.setString(1, usu.getNomUsu());
					rs = stmt.executeQuery();
					if (rs.next()) {
						usuario = new Cliente();
						usuario.setNomUsu(rs.getString(1));
						usuario.setEmail(email);
						usuario.setContrasena(contrasena);
					}
				}
			}
		} catch (SQLException e) {
			Logger.getLogger(DaoImplementacionBD.class.getName()).log(Level.SEVERE, null, e);
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	// Metodo para insertar un nuevo registro en la base de datos utilizando un
	@Override
	public void insertarUsuario(Cliente cli, Ubicacion ubi) {

		this.openConnection();
		int rs;
		try {

			stmt = con.prepareStatement(INSERTAR_USUARIO); // Cargamos el insert de usuario con el stmt
			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, cli.getNomUsu());
			stmt.setString(2, cli.getEmail());
			stmt.setString(3, cli.getContrasena());
			rs = stmt.executeUpdate();

			stmt = con.prepareStatement(INSERTAR_CLIENTE);
			stmt.setString(1, cli.getNomUsu());
			stmt.setString(2, cli.getGenero());
			stmt.setDate(3, Date.valueOf(cli.getFechaNac()));
			rs = stmt.executeUpdate();

			stmt = con.prepareStatement(INSERTAR_UBICACION);
			stmt.setString(1, ubi.getPais());
			stmt.setString(2, ubi.getCiudad());
			stmt.setInt(3, ubi.getCodPostal());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertarRelacion(Relacion rela) {
		this.openConnection();
		int rs;
		try {

			stmt = con.prepareStatement(INSERTAR_RELACION);

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, rela.getOrienSex());
			stmt.setString(2, rela.getZodiaco());
			stmt.setString(3, rela.getGustos());
			stmt.setString(4, rela.getQueBuscas());
			stmt.setString(5, rela.getDescripcion());
			stmt.setString(6, rela.getNomUsuCli());
			rs = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// METODO PARA VERIFICAR LOS PATRONES DE UN EMAIL
	/**
	 * @param email verifica que el email sigue el patron de un email convencional
	 * @return
	 */
	@Override
	public boolean esEmail(String email) {
		// Patr�n para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	@Override
	public Relacion cargarDatos(String nombreUsu) {

		Relacion rela = new Relacion();

		this.openConnection();
		try {
			stmt = con.prepareStatement(PILLAR_NOM);
			stmt.setString(1, nombreUsu);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rela.setCodRela(rs.getInt("codRela"));

			}
			stmt = con.prepareStatement(CARGAR_RELACION);
			stmt.setInt(1, rela.getCodRela());
			rs = stmt.executeQuery();

			if (rs.next()) {

				rela.setNomUsuCli(rs.getString("nomUsuCli"));
				rela.setOrienSex(rs.getString("orienSex"));
				rela.setZodiaco(rs.getString("zodiaco"));
				rela.setGustos(rs.getString("gustos"));
				rela.setQueBuscas(rs.getString("queBuscas"));
				rela.setDescripcion(rs.getString("descrip"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rela;

	}

	@Override
	public void eliminarUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {
			stmt = con.prepareStatement(ELIMINAR_USUARIO);
			stmt.setString(1, usu.getNomUsu());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/* metodo para crear la actividad */
	@Override
	public void crearActividad(Actividad acti) {
		// TODO Auto-generated method stub
		this.openConnection();
		try {
			/* cogemos los datos de la bases de datos */
			stmt = con.prepareStatement(CREAR_ACTIVIDAD);
			stmt.setString(1, acti.getNomActividad());
			stmt.setString(2, acti.getDescripcion());
			stmt.setString(3, acti.getFecha());
			stmt.setString(4, acti.getNomUsuCli());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<String> listarUsuCli() {
		List<String> listadoCliente = new ArrayList<>();
		String usuCli;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SELECCIONAR_USUARIO);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				usuCli = rs.getString(1);
				listadoCliente.add(usuCli);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listadoCliente;
	}

	@Override
	public void modificarRelacion(Relacion rela) {
		// TODO Auto-generated method stub
		this.openConnection();
		int rs;
		try {

			stmt = con.prepareStatement(MODIFICAR_RELACION);

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, rela.getOrienSex());
			stmt.setString(2, rela.getZodiaco());
			stmt.setString(3, rela.getGustos());
			stmt.setString(4, rela.getQueBuscas());
			stmt.setString(5, rela.getNomUsuCli());
			rs = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Actividad> consultarActividades() {
		List<Actividad> actividades = new ArrayList<>();

		Actividad actividad = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECCIONAR_ACTIVIDAD);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				actividad = new Actividad();

				actividad.setCodActividad(rs.getInt(1));
				actividad.setNomActividad(rs.getString(2));
				actividad.setFecha(rs.getString(3));
				actividad.setDescripcion(rs.getString(4));
				actividades.add(actividad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actividades;
	}

//	@Override
//	public List<Cliente> consultarPerfil() {
//		// TODO Auto-generated method stub
//		List<Cliente> clientes = new ArrayList<>();
//
//		Cliente cliente;
//		
//
//		ResultSet rs;	
//		this.openConnection();
//		try {
//			stmt = con.prepareStatement(SELECCIONAR_CLIENTE);
//			 rs = stmt.executeQuery();
//			while (rs.next()) {
//				cliente = new Cliente();
//				cliente.setNomUsu(rs.getString(1));
//				cliente.setEmail(rs.getString(2));
//				cliente.setFechaNac(rs.getDate(3).toLocalDate());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}
//		
//		return null;
//	}
	
	
	@Override
	public List<Cliente> consultarClientes() {
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SELECCIONAR_CLIENTES);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				
				cliente.setNomUsu(rs.getString(1));				
				cliente.setFechaNac(rs.getDate(3).toLocalDate());
				cliente.setEmail(rs.getString(2));
				clientes.add(cliente);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	public List<Relacion> consultarRelaciones() {
		List<Relacion> relaciones = new ArrayList<>();
		Relacion relacion = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SELECCIONAR_RELACION2);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				relacion = new Relacion();
				
				relacion.setOrienSex(rs.getString(1));				
				relacion.setZodiaco(rs.getString(2));
				relacion.setDescripcion(rs.getString(3));
				relaciones.add(relacion);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return relaciones;
	}
	
	
	
	
	
	
	
	
	
	
	
}
