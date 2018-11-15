/**
 * author wangshixu 2018/9/5 14:50 打开新建板块弹出框
 */
$(function () {
    $("#moduleMessage").click(function () {
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