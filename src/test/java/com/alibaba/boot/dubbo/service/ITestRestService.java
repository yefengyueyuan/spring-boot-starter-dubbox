package com.alibaba.boot.dubbo.service;

import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

@Path("user1")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface ITestRestService {
	
	@GET
    @Path("{id : \\d+}")
    String getString(@PathParam("id") @Min(1L) Long id);
	
	@GET
	@Path("register")
    String getTest();
}
