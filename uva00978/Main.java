/*
UVa 00978 - Lemmings Battle!
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.*;

class Soldado implements Comparable<Soldado> {
    public int id;
    public int forca;

    public Soldado(int id, int forca) {
        this.id = id;
        this.forca = forca;
    }

    public int compareTo(Soldado s) {
        if (forca > s.forca) {
            return 1;
        } else if (forca < s.forca) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int Q = reader.nextInt();
        while (Q != 0) {
            Q--;
            int i;
            int battleGrounds = reader.nextInt();
            int blues = reader.nextInt();
            int greens = reader.nextInt();
            TreeSet<Soldado> setBlue = new TreeSet<Soldado>();
            TreeSet<Soldado> setGreen = new TreeSet<Soldado>();
            for (i = 0; i < blues; i++) {
                Soldado s = new Soldado(i, reader.nextInt());
                setGreen.add(s);
            }
            for (i = 0; i < greens; i++) {
                Soldado s = new Soldado(i, reader.nextInt());
                setBlue.add(s);
            }
            boolean battle = true;
            while (battle) {
                for (i = 0; i < battleGrounds; i++) {
                    Soldado blueSoldado;
                    Soldado greenSoldado;

                    NavigableSet<Soldado> bireverse = setBlue.descendingSet();
                    Iterator<Soldado> bi = bireverse.iterator();
                    NavigableSet<Soldado> gireverse = setGreen.descendingSet();
                    Iterator<Soldado> gi = gireverse.iterator();

                    if (bi.hasNext() && gi.hasNext()) {
                        blueSoldado = bi.next();

                        greenSoldado = gi.next();

                        if (blueSoldado.forca == greenSoldado.forca) {
                            blueSoldado.forca = 0;
                            greenSoldado.forca = 0;
                        } else {
                            if (blueSoldado.forca > greenSoldado.forca) {
                                blueSoldado.forca = blueSoldado.forca - greenSoldado.forca;
                                greenSoldado.forca = 0;
                            } else {
                                greenSoldado.forca = greenSoldado.forca - blueSoldado.forca;
                                greenSoldado.forca = 0;
                            }

                        }
                    }
                    setBlue.removeIf(e -> e.forca == 0);
                    setGreen.removeIf(e -> e.forca == 0);
                    if (setBlue.size() == 0 || setGreen.size() == 0 || setBlue.size() + setGreen.size() == 0) {
                        if (setBlue.size() + setGreen.size() == 0) {
                            System.out.println("green and blue died");
                        }
                        if (setBlue.size() > setGreen.size()) {
                            System.out.println("blue wins");
                            for (Soldado bs : setBlue) {
                                System.out.println(bs.forca);
                            }
                        }
                        if (setBlue.size() < setGreen.size()) {
                            System.out.println("green wins");
                            for (Soldado gs : setGreen) {
                                System.out.println(gs.forca);
                            }
                        }
                        System.out.println("");

                        battle = false;

                    }
                }
            }

        }
        reader.close();
    }
}
