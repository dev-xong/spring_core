package hello.core;

import hello.core.memeber.Grade;
import hello.core.memeber.Member;
import hello.core.memeber.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemeberApp {

    public static void main(String[] args) {

        /* 스프링 적용 전 */
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        /* 스프링 적용 후 */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember =  memberService.findMember(1L);
        System.out.println("new member : " +  member.getName());
        System.out.println("findMember : " + findMember.getName());

    }
}
