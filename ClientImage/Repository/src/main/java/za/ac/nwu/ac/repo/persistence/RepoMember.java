package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;

import javax.transaction.Transactional;

@Repository
public interface RepoMember extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    boolean existsByEmail(String email);

    @Query(value = "SELECT      " +
            "        m       " +
            "        FROM       " +
            "        Member     " +
            "        m          " +
            "WHERE m.email = :email" )
    Member getMemberByEmail(String email);

    @Query(value = "SELECT      " +
            "        m.memberID  " +
            "        FROM       " +
            "        Member     " +
            "        m          " +
            "WHERE m.email = :email" )
    Long getMemberEmailByID(String email);

    @Transactional
    @Modifying
    @Query(value = "DELETE      " +
            "        FROM       " +
            "        Member     " +
            "WHERE email = :email" )
    void deleteMemberByEmail(String email);
}
