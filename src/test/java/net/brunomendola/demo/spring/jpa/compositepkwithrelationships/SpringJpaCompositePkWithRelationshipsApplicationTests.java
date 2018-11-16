package net.brunomendola.demo.spring.jpa.compositepkwithrelationships;

import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model.*;
import net.brunomendola.demo.spring.jpa.compositepkwithrelationships.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SpringJpaCompositePkWithRelationshipsApplicationTests {

  @Autowired
  private ActivityRepository activityRepository;
  @Autowired
  private ActionRepository actionRepository;
  @Autowired
  private ActivityActionRepository activityActionRepository;
  @Autowired
  private ProfileRepository profileRepository;
  @Autowired
  private ProfileActionRepository profileActionRepository;

  /**
   * should work according to
   * https://github.com/spring-projects/spring-data-jpa/blob/master/src/test/java/org/springframework/data/jpa/repository/RepositoryWithIdClassKeyTests.java
   * and
   * https://github.com/spring-projects/spring-data-jpa/blob/master/src/test/java/org/springframework/data/jpa/repository/RepositoryWithCompositeKeyTests.java
   */
  @Test
  @Transactional
  public void testCreateProfileActions() {
    Activity activity =  activityRepository.save(new Activity("AT1"));
    Profile profile =  profileRepository.save(new Profile("PR1"));

    AtomicInteger subId = new AtomicInteger(1);
    Stream.of("AZ1", "AZ2", "AZ3")
        .map(actionCode ->
            actionRepository.save(new Action(actionCode)))
        .map(action ->
            activityActionRepository.save(new ActivityAction(activity, action, String.valueOf(subId.getAndIncrement()))))
        .forEach(activityAction ->
            profileActionRepository.save(new ProfileAction(profile, activityAction)));

    List<ProfileAction> results = profileActionRepository.findAll();
    profileActionRepository.flush();

    Assert.assertEquals(3, results.size());
  }

}
