
package logica;


public class Cliente {
    private String identificador = "";
    private String nombre = "";
    private String correo = "";
    private String telefono = "";
    private String direccion = "";
    private String sexo = "";
    private String fechaNacimiento = "";
    private String tipoCliente = "";
    private Casillero casillero;//Para poder confirmar que solo tiene un casillero, se verifica este casillero con el atributo cliente de la clase casillero
    
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
}
