package org.jiaozhu.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author jiaozhu
 * @email gitview(at)gmail.com
 * @description
 */
public class OracleDBUtils {

    private static DataSource dataSource = null;
    private static Context context = null;

    public static DataSource getDataSource() {

        if (dataSource != null) {
            return dataSource;
        }

        try {
            if (context == null) {
                context = new InitialContext();
            }
            dataSource = (DataSource) context.lookup("jndi/rest");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
