class Activity {
    /* Selector de actividades usando un método voraz:
       ENTRADA: n -> número total de actividades
       s[n] -> tiempo de inicio de actividad |
                                             | -> ordenados de menor a mayor
       f[n] -> tiempo de finalización        |
       SALIDA: Conjunto máximo de actividades realizables, una cada vez
    */
    
    // Por comodidad implementamos una clase tupla para devolver los resultados
    static class Tuple {
	public final int x;
	public final int y;
	
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
	
	public String toString() {
	    return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
	}
    }

    public static Tuple[] maxActivities(int n, int[] s, int[] f) {
        // Conjunto de candidatos: tupla formada por s[i], f[i]
        Tuple[] res = new Tuple[n]; // Conjunto solución (empieza vacío)
	int j = 0; 
	// Elegimos de forma sistemática el primer elemento (está ordenado)
	res[0] = new Tuple(s[0], f[0]);

	// Selección de candidatos
	for (int i = 1; i < n; i++) {
	    // test de factibilidad: si no se solapan los horarios elegimos
	    if (s[i] >= f[j]) {
		res[i] = new Tuple(s[i], f[i]);
		j = i;
	    }
	}
	// El conjunto rechazado es el que no está en el conjunto solución (evidentemente)
	return res;
    }

    public static void main(String[] args) {
	int n;
	int [] s, f;
	FastReader fr = new FastReader();

	n = fr.nextInt();
	s = new int[n];
	f = new int[n];
	
	for (int i = 0; i < n; i++)
	    s[i] = fr.nextInt();

	for (int i = 0; i < n; i++)
	    f[i] = fr.nextInt();

	Tuple[] result = maxActivities(n, s, f);
	for (Tuple i : result) {
	    if (i != null)
		System.out.print(i.toString());
	}
    }
}
