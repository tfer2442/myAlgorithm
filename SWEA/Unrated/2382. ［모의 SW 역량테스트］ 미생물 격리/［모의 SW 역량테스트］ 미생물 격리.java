import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N, M, K, time;
	public static ArrayList<Cell> cells;
	public static int[][] d = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static class Cell {
		int r, c, dir, maxValue, sum;
		
		Cell(int r, int c, int dir, int maxValue, int sum) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.maxValue = maxValue;
			this.sum = sum;
		}
	}
	
	public static void move() {
		for (Cell cell : cells) {
			cell.r = cell.r + d[cell.dir][0];
			cell.c = cell.c + d[cell.dir][1];
		}
	}
	
	public static void checkBoundary() {
		for (Cell cell : cells) {
			if (cell.r <= 0 || cell.r >= N-1 || cell.c <= 0 || cell.c >= N-1) {
				cell.sum /= 2;
				cell.maxValue = cell.sum;
				
				if (cell.dir % 2 == 0) {
					cell.dir -= 1;
				} else {
					cell.dir += 1;
				}
			}			
		}
	}
	
	public static void merge() {
		HashMap<Integer, Cell> hm = new HashMap<>();
		ArrayList<Cell> next = new ArrayList<>();
		
		for (int i = 0; i < cells.size(); i++) {
			Cell cell = cells.get(i);
			
			if (cell.sum == 0) {
				continue;
			}
			
			int key = N * cell.r + cell.c;
			
			if (!hm.containsKey(key)) {
				hm.put(key, cell);
				next.add(cell);
			} else {
				Cell cur = hm.get(key);
				
				if (cur.maxValue < cell.maxValue) {
					cur.dir = cell.dir;
					cur.maxValue = cell.maxValue;
				}
				
				cur.sum += cell.sum;
			}
		}
		
		for (int i = 0; i < next.size(); i++) {
			next.get(i).maxValue = next.get(i).sum;
		}
		
		cells = next;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cells = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				Cell cell = new Cell(r, c, dir, value, value);
				cells.add(cell);
			}
			
			for (int time = 1; time <= M; time++) {
				move();
				checkBoundary();
				merge();
			}
			
			int sum = 0;
			
			for (Cell cell : cells) {
				sum += cell.sum;
			}
			System.out.println("#" + t + " " + sum);
		}
	}

}