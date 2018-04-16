
package logica;
import java.util.*;
import java.text.*;

/**
 *
 * @author erick
 */
public class Paquete extends Entregable {
    
    private boolean fragil;
    private boolean esElectronico;
    private double peso;
    private String tipoEntrega;
    private String fechaRecibido;
    private String horaRecibido;
    private String fechaEntregado;
    private String horaEntregado;
    private String impuestoColon;
    private String descuentoColon;
    private String impuestoDolar;
    private String descuentoDolar;
    
    /**
     *
     * @param numReferencia
     * @param estadoEntrega
     * @param descripcion
     * @param remitente
     * @param tipoEntrega
     * @param fragil
     * @param esElectronico
     * @param peso
     */
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
        impuestoColon="";
        descuentoColon="";
        impuestoDolar="";
        descuentoDolar="";
    }

    /**
     *
     * @return
     */
    public boolean esFragil() {
        return fragil;
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
     * @return
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
     * @return
     */
    public String getHoraEntrega(){
        return horaEntregado;
    }

    /**
     *
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
     */
    public String getDescuentoDolar(){
        return descuentoDolar;
    }

    /**
     *
     * @param fragil
     */
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    /**
     *
     * @return
     */
    public boolean esElectronico() {
        return esElectronico;
    }

    /**
     *
     * @param esElectronico
     */
    public void setEsElectronico(boolean esElectronico) {
        this.esElectronico = esElectronico;
    }

    /**
     *
     * @return
     */
    public double getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    /**
     *
     * @param tipo
     */
    public void setTipoEntrega(String tipo){
        this.tipoEntrega = tipo;
    }
    
    /**
     *
     * @return
     */
    public String getTipoEntrega(){
        return tipoEntrega;
    }
    
}
