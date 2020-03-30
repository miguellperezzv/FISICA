/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author gorym
 */
public class CampoNCargas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
        System.out.println("digite el numero de cargas");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        CargaFactory factory = new CargaFactory();
        double magnitud = 0;
        double x = 0;
        double y = 0;
        double exp=0;
        Carga[] cargas = new Carga[n+1];
        double campox = 0;
        double campoy = 0;
        for (int i=1;i<=n;i++){
            System.out.println("Magnitud de carga "+i+" (C):");
            magnitud=s.nextDouble();
            System.out.println("Posicion x de carga "+i+" (m):");
            x=s.nextDouble();
            System.out.println("Posicion y de carga "+i+" (m):");
            y=s.nextDouble();
            cargas[i]=factory.crearCarga(magnitud,exp,x,y);
        }
        System.out.println("Digite el punto p desde el cual se calculara el campo");
        System.out.println("Posicion x:");
        double px = s.nextDouble();
        System.out.println("Posicion y:");
        double py = s.nextDouble();
        for (int i=1;i<=n;i++){
            double rx = px-cargas[i].getX();
            double ry = py-cargas[i].getY();
            double r2 = (rx*rx)+(ry*ry);
            campox += 9*cargas[i].getMagnitud()*rx/(r2*sqrt(r2));
            campoy += 9*cargas[i].getMagnitud()*ry/(r2*sqrt(r2));
        }
        System.out.println("El campo electrico en P es: "+campox+" i + "+campoy+" j *10^9 N/C");
    }    
}
