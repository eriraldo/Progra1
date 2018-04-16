
package logica;

/**
 *
 * @author erick
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
    private Casillero casillero;//Para poder confirmar que solo tiene un casillero, se verifica este casillero con el atributo cliente de la clase casillero
    
    /**
     *
     */
    public Cliente(){
        
    }
    
    /**
     *
     * @param name
     * @param id
     * @param mail
     * @param gender
     * @param cellphone
     * @param location
     * @param nacimiento
     * @param rango
     */
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

    /**
     *
     * @return
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     *
     * @param identificador
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     *
     * @param tipoCliente
     */
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
}
