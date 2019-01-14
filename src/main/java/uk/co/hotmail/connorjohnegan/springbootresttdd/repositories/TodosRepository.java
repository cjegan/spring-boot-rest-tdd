package uk.co.hotmail.connorjohnegan.springbootresttdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.hotmail.connorjohnegan.springbootresttdd.models.TodoEntity;

@Repository
public interface TodosRepository extends JpaRepository<TodoEntity, Long> {
}
