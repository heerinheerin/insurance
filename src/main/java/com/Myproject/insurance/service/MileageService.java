package com.Myproject.insurance.service;

import com.Myproject.insurance.dto.MileageDto;
import com.Myproject.insurance.entity.Member;
import com.Myproject.insurance.entity.Mileage;
import com.Myproject.insurance.repository.MemberRepository;
import com.Myproject.insurance.repository.MileageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MileageService {
    private  final MileageRepository mileageRepository;
    private final MemberRepository memberRepository;
    public  void mileageMembersend(MileageDto mileageDto, Long memberId){
        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            Mileage mileage = Mileage.createMileage(mileageDto, member);

            mileageRepository.save(mileage);
        } else {
            throw new IllegalArgumentException("Member not found for id: " + memberId);
        }

    }

    public List<Mileage>  membertoMileage(Long memberId){

        return mileageRepository.findByMemberId(memberId);
    }

    public  void  save(Member member, Integer useMileage ){
            Mileage mileage = new Mileage();
            mileage.setMember(member);
            mileage.setContent("결제 시 사용");
            mileage.setPoint(-useMileage);
            mileageRepository.save(mileage);

    }
    public  void  saveCancel(Member member, Integer useMileage ){
        Mileage mileage = new Mileage();
        mileage.setMember(member);
        mileage.setContent("결제 취소");
        mileage.setPoint(useMileage);
        mileageRepository.save(mileage);

    }



}
