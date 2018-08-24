$(function(){
	  /*<![CDATA[*/
    var clickbutton1 = $("#go1");
    var clickbutton2 = $("#go2");
    var clickbutton3 = $("#go3");
	clickbutton1.click(function(){
        	var my = new Date();
        	var month=my.getMonth()+1;
        	var year=my.getYear()+1900;
        	var moduleId="2";
        	 alert("查询报表成功！ ");
        	location.href="/data/getlistData?year="+year+"&month="+month+"&moduleId="+moduleId;
    });
	clickbutton2.click(function(){
    	location.href="/data/testScheduled"
});
	clickbutton3.click(function(){
    	location.href="/data/exportMSG"
});
})