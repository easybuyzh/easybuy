package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbViewCartDetail;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/8.
 */
@WebServlet(name = "ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("selected", "首页");
        request.setAttribute("productcategorylist", new TableService().getProductCategoryTable());
        String CommitOrder = request.getParameter("commitorder");
        String userName = (String) request.getSession().getAttribute("userName");
        String DeleteByEpId = request.getParameter("deletebyepid");
        String IncByEpId = request.getParameter("incbyepid");

        if (userName == null) { // 未登录转到登录页面
            doLogin(request, response);
            return;
        }
        if (CommitOrder != null) {    // 点击提交订单
            doCommitOrder(request, response);
            return;
        }
        if(DeleteByEpId != null){
            doDeleteByEpId(request,response);
            return ;
        }
        if(IncByEpId != null){
            doIncByEpId(request,response);
            return;
        }
        doNormal(request,response);  // 正常进入购物车
    }

    protected void doCommitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println("******************8");
        String userName = (String) request.getSession().getAttribute("userName");
        //这里不再判断userName是否为空，是因为CommitOrder这个值是由该页面内部的键提交的
        int Number = new TableService().getCart(userName).size();
        if (Number > 0) {
            boolean res = new TableService().CommitOrderByCart(userName);
            if (res == false) {
                request.setAttribute("commitfailed", "true");
            }
            //当购物车里有商品时才提交订单
        } else {
            request.setAttribute("cartempty", "true");
            //没有商品则向shopping-result页面传递购物车为空的信息
        }
        request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("productid") != null) {
            request.getSession().setAttribute("productid", request.getParameter("productid"));
        }
        request.getSession().setAttribute("comfrom", "shoppingservlet");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doNormal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("userName");
        String ProductId = (String) request.getAttribute("productid");
        if(ProductId == null) ProductId = request.getParameter("productid");

        if (ProductId != null) {
            new TableService().insertOneProductIntoCart(userName, ProductId, "" + 1);
            request.getSession().removeAttribute("productid");
        }
        List<EbViewCartDetail> all = new TableService().getCart(userName);
       // System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&   " + all.size() + " " + ProductId);
        request.setAttribute("shoppingcartlist", all);
        request.getRequestDispatcher("shopping.jsp").forward(request, response);
    }
    protected void doIncByEpId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IncByEpId = request.getParameter("incbyepid");
        String userName = (String)request.getSession().getAttribute("userName");
        new TableService().IncCartQuantityByUserName(userName,IncByEpId);
        request.setAttribute("shoppingcartlist", new TableService().getCart(userName));
        request.getRequestDispatcher("/shopping.jsp").forward(request, response);
    }
    protected void doDeleteByEpId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String DeleteByEpId = request.getParameter("deletebyepid");
        String userName = (String)request.getSession().getAttribute("userName");
        new TableService().DeleteCartByUserName(userName,DeleteByEpId);
        request.setAttribute("shoppingcartlist", new TableService().getCart(userName));
        request.getRequestDispatcher("/shopping.jsp").forward(request, response);
    }
}
