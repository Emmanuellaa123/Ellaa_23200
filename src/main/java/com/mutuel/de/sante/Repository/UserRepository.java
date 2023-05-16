package com.mutuel.de.sante.Repository;

import com.mutuel.de.sante.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findFirstById(Integer id);

    @Query("SELECT p FROM User p WHERE CONCAT(p.id,'',p.fName,'',p.lName,'',p.nationalId,'',p.address,'',p.socialStatus,'',p.headOfFamily,'',p.phoneNumber,'',p.email) LIKE %?1%")
    public List<User>search(String keyword);
}
