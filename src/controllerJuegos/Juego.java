package controllerJuegos;

import model.GameDates;


public class Juego {
    
    private static GameDates juego;

    public static GameDates getJuego() {
        return juego;
    }

    public static void setJuego(GameDates juego) {
        Juego.juego = juego;
    }

    
}
