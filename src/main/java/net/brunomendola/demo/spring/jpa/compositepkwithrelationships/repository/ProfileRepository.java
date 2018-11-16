package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.repository;

import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String>, JpaSpecificationExecutor<Profile> {
}
