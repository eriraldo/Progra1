
package progra.pkg1;

public class Counter {
    private String nombre ;
    private String identificacion ;
    private String direccion ;
    private int numCasilleros;
    
    


    public Counter(){
    
    }
    
    public void crearCounter(String nombre, String identificacion,String direccion,int numCasilleros){
        this.direccion= direccion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.numCasilleros = numCasilleros;
        
        System.out.println("Counter creado exitosamente!");
        
        
    }
    
    public int getNumCasilleros(){
        return numCasilleros;
    }
}