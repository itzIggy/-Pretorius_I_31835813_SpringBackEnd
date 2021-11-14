package za.ac.nwu.ac.sh.controllers;

import io.swagger.annotations.*;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.MemberFlow;

import java.util.List;

@RestController
@RequestMapping("Members")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class MembersController {

    private final MemberFlow memberFlow;

    @Autowired
    public MembersController(MemberFlow memberFlow){
        this.memberFlow = memberFlow;
    }

    @GetMapping("/all/members")
    @ApiOperation(value = "All configured Members", notes = "Returns list of Members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll() {
        List<MemberDto> memberDtos = memberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true,memberDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add/members")
    @ApiOperation(value="Creates new Member",notes = "Create a new Member in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Member Created Successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> addMember(
            @ApiParam(value = "Request to create new member", required = true)
            @RequestBody MemberDto memberDto){
        MemberDto member = memberFlow.addMember(memberDto);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMember/{email}")
    @ApiOperation(value = "Deletes Member",notes = "Deletes a member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Deleted",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<String>> deleteMemberByEmail(
            @PathVariable("email") final String email){
        memberFlow.deleteMemberByEmail(email);
        GeneralResponse<String> response = new GeneralResponse<>(true, "Removed");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getMemberByEmail/{email}")
    @ApiOperation(value = "Gets Specific member", notes = "Fetches member by Email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> getMemberByEmail(
            @PathVariable("email") final String email) {
        MemberDto memberDto = memberFlow.getMemberByEmail(email);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/modifyMember")
    @ApiOperation(value = "Modifies Member",notes = "Modifies a member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Found",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> modifyAccountMember(
            @RequestBody MemberDto memberDto){
        MemberDto memberDtos = memberFlow.modifyMember(memberDto);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true,memberDtos);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
