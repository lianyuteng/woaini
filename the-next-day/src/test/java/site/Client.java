package site;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Client {

	public static void main(String[] args) {

		CloseableHttpClient de = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8080/site/hehe");
		try {
			CloseableHttpResponse response = de.execute(post);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				de.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
