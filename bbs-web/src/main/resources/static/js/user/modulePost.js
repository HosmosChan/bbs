$(function () {
    /*<![CDATA[*/
  
	 $(".moduleClass").click(function () {
	        var s = $(this);
	        var code = s.attr("value");
	        console.log(code);
	        $.ajax({
	            type: 'post',
	            url: '/post/moudelPost',
	            data: {"code": code},
	            success: function (data) {
	                debugger;
	                if (data == "1") {
	                    location.href = "/post/PostRediect?code=" + code;
	                } else {
	                    alert("暂无分类");
	                    location.href = "/post/index";
	                }
	            }
	        });
	    });
	 
    /*]]>*/
});