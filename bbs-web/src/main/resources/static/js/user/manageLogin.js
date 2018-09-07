$(function(){
     /*<![CDATA[*/
    var loginButton = $("#demoLogin");
//    
    $("body").keydown(function(event) {
    	 if (event.keyCode == "13") {//keyCode=13是回车键
    		 loginButton.click();
    	 }
    });
  
    loginButton.click(function(){
        var account = $('input[name="account"]').val();
        var password = $('input[name="password"]').val();
        
        if(account.trim()==""){
            alert("用户账号不能为空，请重新输入");
            return false;
        }
        $.ajax({
            url:"/role/loginAttest",
            type:"post",
            data:$('#form1').serialize(),
            success:function(data){
                if(data=='1'){
                    alert("账号或密码输入有误！");
                    location.href="/role/login";
                }
                if(data=='2'){
                	alert("你不是管理员，无此权限");
                    location.href="/role/login";
                }
                if(data=='3'){
                	location.href="/role/roleindex";
                }
                if(data=='4'){
                	alert("账号输入有误！");
                    location.href="/role/login";
                }
            }
        
        }); 
    })
    /*]]>*/
})
