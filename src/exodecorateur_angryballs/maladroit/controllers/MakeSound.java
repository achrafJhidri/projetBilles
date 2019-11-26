package exodecorateur_angryballs.maladroit.controllers;


import exodecorateur_angryballs.maladroit.modele.Collision;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MakeSound  implements Observateur, Runnable{

    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private Thread  thread ;
    private float x =-1;
    private float intensity =-1;




    public MakeSound(File soundFile) {
        this.soundFile = soundFile;
    }


    public void playSound(float intensity,double x)  {



        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }



        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);

        } catch (LineUnavailableException e ) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int demiLargeur = screenSize.width/2;

//        FloatControl pan = (FloatControl) sourceLine.getControl(Type.PAN);
//        double m= ((x-demiLargeur)/demiLargeur);
//        pan.setValue( (float)m);
        FloatControl volume = (FloatControl) sourceLine.getControl(Type.MASTER_GAIN);
        volume.setValue((20f * (float) Math.log10(intensity)));
        System.out.println("intensity="+intensity);


      /*  public float getVolume() {
        	  FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        	  return (float) Math.pow(10f, gainControl.getValue() / 20f);
        	}

        	public void setVolume(float volume) {
        	  if (volume < 0f || volume > 1f)
        	    throw new IllegalArgumentException("Volume not valid: " + volume);
        	  FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        	  gainControl.setValue(20f * (float) Math.log10(volume));
        	}
           */
        sourceLine.start();

        //boolean isPan = sourceLine.isControlSupported(Type.PAN);
        //System.err.println("Pan : "+isPan);

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

    @Override
    public void update(Observable o, Object obj) {
        if( obj instanceof Collision){
            Collision collision = (Collision) obj ;
            this.intensity = collision.chocdintensiste ;
            this.x = (float) collision.position.x;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
       playSound(this.intensity,this.x);
    }
}