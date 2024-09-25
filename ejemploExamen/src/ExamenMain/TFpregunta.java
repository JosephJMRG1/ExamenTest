package ExamenMain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TFpregunta extends Pregunta {
    private boolean respuestaCorrecta;

    public TFpregunta(String text, boolean respuestaCorrecta, double peso) {
        super(text, peso);
        // Validación del texto de la pregunta
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto de la pregunta no puede ser null o vacío.");
        }
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            while (true) {
                System.out.println(getText() + " (V/F): ");
                String respuesta = in.nextLine().trim().toLowerCase();

                if (respuesta.equals("v") || respuesta.equals("f")) {
                    boolean usuarioResponde = respuesta.equals("v");
                    boolean esCorrecta = (usuarioResponde == respuestaCorrecta);
                    if (esCorrecta) {
                        System.out.println("¡Correcto!");
                    } else {
                        System.out.println("Incorrecto.");
                    }
                    return esCorrecta;
                } else {
                    System.out.println("Entrada inválida. Por favor ingrese 'V' para Verdadero o 'F' para Falso.");
                    // Opcional: Limitar el número de intentos
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de entrada: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            return false;
        } finally {
            // No cerrar Scanner(System.in) para evitar cerrar el flujo de entrada estándar.
            // if (in != null) {
            //     in.close();
            // }
        }
    }
}
