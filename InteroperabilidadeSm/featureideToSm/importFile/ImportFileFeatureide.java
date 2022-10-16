package importFile;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import features.Feature;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import feature.diagram.FeatureDiagram;


public class ImportFileFeatureide {
    private Integer ID = 1;
    private final String path;
    private final XPath  xPath;
    private File     file;
    private Document document;
    private NodeList nodeList;
    private String   expression;
    private  FeatureDiagram diagrama = new FeatureDiagram();

    public FeatureDiagram getDiagrama() {
		return diagrama;
	}

    public ImportFileFeatureide(String path_) {
        path  = path_;
        xPath = XPathFactory.newInstance().newXPath();
    }
    
    public void init() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        openFile();
        readFile();
    }
 
    private void openFile() throws ParserConfigurationException, SAXException, IOException {
        file     = new File(path);
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        document.getDocumentElement().normalize();
    }
    
    private void readFile() throws XPathExpressionException {
        expression = "/featureModel/struct";
        nodeList   = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        if (nodeList.getLength() == 1)
            readRoot((Element) nodeList.item(0));
    }
   
    private void readRoot(Element root) throws XPathExpressionException {
        NodeList inclusive = (NodeList) xPath.compile(expression + "/and").evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < inclusive.getLength(); i++)
            readNode((Element) inclusive.item(i), null, expression + "/and",i);
        
        NodeList exclusive = (NodeList) xPath.compile(expression + "/or").evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < exclusive.getLength(); i++)
            readNode((Element) exclusive.item(i), null, expression + "/or",i);
        
        NodeList alternative = (NodeList) xPath.compile(expression + "/alt").evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < alternative.getLength(); i++)
            readNode((Element) alternative.item(i), null, expression + "/alt",i);
        
        NodeList features  = (NodeList) xPath.compile(expression + "/feature").evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < features.getLength(); i++)
            System.out.println(((Element) features.item(i)).getAttribute("name"));
    }
    
    private void readNode(Element node, Feature parent, String expression, int id) throws XPathExpressionException {
        Feature feature = new Feature(node);
        String  filter  = "[@name=\"" + feature.getName() + "\"]";
        
        
        feature.setId(ID);
        ID++;
        feature.setTag();
        
        diagrama.getFeatures().put(feature.getName(), feature);
        
        if(parent == null) {
        	feature.setPai(null);
        }else {
        	feature.setPai(parent.getName());
        }
        
        // And:
        String   new_ = expression + filter + "/and" ;
        NodeList list = (NodeList) xPath.compile(new_).evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++)
            readNode((Element) list.item(i), feature, new_,id++);
        
        // Or:
        new_ = expression + filter + "/or";
        list = (NodeList) xPath.compile(new_).evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++)
            readNode((Element) list.item(i), feature, new_,id++);
        
        // Alt:
        new_ = expression + filter + "/alt";
        list = (NodeList) xPath.compile(new_).evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++)
            readNode((Element) list.item(i), feature, new_,id++);
        
        // Leaf:
        new_ = expression + filter + "/feature";
        list = (NodeList) xPath.compile(new_).evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++)
            readNode((Element) list.item(i), feature, new_,id++);
    }
    
    public static void main(String[] args) throws XPathExpressionException {
        ImportFileFeatureide import_ = new ImportFileFeatureide("featureideToSm/arquivosEntradaFeatureIDE/modeloLiteratura.xml");
        try {
            import_.init();
            
            
            //apenas atualiza o id para a funcao connections
            import_.diagrama.setID();
            //atualiza as posicoes das features
            import_.diagrama.arrumarPosicoes();
            //cria as conexoes 
            import_.diagrama.connections();
            //apenas print
            import_.diagrama.printarCabecalho();
            import_.diagrama.mostrarDiagrama();
            import_.diagrama.printarRodape();
          
            
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ImportFileFeatureide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
