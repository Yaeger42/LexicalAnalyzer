package Manager;

import Model.Automata;

public class AutomataManager {
/*
    public boolean evaluateLanguage(String input){
        Automata evaluation = new Automata();
        int actualCharacter = 0;
        evaluation.setInput(input);
        while(actualCharacter <= evaluation.getInput().length()){
            int currentInput = validateInput(evaluation.getInput().charAt(actualCharacter));
            if(evaluation.getState() == 1){
                return false;
            }
            //q0 conditions--------------------------------------------------------------------------------------------------------------------------------------------------
            if(evaluation.getState() == 0 && currentInput == Automata.OPERADOR_RELACIONAL || currentInput == Automata.IGUALDAD || currentInput == Automata.DECIMAL){
                evaluation.setState(1);
                continue;
            }
            if(evaluation.getState() == 0 && currentInput == Automata.OPERADOR_ARITMETICO_SUMA_RESTA){
                evaluation.setState(3);
                evaluation.setAccept(false);
                actualCharacter++;
                continue;
            }
            if(evaluation.getState() == 0 && currentInput == Automata.DIGITO){
                evaluation.setState(4);
                evaluation.setAccept(true);
                actualCharacter++;
                continue;
            }
            if(evaluation.getState() == 0 && currentInput == Automata.VARIABLE){
                evaluation.setState(7);
                evaluation.setAccept(true);
                actualCharacter++;
                continue;
            }
            //q3 conditions---------------------------------------------------------------------------------------------------------------------------------------------------
            if(evaluation.getState() == 0){

            }

        }
        return true;
    }

    public int validateInput(char character){
        if(character == '<' || character == '>'){
            return Automata.OPERADOR_RELACIONAL;
        }
        if(character == '+' || character == '-'){
            return Automata.OPERADOR_ARITMETICO_SUMA_RESTA;
        }
        if(character == '*' || character == '/'){
            return Automata.OPERADOR_ARITMETICO_MULTIPLICACION_DIVISION;
        }
        if(character == '='){
            return Automata.IGUALDAD;
        }
        if(Character.isDigit(character)){
            return Automata.DIGITO;
        }
        if(Character.isLetter(character)){
            return Automata.VARIABLE;
        }
        if(character == '.'){
            return Automata.DECIMAL;
        }
        return 0;
    }*/
}
