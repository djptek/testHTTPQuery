import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class testHTTPQuery {

    public static void callServlet(String sTargetHost) {
        try {
            URL url = new URL(sTargetHost);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setDoInput(true);
            http.setRequestMethod("GET");

            System.out.println("GET [" + sTargetHost + "]\n");

            //Connect:
            http.connect();

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

    public static void main(String[] args) {

        String sTargetHost  = "http://127.0.0.1:8080/";
	int iSleepTimeMs = 10000;

	while (true) {
            callServlet(sTargetHost);
	    try {
                Thread.sleep(iSleepTimeMs);
	    }
            catch( InterruptedException e ) {
                System.out.println("Exiting...\n");
	    }
        }
    }
}


