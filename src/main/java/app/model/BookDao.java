package app.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookDao extends CrudRepository<Book, Long> {

    public Book findByAsin(String asin);

}