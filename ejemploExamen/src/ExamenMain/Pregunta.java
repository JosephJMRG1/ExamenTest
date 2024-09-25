package ExamenMain;

public abstract class Pregunta {
    private double peso;
    private String text;

    public Pregunta(String text, double peso) {
        this.text = text;
        this.peso = peso;
    }

    public double getPeso() { return peso; }

    public void setPeso(double peso) { this.peso = peso; }

    public String getText() { return text; }

    public abstract boolean buscar();
}
