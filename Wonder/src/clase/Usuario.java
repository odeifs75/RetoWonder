package clase;

public class Usuario {
	private String nomUsu;
	private String email;
	private String contrasena;
	//
	public Usuario(String nomUsu, String email, String contrasena) {
		super();
		this.nomUsu = nomUsu;
		this.email = email;
		this.contrasena = contrasena;
	}
	//
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
