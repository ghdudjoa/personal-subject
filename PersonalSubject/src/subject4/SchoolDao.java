package subject4;

import java.util.List;


public interface SchoolDao {
	boolean insert(School school);
	List<School> findAll();
	School find(int studentNum);
	boolean update(School school);
	boolean delete(int studentNum);
	
}
