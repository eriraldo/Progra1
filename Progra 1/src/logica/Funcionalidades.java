package logica;




public class Funcionalidades {
    
    protected static Counter counter = new Counter();
    //public static Funcionalidades f = new Funcionalidades();
    
    
    
    
    
    public Funcionalidades(){
        
    }
    
    public static boolean crearCounter(String nombre,String identificacion,String direccion,int numCasilleros){
        
        counter.crearCounter(nombre,identificacion, direccion, numCasilleros);
        return true;
        
        
        
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
    
    public static boolean listarClientes(){
        counter.listarClientes();
        return true;
    }
    
    public static boolean registarSobre(String cedula,Sobre sobre){
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
    
            
}
