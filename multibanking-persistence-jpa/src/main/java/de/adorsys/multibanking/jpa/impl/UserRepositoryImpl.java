package de.adorsys.multibanking.jpa.impl;

import de.adorsys.multibanking.domain.UserEntity;
import de.adorsys.multibanking.jpa.entity.UserJpaEntity;
import de.adorsys.multibanking.jpa.mapper.JpaEntityMapper;
import de.adorsys.multibanking.jpa.repository.UserRepositoryJpa;
import de.adorsys.multibanking.pers.spi.repository.UserRepositoryIf;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Profile({"jpa"})
@Service
public class UserRepositoryImpl implements UserRepositoryIf {

    private final UserRepositoryJpa userRepository;
    private final JpaEntityMapper entityMapper;

    @Override
    public Optional<UserEntity> findById(String id) {
        return userRepository.findById(id).map(entityMapper::mapToUserEntity);
    }

    @Override
    public List<String> findExpiredUser() {
        return userRepository.findByExpireUserLessThan(LocalDateTime.now())
                .stream()
                .map(UserJpaEntity::getId)
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LocalDateTime> getRulesLastChangeDate(String id) {
        return Optional.ofNullable(userRepository.getRulesLastChangeDate(id));
    }

    @Override
    public void setRulesLastChangeDate(String userId, LocalDateTime dateTime) {
        userRepository.setRulesLastChangeDate(dateTime, userId);
    }

    @Override
    public boolean exists(String userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(entityMapper.mapToUserJpaEntity(userEntity));
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }
}
