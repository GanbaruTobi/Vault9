package main;

import javax.swing.text.InternationalFormatter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import models.Page;
import services.DbService;
import services.WebService;

public class Statup {

	public static void main(String[] args) {
		
		//startUrl
//		String url = "https://wikileaks.org/ciav7p1/cms/page_9535828.html";
//		String url = "https://wikileaks.org/ciav7p1/cms/page_15728902.html";
		String url = "https://wikileaks.org/ciav7p1/cms/page_9535552.html";

		//getServices
		WebService ws = new WebService();
		DbService dbs = new DbService();
		
		//getWebsite
		Document doc = ws.getWebsite(url);	
		
		//transform
		String docAsString = doc.text();
		
		//owner
		int indexOfOwnerName = docAsString.indexOf("Owner: ");
		String name = docAsString.substring(indexOfOwnerName, indexOfOwnerName + 20);
		String owner = name.replaceAll("[^0-9]+", "");
		
		//title
		Element title = doc.select("h2").get(0);
		String titleString = title.toString().replaceAll("<h2>", "").replaceAll("</h2>", "");
		
		//number of links
		int numberOfLinks = 0;
		Elements links = doc.select("a[href]");
		numberOfLinks = 0;
		for (Element element : links) {
			numberOfLinks++;
		}
		
		//number of attachments
		Element attachmentsString = doc.select("h3").get(4);
		Element ul = attachmentsString.nextElementSibling();
		Elements lis = ul.select("li");
		int numberOfAttachments = 0;
		for (Element element : lis) {
			numberOfAttachments++;
		}

		
		//number of previous Versions
		int numberOfPrevVersions = 0;		
		try{
			Element prevVersions = doc.select("h3").get(5);
			if(!prevVersions.toString().contains("Previous")){
				prevVersions = doc.select("h3").get(6);
			}
			String[] ary = prevVersions.nextElementSibling().toString().split("\\|");
			numberOfPrevVersions = ary.length - 2;
		}catch (Exception e){
			try{
				int indexOfPrevVersions = docAsString.indexOf("Previous versions:");
				String prevVersions = docAsString.substring(indexOfPrevVersions, indexOfPrevVersions + 200);
				String[] ary = prevVersions.split("\\|");
				numberOfPrevVersions = ary.length - 2;
			}catch(Exception f){
				
			}
		}

		
		//create the page
		Page page = new Page(titleString, docAsString, owner, numberOfLinks, numberOfAttachments, numberOfPrevVersions);
		
		
		//add to DB
		boolean success = dbs.addPageWithOwner(page, owner);
		System.out.println("Erfolgreich: " + success);


	}

}
