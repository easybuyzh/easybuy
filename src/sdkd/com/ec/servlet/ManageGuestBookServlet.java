package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbOrderView;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/9.
 */
@WebServlet(name = "ManageGuestBookServlet")
public class ManageGuestBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EbComment> commentList = new TableService().getCommentTable();
        String QueryByEcNickName = request.getParameter("querybyecnickname");

        if(QueryByEcNickName != null){
              commentList = new TableService().getCommentListByEcNickName(QueryByEcNickName);
        }
        setPageInfo(request,response,commentList,"/ManageGuestBook.Servlet");
        request.setAttribute("selected","留言");
        request.getRequestDispatcher("manage/guestbook.jsp").forward(request,response);
    }
    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response , List<EbComment> all , String url) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbComment> pageUtil = new PageUtil<EbComment>(10);//
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        String pageUrl = url;
        request.setAttribute("nowpage",nowPage);
        request.setAttribute("pagecount",pageCount);
        request.setAttribute("pageurl",pageUrl);
        request.setAttribute("commentlist", pageUtil.getSpecificPageList(all,Integer.valueOf(nowPage))); //
    }
}
