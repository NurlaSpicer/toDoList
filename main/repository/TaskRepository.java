package kz.iitu.itse1910.sagyndykov.todo.repository;

import kz.iitu.itse1910.sagyndykov.todo.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Tasks,Long> {
}
