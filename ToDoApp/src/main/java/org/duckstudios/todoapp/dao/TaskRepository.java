package org.duckstudios.todoapp.dao;

import org.duckstudios.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// zegt tegen JPA dat dit een nieuwe repository is die gaat dealen
// met een task tabel in sql en die is gemapped is op een id die type (Long) is
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
