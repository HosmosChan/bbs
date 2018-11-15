$(function () {
    /*<![CDATA[*/
    var selectbutton = $("#select");
    var exportbutton = $("#exportMsg");
    exportbutton.click(function () {
        var my = new Date();
        var month = my.getMonth() + 1;
        var year = my.getYear() + 1900;
        yearString = document.getElementById("year");
        monthString = document.getElementById("month");
        if (yearString.value == "00" || monthString.value == "01") {
            alert("选择年份与月份后才能导出");
        }
        else {
            var yearselect = yearString.value;
            var monthselect = monthString.value;
            if (yearselect > year || (yearselect < (year + 1) && (monthselect > month || monthselect < 7)))//超出当前时间&&7月之前也没有数据
            {
                alert("您选择的" + yearselect + "年" + monthselect + "月宝宝这没有任何数据呢");
            }
            else {
                //将不确定什么类型的数据转化为确定类型的
                month = monthselect;
                year = yearselect;
                alert("正在导出" + yearselect + "年" + monthselect + "月的数据");
                location.href = "/data/exportMSG?year=" + year + "&month=" + month;
            }
        }
    });
    selectbutton.click(function () {
        var my = new Date();
        var month = my.getMonth() + 1;
        var year = my.getYear() + 1900;
        yearString = document.getElementById("year");
        monthString = document.getElementById("month");
        if (yearString.value == "00" || monthString.value == "01") {
            alert("请选择正确的年份与月份");
        }
        else {
            var yearselect = yearString.value;
            var monthselect = monthString.value;
            if (yearselect > year || (yearselect < (year + 1) && (monthselect > month || monthselect < 7)))//超出当前时间
            {
                alert("您选择的" + yearselect + "年" + monthselect + "月宝宝这没有任何数据呢");
            }
            else {
                //将不确定什么类型的数据转化为确定类型的
                month = monthselect;
                year = yearselect;
                alert("正在查询" + yearselect + "年" + monthselect + "月的数据");
                location.href = "/data/getlistData?year=" + year + "&month=" + month;
            }
        }
        /*]]>*/
    })
});