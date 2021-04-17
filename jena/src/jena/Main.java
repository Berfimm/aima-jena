package jena;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionRemote;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 RDFConnection conn0 = RDFConnectionRemote.create()
		            .destination("http://localhost:3030/VideoGameOntology")
		            .queryEndpoint("sparql")
		             
		            .acceptHeaderSelectQuery("application/sparql-results+json, application/sparql-results+xml;q=0.9")
		            .build();
		         
		  //Query query = QueryFactory.create("SELECT  *{ ?class ?label ?description }");
		 
		 //gives me data properties
		    Query query2 = QueryFactory.create
		    		("prefix vgo:  <http://www.semanticweb.org/berfimkorkmaz/ontologies/2020/11/untitled-ontology-28#>\r\n"
		    	    +"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
		    		+"prefix owl: <http://www.w3.org/2002/07/owl#>"
	        		+"\r\n"
	        		+"\r\n"
	        		+"SELECT distinct ?dataprop ?label "
	        		+"WHERE {?dataprop a owl:DatatypeProperty .OPTIONAL { ?dataprop rdfs:label ?label } }"
		    				);
		    //gives me player's individuals data and object properties
		    Query query3 = QueryFactory.create
		    		("prefix vgo:  <http://www.semanticweb.org/berfimkorkmaz/ontologies/2020/11/untitled-ontology-28#>\r\n"
		    	    +"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
		    		+"prefix owl: <http://www.w3.org/2002/07/owl#>"
	        		+"\r\n"
	        		+"SELECT ?inst ?p ?o "
	        		+"WHERE {?inst a vgo:Player . ?inst ?p ?o . }"
		    				);
		    //give me healingtimeof username
		    Query query4 = QueryFactory.create
		    		("prefix vgo:  <http://www.semanticweb.org/berfimkorkmaz/ontologies/2020/11/untitled-ontology-28#>\r\n"
		    	    +"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
		    		+"prefix owl: <http://www.w3.org/2002/07/owl#>"
	        		+"\r\n"
	        		+"\r\n"
	        		+"SELECT ?Player ?rname  ?lname "
	        		+"\r\n"
	        		+"\r\n"
	        		+"WHERE  {VALUES ?Player {vgo:Player2} .?inst vgo:healingTimeOfPlayer ?rname .?inst vgo:username ?lname .}"
		    				);
		        
		    //Give me player1 and player2 healingtimes
		    Query query5 = QueryFactory.create
		    		("prefix vgo:  <http://www.semanticweb.org/berfimkorkmaz/ontologies/2020/11/untitled-ontology-28#>\r\n"
		    	    +"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
		    		+"prefix owl: <http://www.w3.org/2002/07/owl#>"
	        		+"\r\n"
	        		+"\r\n"
	        		+"SELECT * "
	        		+"WHERE  {VALUES ?Player {vgo:Player1 vgo:Player2}. ?Player vgo:healingTimeOfPlayer ?lname}"
		    				);
		    
		    /*Query query7= QueryFactory.create
		    		("prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
		    				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
		    				+ "prefix owl: <http://www.w3.org/2002/07/owl#>\r\n"
		    				+ "prefix xsd: <http://www.w3.org/2001/XMLSchema#>\r\n"
		    				+ "prefix vgo: <http://www.semanticweb.org/berfimkorkmaz/ontologies/2020/11/untitled-ontology-28#> \r\n"
		    				+ "prefix re: <http://www.w3.org/2000/10/swap/reason#>\r\n"
		    				+ "\r\n"
		    				+ "SELECT * \r\n"
		    				+ "WHERE {   \r\n"
		    				+ "   ?x vgo:hasName ?name.\r\n"
		    				+ "   ?x vgo:damageOfGun ?dam.\r\n"
		    				+ "   ?x vgo:bulletNumber ?bltNum.\r\n"
		    				+ "   FILTER(?bltNum= '30').\r\n"
		    				+ "}"
		    				);*/
		    
		    
		    //bulletNumber of Guns   
		    Query query6 = QueryFactory.create
		    		("prefix vgo:  <http://www.semanticweb.org/berfimkorkmaz/ontologies/2020/11/untitled-ontology-28#>\r\n"
		    	    +"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
		    		+"prefix owl: <http://www.w3.org/2002/07/owl#>"
	        		+"\r\n"
	        		+"\r\n"
	        		+"SELECT * "
	        		+"WHERE  {VALUES ?Guns {vgo:M416 vgo:AKM vgo:Bazooka}. ?Guns vgo:bulletNumber ?lname}"
	        		+"ORDER BY DESC(?bulletNumber)"
		    				);
		       
		    Query query8 = QueryFactory.create
		    		("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
		    				+ "prefix owl: <http://www.w3.org/2002/07/owl#>\r\n"
		    				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
		    				+ "prefix vgo: <http://purl.org/net/VideoGameOntology#>\r\n"
		    				+ "\r\n"
		    				+ "SELECT DISTINCT ?Item ?itemIngame ?playerItem\r\n"
		    				+ "WHERE {\r\n"
		    				+ "  {?itemIngame rdf:type ?Item;}\r\n"
		    				+ "  {?playerItem rdf:type ?Item;}\r\n"
		    				+ "      \r\n"
		    				+ "  FILTER regex(str(?itemIngame), \"Barrel\").\r\n"
		    				+ "  FILTER regex(str(?playerItem), \"Backpack\").\r\n"
		    				+ "   \r\n"
		    				+ "}"
		    				);

		        // Whether the connection can be reused depends on the details of the implementation.
		        // See example 5.
		        try ( RDFConnection conn = conn0 ) { 
		        	 //conn.queryResultSet(query, ResultSetFormatter::out);
		        	 conn.queryResultSet(query2, ResultSetFormatter::out);
		        	 conn.queryResultSet(query3, ResultSetFormatter::out);
		        	 conn.queryResultSet(query4, ResultSetFormatter::out);
		        	 conn.queryResultSet(query5, ResultSetFormatter::out);
		        	 conn.queryResultSet(query6, ResultSetFormatter::out);
		        	 //conn.queryResultSet(query7, ResultSetFormatter::out);
		        	 conn.queryResultSet(query8, ResultSetFormatter::out);
		           }
		        catch(Exception e) {
		        	e.printStackTrace();}
		        }
		
	}


