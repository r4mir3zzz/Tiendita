package com.tienda;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProyectConfig implements WebMvcConfigurer{
    //Los metodos son utilizados para el tema de internalizacion
    
    //LocalResolver ubica la informacion del navegador local del usuario y fija la informacion de la pag
    @Bean
    public LocaleResolver localeResolver (){
        var slr = new SessionLocaleResolver();
        
        slr.setDefaultLocale(Locale.getDefault());
        
        slr.setLocaleAttributeName("session.current.locate"
        );
        
        slr.setTimeZoneAttributeName( "session.current.timezone"
        );
        
        return slr;
    }
    
    
    //Define cual sera la variable que "cambia" el idioma de los textos
    @Bean //Dice que el metodo no se llama nunca porque se ejecuta una vez solamente
    public LocaleChangeInterceptor localChangeInterceptor (){
        var lci = new LocaleChangeInterceptor();
        
        lci.setParamName("lang");
        
        return lci;
    }
    
    
    //Se agrega un "interceptor" para poder hacer el cambio de idioma de inmediato
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localChangeInterceptor());
    }
    
    
    //Se usara para recuperar los textos de java segun el idioma
    @Bean("messaSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }
}
