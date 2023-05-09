package controlador;

import modelo.Dao;
import modelo.DaoImplementacionBD;
import vista.Inicio;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao = new DaoImplementacionBD();
		Inicio ini=new Inicio(dao);
		ini.setVisible(true);
	}

}
   