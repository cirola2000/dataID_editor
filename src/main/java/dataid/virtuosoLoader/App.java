package dataid.virtuosoLoader;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * Hello world!
 *
 */
public class App {
	static final Logger logger = Logger.getLogger(App.class);

	static final String dbpediaSparqlEndPoint = "http://DBpedia.org/sparql";

	public static void main(String[] args) {
		// Model model = FileManager.get().loadModel("dataId.ttl");

		// String NS = "http://aksw.org/dataId.ttl/#kore50-nif";
		// Resource title2 = model.getResource(NS);

		// for (StmtIterator i = title2.listProperties(); i.hasNext();) {
		// Statement s = i.next();
		// System.out.println("property " + s.getPredicate() + " with value "
		// + s.getObject());
		//


		final String uri = "http://brown.nlp2rdf.org/dataid.ttl";
		final Model model = ModelFactory.createDefaultModel();
		model.read(uri,null,"TTL");
		model.write(System.out);
		
		
		
	}

}
