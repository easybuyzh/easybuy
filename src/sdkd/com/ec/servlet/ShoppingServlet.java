package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbViewCartDetail;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/8.
 */
@WebServlet(name = "ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String CommitOrder = request.getParameter("CommitOrder");
            if(CommitOrder != null){
                  new TableService().CommitOrderByCart((String)request.getSession().getAttribute("userName"));
                  request.getRequestDispatcher("shopping-result.jsp").forward(request,response);
                  return ;
            }


            String userName = (String)request.getSession().getAttribute("userName");
            if(request.getParameter("productid") != null){
                System.out.println(" &&& " + request.getParameter("productid"));
                request.getSession().setAttribute("productid",request.getParameter("productid"));
            }
            if(userName == null){
                   request.getSession().setAttribute("comfrom","shoppingservlet");
                   request.getRequestDispatcher("/login.jsp").forward(request,response);
                   return ;
            }
            String ProductId = (String)request.getSession().getAttribute("productid");
            if(ProductId != null){
                     new TableService().insertOneProductIntoCart(userName , ProductId , "" + 1);
                     request.getSession().removeAttribute("productid");
            }
            List<EbViewCartDetail> all = new TableService().getCart(userName);
            request.setAttribute("shoppingcartlist" , all);
            request.getRequestDispatcher("shopping.jsp").forward(request,response);
    }
}
