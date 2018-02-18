import java.util.Arrays;

class ChangeGreedy {

    public static void main(String[] args) {

	// Input

	int value, n;
	int [] coins;
	FastReader fr = new FastReader();


	value = fr.nextInt();
	n = fr.nextInt();
	coins = new int [n];

	for (int i = 0; i < n; i++) {
	    coins[i] = fr.nextInt();
	}

	// Voraz
	int [] cambio = new int [coins.length];

	System.out.println("Monedas: " + View.view(coins));
	System.out.println("Cambio : " + View.view(cambio));

	int m = coins.length - 1;
	int acc = 0;
	int n_monedas = 0;

	while (m >= 0) {
	    cambio[m] += 1;
	    acc += coins[m];
	    n_monedas += 1;

	    System.out.println("=======================");
	    System.out.println("Cambio: " + View.view(cambio));
	    System.out.println("n_monedas: " + n_monedas + "\tAcc: " + acc);


	    if (acc == value) {
		System.out.println("----------------------");
		System.out.println("Número de monedas: " + n_monedas);
		System.out.println("Monedas: " + View.view(coins));
		System.out.println("Cambio : " + View.view(cambio));
		m = -1;
	    } else if (acc > value) {
		acc -= coins[m];
		cambio[m] -= 1;
		n_monedas -= 1;
		m -= 1;
	    } // n < value
	}

	if (acc < value){
	    System.out.println("=======================");
	    System.out.println("No hay cambio.");
	}
    }
}
