package exercice_note.exe03;

import java.util.Random;

public class Exercice3 {

    public static void main(String[] args) {

        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        System.out.println("--- Matrices ---");
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
        System.out.println("Matrice 1 :");
        m1.afficher();

        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice 2 :");
        m2.afficher();

        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 :");
        m3.afficher();




        double[] myelements = new double[] { 1, 2, 3 };
        double[] myelements2 = new double[] { 2, 2 };


        System.out.println("\n--- Mes test de Vecteurs ---");
        System.out.println("--- Constructeurs et affichage de Vecteurs  ---");

        Vecteur va1 = new Vecteur(myelements);
        Vecteur va2 = new Vecteur(myelements);
        Vecteur va3 = new Vecteur(myelements2);

        va1.afficher();
        va2.afficher();
        va3.afficher();

        System.out.println();
        System.out.println("--- Test va2.setElement(1,40)  ---");
        va2.setElement(1, 40);
        va2.afficher();

        System.out.println();
        System.out.println("--- Test va2.getElement(2)  ---");
        System.out.println(va2.getElement(2));

        System.out.println();
        System.out.println("--- Test  va1.dotProduct(va2)  ---");
        System.out.println(va1.dotProduct(va2));


        System.out.println("\n--- Mes test de Matrices ---");

        System.out.println("\n--- Test constructeur et affiche ---");
        Matrice ma1 = new Matrice(4,3);
        Matrice ma2 = new Matrice(0,0);
        ma1.afficher();
        ma2.afficher();

        System.out.println("\n--- Test setCell ---");
        System.out.println("\nAvant initialisé avec random");
        Random rand = new Random();
        for(int i=0; i < 4; i++)
            for(int j=0; j < 3; j++)
                ma1.setCell(i, j, ((double)((int)(rand.nextDouble()*1000)))/100);
        ma1.afficher();
        System.out.println("\nAprès avoir ma1.setCell(1,2,2.5)");
        ma1.setCell(1, 2, 2.5);
        ma1.afficher();

        System.out.println("\n--- Test ma1.getCell(1,2) ---");
        System.out.println(ma1.getCell(1, 2));;

        System.out.println("\n--- Test ma1.getLine(1) ---");
        ma1.getLine(1).afficher();

        System.out.println("\n--- Test ma1.getCol(2) ---");
        ma1.getCol(2).afficher();

        System.out.println("\n--- Test ma3 = Matrice.identite(n) ---");
        Matrice ma3  = Matrice.identite(3);
        ma3.afficher();

        System.out.println("\n--- Test ma3.additionnerScalaire(1) ---");
        ma3.additionnerScalaire(1.0);
        ma3.afficher();

        System.out.println("\n--- Test ma4 = Matrice.identite(3) ---");
        Matrice ma4 = Matrice.identite(3);
        ma4.afficher();

        System.out.println("\n--- Test ma4.multiplierScalaire(2) ---");
        ma4.multiplierScalaire(2.0);
        ma4.afficher();

        System.out.println("\n--- Test ma1.dotProduct(m3) ---");
        ma2 = ma3.dotProduct(ma4);
        ma2.afficher();

//        System.out.println("\n--- Test ma3.dotProduct(m1) Supposer être l'erreur ---");
//        ma2 = ma3.dotProduct(ma1);
//        System.err.println(ma2);

        System.out.println("\n--- Test va3.dotProduct(va2) Supposer être l'erreur ---");
        double val = va3.dotProduct(va2);
        System.err.println(val);

    }
}
