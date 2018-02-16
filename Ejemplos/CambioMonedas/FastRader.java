// https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// Imports solo para leer decentemente.
// Por algo amamos Java para aprender a programar (no).

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
	br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
	while (st == null || !st.hasMoreElements()){
	    try {
		st = new StringTokenizer(br.readLine());
	    } catch (IOException e) {
		System.out.println("Error " + e.getMessage());
	    }
	}
	return st.nextToken();
    }

    int nextInt(){
	return Integer.parseInt(next());
    }

    long nextLong(){
	return Long.parseLong(next());
    }

    double nextDouble(){
	return Double.parseDouble(next());
    }

    String nextLine(){
	String str = "";
	try {
	    str = br.readLine();
	}
	catch (IOException e) {
	    System.out.println("Error " + e.getMessage());
	}
	return str;
    }
}
