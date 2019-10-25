package id.its.api.spmi.endpoint;

import java.net.URL;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import graphql.ExecutionResult;
import graphql.GraphQL;

import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import id.its.api.spmi.dao.DosenDao;
import id.its.api.spmi.model.BebanKerjaDosen;
import id.its.api.spmi.model.Dosen;
import id.its.api.spmi.model.IpDosen;
import id.its.api.spmi.model.JabatanDosen;

@Path("/dosen")
public class DosenEndpoint{

	private DosenDao dosenDao;
	
	public DosenDao getDosenDao() {
		return dosenDao;
	}

	public void setDosenDao(DosenDao dosenDao) {
		this.dosenDao = dosenDao;
	}

	private GraphQL graphQL;
	
	public void loadSchema() {
		try {			
			URL res = getClass().getClassLoader().getResource("/data.graphqls");
			File file = Paths.get(res.toURI()).toFile();
			String absolutePath = file.getAbsolutePath();
			
			File schemaFile = new File(absolutePath);
			
			TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
			RuntimeWiring wiring = buildWiring();
			GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
			this.graphQL = GraphQL.newGraphQL(schema).build();
		} catch(Exception e) {
			System.out.print(e.toString());
		}
	}
	
	private RuntimeWiring buildWiring() {
		
		DataFetcher<List<BebanKerjaDosen>> fetcherBebanKerjaDosen = data -> { 
			try {
				
				Integer kodeProdi = data.getArgument("kodeProdi");
				String fakultas = data.getArgument("fakultas");
				String kategoriKegiatan = data.getArgument("kategoriKegiatan");
				Integer tahun = data.getArgument("tahun");
				
				if(kodeProdi != null && fakultas == null && kategoriKegiatan != null && tahun != null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen1(kodeProdi, kategoriKegiatan, tahun);
				} else if(kodeProdi == null && fakultas != null && kategoriKegiatan != null && tahun != null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen2(fakultas, kategoriKegiatan, tahun);
				} else if(kodeProdi != null && fakultas == null && kategoriKegiatan == null && tahun != null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen3(kodeProdi, tahun);
				} else if(kodeProdi == null && fakultas != null && kategoriKegiatan == null && tahun != null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen4(fakultas, tahun);
				} else if(kodeProdi != null && fakultas == null && kategoriKegiatan == null && tahun == null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen5(kodeProdi);
				} else if(kodeProdi == null && fakultas != null && kategoriKegiatan == null && tahun == null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen6(fakultas);
				} else if(kodeProdi != null && fakultas == null && kategoriKegiatan != null && tahun == null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen7(kodeProdi, kategoriKegiatan);
				} else if(kodeProdi == null && fakultas != null && kategoriKegiatan != null && tahun == null) {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen8(fakultas, kategoriKegiatan);
				} else {
					return (List<BebanKerjaDosen>) dosenDao.countRataBebanKerjaDosen(fakultas, kodeProdi, kategoriKegiatan, tahun);
				}
			} catch(Exception e) {
				return null;
			}		
		};
		
		DataFetcher<List<Dosen>> fetcherPengmasDosen = data -> { 
			try {
				
				Integer kodeProdi = data.getArgument("kodeProdi");
				String fakultas = data.getArgument("fakultas");
				Integer tahun = data.getArgument("tahun");
				
				if(kodeProdi != null && fakultas == null && tahun == null) {
					return (List<Dosen>) dosenDao.countPengabdianDosen1(kodeProdi);
				} else if(kodeProdi == null && fakultas != null && tahun == null) {
					return (List<Dosen>) dosenDao.countPengabdianDosen2(fakultas);
				} else if(kodeProdi != null && fakultas == null && tahun != null) {
					return (List<Dosen>) dosenDao.countPengabdianDosen3(kodeProdi, tahun);
				} else if(kodeProdi == null && fakultas != null && tahun != null) {
					return (List<Dosen>) dosenDao.countPengabdianDosen4(fakultas, tahun);
				} else {
					return (List<Dosen>) dosenDao.countPengabdianDosen(fakultas, kodeProdi, tahun);
				}
			} catch(Exception e) {
				return null;
			}		
		};
		
		DataFetcher<List<Dosen>> fetcherPenelitianDosen = data -> { 
			try {
				
				Integer kodeProdi = data.getArgument("kodeProdi");
				String fakultas = data.getArgument("fakultas");
				Integer tahun = data.getArgument("tahun");
				
				if(kodeProdi != null && fakultas == null && tahun == null) {
					return (List<Dosen>) dosenDao.countPenelitianDosen1(kodeProdi);
				} else if(kodeProdi == null && fakultas != null && tahun == null) {
					return (List<Dosen>) dosenDao.countPenelitianDosen2(fakultas);
				} else if(kodeProdi != null && fakultas == null && tahun != null) {
					return (List<Dosen>) dosenDao.countPenelitianDosen3(kodeProdi, tahun);
				} else if(kodeProdi == null && fakultas != null && tahun != null) {
					return (List<Dosen>) dosenDao.countPenelitianDosen4(fakultas, tahun);
				} else {
					return (List<Dosen>) dosenDao.countPenelitianDosen(fakultas, kodeProdi, tahun);
				}
			} catch(Exception e) {
				return null;
			}		
		};
		
		DataFetcher<List<IpDosen>> fetcherIpDosen = data -> { 
			try {
				
				Integer kodeProdi = data.getArgument("kodeProdi");
				String fakultas = data.getArgument("fakultas");
				Integer tahunAjaran = data.getArgument("tahunAjaran");
				
				if(kodeProdi != null && fakultas == null && tahunAjaran == null) {
					return (List<IpDosen>) dosenDao.countRataIpd1(kodeProdi);
				} else if (kodeProdi == null && fakultas != null && tahunAjaran == null) {
					return (List<IpDosen>) dosenDao.countRataIpd2(fakultas);
				} else if(kodeProdi != null && fakultas == null && tahunAjaran != null) {
					return (List<IpDosen>) dosenDao.countRataIpd3(kodeProdi, tahunAjaran);
				} else if(kodeProdi == null && fakultas != null && tahunAjaran != null) {
					return (List<IpDosen>) dosenDao.countRataIpd4(fakultas, tahunAjaran);
				} else {
					List<IpDosen> rataIpd =  dosenDao.countRataIpd(fakultas, kodeProdi, tahunAjaran);
					System.out.println("lalala");
					System.out.println(rataIpd.get(0).getRataIpd());
					return (List<IpDosen>) dosenDao.countRataIpd(fakultas, kodeProdi, tahunAjaran);
				}
			} catch(Exception e) {
				return null;
			}		
		};
		
		DataFetcher<List<JabatanDosen>> fetcherJabatanDosen = data -> { 
			try {
				Integer kodeProdi = data.getArgument("kodeProdi");
				String fakultas = data.getArgument("fakultas");
				String jabatan = data.getArgument("jabatan");
				
				if(kodeProdi != null && fakultas == null && jabatan != null) {
					List<JabatanDosen> jabatanDosen = this.dosenDao.countFungsionalDosen1(kodeProdi, jabatan);
					return jabatanDosen;
				} else if(kodeProdi == null && fakultas != null && jabatan != null) {
					List<JabatanDosen> jabatanDosen = this.dosenDao.countFungsionalDosen2(fakultas, jabatan);
					return jabatanDosen;
				} else if(kodeProdi != null && fakultas == null && jabatan == null) {
					List<JabatanDosen> jabatanDosen = this.dosenDao.countFungsionalDosen3(kodeProdi);
					return jabatanDosen;
				} else if(kodeProdi == null && fakultas != null && jabatan == null) {
					List<JabatanDosen> jabatanDosen = this.dosenDao.countFungsionalDosen4(fakultas);
					return jabatanDosen;
				} else {
					List<JabatanDosen> jabatanDosen = this.dosenDao.countFungsionalDosen(fakultas, kodeProdi, jabatan);
					return jabatanDosen;
				}
			} catch(Exception e) {
				return null;
			}		
		};
		
		DataFetcher<List<Dosen>> fetcherDosen = data -> { 
			
			Integer kodeProdi = data.getArgument("kodeProdi");
			String fakultas = data.getArgument("fakultas");
			String pendidikanTerakhir = data.getArgument("pendidikanTerakhir");
			Integer isOut = data.getArgument("isOut");
			System.out.print("hola");
			
			try {
				if(kodeProdi != null && fakultas == null && pendidikanTerakhir != null && isOut != null) {
					List<Dosen> dosen = this.dosenDao.countDosen1(kodeProdi, pendidikanTerakhir, isOut);
					return dosen;
				} else if(kodeProdi != null && fakultas == null && pendidikanTerakhir != null && isOut == null) {
					List<Dosen> dosen = this.dosenDao.countDosen2(kodeProdi, pendidikanTerakhir);
					return dosen;
				} else if(kodeProdi == null && fakultas != null && pendidikanTerakhir != null && isOut != null) {
					List<Dosen> dosen = this.dosenDao.countDosen3(fakultas, pendidikanTerakhir, isOut);
					return dosen;
				} else if(kodeProdi == null && fakultas != null && pendidikanTerakhir != null && isOut == null) {
					List<Dosen> dosen = this.dosenDao.countDosen4(fakultas, pendidikanTerakhir);
					return dosen;
				} else if(kodeProdi != null && fakultas == null && pendidikanTerakhir == null && isOut != null) {
					List<Dosen> dosen = this.dosenDao.countDosen5(kodeProdi, isOut);
					return dosen;
				} else if(kodeProdi != null && fakultas == null && pendidikanTerakhir == null && isOut == null) {
					List<Dosen> dosen = this.dosenDao.countDosen6(kodeProdi);
					return dosen;
				} else if(kodeProdi == null && fakultas != null && pendidikanTerakhir == null && isOut != null) {
					List<Dosen> dosen = this.dosenDao.countDosen7(fakultas, isOut);
					return dosen;
				} else if(kodeProdi == null && fakultas != null && pendidikanTerakhir == null && isOut == null) {
					List<Dosen> dosen = this.dosenDao.countDosen8(fakultas);
					return dosen;
				} else {
					List<Dosen> dosen = this.dosenDao.countDosen(fakultas, kodeProdi, pendidikanTerakhir, isOut);
					return dosen;
				}
			} catch(Exception e) {
				return null;
			}
		};

		return RuntimeWiring.newRuntimeWiring()
				.type("Query",typeWriting -> typeWriting
						.dataFetcher("jabatanDosen", fetcherJabatanDosen)
						.dataFetcher("dosen", fetcherDosen)
						.dataFetcher("bebanKerjaDosen", fetcherBebanKerjaDosen)
						.dataFetcher("pengabdianDosen", fetcherPengmasDosen)
						.dataFetcher("penelitianDosen", fetcherPenelitianDosen)
						.dataFetcher("ipDosen", fetcherIpDosen)
						)
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDosen(String body) throws IOException {
		loadSchema();
		ExecutionResult result = this.graphQL.execute(body);
		return Response.ok(result).build();
	}
}