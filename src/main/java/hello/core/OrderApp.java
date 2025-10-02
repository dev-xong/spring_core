package hello.core;

import hello.core.memeber.Grade;
import hello.core.memeber.Member;
import hello.core.memeber.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        /* 스프링 적용 전 */
       /*  AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService(); */

        ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ap.getBean("memberService",MemberService.class);
        OrderService orderService = ap.getBean("orderService",OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 24000);

        System.out.println("order : " + order);

    }
}
