package thinkingInJava;

class DynamicFieldsException extends Exception{}

public class DynamicFields {
	private Object[][] fields;
	public DynamicFields(int initialSize){
		fields = new Object[initialSize][2];
		for(int i=0;i<initialSize;i++){
			fields[i] = new Object[]{null,null};
		}
	}
	
	
	
}
