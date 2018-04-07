
package logica;


public class Casillero {
    private int numero = 1000;
    private boolean estado;
    private Cliente cliente;//cada casillero debe de tener unicamente un cliente
    
    private Paquete[] listaPaquetes;
    private Sobre[] listaSobres;
    private Revista[] listaRevistas;
    public Casillero(){
        
    }
    
    public Casillero(int number, boolean state,Cliente cliente){
        
        if (number>=1000){
            this.estado = state;
            this.numero = number;
            this.cliente = cliente;
            listaPaquetes = new Paquete[50];
            listaRevistas = new Revista[50];
            listaSobres = new Sobre[50];
        }
        else{
            System.out.println("Error, el numero de casillero debe ser mayor o igual a 1000");
        }
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente nuevo){
        this.cliente = nuevo;
    }
    
    public int largoListaPaquetes(){
        int cont =0;
        while (listaPaquetes[cont]!= null)
            cont++;
        return cont;
    }
    public int largoListaSobres(){
        int cont =0;
        while (listaSobres[cont]!= null)
            cont++;
        return cont;
    }
    public int largoListaRevistas(){
        int cont =0;
        while (listaRevistas[cont]!= null)
            cont++;
        return cont;
    }
    
    public Paquete[] getListaPaquetes(){
        return this.listaPaquetes;
        
    }
    
    public void setListaPaquetes(Paquete paquete){
        int largo = largoListaPaquetes();
        this.listaPaquetes[largo] = paquete;
    }
    public Sobre[] getListaSobres(){
        return this.listaSobres;
        
    }
    
    public void setListaSobres(Sobre sobre){
        int largo = largoListaSobres();
        this.listaSobres[largo] = sobre;
    }
    public Revista[] getListaRevistas(){
        return this.listaRevistas;
        
    }
    
    public void setListaRevistas(Revista revista){
        int largo = largoListaRevistas();
        this.listaRevistas[largo] = revista;
    }
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
}


