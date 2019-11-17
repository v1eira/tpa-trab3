/*
UVa 11988
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        LinkedList<Character> lista = new LinkedList<Character>();

        String linha;
        while (read.hasNext()) {
            linha = read.next();
            int cursor = 0;
            for (char i : linha.toCharArray()) {
                if (i == '[') {
                    cursor = 0;
                }
                if (i == ']') {
                    cursor = lista.size();
                }
                if (i != '[' && i != ']') {
                    lista.add(cursor, i);
                    cursor++;
                }
            }
            StringBuilder string = new StringBuilder();
            Iterator<?> it = lista.listIterator();
            while (it.hasNext()) {
                string.append(it.next());
            }
            System.out.println(string);

            lista = new LinkedList<Character>();
        }
        read.close();
    }
}