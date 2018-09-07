$(function () {
    /*<![CDATA[*/
    /**
     * @author chenhuayang
     * @version 2018/9/2
     * 验证码输入框清空
     */
    $(function check() {
        document.getElementById("inputCode").value = "";
    });
    /**
     * @author chenhuayang
     * @version 2018/8/30
     * @param bind
     * 回车键登录功能
     */
	var loginButton = $("#demoLogin");

	$("body").keydown(function(event) {
		if (event.keyCode == "13") {// keyCode=13是回车键
			loginButton.click();
		}
	});

	loginButton.click(function() {
		var account = $('input[name="account"]').val();
		var password = $('input[name="password"]').val();
		var inputCode = document.getElementById("inputCode").value;

		if (account.trim() == "") {
			alert("用户账号不能为空，请重新输入");
			return false;
		}

		if (inputCode.toUpperCase() != code1.toUpperCase()) {
			alert("验证码输入错误，请重新输入！");
			drawPic();
			return false;
		}

		$.ajax({
			url : "/user1/login1Submit",
			type : "post",
			data : $('#form').serialize(),
			success : function(data) {
				if (data == '1') {
					alert("账号或密码输入有误！");
					location.href = "/user1/demo";
				} 
				if (data == '2') {
					location.href = "/post/index";
				}
				if (data == '3') {
					alert("账号不存在，请先进行注册！");
					location.href = "/user1/demo";
				}
			}

		});
	})
    /**
     * @author chenhuayang
     * @version 2018/9/2
     * 判断验证码输入是否正确
     */
    $('#inputCode').blur(function f() {
        var inputCode = document.getElementById("inputCode").value;
        if (inputCode.toUpperCase() != code1.toUpperCase()) {
            $(".vm").attr("src","/images/check_error.gif");
            $(".vm").attr("style","");
        }
        if (inputCode.toUpperCase() == code1.toUpperCase()) {
            $(".vm").attr("src","/images/check_right.gif");
            $(".vm").attr("style","");
        }
    });
    /*]]>*/
});