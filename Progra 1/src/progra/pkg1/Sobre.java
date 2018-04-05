
package progra.pkg1;


public class Sobre extends Entregable {
    
    private String contenido;
    private int peso;
    
    
    public Sobre(int numReferencia,boolean estado,String descripcion,String remitente,String tipo,String contenido,int peso){
        super(numReferencia,estado,descripcion,remitente,tipo);
        this.contenido = contenido;
        this.peso = peso;
        
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
