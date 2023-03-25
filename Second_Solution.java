package misc;

public class main_misc {

	public static void main(String[] args) {
		//
	int[][] v = {{5,10},{15,20},{0,30}};
	/*int[][] r = organize(v);
	quickSort(r,0,r.length-1);
	for(int i = 0;i < r.length;i++) {
		for(int j = 0;j < r[i].length;j++) {
			System.out.print(r[i][j]);
			System.out.print(" ");
		}
		System.out.println();
	}*/
	System.out.println(min_num_mrooms(v));
	
	
		
	
		

	}
	//The idea is:if a value is the start of an interval we need 1 more room
	//if the value is the end of an interval we need 1 less room,the maximum number of current rooms is the answer
	private static int[][] organize(int[][]v){
		//
		int[][] r = new int[v.length*2][2];
		int idx = 0;
		for(int i = 0;i < v.length;i++) {
			r[idx][0] = v[i][0];
			r[idx][1] = 1;
			idx++;
			r[idx][0] = v[i][1];
			r[idx][1] = -1;
			idx++;
		}
		return r;
		
	}
	
	private static void swap(int[][]v,int i,int j) {
		int a = v[i][0];
		int b = v[i][1];
		v[i][0] = v[j][0];
		v[i][1] = v[j][1];
		v[j][0] = a;
		v[j][1] = b;
	}
	private static void quickSort(int[][]v,int strt,int end) {
		
		if(strt >= end) {
			return;
		}
		int p = v[end][0];
		int l = strt;
		int r = end;
		while(l < r) {
			while(v[l][0] <= p && l < r) {
				l++;
			}
			while(v[r][0] >= p && l < r) {
				r--;
			}
			swap(v,l,r);
		}
		if(v[l][0] > v[end][0]) {
			swap(v,l,end);
		}
		else {
			l = end;
		}
		quickSort(v,strt,l-1);
		quickSort(v,l+1,end);
	}
	private static int min_num_mrooms(int[][]v) {
		//
		int [][] r = organize(v);
		quickSort(r,0,r.length-1);
		int curr = 0;
		int max = 0;
		for(int i = 0;i < r.length;i++){
			//
			curr += r[i][1];
			if(curr >= max) {
				max = curr;
			}
		}
		return max;
	}
}
