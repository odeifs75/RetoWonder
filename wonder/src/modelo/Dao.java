package modelo;

import clase.Actividad;
import clase.Cliente;
import clase.Relacion;
import clase.Usuario;


public interface Dao {

	public Usuario login(Usuario usu);
	
	public void insertarUsuario(Cliente cli);
	
	public void insertarRelacion(Relacion rela);
	
	public Relacion cargarDatos(String nomUsu);
	
	public void eliminarUsuario(Usuario usu);
	
	public void crearActividad(Actividad acti);

}
