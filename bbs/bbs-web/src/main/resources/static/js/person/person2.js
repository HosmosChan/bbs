 /* 
  * author wangshixu 2018/7/25 10:08
  * 获取当前用户的所有帖子
  */
 function getPersonalPost(){
 $.ajax({ 
 	type: "POST", 
     data:{
     	"account":0
     },
     dataType:"json",
     url: "/post/getMyPost",
     async: true, 
     success: function(data) {
     	var strHtml = ""+'';
     	//alert(data[0]['title']);
          for(var i =0 ;i<data.length;i++){
         		strHtml = strHtml + 
         		`<div class="f-i-bd">
 					<!-- 文章 -->
 					<div class="bd-text">
 						<h4 class="title"> `+data[i]["title"] +`</h4>
 						<div class="article">`+data[i]["article"]+`　  　　...
 						<a href="/post/getPostByCode?code=`+data[i]["code"]+`">查看原文</a>
 						</div>
 					</div>
 					<!-- 图片 -->
 					<div class="bd-media">
 						<div class="picture">
 							<div class="picture-preview">
 								<ul class="preview-list single clearfix">
 									<li>
 										<img src="`+data[i]["icon"]+`" style="max-width:500px; max-height:400px;">
 									</li>
 								</ul>
 							</div>
 						</div>
 					</div>
 					<div class="bd-operate sj-operate">
 						<div class="handle">
 							<a  href="javascript:void(0);" onclick="deletePost('`+data[i]["code"]+`')" title="删帖">删帖</a>
 							<span class="split-line"></span>
 							<a id="op-comment" class="op-comment" href="javascript:void(0);" onclick="opComment('`+data[i]["code"]+`')" title="评论">
 							评论
 							<span id="`+data[i]['code']+`commentAmount">(`+data[i]["replyAmount"]+`)</span>
 							</a>
 							<span class="split-line"></span>
 							<a class="op-praise praise" href="javascript:void(0);" onclick="opPraise('`+data[i]["code"]+`')">
 							<i class="praise-icon" id="`+data[i]['code']+`praise"></i>
 							<input id ="`+data[i]['code']+`praiseOrNot"  type="hidden" value="1"></input>
 							<span id="`+data[i]['code']+`praiseAmount" >(`+data[i]["praiseAmount"]+`)</span>
 							</a>
 						</div>
 					</div>
 					<div id="`+data[i]['code']+`wrapper" class="comment-wrapper"></div>
 					<div id="`+data[i]['code']+`list" class="comment-list"><div>
 				</div>`;
         }
         	$("#personalPosts").html(strHtml); 
         	
     },
     error: function(error){
 		alert("错误了！！！");
 	}
 });
 };
 
/*
*  打开评论 
*
* */
function opComment(postCode) {
 	var strHtml = `<div class="comment-title">
			<div class="cm-prompt">输入您的评论！</div>
			<div class="cm-title">评论</div>
			</div>
			<div class="comment-area">
			<textarea id ="`+ postCode+`textarea" class="cm-textarea" data-text="" bindcursor="true"></textarea>
			<input id="`+postCode+`cm-publish" onclick="commentPublish('`+postCode+`')" class="cm-button" type="button" title="发布" value="发布">
			</div>`;
	var commentId = "#"+postCode+"wrapper";
	$(commentId).html(strHtml);  
	/* 获取评论并展示评论列表 */
	$.ajax({ 
		type: "POST", 
        data:"postCode="+postCode,
        dataType:"json",
        url: "/post/getComment",
        async: true, 
        success: function(data) {
        	var strListHtml = "";
        	for(var i =0 ;i<data.length;i++){
        		strListHtml+=`<!-- 评论内容 -->
				<div class="comment-item">
					<div class="cm-pic">
						<a href="#"><img src="http://tx.tianyaui.com/logo/small/136682725" title="无事不登宝三殿" alt="无事不登宝三殿">
						</a>
					</div>
					<div class="cm-info">
						<p class="info-name"><a href="#" title="无事不登宝三殿">无事不登宝三殿</a></p>
						<div class="info-content">`+data[i]["content"]+`
						<span class="time">(今天&nbsp;10:27)</span>
						</div>
					</div>
				</div>`;
        	}
        	var commentId = "#"+postCode+"list";
        	$(commentId).html(strListHtml); 
        },
        error: function(error){
			alert("错误了！！！");
		}
    });
};
/*
*  发表评论
*
* */
function commentPublish(postCode){
	var contentId = "#"+postCode+"textarea";
	var content = $(contentId).val();
	$.ajax({
		type: "POST", 
        data:{
        	"postCode":postCode,
        	"content":content
        },
        url: "/post/commentPublish",
        async: true, 
        success: function(data) {
        	opComment(postCode);
        	$("#"+postCode+"commentAmount").html("("+data+")")
        },
        error:function(){
        	alert("发表评论出错！");
        }
	});
}; 
/*
*  点赞
*
* */
 function opPraise(postCode){
	var flag = $("#"+postCode+"praiseOrNot").val();
		$.ajax({ 
			type: "POST", 
		       data:{
		    	   "postCode":postCode,
		    	   "flag":flag
		       },
		       dataType:"json",
		       url: "/about/praise",
		       async: true, 
		       success: function(data) {
		       	$("#"+postCode+"praiseAmount").html("("+data+")");
		       },
		 });
		if(flag==1){
			$("#"+postCode+"praise").css("background-position","-12px -153px");	
			$("#"+postCode+"praiseOrNot").val(-1);
		}else{
			$("#"+postCode+"praise").css("background-position","0px -153px");	
			$("#"+postCode+"praiseOrNot").val(1);
		}
}; 
/*
*  autor:wangshixu 2018/7/23/17:22
*	此处有一个重大bug，后台在执行成功的情况下，还是会调转到error。重大疑问，苦恼。
* */
 function deletePost(postCode){
	$.ajax({ 
		type: "POST", 
	       data:{
	    	   "postCode":postCode
	       },
	       dataType:"json",
	       url: "/post/deletePost",
	       async : false, 
	       success:function(data) {
	    	   alert("删帖成功1！！");
	    	   getPersonalPost(); 
	       },
	       error:function(){
	        	alert("删帖成功2！！");
	        	getPersonalPost(); 
	        }
	 });
};  