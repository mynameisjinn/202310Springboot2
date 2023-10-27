package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        
        // 회원가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 가입되었는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.print("가입한 멤버와 찾는 멤버가 같은가? ");
        System.out.println(member == findMember);

    }
}
