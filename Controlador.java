package hdt1;
//Importación de librerias
import java.util.Scanner;
import java.util.ArrayList;
import jdk.jfr.Frequency;

public class Controlador {
    Radio r = new Radio();
    Scanner sc = new Scanner(System.in);

    //Listas para guardar botones
    ArrayList<Integer> BotonesAM = new ArrayList<Integer>(12);
    ArrayList<Double> BotonesFM = new ArrayList<Double>(12);

    //Variables usadas en diferentes métodos
    private boolean AM = true;
    private int EstacionAM = 530;
    private double EstacionFM = 87.9;
    private String freq = "AM";

    //Método para prender radio
    public void prenderRadio() {
        if (r.getEstado()==false) {
            System.out.println("¿Quiere encender la radio? (s/n)");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                r.setEstado(true);
                System.out.println("La radio ahora está encendida");
            }
            else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("La radio sigue apagada");
            }
            else {
                System.out.println("Ingrese una respuesta correcta");
            }
        }
        else if (r.getEstado()==true) {
            System.out.println("La radio ya está encendida");
        }
    }
    
    //Método para cambiar de frecuencia de AM a FM o viceversa
    public void setFrequencia() {
        if (freq.equalsIgnoreCase("AM")){
            System.out.println("¿Quiere cambiar de frecuencia a FM? (s/n)");
            String respuestaam = sc.nextLine();
            if (respuestaam.equalsIgnoreCase("s")) {
                this.AM = false;
            }
        }
        else if (freq.equalsIgnoreCase("FM")) {
            System.out.println("¿Quiere cambiar de frencuencia a AM? (s/n)");
            String respuestafm = sc.nextLine();
            if (respuestafm.equalsIgnoreCase("n")) {
                this.AM = true;
            }
        }
    }

    //Método para avanzar de estación en AM o FM
    public void avanzarEstacion() {
        if (this.AM) {
            this.EstacionAM += 10;
            System.out.println(EstacionAM);
            if (this.EstacionAM > 1610) {
                this.EstacionAM = 530;
                System.out.println(EstacionAM);
            }
        } else {
            this.EstacionFM += 0.2;
            System.out.println(EstacionFM);
            this.EstacionFM = Math.round(this.EstacionFM * 10.0)/10.0;

            if (this.EstacionFM > 107.9) {
                this.EstacionFM = 87.9;
                System.out.println(EstacionFM);
            }
        }
    }

    //Método para guardar la estación actual en un botón
    public void asignarBotones() {
        if (AM==true) {
            BotonesAM.add(EstacionAM);
        }
        else if (AM==false){
            BotonesFM.add(EstacionFM);
        }
    }

    //Método para poner una estación en un botón asignado
    public void escogerBoton() {
        if (AM==true) {
            System.out.println(BotonesAM);
            System.out.println("¿Que radio de las que guardó quiere poner? (0-11)");
            int respuestaAM = sc.nextInt();
            EstacionAM = BotonesAM.get(respuestaAM);
        }
        else if (AM==false){
            System.out.println(BotonesFM);
            System.out.println("¿Que radio de las que guardó quiere poner? (0-11)");
            int respuestaFM = sc.nextInt();
            EstacionFM= BotonesFM.get(respuestaFM);
        }
    }
    
    //Método para apagar una estación
    public void apagarRadio() {
        if (r.getEstado()==true) {
            System.out.println("¿Quiere apagar la radio? (s/n)");
            String respuesta1 = sc.nextLine();
            if (respuesta1.equalsIgnoreCase("s")) {
                r.setEstado(false);
                System.out.println("La radio ahora está apagada");
            }
            else if (respuesta1.equalsIgnoreCase("n")) {
                System.out.println("La radio sigue encendida");
            }
            else {
                System.out.println("Ingrese una respuesta correcta");
            }
        }
        else if (r.getEstado()==false) {
            System.out.println("La radio ya está apagada");
        }
    }
}
