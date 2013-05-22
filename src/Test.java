

public class Test {
	

	public static void main(String[] args) {
		String[] englishWords = {"house","a","the","book"};
		int[] E={0,1,2,3};
		String[] foreignWords = {"这","书","房间","一个"};
		int[] F = {0,1,2,3};
		int[][][] threeSentencePairs={{{2,0},{0,2}},
										 {{2,3},{0,1}},
										 {{1,3},{3,1}}
										};
		
		double[][] t={{0.25,0.25,0.25,0.25},
								  {0.25,0.25,0.25,0.25},
								  {0.25,0.25,0.25,0.25},
								  {0.25,0.25,0.25,0.25}
								 };
		
		double[] totalsE=new double[4];
		double[] totalF=new double[4];
		double[][] count= new double[4][4];
		
		int convergence=1000000;
		while(convergence-->0){
			//all sentence pairs (e_s , f_s)
			for(int i=0;i<3;i++){
				//set totalsE = 0 for all e
				totalsE[0]=0;
				totalsE[1]=0;
				totalsE[2]=0;
				totalsE[3]=0;
				
				// for all words e in E
				for(int j=0;j<threeSentencePairs[i][0].length;j++){
					//for all words f in F
					for(int k=0;k<threeSentencePairs[i][1].length;k++){
						int e = threeSentencePairs[i][0][j];
						int f = threeSentencePairs[i][1][k];
						totalsE[e]+= t[e][f];
					}
				}
				
				for(int j=0;j<threeSentencePairs[i][0].length;j++){
					for(int k=0;k<threeSentencePairs[i][1].length;k++){
						int e = threeSentencePairs[i][0][j];
						int f = threeSentencePairs[i][1][k];
						count[e][f] +=t[e][f]/totalsE[e];
						totalF[f] += t[e][f]/totalsE[e];
					}
				}
			}
			
			for(int f=0;f<F.length;f++){
				for(int e=0;e<E.length;e++){
					t[e][f] = count[e][f]/totalF[f];
					if(convergence<100)
						System.out.print(Double.toString(t[e][f])+", ");
				}
				if(convergence<100)
					System.out.println();
			}
			if(convergence<100)
				System.out.println();
		}
	}
}