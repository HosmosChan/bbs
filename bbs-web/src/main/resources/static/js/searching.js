$(function () {
    /*<![CDATA[*/
    /**
     * 搜索输入栏type跟随搜索类型转换
     * @author chenhuayang
     * @version 2018/9/6
     */
    $("#searchingType").change(function () {
        if ($("#searchingType").val() == 3) {
            $("#searchingDetails").attr("type", "date");
        }
        if ($("#searchingType").val() != 3) {
            $("#searchingDetails").attr("type", "text");
        }
    });
    $(function check() {
        if ($("#searchingType").val() == 3) {
            $("#searchingDetails").attr("type", "date");
        }
        if ($("#searchingType").val() != 3) {
            $("#searchingDetails").attr("type", "text");
        }
    })
    /*]]>*/
});