package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public MemberTranslatorImpl(RepoMember repoMember) {
        this.repoMember = repoMember;
    }

    @Override
    public List<MemberDto> getAllMembers(){

        List<MemberDto> memberDtos = new ArrayList<>();
        try{
            for (Member member : repoMember.findAll()){
                memberDtos.add(new MemberDto(member));
            }
        } catch (Exception e){

            throw new RuntimeException("Unable to read from the DB", e);
        }

        return  memberDtos;
    }

    @Override
    public MemberDto addMember(MemberDto memberDto){
        try{
            Member member = repoMember.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB!",e);
        }

    }

    @Override
    public MemberDto getMemberByEmail(String email){
        try{
            Member member = repoMember.getMemberByEmail(email);
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to retrieve from DB!",e);
        }
    }


    @Override
    public void deleteMemberByEmail(String email){
        try{
            repoMember.deleteMemberByEmail(email);
        }catch (Exception e){
            throw new RuntimeException("Unable to delete from DB!",e);
        }
    }

    @Override
    public MemberDto modifyMember(MemberDto memberDto) {
        try{
            Member member =repoMember.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB");
        }
    }
}
