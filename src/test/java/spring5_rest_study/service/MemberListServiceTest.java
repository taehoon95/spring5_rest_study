package spring5_rest_study.service;

import static org.junit.Assert.*;

import java.util.List;

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
public class MemberListServiceTest {
	private static final Log log = LogFactory.getLog(MemberDaoTest.class);

	@Autowired
	private MemberListService service;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testGetLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = service.getLists();
		list.stream().forEach(System.out::println);
		Assert.assertNotNull(list);
	}

}
