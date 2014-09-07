package dataid.virtuosoLoader;

import org.junit.Test;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class QueryExternalEndPointTest {

	static final String dbpediaSparqlEndPoint = "http://DBpedia.org/sparql";
	
	@Test
	public void queryTest(){
		String queryString = " SELECT ?p ?s " + " WHERE {{ " + "   ?s "
				+ "      a " + "          ?p }} LIMIT 10";
		
		ResultSet results = QueryExternalEndPoint.query(queryString, dbpediaSparqlEndPoint);
		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			System.out.println(soln.get("?s") + " -> " + soln.get("?p"));
			System.out.println("\n");
		}	
	}
	
}
