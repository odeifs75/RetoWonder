package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import clase.Actividad;
import clase.Administrador;
import clase.Cliente;
import clase.Quiere;
import clase.Relacion;
import clase.Ubicacion;
import clase.Usuario;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
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
	// SELECT
	final String LOGIN = "select * from usuario where nomUsu=? and contraseina=?";
	final String COMPROBAR_ADMIN = "select * from administrador where nomUsuAd=?";
	final String COMPROBAR_CLIENTE = "select * from cliente where nomUsuCli=?";
	final String SELECCIONAR_CLIENTE = "select fechaNac from cliente";
	final String SELECCIONAR_RELACION = "select * from relacion";
	final String SELECCIONAR_CLIENTES = "select * from usuario u join cliente c on c.nomUsuCli=u.nomUsu";
	final String SELECCIONAR_ACTIVIDAD = "select * from actividad";
	final String SELECCIONAR_MATCH = "select * from quiere where like1=true and like2=true and nomUsuCli1=?";
	final String SELECCIONAR_MATCH2 = "select * from quiere where like1=true and like2=true and nomUsuCli2=?";
	final String SELECCIONAR_QUIERE = "select* from quiere where nomUsuCli1=? and nomUsuCli2=?";
	final String SELECCIONAR_NOM_RELACION = "select codRela from relacion where NomUsuCli=?";
	final String SELECCIONAR_USUARIO = "select nomUsuCli from cliente";
	final String CARGAR_RELACION = "select * from relacion where codRela=?";

	final String SELECCIONAR_QUIERE_TABLA = "select * from quiere";
	// INSERT
	final String INSERTAR_USUARIO = "insert into usuario (nomUsu, email, contraseina) values (?, ?, ?)";
	final String INSERTAR_CLIENTE = "insert into cliente (nomUsuCli, genero, fechaNac) values (?, ?, ?)";
	final String INSERTAR_RELACION = "insert into relacion (orienSex, zodiaco, gustos, queBuscas, descrip, nomUsuCli) values (?, ?, ?, ?, ?, ?)";
	final String INSERTAR_UBICACION = "insert into ubicacion (pais, ciudad, codPostal) values (?, ?, ?)";
	final String APUNTARSE = "insert into actividad(cantPersIns) values (?)";
	final String CREAR_QUIERE = "insert into quiere (nomUsuCli1, nomUsuCli2, like1, like2) values (?, ?, ?, ?)";
	final String CREAR_ACTIVIDAD = "insert into actividad (nomActividad, descripcion, fecha, nomUsuCli) values (?, ?, ?, ?)";

	// UPDATE
	final String MODIFICAR_USUARIO = "update cliente set orienSex=?, zodiaco=?, gustos=?, queBuscas=? where nomUsu=?";
	final String MODIFICAR_RELACION = "update relacion set orienSex=?, zodiaco=?, gustos=?, queBuscas=? where nomUsuCli=?";
	final String UPDATE_QUIERE = "update quiere set like2=?";
	// DELETE
	final String ELIMINAR_USUARIO = "delete from usuario where nomUsu=?";

	/**
	 * 
	 */
	public DaoImplementacionBD() {
		// TODO Auto-generated constructor stub
		this.configFichero = ResourceBundle.getBundle("modelo.config");
		this.driverBD = this.configFichero.getString("Driver");
		this.urlBD = this.configFichero.getString("Conn");
		this.userBD = this.configFichero.getString("DBUser");
		this.passwordBD = this.configFichero.getString("DBPass");
	}

	// Abrimos la conexion
	/**
	 * 
	 */
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
	/**
	 * @throws SQLException
	 */
	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	// Metodo para saber si existe el usuario
	/**
	 * @param usuario.
	 * @return Este metodo comprueba si existen usuarios.
	 */
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
	/**
	 * @param usu.
	 * @return Este metodo hace el login y comprueba si el usuario introducido es
	 *         admin o cliente.
	 */
	@Override
	public Usuario login(Usuario usu) {
		ResultSet rs;

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
					Administrador administrador = null;
					administrador = new Administrador();
					administrador.setNomUsu(rs.getString(1));
					administrador.setEmail(email);
					administrador.setContrasena(contrasena);
					return administrador;
				} else {
					stmt = con.prepareStatement(COMPROBAR_CLIENTE);
					stmt.setString(1, usu.getNomUsu());
					rs = stmt.executeQuery();
					if (rs.next()) {
						Cliente cliente = null;
						cliente = new Cliente();
						cliente.setNomUsu(rs.getString(1));
						cliente.setEmail(email);
						cliente.setContrasena(contrasena);
						cliente.setGenero(rs.getString(2));
						return cliente;
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
		return null;

	}

	// Metodo para insertar un nuevo registro en la base de datos utilizando un
	/**
	 * @param cli y ubi Este metodo insert los datos de usuario, cliente y ubicacion
	 *            en la base de datos.
	 */
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

//Metodo para insertar los datos de la relacion
	/**
	 * @param rela. Este metodo insert los datos de la relacion en la base de datos.
	 */
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
	 * @param email.
	 * @return Verifica que el email sigue el patron de un email convencional.
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

	/**
	 * @param nombreUsu El nombre de usuario en la cual se cargaran los datos de la
	 *                  relacion.
	 * @return Carga los datos de la relacion para un nombre de usuario segun con el
	 *         que hayas iniciado sesion.
	 */
	@Override
	public Relacion cargarDatos(String nombreUsu) {

		Relacion rela = new Relacion();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SELECCIONAR_NOM_RELACION);
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

			e.printStackTrace();
		}
		return rela;

	}

	/**
	 * @param usu.
	 * @return Elimina todos los datos del usuario que hayas eligido previamente.
	 */
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
	/**
	 * @param acti.
	 * @return El usuario con el que tu has iniciado sesion puede crear la actividad
	 *         poniendo el nombre de la actividad, la descripcion y la fecha.
	 */
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

	/**
	 * @return Una lista de strings que contiene los nombres de usuarios. Obtiene
	 *         una lista de nombres de usuarios de clientes.
	 */
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

	/**
	 * @param rela contiene loda datos de la relacion a modificar. Modifica los
	 *             datos de una relación existente.
	 */
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

	/**
	 * @return Una lista de instancias de la clase Actividad que representan las
	 *         actividades disponibles. Consulta todas las actividades disponibles.
	 */
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
				actividad.setCantPerIns(rs.getInt(5));
				actividad.setNomUsuCli(rs.getString(6));
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

	/**
	 * @return Una lista de instancias de la clase Cliente que representan los
	 *         clientes registrados. Consulta todos los clientes registrados.
	 */
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
				cliente.setEmail(rs.getString(2));
				cliente.setGenero(rs.getString(5));
				cliente.setFechaNac(rs.getDate(6).toLocalDate());
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

	/**
	 * @return Una lista de instancias de la clase Relacion que representan las
	 *         relaciones existentes.
	 * 
	 *         Consulta todas las relaciones existentes.
	 */
	@Override
	public List<Relacion> consultarRelaciones() {
		List<Relacion> relaciones = new ArrayList<>();
		Relacion relacion = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SELECCIONAR_RELACION);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				relacion = new Relacion();

				relacion.setCodRela(rs.getInt(1));
				relacion.setOrienSex(rs.getString(2));
				relacion.setZodiaco(rs.getString(3));
				relacion.setGustos(rs.getString(4));
				relacion.setQueBuscas(rs.getString(5));
				relacion.setDescripcion(rs.getString(6));
				relacion.setNomUsuCli(rs.getString(7));
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

	/**
	 * 
	 *
	 * @param nomUsu1 y nomUsu2 El nombre de usuario del primer usuario y del
	 *                segundo usuario. Crea una relación quiere entre dos usuarios.
	 */
	@Override
	public void crearQuiere(String nomUsu1, String nomUsu2) {
		this.openConnection();
		boolean creado1 = false;
		boolean creado2 = false;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECCIONAR_QUIERE);
			stmt.setString(1, nomUsu1);
			stmt.setString(2, nomUsu2);
			rs = stmt.executeQuery();
			if (rs.next()) {
				creado1 = rs.getBoolean("like1");
				creado2 = rs.getBoolean("like2");
			} else {
				stmt = con.prepareStatement(SELECCIONAR_QUIERE);
				stmt.setString(1, nomUsu2);
				stmt.setString(2, nomUsu1);
				rs = stmt.executeQuery();
				if (rs.next()) {
					creado1 = rs.getBoolean("like1");
					creado2 = rs.getBoolean("like2");
				}
			}

			if (creado1 == false && creado2 == false) {
				stmt = con.prepareStatement(CREAR_QUIERE);
				stmt.setString(1, nomUsu1);
				stmt.setString(2, nomUsu2);
				stmt.setBoolean(3, true);
				stmt.setBoolean(4, false);
				stmt.executeUpdate();
			} else if (creado1 == true && creado2 == false) {
				stmt = con.prepareStatement(UPDATE_QUIERE);
				stmt.setBoolean(1, true);
				stmt.executeUpdate();
			}

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

	/**
	 * @param nomUsu.
	 * @return Una instancia de la clase Cliente que representa los datos del
	 *         cliente o null si no se encuentra el cliente.
	 * 
	 *         Obtiene los datos de un cliente especifico.
	 * 
	 */
	@Override
	public Cliente cogerDatosCliente(String nomUsu) {
		this.openConnection();
		ResultSet rs;
		try {
			stmt = con.prepareStatement(COMPROBAR_CLIENTE);
			stmt.setString(1, nomUsu);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente = new Cliente();
				cliente.setNomUsu(rs.getString(1));
				cliente.setGenero(rs.getString(2));
				return cliente;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param act.
	 * 
	 *             El usuario se puede apuntar a actividades ya creadas por otros
	 *             usuarios.
	 */
	@Override
	public void apuntarseActividad(Actividad act) {
		this.openConnection();
		int personasIns;
		ResultSet rs = null;
		try {

			stmt = con.prepareStatement(APUNTARSE);
			stmt.setInt(1, act.getCodActividad());
			personasIns = rs.getInt("cantPersIns");
			personasIns = +1;
			stmt = con.prepareStatement("APUNTARSE");
			stmt.setInt(5, personasIns);
			rs = stmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Cliente> match(String nomUsu) {
		this.openConnection();
		List<Cliente> clientes = new ArrayList<>();
		ResultSet rs;

		try {

			stmt = con.prepareStatement(SELECCIONAR_MATCH);
			stmt.setString(1, nomUsu);
			rs = stmt.executeQuery();
			if (rs.next()) {

				Cliente cli = new Cliente();
				cli.setNomUsu(rs.getString(2));

				stmt = con.prepareStatement(COMPROBAR_CLIENTE);
				stmt.setString(1, cli.getNomUsu());
				rs = stmt.executeQuery();
				clientes.add(cli);

			}

			stmt = con.prepareStatement(SELECCIONAR_MATCH2);
			stmt.setString(1, nomUsu);
			rs = stmt.executeQuery();
			if (rs.next()) {

				Cliente cli = new Cliente();
				cli.setNomUsu(rs.getString(1));

				stmt = con.prepareStatement(COMPROBAR_CLIENTE);
				stmt.setString(1, cli.getNomUsu());
				rs = stmt.executeQuery();
				clientes.add(cli);

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

//	public void crearQuiere(String nomUsu1, String nomUsu2) {
//		this.openConnection();
//		boolean creado1 = false;
//		boolean creado2 = false;
//		ResultSet rs;
//
//		try {
//			stmt = con.prepareStatement(SELECCIONAR_QUIERE);
//			stmt.setString(1, nomUsu1);
//			stmt.setString(2, nomUsu2);
//			rs = stmt.executeQuery();
//			if (rs.next()) {
//				creado1 = rs.getBoolean("like1");
//				creado2 = rs.getBoolean("like2");
//			} else {
//				stmt = con.prepareStatement(SELECCIONAR_QUIERE);
//				stmt.setString(1, nomUsu2);
//				stmt.setString(2, nomUsu1);
//				rs = stmt.executeQuery();
//				if (rs.next()) {
//					creado1 = rs.getBoolean("like1");
//					creado2 = rs.getBoolean("like2");
//				}
//			}
//
//			if (creado1 == false && creado2 == false) {
//				stmt = con.prepareStatement(CREAR_QUIERE);
//				stmt.setString(1, nomUsu1);
//				stmt.setString(2, nomUsu2);
//				stmt.setBoolean(3, true);
//				stmt.setBoolean(4, false);
//				stmt.executeUpdate();
//			} else if (creado1 == true && creado2 == false) {
//				stmt = con.prepareStatement(UPDATE_QUIERE);
//				stmt.setBoolean(1, true);
//				stmt.executeUpdate();
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			this.closeConnection();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
