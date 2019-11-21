package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.util.Vector;

public interface Bille {
    static final double EPSILON = 1.0E-6;
    Vecteur getPosition();
    double getRayon();
    Vecteur getAcceleration();
    int getClef();
    double masse();
    Vecteur getVitesse();
    void setVitesse(Vecteur v);
    void d�placer(double deltaT);
    void gestionAcc�l�ration(Vector<Bille> billes);
    boolean gestionCollisionBilleBille(Vector<Bille> billes);
    void collisionContour(double abscisseCoinHautGauche,double ordonn�eCoinHautGauche,double largeur,double hauteur);
    void dessine(Graphics g);
    @Override
    String toString();
}
