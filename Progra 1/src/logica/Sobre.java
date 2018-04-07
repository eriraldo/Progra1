
package logica;


public class Sobre extends Entregable {
    
    private String contenido;
    private double peso;
    private String tipoSobre;
    
    
    public Sobre(int numReferencia,boolean estado,String descripcion,String remitente,String tipoSobre,String contenido,double peso){
        super(numReferencia,estado,descripcion,remitente);
        this.contenido = contenido;
        this.peso = peso;
        this.tipoSobre = tipoSobre;
        
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setTipoSobre(String tipo){
        this.tipoSobre = tipo;
    }
    
    public String getTipoSobre(){
        return tipoSobre;
    }
    
    
}
