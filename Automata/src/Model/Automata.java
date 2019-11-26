package Model;

import View.AutomataListener;

import java.util.Arrays;

public class Automata {

    int counter;
    static char [] characters;
    boolean accepted;
    StringBuilder output;
    StringBuilder states;
    StringBuilder formatter;
    AutomataListener listener;

    public Automata(AutomataListener listener){
        this.listener = listener;
    }

    public void start(String evaluation){
        output = new StringBuilder();
        states = new StringBuilder();
        formatter = new StringBuilder();
        characters = evaluation.toCharArray();
        accepted = false;
        counter = 0;
        q0();
        listener.getResult(accepted);
        listener.getCharacter(output.toString());
        listener.getStates(states.toString());
    }

    public void q0(){
        System.out.println("En q0" );
        states.append(">Q0");
        if(counter < characters.length){
            if(characters[counter] == '<' || characters[counter] == '>' || characters[counter] == '=' || characters[counter] == '*' || characters[counter] == '/'){
                output.append("Operador: "+characters[counter] +'\n');
                counter ++;
                q1();
            }

            else if(characters[counter] == '.'){
                output.append("Decimal: " + characters[counter] + '\n');
                counter++;
                q1();
            }

            else if(characters[counter] == '+'){
                output.append(" Entero positivo: "+characters[counter]);
                counter++;
                q3();
            }

            else if(characters[counter] == '-'){
                output.append(" Entero negativo: "+characters[counter] );
                counter++;
                q3();
            }

            else if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append(" Entero: " + characters[counter]);
                counter++;
                q4();
            }

            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(" Variable: " + characters[counter]);
                counter++;
                q7();
            }
        }
    }

    public void q1(){
        System.out.println("En q1");
        states.append("-->Q1");
        accepted = false;
        if(counter < characters.length){
            if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')||(characters[counter] == 0 || characters[counter] <= 9||characters[counter] == '<' || characters[counter] == '>' || characters[counter] == '=' || characters[counter] == '*' || characters[counter] == '/'||characters[counter] == '-' || characters[counter] == '+')){
                output.append("Caracter: " + characters[counter] + '\n');
                counter++;
                q1();
            }
        }
    }

    public void q2(){
        System.out.println("En q2");
        states.append("-->Q2");
        accepted = false;
        if(counter < characters.length){
            if(characters[counter] == '='){
                output.append(" Operador: "+ characters[counter] + '\n');
                counter++;
                q11();
            }
        }

    }

    public void q3(){
        System.out.println("En q3");
        accepted = false;
        states.append("-->Q3");
        if(counter < characters.length){
            if(characters[counter] == '<' || characters[counter] == '>' || characters[counter] == '=' || characters[counter] == '*' || characters[counter] == '/'||characters[counter] == '-' || characters[counter] == '+'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter ++;
                q1();
            }
            else if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append(characters[counter]);
                counter ++;
                q4();
            }

            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(" Variable: " +characters[counter] +  '\n');
                counter ++;
                q7();
            }
        }

    }

    public void q4(){
        System.out.println("En q4");
        states.append("-->Q4");
        accepted = true;
        if(counter < characters.length){
            if(characters[counter] == '+' || characters[counter] == '-' || characters[counter] == '*' || characters[counter] == '/'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q5();
            }

            else if (characters[counter] == '.'){
                output.append(" Decimal: " + characters[counter] + '\n');
                counter++;
                q9();
            }

            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(" Variable: " +characters[counter] +  '\n');
                counter ++;
                q8();
            }


            else if (characters[counter] == '='){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q12();
            }

            else if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append(characters[counter]);
                counter++;
                q4();
            }

            else{
                accepted = false;
            }

        }
    }

    public void q5(){
        System.out.println("En q5");
        states.append("-->Q5");
        accepted = false;
        if (counter < characters.length){
            if (characters[counter] == '+' || characters[counter] == '-' || characters[counter] == '*' || characters[counter] == '/'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q1();
            }
            else if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append(" Entero: " +characters[counter]);
                counter++;
                q6();
            }
        }
    }

    public void q6(){
        states.append("-->Q6");
        System.out.println("En q6");
        accepted = true;
        if(counter < characters.length){
            if(characters[counter] == '<' || characters[counter] == '>'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q2();
            }

            else if(characters[counter] == '.'){
                output.append(" Decimal: " + characters[counter] + '\n');
                counter++;
                q10();
            }
            else if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append(characters[counter]);
                counter++;
                q6();
            }
            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(" Variable: " +characters[counter] +  '\n');
                counter ++;
                q6();
            }

            else if(characters[counter] == '='){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q12();
            }
            else if (characters[counter] == '+' || characters[counter] == '-' || characters[counter] == '*' || characters[counter] == '/'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q5();
            }
        }

    }

    public void q7() {
        states.append("-->Q7");
        System.out.println("En q7");
        accepted = true;
        if (counter < characters.length) {
            if (characters[counter] == '<' || characters[counter] == '>' || characters[counter] == '*' || characters[counter] == '+' || characters[counter] == '-'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q5();
            }

            else if (characters[counter] == '=' ) {
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q12();
            }

            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')) {
            output.append(characters[counter]);
                counter++;
                q8();
            }
            else{
                accepted = false;
            }
        }
    }

    public void q8(){
        states.append("-->Q8");
        System.out.println("En q8");
        accepted = true;
        if (counter < characters.length) {
            if (characters[counter] == '=') {
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q12();
            }

            else if(characters[counter] == '+' || characters[counter] == '-' || characters[counter] == '*' || characters[counter] == '/'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q5();
            }

            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(characters[counter]);
                counter++;
                q8();
            }
        }
    }

    public void q9(){
        states.append("-->Q9");
        System.out.println("En q9");
        accepted = false;
        if(counter < characters.length){
            /*
            if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append("Entero: " + characters[counter] + '\n');
                counter++;
                q4();
            }
            */
             if(characters[counter] == '.'){
                counter ++;
                q9();
            }
        }
    }

    public void q10() {
        states.append("-->Q10");
        System.out.println("En q10");
        accepted = false;
        if (counter < characters.length) {
            if (characters[counter] >= '0' && characters[counter] <= '9') {
                output.append(" Entero: " + characters[counter] + '\n');
                counter++;
                q6();
            }
            if (characters[counter] == '.') {
                output.append(" Punto: " + characters[counter] + '\n');
                counter++;
                q10();
            }

        }
    }
    public void q11() {
        states.append("-->Q11");
        System.out.println("En q11");
        accepted = false;
        if (counter < characters.length) {
            if (characters[counter] >= '0' && characters[counter] <= '9') {
                output.append(" Entero: " +characters[counter] +  '\n');
                counter++;
                q6();
            } else if ((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')) {
                output.append(" Variable: " + characters[counter] + '\n');
                counter++;
                q8();
            }
        }
    }

    public void q12() {
        states.append("-->Q12");
        System.out.println("En q12");
        accepted = false;
        if (counter < characters.length) {
            if (characters[counter] >= '0' && characters[counter] <= '9') {
                output.append(" Entero: " + characters[counter]);
                counter++;
                q13();
            } else if ((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')) {
                output.append(" Variable: " + characters[counter]);
                counter++;
                q14();
            }
        }
    }

    public void q13() {
        System.out.println("En q13");
        states.append("-->Q13");
        accepted = true;
        if (counter < characters.length) {
            if (characters[counter] >= '0' && characters[counter] <= '9') {
                output.append(characters[counter]);
                counter++;
                q13();
            }
            else if(characters[counter] == '.'){
                output.append(" Decimal: " + characters[counter] + '\n');
                counter++;
                q13();
                accepted = false;
            }
            else if(characters[counter] == '+' || characters[counter] == '-' || characters[counter] == '*' || characters[counter] == '/'){
                output.append(" Operador: "+characters[counter] + '\n');
                counter++;
                q15();
            }
            else if(characters[counter] == '='){
                output.append(" Operador: " + characters[counter] +'\n');
                counter++;
                q1();
            }

        }
    }

    public void q14(){
        System.out.println("En q14");
        states.append("-->Q14");
        accepted = true;
        if (counter < characters.length){
            if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(characters[counter]);
                counter++;
                q14();
            }
            else if (characters[counter] == '+' || characters[counter] == '-' || characters[counter] == '*' || characters[counter] == '/'){
                output.append(" Operador: "+ characters[counter] + '\n');
                counter++;
                q15();
            }
            else if(characters[counter] == '='){
                output.append(" Operador: "+ characters[counter] + '\n');
                counter++;
                q1();
            }
        }

    }

    public void q15(){
        System.out.println("En q15");
        states.append("-->Q15");
        accepted = false;
        if (counter < characters.length){
            if(characters[counter] >= '0' && characters[counter] <= '9'){
                output.append(" Entero: " + characters[counter] + '\n');
                counter++;
                q13();
            }
            else if((characters[counter] >= 'A' && characters[counter] <= 'Z')||(characters[counter] >= 'a' && characters[counter] <= 'z')){
                output.append(" Variable: " + characters[counter] + '\n');
                counter++;
                q14();
            }
        }

    }

    public void q16() {
        System.out.println("En 16");
        states.append("-->Q16");
        accepted = false;
        if (counter < characters.length) {
            if (characters[counter] >= '0' && characters[counter] <= '9') {
                output.append(" Entero: " + characters[counter] + '\n');
                counter++;
                q16();
            }
            else if(characters[counter] == '.'){
                output.append("Decimal: " + characters[counter] + '\n');
                accepted = false;
                counter++;
                q13();
            }
        }
    }

}
