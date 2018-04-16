
package logica;

/**
 *
 * @author erick
 */
public class Entregable {
    private int numReferencia ;
    private boolean estadoEntrega;
    private String descripcion ;
    private String remitente ;
   
    /**
     *
     */
    public Entregable(){
   
                
    }
    
    /**
     *
     * @param numReferencia
     * @param estado
     * @param descripcion
     * @param remitente
     */
    public Entregable(int numReferencia,boolean estado,String descripcion,String remitente){
        this.descripcion = descripcion;
        this.estadoEntrega = estado;
        this.numReferencia = numReferencia;
        this.remitente = remitente;
        
        
    }

    /**
     *
     * @return
     */
    public int getNumReferencia() {
        return numReferencia;
    }

    /**
     *
     * @param numReferencia
     */
    public void setNumReferencia(int numReferencia) {
        this.numReferencia = numReferencia;
    }

    /**
     *
     * @return
     */
    public boolean getEstadoEntrega() {
        return estadoEntrega;
    }

    /**
     *
     * @param estado
     */
    public void setEstadoEntrega(boolean estado) {
        this.estadoEntrega = estado;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     *
     * @param remitente
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }


    
    
}
