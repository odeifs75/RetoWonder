package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Quiere {
	// ATRIBUTOS
	private String nomUsuCli1;
	private String nomUsuCli2;
	private boolean like1;
	private boolean like2;

	// CONSTRUCTOR
	/**
	 * 
	 */
	public Quiere() {
		super();
	}

	// GETTERS Y SETTER
	/**
	 * @return
	 */
	public String getNomUsuCli1() {
		return nomUsuCli1;
	}

	/**
	 * @param nomUsuCli1
	 */
	public void setNomUsuCli1(String nomUsuCli1) {
		this.nomUsuCli1 = nomUsuCli1;
	}

	/**
	 * @return
	 */
	public String getNomUsuCli2() {
		return nomUsuCli2;
	}

	/**
	 * @param nomUsuCli2
	 */
	public void setNomUsuCli2(String nomUsuCli2) {
		this.nomUsuCli2 = nomUsuCli2;
	}

	/**
	 * @return
	 */
	public boolean isLike1() {
		return like1;
	}

	/**
	 * @param like1
	 */
	public void setLike1(boolean like1) {
		this.like1 = like1;
	}

	/**
	 * @return
	 */
	public boolean isLike2() {
		return like2;
	}

	/**
	 * @param like2
	 */
	public void setLike2(boolean like2) {
		this.like2 = like2;
	}

}
