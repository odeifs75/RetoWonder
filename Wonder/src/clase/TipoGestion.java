package clase;

public class TipoGestion {
	private int codGestion;
	private String tipoGestion;
	//
	public TipoGestion(int codGestion, String tipoGestion) {
		super();
		this.codGestion = codGestion;
		this.tipoGestion = tipoGestion;
	}
	//
	public int getCodGestion() {
		return codGestion;
	}
	public void setCodGestion(int codGestion) {
		this.codGestion = codGestion;
	}
	public String getTipoGestion() {
		return tipoGestion;
	}
	public void setTipoGestion(String tipoGestion) {
		this.tipoGestion = tipoGestion;
	}
}
