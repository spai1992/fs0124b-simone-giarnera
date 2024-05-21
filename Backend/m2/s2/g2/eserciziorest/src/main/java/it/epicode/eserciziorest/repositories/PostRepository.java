package it.epicode.eserciziorest.repositories;

import it.epicode.eserciziorest.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
