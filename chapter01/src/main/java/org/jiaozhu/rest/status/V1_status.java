package org.jiaozhu.rest.status;

import org.jiaozhu.dao.OracleDBUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jiaozhu
 * @email gitview(at)gmail.com
 * @description
 */
@Path("/v1/status")
public class V1_status {

    private static final String api_version = "00.01.00";

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle() {
        return "<p>Java Web Service</p>";
    }

    @Path("/version")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnVersion() {
        return "<p>Version:</p>" + api_version;
    }


    @Path("/database")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnDatabaseStatus() {
        Connection conn = null;
        PreparedStatement pstm = null;
        String reString = null;
        String result = null;

        try {
            conn = OracleDBUtils.getDataSource().getConnection();
            pstm = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME FROM DUAL");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                reString = rs.getString("DATETIME");
            }

            pstm.close();

            result = "<p>DATABASE STATUS</p>" + "<p>DATABASE DATE/TIME RETURN :" + reString + "</p>";


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
