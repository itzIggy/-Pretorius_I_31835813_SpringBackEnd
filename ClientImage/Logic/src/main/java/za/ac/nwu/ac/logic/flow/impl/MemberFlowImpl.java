package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.MemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class MemberFlowImpl implements MemberFlow {

    private final MemberTranslator memberTranslator;

    @Autowired
    public MemberFlowImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers(){
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto addMember(MemberDto memberDto){
        return memberTranslator.addMember(memberDto);
    }

    @Override
    public void deleteMemberByEmail(String email){
        memberTranslator.deleteMemberByEmail(email);
    }

    @Override
    public MemberDto getMemberByEmail(String email){
        return memberTranslator.getMemberByEmail(email);
    }

    @Override
    public MemberDto modifyMember(MemberDto memberDto){
        return memberTranslator.modifyMember(memberDto);
    }
}
