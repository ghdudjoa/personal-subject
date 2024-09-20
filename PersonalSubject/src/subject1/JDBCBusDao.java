package subject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCBusDao implements BusDao {

	@Override
	public boolean insert(Bus bus) {
		boolean result = false;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement pStatement 
			= connection.prepareStatement("insert into bus (name, busnum, time) values (?, ?, ?)")){
			
			pStatement.setString(1, bus.getName());
			pStatement.setString(2, bus.getBusNum());
			pStatement.setTimestamp(3, bus.getTime());
				
			
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
	public List<Bus> findAll() {
		List<Bus> bLst = new ArrayList<Bus>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"select * from bus order by busnum desc");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Bus bus = new Bus(
						rs.getString("name"),
						rs.getString("busnum"),						
						rs.getTimestamp("time"));
				
				bLst.add(bus);
				
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return bLst;
	}
	@Override
	public Bus find(String busNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "select * from bus where busnum = ?"))
	        {
	            pStatement.setString(1, busNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return null;
	    }


	@Override
	public boolean update(Bus bus) {
		  try (Connection conn = DataSource.getDataSource();
		       PreparedStatement pStatement = conn.prepareStatement(
		    		"update bus set name = ? , time = ? where busnum = ? "))
		        {
		        	pStatement.setString(1, bus.getName());
		    		pStatement.setTimestamp(2, bus.getTime());
		    		pStatement.setString(3, bus.getBusNum());

		            pStatement.executeUpdate();
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }


		        return false;
		    }

	@Override
	public boolean delete(String busnum) {
		 try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "delete from bus where busnum = ?"))
	        {
	            pStatement.setString(1, busnum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return false;
	    }

}
