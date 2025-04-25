package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member();
        member.setName("woo");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void validateDuplicateMember() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("woo");

        Member member2 = new Member();
        member2.setName("woo");

        //when
        memberService.join(member1);

        //then
        //IllegalStateException例外が発生しなければ、テスト失敗
        assertThrows(IllegalStateException.class, () ->
                    memberService.join(member2));
    }
}