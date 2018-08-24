/* 
 * author wangshixu 2018/7/25 10:08
 * 打开帖子投诉弹出框
 */
$(function(){
    $("#addComplain").click(function(){
        layer.open({
            type: 2,
            skin: 'layui-layer-lan',
            title: '举报',
            fix: false,
            shadeClose: true,
            area: ['700px', '670px'],
            content: '/post/addComplain',
        })
    });
});