package importFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import feature.diagram.featureide.*;
import features.featureide.Connection;
import features.featureide.Feature;
import features.featureide.Variability;

public class ImportFileSm {
    private String path = "";	//caminho de entrada 
    private XPath xPath = null;	//objeto para a leitura de um arquivo xml
    private File file;	//buffer para o arquivo de entrada
    private Document document;	//objeto para salvar o documento
    private NodeList nodeList;	//nodelist para salvar cada nó(feature) do diagrama 
    private String expression;	//expressão para a leitura no arquivo (tag para leitura)
    private FeatureDiagram diagrama = new FeatureDiagram(); // classe diagrama guarda todas as informacoes do diagrama lido

    
    public ImportFileSm(String path_) {
    	/* 
    		Construtor iniciando o caminho do arquivo
    		para leitura e o xPath para ler tags xml
    	 */
        path  = path_;
        xPath = XPathFactory.newInstance().newXPath();
        
    }
  
    public void init() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
    	/*
    		Metodo para ler e montar o diagrama
    	*/
    	openFile();
        readFile();
        montarDiagrama();
    }
    
    private void openFile() throws ParserConfigurationException, SAXException, IOException {
    	/*
   	 		Metodo para abrir o arquivo utilizando o xpath
   	 		Salva o arquivo em document
    	*/
    	file     = new File(path);
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        document.getDocumentElement().normalize();
        
    }
    
    private void readFeatures() throws XPathExpressionException {

    	expression = "/project/diagram/feature"; 	//procurando as tags features no arquivo
        nodeList   = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        
        for(int i = 0; i<nodeList.getLength(); i++) {
        	Node node = nodeList.item(i);
        	Element element = (Element) node ;
        	Feature feature = new features.featureide.Feature(element); 
        	diagrama.setFeatures(feature.getId(), feature);
        }
    }
    
    private void readVariabilitys() throws XPathExpressionException {
    	
        expression = "/project/diagram/variability"; //procurando as variability features no arquivo
        nodeList   = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        
        ArrayList<Variability> variabilityArray = new ArrayList<Variability>();
        for(int i = 0; i<nodeList.getLength(); i++) {
        	
        	Node node = nodeList.item(i);
        	NodeList childNodes  = node.getChildNodes();
        	Variability variability = new Variability();
        	ArrayList<Feature> variabilityFeatures = new ArrayList<Feature>();
        	variability.setCategory(node.getAttributes().getNamedItem("category").getNodeValue());
        	variability.setPai(diagrama.buscarFeature(node.getAttributes().getNamedItem("variationPoint").getNodeValue()));

        	for(int k = 0; k< childNodes.getLength(); k++) {
        		if(! childNodes.item(k).getNodeName().equals("#text")) {
        			
        			variabilityFeatures.add(diagrama.buscarFeature(childNodes.item(k).getAttributes().getNamedItem("id").getNodeValue()));
        		}
        	}
        	variability.setFeatures(variabilityFeatures);
        	variability.setId(node.getAttributes().getNamedItem("id").getNodeValue());
        	variability.arrumarTagPai();
        	variabilityArray.add(variability);
        }
        diagrama.setVariability(variabilityArray);
    }
    
    private void readConnetion() throws XPathExpressionException {
    	
    	expression = "/project/diagram/connection"; //procurando as connections no arquivo
        nodeList   = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        
        
        ArrayList<Connection> connection_array =  new ArrayList<Connection>(); 
		for(int k = 0; k<nodeList.getLength(); k++) {
			
			Connection connection = new Connection();
			
			connection.setSource(diagrama.buscarFeature(nodeList.item(k).getAttributes().getNamedItem("source").getNodeValue()));
			connection.setTarget(diagrama.buscarFeature(nodeList.item(k).getAttributes().getNamedItem("target").getNodeValue()));
			connection.setCategory(nodeList.item(k).getAttributes().getNamedItem("category").getNodeValue());
			connection.arruamarTag();
			connection_array.add(connection);
		}
		diagrama.setConnection(connection_array);
    }
    
    private void readFile() throws XPathExpressionException {
    	/*
	 		Metodo para executar a leitura das tags do arquivo 
	 		
    	*/
    	readFeatures();
    	readVariabilitys();
    	readConnetion();
		
		
}
    
    private void montarDiagrama() {
    	/*
 			Metodo para montar o diagrama, executado apos a leitura 
 		
    	*/
    	diagrama.arrumarPais();
    	diagrama.arrumarDiagrama();
    	diagrama.primeiraParte();
    	/*
    	 ler o arquivo com o TypeFile e a saida dele passar para o ImportFileSm
    	 fazer telinha igual o outro para testes
    	 */
    }

    public static void main(String[] args) throws XPathExpressionException {
    	ImportFileSm import_ = new ImportFileSm("smToFeatureide/arquivosEntradaSm/teste2.smty");
        try {
        	
            import_.init();
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ImportFileFeatureide.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
