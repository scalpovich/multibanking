package de.adorsys.multibanking.jpa.impl;

import de.adorsys.multibanking.domain.BookingsIndexEntity;
import de.adorsys.multibanking.jpa.mapper.JpaEntityMapper;
import de.adorsys.multibanking.jpa.repository.BookingsIndexRepositoryJpa;
import de.adorsys.multibanking.pers.spi.repository.BookingsIndexRepositoryIf;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Profile({"jpa"})
@Service
public class BookingsIndexRepositoryImpl implements BookingsIndexRepositoryIf {

    private final BookingsIndexRepositoryJpa repository;
    private final JpaEntityMapper entityMapper;

    @Override
    public void save(BookingsIndexEntity entity) {
        repository.deleteByUserIdAndAccountId(entity.getUserId(), entity.getAccountId());
        repository.save(entityMapper.mapToBookingsIndexJpaEntity(entity));
    }

    @Override
    public void delete(BookingsIndexEntity entity) {
        repository.deleteById(entity.getId());
    }

    @Override
    public List<BookingsIndexEntity> search(String terms) {
        return null;
    }

    @Override
    public Optional<BookingsIndexEntity> findByUserIdAndAccountId(String userId, String accountId) {
        return repository.findByUserIdAndAccountId(userId, accountId)
                .map(entityMapper::mapToBookingsIndexEntity);
    }
}
