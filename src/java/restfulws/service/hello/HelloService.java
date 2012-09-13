/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restfulws.service.hello;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Menes
 */
@Stateless
@Path("/hello")
public class HelloService {
    
    @GET
    public String hello( @QueryParam("name") String name ){
        return "Hello! " + name;
    }

}
