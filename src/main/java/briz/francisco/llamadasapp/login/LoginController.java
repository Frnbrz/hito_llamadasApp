package briz.francisco.llamadasapp.login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    public static final String LOGIN_PATH = "/api/v1/login";
    public static final String LOGIN_PATH_BY_EMAIL = LOGIN_PATH + "/{userEmail}";

    private final LoginService loginService;

    @CrossOrigin(origins = "*")
    @GetMapping(value = LOGIN_PATH_BY_EMAIL)

    public ResponseEntity<LoginDTO> getLoginByEmail(@PathVariable("userEmail") String userEmail) {
        LoginDTO login = loginService.getLoginByEmail(userEmail);
        if (login == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(login);
        }
    }


}
