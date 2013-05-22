import java.util.ArrayList;


public class AdaBoost {
	public static void main(String[] args){
		ArrayList<XY> trainData = new ArrayList<XY>();
		ArrayList<Integer> classifiers = new ArrayList<Integer>();
		trainData.add(new XY(0,1));
		trainData.add(new XY(1,1));
		trainData.add(new XY(2,1));
		trainData.add(new XY(3,-1));
		trainData.add(new XY(4,-1));
		trainData.add(new XY(5,-1));
		trainData.add(new XY(6,1));
		trainData.add(new XY(7,1));
		trainData.add(new XY(8,1));
		trainData.add(new XY(9,-1));
		double[] weight = new double[10];
		for(int i=0;i<weight.length;i++)
			weight[i]=0.1;
		 classifierFeature cf = trainBasicClassifier(trainData,weight);
		classifiers.add(cf.classifierPoint);
		double alpha=0.5*Math.log((1-cf.epsilon)/cf.epsilon);
		double Z = 0 ;

		
	}
	public static classifierFeature  trainBasicClassifier(ArrayList<XY> data,double[] weight){
		double epsilon=Double.MAX_VALUE;
		int result=0;
		ArrayList<Integer> error = new ArrayList<Integer>();
		for(int v = 0 ; v<10;v++){
			for(int i=0;i<data.size();i++){
				XY temp =data.get(i);
				if(temp.x<v&&temp.y==1){
					continue;
				}else if(temp.x>v&&temp.y==-1){
					continue;
				}else{
					error.add(i);
				}
			}
			double epsilonV=0; 
			for(int j=0;j<error.size();j++){
				epsilonV+=weight[error.get(j)];
			}
			if(epsilonV<epsilon){
				epsilon=epsilonV;
				result = v;
			}
		}
		classifierFeature cf = new classifierFeature();
		cf.classifierPoint = result;
		cf.epsilon = epsilon;
		return cf;
	}
}
class XY{
	public XY(int x,int y){
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
}
class classifierFeature{
	int classifierPoint = 0 ;
	double epsilon =0 ;
}
