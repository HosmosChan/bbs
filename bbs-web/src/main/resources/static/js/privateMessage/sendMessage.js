$(function () {
    /*<![CDATA[*/
    /**
     * 私信提交提示信息&关闭发送私信界面
     * @author chenhuayang
     * @version 2018/8/10
     */
    $("#savePrivateMessage").click(function () {
        if ("" == $("#message").val()) {
            alert("请输入私信信息");
            return false;
        }
        else {
            alert("发送私信成功");
            window.parent.location.reload();
        }
    });
    /*]]>*/
});