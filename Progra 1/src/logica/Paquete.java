
package logica;
import java.util.*;
import java.text.*;

public class Paquete extends Entregable {
    
    private boolean fragil;
    private boolean esElectronico;
    private double peso;
    private String tipoEntrega;
    private String fechaRecibido;
    private String horaRecibido;
    private String fechaEntregado;
    private String horaEntregado;
    
    public Paquete(int numReferencia,boolean estadoEntrega,String descripcion,String remitente,String tipoEntrega,boolean fragil,boolean esElectronico,double peso){
        super(numReferencia,estadoEntrega,descripcion,remitente);
        this.esElectronico  = esElectronico;
        this.fragil = fragil;
        this.peso = peso;
        this.tipoEntrega = tipoEntrega;
        Date dNow = new Date( );
        SimpleDateFormat date = new SimpleDateFormat ("dd.MM.yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
        fechaRecibido = date.format(dNow);
        horaRecibido = hour.format(dNow);
        fechaEntregado ="";
        horaEntregado = "";
    }

    public boolean esFragil() {
        return fragil;
    }
    public void setFechaEntrega(String s){
        fechaEntregado = s;
    }
    public String getFechaEntrega(){
        return fechaEntregado;
    }
    public void setHoraEntrega(String s){
        horaEntregado = s;
    }
    public String getHoraEntrega(){
        return horaEntregado;
    }
    public String getFechaRecibido(){
        return fechaRecibido;
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
