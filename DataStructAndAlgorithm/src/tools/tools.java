package tools;

import java.util.Random;

public class tools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printArray(int[] a) {
		if (a == null || a.length == 0)
			return;
		System.out.print("[");
		for (int i = 0, m = a.length; i < m; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]\n");
	}

	public static void swap(int a, int b, int[] array) {
		if (a == b)
			return;
		array[a] = array[a] ^ array[b];
		array[b] = array[a] ^ array[b];
		array[a] = array[a] ^ array[b];
	}

	public static void randomArray(int[] a) {
		if (a == null || a.length == 0)
			return;
		Random r = new Random(System.currentTimeMillis());
		final int L = a.length;
		for (int n = 0; n < L; n++) {
			tools.swap(r.nextInt(L - n), L - n - 1, a);
		}
	}

	public static int[] getRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = i;
		}
		randomArray(a);
		return a;
	}
}
