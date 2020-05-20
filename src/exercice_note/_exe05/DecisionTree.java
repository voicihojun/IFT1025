package exercice_note._exe05;


import java.util.ArrayList;

public class DecisionTree {

    /**
     * Un Arbre de Décision contient seulement une référence vers la
     * racine de l'arbre
     */

    private Node root = new Node("rootdata");



    ArrayList<Node> children = null;
    ArrayList<Node> nodeList = new ArrayList<>();
    ArrayList<String> strList = new ArrayList<>();


    public DecisionTree(LabeledData[] dataset) {
        // TODO : Construire l'arbre

        // [Humain, Chante]
        // [Oiseau, Parle]
        // [Oiseau, Chante]
        // [Humain, Crie]
        // [Humain, Parle]
        // In the above dataset, one data is a field.
        // So, the fieldLength = 2.
        // And, dataset.length = 5;

        int fieldLength = dataset[0].getFields().length;

//        for(int i=0; i < fieldLength; i++) {
//            List<Node> nodeList = new ArrayList<>();
//            List<String> strList = new ArrayList<>();
//            for(int j=0; j < dataset.length; j++) {
//
//            }
//        }
        for(int i=0; i < dataset.length; i++) { // 4
            for(int j=0; j < fieldLength; j++) {  // 2
                Node n = new Node(dataset[i].getFields()[j]);
                root.addChild(n);
            }
        }
    }

    public String predict(String[] data) {
        // TODO : Faire une prédiction
        return null;
    }

    public static void main(String[] args) {

        LabeledData[] datasetSimple = new LabeledData[]{
                // [Catégorie, Son] => Résultat
                new LabeledData(new String[]{"Humain", "Chante"}, "Ginette Renaud"),
                new LabeledData(new String[]{"Humain", "Parle"}, "Jimmy Whooper"),
                new LabeledData(new String[]{"Oiseau", "Chante"}, "Rouge Gorge"),
                new LabeledData(new String[]{"Oiseau", "Parle"}, "Perroquet")
        };

        DecisionTree dt = new DecisionTree(datasetSimple);

    }
}
