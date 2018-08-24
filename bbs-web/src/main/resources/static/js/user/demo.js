$(function(){
     /*<![CDATA[*/
    var loginButton = $("#demoLogin");
    loginButton.click(function(){
        var account = $('input[name="account"]').val();
        var password = $('input[name="password"]').val();
        
        if(account.trim()==""){
            alert("用户账号不能为空，请重新输入");
            return false;
        }
        if(password.trim().length<=8 || password.trim().length>=20){
            alert("设置的密码长度应该在8~20个字符之间，请重新输入");
            return false;
        }
        
        $.ajax({
            url:"/user1/login1Submit",
            type:"post",
            data:$('#form').serialize(),
            success:function(data){
                if(data=='1'){
                    alert("密码错误！");
                    location.href="/user1/demo";
                }else{
                    location.href="/post/index";
                }
            }
        
        }); 
    })
    /*]]>*/
})
