//package importFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import javax.xml.xpath.XPathExpressionException;
//
//public class TypeFile {
//	
//    
//    /*
//    Funcao que faz a copia do arquivo de entrada para alterar sua extensão
//	de .smty para .xml
//	recebe o file de entrada e o de destino
//	*/
//    static void copy(File src, File dst) throws IOException {
//    	InputStream in = new FileInputStream(src);
//    	OutputStream out = new FileOutputStream(dst);  
//    	byte[] buf = new byte[1024];
//    	int len;
//    	while ((len = in.read(buf)) > 0) {
//    		out.write(buf, 0, len);
//    	}
//    	in.close();
//    	out.close();
//    }
//
//
//    public static void main(String[] args) throws XPathExpressionException, IOException {
//    	
//    	try {
//    		File fileIn     = new File("smToFeatureide/arquivosEntradaSm/TraducaoOr.smty");
//            File fileOut     = new File("smToFeatureide/arquivosEntradaSmXml/TraducaoOr.xml");
//            copy(fileIn, fileOut);
//            System.out.println("Arquivo copiado para smToFeatureide/arquivosEntradaSmXml/ ");
//    	}catch(Exception error) {
//    		System.out.println("Algo deu errado"+ error);
//    	}
//        
//    }
//}
