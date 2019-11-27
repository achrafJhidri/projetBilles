package exodecorateur_angryballs.maladroit.vues;

import exodecorateur_angryballs.maladroit.Interupteur;
import exodecorateur_angryballs.maladroit.controllers.Observable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends Observable implements ActionListener {
    public Button button ;
    private Interupteur action ;

    public MyButton(String label,Interupteur action){
        this.action=action ;
        button = new Button(label);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        notify(action);
    }
}
