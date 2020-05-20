package demo.demo5;

public class Noeud<E> {
    public E valeur;
    public Noeud prochain;

    public Noeud(E valeur) {
        this.valeur = valeur;
        this.prochain = null;
    }
}
