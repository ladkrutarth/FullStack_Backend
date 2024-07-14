package com.SpringbootProject.FullStack_Project.respository;

import com.SpringbootProject.FullStack_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
