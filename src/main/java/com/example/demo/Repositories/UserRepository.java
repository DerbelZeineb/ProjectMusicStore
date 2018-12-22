package com.example.demo.Repositories;


import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
   public User findByLoginAndPasswd(String login, String passwd);
   public User findByLogin(String login);
}
