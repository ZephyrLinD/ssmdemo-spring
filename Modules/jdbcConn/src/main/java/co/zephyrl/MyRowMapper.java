package co.zephyrl;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Users us = new Users();
        us.setId(resultSet.getInt("id"));
        us.setAges(resultSet.getInt("ages"));
        us.setCdata(resultSet.getString("cdata"));
        us.setUname(resultSet.getString("uname"));
        us.setMsg(resultSet.getString("msg"));
        us.setPsd(resultSet.getInt("psd"));
        return us;
    }
}
