package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface LoginRepository extends JpaRepository<User,String>{

}
