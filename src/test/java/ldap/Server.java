package ldap;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jérémie Drouet on 22/05/14.
 */
public class Server {

    private static Server instance = null;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public static void main(String[] args) throws IOException {
        Server.getInstance().start();
    }

    private String hostname;
    private int port;
    private File serverHome;
    private File ldifFile;

    private Server() {
        this.serverHome = new File(System.getProperty("java.io.tmpFile"), "opendj");
        this.ldifFile = new File("src/test/resources/ldap-content.ldif");
        this.hostname = "localhost";
        this.port = 10983;
    }

    public void start() {
        // TODO
    }
}
