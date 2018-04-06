
package logica;





public class Progra1 {

    
    public static void main(String[] args) {
        Funcionalidades f = new Funcionalidades();
        f.crearCounter("Aerocasillas", "28930", "Tibas", 30);      //El numero es el # de casilleros, segun la docu hay que especificarlo.
        f.agregarCliente("Andres", "604490595", "avargas@gmail.com", "Male", "85102666", "Tibas", "01/01/1999", "Platino");
        f.agregarCliente("Maria", "110630719", "maria14@hotmail.com", "Female", "88262222", "Alajuela", "12/04/1990", "Oro");
        f.modificarCliente("110630719", "83150445", 5);
        
        //f.listarClientes();
        //f.consultarCliente("604490595");
        //f.eliminarCliente("110630719");
        
        //Cliente[] temp = f.demeLista();
        //String n = temp[0].getTelefono();
        //System.out.println(n);
    }
    
}


