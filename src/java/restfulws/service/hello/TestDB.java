/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restfulws.service.hello;

import connection.DbConnection;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Menes
 */
@Stateless
@Path("/testdb")
public class TestDB {
    
    @GET
    public String testDb( ){
        DbConnection c = new DbConnection();
        return c.runSqlStatement();
    }
    
}
