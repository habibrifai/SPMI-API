package id.its.api.spmi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import id.its.api.spmi.dao.mapper.PustakawanRowMapper;
import id.its.api.spmi.dao.*;
import id.its.api.spmi.model.Pustakawan;

public class JdbcPustakawanDao extends AbstractDao implements PustakawanDao{
	public List<Pustakawan> getJumlahPustakawan(String jenjang) {
		String sql = "SELECT jenjang_terakhir as jenjangTerakhir, COUNT(nip) as jumlahPustakawan "
				+ "FROM pustakawan "
				+ "WHERE jenjang_terakhir = :jenjang "
				+ "GROUP BY jenjang_terakhir";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Pustakawan> jumlahPustakawan = jdbcTemplate.query(sql, params, new PustakawanRowMapper());

		return jumlahPustakawan;
	}

	@Override
	public List<Pustakawan> getJumlahPustakawanList() {
		String sql = "SELECT jenjang_terakhir as jenjangTerakhir, COUNT(nip) as jumlahPustakawan "
				+ "FROM pustakawan "
				+ "GROUP BY jenjang_terakhir";
		
		Map<String, Object> params = new HashMap<String, Object>();
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Pustakawan> jumlahPustakawan = jdbcTemplate.query(sql, params, new PustakawanRowMapper());

		return jumlahPustakawan;
	}
}