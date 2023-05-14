package modelo;

import java.util.List;

import clase.Actividad;
import clase.Cliente;
import clase.Relacion;
import clase.Ubicacion;
import clase.Usuario;

public interface Dao {

	public Usuario login(Usuario usu);

	public void insertarUsuario(Cliente cli, Ubicacion ubi);

	public void insertarRelacion(Relacion rela);

	public Relacion cargarDatos(String nomUsu);

	public void eliminarUsuario(Usuario usu);

	public void crearActividad(Actividad acti);

	public List<String> listarUsuCli();

	public int existeUsuario(String usuario);

	public boolean esEmail(String email);

	public void modificarRelacion(Relacion rela);

	public List<Actividad> consultarActividades();

//	public List<Cliente> consultarPerfil();
	
	public List<Cliente> consultarClientes();

	public List<Relacion> consultarRelaciones();
}
