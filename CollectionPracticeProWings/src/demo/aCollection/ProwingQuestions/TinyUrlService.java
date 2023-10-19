package demo.aCollection.ProwingQuestions;
//Questions -> 16
import java.util.HashMap;

public class TinyUrlService {
	
	private HashMap<String, String> urlMap;
	
	public TinyUrlService() {
		urlMap = new HashMap<>();
	}

	private String expandedUrl(String shortUrl) {
		return urlMap.get(shortUrl);
	}

	private String shortenUrl(String longUrl) {
		String shortUrl = generateShortUrl(longUrl);
		urlMap.put(shortUrl, longUrl);
		return shortUrl;
	}

	private String generateShortUrl(String longUrl) {
		int hashcode = longUrl.hashCode();
		String encoded = Integer.toString(Math.abs(hashcode), 36);
		return encoded.substring(0,6);
	}
	
	public static void main(String[] args) {
		TinyUrlService tinyUrlService = new TinyUrlService();
		
		String longUrl = "https://www.youtube.com/watch?v=jKdM8JF0hA8";
		System.out.println("Long URL is : " + longUrl);
		
		String shortUrl = tinyUrlService.shortenUrl(longUrl);
		System.out.println("Short URL : " + shortUrl);
		
		String expandUrl = tinyUrlService.expandedUrl(shortUrl);
		System.out.println("Expanded URL : " + expandUrl);
	}
}