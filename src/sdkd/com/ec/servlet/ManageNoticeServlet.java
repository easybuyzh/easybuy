package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbNotice;
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
 * Created by zhangjiwen on 2016/7/12.
 */
@WebServlet(name = "ManageNoticeServlet")
public class ManageNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NoticeDelete = request.getParameter("noticedelete");
        String NoticeCreateTime = request.getParameter("noticecreatetime");
        setPageInfo(request, response, new TableService().getNoticeTable(), "/ManageNotice.Servlet");
        if (NoticeDelete != null) {
            new TableService().deleteNoticeByNoticeCreateTime(NoticeCreateTime);
            response.sendRedirect("/ManageNotice.Servlet");
            return;
        }
        request.setAttribute("selected", "公告");
        request.getRequestDispatcher("manage/notice.jsp").forward(request, response);
    }

    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response, List<EbNotice> all, String url) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbNotice> pageUtil = new PageUtil<EbNotice>(10);
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        String pageUrl = url;
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("pageurl", pageUrl);
        request.setAttribute("noticelist", pageUtil.getSpecificPageList(all, Integer.valueOf(nowPage)));
    }
}
