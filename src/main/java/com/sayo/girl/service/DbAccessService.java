package com.sayo.girl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DbAccessService {
    private static final Logger logger = LoggerFactory.getLogger(DbAccessService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<String> getNameList() {
        String str = "select c.name from Child c";
        Query query = entityManager.createQuery(str);
        List<String> vchNoList = query.getResultList();
        vchNoList.stream().forEach(e -> logger.info("name is:{}", e));

        return vchNoList;
    }
}
