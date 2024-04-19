package com.example.exercise02.repository;

import com.example.exercise02.module.Blog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class BlogRepoIplm implements IBlogRepo{
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("from Blog",Blog.class).getResultList();
    }

    @Override
    public Blog findById(Long id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public boolean save(Blog blog) {
        if (blog.getId()==null){
            // them moi
            entityManager.persist(blog);
        }else {
            // cap nhat
            entityManager.merge(blog);
        }
        return true;    }

    @Override
    public boolean delete(Long id) {
        entityManager.remove(findById(id));
        return true;
    }
}
