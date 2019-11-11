import java.util.*;

class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        int L = scan.nextInt();
		while (K !=0 && L != 0) {
            int cont = 0;
			Set<Integer> conjunto = new HashSet<Integer>();
			for (int i = 0; i < K; i++) {
                int k_cd = scan.nextInt();
				conjunto.add(k_cd);
			}
			for (int i = 0; i < L; i++) {
                    int l_cd = scan.nextInt();
				if (conjunto.contains(l_cd)) {
					cont = cont+1;
				}
			}
            
            System.out.println(cont);
            K = scan.nextInt();
            L = scan.nextInt();
		}
	}
}