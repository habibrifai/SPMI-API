package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.IpDosen;

public class IpDosenRowMapper implements RowMapper<IpDosen>{

	@Override
	public IpDosen mapRow(ResultSet rs, int rowNum) throws SQLException {
		IpDosen d = new IpDosen();
		
		d.setRataIpd(rs.getDouble("rataIpd"));
		
		return d;
	}

}
