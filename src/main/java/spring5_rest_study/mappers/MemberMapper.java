package spring5_rest_study.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import spring5_rest_study.dto.Member;

@Component
public interface MemberMapper {
	Member getMemberByEmail(String email);
	List<Member> getLists();
    Member getMember(long id);
    
    int registerMember(Member member);
    int modifyMember(Member member);
    int removeMember(long id);
}
