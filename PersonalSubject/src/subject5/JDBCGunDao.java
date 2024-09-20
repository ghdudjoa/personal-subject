package subject5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCGunDao implements GunDao{

	@Override
	public boolean insert(Gun gun) {
		boolean result = false;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement pStatement 
			= connection.prepareStatement("insert into gun (name, price, function, gunNum) values (?, ?, ?, ?)")){
			
			pStatement.setString(1, gun.getName());
			pStatement.setInt(2, gun.getPrice());
			pStatement.setString(3, gun.getFunction());
			pStatement.setInt(3, gun.getGunNum());	
			
			int affectedRows = pStatement.executeUpdate();
			
			if(affectedRows > 0) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	
	}

	@Override
	public List<Gun> findAll(Gun gun) {
		List<Gun> gunList = new ArrayList<Gun>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"select * from gun order by gunNum desc");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Gun gunInput = new Gun(
				rs.getString("name"),
				rs.getInt("price"),
				rs.getString("function"),
				rs.getInt("gunNum"));
				gunList.add(gunInput);
				
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return gunList;
	}

	@Override
	public Gun find(int gunNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "select * from gun where gunNum = ?"))
	        {
	            pStatement.setInt(1, gunNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return null;
	    }
	@Override
	public boolean update(Gun gun) {
		try (Connection conn = DataSource.getDataSource();
			       PreparedStatement pStatement = conn.prepareStatement(
			    		"update bus set name = ? , price = ?, function = ? where gunNum = ? "))
			        {
			        	pStatement.setString(1, gun.getName());
			    		pStatement.setInt(2, gun.getPrice());
			    		pStatement.setString(3, gun.getFunction());
			    		pStatement.setInt(4, gun.getGunNum());
			    		
			    		
			            pStatement.executeUpdate();
			        }
			        catch (Exception e)
			        {
			            e.printStackTrace();
			        }


			        return false;
			    }


	@Override
	public boolean delete(int gunNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "delete from gun where gunNum = ?"))
	        {
	            pStatement.setInt(1, gunNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return false;
	 }
}
