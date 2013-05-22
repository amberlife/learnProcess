
public enum OzWitch {
	
	
	WEST("west is the west"),
	NORTH("north is the north"),
	EAST("east is the east"),
	SOUTH("south is the south");
	private String description ; 
	private OzWitch(String description){
		this.description = description;
	}
	
	public String toString(){
		return	name();
	}
	
	public static void main(String[] args){
		System.out.println(OzWitch.WEST);
		
		/*for(OzWitch witch:OzWitch.values()){
			System.out.println(witch+": "+witch.getDescription());
		}*/
	}
	
}
