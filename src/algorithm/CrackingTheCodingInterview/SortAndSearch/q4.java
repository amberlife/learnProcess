package algorithm.CrackingTheCodingInterview.SortAndSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

import sun.tools.jar.Main;


/**
 * If you have a 2 GB file with one string per line, which sorting algorithm would you use to sort the file and why?
 * һ��2G����ļ�������ÿһ����һ���ַ��������ʹ��ʲô�㷨������Ϊʲô��
 * 
 * 2G����ļ�����Ŀ����˼��Ȼ��Ҫ���������򣬵�������ռ��2G���ڴ棬���ټ���
 * ������ǲ���N·�鲢����
 * ��˿��ǣ�����ֻ��Ҫ��ԭʼ�ļ����зֶΣ�ÿ�ζ�һ�ν�������ÿһ��������ɺ󣬴�����̡�
 * ���ǽ�K��С�ļ�������󣬺ϲ����ǡ�
 * 
 * 
 */
public class q4 {
	public static final int MAX_LINE=200000;
	public static final int PER_LINE=10000;
	//����һ��2G����ļ���ÿһ�а���һ�������
	public static File createBigFile() throws IOException{
		File file = new File("big.dat");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		Random rand = new Random();
		for(int i=0;i<MAX_LINE;i++){
			writer.write(rand.nextInt(100000000)+"\n");
		}
		writer.close();
		return file;
	}
	
	//�����ļ����з�Ƭ
	public static void fragmentBigFile(File file) {
		int maxlines=PER_LINE;
		BufferedReader reader=null;
		BufferedWriter writer=null;
		File dir = new File("tmp/");
		dir.mkdir();
		try{
			int count=0;
			int fileCount=0;
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+File.separator+(fileCount++)+".dat"));
			for(String line;(line=reader.readLine())!=null;){
				if(++count%maxlines==0){
					writer.close();
					writer = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+File.separator+(fileCount++)+".dat"));
				}
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				reader.close();
			} catch (IOException e) {
			}
		}
	}
	
	//��������С�ļ�
	public static void handleSmallFileList(File file) throws IOException{
		if(file.isDirectory()){
			File[] files =file.listFiles();
			for(File f:files){
				sortSmallFile(f);
			}
		}
	}
	
	//����Ƭ��С�ļ���������
	public static void sortSmallFile(File file) throws IOException{
		int[] arr = new int[PER_LINE];
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int idx=0;
		while((line=br.readLine())!=null){
			arr[idx++]=Integer.parseInt(line);
		}
		arr = Arrays.copyOf(arr, idx);
		Arrays.sort(arr);
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
		for(int i=0;i<idx;i++){
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
		}
		bw.close();
	}
	
	//2·�鲢�㷨
	public static void merge (File file1,File file2,String outputFile) throws IOException{
		BufferedReader read1 = new BufferedReader(new FileReader(file1));
		BufferedReader read2 = new BufferedReader(new FileReader(file2));
		String line1,line2;
		
		BufferedWriter writer= new BufferedWriter(new FileWriter(outputFile));
		line1=read1.readLine();
		line2=read2.readLine();
		while(true){
			if(Integer.valueOf(line1)<Integer.valueOf(line2)){
					writer.write(line1);
					writer.newLine();
					line1=read1.readLine();
					if(line1==null){
						//��file2ʣ�µĲ���
						while((line2=read2.readLine())!=null){
							//line2=read2.readLine();
							writer.write(line2);
							writer.newLine();
						}
						break;
					}
			}else{
				writer.write(line2);
				writer.newLine();
				line2=read2.readLine();
				if(line2==null){
					//��file1ʣ�µĲ���
					while((line1=read1.readLine())!=null){
						//line1=read1.readLine();
						writer.write(line1);
						writer.newLine();
					}
					break;
				}
			}
		}
		read1.close();
		read2.close();
		writer.close();
		file1.delete();
		file2.delete();
		
	}	
	
	
	//���ֹ鲢
	public static void outerMerge(File file,String outputDir,int f) throws IOException{
		if(file.isDirectory()){
			File[] files = file.listFiles();
			if(files.length>1){
				File newDir = new File(outputDir+f);
				newDir.mkdir();
				for(int i=0,k=1,count=0;i<files.length;i+=2,k+=2,count++){
					File file1 = files[i];
					File file2 = null;
					if(k<files.length){
						file2= files[k];
					}else{
						file1.renameTo(new File(newDir.getAbsolutePath()+"/"+(count++)+".dat"));
					}
					if(file1!=null&&file2!=null){
						merge(file1,file2,newDir.getAbsolutePath()+"/"+count+".dat");
					}
				}
				outerMerge(newDir,outputDir,f+1);
			}else{
					file.renameTo(new File("sorted"));
					return ;
			}
			
			file.delete();
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		createBigFile();
		fragmentBigFile(new File("big.dat"));
		handleSmallFileList(new File("./tmp"));
		outerMerge(new File("./tmp"),"outer_tmp",0);
		
	}
}
