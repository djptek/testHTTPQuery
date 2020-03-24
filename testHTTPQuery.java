import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class testHTTPQuery {

	public static void main(String[] args) {


		String sTargetHost  = "http://127.0.0.1:8888/";

		try {
			URL url = new URL(sTargetHost);

			HttpURLConnection http = (HttpURLConnection)url.openConnection();

			http.setDoInput(true);
			http.setDoOutput(true);
			http.setRequestMethod("GET");
			//http.setConnectTimeout(1000);
			//http.setReadTimeout(10000);

			System.out.println("GET [" + sTargetHost + "]\n");

			//Connect:
			http.connect();

			//Send data to Stream:
			OutputStream myOutputStream = null;
			myOutputStream = http.getOutputStream ();

			//flush...
			myOutputStream.flush();
			myOutputStream.close();

			//Wait for answer.
			BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String inLine = null;


			while((inLine = in.readLine()) != null) {
				System.out.println(inLine + "\n");
			}

		}
		catch( java.net.MalformedURLException e ) {
			e.printStackTrace();
		}
		catch( java.io.IOException e ) {
			e.printStackTrace();
		}
	}
}


