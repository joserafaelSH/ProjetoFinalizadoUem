package features.featureide;

import org.w3c.dom.Element;

public class Feature {
    private String id;
    private String name;
    private String nodeType;
    private String abstract_;
	private String mandatory;
    private Feature pai;
    private String tag ;
    private String tagDeFechamento;
    
    public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

    public String getFechamento_tag() {
		return tagDeFechamento;
	}

	public void setFechamento_tag(String fechamento_tag) {
		this.tagDeFechamento = fechamento_tag;
	}
	
	public Feature(Element element) {
        id        = element.getAttribute("id");
        name = element.getAttribute("name");
        abstract_ = element.getAttribute("abstract");
        if(abstract_.equals("")) {
        	abstract_ = "false" ;
        }
        mandatory = element.getAttribute("mandatory");
        if(mandatory.equals("")) {
        	mandatory = "false" ;
        }
        nodeType = element.getNodeName();
        
    }
    
	public Feature getPai() {
		return pai;
	}

	public void setPai(Feature pai) {
		this.pai = pai;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public String getNodeType() {
        return nodeType;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAbstract() {
        return abstract_;
    }

    public void setAbstract(String abstract_) {
        this.abstract_ = abstract_;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getTag() {
		return tag;
	}

	public void setTag() {
		if(nodeType.equals("feature")) {
			String tag_aux = "";
			if(this.mandatory.equals("true") && this.abstract_.equals("false")) {
				
				tag_aux = "<feature mandatory=\""+mandatory+"\" name=\""+ name +"\"/>";
			}
			else if(this.mandatory.equals("true") && this.abstract_.equals("true")) {
				tag_aux = "<feature mandatory=\""+mandatory+ "\" abstract=\""+abstract_ +"\" name=\""+ name +"\"/>";
			}else if(this.mandatory.equals("false") && this.abstract_.equals("true")) {
				tag_aux = "<feature abstract=\""+abstract_ +"\" name=\""+ name +"\"/>";
			}
			else {
				tag_aux = "<feature name=\""+ name +"\"/>";
			}
			this.tagDeFechamento = "";
			this.tag = tag_aux;
		}else if(nodeType.equals("alt")) {
			if(abstract_.equals("true") && mandatory.equals("true")){
				String tag_aux = "<alt abstract=\""+ abstract_ +"\""+" mandatory=\""+ mandatory +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else if(abstract_.equals("false") && mandatory.equals("true")) {
				String tag_aux = "<alt mandatory=\""+  mandatory +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else if(abstract_.equals("true") && mandatory.equals("false")) {
				String tag_aux = "<alt abstract=\""+ abstract_ +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else {
				String tag_aux = "<alt name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			this.tagDeFechamento = "</alt>";
		}else if(nodeType.equals("and")) {
			if(abstract_.equals("true") && mandatory.equals("true")){
				String tag_aux = "<and abstract=\""+ abstract_ +"\""+" mandatory=\""+ mandatory +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else if(abstract_.equals("false") && mandatory.equals("true")) {
				String tag_aux = "<and mandatory=\""+  mandatory +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else if(abstract_.equals("true") && mandatory.equals("false")) {
				String tag_aux = "<and abstract=\""+ abstract_ +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else {
				String tag_aux = "<and name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			this.tagDeFechamento = "</and>";
		}else if(nodeType.equals("or")) {
			if(abstract_.equals("true") && mandatory.equals("true")){
				String tag_aux = "<or abstract=\""+ abstract_ +"\""+" mandatory=\""+ mandatory +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else if(abstract_.equals("false") && mandatory.equals("true")) {
				String tag_aux = "<or mandatory=\""+  mandatory +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else if(abstract_.equals("true") && mandatory.equals("false")) {
				String tag_aux = "<or abstract=\""+ abstract_ +"\" name=\""+ name +"\" >";
				this.tag = tag_aux;
			}
			else {
				String tag_aux = "<or name=\""+ name +"\">";
				this.tag = tag_aux;
			}
			this.tagDeFechamento = "</or>";
		}
	}

}