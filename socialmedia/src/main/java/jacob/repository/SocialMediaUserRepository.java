package jacob.repository;

import jacob.appUser.SocialMediaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialMediaUserRepository extends JpaRepository<SocialMediaUser, Integer> {
    Optional<SocialMediaUser> findByEmail(String email);
}
