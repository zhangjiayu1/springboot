package com.ztest.chapter36.resolver;

import com.ztest.chapter36.annotation.ParameterModel;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;


/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/09/10
 * \* Time: 14:25
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 36 自定义参数装载
 * \
 */
public class CustomerArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     *日志对象
     */
    private Logger logger = LoggerFactory.getLogger(CustomerArgumentResolver.class);

    /**
     * 该方法返回true时调用resolveArgument方法执行逻辑
     * event & listener也用到了同样的
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(ParameterModel.class);
    }

    /**
     * 装载参数
     * @param methodParameter 方法参数
     * @param modelAndViewContainer 返回视图容器
     * @param nativeWebRequest 本次请求对象
     * @param webDataBinderFactory 数据绑定工厂
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest,
            WebDataBinderFactory webDataBinderFactory) throws Exception {

        String parammeterName = methodParameter.getParameterName();
        logger.info("参数名称：{}",parammeterName);
        /**
         * 目标返回对象
         * 如果Model存在该Attribute时从module内获取并设置为返回值
         * 如果Model不存在该Attribute则从request parameterMap内获取并设置为返回值
         */
        Object target = modelAndViewContainer.containsAttribute(parammeterName) ?
                modelAndViewContainer.getModel().get(parammeterName) : createAttribute(parammeterName,methodParameter,webDataBinderFactory,nativeWebRequest);
        /**
         * 返回内容，这里返回的内容才是最终装载到参数的值
         */
        return target;
    }

    /**
     * 根据参数attributeName获取请求的值
     * @param attributeName 请求参数
     * @param parameter 参数对象
     * @param binderFactory 数据绑定工厂
     * @param request 请求对象
     * @return
     * @throws Exception
     */
    protected Object createAttribute(String attributeName, MethodParameter parameter,
                                     WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception{

        /**
         * 获取attributeName的值
         */
        String value = getRequestValueForAttribute(attributeName,request);
        /**
         * 如果存在值
         */
        if(null != value){
            /**
             * 进行类型转换
             * 检查请求的类型与目标参数类型是否可以进行转换
             */
            Object attribute = convertAttributeToParameterValue(value,attributeName,parameter,binderFactory,request);
            if(null != attribute){
                return attribute;
            }
        }
        /**
         * 检查request parameterMap 内是否存在以attributeName作为前缀的数据
         * 如果存在则根据字段的类型来进行设置值、集合、数组等
         */
        else{
            Object attribute = putParameters(parameter,request);
            if(null != attribute){
                return attribute;
            }
        }
        /**
         * 如果以上两种条件不符合，直接返回初始化参数类型的空对象
         */
        return BeanUtils.instantiateClass(parameter.getParameterType());
    }

    /**
     * 将attribute的值转换为parameter参数值类型
     * @param sourceValue
     * @param attributeName
     * @param parameter
     * @param binderFactory
     * @param request
     * @return
     * @throws Exception
     */
    protected Object convertAttributeToParameterValue(String sourceValue,
                                                      String attributeName,
                                                      MethodParameter parameter,
                                                      WebDataBinderFactory binderFactory,
                                                      NativeWebRequest request) throws Exception{
        /**
         * 获取类型转换业务逻辑实现类
         */
        DataBinder binder = binderFactory.createBinder(request, null ,attributeName);
        ConversionService conversionService = binder.getConversionService();
        if(null != conversionService){
            /**
             * 源类型描述
             */
            TypeDescriptor source = TypeDescriptor.valueOf(String.class);
            /**
             * 根据目标参数对象获取目标参数类型描述
             */
            TypeDescriptor target = new TypeDescriptor(parameter);
            /**
             * 验证是否可以进行转换
             */
            if(conversionService.canConvert(source,target)){
                /**
                 * 返回转换后的值
                 */
                return binder.convertIfNecessary(sourceValue,parameter.getParameterType(),parameter);
            }
        }
        return null;
    }

    /**
     * 从request parameterMap集合内获取attributeName的值
     * @param attributeName 参数名称
     * @param request 请求对象
     * @return
     */
    protected String getRequestValueForAttribute(String attributeName,NativeWebRequest request){
        /**
         * 获取PathVariables参数集合
         */
        Map<String,String> variables = getUriTemplateVariables(request);
        /**
         * 如果PathVariables参数集合内存在该attributeName
         * 直接返回对应的值
         */
        if(StringUtils.hasText(variables.get(attributeName))){
            return variables.get(attributeName);
        }
        /**
         * 如果request parameterMap内存在该attributeName
         * 直接返回对应的值
         */
        else if(StringUtils.hasText(request.getParameter(attributeName))){
            return request.getParameter(attributeName);
        }
        return null;
    }
}
