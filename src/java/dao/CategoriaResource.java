
package dao;

import com.google.gson.Gson;
import entidades.Categoria;
import entidades.Produto;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Matheus
 */
@Path("categoria")
public class CategoriaResource {

    @Context
    private UriInfo context;
   
    
    
    public CategoriaResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mostrarCategorias() {
        Gson gson = new Gson();
        return gson.toJson(DaoCategoria.getAll());
    }
    
    @Path("{categoriaId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mostrarPorUmIDCategoria(@PathParam("categoriaId") String id) {        
        Gson gson = new Gson();
        Categoria cat = new Categoria();
        cat = DaoCategoria.getOne(Integer.parseInt(id));
        return gson.toJson(cat); 
    }
    
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
    public boolean editarCategoria(String content) {
        Gson gson = new Gson();
        Categoria cat = (Categoria) gson.fromJson(content, Categoria.class);
        return DaoCategoria.editar(cat);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
     public boolean inserirCategoria(String content) {
        Gson gson = new Gson();
        Categoria cat = (Categoria) gson.fromJson(content, Categoria.class);
        return DaoCategoria.persist(cat);
    }
     
    @Path("excluir/{CategoriaId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluirCategoria(@PathParam("categoriaId") String id) {
      return DaoCategoria.excluir(Integer.parseInt(id));
    }
}
