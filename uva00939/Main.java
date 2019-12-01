/*
UVa 00939 - Genes
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

        for (int i = 0; i < N; i++) {
            firstWord = read.next();
            secondWord = read.next();

            if (secondWord.equals("dominant") || secondWord.equals("recessive") || secondWord.equals("non-existent")) {
                Person p = new Person(firstWord, secondWord);
                people.add(p);
            }
            else {
                int index = personIsIn(people, secondWord);
                if (index >= 0) {
                    Person p = people.get(index);
                    p.parents[1][0] = firstWord;
                    p.parents[1][1] = getPersonGene(people, firstWord);
                    p.getGene();
                }
                else {
                    Person p = new Person(secondWord);
                    p.parents[0][0] = firstWord;
                    p.parents[0][1] = getPersonGene(people, firstWord);
                    people.add(p);
                }
            }
        }

        read.close();

        Collections.sort(people);

        for (int k = 0; k < people.size(); k++) {
            System.out.println(people.get(k).name + " " + people.get(k).gene);
        }
    }

    private static class Person implements Comparable<Person> {
        public String name;
        public String gene = "";
        public String[][] parents;

        public Person (String name) {
            this.name = name;
            this.parents = new String[2][2];
        }

        public Person (String name, String gene) {
            this.name = name;
            this.gene = gene;
        }

        public String getGene() {
            if (this.gene.equals("") && this.parents.length == 2) {
                int dominant = 0;
                int recessive = 0;
                for (int i = 0; i < 2; i++) {
                    if (this.parents[i][1] == "dominant")
                        dominant += 1;
                    if (this.parents[i][1] == "recessive")
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
            if (pl.get(i).name == name)
                return pl.get(i).gene;
        }
        return "";
    }

    public static int personIsIn(ArrayList<Person> pl, String name) {
        for (int i = 0; i < pl.size(); i++) {
            if (pl.get(i).name == name)
                return i;
        }
        return -1;
    }
}