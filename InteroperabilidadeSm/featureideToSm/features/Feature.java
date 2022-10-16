package features;

import org.w3c.dom.Element;

public class Feature {
    private int id;
    private String name;
    private String nodeType;
    private String abstract_;
    private String mandatory;
    private String pai;
    private String tag ;
    private float x = 0;
    private float y = 0;
    private boolean visitado = false ;
   
    

    public Feature(Element element) {
        //id        = "FEATURE#";
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
    
    
    
    public float getX() {
		return x;
	}



	public void setX(float x) {
		this.x = x;
	}



	public float getY() {
		return y;
	}



	public void setY(float y) {
		this.y = y;
	}



	public boolean isVisitado() {
		return visitado;
	}



	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}



	public String getPai() {
		return pai;
	}


	public void setPai(String pai) {
		this.pai = pai;
	}



	public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
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
		this.tag = "<feature id=\"FEATURE#"+ this.id + "\" name=\""+ this.name+"\" mandatory=\""+ this.mandatory+"\" abstract=\""+this.abstract_ +"\" x=\""+this.x + "\" y=\""+ this.y + "\" globalX=\"0\"" + " globalY=\"0\"" + " height=\"50\"" + " width=\"150\"/>" ;
	}


	public String export() {
    	
    	return this.tag ;
    }
    
    
    public String toString() {
        return name;
    }
}

