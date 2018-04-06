
package logica;


public class Casillero {
    private int numero = 1000;
    private boolean estado;
    private Cliente cliente;//cada casillero debe de tener unicamente un cliente
    public Casillero(){
        
    }
    
    public Casillero(int number, boolean state,Cliente cliente){
        
        if (number>=1000){
            this.estado = state;
            this.numero = number;
            this.cliente = cliente;
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
    
}


