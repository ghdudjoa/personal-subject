package subject4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCSchoolDao implements SchoolDao {

	@Override
	public boolean insert(School school) {
		boolean result = false;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement pStatement 
			= connection.prepareStatement("insert into school (name, classNum, grade, studentNum) values (?, ?, ?, ?)")){
			
			pStatement.setString(1, school.getname());
			pStatement.setInt(2, school.getClassNum());
			pStatement.setDouble(3, school.getGrade());
			pStatement.setInt(3, school.getStudentNum());	
			
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
	public List<School> findAll() {
		List<School> schoolLst = new ArrayList<School>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"select * from school order by studentNum");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				School school = new School(
						rs.getString("name"),
						rs.getInt("classNum"),						
						rs.getDouble("grade"),
						rs.getInt("studentNum"));
				
				schoolLst.add(school);
				
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return schoolLst;
	}

	@Override
	public School find(int studentNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "select * from school where studentNum = ?"))
	        {
	            pStatement.setInt(1, studentNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return null;
	    }


	@Override
	public boolean update(School school) {
		try (Connection conn = DataSource.getDataSource();
			       PreparedStatement pStatement = conn.prepareStatement(
			    		"update bus set name = ? , classNum = ?, grade = ? where studentNum = ? "))
			        {
			        	pStatement.setString(1, school.getname());
			    		pStatement.setInt(2, school.getClassNum());
			    		pStatement.setDouble(3, school.getGrade());
			    		pStatement.setInt(4, school.getStudentNum());
			    		
			            pStatement.executeUpdate();
			        }
			        catch (Exception e)
			        {
			            e.printStackTrace();
			        }


			        return false;
			    }


	@Override
	public boolean delete(int studentNum) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "delete from school where studentNum = ?"))
	        {
	            pStatement.setInt(1, studentNum);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }


	        return false;
	 }

}
