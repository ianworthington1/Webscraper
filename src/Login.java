import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Login {
	
	public static Document Login() {
		Document loginPage;
		Document doc = null;
		
		Scanner userInput = new Scanner(System.in);
		
		try {
//			loginPage = Jsoup.connect("https://samp-wearlenses.kallysoft.ch/my-account/login").userAgent("Mozilla").get();
//			
//			String title = loginPage.title();
//			Title = ("Title: " + title);
			System.out.println("Enter URL: ");
			String input = userInput.nextLine() ;
			URL url = new URL(input);
			userInput.close();
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			String line = null;
			StringBuilder tmp = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = in.readLine()) != null) {
				tmp.append(line);
			}
			
			doc = Jsoup.parse(tmp.toString());
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("done");
		return doc;
	}
}