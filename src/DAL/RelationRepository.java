package DAL;

import java.sql.Connection;
import java.sql.ResultSet;

public class RelationRepository extends BaseRepository {

	public boolean addRelation_owns(int ownerId, int pageId) {
		try(Connection con = getConnection()){
			String qry = "INSERT IGNORE INTO ownes(page, user) VALUES (" + pageId + ", " + ownerId + ");";
			System.out.println(qry);
			con.createStatement().executeQuery(qry);
			return true;
		}catch(Exception e){
		}
		return false;
	}

}
