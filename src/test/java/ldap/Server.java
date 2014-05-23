package ldap;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.sdk.LDAPException;

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

    public static void main(String[] args) throws IOException, LDAPException {
        Server.getInstance().start();
    }

    private int port;
    private String ldifFile;
    private String adminDn;
    private String adminPassword;
    private InMemoryDirectoryServer directoryServer;

    private Server() {
        this.ldifFile = "src/test/resources/ldap-content.ldif";
        this.port = 10983;
        this.adminDn = "uid=admin, ou=Administrator, o=Best ever, dc=example, dc=com";
        this.adminPassword = "password";
    }

    public void start() throws LDAPException {
        InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig("dc=example, dc=com");
        config.setSchema(null);
        config.addAdditionalBindCredentials(this.adminDn, this.adminPassword);
        config.setListenerConfigs(InMemoryListenerConfig.createLDAPConfig("LDAP", this.port));

        this.directoryServer = new InMemoryDirectoryServer(config);
        this.directoryServer.importFromLDIF(true, this.ldifFile);
        this.directoryServer.startListening();
    }

    public void stop() {
        this.directoryServer.shutDown(true);
    }
}
