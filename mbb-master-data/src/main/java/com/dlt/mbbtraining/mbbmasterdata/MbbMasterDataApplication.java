package com.dlt.mbbtraining.mbbmasterdata;

import com.dlt.mbbtraining.mbbmasterdata.easyrules.model.Case;
import com.dlt.mbbtraining.mbbmasterdata.easyrules.model.User;
import com.dlt.mbbtraining.mbbmasterdata.easyrules.rules.IRule;
import com.dlt.mbbtraining.mbbmasterdata.easyrules.rules.Response;
import lombok.extern.slf4j.Slf4j;
import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
//@EnableCaching
public class MbbMasterDataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MbbMasterDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MbbMasterDataApplication rules = new MbbMasterDataApplication();
        User user = new User();
        user.setName("Donald Duck");
        Case aCase = new Case();
        aCase.setUser(user);
        aCase.setHourOfDay(23);

        rules.process(aCase);

    }

    public void process(Case aCase) {
        final EngineFactory<IRule> engineFactory = new RulesEngineFactory<IRule>(getClass().getClassLoader()
                .getResource("HelloUser.xls"), IRule.class);
        IRule instance = engineFactory.newEngineInstance();

        System.out.println("############ METHOD IN ############");

//        instance.helloUser(aCase, new Response());

        User responseUser = instance.returnUser(aCase, new Response());
        log.info("Return data user: {}", responseUser.toString());

        System.out.println("############ METHOD EXIT ############");

    }
}

