/*
UVa 00939 - Genes
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int N = read.nextInt();

        String firstWord, secondWord;
        ArrayList<Person> people = new ArrayList<>();
        int parents = 0;

        for (int i = 0; i < N; i++) {
            firstWord = read.next();
            secondWord = read.next();

            if (secondWord.equals("dominant") || secondWord.equals("recessive") || secondWord.equals("non-existent")) {
                Person p = new Person(firstWord, secondWord);
                people.add(p);
                parents += 1;
            }
            else {
                int index = personIsIn(people, secondWord);
                if (index >= 0)
                    people.get(index).parents[1][0] = firstWord;
                else {
                    Person p = new Person(secondWord);
                    p.parents[0][0] = firstWord;
                    people.add(p);
                }
            }
        }

        int count = 0;

        do {
            for (int i = 0; i < people.size(); i++) {
                Person p = people.get(i);
                if (p.parents[0][0] != null && ((p.parents[0][1] == null || p.parents[0][1].equals("none")) || (p.parents[1][1] == null || p.parents[1][1].equals("none")))) {
                    p.parents[0][1] = getPersonGene(people, p.parents[0][0]);
                    p.parents[1][1] = getPersonGene(people, p.parents[1][0]);
                    
                    if (p.parents[0][1].equals("none") || p.parents[1][1].equals("none"))
                        continue;
                    else {
                        p.getGene();
                        count += 1;
                    }
                }
            }
        } while (count < (people.size() - parents));

        read.close();

        Collections.sort(people);

        for (int k = 0; k < people.size(); k++) {
            System.out.println(people.get(k).name + " " + people.get(k).gene);
        }
    }

    private static class Person implements Comparable<Person> {
        public String name;
        public String gene = "none";
        public String[][] parents = new String[2][2];

        public Person (String name) {
            this.name = name;
            this.parents[0][0] = null;
            this.parents[0][1] = null;
            this.parents[1][0] = null;
            this.parents[1][1] = null;
        }

        public Person (String name, String gene) {
            this.name = name;
            this.gene = gene;
            this.parents[0][0] = null;
            this.parents[0][1] = null;
            this.parents[1][0] = null;
            this.parents[1][1] = null;
        }

        public String getGene() {
            if (this.gene.equals("none") && this.parents.length == 2) {
                int dominant = 0;
                int recessive = 0;
                for (int i = 0; i < 2; i++) {
                    if (this.parents[i][1].equals("dominant"))
                        dominant += 1;
                    if (this.parents[i][1].equals("recessive"))
                        recessive += 1;
                }
                if (dominant == 2 || (dominant == 1 && recessive == 1))
                    this.gene = "dominant";
                else if (dominant > 0 || recessive == 2)
                    this.gene = "recessive";
                else
                    this.gene = "non-existent";
            }
            return this.gene;
        }

        @Override
        public int compareTo(Person b) {                
            return this.name.compareTo(b.name);
        }
    }

    public static String getPersonGene(ArrayList<Person> pl, String name) {
        for (int i = 0; i < pl.size(); i++) {
            if (pl.get(i).name.equals(name))
                return pl.get(i).gene;
        }
        return "none";
    }

    public static int personIsIn(ArrayList<Person> pl, String name) {
        for (int i = 0; i < pl.size(); i++) {
            if (pl.get(i).name.equals(name))
                return i;
        }
        return -1;
    }
}