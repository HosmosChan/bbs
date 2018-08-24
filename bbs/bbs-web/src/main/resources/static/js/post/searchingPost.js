$(function () {
    /*<![CDATA[*/
    /**
     * 搜索条显示状况按搜索方式切换js
     * @author chenhuayang 2018/7/19
     */
    $(function check() {
        document.getElementById("searchingDetails").value = '请输入检索内容';
        document.getElementById("searchingDetails0").value = '';
        document.getElementById("searchingType").value = "1";
        document.getElementById("searchingDetails").style.visibility = "visible";
        document.getElementById("searchingDetails0").style.visibility = "hidden";
    });
    $("#searchingType").change(function () {
        if ($("#searchingType").val() == 3) {
            document.getElementById("searchingDetails").style.visibility = "hidden";
            document.getElementById("searchingDetails0").style.visibility = "visible";
            document.getElementById("searchingDetails").value = '请输入检索内容';
            document.getElementById("searchingDetails").style.color = '#9D9D9D';
        }
        else {
            document.getElementById("searchingDetails0").value = '';
            document.getElementById("searchingDetails").style.visibility = "visible";
            document.getElementById("searchingDetails0").style.visibility = "hidden";
        }
    });
    /**
     * 搜索帖子页面js
     * @author chenhuayang 2018/7/19
     */
    /**
     * 其他页面跳转至searchingPost搜索js
     * @author chenhuayang 2018/7/23
     */
    $(function check() {
        var storage = window.localStorage;
        var type = storage.storageType;
        var searchingDetails = storage.storageDetails;
        console.log(searchingDetails);
        var searchingDetails0 = storage.storageDetails0;
        var message;
        var status = "01";
        console.log(searchingDetails0);
        if (type == 1) {
            if (searchingDetails == "" || searchingDetails == "请输入检索内容") message = "";
            else message = searchingDetails;
            $.ajax({
                type: "POST",
                data: {
                    "title": message,
                    "status": status
                },
                dataType: "json",
                url: "/post/searchingPostInfo1",
                async: true,
                success: function (data) {
                    var strHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        if (data[i]["icon"] != null) {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="havePic">
                                            <img src="` + data[i]["icon"] + `" class="havePic_head">
                                        </div>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                        else {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                    }
                    $("#result-list-table").html(strHtml);
                },
                error: function (error) {
                    alert("错误了！！！");
                }
            });
        }
        else if (type == 2) {
            if (searchingDetails == "" || searchingDetails == "请输入检索内容") message = "";
            else message = searchingDetails;
            $.ajax({
                type: "POST",
                data: {
                    "userName": message,
                    "status": status
                },
                dataType: "json",
                url: "/post/searchingPostInfo2",
                async: true,
                success: function (data) {
                    var strHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        if (data[i]["icon"] != null) {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="havePic">
                                            <img src="` + data[i]["icon"] + `" class="havePic_head">
                                        </div>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                        else {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                    }
                    $("#result-list-table").html(strHtml);
                },
                error: function (error) {
                    alert("错误了！！！");
                }
            });
        }
        else if (type == 3) {
            if (searchingDetails0 == "" || searchingDetails0 == "请输入检索内容") message = "";
            else message = searchingDetails0;
            $.ajax({
                type: "POST",
                data: {
                    "publishDate": message,
                    "status": status
                },
                dataType: "json",
                url: "/post/searchingPostInfo3",
                async: true,
                success: function (data) {
                    var strHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        if (data[i]["icon"] != null) {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                               <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="havePic">
                                            <img src="` + data[i]["icon"] + `" class="havePic_head">
                                        </div>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                        else {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                    }
                    $("#result-list-table").html(strHtml);
                },
                error: function (error) {
                    alert("错误了！！！");
                }
            });
        }
        storage.clear();
        console.log(storage);
    });
    /**
     * 点击页面中“搜索按钮”搜索js
     * @author chenhuayang 2018/7/19
     */
    $("#searchingPost").click(function () {
        var message;
        if ($("#searchingType").val() == 1) {
            if ($("#searchingDetails").val() == "" || $("#searchingDetails").val() == "请输入检索内容") message = "";
            else message = $("#searchingDetails").val();
            $.ajax({
                type: "POST",
                data: {
                    "title": message,
                    "status": status
                },
                dataType: "json",
                url: "/post/searchingPostInfo1",
                async: true,
                success: function (data) {
                    var strHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        if (data[i]["icon"] != null) {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="havePic">
                                                <img src="` + data[i]["icon"] + `" class="havePic_head">
                                        </div>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                        else {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                    }
                    $("#result-list-table").html(strHtml);
                },
                error: function (error) {
                    alert("错误了！！！");
                }
            });
        }
        else if ($("#searchingType").val() == 2) {
            if ($("#searchingDetails").val() == "" || $("#searchingDetails").val() == "请输入检索内容") message = "";
            else message = $("#searchingDetails").val();
            $.ajax({
                type: "POST",
                data: {
                    "userName": message,
                    "status": status
                },
                dataType: "json",
                url: "/post/searchingPostInfo2",
                async: true,
                success: function (data) {
                    var strHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        if (data[i]["icon"] != null) {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="havePic">
                                                <img src="` + data[i]["icon"] + `" class="havePic_head">
                                        </div>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                        else {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                    }
                    $("#result-list-table").html(strHtml);
                },
                error: function (error) {
                    alert("错误了！！！");
                }
            });
        }
        else if ($("#searchingType").val() == 3) {
            if ($("#searchingDetails0").val() == "" || $("#searchingDetails0").val() == "请输入检索内容") message = "";
            else message = $("#searchingDetails0").val();
            $.ajax({
                type: "POST",
                data: {
                    "publishDate": message,
                    "status": status
                },
                dataType: "json",
                url: "/post/searchingPostInfo3",
                async: true,
                success: function (data) {
                    var strHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        if (data[i]["icon"] != null) {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="havePic">
                                                <img src="` + data[i]["icon"] + `" class="havePic_head">
                                        </div>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                        else {
                            strHtml +=
                                `<div class="indexCon_msg">
                                    <div class="indexCon_msg_pic"></div>
                                    <div class="indexCon_msg_detail">
                                        <a href="">
                                            <div class="indexCon_msg_detail_tittle">
                                                <span>` + data[i]["className"] + `</span>
                                            </div>
                                        </a>
                                        <a href="/post/getPostByCode/?code=` + data[i]['code'] + `" target="_blank">
                                            <div class="indexCon_msg_detail_tittle">
                                                <p>` + data[i]["title"] + `</p>
                                            </div>
                                        </a>
                                        <div class="indexCon_msg_detail_other">
                                            <ul>
                                                <li>` + data[i]["userName"] + `</li>
                                                <li>` + data[i]["createDate"] + `</li>
                                                <li>` + data[i]["readingAmount"] + `</li>
                                                <li>` + data[i]["praiseAmount"] + `</li>
                                                <li>` + data[i]["replyAmount"] + `</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            `;
                        }
                    }
                    $("#result-list-table").html(strHtml);
                },
                error: function (error) {
                    alert("错误了！！！");
                }
            });
        }
        ;
    });
    /*]]>*/
});