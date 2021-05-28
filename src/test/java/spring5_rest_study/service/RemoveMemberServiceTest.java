package spring5_rest_study.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberDaoTest;
import spring5_rest_study.mappers.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class RemoveMemberServiceTest {
	private static final Log log = LogFactory.getLog(MemberDaoTest.class);

	@Autowired
	private RemoveMemberService service;

	@Autowired
	private MemberMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testRemoveMember() {
		Member member = mapper.getMemberByEmail("22@22.co.kr");
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = service.removeMember(member.getId());
		Assert.assertEquals(1, res);
	}

}
