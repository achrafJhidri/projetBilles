package exodecorateur_angryballs.maladroit.modele.outilsModele;


import java.util.Vector;

import exodecorateur_angryballs.maladroit.controllers.Observable;
import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 *
 *
 * Op�rations utiles sur les billes
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
     * @return la liste des autres billes que cetteBille, c'est-�-dire la liste de toutes les billes sauf cetteBille
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
     * @param cetteBille : une bille particuli�re
     * @param billes : une liste de billes, cette liste peut contenir cettebille
     *
     * gestion de l'�ventuelle  collision de cette bille avec les autres billes
     *
     * billes est la liste de toutes les billes en mouvement
     *
     * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond sans amortissement)
     *
     * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliqu�es dans le choc sont modifi�es
     * si renvoie false, il n'y a pas de collision et les billes sont laiss�es intactes
     * */
    public boolean  gestionCollisionBilleBille(Bille cetteBille, Vector<Bille> billes)
    {
//--- on r�cup�re d'abord dans autresBilles toutes les billes sauf cetteBille ----

        Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//--- on cherche � pr�sent la 1�re des autres billes avec laquelle cetteBille est en collision ---------------------
//-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux billes � la fois ---------------

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
     * Effectue les calculs correspondants � la collision entre la bille b1(G1,rayon1,v1,m1) et la bille b2(G2,rayon2,v2,m2)
     *
     * La m�thode laisse toujours G1 et G2 intacts.
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
//donn�es : b1 et b2 avant le choc
//r�sultats : b1 et b2 apr�s le choc
    {
        Vecteur G1G2 = Vecteur.difference(G2, G1);

        double nG1G2_2 = G1G2.normeCarr�e();

        double r = rayon1+rayon2;
        double r2 = r*r;

        if ( nG1G2_2 >= r2 )  return false;   // il n'y a pas de collision entre les 2 billes car elles sont trop �loign�es l'une de l'autre

        double  nG1G2 = Math.sqrt(nG1G2_2);

        Vecteur N = G1G2.produit(1 / nG1G2);    // vecteur unitaire sur le segment [G1 G2]

        double v1N, v2N;

        v1N = v1.produitScalaire(N);
        v2N = v2.produitScalaire(N);

        double a = v1N - v2N;

        if (a <= 0) return false;       // les billes s�loignent l'une de l'autre, la collision a donc d�j� �t� trait�e

        inout[0] = (float)a ;
// � pr�sent a > 0. a repr�sente l'intensit� du choc entre les 2 billes !!!!

// calculons les nouveaux vecteurs vitesse imm�diatement apr�s le choc

        double masseTotale = m1+m2;
        double alfa = (m1-m2)/masseTotale;
        double deuxSurM = 2/masseTotale;

        double v1Np =          alfa * v1N + m2 * deuxSurM * v2N;
        double v2Np = m1 * deuxSurM * v1N -          alfa * v2N;

        Vecteur U = N.rotationQuartDeTour();

        double v1T = v1.produitScalaire(U);
        double v2T = v2.produitScalaire(U);

        v1.set(Vecteur.combinaisonLin�aire(v1Np,  N , v1T, U));
        v2.set(Vecteur.combinaisonLin�aire(v2Np,  N , v2T, U));

        return true;

    } // collisionBilleBille
    /**
     * @param cetteBille : une bille particuli�re
     * @param billes : une liste de billes, cette liste peut contenir cettebille
     *
     * On suppose que cetteBille subit l'attraction gravitationnelle due aux billes contenues dans "billes" autres que cetteBille.
     *
     * t�che : calcule a, le vecteur acc�l�ration subi par cetteBille r�sultant de l'attraction par les autres billes de la liste.
     *
     * @return a : le vecteur acc�l�ration r�sultant
     *
     * */
    public static Vecteur gestionAcc�l�rationNewton(Bille cetteBille, Vector<Bille> billes)
    {

//--- on r�cup�re d'abord dans autresBilles toutes les billes sauf celle-ci ----

        Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//-------------- � pr�sent on r�cup�re les masses et les positions des autres billes ------------------
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

//------------------ � pr�sent on calcule le champ de gravit� exerc� par les autres billes sur cette bille ------------------

        return  MecaniquePoint.champGravit�Global( cetteBille.getPosition(),  masses, C);
    }
}
