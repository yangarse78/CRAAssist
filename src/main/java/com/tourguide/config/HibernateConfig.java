package com.tourguide.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tourguide.model.IntervalType;
import com.tourguide.model.Patient;
import com.tourguide.model.Trial;
import com.tourguide.model.User;
import com.tourguide.model.VisitType;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {


    @Autowired
    private ApplicationContext context;
 
    @Bean
    // Creates a Hibernate SessionFactory
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
//        factoryBean.setAnnotatedClasses(User.class);
//        factoryBean.setAnnotatedClasses(IntervalType.class);
//        factoryBean.setAnnotatedClasses(VisitType.class);
//        factoryBean.setAnnotatedClasses(Trial.class);
//        factoryBean.setAnnotatedClasses(Patient.class);
        return factoryBean;
    }
 
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
    
}
