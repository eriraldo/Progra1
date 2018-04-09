
package logica;



public class Progra1 {

    
    public static void main(String[] args) {
        
        Counter f = new Counter();
        
        f.crearCounter("Aerocasillas", "28930", "Tibas", 30);      //El numero es el # de casilleros, segun la docu hay que especificarlo.
        
        f.addCliente("Andres", "604490595", "automaticcounterbot@gmail.com", "Male", "85102666", "Tibas", "01/01/1999", "Normal");
        f.addCliente("Maria", "110630719", "automaticcounterbot@gmail.com", "Female", "88262222", "Alajuela", "12/04/1990", "Oro");
        f.modificarCliente("110630719", "83150445", 5);
        
        Sobre sob1 = new Sobre(92345,false,"Sobre comun de manila","Pedro Cunha","manila","Documento",0.05);
        Revista rev1 = new Revista(23734,false,"Revista de coleccion","Amazon","Anemona Paradise",false,"Naturaleza");
        Paquete paq1 = new Paquete(83823,false,"Tablet Samsung color negro","Amazon","Caja",true,true,2);
        
        f.modificarAscensoDeRango(1);
        
        f.registrarSobre("604490595", sob1);//Esta en normal, asciende a plata
        f.registrarPaquete("604490595", paq1);//Esta en plata, asciende a oro
        f.registrarRevista("110630719", rev1);//Esta en oro ,se queda en oro
        
        
        
        /*
        double imp1= f.calcularImpuestoSobre(sob1, true);
        double imp2= f.calcularImpuestoRevista(rev1, true);
        double imp3 = f.calcularImpuestoPaquete(paq1, true);
        
        double desc1 = f.calcularDescuentoCliente("604490595");
        double desc2 = f.calcularDescuentoCliente("110630719");
                
        
        System.out.println("Impuesto:"+String.valueOf(imp1)+"\tDescuento:"+String.valueOf(desc1*imp1)+"\tTotal:"+String.valueOf(imp1-(imp1*desc1)));
        System.out.println("Impuesto:"+String.valueOf(imp2)+"\tDescuento:"+String.valueOf(desc2*imp2)+"\tTotal:"+String.valueOf(imp2-(imp2*desc2)));
        System.out.println("Impuesto:"+String.valueOf(imp3)+"\tDescuento:"+String.valueOf(desc2*imp3)+"\tTotal:"+String.valueOf(imp3-(imp3*desc2)));
        //f.listarClientes();
        //f.consultarCliente("604490595");
        //f.eliminarCliente("110630719");
        
       */
    }
        
        
    
}


