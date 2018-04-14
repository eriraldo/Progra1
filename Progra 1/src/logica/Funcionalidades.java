package logica;


import java.util.ArrayList;

public class Funcionalidades {
    
    public static Counter counter;
    
    
    
    
    
    public Funcionalidades(){
        
    }
    
    
    public static boolean crearCounter(String nombre,String identificacion,String direccion,int numCasilleros){
        
        counter.crearCounter(nombre,identificacion, direccion, numCasilleros);
        return true;
        
        
        
    }

    public static Counter getCounter() {
        return counter;
    }

    public static void setCounter(Counter counter) {
        Funcionalidades.counter = counter;
    }
    
    public static boolean agregarCliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){
        
        counter.addCliente(name, id, mail, gender, cellphone, location, nacimiento, rango);
        return true;
        
    }
    public static boolean modificarCliente(String cedula,String dato,int tipo){
        counter.modificarCliente(cedula, dato, tipo);
        return true;
    }
    
    public static Casillero[] demeLista(){
        return counter.getLista();
    }
    
    public static String consultarCliente(String cedula){
        String temp = counter.consultarCliente(cedula);
        return temp ;
        
    }
    public static boolean eliminarCliente(String cedula){
        counter.eliminarCliente(cedula);
        return true;
        
    }
    
    public static String listarClientes(){
        String lista;
        lista = counter.listarClientes();
        return lista;
    }
    
    public static boolean registrarSobre(String cedula,Sobre sobre){
        counter.registrarSobre(cedula, sobre);
        return true;
    }
    public static boolean registrarRevista(String cedula,Revista revista){
        counter.registrarRevista(cedula, revista);
        return true;
    }
    public static boolean registrarPaquete(String cedula,Paquete paquete){
        counter.registrarPaquete(cedula, paquete);
        return true;
        
    }
    public static double calcularImpuestoSobre(Sobre sobre,boolean moneda){
        return counter.calcularImpuestoSobre(sobre, moneda);
    }
    public static double calcularImpuestoRevista(Revista rev,boolean moneda){
        return counter.calcularImpuestoRevista(rev, moneda);
    }
    public static double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        return counter.calcularImpuestoPaquete(paquete, moneda);
    }
    
    public static double calcularDescuentoCliente(String cedula){
        return counter.descuentoClientePaquete(cedula);
    }
    public static boolean modificarAscensoDeRango(int valor){
        counter.modificarAscensoDeRango(valor);
        return true;
    }
    public static String retirarEntregable(ArrayList arr,String cedula){
        String res = counter.retirarPaquetes(arr, cedula);
        return res;
                
    }
    public static String listarEntregablesPendientes(String cedula){
        String res = counter.listaEntregablesPendientes(cedula);
        return res;
    }
    public static ArrayList obtenerEntregablesDeString(String tiraRegistros,String cedula){
        ArrayList arr = counter.obtenerEntregablesDeString(tiraRegistros, cedula);
        return arr;
        
    }
    public static String retirarEntregables(ArrayList arr,String cedula){
        String res = counter.retirarPaquetes(arr, cedula);
        return res;
    }
    
    public static String estadoCasillero(String s){
        String res = counter.estadoCasillero(s);
        return res;
    }
    public static String detalleRecibidosPorFecha(String fecha){
        String res = counter.detalleRecibidosPorFecha(fecha);
        return res;
    }
    public static String detalleEntregadosPorFecha(String fecha){
        String res = counter.detalleEntregadosPorFecha(fecha);
        return res;
    }
    public static String listaClientesConPendientes(){
        String res = counter.listaClientesConPendientes();
        return res;
    }
    
            
}
