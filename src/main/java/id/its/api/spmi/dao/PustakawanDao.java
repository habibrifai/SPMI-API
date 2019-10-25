package id.its.api.spmi.dao;

import java.util.List;

import id.its.api.spmi.model.Pustakawan;

public interface PustakawanDao {
	List<Pustakawan> getJumlahPustakawan(String jenjangTerakhir);
	List<Pustakawan> getJumlahPustakawanList();
}