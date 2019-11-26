package View;

import Model.Automata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class UI extends JFrame implements AutomataListener{
    private JLabel output;
    private JLabel result;
    private JLabel states;
    private JTextField input = new JTextField(20);
    private Automata automata = new Automata(this);
    private JButton evaluate;

    public UI(){
        super("Validador de ecuaciones");
        //setExtendedState(MAXIMIZED_HORIZ);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Setting Labels;
        output = new JLabel("Valores ingresados: \n");
        result = new JLabel("Resultado: \n");
        states = new JLabel("Estados: \n");

        //Setting Button
        evaluate = new JButton("Evaluate");
        evaluate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                       automata.start(input.getText());
                    }
                });
                thread.start();
            }
        });

        //Setting Main Panels
        /*
        setLayout(new BorderLayout());
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new BorderLayout());
        add(registrationPanel, BorderLayout.NORTH);

        registrationPanel.add(input, BorderLayout.WEST);
        registrationPanel.add(output, BorderLayout.CENTER);
        registrationPanel.add(result, BorderLayout.EAST);
        registrationPanel.add(evaluate, BorderLayout.SOUTH);
        registrationPanel.setVisible(true);
        */
        setLayout(new BorderLayout());
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new FlowLayout());
        add(registrationPanel);
        registrationPanel.add(input);
        registrationPanel.add(output);
        registrationPanel.add(result);
        registrationPanel.add(evaluate);
        registrationPanel.add(states);
        registrationPanel.setVisible(true);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UI();
            }
        });

       // System.out.println(Pattern.matches("[a-zA-Z]*", "eeee1"));
    }

    @Override
    public void getResult(boolean result) {
        if(!this.result.getText().equals("Resultado: \n")){
            this.result.setText("Resultado: \n");
            this.states.setText("Estados: \n");
        }
        this.result.setText(this.result.getText() + result);
        this.states.setText(this.states.getText() + states);
    }

    @Override
    public void getCharacter(String output) {
        if(!this.output.getText().equals("Valores ingresados:\n ")){
            this.output.setText("Valores ingresados: \n");
        }
        this.output.setText(this.output.getText() + output);
        this.states.setText(this.states.getText() + states) ;
    }

    @Override
    public void getStates(String states) {
        if(!this.states.getText().equals("States:\n ")){
            this.states.setText("Estados: \n");
        }
        this.states.setText(this.states.getText() + states) ;
    }
}