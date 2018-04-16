package logica;


import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Funcionalidades {
    
    /**
     *
     */
    public static Counter counter;
    
    /**
     *
     */
    public Funcionalidades(){
        
    }
    
    /**
     *
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numCasilleros
     * @return
     */
    public static boolean crearCounter(String nombre,String identificacion,String direccion,int numCasilleros){
        
        counter.crearCounter(nombre,identificacion, direccion, numCasilleros);
        return true;
        
        
        
    }

    /**
     *
     * @return
     */
    public static Counter getCounter() {
        return counter;
    }

    /**
     *
     * @param counter
     */
    public static void setCounter(Counter counter) {
        Funcionalidades.counter = counter;
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
     * @return
     */
    public static boolean agregarCliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){
        
        counter.addCliente(name, id, mail, gender, cellphone, location, nacimiento, rango);
        return true;
        
    }

    /**
     *
     * @param cedula
     * @param dato
     * @param tipo
     * @return
     */
    public static boolean modificarCliente(String cedula,String dato,int tipo){
        counter.modificarCliente(cedula, dato, tipo);
        return true;
    }
    
    /**
     *
     * @return
     */
    public static Casillero[] demeLista(){
        return counter.getLista();
    }
    
    /**
     *
     * @param cedula
     * @return
     */
    public static String consultarCliente(String cedula){
        String temp = counter.consultarCliente(cedula);
        return temp ;
        
    }

    /**
     *
     * @param cedula
     * @return
     */
    public static boolean eliminarCliente(String cedula){
        counter.eliminarCliente(cedula);
        return true;
        
    }
    
    /**
     *
     * @return
     */
    public static String listarClientes(){
        String lista;
        lista = counter.listarClientes();
        return lista;
    }
    
    /**
     *
     * @param cedula
     * @param sobre
     * @return
     */
    public static boolean registrarSobre(String cedula,Sobre sobre){
        counter.registrarSobre(cedula, sobre);
        return true;
    }

    /**
     *
     * @param cedula
     * @param revista
     * @return
     */
    public static boolean registrarRevista(String cedula,Revista revista){
        counter.registrarRevista(cedula, revista);
        return true;
    }

    /**
     *
     * @param cedula
     * @param paquete
     * @return
     */
    public static boolean registrarPaquete(String cedula,Paquete paquete){
        counter.registrarPaquete(cedula, paquete);
        return true;
        
    }

    /**
     *
     * @param sobre
     * @param moneda
     * @return
     */
    public static double calcularImpuestoSobre(Sobre sobre,boolean moneda){
        return counter.calcularImpuestoSobre(sobre, moneda);
    }

    /**
     *
     * @param rev
     * @param moneda
     * @return
     */
    public static double calcularImpuestoRevista(Revista rev,boolean moneda){
        return counter.calcularImpuestoRevista(rev, moneda);
    }

    /**
     *
     * @param paquete
     * @param moneda
     * @return
     */
    public static double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        return counter.calcularImpuestoPaquete(paquete, moneda);
    }
    
    /**
     *
     * @param cedula
     * @return
     */
    public static double calcularDescuentoCliente(String cedula){
        return counter.descuentoClientePaquete(cedula);
    }

    /**
     *
     * @param valor
     * @return
     */
    public static boolean modificarAscensoDeRango(int valor){
        counter.modificarAscensoDeRango(valor);
        return true;
    }

    /**
     *
     * @param arr
     * @param cedula
     * @return
     */
    public static String retirarEntregable(ArrayList arr,String cedula){
        String res = counter.retirarPaquetes(arr, cedula);
        return res;
                
    }

    /**
     *
     * @param cedula
     * @return
     */
    public static String listarEntregablesPendientes(String cedula){
        String res = counter.listaEntregablesPendientes(cedula);
        return res;
    }

    /**
     *
     * @param tiraRegistros
     * @param cedula
     * @return
     */
    public static ArrayList obtenerEntregablesDeString(String tiraRegistros,String cedula){
        ArrayList arr = counter.obtenerEntregablesDeString(tiraRegistros, cedula);
        return arr;
        
    }

    /**
     *
     * @param arr
     * @param cedula
     * @return
     */
    public static String retirarEntregables(ArrayList arr,String cedula){
        String res = counter.retirarPaquetes(arr, cedula);
        return res;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static String estadoCasillero(String s){
        String res = counter.estadoCasillero(s);
        return res;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public static String detalleRecibidosPorFecha(String fecha){
        String res = counter.detalleRecibidosPorFecha(fecha);
        return res;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public static String detalleEntregadosPorFecha(String fecha){
        String res = counter.detalleEntregadosPorFecha(fecha);
        return res;
    }

    /**
     *
     * @return
     */
    public static String listaClientesConPendientes(){
        String res = counter.listaClientesConPendientes();
        return res;
    }
    
            
}
