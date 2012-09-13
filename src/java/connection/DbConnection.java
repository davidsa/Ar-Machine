/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

/**
 *
 * @author Menes
 */
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class DbConnection {
    
    private final static String createProfessor = 
            "INSERT INTO Professor(professorName, professorLastName, professorEmail, professorPassword) VALUES ('Dr Jimenez','Meneo','elmeneo@meneo.com','qwerty')";
 
    public Connection createConnection() throws IOException, ClassNotFoundException, SQLException {
 
        Connection connection;
         
        Properties prop = new Properties();
        System.out.println("test");
        //prop.load(new FileInputStream(/*System.getProperty("user.home") +*/ "/mydb.cfg"));
        //System.out.println("user.home: "+System.getProperty("user.home"));
        String host = "jdbc:mysql://mysql-armachine.jelastic.servint.net/Armachine";//prop.getProperty("host").toString();
        String username = "root"; //prop.getProperty("username").toString();
        String password = "armachinep"; //prop.getProperty("password").toString();
        String driver = "com.mysql.jdbc.Driver"; //prop.getProperty("driver").toString();
 
        System.out.println("host: " + host + "\\username: " + username + "\\password: " + password + "\ndriver: " + driver);
 
        Class.forName(driver);
        System.out.println("--------------------------");
        System.out.println("DRIVER: " + driver);
        connection = DriverManager.getConnection(host, username, password);
        System.out.println("CONNECTION: " + connection);
 
        return connection;
    }
    public String runSqlStatement() {
        String response = null;
        try {
            Statement statement = createConnection().createStatement();
            statement.execute(createProfessor);
            response = "Sentencia ejecutada"; 
            
        } catch (IOException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            response = "Error IOException";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            response = "Error Driver";
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            response = "Error SQLException";
        }
        return response;
    }
}
