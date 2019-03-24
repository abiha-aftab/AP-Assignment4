package javaapplication23;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author CIT
 */
public class Controllers implements ActionListener{
    Models model;
    View view;
    String a,b;
    
    public Controllers(Models model, View view, String a, String b) {
        this.a=a;
        this.b=b;
        this.model = model;
        this.view = view;
        for (JButton k : view.but) {
            k.addActionListener(this);
            //view.lab1.addActionListener(this);
        }
    }

    
    private boolean addChoice(Integer field, Value value) {
        model.setChoice(field, value);
        if(model.movCount >= 5) {
            if(model.checkBoard()) {
                //System.out.println(a+" a "+b+" b");
                view.winGame();
                view.endGame();
           
                return true;
            }
            
            if(model.movCount == 9) {
                view.endGame();
                view.setNoWinner(); 
            }
       
        } 
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Value currentPlayer = view.getCurrentPlayerValue(); 

        if (Arrays.asList(view.but).contains(e.getSource()) && currentPlayer != null) {
            Integer knobIndex = Arrays.asList(view.but).indexOf((JButton)e.getSource());
            ((JButton) e.getSource()).setText(view.getCurrentPlayerString()); 
            //view.pack();
            ((JButton) e.getSource()).setEnabled(false); //Dezaktywuje przycisk
            if(!addChoice(knobIndex, currentPlayer)) view.changePlayer();
        }
        else if(e.getSource().equals(view.lab)) {
            this.view.dispose();
            this.view = new View(a,b); 
            for (JButton k : view.but) {
            k.addActionListener(this);
            //view.lab1.addActionListener(this);
        }
            this.model = new Models();
        }
        }
    }
