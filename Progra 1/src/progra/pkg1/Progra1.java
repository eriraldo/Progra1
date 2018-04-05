
package progra.pkg1;





public class Progra1 {

    
    public static void main(String[] args) {
        Funcionalidades f = new Funcionalidades();
        f.crearCounter("Aerocasillas", "28930", "Tibas", 30);      //El numero es el # de casilleros, segun la docu hay que especificarlo.
    }
    
}


//Trate usted de representar las relaciones de dependencia en codigo para darme una idea, por lo menos entre Counter,Cliente y casillero

//Estoy indeciso de donde colocar el array, porque puede ser que tambien al crear un counter, ahi inicializo el array(casilleros) de ese counter.
//No tendria sentido que en funcionalidades tenga un array si no ha creado un counter, no se que opina.

//Anemonas