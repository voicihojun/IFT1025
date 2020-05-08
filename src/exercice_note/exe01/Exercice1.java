package exercice_note.exe01;

public class Exercice1 {

    public static void main(String arg[]) {
        System.out.println(paiementParMois(200000, 6.5f, 360));
        System.out.println(approxPi(20000));
        System.out.println(romain(439));  //"CDXXXIX"
        System.out.println(romain(2948));  //"MMCMXLVIII"
    }

    public static float paiementParMois(float pret, float interet, int nbrMois) {
        float im = interet/(12*100);                // taux d'intérêt mensuel
        double expo = Math.pow(1+im,nbrMois);        // terme exponentiel
        double m = pret * expo * im / (expo - 1); // paiement mensuel

        return (float) m;  // imprimer le paiement mensuel
    }

    public static float approxPi(int nbrIterations) {
        float pi = 0;     // approximation de pi
        for (var i=0; i<nbrIterations; i++) {
            pi += Math.pow(-1,i) * 4/(i * 2+1); // terme à ajouter
        }

        return pi;
    }


    public static String romain(int n) {
        // Retourne un texte correspondant à la numération romaine de n, qui
        // doit être un nombre entier entre 1 et 3999

        return chiffre(n, 1000, "M", "?", "?") +
                chiffre(n, 100, "C", "D", "M") +
                chiffre(n, 10, "X", "L", "C") +
                chiffre(n, 1, "I", "V", "X");
    }

    public static String chiffre(int n, int puiss10, String un, String cinq, String dix) {
        // Retourne un texte correspondant au chiffre de n de poids puiss10.
        int c = (int) Math.floor(n/puiss10) % 10;
        if (c < 4) {
            return repeter(c, un);
        } else if (c == 4) {
            return un + cinq;
        } else if (c < 9) {
            return cinq + repeter(c-5, un);
        } else {
            return un + dix;
        }
    }


    public static String repeter(int n, String sujet) {
        // Retourne un texte qui contient n répétitions du texte sujet
        // (par exemple repeter(3,"I") retourne "III").

        String accum = "";
        for(int i = n; i > 0; i--) {
            accum += sujet;
        }

        return accum;
    }

}
