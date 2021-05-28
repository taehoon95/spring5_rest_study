package spring5_rest_study.service;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class RegisterMemberServiceTest {
	private static final Log log = LogFactory.getLog(MemberDaoTest.class);

	@Autowired
	private RegisterMemberService service;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void testRegisterMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		LocalDateTime ldt = LocalDateTime.now();
		Member addMember = new Member("22@22.co.kr", "123", "test",ldt);
		int res = service.registerMember(addMember);
		Assert.assertEquals(1,res);
	}

}
