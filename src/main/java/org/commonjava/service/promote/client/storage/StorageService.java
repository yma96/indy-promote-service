package org.commonjava.service.promote.client.storage;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api/storage")
@RegisterRestClient(configKey="storage-service-api")
public interface StorageService
{
    @DELETE
    @Path("content/{filesystem}/{path: (.*)}")
    Response delete(final @PathParam( "filesystem" ) String filesystem, final @PathParam( "path" ) String path);

    @DELETE
    @Path("filesystem")
    Response delete(final BatchDeleteRequest request );

    @GET
    @Path("content/{filesystem}/{path: (.*)}")
    Response retrieve(final @PathParam( "filesystem" ) String filesystem, final @PathParam( "path" ) String path);

    @POST
    @Path( "copy" )
    Response copy( final FileCopyRequest request );

    @HEAD
    @Path("content/{filesystem}/{path: (.*)}")
    Response exists(final @PathParam( "filesystem" ) String filesystem, final @PathParam( "path" ) String path);
}