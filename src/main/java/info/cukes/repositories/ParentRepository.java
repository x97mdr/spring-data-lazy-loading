package info.cukes.repositories;

import info.cukes.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: Jeffrey
 * Date: 29/03/13
 * Time: 2:34 PM
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

    public Parent findByFirstName(String firstName);
}
