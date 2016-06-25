package app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookDao extends JpaRepository<Book, Long> {

    public Book findByAsin(String asin);

}