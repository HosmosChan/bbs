$(function () {
/*<![CDATA[*/
    /**
     * 搜索帖子js
     * @author chenhuayang 2018/7/23
     */
    /**
     * 搜索条显示状况按搜索方式切换js
     * @author chenhuayang 2018/7/23
     */
    $(function check(){
        document.getElementById("searchingDetails").value='请输入检索内容';
        document.getElementById("searchingDetails0").value='';
        document.getElementById("searchingType").value="1";
        document.getElementById("searchingDetails").style.visibility="visible";
        document.getElementById("searchingDetails0").style.visibility="hidden";
    });
    $("#searchingType").change(function () {
        if($("#searchingType").val() == 3) {
            document.getElementById("searchingDetails").style.visibility="hidden";
            document.getElementById("searchingDetails0").style.visibility="visible";
            document.getElementById("searchingDetails").value='请输入检索内容';
            document.getElementById("searchingDetails").style.color='#9D9D9D';
        }
        else {
            document.getElementById("searchingDetails0").value='';
            document.getElementById("searchingDetails").style.visibility="visible";
            document.getElementById("searchingDetails0").style.visibility="hidden";
        }
    });
    /**
     * 搜索帖子跳转到searchingPost并搜索帖子js
     * @author chenhuayang 2018/7/23
     */
    $("#searchingPost").click(function(){
        var storage = window.localStorage;
        storage["storageType"] = document.getElementById("searchingType").value;
        storage["storageDetails"] = document.getElementById("searchingDetails").value;
        storage["storageDetails0"] = document.getElementById("searchingDetails0").value;
        console.log(typeof storage["storageType"]);
        console.log(typeof storage["storageDetails"]);
        console.log(typeof storage["storageDetails0"]);
        location.href = ("/post/searchingPost");
    });
    /*]]>*/
})