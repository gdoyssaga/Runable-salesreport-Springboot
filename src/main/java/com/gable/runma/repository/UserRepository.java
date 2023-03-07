package com.gable.runma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gable.runma.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
<<<<<<< Upstream, based on origin/master

=======
>>>>>>> 76cebeb merge from suebkwan
    public User findByEmail(String email);
}
