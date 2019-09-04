package com.ztest.chapter35;

import com.ztest.chapter35.bean.GoodInfos;
import com.ztest.chapter35.jpa.GoodInfoJPA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter35ApplicationTests {

    /**
     * 模拟mvc测试对象
     */
    private MockMvc mockMvc;

    /**
     * web项目上下文
     */
    @Autowired
    private WebApplicationContext webApplicationCOntext;

    /**
     * 商品业务数据接口
     */
    @Autowired
    private GoodInfoJPA goodInfoJPA;

    /**
     * 所有测试方法执行之前执行该方法
     */
    @Before
    public void before(){
       //获取mockmvc对象实例
       mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationCOntext).build();
    }

    /**
     * 测试访问/index地址
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception{
        MvcResult mvcResult = mockMvc
                //1
                .perform(
                        //2
                        MockMvcRequestBuilders.get("/index")
                                //3
                        .param("name","admin")
                )
                //4
                .andReturn();
        //5
        int status = mvcResult.getResponse().getStatus();
        //6
        String responseString = mvcResult.getResponse().getContentAsString();
        //7
        Assert.assertEquals("请求错误",200,status);
        //8
        Assert.assertEquals("返回结果不一致","This is index pageadmin",responseString);
    }

    @Test
    public void testAll() throws Exception{
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/all")
                )
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("return status not equals 200",200,status);
        System.out.println(responseString);
    }

    /**
     * 测试查询详情
     * @throws Exception
     */
    @Test
    public void testDetail() throws Exception{
        MvcResult mvcResult = mockMvc
                //1
                .perform(
                        //2
                        MockMvcRequestBuilders.get("/detail")
                                //3
                        .param("tg_Id","3")
                )
                //4
                .andReturn();
        //输出经历的拦截器
        HandlerInterceptor[] interceptors = mvcResult.getInterceptors();
        System.out.println(interceptors[0].getClass().getName());

        //5
        int status = mvcResult.getResponse().getStatus();
        //6
        String responseString = mvcResult.getResponse().getContentAsString();
        System.out.println("返回内容: "+ responseString);
        Assert.assertEquals("return status not equals 200",200,status);
    }

    /**
     * 测试添加商品基本信息
     */
    @Test
    public void testInsert(){
        //商品基本信息实体
        GoodInfos goodInfos = new GoodInfos();
        goodInfos.setTgTitle("西红柿");
        goodInfos.setTgOrder(2);
        goodInfos.setTgPrice(5.82);
        goodInfos.setTgTypeId(1);
        goodInfoJPA.save(goodInfos);
        //测试是否添加成功，测试主键是否存在
        Assert.assertNotNull(goodInfos.getTgId());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        goodInfoJPA.deleteById(1);

        //验证
        Assert.assertNotNull(goodInfoJPA.findById(1));
    }
}
