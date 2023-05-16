package com.mutuel.de.sante.Repository;

import com.mutuel.de.sante.Model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp, Integer> {
    Optional<SignUp> findByEmailAndPassword(String email, String password);
    Optional<SignUp> findFirstByEmail(String email);
}
