
package progra.pkg1;


public class Entregable {
    private int numReferencia ;
    private boolean estado;
    private String descripcion ;
    private String remitente ;
    private String tipo;
    
    public Entregable(){
        numReferencia = 0;
        estado = false;
        descripcion = "";
        remitente = "";
        tipo = "";
                
    }
    
    
    public Entregable(int numReferencia,boolean estado,String descripcion,String remitente,String tipo){
        this.descripcion = descripcion;
        this.estado = estado;
        this.numReferencia = numReferencia;
        this.remitente = remitente;
        this.tipo = tipo;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
