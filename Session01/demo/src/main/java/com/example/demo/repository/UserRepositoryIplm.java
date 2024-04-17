package com.example.demo.repository;

import com.example.demo.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class UserRepositoryIplm implements IUserRepository {
    @PersistenceContext
    public EntityManager entityManager;
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User ",User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public boolean save(User user) {
        if(user.getUserId()==null){
            entityManager.persist(user);
        }else {
            entityManager.merge(user);
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.remove(findById(id));
        return true;
    }
}
