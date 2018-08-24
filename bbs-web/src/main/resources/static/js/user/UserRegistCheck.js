$(function(){
	 /*<![CDATA[*/
	var loginButton = $("#UserRegist");
	  loginButton.click(function(){
		var account = $('input[name="account"]').val();
		var userName = $('input[name="userName"]').val();
		var password = $('input[name="password"]').val();
		var password2 = $('input[name="password2"]').val();
		
		if(account.trim()==""){
			alert("用户账号不能为空，请重新输入");
			return false;
		}
		if(userName.trim()==""){
			alert("用户昵称不能为空，请重新输入");
			return false;
		}
		if(password.trim().length<=8 || password.trim().length>=20){
			alert("设置的密码长度应该在8~20个字符之间，请重新输入");
			return false;
		}
		if(password2.trim() != password.trim()){
			alert("二次密码输入的值不一样，请重新输入");
			return false;
		}
		
		$.ajax({
            url:"/user1/registSubmit",
            type:"post",
            data:$('#form').serialize(),
            success:function(data){
            	if(data=='1'){
            		alert("注册成功！");
            		location.href="/user1/success";
            	}else{
            		alert(data);
            	}
            },
            error:function(data){
            	
            }
        
        }); 
	})
	/*]]>*/
})
