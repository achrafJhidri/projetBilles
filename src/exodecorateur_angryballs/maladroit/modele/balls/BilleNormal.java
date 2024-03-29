    package exodecorateur_angryballs.maladroit.modele.balls;

import exodecorateur_angryballs.maladroit.modele.outilsModele.Collision;
import exodecorateur_angryballs.maladroit.modele.outilsModele.Color;
import exodecorateur_angryballs.maladroit.modele.outilsModele.OutilsBille;
import exodecorateur_angryballs.maladroit.vues.Dessinateur;
import exodecorateur_angryballs.maladroit.vues.SoundCollisionBB;
import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class BilleNormal implements Bille {
    private Vecteur position;
    private double rayon ;
    private Vecteur vitesse;
    private Vecteur acceleration;
    private int cle;
    private Color couleur;


    private static int nextkey = 0 ;
    private final static double ro = 1;

    protected BilleNormal(Vecteur position, double rayon, Vecteur vitesse,Vecteur acceleration,Color couleur) {
        this.position = position;
        this.rayon = rayon;
        this.vitesse = vitesse;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.cle=nextkey++;
    }
    public BilleNormal(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
        this(position,rayon,vitesse,new Vecteur(0,0),couleur);
    }

    @Override
    public Vecteur getPosition() {
        return position;
    }

    @Override
    public double getRayon() {
        return rayon;
    }

    @Override
    public Vecteur getAcceleration() {
        return acceleration;
    }

    @Override
    public void setAcceleration(Vecteur a) {
        this.acceleration=a;
    }

    @Override
    public int getClef() {
        return cle;
    }

    public Color getCouleur() {
        return couleur;
    }


    @Override
    public double masse() {
        return ro* Geop.volumeSphère(rayon);
    }

    @Override
    public Vecteur getVitesse() {
        return vitesse;
    }

    @Override
    public void setVitesse(Vecteur v) {
        this.vitesse=v;
    }

    @Override
    public void déplacer(double deltaT) {
        Cinematique.mouvementUniformémentAccéléré(position,vitesse,acceleration,deltaT);
    }

    @Override
    public void gestionAccélération(Vector<Bille> billes) {
        acceleration.set(Vecteur.VECTEURNUL);
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        double[] inout = new double[1];
        if( OutilsBille.gestionCollisionBilleBille(this,billes,inout)){
            Collision collision = new Collision((float)inout[0],position);
                SoundCollisionBB.getInstance().notify(collision);
            return true;
        }
        return false ;
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {

    }

    @Override
    public void dessine(Dessinateur dessinateur) {

            dessinateur.visite(this);
    }

    @Override
    public Bille getWrappedBille() {
        return null;
    }
}
