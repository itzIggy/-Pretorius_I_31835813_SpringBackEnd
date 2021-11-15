package za.ac.nwu.ac.sh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.RepoMember;

import java.util.ArrayList;

@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    private RepoMember repoMember;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = repoMember.getMemberByEmail(email);
        if(member == null){
            throw new UsernameNotFoundException("User not found" + email);
        }
        return new User(member.getEmail(),member.getPassword(),new ArrayList<>());
    }
}
