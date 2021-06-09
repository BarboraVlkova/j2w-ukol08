package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * vytvor JpaRepository -> entita Post (nazev PostRepository)
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   @Query
    Post findBySlug(String slug);

    Page<Post> findByPublishedBefore(LocalDate date, Pageable pageable);
}
