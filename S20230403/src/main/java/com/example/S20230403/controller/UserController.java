package com.example.S20230403.controller;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.model.Users;
import com.example.S20230403.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UsersService userService;

    @GetMapping("/login")
    public String login() {
        return "views/login";
    }

    @PostMapping("/checkDuplication")
    @ResponseBody
    public int checkDuplication(@RequestParam String user_id) {
        return userService.exists(user_id);
    }

    @PostMapping("/checkDuplicationNick")
    @ResponseBody
    public int checkDuplicationNick(@RequestParam String nickname) {
        return userService.existsNick(nickname);
    }

    @GetMapping("/sign")
    public String signForm() {
        return "views/signForm";
    }

    @PostMapping("/sign")
    public String sign(Users user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/additional-info")
    public String showAdditionalInfo(@AuthenticationPrincipal PrincipalDetail userDetail, Model model) {
        String user_id = userDetail.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();

        model.addAttribute("user_id", user_id);
        model.addAttribute("authorities", authorities);
        return "additional-info";
    }

    @PostMapping("/updateInfo")
    public String submitAdditionalInfoForm(@ModelAttribute("user") Users user, Authentication authentication) {
        PrincipalDetail userDetails = (PrincipalDetail) authentication.getPrincipal();
        Users currentUser = userDetails.getUser();
        currentUser.setNickname(user.getNickname());
        currentUser.setPhone(user.getPhone());
        currentUser.setTelecom(user.getTelecom());
        currentUser.setGender(user.getGender());
        currentUser.setAuth_level(user.getAuth_level());
        userService.addInfoUser(currentUser);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("user_id") String user_id) {
        userService.delete(user_id);

        return "redirect:/";
    }

    @GetMapping("/hello")
    public String userAccess() {
        return "user_access";
    }

    @GetMapping("/seller")
    public @ResponseBody String seller() {
        return "seller";
    }

    @GetMapping("/error")
    public String error() {
        return "redirect:/";
    }


}
