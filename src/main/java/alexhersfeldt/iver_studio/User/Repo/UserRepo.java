package alexhersfeldt.iver_studio.User.Repo;


import alexhersfeldt.iver_studio.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer integer);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
