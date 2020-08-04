/*
 * package com.poc.SFIntegerationDemo.service;
 * 
 * import java.io.InputStreamReader; import java.util.Map;
 * 
 * import org.apache.commons.httpclient.HttpClient; import
 * org.apache.commons.httpclient.HttpStatus; import
 * org.apache.commons.httpclient.cookie.CookiePolicy; import
 * org.apache.commons.httpclient.methods.PostMethod; import
 * org.apache.commons.httpclient.methods.StringRequestEntity; import
 * org.apache.commons.httpclient.params.HttpClientParams; import
 * org.json.JSONObject; import org.json.JSONTokener; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.MediaType; import
 * org.springframework.stereotype.Service; import
 * org.springframework.util.LinkedMultiValueMap; import
 * org.springframework.util.MultiValueMap; import
 * org.springframework.web.client.RestTemplate;
 * 
 * @Service public class JavarestApi { private static final String clientId =
 * "3MVG9n_HvETGhr3BUUg8VWsO9t6e32rQS3iTu.hPS51o9pbSm6Q9_qA4Zo6peRWzDXDp4TAcvA1GwWVg1MKSK";
 * private static final String clientSecret =
 * "282091D72C42BFFFD62C252B610E9293846975E0D644342181F799F1BC3869B4"; //
 * private static final String redirectUrl =
 * "https://localhost:8443/RestTest/oauth/_callback"; private static String
 * tokenUrl = ""; private static final String environment =
 * "https://ap16.salesforce.com"; private static final String username =
 * "kalidas@lti.com"; private static final String password = "AaiBaba1415";
 * 
 * private static String accessToken = ""; private static String instanceUrl =
 * "";
 * 
 * public Object doSalesforceLogin() { tokenUrl = environment +
 * "/services/oauth2/token"; HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON);
 * 
 * MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
 * String>(); map.add("grant_type", "password"); map.add("client_id", clientId);
 * map.add("client_secret", clientSecret); map.add("username", username);
 * map.add("password", password);
 * 
 * Object response = this.restTemplate.postForObject(tokenUrl, map, Map.class);
 * 
 * // createaccountRest() return response; }
 * 
 * public Object createaccountRest(String instanceUrl, String accessToken)
 * throws Exception { HttpHeaders headers = new HttpHeaders();
 * headers.set("Authorization", "Bearer " + accessToken);
 * headers.setContentType(MediaType.APPLICATION_JSON); instanceUrl =instanceUrl
 * + "/services/data/v42.0/sobjects/Account/"; MultiValueMap<String, String> map
 * = new LinkedMultiValueMap<String, String>(); map.add("Name",
 * "Kalidas Baburao Khupte"); map.add("AccountNumber", "78945"); Object response
 * = this.restTemplate.postForObject(instanceUrl, map, Map.class); return
 * response; } public String createaccount(String instanceUrl, String
 * accessToken) throws Exception {
 * System.out.println("----------start account--------");
 * createaccountRest(instanceUrl,accessToken ); HttpClient httpclient = new
 * HttpClient(); JSONObject account = new JSONObject(); String accountId = "";
 * 
 * try {
 * 
 * account.put("Name", "Kalidas Baburao Khupte"); account.put("AccountNumber",
 * "1233");
 * 
 * PostMethod post = new PostMethod(instanceUrl +
 * "/services/data/v42.0/sobjects/Account/");
 * post.setRequestHeader("Authorization", "Bearer " + accessToken);
 * post.setRequestHeader("Content-Type", "application/json");
 * post.setRequestEntity(new StringRequestEntity(account.toString(),
 * "application/json", null));
 * 
 * httpclient.executeMethod(post); System.out.println("HTTP status " +
 * post.getStatusCode() + " creating account\n\n"); if (post.getStatusCode() ==
 * HttpStatus.SC_CREATED) { try { JSONObject response = new JSONObject( new
 * JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
 * System.out.println("create response" + response.toString(2)); if
 * (response.getBoolean("success")) { accountId = response.getString("id");
 * 
 * System.out.println("new record id:-" + accountId + "\n\n"); } } catch
 * (Exception e) { e.printStackTrace(); } }
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * System.out.println("----------end account--------"); return accountId; }
 * 
 * public String createProfile(String instanceUrl, String accessToken) throws
 * Exception { System.out.println("----------start account--------"); HttpClient
 * httpclient = new HttpClient(); JSONObject account = new JSONObject(); String
 * accountId = "";
 * 
 * try { account.put("Name", "Employee"); account.put("type", "Permanent");
 * 
 * PostMethod post = new PostMethod(instanceUrl +
 * "/services/data/v42.0/sobjects/Ac/"); post.setRequestHeader("Authorization",
 * "Bearer " + accessToken); post.setRequestHeader("Content-Type",
 * "application/json"); post.setRequestEntity(new
 * StringRequestEntity(account.toString(), "application/x-www-form-urlencoded",
 * null));
 * 
 * httpclient.executeMethod(post); System.out.println("HTTP status " +
 * post.getStatusCode() + " creating Profile\n\n"); if (post.getStatusCode() ==
 * HttpStatus.SC_CREATED) { try { JSONObject response = new JSONObject( new
 * JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
 * System.out.println("create response" + response.toString(2)); if
 * (response.getBoolean("success")) { accountId = response.getString("id");
 * 
 * System.out.println("new record id:-" + accountId + "\n\n"); } } catch
 * (Exception e) { e.printStackTrace(); } }
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * System.out.println("----------end account--------"); return accountId; }
 * 
 * 
 * }
 */