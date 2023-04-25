package clase;

public class Crear {
	private String nomUsu;
	private int codActividad;
	//
	public Crear(String nomUsu, int codActividad) {
		super();
		this.nomUsu = nomUsu;
		this.codActividad = codActividad;
	}
	//
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
	public int getCodActividad() {
		return codActividad;
	}
	public void setCodActividad(int codActividad) {
		this.codActividad = codActividad;
	}
}
