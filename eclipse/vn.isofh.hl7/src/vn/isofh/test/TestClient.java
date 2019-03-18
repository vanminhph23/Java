package vn.isofh.test;

import javax.ws.rs.WebApplicationException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TestClient {

	public static void main(String[] args) {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);

		String url = "http://localhost:8181/vn.isofh.hl7/isofh/test";
		WebResource webResourceGet = client.resource(url);
		ClientResponse response = webResourceGet.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new WebApplicationException();
		}
		
		Object responseEntity = response.getEntity(Object.class);
		System.out.println(responseEntity.toString());
	}

}
