package misc;

public class main_misc {

	public static void main(String[] args) {
		//
		int [][] v = {{0,100000},{15,20},{5,30}};
		/*quickSort(v,0,v.length-1);
		for(int i = 0;i < v.length;i++) {
			for(int j = 0;j < v[i].length;j++){
				System.out.print(v[i][j]);
			}
			System.out.println();
		}*/
		System.out.println(min_num_mrooms(v));
	
		

	}
	 //if two intervals are disjoint they can use the same room.	
	/*The minimal quantity of meeting rooms q is:the number of meeting booked - the path that that can be made of all
	   disjoint intervals(q >= 1)         */
	 private static void swap(int[][]v,int i,int j) {
		 //
		 int a = v[i][0];
		 int b = v[i][1];
		 v[i][0] = v[j][0];
		 v[i][1] = v[j][1];
		 v[j][0] = a;
		 v[j][1] = b;
		 
	 }
	 private static void quickSort(int[][]v,int strt,int end) {
		 //
		 if(strt >= end) {
			 return;
		 }
		 int p = v[end][1];
		 int l = strt;
		 int r = end;
		 
		 while(l < r) {
			 while(v[l][1] <= p && l < r){
				 l++;
			 }
			 while(v[r][1] >= p && l < r) {
				 r--;
			 }
			 swap(v,l,r);
		 }
		 if(v[l][1] > v[end][1]) {
			 swap(v,l,end);
		 }
		 else {
			 l = end;
		 }
		 quickSort(v,strt,l-1);
		 quickSort(v,l+1,end);
	 }
	 private static int is_disjoint(int[]a,int[]b) {
		 //a is v[0] and b is v[i]
		 if(a[1] >= b[0]) {
			 return 0;
		 }
		 return 1;
	 }
	 private static int min_num_mrooms(int[][]v) {
		 //
		 quickSort(v,0,v.length-1);
		 int c = 0;
		 for(int i = 1;i < v.length;i++) {
			 if(is_disjoint(v[0],v[i]) == 1) {
				 c++;
			 }
		 }
		 return v.length - c;
	 }
   
	
   
	
}
