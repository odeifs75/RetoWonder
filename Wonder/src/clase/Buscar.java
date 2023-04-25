package clase;

public class Buscar {
	private int codRela;
	private String NomUsu;
	//
	public Buscar(int codRela, String nomUsu) {
		super();
		this.codRela = codRela;
		NomUsu = nomUsu;
	}
	//
	public int getCodRela() {
		return codRela;
	}
	public void setCodRela(int codRela) {
		this.codRela = codRela;
	}
	public String getNomUsu() {
		return NomUsu;
	}
	public void setNomUsu(String nomUsu) {
		NomUsu = nomUsu;
	}
}
