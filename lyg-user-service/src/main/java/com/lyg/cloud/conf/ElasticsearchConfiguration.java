/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.conf;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.lyg.cloud.repository")
public class ElasticsearchConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchConfiguration.class);
	@Resource
    private Environment environment;
	@Value("${spring.data.elasticsearch.properties.host}")
	private String ELASTICSEARCH_HOST;
	@Value("${spring.data.elasticsearch.properties.port}")
	private String ELASTICSEARCH_PORT;
	
	@Value("${spring.data.elasticsearch.cluster-name}")
	private String CLUSTER_NAME;
	
    @Bean
    public Client client() {
    	LOGGER.warn("---从配置文件中获取参数：ELASTICSEARCH_HOST="+ ELASTICSEARCH_HOST);
    	
    	Settings settings = Settings.settingsBuilder().put("cluster.name", CLUSTER_NAME).build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        InetAddress ia = null;
        try {
        	ia = InetAddress.getByName(ELASTICSEARCH_HOST);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        if(ia !=null) {
        	TransportAddress address = new InetSocketTransportAddress(ia, Integer.parseInt(ELASTICSEARCH_PORT));
        	client.addTransportAddress(address);
        }
        LOGGER.debug("---配置马上要结束了---");
        LOGGER.error("---配置结束了--");
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }


}