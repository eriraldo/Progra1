
package logica;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Casillero {
    private int numero = 1000;
    private boolean estado;
    private Cliente cliente;//cada casillero debe de tener unicamente un cliente
    private int cantPaquetes;
    private int cantPendientes;
    private boolean cambioDeNivel;
    
    private ArrayList listaEntregables;
    private String informeEstadoCasillero;
    
    private Paquete[] listaPaquetes;
    private Sobre[] listaSobres;
    private Revista[] listaRevistas;

    /**
     *
     */
    public Casillero(){
        
    }
    
    /**
     *
     * @param number
     * @param state
     * @param cliente
     */
    public Casillero(int number, boolean state,Cliente cliente){
        
        if (number>=1000){
            this.estado = state;
            this.numero = number;
            this.cliente = cliente;
            listaPaquetes = new Paquete[50];
            listaRevistas = new Revista[50];
            listaSobres = new Sobre[50];
            cantPaquetes = 0;
            listaEntregables = new ArrayList(20);
            informeEstadoCasillero = "";
            cantPendientes= 0;
            cambioDeNivel = false;
            
        }
        else{
            System.out.println("Error, el numero de casillero debe ser mayor o igual a 1000");
        }
        
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getInformeEstado() {
        return informeEstadoCasillero;
    }

    /**
     *
     * @param s
     */
    public void setInformeEstado(String s) {
        informeEstadoCasillero+= s;
    }
    
    /**
     *
     */
    public void resetInformeEstado(){
        informeEstadoCasillero ="";
        
    }

    /**
     *
     */
    public void resetListaEntregables(){
        listaEntregables.clear();
    }

    /**
     *
     * @return
     */
    public boolean getCambioDeNivel(){
        return cambioDeNivel;
    }

    /**
     *
     * @param b
     */
    public void setCambioDeNivel(boolean b){
        cambioDeNivel = b;
    }

    /**
     *
     * @return
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     *
     * @param n
     */
    public void setCantidadPendientes(int n){
        cantPendientes+=n;
    }

    /**
     *
     * @return
     */
    public int getCantidadPendientes(){
        return cantPendientes;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     *
     * @return
     */
    public Cliente getCliente(){
        return this.cliente;
    }

    /**
     *
     * @param nuevo
     */
    public void setCliente(Cliente nuevo){
        this.cliente = nuevo;
    }
    
    /**
     *
     * @param n
     */
    public void setCantidadPaquetes(int n){
        cantPaquetes = n;
    }

    /**
     *
     * @return
     */
    public int getCantidadPaquetes(){
        return cantPaquetes;
    }

    /**
     *
     * @return
     */
    public int largoListaPaquetes(){
        int cont =0;
        while (listaPaquetes[cont]!= null)
            cont++;
        return cont;
    }

    /**
     *
     * @return
     */
    public int largoListaSobres(){
        int cont =0;
        while (listaSobres[cont]!= null)
            cont++;
        return cont;
    }

    /**
     *
     * @return
     */
    public int largoListaRevistas(){
        int cont =0;
        while (listaRevistas[cont]!= null)
            cont++;
        return cont;
    }
    
    /**
     *
     * @return
     */
    public Paquete[] getListaPaquetes(){
        return this.listaPaquetes;
        
    }
    
    /**
     *
     * @param paquete
     */
    public void setListaPaquetes(Paquete paquete){
        int largo = largoListaPaquetes();
        this.listaPaquetes[largo] = paquete;
    }

    /**
     *
     * @return
     */
    public Sobre[] getListaSobres(){
        return this.listaSobres;
        
    }
    
    /**
     *
     * @param sobre
     */
    public void setListaSobres(Sobre sobre){
        int largo = largoListaSobres();
        this.listaSobres[largo] = sobre;
    }

    /**
     *
     * @return
     */
    public Revista[] getListaRevistas(){
        return this.listaRevistas;
        
    }
    
    /**
     *
     * @param revista
     */
    public void setListaRevistas(Revista revista){
        int largo = largoListaRevistas();
        this.listaRevistas[largo] = revista;
    }

    /**
     *
     * @return
     */
    public String listarEntregables(){
        String resul = "";
        int cont = 0;
        if (listaRevistas[cont]!=null){
            resul+="Revistas:"+"\n";
            while(listaRevistas[cont]!=null){
                Revista rev = listaRevistas[cont];
                String str = rev.getTitulo();
                resul+="-"+str;
                cont++;
            }
        }
        resul+="\n\n";
        cont = 0;
        if (listaPaquetes[cont]!=null){
            resul+="Paquetes:"+"\n";
            while(listaPaquetes[cont]!=null){
                Paquete paq = listaPaquetes[cont];
                String str = paq.getDescripcion();
                resul+="-"+str;
                cont++;
            }
        }
        resul+="\n\n";
        cont = 0;
        if (listaSobres[cont]!=null){
            resul+="Sobres:"+"\n";
            while(listaSobres[cont]!=null){
                Sobre sob = listaSobres[cont];
                String str = sob.getDescripcion();
                resul+="-"+str;
                cont++;
            
            }
        }
        return resul;
        
    }

    /**
     *
     * @return
     */
    public ArrayList getListaEntregables(){
        return listaEntregables;
    }

    /**
     *
     * @return lista de pendientes
     */
    public String listarPendientes(){
        String resul = "";
        int cont = 0;
        if (listaRevistas[cont]!=null){
            resul+="Revistas:"+"\n";
            while(listaRevistas[cont]!=null){
                Revista rev = listaRevistas[cont];
                if (rev.getEstadoEntrega()== false){
                    String str = rev.getTitulo();
                    resul+="-"+str;
                    cont++;
                }
                else{
                    cont++;
                }
            }
        }
        resul+="\n\n";
        cont = 0;
        if (listaPaquetes[cont]!=null){
            resul+="Paquetes:"+"\n";
            while(listaPaquetes[cont]!=null){
                Paquete paq = listaPaquetes[cont];
                if(paq.getEstadoEntrega()==false){
                    String str = paq.getDescripcion();
                    resul+="-"+str;
                    cont++;
                }
                else{
                    cont++;
                }
            }
        }
        resul+="\n\n";
        cont = 0;
        if (listaSobres[cont]!=null){
            resul+="Sobres:"+"\n";
            while(listaSobres[cont]!=null){
                Sobre sob = listaSobres[cont];
                if (sob.getEstadoEntrega()==false){
                    String str = sob.getDescripcion();
                    resul+="-"+str;
                    cont++;
                }
                else{
                    cont++;
                }
            }
        }
        return resul;
        
    }
}


