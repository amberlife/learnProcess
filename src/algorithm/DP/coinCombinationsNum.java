package algorithm.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * minCoinsNumber�����Ŀ�ı��֡�
 * minCoinsNumber:�� 1Ԫ��3Ԫ��5Ԫ����Ӳ�ң��ʴչ�11ԪӲ��������Ҫ���ٸ�Ӳ�ң�
 * coinCombinationsNum:��1Ԫ��3Ԫ��5Ԫ����Ӳ�ң��ʴչ�11ԪӲ���ж����ִշ���
 * ״̬D[i]���չ�iԪӲ����D[i]�ִշ�
 * 
 * �ֶ����ݣ�
 * D[0]=0
 * D[1]=count{1ö1ԪӲ��}=1;
 * D[2]=count{2ö1ԪӲ��}=1;
 * D[3]=count{1ö3ԪӲ�ң�3öһԪӲ��}=2��
 * D[4]=count{1ö3ԪӲ�Һ�1öһԪӲ��,4ö1ԪӲ��}=2��
 * D[5]=count{1ö5ԪӲ�ң�1ö3ԪӲ�Һ�2öһԪӲ�ң�5öһԪӲ��}=3;
 * D[6]=count{1ö5ԪӲ�Һ�1ö1ԪӲ�ң�2ö3ԪӲ�ң�1ö3ԪӲ�Һ�3ö1ԪӲ�ң�6öһԪӲ��}=4
 *
 *
 */
public class coinCombinationsNum {
	public static void main(String[] args){
		Map<Integer, HashMap<Integer, Integer>> R = new HashMap<Integer ,HashMap<Integer,Integer>>();
		int[] T = {1,3,5};
		R.put(0, null);
		for(int i=1;i<=11;i++){
			for(int j=0;j<T.length;j++){
				if(i>=T[j]){
					
				}
			}
		}
		
	}
}
