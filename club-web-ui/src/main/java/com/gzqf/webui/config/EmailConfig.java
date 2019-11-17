package com.gzqf.webui.config;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EmailConfig implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 当@Value后面的值是${}格式时，表示我们需要取配置文件里面的这个变量的值
     */
    @Value("${email.host.name}")
    private String hostName;
    @Value("${email.smtp.port}")
    private int port;
    @Value("${email.username}")
    private String userName;
    @Value("${email.password}")
    private String password;
    /**
     * 获取EMAIL对象
     * @return
     */
    public static Email getEmail(){
        return applicationContext.getBean(Email.class);
    }
    /**
     * 创建一个email的spring bean
     *
     * 当我们每次需要这个EMAIL的bean的时候，因为scope=prototype,
     * spring每次都会调这个方法获取一个新的对象，然后返回
     * email对象是不可以用两次，我们每次发邮件都创建一个新的email对象。所以，我们要设置成prototype
     * @return
     */
    @Bean
    @Scope(value = "prototype")
    public Email createEmail(){
        try {
            //新建一个邮件对象
            Email email = new SimpleEmail();
            //设置host.name 端口
            email.setSmtpPort(port);
            //设置host name
            email.setHostName(hostName);
            //设置用户名、密码
            email.setAuthentication(userName, password);
            //设置SSL 加密通道
            email.setSSLOnConnect(true);
            //设置 from ,发件人
            email.setFrom(userName);
            return email;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        EmailConfig.applicationContext=applicationContext;
    }

}
