package NetWorkProgram.ch6;

public class Line {
	int lineNum;
	String lineValue;
	
	public Line(int lineNum,String lineValue){
		this.lineNum = lineNum;
		this.lineValue = lineValue;
	}
	
	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	public String getLineValue() {
		return lineValue;
	}
	public void setLineValue(String lineValue) {
		this.lineValue = lineValue;
	}
	
	
}
