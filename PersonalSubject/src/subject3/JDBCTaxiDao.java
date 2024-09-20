package subject3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTaxiDao implements TaxiDao{

	@Override
	public boolean insert(Taxi taxi) {
		boolean result = false;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement pStatement 
			= connection.prepareStatement("insert into taxi (name, taxiNum, type) values (?, ?, ?)")){
			
			pStatement.setString(1, taxi.getName());
			pStatement.setInt(2, taxi.getTaxiNum());
			pStatement.setString(3, taxi.getType());
				
			
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
	public List<Taxi> findAll() {
		List<Taxi> tLst = new ArrayList<Taxi>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"select * from taxi order by taxiNum desc");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Taxi taxi = new Taxi(
						rs.getString("name"),
						rs.getInt("taxiNum"),						
						rs.getString("type"));
				
				tLst.add(taxi);
				
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return tLst;
	}

	@Override
	public Taxi find(int taxiNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "select * from taxi where taxiNum = ?"))
	        {
	            pStatement.setInt(1, taxiNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return null;
	    }
	@Override
	public boolean update(Taxi taxi) {
		try (Connection conn = DataSource.getDataSource();
			       PreparedStatement pStatement = conn.prepareStatement(
			    		"update bus set name = ? , type = ? where taxiNum = ? "))
			        {
			        	pStatement.setString(1, taxi.getName());
			    		pStatement.setString(2, taxi.getType());
			    		pStatement.setInt(3, taxi.getTaxiNum());

			            pStatement.executeUpdate();
			        }
			        catch (Exception e)
			        {
			            e.printStackTrace();
			        }


			        return false;
			    }


	@Override
	public boolean delete(int taxiNum) {
		 try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "delete from taxi where taxiNum = ?"))
	        {
	            pStatement.setInt(1, taxiNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return false;
	 }

}
