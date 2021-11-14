package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;

import java.util.List;

public interface MemberTranslator {

    List<MemberDto> getAllMembers();

    MemberDto addMember(MemberDto memberDto);

    void deleteMemberByEmail(String email);

    MemberDto getMemberByEmail(String email);

    MemberDto modifyMember(MemberDto memberDto);
}
