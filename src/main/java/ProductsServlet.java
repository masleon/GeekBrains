import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="productsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Web app started!");
        List<Product> list = new ArrayList<Product>(){{
            add(new Product(1,"Chewing gum",1.3f));
            add(new Product(2,"Bread",5.0f));
            add(new Product(3,"Notebook",120.6f));
            add(new Product(4,"Cup",15.2f));
            add(new Product(5,"Bottle",6.7f));
            add(new Product(6,"Photo frame",10.1f));
            add(new Product(7,"Freezer",150.0f));
            add(new Product(8,"Apple",4.0f));
            add(new Product(9,"Guitar stand",30.2f));
            add(new Product(10,"Table",50.2f));
        }};
        for (Product product: list){
            resp.getWriter().println(product);
        }
    }
}
