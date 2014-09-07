package dataid.virtuosoLoader;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

public class VirtuosoTools {

	private static final String virtuosoUser = "dba";
	private static final String virtuosoPass = "dba";
	private static final String virtuosoHost = "localhost";
	private static final String virtuosoPort = "1111";

	public static VirtGraph graph = null;

	protected static void load() {
		if (graph == null)
			graph = new VirtGraph("jdbc:virtuoso://" + virtuosoHost + ":"
					+ virtuosoPort, virtuosoUser, virtuosoPass);
	}

	public VirtuosoTools() {
		load();
	}

	public static void insertByString(String str) {
		load();
		VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(str, graph);
		vur.exec();
		graph.clear();
	}
	
	public static void insertByResultSet(ResultSet data){
		
	}

	public static ResultSet query(String queryString) {
		load();
		Query sparql = QueryFactory.create(queryString);
		VirtuosoQueryExecution qExec = VirtuosoQueryExecutionFactory.create(
				sparql, graph);
		return qExec.execSelect();

	}

}
