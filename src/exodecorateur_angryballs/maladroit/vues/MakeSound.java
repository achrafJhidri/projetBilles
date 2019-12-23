package exodecorateur_angryballs.maladroit.vues;


import exodecorateur_angryballs.maladroit.controllers.Observable;
import exodecorateur_angryballs.maladroit.controllers.Observateur;
import exodecorateur_angryballs.maladroit.modele.outilsModele.Collision;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.io.File;

public class MakeSound  implements Observateur, Runnable{


    static {
        JFXPanel fxPanel = new JFXPanel();
    }

    private Thread  thread ;
    private float x =-1;
    private float intensity =-1;
    private Media media ;
    private File file;

    public MakeSound(File billeBille) {
        file=billeBille;

    }

    public void PlaySound (  double volume , double balance ) {
        media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int demiLargeur = screenSize.width/2;
        double m= ((balance-demiLargeur)/demiLargeur);


        mediaPlayer.balanceProperty().setValue(m);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
    }




    @Override
    public void update(Observable o, Object obj) {
        if( obj instanceof Collision){
            Collision collision = (Collision) obj ;
            this.intensity = collision.intensity;
            this.x = (float) collision.position.x;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        PlaySound(this.intensity,this.x);
    }
}