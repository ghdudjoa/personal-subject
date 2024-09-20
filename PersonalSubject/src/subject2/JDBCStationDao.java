package subject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCStationDao implements StationDao{

	@Override
	public boolean insert(Station station) {
		boolean result = false;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement pStatement 
			= connection.prepareStatement("insert into station (name, stNum, address) values (?, ?, ?)")){
			
			pStatement.setString(1, station.getName());
			pStatement.setString(2, station.getStNum());
			pStatement.setString(3, station.getAddress());
				
			
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
	public List<Station> findAll() {
		List<Station> sLst = new ArrayList<Station>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"select * from station order by stNum desc");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Station station = new Station(
						rs.getString("name"),
						rs.getString("stNum"),						
						rs.getString("adrress"));
				
				sLst.add(station);
				
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return sLst;
	}

	@Override
	public Station find(String stNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "select * from station where stNum = ?"))
	        {
	            pStatement.setString(1, stNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return null;
	    }


	@Override
	public boolean update(Station station) {
		try (Connection conn = DataSource.getDataSource();
			       PreparedStatement pStatement = conn.prepareStatement(
			    		"update bus set name = ? , address = ? where stNum = ? "))
			        {
			        	pStatement.setString(1, station.getName());
			    		pStatement.setString(2, station.getAddress());
			    		pStatement.setString(3, station.getStNum());

			            pStatement.executeUpdate();
			        }
			        catch (Exception e)
			        {
			            e.printStackTrace();
			        }


			        return false;
			    }

	@Override
	public boolean delete(String stNum) {
		 try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "delete from station where stNum = ?"))
	        {
	            pStatement.setString(1, stNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return false;
	 }
}
