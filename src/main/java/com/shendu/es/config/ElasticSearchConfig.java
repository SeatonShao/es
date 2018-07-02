package com.shendu.es.config;

import java.io.IOException;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com/shendu/es/repositories")
public class ElasticSearchConfig {

	@Bean
	public TransportClient transportClient() {
		Settings settings = Settings.builder().build();
		TransportClient transportClient = new PreBuiltTransportClient(settings);
		return transportClient;
	}
	
	@Bean
    public ElasticsearchOperations elasticsearchTemplate() throws IOException {
		ElasticsearchTemplate elasticsearchTemplate= null;
		Node client = null;
		try {
			Settings settings = Settings.builder().build();
			client = new Node(settings);
			elasticsearchTemplate = new ElasticsearchTemplate(client.client());
		}catch (Exception e) {
			
		}finally {
			client.close();
		}
        return elasticsearchTemplate;
    }
}
