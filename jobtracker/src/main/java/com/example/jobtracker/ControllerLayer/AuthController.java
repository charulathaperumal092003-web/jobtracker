package com.example.jobtracker.ControllerLayer;
import com.example.jobtracker.DTOLayer.LoginDto;
import com.example.jobtracker.DTOLayer.RegisterDto;
import com.example.jobtracker.SecurityLayer.JwtUtil;
import com.example.jobtracker.ServiceLayer.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil= jwtUtil ;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterDto dto) {
        userService.register(dto);
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginDto dto) {
        userService.login(dto.getEmail(), dto.getPassword());
        String token = jwtUtil.generateToken(dto.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
