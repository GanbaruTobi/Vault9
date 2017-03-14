package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class OwnerRepository extends BaseRepository {

	public int addOwner(String owner) {
		try(Connection con = getConnection()){
			String qry = "INSERT IGNORE INTO user(name) VALUES ('" + owner + "');";
			System.out.println(qry);
			con.createStatement().executeQuery(qry);
			ResultSet rs = con.createStatement().executeQuery("SELECT id FROM user WHERE name='" + owner + "';");
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}

}
