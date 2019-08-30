package com.ztest.chapter30.mapper;

import com.ztest.chapter30.bean.GoodInfos;
import com.ztest.chapter30.bean.GoodTypes;
import com.ztest.chapter30.dto.GoodInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/30
 * \* Time: 15:23
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 30 配置映射 获取mapper比较常用的两种方式
 * \* 1、默认配置 采用Mappers通过动态工厂内部反射机制完成Mapper实现类的获取 下文中注释掉的
 * \* 2、Spring方式配置 在@Mapper注解内添加componentModel属性值，然后在外部可以采用@Autowired方式注入Mapper实现类完成映射方法调用
 * \* source代表的是映射接口方法内的参数名称，如果是基本类型的参数，参数名可以直接作为source的内容，如果是实体类型，则可以采用实体参数名.字段名的方式作为source的内容
 * \* target代表的是映射到方法方法值内的字段名称，配置如上面GoodInfoMapper所示。
 */
@Mapper(componentModel = "spring")
//@Mapper
public interface GoodInfoMapper {

    //public static GoodInfoMapper MAPPER = Mappers.getMapper(GoodInfoMapper.class);

    @Mappings({
            @Mapping(source = "type.tgtName",target = "typeName"),
            @Mapping(source = "good.tgId",target = "goodId"),
            @Mapping(source = "good.tgTitle",target = "goodName"),
            @Mapping(source = "good.tgPrice",target = "goodPrice")
    })
    public GoodInfoDTO from(GoodInfos good, GoodTypes type);
}
