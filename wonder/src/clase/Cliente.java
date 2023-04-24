package clase;

public class Cliente extends Usuario{

	private String edad;
	private String genero;


	//
	
	public Cliente() {
		super();
	
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
