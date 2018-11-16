package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.repository;

import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.ActivityAction;
import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.ActivityActionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityActionRepository extends JpaRepository<ActivityAction, ActivityActionPK>, JpaSpecificationExecutor<ActivityAction> {
}
