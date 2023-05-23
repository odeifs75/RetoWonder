package modelo;

import java.util.List;

import clase.Actividad;
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
public interface Dao {

	/**
	 * @param usu
	 * @return
	 */

	public Usuario login(Usuario usu);

	/**
	 * @param cli
	 * @param ubi
	 */

	public void insertarUsuario(Cliente cli, Ubicacion ubi);

	/**
	 * @param rela
	 */

	public void insertarRelacion(Relacion rela);

	/**
	 * @param nomUsu
	 * @return
	 */

	public Relacion cargarDatos(String nomUsu);

	/**
	 * @param usu
	 */
	public void eliminarUsuario(Usuario usu);

	/**
	 * @param acti
	 */
	public void crearActividad(Actividad acti);

	/**
	 * @return
	 */
	public List<String> listarUsuCli();

	/**
	 * @param usuario
	 * @return
	 */
	public int existeUsuario(String usuario);

	/**
	 * @param email
	 * @return
	 */
	public boolean esEmail(String email);

	/**
	 * @param rela
	 */
	public void modificarRelacion(Relacion rela);

	/**
	 * @return
	 */
	public List<Actividad> consultarActividades();
	
	/**
	 * @return
	 */
	public List<Cliente> consultarClientes();

	/**
	 * @return
	 */
	public List<Relacion> consultarRelaciones();

	/**
	 * @param nombreUsu
	 * @param nomUsu
	 */
	public void crearQuiere(String nombreUsu, String nomUsu);

	/**
	 * @param nomUsu
	 * @return
	 */
	public Cliente cogerDatosCliente( String nomUsu);

	/**
	 * @param act
	 */
	public void apuntarseActividad(Actividad act);

	/**
	 * @param nomUsu
	 * @return
	 */
	public List<Cliente> match(String nomUsu);
	


}
