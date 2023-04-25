package clase;

public class Vivir {
	private int codUbicacion;
	private String nomUsu;
	//Constructores
	public Vivir(int codUbicacion, String nomUsu) {
		super();
		this.codUbicacion = codUbicacion;
		this.nomUsu = nomUsu;
	}
	//Getters y setters
	public int getCodUbicacion() {
		return codUbicacion;
	}
	public void setCodUbicacion(int codUbicacion) {
		this.codUbicacion = codUbicacion;
	}
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
}
