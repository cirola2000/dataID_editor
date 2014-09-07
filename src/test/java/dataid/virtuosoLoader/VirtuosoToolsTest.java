package dataid.virtuosoLoader;

import org.junit.Test;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class VirtuosoToolsTest {

	
	@Test
	public void insertByStringTest(){
		/* STEP 2 */
		// String str = "CLEAR GRAPH <http://ciro>";
		// VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(str, graph);
		// vur.exec();
		String insertQuery = "INSERT INTO GRAPH <http://ciro> { <me> <name> 'cirola2' . <me> <age> 28. }";
		VirtuosoTools.insertByString(insertQuery);
	}
	
	@Test
	public void queryTest() {

		String queryString = "SELECT * FROM <http://ciro> WHERE { ?a ?b ?c } LIMIT 10";
		
		try {
			ResultSet results = VirtuosoTools.query(queryString);
			for (; results.hasNext();) {
				QuerySolution rs = results.nextSolution();
				RDFNode s = rs.get("a");
				RDFNode p = rs.get("b");
				RDFNode o = rs.get("c");
				System.out.println(" { " + s + " " + p + " " + o + " . }");
			}
		} finally {

		}

	}

}
