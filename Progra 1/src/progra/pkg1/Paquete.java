
package progra.pkg1;


public class Paquete extends Entregable {
    
    private boolean fragil;
    private boolean esElectronico;
    private int peso;
    
    public Paquete(int numReferencia,boolean estado,String descripcion,String remitente,String tipo,boolean fragil,boolean esElectronico,int peso){
        super(numReferencia,estado,descripcion,remitente,tipo);
        this.esElectronico  = esElectronico;
        this.fragil = fragil;
        this.peso = peso;
    }
    
}
