package id.its.api.spmi.security;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.its.api.spmi.security.DataJWTAuthorizationFilter;
import id.its.integra.security.jwt.IntegraJWTValidator;

@Provider
@Priority(value = 2000)
public class DataJWTAuthorizationFilter implements ContainerRequestFilter {

	private Logger log = LoggerFactory.getLogger(DataJWTAuthorizationFilter.class);

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext ctx) throws IOException {
		String jwtHeader = ctx.getHeaderString("x-jwt-assertion");

		if (jwtHeader != null && !jwtHeader.isEmpty()) {
			IntegraJWTValidator tokenValidator = new IntegraJWTValidator(jwtHeader);
			if (!tokenValidator.isValid()) {
				ctx.abortWith(Response.status(Status.UNAUTHORIZED).build());
			}
		} else {
			ctx.abortWith(Response.status(Status.UNAUTHORIZED).build());
		}
	}
}