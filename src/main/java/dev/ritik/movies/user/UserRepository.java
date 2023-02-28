package dev.ritik.movies.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ritik.movies.config.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
