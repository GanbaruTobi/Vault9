package models;

public class Page {

	public Page(String title, String content, String owner, int numberOfLinks, int numberOfAttachments, int numberOfPrevVersions, String url, int latestVersion){
		this.title = title;
		this.content = "Lorem Ipsum";
		this.owner = owner;
		this.numberOfLinks = numberOfLinks;
		this.numberOfAttachments = numberOfAttachments;
		this.numberOfPrevVersions = numberOfPrevVersions;
		this.url = url;
		this.latestVersion = latestVersion;
		//System.out.println(title + "; " + owner + "; " + numberOfLinks + "; " + numberOfAttachments + "; "+ content + "; ");
	}
	
	private String title;
	private String content;
	private String owner;
	private int numberOfLinks;
	private int numberOfAttachments;
	private int numberOfPrevVersions;
	private String url;
	

	private int latestVersion;
	
	public int getLatestVersion() {
		return latestVersion;
	}
	public void setLatestVersion(int latestVersion) {
		this.latestVersion = latestVersion;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getNumberOfLinks() {
		return numberOfLinks;
	}
	public void setNumberOfLinks(int numberOfLinks) {
		this.numberOfLinks = numberOfLinks;
	}
	public int getNumberOfAttachments() {
		return numberOfAttachments;
	}
	public void setNumberOfAttachments(int numberOfAttachments) {
		this.numberOfAttachments = numberOfAttachments;
	}
	public int getNumberOfPrevVersions() {
		return numberOfPrevVersions;
	}
	public void setNumberOfPrevVersions(int numberOfPrevVersions) {
		this.numberOfPrevVersions = numberOfPrevVersions;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
