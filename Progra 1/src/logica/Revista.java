
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Revista extends Entregable{
    
    private String titulo;
    private boolean esCatalogo;
    private String tema;
    private String fechaRecibido;
    private String horaRecibido;
    private String fechaEntregado;
    private String horaEntregado;
    private String impuestoColon;
    private String descuentoColon;
    private String impuestoDolar;
    private String descuentoDolar;
    
    public Revista(int numReferencia,boolean estado,String descripcion,String remitente,String titulo,boolean esCatalogo,String tema){
        super(numReferencia,estado,descripcion,remitente);
        this.esCatalogo = esCatalogo;
        this.tema = tema;
        this.titulo = titulo;
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
    
    public String getTitulo(){
        return titulo;
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
    
    
    public void imprimirPrueba(){
        System.out.println(getTitulo());
    }

    public boolean esCatalogo() {
        return esCatalogo;
    }

    public void setEsCatalogo(boolean esCatalogo) {
        this.esCatalogo = esCatalogo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    
}
