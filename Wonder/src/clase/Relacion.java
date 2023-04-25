package clase;

public class Relacion {
	private int codRela;
	private String descripcion;
	//
	public Relacion(int codRela, String descripcion) {
		super();
		this.codRela = codRela;
		this.descripcion = descripcion;
	}
	//
	public int getCodRela() {
		return codRela;
	}
	public void setCodRela(int codRela) {
		this.codRela = codRela;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
