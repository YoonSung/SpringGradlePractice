package architree.yoon.repository;

import architree.yoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yoon on 15. 3. 25..
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
