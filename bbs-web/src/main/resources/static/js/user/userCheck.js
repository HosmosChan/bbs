$(function () {
    var loginButton = $("#login");
    loginButton.click(function () {
        var username = $('input[name="userName"]').val();
        var password = $('input[name="password"]').val();
        if (username.trim() == "") {
            alert("用户账号为空，请输入用户账号");
            return false;
        }
        if (password.trim() == "") {
            alert("密码为空，请输入密码");
            return false;
        }
    })
});