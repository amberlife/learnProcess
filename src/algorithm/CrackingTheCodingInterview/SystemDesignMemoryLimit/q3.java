package algorithm.CrackingTheCodingInterview.SystemDesignMemoryLimit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ����һ���ļ����������40�ڸ��������ṩһ���㷨�ҳ����ļ��в�������һ����������������1G���ڴ����ʹ��
 * ���ǰ����ݼ��ٵ�100w���Լ��ټ���ʱ�䣬�����㷨�����ǲ����иı�ġ�
 */
public class q3 {
	public static int dataSize=1000000;
	
	public static void createDataFile() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("1Billion.dat",false));
		for(int i=0;i<dataSize;i++){
			if(i!=10){//������ǰ�10��Ϊȱʧ������
			writer.write(String.valueOf(i));
			writer.newLine();
			}
		}
		writer.close();
	}
	public static int[] createBitMap(File file,int c) throws IOException{
		int size=c/32;
		if(c%32!=0){
			size+=1;
		}
		int[] bitmap = new int[size];
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line=reader.readLine())!=null){
			int number = Integer.valueOf(line);
			int idx = number/32;
			int offset = number%32;
			int i=1<<offset;
			bitmap[idx]=bitmap[idx]|i;
		}
		reader.close();
		return bitmap;
	}
	
	public static int findMissing(int[] bitmap){
		int n=0;
		for(int i=0;i<bitmap.length;i++){
			int k=1;
			for(int j=0;j<32;j++){
				if((bitmap[i]&k)!=0){
					k<<=1;
					n++;
				}else{
					return n ;
				}
			}
		}
		return  n;
	}
	
	public static void main(String[] args) throws IOException {
		createDataFile();
		File file = new File("1Billion.dat");
		int[] bitmap = createBitMap(file,dataSize);
		int missing=findMissing(bitmap);
		System.out.println(missing);
		
	}
	
	
}
