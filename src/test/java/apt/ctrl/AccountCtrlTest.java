package apt.ctrl;

import apt.Application;
import apt.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author jeremie.drouet
 * @date 21/05/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class AccountCtrlTest {

    @Value("${local.server.port}")
    private int port;

    private String generateRandomUid() {
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            if (rand.nextBoolean()) {
                sb.append((char) ('a' + rand.nextInt('z' - 'a')));
            } else {
                sb.append("" + (rand.nextInt(10)));
            }
        }
        return sb.toString();
    }

    @Test
    public void createSuccess() throws Exception {
        Account account = new Account();
        account.setUid(generateRandomUid());
        //
        ResponseEntity<String> entity = new TestRestTemplate().postForEntity(
                "http://localhost:" + this.port + "/account/create", account, String.class);
        assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

}
