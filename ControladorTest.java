package hdt1;

import org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ControladorTest {

    private Controlador controlador;

    @BeforeEach
    void setUp() {
        controlador = new Controlador();
    }

    @Test
    void testPrenderRadioSi() {
        String input = "s\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        controlador.sc = new Scanner(System.in);

        controlador.prenderRadio();

        assertTrue(controlador.r.getEstado());
    }

    @Test
    void testPrenderRadioNo() {
        String input = "n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        controlador.sc = new Scanner(System.in);

        controlador.prenderRadio();

        assertFalse(controlador.r.getEstado());
    }

    @Test
    void testApagarRadioSi() {
        controlador.r.setEstado(true);

        String input = "s\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        controlador.sc = new Scanner(System.in);

        controlador.apagarRadio();

        assertFalse(controlador.r.getEstado());
    }

    @Test
    void testAvanzarEstacionAMNormal() {
        controlador.avanzarEstacion();
        assertEquals(540, controlador.EstacionAM);
    }

    @Test
    void testAvanzarEstacionAMReinicio() {
        controlador.EstacionAM = 1610;
        controlador.avanzarEstacion();

        assertEquals(530, controlador.EstacionAM);
    }

    @Test
    void testAvanzarEstacionFMNormal() {
        controlador.AM = false;
        controlador.avanzarEstacion();

        assertEquals(88.1, controlador.EstacionFM, 0.0001);
    }

    @Test
    void testAvanzarEstacionFMReinicio() {
        controlador.AM = false;
        controlador.EstacionFM = 107.9;

        controlador.avanzarEstacion();

        assertEquals(87.9, controlador.EstacionFM, 0.0001);
    }

    @Test
    void testAsignarBotonAM() {
        controlador.asignarBotones();

        assertEquals(1, controlador.BotonesAM.size());
        assertEquals(530, controlador.BotonesAM.get(0));
    }

    @Test
    void testAsignarBotonFM() {
        controlador.AM = false;
        controlador.asignarBotones();

        assertEquals(1, controlador.BotonesFM.size());
        assertEquals(87.9, controlador.BotonesFM.get(0));
    }

    @Test
    void testEscogerBotonAM() {
        controlador.BotonesAM.add(600);
        controlador.BotonesAM.add(700);

        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        controlador.sc = new Scanner(System.in);

        controlador.escogerBoton();

        assertEquals(700, controlador.EstacionAM);
    }

    @Test
    void testEscogerBotonFM() {
        controlador.AM = false;
        controlador.BotonesFM.add(99.5);
        controlador.BotonesFM.add(101.1);

        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        controlador.sc = new Scanner(System.in);

        controlador.escogerBoton();

        assertEquals(99.5, controlador.EstacionFM, 0.0001);
    }
}
