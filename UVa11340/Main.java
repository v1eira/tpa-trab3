import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();

        for (int i = 0; i < n; i++) {
            float payment = 0;
            int k = read.nextInt();
            String[][] paidCharacters = new String[k][2];
            

            for (int j = 0; j < k; j++) {
                paidCharacters[j][0] = read.next();
                paidCharacters[j][1] = read.next();
            }

            int m = read.nextInt();

            for (int x = 0; x <= m; x++) {
                String line = read.nextLine();
                for (int y = 0; y < line.length(); y++) {
                    String character = Character.toString(line.charAt(y));
                    for (int z = 0; z < paidCharacters.length; z++) {
                        if (character.equals(paidCharacters[z][0])) {
                            payment = payment + Integer.parseInt(paidCharacters[z][1]);
                            break;
                        }
                    }
                }
            }
            payment = payment / 100;
            String money = String.format(java.util.Locale.US,"%.2f", payment);
            System.out.println(money + "$");
        }

        read.close();
    }
}