package org.qa.light.session17;

import lombok.SneakyThrows;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.testng.annotations.Test;

public class ApacheHttpTests {

    @SneakyThrows
    @Test
    public void testApacheHttp() {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.google.com");
        String s =client.execute(httpGet, r -> {
            return r.getEntity().getContentType();
        });
        System.out.println(s);
    }
}
