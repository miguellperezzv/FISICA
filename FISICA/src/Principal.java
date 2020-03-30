import static java.lang.Math.sqrt;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {
	
		Carga carga;
		Carga[] cargas;
		CargaFactory factory = new CargaFactory();
		int i=0;
		int cant=0;
		JLabel txtNCargas = new JLabel("Ingrese la cantidad de cargas");
		JTextField nCargas = new JTextField();
		JButton btnNCargas = new JButton ("CONFIRMAR");
		JButton guardarCarga = new JButton ("GUARDAR");
		JButton calcular = new JButton("CALCULAR");
		
		JLabel txtcarga=new JLabel();
		JTextField magnitud = new JTextField();
		JTextField exponente = new JTextField();
		JTextField coordx = new JTextField();
		JTextField coordy = new JTextField();
		
	public static void main(String[] args) {
		
		Principal m = new Principal();
		
		m.setSize(1000, 500);
		m.setLayout(null);
		m.setVisible(true);
	}

	Principal(){
		Container c = getContentPane();
		c.add(txtNCargas); txtNCargas.setBounds(40, 40, 200, 40);
		c.add(nCargas); nCargas.setBounds(250, 40, 50, 30);
		c.add(btnNCargas); btnNCargas.setBounds(400,40,100,30); btnNCargas.addActionListener(this);
		
		c.add(guardarCarga); guardarCarga.setBounds(500, 135, 150, 30); guardarCarga.setVisible(false);
		guardarCarga.addActionListener(this);
		c.add(txtcarga); 	txtcarga.setBounds(40, 100, 700, 30); txtcarga.setVisible(false);
		c.add(magnitud);	magnitud.setBounds(120, 135, 70, 30); magnitud.setVisible(false);
		c.add(exponente);	exponente.setBounds(220, 135, 50, 30); exponente.setVisible(false);
		c.add(coordx);	coordx.setBounds(350, 135, 50, 30); coordx.setVisible(false);
		c.add(coordy);	coordy.setBounds(400, 135, 50, 30); coordy.setVisible(false);
		c.add(calcular); calcular.setBounds(500, 135, 150, 30); calcular.setVisible(false);
		calcular.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnNCargas) {
			cant =Integer.parseInt(nCargas.getText());
			cargas=new Carga[cant];
			txtcarga.setText("Carga "+(i+1)+" "+ " :  MAGNITUD                      x10^                 COORD     x                          y                          ") ;
			guardarCarga.setVisible(true);
			txtcarga.setVisible(true);
			magnitud.setVisible(true);
			exponente.setVisible(true);
			coordx.setVisible(true);
			coordy.setVisible(true);
		}
		
		if(e.getSource()==guardarCarga) {
			
			txtcarga.setText("Carga "+(i+2)+" "+ " :  MAGNITUD                      x10^                 COORD     x                          y                          ") ;
			int magn =0;
			int exp = 0;
			double x=0;
			double y=0;
			if(i<(cant)) {
			magn =Integer.parseInt(magnitud.getText());
			exp = Integer.parseInt(exponente.getText());
			x=Double.parseDouble(coordx.getText());
			y=Double.parseDouble(coordy.getText());
			cargas[i]=factory.crearCarga(magn,exp,x,y);
			System.out.println("CARGA GUARDADA: magn: "+magn+", exp: "+exp+", x y"+x+","+y);
			i++;
			if(i==cant) {
				txtcarga.setText("Ingrese las coordenadas de la carga de prueba                   x                          y                          ") ;
				txtNCargas.setVisible(false);
				nCargas.setVisible(false);
				btnNCargas.setVisible(false);
				guardarCarga.setVisible(false);
				magnitud.setVisible(false);
				exponente.setVisible(false);
				calcular.setVisible(true);	
			}
			
			}
			
		}
		
		if(e.getSource()==calcular) {
			System.out.println("largo del arreglo "+ cargas.length);
			for(i=0;i<cargas.length;i++) {
				System.out.print("CARGA: "+ cargas[i].getMagnitud()+cargas[i].getExp() +cargas[i].getX()+cargas[i].getY()+"\n");
			}
			
			
			 double px =Double.parseDouble(coordx.getText());
			 double py =Double.parseDouble(coordy.getText());
		     double campox=0;
		     double campoy=0;
		        for (int i=0;i<cant;i++){
		            double rx = px-cargas[i].getX();
		            double ry = py-cargas[i].getY();
		            double r2 = (rx*rx)+(ry*ry);
		            
		            campox += 9*cargas[i].getMagnitud()*rx/(r2*sqrt(r2));
		            campoy += 9*cargas[i].getMagnitud()*ry/(r2*sqrt(r2));
		        }
		        System.out.println("El campo electrico en P es: "+campox+" i + "+campoy+" j *10^9 N/C");
		}
		
		
	}

}
