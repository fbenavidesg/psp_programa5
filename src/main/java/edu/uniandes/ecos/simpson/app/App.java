/******************************************************************************/
/* Programa ID: PSP_TAREA5                                                    */
/* Autor: Fredy Benavides                                                     */
/* Fecha: 04/03/2017                                                          */
/* Descripcion: Programa integra usando regla simpson y distribuci�n T        */
/*                                                                            */
/******************************************************************************/
package edu.uniandes.ecos.simpson.app;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import java.util.HashMap;
import java.util.Map;
import edu.uniandes.ecos.simpson.model.ResultSimpson;
import static spark.Spark.*;
/**
 * Clase principal funciona como controllador frontal
 * @author fbenavides
 */
public class App 
{
	/**
     * Metodo de entrada de la aplicacion implementa el motor de plantillas spart.
     * @param args
     * @throws IOException
     */
    public static void main( String[] args )
    {
    	port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
    	get("/", (req, res) -> {
    		String template = "index";
    		Map<String, Object> attributes = new HashMap<>();
    		String getX = req.queryParams("x");
    		String getDof = req.queryParams("dof");
    		String resultExpected = req.queryParams("resultExpected");
    		if( getX == null || getDof == null || resultExpected == null ){
    			attributes.put("uri", req.url());
    			template = "err";
    		}else{
    			ControllerApp controllerApp = new ControllerApp();
        		ResultSimpson resultSimpson = controllerApp.execute(Double.parseDouble(getX), Double.parseDouble(getDof), Double.parseDouble(resultExpected));
        		attributes.put("resultSimpson", resultSimpson);
    		}
            return new ModelAndView(attributes, template +".ftl");
    	},new FreeMarkerEngine());
    }
}
