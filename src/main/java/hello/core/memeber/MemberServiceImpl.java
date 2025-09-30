package hello.core.memeber;

public class MemberServiceImpl implements MemberService {

    //추상화에만 의존
    private final MemberRepository memberRepository;

    //생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
