package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.RepoMember;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class MemberTranslatorImpl implements MemberTranslator {

    private final RepoMember repoMember;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberTranslatorImpl.class);

    @Autowired
    public MemberTranslatorImpl(RepoMember repoMember) {
        this.repoMember = repoMember;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<MemberDto> getAllMembers(){

        List<MemberDto> memberDtos = new ArrayList<>();
        try{
            for (Member member : repoMember.findAll()){
                memberDtos.add(new MemberDto(member));
            }
        } catch (Exception e){
            LOGGER.error("error getting all members");
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return  memberDtos;
    }

    @Override
    public MemberDto addMember(MemberDto memberDto){
        try{
            String newPassword = bCryptPasswordEncoder.encode(memberDto.getPassword());
            memberDto.setPassword(newPassword);
            Member member = repoMember.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            LOGGER.error("error adding a member");
            throw new RuntimeException("Unable to save to DB!",e);
        }

    }

    @Override
    public MemberDto getMemberByEmail(String email){
        try{
            Member member = repoMember.getMemberByEmail(email);
            return new MemberDto(member);
        }catch (Exception e){
            LOGGER.error("error getting a member by email");
            throw new RuntimeException("Unable to retrieve from DB!",e);
        }
    }


    @Override
    public void deleteMemberByEmail(String email){
        try{
            repoMember.deleteMemberByEmail(email);
        }catch (Exception e){
            LOGGER.error("error deleting a member");
            throw new RuntimeException("Unable to delete from DB!",e);
        }
    }

    @Override
    public MemberDto modifyMember(MemberDto memberDto) {
        try{
            Member member =repoMember.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            LOGGER.error("error modifying a member");
            throw new RuntimeException("Unable to save to DB");
        }
    }


}
