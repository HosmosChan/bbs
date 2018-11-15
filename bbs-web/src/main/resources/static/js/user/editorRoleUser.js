$(function () {
    /*<![CDATA[*/
    var loginButton = $("#tijiao3");
    var reg2 = new RegExp("[\\u4E00-\\u9FFF]+", "g");
    $("body").keydown(function (event) {
        if (event.keyCode == "13") {//keyCode=13是回车键
            loginButton.click();
        }
    });
    loginButton.click(function () {
        var userName = $('input[name="userName"]').val();
        var id = $('input[name="id"]').val();
        var password = $('input[name="password"]').val();
        var s = $("#selectRoleName").find("option:selected").val();
        var roleName = s;
        if (userName.trim() == "") {
            alert("用户昵称不能为空，请重新输入");
            return false;
        }
        if (password.trim().length <= 8 || password.trim().length >= 20) {
            alert("设置的密码长度应该在8~20个字符之间，请重新输入");
            return false;
        }
        if (reg2.test(password)) {
            alert("设置的密码不能含有汉字！！")
            return false;
        }
        $.ajax({
            url: "/role/editorSubmit",
            type: "post",
            data: {userName, password, roleName, id},
            success: function (data) {
                alert("已经成功修改")
                location.href = "/role/main_list"
            }
        });
    })
    /*]]>*/
});