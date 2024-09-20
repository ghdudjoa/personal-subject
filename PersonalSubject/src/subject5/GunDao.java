package subject5;

import java.util.List;

public interface GunDao {
	boolean insert(Gun gun);
	List<Gun> findAll(Gun gun);
	Gun find(int gunNum);
	boolean update(Gun gun);
	boolean delete(int gunNum);
}
