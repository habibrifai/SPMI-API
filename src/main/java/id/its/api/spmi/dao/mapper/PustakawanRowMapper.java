package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.Pustakawan;

public class PustakawanRowMapper implements RowMapper<Pustakawan>{
	
	@Override
	public Pustakawan mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pustakawan p = new Pustakawan();
		
		p.setJenjangTerakhir(rs.getString("jenjangTerakhir"));
		p.setJumlahPustakawan(rs.getInt("jumlahPustakawan"));

		return p;
	}
}
