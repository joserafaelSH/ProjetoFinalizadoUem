package features.featureide;

public class Connection {
	private Feature source ;
	private Feature target;
	private String category;
	
	public Connection() {
		super();
	}
	
	public Connection(Feature source, Feature target, String category) {
		super();
		this.source = source;
		this.target = target;
		this.category = category;
	}
	
	public void arruamarTag() {
		source.setNodeType("and");
	}
	public Feature getSource() {
		return source;
	}
	public void setSource(Feature source) {
		this.source = source;
	}
	public Feature getTarget() {
		return target;
	}
	public void setTarget(Feature target) {
		this.target = target;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
