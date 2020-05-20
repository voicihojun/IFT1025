package exercice_note._exe05;

import java.util.Arrays;

public class TestDecisionTree {

    public static void main(String[] args) {

        testSimple();
        System.out.println("-----");
        testTemperatures();
        System.out.println("-----");
        testMusique();
    }

    public static void testSimple() {
        LabeledData[] datasetSimple = new LabeledData[]{
            // [Catégorie, Son] => Résultat
            new LabeledData(new String[]{"Humain", "Chante"}, "Ginette Renaud"),
            new LabeledData(new String[]{"Humain", "Parle"}, "Jimmy Whooper"),
            new LabeledData(new String[]{"Oiseau", "Chante"}, "Rouge Gorge"),
            new LabeledData(new String[]{"Oiseau", "Parle"}, "Perroquet")
        };

        // Création de l'arbre de décision à partir des données
        DecisionTree decisionTree = new DecisionTree(datasetSimple);

        String[][] testData = new String[][]{
            new String[]{"Humain", "Parle"}, // Jimmy Whooper
            new String[]{"Humain", "Chante"}, // Ginette Renaud
            new String[]{"Oiseau", "Parle"}, // Perroquet
            new String[]{"Oiseau", "Chante"}, // Rouge Gorge
            new String[]{"Humain", "Crie"} // Je ne sais pas
        };

        for (String[] data : testData) {
            String prediction = decisionTree.predict(data);

            System.out.println(Arrays.toString(data) + " => " + prediction);
        }
    }

    public static void testTemperatures() {
        LabeledData[] dataset = new LabeledData[]{
            // Données dérivées de https://gerardnico.com/data_mining/weather
            new LabeledData(new String[]{"Ciel Couvert", "Chaud", "Humide", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ciel Couvert", "Froid", "Sec", "Venteux"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ciel Couvert", "Moyen", "Humide", "Venteux"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ciel Couvert", "Moyen", "Humide", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ciel Couvert", "Chaud", "Sec", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Pluvieux", "Moyen", "Humide", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Pluvieux", "Froid", "Sec", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Pluvieux", "Froid", "Sec", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Pluvieux", "Moyen", "Sec", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Pluvieux", "Moyen", "Humide", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Chaud", "Humide", "Calme"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Chaud", "Humide", "Calme"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Chaud", "Humide", "Calme"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Chaud", "Humide", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Chaud", "Humide", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Humide", "Calme"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Humide", "Calme"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Froid", "Sec", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ensoleillé", "Froid", "Sec", "Calme"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, "Étudier Dans Le Salon..."),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, "Jouer Dehors !"),
            new LabeledData(new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, "Jouer Dehors !")
        };

        // Création de l'arbre de décision à partir des données
        DecisionTree decisionTree = new DecisionTree(dataset);

        String[][] testData = new String[][]{
            new String[]{"Ensoleillé", "Froid", "Sec", "Calme"}, // Jouer Dehors !
            new String[]{"Pluvieux", "Moyen", "Humide", "Venteux"}, // Étudier Dans Le Salon...
            new String[]{"Ciel Couvert", "Moyen", "Humide", "Venteux"}, // 50% Jouer Dehors !, 50% Étudier Dans Le Salon...
            new String[]{"Ensoleillé", "Moyen", "Humide", "Calme"}, // Étudier Dans Le Salon...
            new String[]{"Ensoleillé", "Moyen", "Sec", "Venteux"}, // 67% Jouer dehors, 33% Étudier
            new String[]{"Ciel Couvert", "Moyen", "Humide", "Venteux"}, // 50% Jouer dehors, 33% Étudier
        };

        for (String[] data : testData) {
            String prediction = decisionTree.predict(data);

            System.out.println(Arrays.toString(data) + " => " + prediction);
        }
    }

    public static void testMusique() {

        /*
         * TODO : lire le fichier musique.txt qui contient des données dans le
         * format :
         *
         * [Décénie] [Tempo] [Mode] [Nom d'artiste]
         *
         * Par exemple :
         *
         * 1970 140 0 Pink Floyd
         *
         * Pour une chanson de Pink Floyd sortie dans les années 70, qui a un
         * tempo dans les 140bpm, en mineur (mode=0)
         *
         * Notez: vous n'avez pas besoin de comprendre les détails des
         * caractéristiques musicales d'une chanson pour cet exercice
         * L'important est que vous arriviez à un arbre de décision qui peut
         * reconnaître tout seul l'artiste derrière une chanson à partir de
         * caractéristiques arbitraires
         */

        /* Quelques tests possibles pour valider votre arbre :
            [1960, 120, 1] => Pink Floyd
            [1980, 140, 1] => 50% Metallica, 50% Céline Dion
            [1990, 100, 0] => 50% Pink Floyd, 50% Céline Dion
            [1990, 100, 1] => Céline Dion
            [2000, 190, 0] => Metallica
            [2000, 120, 1] => 50% Metallica, 50% Céline Dion
            [2000, 100, 1] => 22% Metallica, 78% Céline Dion
            [1960, 160, 0] => Pink Floyd
        */
    }
}
