package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.memeber.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.memeber.MemberService;
import hello.core.memeber.MemberServiceImpl;
import hello.core.memeber.MemoryMemberRepository;

public class AppConfig {

    //실제 동작에 필요한 '구현 객체'를 생성

    //생성자 주입
    public MemberService memberService () {

        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService () {
        return new OrderServiceImpl( memberRepository(), discountPolicy() );
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
