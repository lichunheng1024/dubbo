package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lch
 */
public class GenericServiceDemo {

    public static void main(String[] args) throws InterruptedException {



            ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
            reference.setApplication(new ApplicationConfig("generic-consumer"));
            reference.setInterface("com.alibaba.dubbo.demo.DemoService");
            reference.setGeneric(true);


            ConsumerConfig consumerConfig = new ConsumerConfig();
            RegistryConfig registryConfig=new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            consumerConfig.setRegistry(registryConfig);
            reference.setConsumer(consumerConfig);
            GenericService genericService = reference.get();

            while(true) {

                Thread.sleep(2000);

                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("lichunheng----", "java.lang.String");
                Object echo = genericService.$invoke("sayHello", new String[]{String.class.getName()}, new Object[]{"lichunheng"});
                System.out.println("======》》》》》" + echo);
            }



    }
}
