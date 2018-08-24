$(function(){
    /*<![CDATA[*/
    var likeButton = $("#saveUser");
   
    likeButton.click(function(){
    	if(account.value.trim()==""){
    		alert("账号不能为空或空串");
    		return false;
    	}
    	if(userName.value.trim()==""){
    		alert("用户名不能为空或空串");
    		return false;
    	}
    	
    	if(password.value.trim()==""){
    		alert("密码不能为空");
    		return false;
    	}
    	if(password.value!=confirmPassword.value){
    		alert("密码和确认密码不一样");
    		return false;
    	}
    	//判断用户账号是否存在
    	
    	 		$.ajax({
            url:"/user/getUser",
            type:"post",
            data:$('#form').serialize(),
            success:function(data){
            	if(data==""){
              	$.ajax({
                    url:"/user/saveUser",
                    type:"post",
                    data:$('#form').serialize(),
                    success:function(data){
                    	alert("保存成功");
                    	　location.href="/user/listUser"
                    },
                    error:function(e){
        				alert("保存失败");
                    }
                }); 
            	}
            },
            error:function(e){
				alert("保存失败");
            }
        });  
    		
  
    });  

    /*]]>*/
 
})

