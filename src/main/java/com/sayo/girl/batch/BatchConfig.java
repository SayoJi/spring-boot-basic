package com.sayo.girl.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Shuangyao
 * 13:50 2018/4/8
 * refer to spring official website.{https://projects.spring.io/spring-batch/}
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private Logger logger = LoggerFactory.getLogger(BatchConfig.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
                        logger.info("~~~~~I'm step 1.~~~~");
                        return null;
                    }
                })
                .build();
    }

    @Bean
    public Job job(Step step1) throws Exception {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
}
