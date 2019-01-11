package com.ccip.bank.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

import com.jfinal.core.Controller;


/**
 * @date 2018年3月29日 下午9:17:19 
 * @author Mason
 * Rdf数据操作方法封装
 * @params company_name
 */
public class EnterpriseInfoRdf extends Controller{

    static // get WEB Root path
    String paths = System.getProperty("user.dir");
    static String dataSetPrex = paths + "/datasets/rdfData/";	 
    String prefix="PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+ 
            "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#>"+ 
            "PREFIX owl:<http://www.w3.org/2002/07/owl#>"+ 
            "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"+ 
            "PREFIX base:<http://ccip.ucas.ac.cn/resource#>"+ 
            "PREFIX enterprise:<http://ccip.ucas.ac.cn/ontology/company#>";
    static String filePath = dataSetPrex; //data resource

    //basicInfo dataInterface
    public   Map<String,Object>  basicInfo(String company){
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        ontModel.read(filePath + company + ".rdf");
        String queryString = "SELECT ?property ?value"
                +" WHERE " +
                "{ base:"+ company  +"的企业概况 ?property    ?value}";
        Query query = QueryFactory.create(prefix + queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
        ResultSet rs = qe.execSelect();
        Map<String, Object> params=new HashMap<String, Object> ();
        while(rs.hasNext()){			
            QuerySolution soln = rs.nextSolution() ;
            RDFNode key = soln.get("property");
            RDFNode value = soln.get("value");
            String keys = key.toString().split("#")[1];
            params.put(keys, value);			

        }
        return params;

    }


    /**
     *@author Mason
     *@deprecated tax-Info
     *@date 20190111
     */
    @Deprecated
    public Map<String, Object> taxInfo(String company) {
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        ontModel.read(filePath + company + ".rdf");
        String queryString = "SELECT ?property ?value"
                +" WHERE " +
                "{ base:"+ company  +"的税务信息 ?property    ?value}";
        Query query = QueryFactory.create(prefix + queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, ontModel);  
        ResultSet rs = qe.execSelect();
        Map<String, Object> params=new HashMap<String, Object> ();
        while(rs.hasNext()){            
            QuerySolution soln = rs.nextSolution() ;
            RDFNode key = soln.get("property");
            RDFNode value = soln.get("value");
            String keys = key.toString().split("#")[1];
            params.put(keys, value);            

        }
        return params;
    }


    /**
     *@author Mason
     *@deprecated debt-Info
     *@date 20190111
     *@return params
     */
    @Deprecated
    public Map<String, Object> debtInfo(String company) {
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        ontModel.read(filePath + company + ".rdf");
        String queryString = "SELECT ?property ?value"
                +" WHERE " +
                "{ base:"+ company  +"的经营性负债偿还情况?property    ?value}";
        Query query = QueryFactory.create(prefix + queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, ontModel);  
        ResultSet rs = qe.execSelect();
        Map<String, Object> params=new HashMap<String, Object> ();
        while(rs.hasNext()){            
            QuerySolution soln = rs.nextSolution() ;
            RDFNode key = soln.get("property");
            RDFNode value = soln.get("value");
            String keys = key.toString().split("#")[1];
            params.put(keys, value);            

        }
        return params;
    }
}

