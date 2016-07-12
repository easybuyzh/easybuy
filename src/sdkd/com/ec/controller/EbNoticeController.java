package sdkd.com.ec.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangjiwen on 2016/7/7.
 */
@WebServlet(name = "EbNoticeController")
public class EbNoticeController extends ActionSupport implements RequestAware,SessionAware{
    private Map<String, Object> request;
    private Map<String, Object> session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // EbNoticeDao ebNoticeDao =new EbNoticeDao();
        //List<EbNotice> list =ebNoticeDao.getNotice();
       // request.setAttribute("ebnoticelist",list);
       String producvtid =  request.getParameter("productid");
       // System.out.print(producvtid);

       // request.getRequestDispatcher("/shopping.jsp").forward(request,response);
    }

    public  static  void execute_(){
        //System.out.print("*************");
    }

    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
