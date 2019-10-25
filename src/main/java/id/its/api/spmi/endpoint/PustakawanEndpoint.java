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
import id.its.api.spmi.dao.PustakawanDao;
import id.its.api.spmi.model.Pustakawan;

@Path("/pustakawan")
public class PustakawanEndpoint {

	private PustakawanDao pustakawanDao;
	
	public PustakawanDao getPustakawanDao() {
		return pustakawanDao;
	}
	public void setPustakawanDao(PustakawanDao pustakawanDao) {
		this.pustakawanDao = pustakawanDao;
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
		DataFetcher<List<Pustakawan>> fetcherPustakawan = data -> { 
			try {
				String jenjang = data.getArgument("jenjang");
				
//				filter pustakawan berdasarkan jenjang
				if(jenjang != null) {
					List<Pustakawan> jumlahPustakawan = this.pustakawanDao.getJumlahPustakawan(jenjang);
					return jumlahPustakawan;
//				tidak ada filter untuk pustakawan, semua jenjang ditampilkan
				} else {
					List<Pustakawan> jumlahPustakawan = this.pustakawanDao.getJumlahPustakawanList();
					return jumlahPustakawan;
				}
			} catch(Exception e) {
				return null;
			}	
		};
		
		return RuntimeWiring.newRuntimeWiring()
				.type("Query",typeWriting -> typeWriting
						.dataFetcher("pustakawan", fetcherPustakawan))				
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPustakawan(String body) throws IOException {
		loadSchema();
		ExecutionResult result = this.graphQL.execute(body);
		return Response.ok(result).build();
	}
}