
package dao;

import com.google.gson.Gson;
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
@Path("produto")
public class ProdutoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mostrarProdutos() {
        Gson gson = new Gson();
        return gson.toJson(DaoProduto.getAll());
    }
    
    @Path("{produtoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mostrarPorUmIDProduto(@PathParam("produtoId") String id) {        
        Gson gson = new Gson();
        Produto ct = new Produto();
        ct = DaoProduto.getOne(Integer.parseInt(id));
        return gson.toJson(ct); 
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean alterarProduto(String content) {
        Gson gson = new Gson();
        Produto ct = (Produto) gson.fromJson(content, Produto.class);
        return DaoProduto.editar(ct);
    }
    
    @Path("excluir/{ProdutoId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluirProduto(@PathParam("produtoId") String id) {
      return DaoProduto.excluir(Integer.parseInt(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
     public boolean inserirProduto(String content) {
        Gson gson = new Gson();
        Produto ct = (Produto) gson.fromJson(content, Produto.class);
        return DaoProduto.persist(ct);
}
}
