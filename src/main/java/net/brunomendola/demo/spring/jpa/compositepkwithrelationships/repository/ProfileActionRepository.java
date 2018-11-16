package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.repository;

import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.ProfileAction;
import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.ProfileActionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileActionRepository extends JpaRepository<ProfileAction, ProfileActionPK>, JpaSpecificationExecutor<ProfileAction> {
}
