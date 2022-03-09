package com.demo.config;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * 忽略https认证验证
 */
@Configuration
public class HttpsConfig {

//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        return new RestTemplate(factory);
//    }

//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory(HttpComponentsClientHttpRequestFactory requestFactory) {
//        requestFactory.setConnectTimeout(15000);
//        requestFactory.setReadTimeout(5000);
//        return requestFactory;
//    }

//    @Bean
//    public static HttpComponentsClientHttpRequestFactory generateHttpRequestFactory() throws Exception {
//        TrustStrategy acceptingTrustStrategy = (x509Certificates, authType) -> true;
//        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
//        SSLConnectionSocketFactory connectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
//
//        HttpClientBuilder httpClientBuilder = HttpClients.custom();
//        httpClientBuilder.setSSLSocketFactory(connectionSocketFactory);
//        CloseableHttpClient httpClient = httpClientBuilder.build();
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setHttpClient(httpClient);
//        return factory;
//    }

    @Bean
    public RestTemplate httpsRestTemplate(HttpComponentsClientHttpRequestFactory httpsFactory) {
        //设置超时时间60s
        httpsFactory.setConnectTimeout(60*1000);
        httpsFactory.setReadTimeout(60*1000);

        RestTemplate restTemplate = new RestTemplate(httpsFactory);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) {
                return false;
            }
            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) {
                //默认处理非200的返回，会抛异常
            }
        });
        return restTemplate;
    }

    @Bean(name = "httpsFactory")
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() throws Exception {
        CloseableHttpClient httpClient = acceptsUntrustedCertsHttpClient();
        HttpComponentsClientHttpRequestFactory httpsFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        httpsFactory.setReadTimeout(2000);//the timeout value in milliseconds
        httpsFactory.setConnectTimeout(2000);//the timeout value in milliseconds
        return httpsFactory;
    }

    public CloseableHttpClient acceptsUntrustedCertsHttpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        HttpClientBuilder b = HttpClientBuilder.create();
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] arg0, String arg1) {
                return true;
            }
        }).build();
        b.setSSLContext(sslContext);

        HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connMgr.setMaxTotal(200);
        connMgr.setDefaultMaxPerRoute(100);
        b.setConnectionManager(connMgr);
        // finally, build the HttpClient;
        CloseableHttpClient client = b.build();
        return client;
    }

}
