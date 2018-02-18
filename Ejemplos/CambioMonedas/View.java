class View {

    public static String view(int [] a){
	String str = "[";
	for (int i = 0; i < (a.length - 1); i++) {
	    str += a[i] + ", ";
	}
	return str + a[a.length - 1] + "]";
    }
}
