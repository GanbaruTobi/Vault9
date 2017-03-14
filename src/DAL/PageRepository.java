package DAL;

import java.sql.Connection;
import java.sql.ResultSet;

import models.Page;

public class PageRepository extends BaseRepository{

	public int addPage(Page page) {
		try(Connection con = getConnection()){
			String qry = "INSERT IGNORE INTO pages(title, content, numberOfAttachments, numberOfPrevVersions, numberOfLinks, url, latestVersion) VALUES ('" + page.getTitle() +"', '" + page.getContent() + "', " + page.getNumberOfAttachments() + ", " + page.getNumberOfPrevVersions() + ", " + page.getNumberOfLinks() + ", '" + page.getUrl() + "'," + page.getLatestVersion() + ");";
			System.out.println(qry);
			con.createStatement().executeQuery(qry);
			ResultSet rs = con.createStatement().executeQuery("SELECT id FROM pages WHERE title='" + page.getTitle() + "';");
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
		}
		return -1;
	}

}
