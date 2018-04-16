
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erick
 * @author dereck
 */
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
    
    /**
     *constructor para crear una revista con sus diferentes atributos
     * @param numReferencia
     * @param estado
     * @param descripcion
     * @param remitente
     * @param titulo
     * @param esCatalogo
     * @param tema
     */
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
    
    /**
     *
     * @return titulo
     */
    public String getTitulo(){
        return titulo;
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
     */
    public void imprimirPrueba(){
        System.out.println(getTitulo());
    }

    /**
     *
     * @return esCatalogo
     */
    public boolean esCatalogo() {
        return esCatalogo;
    }

    /**
     *
     * @param esCatalogo
     */
    public void setEsCatalogo(boolean esCatalogo) {
        this.esCatalogo = esCatalogo;
    }

    /**
     *
     * @return tema
     */
    public String getTema() {
        return tema;
    }

    /**
     *
     * @param tema
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    
}
