package com.hectorbru.rabbitmq_poc.publications;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, UUID> {
    @Query("UPDATE Publication p SET p.numberOfLikes = p.numberOfLikes + 1 WHERE p.id = ?1")
    @Modifying
    @Transactional
    void increasePublicationLikes(UUID id);
}
