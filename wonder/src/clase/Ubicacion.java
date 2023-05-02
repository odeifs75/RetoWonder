package clase;

public class Ubicacion {
	private int codUbicacion;
	private String pais;
	private String ciudad;
	private int codPostal;
	
	//Constructores
	public Ubicacion() {
		super();
		
	}
	//Getters y setters
	public int getCodUbicacion() {
		return codUbicacion;
	}
	
	public void setCodUbicacion(int codUbicacion) {
		this.codUbicacion = codUbicacion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
}
