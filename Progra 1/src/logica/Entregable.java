
package logica;


public class Entregable {
    private int numReferencia ;
    private boolean estadoEntrega;
    private String descripcion ;
    private String remitente ;
   
    
    public Entregable(){
   
                
    }
    
    
    public Entregable(int numReferencia,boolean estado,String descripcion,String remitente){
        this.descripcion = descripcion;
        this.estadoEntrega = estado;
        this.numReferencia = numReferencia;
        this.remitente = remitente;
        
        
    }

    public int getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(int numReferencia) {
        this.numReferencia = numReferencia;
    }

    public boolean getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(boolean estado) {
        this.estadoEntrega = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }


    
    
}
