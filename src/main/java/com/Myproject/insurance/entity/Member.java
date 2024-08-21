package com.Myproject.insurance.entity;

import com.Myproject.insurance.constant.Role;
import com.Myproject.insurance.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member extends BaseEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private String postcode;
    private String detailAddress;
    private String tel;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto,
                                      PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());

        member.setTel(memberFormDto.getTel());

        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }


    public void updatemember(MemberFormDto memberFormDto){
        this.name = memberFormDto.getName();
        this.email = memberFormDto.getEmail();

        this.tel = memberFormDto.getTel();



    }
}
