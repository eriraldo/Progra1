package logica;


import java.util.ArrayList;

/**
 *clase que sirve para comunicar la interfaz con la logica
 * @author erick
 * @author dereck
 */
public class Funcionalidades {
    
    /**
     *se crea un counter para trabajar sobre el
     */
    public static Counter counter;
    
    /**
     *constructor default
     */
    public Funcionalidades(){
        
    }
    
    /**
     *crea un counter nuevo
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
     * @return counter
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
     *Sirve para agregar un cliente
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
     *modifica un cliente
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
     * @return listaCasilleros
     */
    public static Casillero[] demeLista(){
        return counter.getLista();
    }
    
    /**
     *consulta un cliente
     * @param cedula
     * @return temp
     */
    public static String consultarCliente(String cedula){
        String temp = counter.consultarCliente(cedula);
        return temp ;
        
    }

    /**
     * elimina un cliente del counter
     * @param cedula
     * @return true
     */
    public static boolean eliminarCliente(String cedula){
        counter.eliminarCliente(cedula);
        return true;
        
    }
    
    /**
     *lista todos los clientes
     * @return lista
     */
    public static String listarClientes(){
        String lista;
        lista = counter.listarClientes();
        return lista;
    }
    
    /**
     *registra un sobre
     * @param cedula
     * @param sobre
     * @return true
     */
    public static boolean registrarSobre(String cedula,Sobre sobre){
        counter.registrarSobre(cedula, sobre);
        return true;
    }

    /**
     *registra una revista
     * @param cedula
     * @param revista
     * @return true
     */
    public static boolean registrarRevista(String cedula,Revista revista){
        counter.registrarRevista(cedula, revista);
        return true;
    }

    /**
     *
     * @param cedula
     * @param paquete
     * @return true
     */
    public static boolean registrarPaquete(String cedula,Paquete paquete){
        counter.registrarPaquete(cedula, paquete);
        return true;
        
    }

    /**
     *calcular el impuesto de un sobre
     * @param sobre
     * @param moneda
     * @return impuesto
     */
    public static double calcularImpuestoSobre(Sobre sobre,boolean moneda){
        return counter.calcularImpuestoSobre(sobre, moneda);
    }

    /**
     *calcular el impuesto de una revista
     * @param rev
     * @param moneda
     * @return impuesto
     */
    public static double calcularImpuestoRevista(Revista rev,boolean moneda){
        return counter.calcularImpuestoRevista(rev, moneda);
    }

    /**
     *calcular el impuesto de un paquete
     * @param paquete
     * @param moneda
     * @return impuesto
     */
    public static double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        return counter.calcularImpuestoPaquete(paquete, moneda);
    }
    
    /**
     *calcula el descuento que tiene un cliente segun su rango
     * @param cedula
     * @return descuento
     */
    public static double calcularDescuentoCliente(String cedula){
        return counter.descuentoClientePaquete(cedula);
    }

    /**
     *modifica la cantidad de paquetes que debe recibir un cliente para subir de rango
     * @param valor
     * @return true
     */
    public static boolean modificarAscensoDeRango(int valor){
        counter.modificarAscensoDeRango(valor);
        return true;
    }

    /**
     *retira un entregable
     * @param arr
     * @param cedula
     * @return res
     */
    public static String retirarEntregable(ArrayList arr,String cedula){
        String res = counter.retirarPaquetes(arr, cedula);
        return res;
                
    }

    /**
     *lista los entregables pendientes
     * @param cedula
     * @return res
     */
    public static String listarEntregablesPendientes(String cedula){
        String res = counter.listaEntregablesPendientes(cedula);
        return res;
    }

    /**
     * lista los entregables de un string
     * @param tiraRegistros
     * @param cedula
     * @return arr
     */
    public static ArrayList obtenerEntregablesDeString(String tiraRegistros,String cedula){
        ArrayList arr = counter.obtenerEntregablesDeString(tiraRegistros, cedula);
        return arr;
        
    }

    /**
     *retira los entregables
     * @param arr
     * @param cedula
     * @return res
     */
    public static String retirarEntregables(ArrayList arr,String cedula){
        String res = counter.retirarPaquetes(arr, cedula);
        return res;
    }
    
    /**
     *muestra el estado de un casillero
     * @param s
     * @return res
     */
    public static String estadoCasillero(String s){
        String res = counter.estadoCasillero(s);
        return res;
    }

    /**
     *lista los articulos recibidos en una fecha
     * @param fecha
     * @return res
     */
    public static String detalleRecibidosPorFecha(String fecha){
        String res = counter.detalleRecibidosPorFecha(fecha);
        return res;
    }

    /**
     *lista los articulos entregados en una fecha
     * @param fecha
     * @return res
     */
    public static String detalleEntregadosPorFecha(String fecha){
        String res = counter.detalleEntregadosPorFecha(fecha);
        return res;
    }

    /**
     * lista los clientes que tienen articulos con pendientes
     * @return
     */
    public static String listaClientesConPendientes(){
        String res = counter.listaClientesConPendientes();
        return res;
    }
    
            
}
