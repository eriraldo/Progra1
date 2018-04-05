
package progra.pkg1;

/**
 *
 * @author dereck
 */
public class Casillero {
    private int numero = 1000;
    private boolean estado;
    
    public Casillero(){
        
    }
    
    public Casillero(int number, boolean state){
        
        if (number>=1000){
            this.estado = state;
            this.numero = number;
        }
        else{
            System.out.println("Error, el numero de casillero debe ser mayor o igual a 1000");
        }
        
    }
    
}


