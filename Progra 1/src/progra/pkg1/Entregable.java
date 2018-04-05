
package progra.pkg1;


public class Entregable {
    private int numReferencia ;
    private boolean estado;
    private String descripcion ;
    private String remitente ;
    private String tipo;
    
    public Entregable(){
   
                
    }
    
    
    public Entregable(int numReferencia,boolean estado,String descripcion,String remitente,String tipo){
        this.descripcion = descripcion;
        this.estado = estado;
        this.numReferencia = numReferencia;
        this.remitente = remitente;
        this.tipo = tipo;
        
    }

    public int getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(int numReferencia) {
        this.numReferencia = numReferencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
