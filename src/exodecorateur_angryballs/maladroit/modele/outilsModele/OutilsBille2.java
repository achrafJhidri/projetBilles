package exodecorateur_angryballs.maladroit.modele.outilsModele;


import java.util.Vector;

import exodecorateur_angryballs.maladroit.controllers.Observable;
import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 *
 *
 * Opérations utiles sur les billes
 *
 *  ICI : IL N'Y A RIEN A CHANGER
 *
 *  */

public class OutilsBille2 extends Observable
{
    private static OutilsBille2 instance= null;

    private OutilsBille2() {
    }

    public static OutilsBille2 getInstance() {
        if ( instance == null)
            instance = new OutilsBille2();
        return instance;
    }



    /**
     * @param billes est la liste de TOUTES les billes en mouvement
     * @param cetteBille est l'une d'entre elles.
     * @return la liste des autres billes que cetteBille, c'est-à-dire la liste de toutes les billes sauf cetteBille
     *
     * */
    public static Vector<Bille> autresBilles(Bille cetteBille, Vector<Bille> billes)
    {
        Vector<Bille> autresBilles = new Vector<Bille>();

        Bille billeCourante;

        int i;

        for( i = 0; i < billes.size(); ++i)
        {
            billeCourante = billes.get(i);
            if ( billeCourante.getClef() != cetteBille.getClef())
                autresBilles.add(billeCourante);
        }

        return autresBilles;
    }


    /**
     * @param cetteBille : une bille particulière
     * @param billes : une liste de billes, cette liste peut contenir cettebille
     *
     * gestion de l'éventuelle  collision de cette bille avec les autres billes
     *
     * billes est la liste de toutes les billes en mouvement
     *
     * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
     *
     * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquées dans le choc sont modifiées
     * si renvoie false, il n'y a pas de collision et les billes sont laissées intactes
     * */
    public boolean  gestionCollisionBilleBille(Bille cetteBille, Vector<Bille> billes)
    {
//--- on récupère d'abord dans autresBilles toutes les billes sauf cetteBille ----

        Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//--- on cherche à présent la 1ère des autres billes avec laquelle cetteBille est en collision ---------------------
//-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux billes à la fois ---------------

        Bille billeCourante;

        int i;

        for ( i = 0 ; i < autresBilles.size(); ++i)
        {
            billeCourante = autresBilles.get(i);
            double[] inout = new double[1];
            if (CollisionBilleBille(    cetteBille.getPosition(),    cetteBille.getRayon(),    cetteBille.getVitesse(),    cetteBille.masse(),
                    billeCourante.getPosition(), billeCourante.getRayon(), billeCourante.getVitesse(), billeCourante.masse(),inout)) {

                Collision collision = new Collision((float)inout[0],cetteBille.getPosition(), COLLISIONTYPE.BILLE);
                this.notify(collision);
                return true;
            }
        }
        return false;
    }
    public static boolean CollisionBilleBille( final Vecteur G1, double rayon1, Vecteur v1, double m1,
                                               final Vecteur G2, double rayon2, Vecteur v2, double m2){
        return CollisionBilleBille(G1, rayon1, v1, m1, G2, rayon2, v2, m2, new double[0]);
    }

    /**
     * Effectue les calculs correspondants à la collision entre la bille b1(G1,rayon1,v1,m1) et la bille b2(G2,rayon2,v2,m2)
     *
     * La méthode laisse toujours G1 et G2 intacts.
     *
     * @param G1 : centre de la bille b1
     * @param rayon1 : rayon de la bille b1
     * @param v1 : vecteur vitesse de la bille b1
     * @param m1 : masse de la bille b1
     *
     * @param G2 : centre de la bille b2
     * @param rayon2 : rayon de la bille b2
     * @param v2 : vecteur vitesse de la bille b2
     * @param m2 : masse de la bille b2
     *
     * @return true si il y a collision et false si il n'y a pas collision
     *
     * si retourne true, modifie les vecteurs vitesse v1 et v2
     */
    public static boolean CollisionBilleBille( final Vecteur G1, double rayon1, Vecteur v1, double m1,
                                               final Vecteur G2, double rayon2, Vecteur v2, double m2,double[] inout)
//modifie b1 et b2
//données : b1 et b2 avant le choc
//résultats : b1 et b2 après le choc
    {
        Vecteur G1G2 = Vecteur.difference(G2, G1);

        double nG1G2_2 = G1G2.normeCarrée();

        double r = rayon1+rayon2;
        double r2 = r*r;

        if ( nG1G2_2 >= r2 )  return false;   // il n'y a pas de collision entre les 2 billes car elles sont trop éloignées l'une de l'autre

        double  nG1G2 = Math.sqrt(nG1G2_2);

        Vecteur N = G1G2.produit(1 / nG1G2);    // vecteur unitaire sur le segment [G1 G2]

        double v1N, v2N;

        v1N = v1.produitScalaire(N);
        v2N = v2.produitScalaire(N);

        double a = v1N - v2N;

        if (a <= 0) return false;       // les billes séloignent l'une de l'autre, la collision a donc déjà été traitée

        inout[0] = (float)a ;
// à présent a > 0. a représente l'intensité du choc entre les 2 billes !!!!

// calculons les nouveaux vecteurs vitesse immédiatement après le choc

        double masseTotale = m1+m2;
        double alfa = (m1-m2)/masseTotale;
        double deuxSurM = 2/masseTotale;

        double v1Np =          alfa * v1N + m2 * deuxSurM * v2N;
        double v2Np = m1 * deuxSurM * v1N -          alfa * v2N;

        Vecteur U = N.rotationQuartDeTour();

        double v1T = v1.produitScalaire(U);
        double v2T = v2.produitScalaire(U);

        v1.set(Vecteur.combinaisonLinéaire(v1Np,  N , v1T, U));
        v2.set(Vecteur.combinaisonLinéaire(v2Np,  N , v2T, U));

        return true;

    } // collisionBilleBille
    /**
     * @param cetteBille : une bille particulière
     * @param billes : une liste de billes, cette liste peut contenir cettebille
     *
     * On suppose que cetteBille subit l'attraction gravitationnelle due aux billes contenues dans "billes" autres que cetteBille.
     *
     * tâche : calcule a, le vecteur accélération subi par cetteBille résultant de l'attraction par les autres billes de la liste.
     *
     * @return a : le vecteur accélération résultant
     *
     * */
    public static Vecteur gestionAccélérationNewton(Bille cetteBille, Vector<Bille> billes)
    {

//--- on récupère d'abord dans autresBilles toutes les billes sauf celle-ci ----

        Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//-------------- à présent on récupère les masses et les positions des autres billes ------------------
        int i;
        Bille billeCourante;

        int d = autresBilles.size();

        double masses [] = new double[d];   // les masses des autres billes
        Vecteur C [] = new Vecteur[d];      // les positions des autres billes

        for ( i = 0; i < d; ++i)
        {
            billeCourante = autresBilles.get(i);
            masses[i] = billeCourante.masse();
            C[i] = billeCourante.getPosition();
        }

//------------------ à présent on calcule le champ de gravité exercé par les autres billes sur cette bille ------------------

        return  MecaniquePoint.champGravitéGlobal( cetteBille.getPosition(),  masses, C);
    }
}
