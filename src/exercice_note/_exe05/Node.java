package exercice_note._exe05;


import java.util.ArrayList;

public class Node {
    // TODO : Ajouter des attributs
    private String data;
    private Node parent;
    private ArrayList<Node> children;
    private int level;

    // TODO : Ajouter un constructeur
    public Node(String data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
        this.level = 0;

    }

    // TODO : Compléter
    public String predict(String[] data) {
        return null;
    }

    public String getData() {
        return this.data;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void addChild(Node child) {
        if(!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



}
