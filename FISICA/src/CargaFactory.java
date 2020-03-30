/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gorym
 */
public class CargaFactory implements CargaFactoryMethod{

	@Override
	public Carga crearCarga(double magnitud, double exp,double x, double y) {
		// TODO Auto-generated method stub
		 return new Carga(magnitud,x,x,y);
	}
    
}
