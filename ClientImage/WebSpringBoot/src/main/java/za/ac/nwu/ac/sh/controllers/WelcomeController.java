package za.ac.nwu.ac.sh.controllers;

import com.amazonaws.services.cognitoidp.model.SignUpRequest;
import com.amazonaws.services.pinpoint.model.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AuthReqDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.repo.persistence.RepoMember;
import za.ac.nwu.ac.sh.service.MemberDetailService;
import za.ac.nwu.ac.sh.util.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/test")
    public String welcome(){
        return "Welcome to Image App";
    }

    @PostMapping("/signIn")
    public ResponseEntity<GeneralResponse<String>> generateToken(@RequestBody AuthReqDto authReqDto) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReqDto.getEmail(),authReqDto.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("Invalid Username or Password!");
        }
        String success = jwtUtil.generateToken(authReqDto.getEmail());

        GeneralResponse<String> response = new GeneralResponse<>(true,success);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public GeneralResponse<?> signUpAuthentication(@RequestBody SignUpRequest signUpRequest) throws Exception{
       return null;
    }

}
