
package logica;


public class Paquete extends Entregable {
    
    private boolean fragil;
    private boolean esElectronico;
    private double peso;
    private String tipoEntrega;
    
    public Paquete(int numReferencia,boolean estadoEntrega,String descripcion,String remitente,String tipoEntrega,boolean fragil,boolean esElectronico,double peso){
        super(numReferencia,estadoEntrega,descripcion,remitente);
        this.esElectronico  = esElectronico;
        this.fragil = fragil;
        this.peso = peso;
        this.tipoEntrega = tipoEntrega;
    }

    public boolean esFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public boolean esElectronico() {
        return esElectronico;
    }

    public void setEsElectronico(boolean esElectronico) {
        this.esElectronico = esElectronico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public void setTipoEntrega(String tipo){
        this.tipoEntrega = tipo;
    }
    
    public String getTipoEntrega(){
        return tipoEntrega;
    }
    
}
