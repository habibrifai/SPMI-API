package id.its.api.spmi.dao;

import java.util.List;

import id.its.api.spmi.model.BebanKerjaDosen;
import id.its.api.spmi.model.Dosen;
import id.its.api.spmi.model.IpDosen;
import id.its.api.spmi.model.JabatanDosen;

public interface DosenDao {
	List<JabatanDosen> countFungsionalDosen1(Integer kodeProdi, String jabatan);
	List<JabatanDosen> countFungsionalDosen2(String fakultas, String jabatan);
	List<JabatanDosen> countFungsionalDosen3(Integer kodeProdi);
	List<JabatanDosen> countFungsionalDosen4(String fakultas);
	List<JabatanDosen> countFungsionalDosen(String fakultas, Integer kodeProdi, String jabatan);
	List<BebanKerjaDosen> countRataBebanKerjaDosen1(Integer kodeProdi, String kategoriKegiatan, Integer tahun);
	List<BebanKerjaDosen> countRataBebanKerjaDosen2(String fakultas, String kategoriKegiatan, Integer tahun);
	List<BebanKerjaDosen> countRataBebanKerjaDosen3(Integer kodeProdi, Integer tahun);
	List<BebanKerjaDosen> countRataBebanKerjaDosen4(String fakultas, Integer tahun);
	List<BebanKerjaDosen> countRataBebanKerjaDosen5(Integer kodeProdi);
	List<BebanKerjaDosen> countRataBebanKerjaDosen6(String fakultas);
	List<BebanKerjaDosen> countRataBebanKerjaDosen7(Integer kodeProdi, String kategoriKegiatan);
	List<BebanKerjaDosen> countRataBebanKerjaDosen8(String fakultas, String kategoriKegiatan);
	List<BebanKerjaDosen> countRataBebanKerjaDosen(String fakultas, Integer kodeProdi, String kategoriKegiatan, Integer tahun);
	List<Dosen> countPengabdianDosen1(Integer kodeProdi);
	List<Dosen> countPengabdianDosen2(String fakultas);
	List<Dosen> countPengabdianDosen3(Integer kodeProdi, Integer tahun);
	List<Dosen> countPengabdianDosen4(String fakultas, Integer tahun);
	List<Dosen> countPengabdianDosen(String fakultas, Integer kodeProdi, Integer tahun);
	List<Dosen> countPenelitianDosen1(Integer kodeProdi);
	List<Dosen> countPenelitianDosen2(String fakultas);
	List<Dosen> countPenelitianDosen3(Integer kodeProdi, Integer tahun);
	List<Dosen> countPenelitianDosen4(String fakultas, Integer tahun);
	List<Dosen> countPenelitianDosen(String fakultas, Integer kodeProdi, Integer tahun);
	List<IpDosen> countRataIpd1(Integer kodeProdi);
	List<IpDosen> countRataIpd2(String fakultas);
	List<IpDosen> countRataIpd3(Integer kodeProdi, Integer tahunAjaran);
	List<IpDosen> countRataIpd4(String fakultas, Integer tahunAjaran);
	List<IpDosen> countRataIpd(String fakultas, Integer kodeProdi, Integer tahunAjaran);
	List<Dosen> countDosen1(Integer kodeProdi, String pendidikanTerakhir, Integer isOut);
	List<Dosen> countDosen2(Integer kodeProdi, String pendidikanTerakhir);
	List<Dosen> countDosen3(String fakultas, String pendidikanTerakhir, Integer isOut);
	List<Dosen> countDosen4(String fakultas, String pendidikanTerakhir);
	List<Dosen> countDosen5(Integer kodeProdi, Integer isOut);
	List<Dosen> countDosen6(Integer kodeProdi);
	List<Dosen> countDosen7(String fakultas, Integer isOut);
	List<Dosen> countDosen8(String fakultas);
	List<Dosen> countDosen(String fakultas, Integer kodeProdi, String pendidikanTerakhir, Integer isOut);
}
