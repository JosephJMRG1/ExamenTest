package ExamenMain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RCpregunta extends Pregunta {
    private String respuestaCorrecta;

    public RCpregunta(String text, String respuestaCorrecta, double peso) {
        super(text, peso);
        if (respuestaCorrecta == null || respuestaCorrecta.trim().isEmpty()) {
            throw new IllegalArgumentException("La respuesta correcta no puede ser null o vacía.");
        }
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println(getText());
            System.out.print("Respuesta: ");
            String respuestaUsuario = in.nextLine().trim();

            if (respuestaUsuario.isEmpty()) {
                throw new InputMismatchException("La respuesta no puede estar vacía.");
            }

            boolean esCorrecta = respuestaUsuario.equalsIgnoreCase(respuestaCorrecta);
            if (esCorrecta) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto.");
            }
            return esCorrecta;
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
