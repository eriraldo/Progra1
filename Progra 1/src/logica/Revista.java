
package logica;


public class Revista extends Entregable{
    
    private String titulo;
    private boolean esCatalogo;
    private String tema;
    
    public Revista(int numReferencia,boolean estado,String descripcion,String remitente,String titulo,boolean esCatalogo,String tema){
        super(numReferencia,estado,descripcion,remitente);
        this.esCatalogo = esCatalogo;
        this.tema = tema;
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return titulo;
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
