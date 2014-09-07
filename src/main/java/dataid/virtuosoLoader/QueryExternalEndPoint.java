package dataid.virtuosoLoader;

import com.hp.hpl.jena.query.ARQ;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class QueryExternalEndPoint {
	

	static public ResultSet query(String queryString, String sparqlService) {
		// Defining SPARQL Query. This query lists, in all languages available,
		// the
		// abstract entries on Wikipedia/DBpedia for the planet Mars.
		String sparqlQueryString2 = " SELECT ?p ?s " + " WHERE {{ " + "   ?s "
				+ "      a " + "          ?p }} LIMIT 10";
		// "FILTER langMatches( lang(?o), 'EN' ) }}";

		Query query = QueryFactory.create(queryString);
		ARQ.getContext().setTrue(ARQ.useSAX);
		// Executing SPARQL Query and pointing to the DBpedia SPARQL Endpoint
		QueryExecution qexec = QueryExecutionFactory.sparqlService(
				"http://DBpedia.org/sparql", query);
		// Retrieving the SPARQL Query results
		ResultSet r = qexec.execSelect();
		qexec.close();
		return r;
		// Iterating over the SPARQL Query results
//		while (results.hasNext()) {
//			QuerySolution soln = results.nextSolution();
//			// Printing DBpedia entries' abstract.
//			System.out.println(soln.get("?s") + " -> " + soln.get("?p"));
//			System.out.println("\n");
//		}
//		qexec.close();

	}
	
}
