package apt.config.db;

import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author jeremie.drouet
 * @date 21/05/14
 */
@Component("sessionFactory")
public class SessionFactory extends LocalSessionFactoryBean {

    public SessionFactory() {
        this.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
    }

}
