package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, a, b;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edges = new int[n + 1];
		
		for(int i = 1; i <= n; i++)
			edges[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(i == edges[i])
				cnt++;
		}
		System.out.println(cnt);
	}
	
	private static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		edges[b] = a;
	}
	
	private static int findSet(int n) {
		if(n != edges[n])
			edges[n] = findSet(edges[n]);
		return edges[n];
	}

}
