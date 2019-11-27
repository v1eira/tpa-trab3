/*
UVa 10258 - Contest Scoreboard
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int tests = read.nextInt();
        
        String line;

        String[] array = new String[4];

        line = read.nextLine();
        line = read.nextLine();

        for (int i = 0; i < tests; i++) {
            ArrayList<Entry> input = new ArrayList<Entry>();
            ArrayList<Entry> correct = new ArrayList<Entry>();
            ArrayList<Output> testOut = new ArrayList<Output>();
            ArrayList<Integer> idSolved = new ArrayList<Integer>();
            int id, problem, position, time = 0, nproblems = 0, lastId = 0, lastProblem = 0, p = 0;
            boolean first = true;

            while (read.hasNext()) {
                line = read.nextLine();
                if (!line.isEmpty()) {
                    array = line.split(" ");
                    Entry e = new Entry();
                    e.contestant = Integer.parseInt(array[0]);
                    e.problem = Integer.parseInt(array[1]);
                    e.time = Integer.parseInt(array[2]);
                    e.L = array[3];
                    e.pos = p;

                    if (e.L.equals("C")) {
                        correct.add(e);
                        idSolved.add(e.contestant);
                    }
                    else
                        input.add(e);

                } else {
                    break;
                }

                p += 1;
            }

            if (correct.size() > 0) {
                Collections.sort(correct);

                for (int j = 1; j < correct.size(); j++) {
                    Entry a = correct.get(j-1);
                    Entry b = correct.get(j);

                    if (a.contestant == b.contestant && a.problem == b.problem)
                        correct.remove(j);
                }

                for (int j = 0; j < correct.size(); j++) {
                    id = correct.get(j).contestant;
                    problem = correct.get(j).problem;
                    position = correct.get(j).pos;

                    if (first)
                        time = correct.get(j).time;
                    else if (id != lastId) {
                        Output out = new Output();
                        out.id = lastId;
                        out.problemsSolved = nproblems;
                        out.time = time;
                        testOut.add(out);
                        
                        time = correct.get(j).time;
                        nproblems = 0;
                    } else
                        time += correct.get(j).time;

                    if (problem != lastProblem || id != lastId)
                        nproblems += 1;

                    for (int k = 0; k < input.size(); k++) {
                        if (input.get(k).contestant == id && input.get(k).problem == problem) {
                            if (input.get(k).L.equals("I") && input.get(k).pos < position)
                                time += 20;
                            else if (input.get(k).L.equals("C"))
                                time += input.get(k).time;
                        }
                    }

                    lastId = id;
                    lastProblem = problem;
                    first = false;
                }
                
                Output out = new Output();
                out.id = lastId;
                out.problemsSolved = nproblems;
                out.time = time;
                testOut.add(out);

                Collections.sort(testOut);

                for (int j = 0; j < testOut.size(); j++) {
                    System.out.println(testOut.get(j).id + " " + testOut.get(j).problemsSolved + " " + testOut.get(j).time);
                }
            }

            Collections.sort(input);

            for (int j = 0; j < input.size(); j++) {
                if (!(idSolved.contains(input.get(j).contestant))) {
                    System.out.println(input.get(j).contestant + " 0 0");
                    idSolved.add(input.get(j).contestant);
                }
            }

            if (i < tests-1)
                System.out.println();
        }

        read.close();
    }

    public static class Entry implements Comparable<Entry> {
        int contestant;
        int problem;
        int time;
        String L;
        int pos;

        @Override
        public int compareTo(Entry b) {
            if (this.contestant < b.contestant)
                return -1;
            else if (this.contestant > b.contestant)
                return 1;
            else {
                if (this.problem < b.problem)
                    return -1;
                else if (this.problem > b.problem)
                    return 1;
                else {
                    if (this.time < b.time)
                        return -1;
                    else
                        return 1;
                }
            }
        }
    }

    public static class Output implements Comparable<Output> {
        int id;
        int problemsSolved;
        int time;

        @Override
        public int compareTo(Output b) {
            if (this.problemsSolved > b.problemsSolved)
                return -1;
            else if (this.problemsSolved < b.problemsSolved)
                return 1;
            else {
                if (this.time < b.time)
                    return -1;
                else if (this.time > b.time)
                    return 1;
                else {
                    if (this.id < b.id)
                        return -1;
                    else
                        return 1;
                }
            }
        }
    }
}