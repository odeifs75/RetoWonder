package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.mysql.cj.exceptions.RSAException;

import clase.Administrador;
import clase.Cliente;
import clase.Relacion;
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
	private String id;

	// Sentencias sql
	final String LOGIN = "select * from usuario where nomUsu=? and contraseina=?";
	final String COMPROBAR_ADMIN = "select * from administrador where nomUsuAd=?";
	final String COMPROBAR_CLIENTE = "select * from usuario where nomUsu=?";
	final String MODIFICAR_USUARIO = "update cliente set orienSex=?, zodiaco=?, gustos=?, queBuscas=? where nomUsu=?";
	final String INSERTAR_USUARIO = "insert into usuario (nomUsu, email, contraseina) values (?, ?, ?)";
	final String INSERTAR_CLIENTE = "insert into cliente (nomUsuCli, edad, genero) values (?, ?, ?)";
	final String INSERTAR_RELACION = "insert into relacion (codRela, orienSex, zodiaco, gustos, queBuscas, descrip, nomUsu) values (?, ?, ?, ?, ?, ?, ?)";
	final String CARGAR_RELACION = "select * from relacion where codRela=?";
	final String ELIMINAR_USUARIO = "delete from usuario where nomUsu=?";

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
	public int existeUsuario(String usuario) {

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
	public void insertarUsuario(Cliente cli) {

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
			stmt.setString(2, cli.getEdad());
			stmt.setString(3, cli.getGenero());
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

	public void insertarRelacion(Relacion rela) {
		this.openConnection();
		int rs;
		try {

			stmt = con.prepareStatement(INSERTAR_RELACION);

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, rela.getCodRela());
			stmt.setString(2, rela.getOrienSex());
			stmt.setString(3, rela.getZodiaco());
			stmt.setString(4, rela.getGustos());
			stmt.setString(5, rela.getQueBuscas());
			stmt.setString(6, rela.getDescripcion());
			stmt.setString(7, rela.getNomUsu());
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
	public boolean esEmail(String email) {
		// Patr�n para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	public Relacion cargarDatos() {

		Relacion rela = new Relacion();
		

		this.openConnection();
		try {

			stmt = con.prepareStatement(CARGAR_RELACION);
			stmt.setString(1, "01");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				rela.setNomUsu(rs.getString("nomUsuCli"));
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

}
