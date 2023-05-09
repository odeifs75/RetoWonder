package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Administrador extends Usuario {
	// ATRIBUTOS
	private float salario;

	// CONSTRUCTOR
	/**
	 * 
	 */
	public Administrador() {
		super();

	}

	// GETTERS Y SETTER
	/**
	 * @return
	 */
	public float getSalario() {
		return salario;
	}

	/**
	 * @param salario
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}
}
