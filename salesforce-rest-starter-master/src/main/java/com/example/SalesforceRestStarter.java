package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesforceRestStarter {

	private static final String TOKEN_URL = "https://ap16.salesforce.com/services/oauth2/token";
	private static final String username = "kalidas@lti.com";
	private static final String password = "AaiBaba14157kigamPYBN06jWfGmp8ypPXgd";
	private static final String consumerKey = "3MVG9n_HvETGhr3BUUg8VWsO9t6e32rQS3iTu.hPS51o9pbSm6Q9_qA4Zo6peRWzDXDp4TAcvA1GwWVg1MKSK";
	private static final String consumerSecret = "282091D72C42BFFFD62C252B610E9293846975E0D644342181F799F1BC3869B4";

	public static void main(String[] args) throws Exception {
		try {
			// login
			final CloseableHttpClient httpclient = HttpClients.createDefault();

			final List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
			loginParams.add(new BasicNameValuePair("grant_type", "password"));
			loginParams.add(new BasicNameValuePair("client_id", consumerKey));
			loginParams.add(new BasicNameValuePair("client_secret", consumerSecret));
			loginParams.add(new BasicNameValuePair("username", username));
			loginParams.add(new BasicNameValuePair("password", password));

			final HttpPost post = new HttpPost(TOKEN_URL);
			post.setEntity(new UrlEncodedFormEntity(loginParams));

			final HttpResponse loginResponse = httpclient.execute(post);

			// parse
			final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

			final JsonNode loginResult = mapper.readValue(loginResponse.getEntity().getContent(), JsonNode.class);
			final String accessToken = loginResult.get("access_token").asText();
			final String instanceUrl = loginResult.get("instance_url").asText();

			// query contacts
			final URIBuilder builder = new URIBuilder(instanceUrl);
			builder.setPath("/services/data/v39.0/query/").setParameter("q", "SELECT Id, Name FROM Contact");

			final HttpGet get = new HttpGet(builder.build());
			get.setHeader("Authorization", "Bearer " + accessToken);

			final HttpResponse queryResponse = httpclient.execute(get);

			final JsonNode queryResults = mapper.readValue(queryResponse.getEntity().getContent(), JsonNode.class);

			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(queryResults));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
