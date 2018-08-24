$(function(){
    /*<![CDATA[*/
	var loginButton = $("#tijiao3");
	loginButton.click(function(){
		var userName = $('input[name="userName"]').val();
		var id = $('input[name="id"]').val();
		var password = $('input[name="password"]').val();
	    var s=$("#selectRoleName").find("option:selected").val();
	    var roleName=s;
		if(userName.trim()==""){
			alert("用户昵称不能为空，请重新输入");
			return false;
		}
		if(password.trim().length<=8 || password.trim().length>=20){
			alert("设置的密码长度应该在8~20个字符之间，请重新输入");
			return false;
		}
 		$.ajax({
            url:"/role/editorSubmit",
            type:"post",
            data:{userName,password,roleName,id},
            success:function(data){
            	location.href="/role/main_list"
            }
        
        });  
		
	})
	/*]]>*/
})
