package Model;

import java.util.Objects;

public class Respaldo {
    public static final int OPERADOR_RELACIONAL = 1;
    public static final int OPERADOR_ARITMETICO_SUMA_RESTA = 2;
    public static final int OPERADOR_ARITMETICO_MULTIPLICACION_DIVISION = 3;
    public static final int IGUALDAD = 4;
    public static final int DIGITO = 5;
    public static final int VARIABLE = 6;
    public static final int DECIMAL = 7;

    private int state = 0;
    private boolean accept = false;
    private String input;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Automata{" +
                "state=" + state +
                ", accept=" + accept +
                ", input='" + input + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Respaldo respaldo = (Respaldo) o;
        return state == respaldo.state &&
                accept == respaldo.accept &&
                Objects.equals(input, respaldo.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, accept, input);
    }
}
