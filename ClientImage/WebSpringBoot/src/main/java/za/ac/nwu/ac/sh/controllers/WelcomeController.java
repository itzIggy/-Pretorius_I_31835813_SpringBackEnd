package za.ac.nwu.ac.sh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AuthReqDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.sh.util.JwtUtil;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to Image App";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthReqDto authReqDto) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReqDto.getEmail(),authReqDto.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("Invalid Username or Password!");
        }
        return jwtUtil.generateToken(authReqDto.getEmail());
    }
}
