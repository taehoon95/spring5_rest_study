package spring5_rest_study.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mappers.MemberMapper;
@Service
public class ModifyMemberServiceImpl implements spring5_rest_study.service.ModifyMemberService {

	static final Log log = LogFactory.getLog(MemberListServiceImpl.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int modifyMember(Member member) {
		log.debug("service - modifyMember() > " +member);
		return mapper.modifyMember(member);
	}

}
