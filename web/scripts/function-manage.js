// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/ManageGuestBookModify.Servlet?ecdelete=true&ecid=" + id;
	}
}

function DeleteNews(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/ManageNews.Servlet?endelete=true&enid=" + id;
	}
}