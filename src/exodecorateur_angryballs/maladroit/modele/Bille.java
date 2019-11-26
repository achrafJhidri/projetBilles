package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;


import java.util.Vector;

public interface Bille {
    Vecteur getPosition();
    double getRayon();
    Vecteur getAcceleration();
    void setAcceleration(Vecteur a);
    int getClef();
    double masse();
    Vecteur getVitesse();
    void setVitesse(Vecteur v);
    void d�placer(double deltaT);
    void gestionAcc�l�ration(Vector<Bille> billes);
    boolean gestionCollisionBilleBille(Vector<Bille> billes);
    void collisionContour(double abscisseCoinHautGauche,double ordonn�eCoinHautGauche,double largeur,double hauteur);
    void dessine(Dessinateur g);
    Bille getWrappedBille();
    @Override
    String toString();

    Color getCouleur();
}
