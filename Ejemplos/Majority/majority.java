import java.util.Arrays;

class Majority {
    public static int baseCase(int[] a){
	return (a[0] == a[1]) ? a[0] : -1; // devolvemos el valor mayoritario si son iguales
    }

    public static int count(int[] arr, int n){
	int r = 0;
	for (int i : arr){
	    if (i == n)
		r++;
	}
	return r;
    }
    
    public static int findMajority(int[] a, int l){
	//  l = a.length;

	/* caso base y resolución */
	if (l == 1)
	    return a[0]; // útil si la entrada es impar

	/* subdivisión de la entrada (split) */
	int mid = (int)Math.floor(l/2); // elemento central
	int elem1 = findMajority(Arrays.copyOfRange(a, 0, (int)Math.floor(l/2)), mid); // izquierda
	int elem2 = findMajority(Arrays.copyOfRange(a, (int)Math.floor(l/2), l), mid); // derecha
	
	/* unión del resultado de los casos base (merge) */
	if(elem1 == elem2)
	    return elem1; // Elementos son iguales
	if(count(a, elem1) > l/2)
	    return elem1; // Elemento 1 mayoritario
	if(count(a, elem2) > l/2)
	    return elem2; // Elemento 2 mayoritario
	
	return -1; // No hay mayoritario
    }

    public static void main(String[] args){
	int n, len;
	int [] arr;
	FastReader fr = new FastReader();

	n = fr.nextInt();
	while (n > 0){
	    len = fr.nextInt();
	    arr = new int[len];
	    for (int i = 0; i < len; i++)
		arr[i] = fr.nextInt();
	    
	    System.out.println(findMajority(arr, len));
	    n--;
	}
	
    }
}
