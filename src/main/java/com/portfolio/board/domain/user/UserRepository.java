package com.portfolio.board.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    //유저 프로필이 업데이트 될 수도 있어서 만들어놓은 메서드. service에서 사용
}
