package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OwnerRepository extends BaseRepository {

	public int addOwner(String owner) {
		try(Connection con = getConnection()){
			System.out.println("INSERT IGNORE INTO user(name) VALUES ('" + owner + "');");
			PreparedStatement st = con.prepareStatement("INSERT IGNORE INTO user(name) VALUES (?)");
			st.setString(1,owner);
			st.executeQuery();
			PreparedStatement st2 = con.prepareStatement("SELECT id FROM user WHERE name=?");
			st2.setString(1, owner);
			ResultSet rs = st2.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}