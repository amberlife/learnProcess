import java.util.Stack;


public class viterbi {
	public static void main(String[] args){
		String[] stateSpace = new String[]{"box1","box2","box3"};
		int[] observationSequence = new int[] {0,1,0};
		double[][] A = {{0.5,0.2,0.3},
							 {0.3,0.5,0.2},
							 {0.2,0.3,0.5}};
		double[][] B = {{0.5,0.5},
							 {0.4,0.6},
							{0.7,0.3}};
		double[] PI = {0.2,0.4,0.4};
		double[][] t1 = new double[3][3];
		int[][] t2 = new int [3][3];

		//step 1 initialize;
		for(int i=0;i<3;i++){
			t1[i][0]=PI[i]*B[i][0];
			t2[i][0]=0;
		}
		//递推
		for (int t = 1; t < 3; t++) {
			for (int i = 0; i < 3; i++) {
				double max = t1[0][t - 1] * A[0][i];
				int pos = 0;
				for (int j = 1; j < 3; j++) {
					if (max < t1[j][t - 1] * A[j][i]) {
						max = t1[j][t - 1] * A[j][i];
						pos = j;
					}
				}
				t1[i][t] = max * B[i][observationSequence[t]];
				t2[i][t] = pos;
			}
		}
		
		 
		//给出结果
		double maxP =t1[0][2];
		int posT = 0 ;
		for(int i=1;i<3;i++){
			if(maxP<t1[i][2]){
				maxP = t1[i][2];
				posT = i;
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(posT);
		for(int t=2;t>0;t--){
			posT = t2[posT][t];
			stack.push(posT);
		}
		
		while(!stack.isEmpty()){
		System.out.print(stateSpace[stack.pop()]+ " ");
		}
	}
}
