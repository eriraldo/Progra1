
package progra.pkg1;

/**
 *
 * @author dereck
 */
public class Cliente {
    private String identificador = "";
    private String nombre = "";
    private String correo = "";
    private String telefono = "";
    private String direccion = "";
    private String sexo = "";
    private String fechaNacimiento = "";
    private String tipoCliente = "";
    
    public Cliente(){
        
    }
    
    
    
    public Cliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){     
        this.correo = mail;
        this.direccion = location;
        this.fechaNacimiento = nacimiento;
        this.identificador = id;
        this.nombre = name;
        this.sexo = gender ;
        this.telefono = cellphone;
        this.tipoCliente = rango;
    }
    
}
