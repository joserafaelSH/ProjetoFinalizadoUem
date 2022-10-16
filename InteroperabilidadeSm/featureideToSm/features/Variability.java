package features;

import java.util.ArrayList;

public class Variability {
    private int id;
    private String tag ;
    private ArrayList<Integer> idvariats ;
    private ArrayList<String> combinations ;
    
	public Variability() {
		super();
	}
	
	public Variability(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
		idvariats = new ArrayList<Integer>()  ;
		combinations = new ArrayList<String>()  ;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public ArrayList<Integer> getIdvariats() {
		return idvariats;
	}
	
	public void setIdvariats(ArrayList<Integer> idvariats) {
		this.idvariats = idvariats;
	} 
    
	//Ajusta o id da tag
	public void arrumarIds() {
		setTag(tag.replace("subid",String.valueOf(id)));
	}
	
	//Cria as tags combinations
	public void combination(ArrayList<String> listaids) {
		int idaux = id;
		idaux++;
		for(int i = 0; i < listaids.size(); i++) {
			if(i == 0) {
				combinations.add("<combination id=\"COMBINATION#"+idaux+"\" source=\"VARIABILITY#"+id+"\" target=\"FEATURE#"+listaids.get(i)+"\" root=\"true\">\n    </combination>");
				//System.out.println("<combination id=COMBINATION#"+idaux+" source=VARIABILITY#"+id+" target=FEATURE#"+listaids.get(i)+" root=true></combination>");
			}
			else {
				
				combinations.add("<combination id=\"COMBINATION#"+idaux+"\" source=\"VARIABILITY#"+id+"\" target=\"FEATURE#"+listaids.get(i)+"\" root=\"false\">\n    </combination>");
				//System.out.println("<combination id=COMBINATION#"+idaux+" source=VARIABILITY#"+id+" target=FEATURE#"+listaids.get(i)+" root=false></combination>");
			}
			idaux++;
		}
		setId(idaux);
	}
    
	public String exportTag() {
		return tag;
	}
	
	public ArrayList<String> exportCombinations() {
		return combinations ;
	}
}