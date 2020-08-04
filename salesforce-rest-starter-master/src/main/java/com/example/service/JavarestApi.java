package com.example.service;

import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JavarestApi {
	private static final String clientId = "3MVG9n_HvETGhr3BUUg8VWsO9t6e32rQS3iTu.hPS51o9pbSm6Q9_qA4Zo6peRWzDXDp4TAcvA1GwWVg1MKSK";
	private static final String clientSecret = "282091D72C42BFFFD62C252B610E9293846975E0D644342181F799F1BC3869B4";
//	private static final String redirectUrl = "https://localhost:8443/RestTest/oauth/_callback";
	private static String tokenUrl = "";
	private static final String environment = "https://ap16.salesforce.com";
	private static final String username = "kalidas@lti.com";
	private static final String password = "AaiBaba1415";

	private static String accessToken = "";
	private static String instanceUrl = "";

	public static void main(String ar[]) {
		System.out.println("----------getting a token---------");

		tokenUrl = environment + "/services/oauth2/token";
		System.out.println("tokenUrl    ........." + tokenUrl);
		HttpClient httpclient = new HttpClient();
		//httpclient.getParams().setParameter(HttpClientParams.ALLOW_CIRCULAR_REDIRECTS, true);
		httpclient.getParams().setParameter(HttpClientParams.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);

		PostMethod post = new PostMethod(tokenUrl);
		post.addParameter("grant_type", "password");
		post.addParameter("client_id", clientId);
		post.addParameter("client_secret", clientSecret);
		//post.addParameter("redirect_url", redirectUrl);
		post.addParameter("username", username);
		post.addParameter("password", password);

		try {
			httpclient.executeMethod(post);
			JSONObject authResponse = new JSONObject(
					new JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
			System.out.println("Auth Response :-" + authResponse.toString(2));

			accessToken = authResponse.getString("access_token");
			instanceUrl = authResponse.getString("instance_url");

			System.out.println("Got Access Token " + accessToken);
			System.out.println("Got Instance Url " + instanceUrl);

			new JavarestApi().createaccount(instanceUrl, accessToken);
		} catch (Exception e) {
			System.out.println("Exception during Connect" + e);
		}

	}

	private String createaccount(String instanceUrl, String accessToken) throws Exception {
		System.out.println("----------start account--------");
		HttpClient httpclient = new HttpClient();
		JSONObject account = new JSONObject();
		String accountId = "";

		try {
			account.put("Name", "Amol");
			account.put("AccountNumber", "98123");

			PostMethod post = new PostMethod(instanceUrl + "/services/data/v20.0/sobjects/Account/");
			post.setRequestHeader("Authorization", "OAuth" + accessToken);
			post.setRequestEntity(
					new StringRequestEntity(account.toString(), "application/x-www-form-urlencoded", null));

			httpclient.executeMethod(post);
			System.out.println("HTTP status" + post.getStatusCode() + "creating account\n\n");
			if (post.getStatusCode() == HttpStatus.SC_CREATED) {
				try {
					JSONObject response = new JSONObject(
							new JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
					System.out.println("create response" + response.toString(2));
					if (response.getBoolean("success")) {
						accountId = response.getString("id");

						System.out.println("new record id:-" + accountId + "\n\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------end account--------");
		return accountId;
	}

}
