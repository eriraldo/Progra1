
package logica;





public class Progra1 {

    
    public static void main(String[] args) {
        
        Funcionalidades f = new Funcionalidades();
        f.crearCounter("Aerocasillas", "28930", "Tibas", 30);      //El numero es el # de casilleros, segun la docu hay que especificarlo.
        f.agregarCliente("Andres", "604490595", "automaticcounterbot@gmail.com", "Male", "85102666", "Tibas", "01/01/1999", "Platino");
        f.agregarCliente("Maria", "110630719", "automaticcounterbot@gmail.com", "Female", "88262222", "Alajuela", "12/04/1990", "Oro");
        f.modificarCliente("110630719", "83150445", 5);
        Sobre sob1 = new Sobre(92345,false,"Sobre comun de manila","Pedro Cunha","manila","Contiene 3 cartas de amor",0.05);
        Revista rev1 = new Revista(23734,false,"Revista de coleccion","Amazon","Anemona Cliche",false,"Naturaleza");
        Paquete paq1 = new Paquete(83823,false,"Tablet Samsung color negro","Amazon","Caja",true,true,2);
        //f.registarSobre("604490595", sob1);
        f.registrarPaquete("110630719", paq1);
        //f.registrarRevista("110630719", rev1);
        //f.listarClientes();
        //f.consultarCliente("604490595");
        //f.eliminarCliente("110630719");
        
        
    }
    
}


