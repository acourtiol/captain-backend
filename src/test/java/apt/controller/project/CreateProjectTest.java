package apt.controller.project;

import apt.Application;
import apt.controller.RestTest;
import apt.model.Account;
import apt.model.InternalAccount;
import apt.model.Project;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class CreateProjectTest extends RestTest {

    @Value("${local.server.port}")
    private int port;

    private Account account;

    @Before
    public void before() {
        InternalAccount account = new InternalAccount();
        account.setIdAccount(1L);
        account.setUsername("demo");
        account.setPassword("demo");
        //
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<InternalAccount> accountResponseEntity = restTemplate.postForEntity("http://localhost:" + port + "/account/create/internal.json", prepare(account), InternalAccount.class);
        Assert.assertNotNull(accountResponseEntity.getBody());
        this.account = accountResponseEntity.getBody();
    }

    @Test
    public void saveNewInstance() {
        Project project = new Project();
        project.setOwner(this.account);
        project.setTitle("test");
        project.setDescription("test");
        //
        //
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<Project> projectResponseEntity = restTemplate.postForEntity("http://localhost:" + port + "/project/create.json", prepare(project), Project.class);
        Assert.assertNotNull(projectResponseEntity.getBody());
    }

}
