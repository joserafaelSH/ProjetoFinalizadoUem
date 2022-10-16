package feature.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import features.Feature;
import features.Variability;

public class FeatureDiagram {
    private final HashMap<String, Feature> features; 
    private final HashMap<Integer, Variability> variabilityfinal;
    private final ArrayList<String> connection;
    private final HashMap<String,ArrayList<String>> variability;
    private Integer ID  ;
    
 
    public FeatureDiagram() {
    	variabilityfinal = new HashMap<Integer, Variability>(); 
        features = new HashMap<String, Feature>(); 
        connection = new ArrayList<String>() ; 
        variability = new HashMap<String,ArrayList<String>>() ;
        
    }

	public HashMap<String, Feature> getFeatures() {
		return features;
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID() {
		ID = features.size()+1;
	}
	
	public void setID(int i) {
		ID = i ;
	}

	public void mostrarDiagrama() {
		for(String i : features.keySet()) {
			System.out.println("    "+ features.get(i).export());
		}
		for(Integer j : variabilityfinal.keySet()) {
			
			System.out.println("    "+ variabilityfinal.get(j).exportTag());
			for(String i : variabilityfinal.get(j).exportCombinations()) {
				System.out.println("    "+ i);
			}
		}
		for(String i : connection) {
			System.out.println("    "+ i);
		}
		
	}
	
	public void printarCabecalho() {
		System.out.println("<project id=\"41ec5113f7051ae74507685af3696e15\" name=\"Project0\" version=\"1.0\">\n"
				+ "  <types>\n"
				+ "    <type id=\"TYPE#29\" path=\"java.util\" name=\"Arrays\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#10\" path=\"java.lang\" name=\"Boolean\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#11\" path=\"java.lang\" name=\"Byte\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#12\" path=\"java.lang\" name=\"Character\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#30\" path=\"java.util\" name=\"Collections\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#31\" path=\"java.util\" name=\"Date\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#13\" path=\"java.lang\" name=\"Double\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#14\" path=\"java.lang\" name=\"Enum\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#32\" path=\"java.util\" name=\"EnumMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#33\" path=\"java.util\" name=\"EnumSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#34\" path=\"java.util\" name=\"EventListener\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#15\" path=\"java.lang\" name=\"Exception\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#16\" path=\"java.lang\" name=\"Float\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#35\" path=\"java.util\" name=\"HashMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#36\" path=\"java.util\" name=\"HashSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#37\" path=\"java.util\" name=\"HashTable\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#17\" path=\"java.lang\" name=\"Integer\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#38\" path=\"java.util\" name=\"LinkedHashMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#39\" path=\"java.util\" name=\"LinkedHashSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#40\" path=\"java.util\" name=\"LinkedList\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#41\" path=\"java.util\" name=\"List\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#18\" path=\"java.lang\" name=\"Long\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#42\" path=\"java.util\" name=\"Map\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#19\" path=\"java.lang\" name=\"Math\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#20\" path=\"java.lang\" name=\"Number\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#21\" path=\"java.lang\" name=\"Object\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#22\" path=\"java.lang\" name=\"Package\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#43\" path=\"java.util\" name=\"Queue\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#44\" path=\"java.util\" name=\"Random\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#45\" path=\"java.util\" name=\"Scanner\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#46\" path=\"java.util\" name=\"Set\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#23\" path=\"java.lang\" name=\"Short\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#47\" path=\"java.util\" name=\"Stack\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#24\" path=\"java.lang\" name=\"String\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#25\" path=\"java.lang\" name=\"StringBuffer\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#26\" path=\"java.lang\" name=\"StringBuilder\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#27\" path=\"java.lang\" name=\"Thread\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#48\" path=\"java.util\" name=\"Timer\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#49\" path=\"java.util\" name=\"TreeMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#50\" path=\"java.util\" name=\"TreeSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#51\" path=\"java.util\" name=\"Vector\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#28\" path=\"java.lang\" name=\"Void\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#1\" path=\"\" name=\"boolean\" value=\"false\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#2\" path=\"\" name=\"byte\" value=\"'0'\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#3\" path=\"\" name=\"char\" value=\"' '\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#4\" path=\"\" name=\"double\" value=\"0.0d\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#5\" path=\"\" name=\"float\" value=\"0.0f\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#6\" path=\"\" name=\"int\" value=\"0\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#7\" path=\"\" name=\"long\" value=\"0.0l\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#8\" path=\"\" name=\"short\" value=\"0\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#9\" path=\"\" name=\"void\" value=\"\" primitive=\"true\" standard=\"true\"/>\n"
				+ "  </types>\n"
				+ "  <stereotypes>\n"
				+ "    <stereotype id=\"STEREOTYPE#4\" name=\"alternative_OR\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#5\" name=\"alternative_XOR\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#1\" name=\"mandatory\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#7\" name=\"mutex\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#2\" name=\"optional\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#6\" name=\"requires\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#8\" name=\"stereotype\" primitive=\"false\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#3\" name=\"variationPoint\" primitive=\"true\"/>\n"
				+ "  </stereotypes>\n"
				+ "  <profile mandatory=\"STEREOTYPE#1\" optional=\"STEREOTYPE#2\" variationPoint=\"STEREOTYPE#3\" inclusive=\"STEREOTYPE#4\" exclusive=\"STEREOTYPE#5\" requires=\"STEREOTYPE#6\" mutex=\"STEREOTYPE#7\"/>\n"
				+ "  <diagram id=\"DIAGRAM#1\" name=\"Diagram1\" type=\"Feature\">") ;
	}
	
	public String printarCabecalho1() {
		return ("<project id=\"41ec5113f7051ae74507685af3696e15\" name=\"Project0\" version=\"1.0\">\n"
				+ "  <types>\n"
				+ "    <type id=\"TYPE#29\" path=\"java.util\" name=\"Arrays\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#10\" path=\"java.lang\" name=\"Boolean\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#11\" path=\"java.lang\" name=\"Byte\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#12\" path=\"java.lang\" name=\"Character\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#30\" path=\"java.util\" name=\"Collections\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#31\" path=\"java.util\" name=\"Date\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#13\" path=\"java.lang\" name=\"Double\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#14\" path=\"java.lang\" name=\"Enum\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#32\" path=\"java.util\" name=\"EnumMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#33\" path=\"java.util\" name=\"EnumSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#34\" path=\"java.util\" name=\"EventListener\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#15\" path=\"java.lang\" name=\"Exception\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#16\" path=\"java.lang\" name=\"Float\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#35\" path=\"java.util\" name=\"HashMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#36\" path=\"java.util\" name=\"HashSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#37\" path=\"java.util\" name=\"HashTable\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#17\" path=\"java.lang\" name=\"Integer\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#38\" path=\"java.util\" name=\"LinkedHashMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#39\" path=\"java.util\" name=\"LinkedHashSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#40\" path=\"java.util\" name=\"LinkedList\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#41\" path=\"java.util\" name=\"List\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#18\" path=\"java.lang\" name=\"Long\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#42\" path=\"java.util\" name=\"Map\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#19\" path=\"java.lang\" name=\"Math\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#20\" path=\"java.lang\" name=\"Number\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#21\" path=\"java.lang\" name=\"Object\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#22\" path=\"java.lang\" name=\"Package\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#43\" path=\"java.util\" name=\"Queue\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#44\" path=\"java.util\" name=\"Random\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#45\" path=\"java.util\" name=\"Scanner\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#46\" path=\"java.util\" name=\"Set\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#23\" path=\"java.lang\" name=\"Short\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#47\" path=\"java.util\" name=\"Stack\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#24\" path=\"java.lang\" name=\"String\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#25\" path=\"java.lang\" name=\"StringBuffer\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#26\" path=\"java.lang\" name=\"StringBuilder\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#27\" path=\"java.lang\" name=\"Thread\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#48\" path=\"java.util\" name=\"Timer\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#49\" path=\"java.util\" name=\"TreeMap\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#50\" path=\"java.util\" name=\"TreeSet\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#51\" path=\"java.util\" name=\"Vector\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#28\" path=\"java.lang\" name=\"Void\" value=\"null\" primitive=\"false\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#1\" path=\"\" name=\"boolean\" value=\"false\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#2\" path=\"\" name=\"byte\" value=\"'0'\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#3\" path=\"\" name=\"char\" value=\"' '\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#4\" path=\"\" name=\"double\" value=\"0.0d\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#5\" path=\"\" name=\"float\" value=\"0.0f\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#6\" path=\"\" name=\"int\" value=\"0\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#7\" path=\"\" name=\"long\" value=\"0.0l\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#8\" path=\"\" name=\"short\" value=\"0\" primitive=\"true\" standard=\"true\"/>\n"
				+ "    <type id=\"TYPE#9\" path=\"\" name=\"void\" value=\"\" primitive=\"true\" standard=\"true\"/>\n"
				+ "  </types>\n"
				+ "  <stereotypes>\n"
				+ "    <stereotype id=\"STEREOTYPE#4\" name=\"alternative_OR\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#5\" name=\"alternative_XOR\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#1\" name=\"mandatory\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#7\" name=\"mutex\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#2\" name=\"optional\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#6\" name=\"requires\" primitive=\"true\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#8\" name=\"stereotype\" primitive=\"false\"/>\n"
				+ "    <stereotype id=\"STEREOTYPE#3\" name=\"variationPoint\" primitive=\"true\"/>\n"
				+ "  </stereotypes>\n"
				+ "  <profile mandatory=\"STEREOTYPE#1\" optional=\"STEREOTYPE#2\" variationPoint=\"STEREOTYPE#3\" inclusive=\"STEREOTYPE#4\" exclusive=\"STEREOTYPE#5\" requires=\"STEREOTYPE#6\" mutex=\"STEREOTYPE#7\"/>\n"
				+ "  <diagram id=\"DIAGRAM#1\" name=\"Diagram1\" type=\"Feature\">") ;
	}
	
	public void printarRodape() {
		System.out.println("  </diagram>\n"
				+ "  <links>\n"
				+ "  </links>\n"
				+ "  <products>\n"
				+ "  </products>\n"
				+ "</project>");
	}
	
	public String printarRodape1() {
		return("  </diagram>\n"
				+ "  <links>\n"
				+ "  </links>\n"
				+ "  <products>\n"
				+ "  </products>\n"
				+ "</project>");
	}
	
	public int buscaId(String nome) {
		for(String i : features.keySet()) {
			if(features.get(i).getName().equals(nome)) {
				return features.get(i).getId();
			}
		}
		return -1;
	}
	
	public Feature buscaNome(String nome) {
		for(String i : features.keySet()) {
			if(features.get(i).getName().equals(nome)) {
				return features.get(i);
			}
		}
		return null;
	}
    
	public String criarVariabilityAlt(ArrayList<String> aux1, Feature i) {
		String tagaux = "<variability id=\"VARIABILITY#subid\" name=\"\" category=\"Inclusive\" variationPoint=\"FEATURE#"+i.getId()+"\" mandatory=\"false\" x=\""+(i.getX()+50)+"\" y=\""+(i.getY()+60)+"\"  globalX=\"0\" globalY=\"0\" height=\"50\" width=\"50\">\n";
		
		aux1.add(String.valueOf(i.getId()));
		for(Feature j : features.values()) {
			if(j.getPai() == (i.getName())) {
				tagaux+= "      <variant id=\"FEATURE#"+j.getId()+"\"/>\n" ;	
				aux1.add(String.valueOf(j.getId()));
			}
		}
		tagaux+= "    </variability>\n" ;
		return tagaux;
	}
	
	public String criarVariabilityOr(ArrayList<String> aux1, Feature i) {
		String tagaux = "<variability id=\"VARIABILITY#subid\" name=\"\" category=\"Exclusive\" variationPoint=\"FEATURE#"+i.getId()+"\" mandatory=\"false\" x=\""+(i.getX()+50)+"\" y=\""+(i.getY()+60)+"\" globalX=\"0\" globalY=\"0\" height=\"50\" width=\"50\">\n";

		aux1.add(String.valueOf(i.getId()));
		for(Feature j : features.values()) {
			if(j.getPai()==(i.getName())) {
				tagaux+= "      <variant id=\"FEATURE#"+j.getId()+"\"/>\n" ;	
				aux1.add(String.valueOf(j.getId()));
			}
		}
		tagaux+= "    </variability>\n" ;
		return tagaux;
	}
	
	@SuppressWarnings("unchecked")
	public void connections(){
		
		ArrayList<String> aux1 = new ArrayList<String>();

		for(Feature i : features.values()) {
			if(i.getPai() == null) {
				if(i.getNodeType().equals("alt")) {
					variability.put(criarVariabilityAlt(aux1,i),(ArrayList<String>) aux1.clone() );
					aux1.clear();
				}
				else if(i.getNodeType().equals("or")) {
					
					variability.put(criarVariabilityOr(aux1,i),(ArrayList<String>) aux1.clone());
					aux1.clear();
					
				}
			}
			else {
				if(i.getNodeType().equals("alt")) {
					variability.put(criarVariabilityAlt(aux1,i),(ArrayList<String>) aux1.clone() );
					aux1.clear();
					
				}else if(i.getNodeType().equals("or")) {
					variability.put(criarVariabilityOr(aux1,i),(ArrayList<String>) aux1.clone());
					aux1.clear();
					
				}
				
				Feature aux = buscaNome(i.getPai());
				if(aux.getNodeType().equals("and")) {
					String tagaux ;
					if(i.getMandatory().equals("true")) {
						tagaux = "<connection id=\"CONNECTION#"+ID+"\" source=\"FEATURE#"+aux.getId()+"\" target=\"FEATURE#"+i.getId() +"\" category=\"mandatory\"></connection>";		
					}
					else {
						tagaux = "<connection id=\"CONNECTION#"+ID+"\" source=\"FEATURE#"+aux.getId()+"\" target=\"FEATURE#"+i.getId() +"\" category=\"optional\"></connection>";
					}
							
					connection.add(tagaux);
					ID++;
				}
				
			}
			
			
		}

		for(String j : variability.keySet()) {
			Variability aux = new Variability(ID, j);
			aux.arrumarIds();
			aux.combination(variability.get(j));
			variabilityfinal.put(ID, aux);
			ID = aux.getId();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void arrumarPosicoes() {
		//presets
		float x,y,gapx,gapy,h,w;
		//eixo x inicial
		x = 100;
		//eixo y incial
		y = 50 ;
		//distancia x de cada feature
		gapx = 10;
		//distancia y de cada feature
		gapy = 100;
		//altura de cada feature
		h = 50;
		//largura de cada feature
		w = 150;
		@SuppressWarnings("unused")
		int n = 0;
		LinkedList<Feature> nivel = new LinkedList<Feature>();
		LinkedList<Feature> nivelaux = new LinkedList<Feature>();
		//primeiro pegar a feature que tem pai == null => raiz da arvore nv 0
		for(Feature i : features.values()) {
			if(i.getPai() == null) {
				i.setX(x);
				i.setY(y);
				i.setTag();
				x += w + gapx;
				nivel.add(i);
				
			}
		}//nivel 0 feito, atualizar altura e resetar o x
		n++;
		x = 100;
		y+= h + gapy ;
		
		while(nivel.size()>0) {
			
			for(Feature i : nivel) {
				for(Feature j : features.values()) {
					if(j.getPai() == i.getName()) {
						
						nivelaux.add(j);
						
					}
				}
				
			}
			if(nivelaux.size()>0) {
				for(Feature j : nivelaux ) {
					j.setX(x);
					j.setY(y);
					j.setTag();
					x += w + gapx;
				}
				n++;
				x = 100;
				y+= h + gapy ;
			}
				
			nivel = (LinkedList<Feature>) nivelaux.clone() ;
			nivelaux.clear();
		}
	}
	
}
	
