package sdkd.com.ec.model;

/**
 * Created by zhangjiwen on 2016/7/7.
 */
public class EbNotice {
   /* notice_id
            notice_title
    notice_content
            notice_time*/
    String NoticeId;
    String NoticeTitle;
    String NoticeContent;
    String NoticeTime;

    public String getNoticeTime() {
        return NoticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        NoticeTime = noticeTime;
    }

    public String getNoticeContent() {
        return NoticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        NoticeContent = noticeContent;
    }

    public String getNoticeTitle() {
        return NoticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        NoticeTitle = noticeTitle;
    }

    public String getNoticeId() {
        return NoticeId;
    }

    public void setNoticeId(String noticeId) {
        NoticeId = noticeId;
    }
}
