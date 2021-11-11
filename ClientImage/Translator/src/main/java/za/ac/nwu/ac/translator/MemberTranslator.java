package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface MemberTranslator {

    List<MemberDto> getAllMembers();
}
