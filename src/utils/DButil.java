package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DButil {
    //DAO DBを操作するための準備

    //変数宣言
    private static final String PERSISTENCE_UNIT_NAME = "tasklist";
    private static EntityManagerFactory emf;

    //createEntityManagerを呼び出すことでDBを操作できる
    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

}
