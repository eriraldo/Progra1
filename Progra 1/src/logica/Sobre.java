
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Sobre extends Entregable {
    
    private String contenido;
    private double peso;
    private String tipoSobre;
    private String fechaRecibido;
    private String horaRecibido;
    private String fechaEntregado;
    private String horaEntregado;
    private String impuestoColon;
    private String descuentoColon;
    private String impuestoDolar;
    private String descuentoDolar;
    
    
    public Sobre(int numReferencia,boolean estado,String descripcion,String remitente,String tipoSobre,String contenido,double peso){
        super(numReferencia,estado,descripcion,remitente);
        this.contenido = contenido;
        this.peso = peso;
        this.tipoSobre = tipoSobre;
        Date dNow = new Date( );
        SimpleDateFormat date = new SimpleDateFormat ("dd.MM.yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
        fechaRecibido = date.format(dNow);
        horaRecibido = hour.format(dNow);
        fechaEntregado ="";
        horaEntregado = "";
        impuestoColon="";
        descuentoColon="";
        impuestoDolar="";
        descuentoDolar="";
        
    }

    public String getContenido() {
        return contenido;
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
    public void setImpuestoColon(String dato){
        impuestoColon = dato;
    }
    public String getImpuestoColon(){
        return impuestoColon;
    }
    public void setDescuentoColon(String dato){
        descuentoColon = dato;
    }
    public String getDescuentoColon(){
        return descuentoColon;
    }
    public void setImpuestoDolar(String dato){
        impuestoDolar = dato;
    }
    public String getImpuestoDolar(){
        return impuestoDolar;
    }
    public void setDescuentoDolar(String dato){
        descuentoDolar = dato;
    }
    public String getDescuentoDolar(){
        return descuentoDolar;
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
