package features.featureide;
import java.util.ArrayList;

public class Variability {
	private String id;
	private String category;
    private String tag ;
    private String nodeType;
    private Feature pai;
    private ArrayList<Feature> features ;
    
    
    public Variability() {
		super();
	}
	
	public Variability(String node_type, ArrayList<Feature> features) {
		super();
		this.nodeType = node_type;
		this.tag = new String();
		this.features = new ArrayList<Feature>()  ;
		
	}
    
	public String getCategory()  {
		return category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPai(Feature pai) {
		this.pai = pai;
	}
	
	public Feature getPai() {
		return this.pai;
	}
	
	public String getNodeType() {
		return this.nodeType;
	}
	
	public void setNodeType(String node_type) {
		this.nodeType = node_type;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public ArrayList<Feature> getFeatures() {
		return features;
	}
	
	public void setFeatures(ArrayList<Feature> features) {
		this.features = features;
	}
	
	public void arrumarTagPai() {
		if(category!= null){
			if(category.equals("Inclusive")) {
				pai.setNodeType("alt");
				
			}
			else if(category.equals("Exclusive")) {
				pai.setNodeType("or");
			}
		}
	}
		
	public void mostrarArray() {
		features.forEach((f) -> System.out.println(f.getName()));
	}
	
	
}
