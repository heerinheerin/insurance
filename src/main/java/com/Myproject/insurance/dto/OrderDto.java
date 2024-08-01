package com.Myproject.insurance.dto;

import com.Myproject.insurance.entity.Member;
import com.Myproject.insurance.service.MailService;
import com.Myproject.insurance.service.MemberService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
public class OrderDto {
    private  Long itemId;
    private  int count;


}
