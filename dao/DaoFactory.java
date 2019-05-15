package dao;

import enums.DBType;

public class DaoFactory {

    public static BaseDao getDaoForEntity(DBType dbType) {
        BaseDao baseDao = null;
                switch (dbType) {
                    case MYSQL:
                        baseDao = MySQLEmployeeDao.getInstance();
                }
        return baseDao;
    }

}

