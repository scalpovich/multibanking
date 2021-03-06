package de.adorsys.multibanking.mongo.repository;

import de.adorsys.multibanking.mongo.entity.RuleMongoEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile({"mongo", "fongo"})
public interface BookingRuleRepositoryMongodb extends MongoRepository<RuleMongoEntity, String> {

    Page<RuleMongoEntity> findAll(Pageable pageable);

    List<RuleMongoEntity> findByUserId(String userId);

    Optional<RuleMongoEntity> findByRuleId(String ruleId);

}
