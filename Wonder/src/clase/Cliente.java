package clase;

public class Cliente extends Usuario{
	private String nomUsu;
	private String email;
	private String contrasena;
	//
	public Cliente(String nomUsu, String email, String contrasena, String nomUsu2, String email2, String contrasena2) {
		super(nomUsu, email, contrasena);
		nomUsu = nomUsu2;
		email = email2;
		contrasena = contrasena2;
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
