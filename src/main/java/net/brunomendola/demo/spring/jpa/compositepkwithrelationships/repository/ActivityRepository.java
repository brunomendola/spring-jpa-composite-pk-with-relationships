package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.repository;

import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String>, JpaSpecificationExecutor<Activity> {
}
