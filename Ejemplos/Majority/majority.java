import java.util.Arrays;

class Majority {
    public static int baseCase(int[] a){
	return (a[0] == a[1]) ? a[0] : -1; // devolvemos el valor mayoritario si son iguales
    }

    public static int findMajority(int[] a){
	int l = a.length;

	/* caso base y resolución */
	if (l == 2)
	    return baseCase(a);
	else if (l == 1)
	    return a[0]; // útil si la entrada es impar

	/* subdivisión de la entrada (split) */
	int elem1 = findMajority(Arrays.copyOfRange(a, 0, (int)Math.floor(l/2)));
	int elem2 = findMajority(Arrays.copyOfRange(a, (int)Math.floor(l/2), l));

	/* unión del resultado de los casos base (merge) */
	if (elem1 == -1 && elem2 >= 0)
	    return elem2;
	if ((elem2 == -1 && elem1 >= 0) || (elem1 == elem2))
	    return elem1;
	else
	    return -1;
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
	    
	    System.out.println(findMajority(arr));
	    n--;
	}
	
    }
}
