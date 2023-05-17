package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Usuario {
	// ATRIBUTOS
	private String nomUsu;
	private String email;
	private String contrasena;
	
	// CONSTRUCTOR
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	// GETTERS Y SETTER
	/**
	 * @return
	 */
	public String getNomUsu() {
		return nomUsu;
	}
	/**
	 * @param nomUsu
	 */
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
