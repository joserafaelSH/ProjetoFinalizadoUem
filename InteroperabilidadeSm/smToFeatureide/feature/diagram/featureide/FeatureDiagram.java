package feature.diagram.featureide;

import java.util.ArrayList;
import java.util.HashMap;
import features.featureide.*;

public class FeatureDiagram {
	private Feature root;
	private HashMap<String, Feature> features;
	private ArrayList<Variability> variability;
	private ArrayList<Connection> connection;
	private ArrayList<ArrayList<Feature>> niveis;
	private ArrayList<Feature> pais = new ArrayList<Feature>();;
	private ArrayList<Feature> filhos = new ArrayList<Feature>();;
	

	public FeatureDiagram() {
		niveis = new ArrayList<ArrayList<Feature>>();
		features = new HashMap<String, Feature>();
		variability = new ArrayList<Variability>();
		connection = new ArrayList<Connection>();
	}

	public Feature getRoot() {
		return root;
	}

	public void setRoot(Feature root) {
		this.root = root;
	}

	public void setVariability(ArrayList<Variability> var) {
		variability = var;
	}

	public void setConnection(ArrayList<Connection> connection) {
		this.connection = connection;
	}

	public ArrayList<Connection> getConnection() {
		return connection;
	}

	public HashMap<String, Feature> getFeatures() {
		return features;
	}

	public void setFeatures(String chave, Feature feature) {
		this.features.put(chave, feature);
	}

	public ArrayList<Variability> getVariability() {
		return variability;
	}

	public Feature buscarFeature(String name) {

		String aux = new String();
		for (String key : features.keySet()) {
			if (key.equals(name)) {

				aux = key;
				break;
			}
		}
		
		return features.get(aux);

	}

	public Variability buscarVariability(String name) {

		int idx = 0;
		for (int i = 0; i < variability.size(); i++) {
			if (variability.get(i).getId().equals(name)) {
				idx = i;
				break;
			}
		}

		return variability.get(idx);
	}

	public void mostrarFeatures() {
		for (String key : features.keySet()) {
			if (features.get(key).getPai() != null) {

				System.out.println(features.get(key).getTag() + " " + features.get(key).getId() + " pai: "
						+ features.get(key).getPai().getId());
			} else {
				System.out.println(features.get(key).getTag() + " " + features.get(key).getId());
			}
		}

	}

	public void arrumarPais() {
		variability.forEach((var) -> {
			var.getFeatures().forEach((feature) -> {
				feature.setPai(var.getPai());
			});
		});
		
		connection.forEach((conn) -> {

			conn.getTarget().setPai(conn.getSource());
		});
		

	}

	public void findRoot() {
		String aux = "";
		for (String key : features.keySet()) {
			if (features.get(key).getPai() == null) {
				aux = key;
				break;
			}
		}
		root = features.get(aux);
	}

	public ArrayList<Feature> acharFilhos(Feature pai) {
		ArrayList<Feature> filhos = new ArrayList<Feature>();
		for (String key : features.keySet()) {
			if (features.get(key).getPai() != null) {

				if (features.get(key).getPai().getId().equals(pai.getId())) {
					filhos.add(features.get(key));

				}
			}
		}
		return filhos;
	}

	public void arrumarNiveis() {
		/*
			Mostra o diagrama separando seus niveis
		 */
		for (int i = 0; i < niveis.size(); i++) {
			System.out.println("Nivel: " + i);
			niveis.get(i).forEach((node) -> {
				node.setTag();
				System.out.print(" " + node.getName() + "/" + node.getNodeType() + " " + node.getTag() + " ");
			});
			System.out.println("");
		}

	}

	public void primeiraParte() {
		
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n" + "<featureModel>\r\n"
				+ "	<properties>\r\n" + "	\t<graphics key=\"autolayoutconstraints\" value=\"false\"/>\r\n"
				+ "	\t<graphics key=\"legendautolayout\" value=\"true\"/>\r\n"
				+ "	\t<graphics key=\"showshortnames\" value=\"false\"/>\r\n"
				+ "	\t<graphics key=\"layout\" value=\"horizontal\"/>\r\n"
				+ "	\t<graphics key=\"showcollapsedconstraints\" value=\"true\"/>\r\n"
				+ "	\t<graphics key=\"legendhidden\" value=\"false\"/>\r\n"
				+ "	\t<graphics key=\"layoutalgorithm\" value=\"1\"/>\r\n" + "	</properties>\r\n" + "	<struct>");
		System.out.println("		" + niveis.get(0).get(0).getTag());
		segundaParte(niveis.get(1), 3, niveis.get(0).get(0));
		System.out.println("		" + niveis.get(0).get(0).getFechamento_tag());
		System.out.println("\t</struct>\r\n" + "</featureModel>");
	}

	public void segundaParte(ArrayList<Feature> nivel, int espaco, Feature pai) {
		if (nivel.size() > 0) {

			for (int i = 0; i < nivel.size(); i++) {

				if (nivel.get(i).getNodeType().equals("feature")) {
					for (int k = 0; k < espaco; k++) {

						System.out.print("\t");
					}
					System.out.println(nivel.get(i).getTag());

				} else {
					for (int k = 0; k < espaco; k++) {

						System.out.print("\t");
					}
					System.out.println(nivel.get(i).getTag());
					ArrayList<Feature> novo_nivel = acharFilhos(nivel.get(i));
					int aux = espaco + 1;
					segundaParte(novo_nivel, aux, nivel.get(i));
					for (int k = 0; k < espaco; k++) {

						System.out.print("\t");
					}
					System.out.println(nivel.get(i).getFechamento_tag());

				}
			}
		}
	}

	public void arrumarDiagrama() {
		findRoot();
		ArrayList<Feature> nivel0 = new ArrayList<Feature>();
		nivel0.add(getRoot());
		niveis.add(nivel0);
		pais = nivel0;
		while (pais.size() > 0) {
			// System.out.println("NOVO NIVEL");
			ArrayList<Feature> novo_nivel = new ArrayList<Feature>();
			pais.forEach((pai) -> {
				filhos = acharFilhos(pai);
				filhos.forEach((f) -> {
				
					novo_nivel.add(f);
				});

			});
			niveis.add(novo_nivel);
			pais = novo_nivel;

		}
		arrumarNiveis();

	}	

	public void mostrarVariability() {
		variability.forEach((var) -> {
			System.out.println(var.getCategory());
			// System.out.println(var.getNode_type());
			System.out
					.println("Feature pai " + var.getPai().getId() + " " + var.getPai().getName() + " " + var.getId());
			var.mostrarArray();
			System.out.println(" ");
		});
	}

	public void mostrarConnection() {
		connection.forEach((conn) -> {
			System.out.println(conn.getTarget().getId() + " " + conn.getSource().getId() + " " + conn.getCategory());
		});
	}

	public ArrayList<ArrayList<Feature>> getNiveis() {
		return niveis;
	}

}
