package za.ac.nwu.ac.sh.controllers;

import io.swagger.annotations.*;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.MemberFlow;

import java.util.List;

@RestController
@RequestMapping("Members")
public class MembersController {

    private final MemberFlow memberFlow;

    @Autowired
    public MembersController(MemberFlow memberFlow){
        this.memberFlow = memberFlow;
    }

    @GetMapping("/all/members")
    @ApiOperation(value = "All configured Account Members", notes = "Returns list of Account Members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Members Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll() {
        List<MemberDto> memberDtos = memberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true,memberDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
