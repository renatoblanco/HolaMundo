package uy.com.lifan.holamundo;

public class Global   {

    //Clase que agrupa todas las variables globales de la app.

    private static Global instance ;

    private Global() {}

    public static Global getInstance() {
        if(instance == null) instance = new Global();
        return instance;
    }
}
