
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erick
 * @author dereck
 */
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
    
    /**
     *constructor con todo lo necesario para crear un sobre
     * @param numReferencia
     * @param estado
     * @param descripcion
     * @param remitente
     * @param tipoSobre
     * @param contenido
     * @param peso
     */
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

    /**
     *
     * @return contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @param s
     */
    public void setFechaEntrega(String s){
        fechaEntregado = s;
    }

    /**
     *
     * @return fechaEntregado
     */
    public String getFechaEntrega(){
        return fechaEntregado;
    }

    /**
     *
     * @param s
     */
    public void setHoraEntrega(String s){
        horaEntregado = s;
    }

    /**
     *
     * @return horaEntregado
     */
    public String getHoraEntrega(){
        return horaEntregado;
    }

    /**
     *
     * @return fechaRecibido
     */
    public String getFechaRecibido(){
        return fechaRecibido;
    }

    /**
     *
     * @param dato
     */
    public void setImpuestoColon(String dato){
        impuestoColon = dato;
    }

    /**
     *
     * @return impuestoColon
     */
    public String getImpuestoColon(){
        return impuestoColon;
    }

    /**
     *
     * @param dato
     */
    public void setDescuentoColon(String dato){
        descuentoColon = dato;
    }

    /**
     *
     * @return descuentoColon
     */
    public String getDescuentoColon(){
        return descuentoColon;
    }

    /**
     *
     * @param dato
     */
    public void setImpuestoDolar(String dato){
        impuestoDolar = dato;
    }

    /**
     *
     * @return impuestoDolar
     */
    public String getImpuestoDolar(){
        return impuestoDolar;
    }

    /**
     *
     * @param dato
     */
    public void setDescuentoDolar(String dato){
        descuentoDolar = dato;
    }

    /**
     *
     * @return descuentoDolar
     */
    public String getDescuentoDolar(){
        return descuentoDolar;
    }

    /**
     *
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @return peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     *
     * @param tipo
     */
    public void setTipoSobre(String tipo){
        this.tipoSobre = tipo;
    }
    
    /**
     *
     * @return tipoSobre
     */
    public String getTipoSobre(){
        return tipoSobre;
    }
    
    
}
