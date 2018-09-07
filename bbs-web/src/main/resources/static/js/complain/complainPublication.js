$(function () {
    /*<![CDATA[*/
    /**
     * 投诉提交提示信息&关闭投诉界面
     * @author chenhuayang
     * @version 2018/8/10
     */
    $("#saveComplain").click(function () {
        if ($("#typeCode").val() == "" && $("#message").val() != "") {
            alert("请选择投诉类型");
            return false;
        }
        else if ($("#typeCode").val() != "" && $("#message").val() == "") {
            alert("请输入投诉内容描述");
            return false;
        }
        else if ($("#typeCode").val() == "" && $("#message").val() == "") {
            alert("请输入投诉信息");
            return false;
        }
        else {
            alert("投诉成功");
            window.parent.location.reload();
        }
    });
    /**
     * 投诉标题初始化js
     * @author chenhuayang
     * @version 2018/7/23
     */
    $(function check() {
        /**
         * 投诉类型下拉链表自动填充
         * @author chenhuayang
         * @version 2018/7/23
         * @version 2018/7/25
         */
        var createBy = "Admin";
        $.ajax({
            type: "POST",
            dataType: "json",
            data: createBy,
            url: "/../../complain/getComplainType",
            async: true,
            success: function (data) {
                var strHtml = "";
                strHtml += `<option value="">----------------请选择----------------</option>`;
                for (var i = 0; i < data.length; i++) {
                    strHtml +=
                        `<option value="` + data[i]["code"] + `">` + data[i]["typer"] + `</option>`;
                }
                $("#typeCode").html(strHtml);
            },
            error: function (error) {
                alert("错误了！！！");
            }
        });
        document.getElementById("typeCode").value = "";
    });
    /**
     * 投诉内容字数限制
     * @author chenhuayang
     * @version 2018/9/6
     */
    $(window.onload = function () {
        //（document）
        document.getElementById('message').onkeyup = function () {
            document.getElementById('text-count').innerHTML = this.value.length;
        }
    })
    /*]]>*/
});