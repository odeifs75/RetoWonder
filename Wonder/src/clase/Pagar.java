package clase;

public class Pagar {
	private String nomUsu;
	private int codActividad;

	//
	public Pagar(String nomUsu, int codActividad) {

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
