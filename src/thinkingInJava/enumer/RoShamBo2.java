package thinkingInJava.enumer;

enum OutCome{
	DRAW,LOSE,WIN;
}

interface Competitor<T extends Competitor<T>>{
	OutCome compete(T competitor);
}

public enum RoShamBo2 implements Competitor<RoShamBo2>{
	PAPER(OutCome.DRAW,OutCome.LOSE,OutCome.WIN),
	SCISSORS(OutCome.WIN,OutCome.DRAW,OutCome.LOSE),
	ROCK(OutCome.LOSE,OutCome.WIN,OutCome.DRAW)
	;
	private OutCome vPAPER,vSCISSORS,vROCK;
	private RoShamBo2(OutCome paper,OutCome scissors,OutCome rock){
		this.vPAPER = paper;
		this.vSCISSORS = scissors;
		this.vROCK = rock;
	}
	
	public OutCome compete(RoShamBo2 competitor) {
		switch(competitor){
			default:
			case PAPER:return vPAPER;
			case SCISSORS: return vSCISSORS;
			case ROCK: return vROCK;
		}
	}
	
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo2.class,20);
	}
}

class RoShamBo {
	public static <T extends Competitor<T>> void match(T a,T b){
		System.out.println(a+" vs. "+b+": "+a.compete(b));
	}
	public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass,int size){
		for(int i=0;i<size;i++){
			match(Enums.random(rsbClass),Enums.random(rsbClass));
		}
	}
	
}

