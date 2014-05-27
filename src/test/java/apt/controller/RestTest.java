package apt.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * Created by Jérémie Drouet on 27/05/14.
 */
public class RestTest {

    protected <T> HttpEntity<T> prepare(T object) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //
        return new HttpEntity<T>(object, headers);
    }
}
