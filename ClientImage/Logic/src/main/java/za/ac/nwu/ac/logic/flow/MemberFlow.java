package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface MemberFlow {
    List<MemberDto> getAllMembers();
    MemberDto addMember(MemberDto memberDto);
    void deleteMemberByEmail(String email);
    MemberDto getMemberByEmail(String email);
    MemberDto modifyMember(MemberDto memberDto);
}
