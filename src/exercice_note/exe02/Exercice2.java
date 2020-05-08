package exercice_note.exe02;

import java.util.Scanner;

public class Exercice2 {

    public static void main(String args[]) {

        int tab[] = new int[100];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez les nombres à trier (entrez 0 pour arrêter) :");

        int input;
        int idx = 0;

        while(true) {
            input = scanner.nextInt();
            if(input != 0) {
                tab[idx] = input;
                idx++;
            } else {
                idx--;
                break;
            }
        }

        if(tab[0] == 0) {
            System.out.println("there is nothing to be entered!");
        } else {
            int[] nouveau_tab = new int[idx+1];
            for(int i=0; i < nouveau_tab.length; i++) {
                nouveau_tab[i] = tab[i];
            }

            System.out.println("Les nombres sont : ");
            for(int i=0; i < nouveau_tab.length; i++) {
                if(i != nouveau_tab.length - 1) {
                    System.out.print(tab[i] + ", ");
                } else {
                    System.out.println(tab[i]);
                }
            }

            System.out.println("Les nombres triés sont : ");


            nouveau_tab = trier(nouveau_tab);
            for(int i=0; i < nouveau_tab.length; i++) {
                if(i != nouveau_tab.length - 1) {
                    System.out.print(nouveau_tab[i] + ", ");
                } else {
                    System.out.println(nouveau_tab[i]);
                }
            }
        }
    }

//    a) Écrire une fonction trier() qui trie en ordre croissant le tableau
//    passé en paramètre.
//            Assurez-vous de retourner un nouveau tableau trié et de ne pas
//    modifier celui passé en paramètre

    public static int[] trier(int[] tab) {
//        int result[] = new int[tab.length];
        int min = 0;
        int min_index = 0;

        for(int i=0; i < tab.length - 1; i++) {
            min = tab[i];
            min_index = i;
            for(int j=i+1; j < tab.length; j++) {
                if(tab[j] < min) {
                    min = tab[j];
                    min_index = j;
                }
            }
            tab[min_index] = tab[i];
            tab[i] = min;
        }

        return tab;
    }
}
