class ChangeDP {

    public static int min (int [] a) {
	int m = a[0];
	for (int i = 0; i < a.length; i++) {
	    if (m > a[i]) m = a[i];
	}
	return m;
    }

    public static int change (int value, int [] coins, int [] table) { // value < table.length
	if (value < 0) return 10000000; // Simplemente un numero grande para evitar cambio negativo
	if (value == 0) return 0;
	if (table[value] != 0) return table[value]; // Estado ya visitado

	// Nuevo estado, calculamos el minimo cambio para el estado

	int [] ans = new int [coins.length];

	for (int i = 0; i < coins.length; i++) {
	    ans[i] = 1 + change(value - coins[i], coins, table);
	}
	int r = min(ans);
	table[value] = r;
	System.out.println("-\t" + View.view(table));

	return r;

    }

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

	// DP

	int [] min_tab = new int [value + 1]; // [0 .. value]

	System.out.println("Tabla:\t" + View.view(min_tab));

	int cambio_DP = change(value, coins, min_tab);

	System.out.println("Número de monedas: " + cambio_DP);
	System.out.println("Tabla:\t" + View.view(min_tab) + "  (FIN)");

    }

}
