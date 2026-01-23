package hdt1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Controlador c = new Controlador();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Prender Radio\n2. Cambiar de AM y FM\n3. Avanzar en dial de emisoras\n4. Guardar la emisora actual en un botón\n5. Seleccionar emisora guardada en un botón\n6. Apagar Radio");
            int eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    c.prenderRadio();
                    break;
                case 2:
                    c.setFrequencia();
                    break;
                case 3:
                    c.avanzarEstacion();
                    break;
                case 4:
                    c.asignarBotones();
                    break;
                case 5:
                    c.escogerBoton();
                    break;
                case 6:
                    c.apagarRadio();
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
        }
        }
    }
}
