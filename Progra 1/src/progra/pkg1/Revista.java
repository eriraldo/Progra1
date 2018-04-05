
package progra.pkg1;


public class Revista extends Entregable{
    
    private String titulo;
    private boolean esCatalogo;
    private String tema;
    
    public Revista(int numReferencia,boolean estado,String descripcion,String remitente,String tipo,String titulo,boolean esCatalogo,String tema){
        super(numReferencia,estado,descripcion,remitente,tipo);
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
    
}
