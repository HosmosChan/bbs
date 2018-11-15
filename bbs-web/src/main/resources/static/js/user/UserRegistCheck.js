$(function () {
    /*<![CDATA[*/
    var loginButton = $("#UserRegist");
    var reg = /^[0-9]*$/;
    var reg2 = new RegExp("[\\u4E00-\\u9FFF]+", "g");
    $("body").keydown(function (event) {
        if (event.keyCode == "13") {//keyCode=13是回车键
            loginButton.click();
        }
    });
    loginButton.click(function () {
        var account = $('input[name="account"]').val();
        var userName = $('input[name="userName"]').val();
        var password = $('input[name="password"]').val();
        var password2 = $('input[name="password2"]').val();
        if (account.trim() == "") {
            alert("用户账号不能为空，请重新输入");
            return false;
        }
        if (account.trim().length != 11) {
            alert("请输入正确的手机号！")
            return false;
        }
        if (!reg.test(account)) {
            alert("输入的手机号存在数字以外的字符，请输入正确的手机号！")
            return false;
        }
        if (userName.trim() == "") {
            alert("用户名不能为空，请重新输入");
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
        if (password2.trim() != password.trim()) {
            alert("二次密码输入的值不一样，请重新输入");
            return false;
        }
        $.ajax({
            url: "/user1/registSubmit",
            type: "post",
            data: $('#form').serialize(),
            success: function (data) {
                if (data == '1') {
                    alert("注册成功！");
                    location.href = "/user1/success";
                } else {
                    alert(data);
                }
            }
        });
    })
    /*]]>*/
});