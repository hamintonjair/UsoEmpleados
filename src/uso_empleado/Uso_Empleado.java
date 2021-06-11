/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uso_empleado;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author JOJAMA
 */
public class Uso_Empleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        Jefatura jefe_RRHH = new Jefatura("jair,", 55000, 2006, 9, 25);
       jefe_RRHH.estableceIncentivo(2570);
       
       
       Empleado[] misEmpleados = new Empleado[5];
       
       misEmpleados[0] = jefe_RRHH; //POLIMORFISMO EN ACCION, PRINCIPIO DE SUSTITUCION   
       misEmpleados[1] = new Empleado("Haminton Mena,", 95000, 2000, 12, 18);
       misEmpleados[2] = new Empleado("Horacio Palacios,", 85000, 2001, 11, 17);
       misEmpleados[3] = new Empleado("Digna Luz Cordoba,", 75000, 2002, 10, 16); 
       misEmpleados[4] = new Jefatura("Maria", 95000, 1990, 5, 26);
       
        for(Empleado d: misEmpleados){
              d.subeSueldo(5);
        }
         
        for(Empleado d: misEmpleados){
             System.out.println("Nombre: " + d.dameNombre() + ", Sueldo: "+ d.dameSueldo()
              + ", Fecha de alta: " + d.dameFechaContrato());
        }
    }
    
}
//parametros de la clase empleado
class Empleado{
    
    public Empleado(String nomb, double suel, int año, int mes, int dia){
        
        nombre = nomb;
        sueldo = suel;
        GregorianCalendar calendario = new GregorianCalendar(año, mes-1, dia);
        altaContrato = calendario.getTime();
        ++IdSiguiente;
        Id = IdSiguiente;
        
    }
    //metodo getter o get
    public String dameNombre(){
        return nombre + " Id: " + Id ;
    }
    public double dameSueldo(){
        return sueldo;
    }
    public Date dameFechaContrato(){
        return altaContrato;
    }
    
    //metodo setter o set
    public void subeSueldo(double porcentaje){
        double aumento = (sueldo * porcentaje) / 100;
        sueldo += aumento;
    }
    
    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente;
    private int Id;
       
}
class Jefatura extends Empleado{
    
    public Jefatura(String nomb, double suel, int año, int mes, int dia){
        super(nomb, suel, año, mes, dia);
    }
    public void estableceIncentivo(double b){
        incentivo = b;
    }
    
    //EL TERMINO SUPER ES PARA LLAMAR AL METODO DE LA CLASE PADRE
    public double dameSueldo(){
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }
    
    private double incentivo;
}
