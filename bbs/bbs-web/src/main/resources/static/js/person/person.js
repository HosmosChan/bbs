/* 
 * author wangshixu 2018/7/25 10:08
 * 打开新建板块弹出框
 */
$(function(){
 $("#moduleManage").click(function(){
 layer.open({
        type: 2,
        skin: '#e43e20',
        title: '添加新板块',
        fix: false,
        shadeClose: true,
        area: ['700px', '670px'],
        content: '/module/selectAllModule',
    })
});
 $("#moduleMessage").click(function(){
	 layer.open({
	        type: 2,
	        skin: '#e43e20',
	        title: '版块信息查看',
	        fix: false,
	        shadeClose: true,
	        area: ['700px', '670px'],
	        content: '/post/getPostClassNum',
	    })
	});
});




