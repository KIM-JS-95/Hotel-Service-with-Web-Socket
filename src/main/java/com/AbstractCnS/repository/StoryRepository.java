package com.AbstractCnS.repository;

import com.AbstractCnS.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StoryRepository extends CrudRepository<Story, Serializable> {
}
