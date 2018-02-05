<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
    <title>Baidu Map </title>  
    <style type="text/css">  
        html{height:100%}  
        body{height:100%;margin:0px;padding:0px}  
        #container{height:50%}  
        #r-result{height:40%}  
    </style>  
</head>
<body>
<%
	String jingdu=request.getParameter("jingdu"); 
	String weidu=request.getParameter("weidu"); 
%>
<div id="container"></div>
<div id="r-result"></div>

</body>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jHUK9DE3Rjk46yWY9qgoV62vE0b5g3sQ"></script>
<script type="text/javascript">
$(function(){
	init();
})
var point;
function init(){
	/*1.将地图展示在div上*/
	var map = new BMap.Map("container");      // 创建地图实例  
	point = new BMap.Point(<%=jingdu%>, <%=weidu%>);  // 创建点坐标  
	map.centerAndZoom(point, 15);      
	/*2.poi搜索*/
	var local = new BMap.LocalSearch(map, {
		renderOptions: {map: map, panel: "r-result"}
	});
	local.searchNearby("公司",point,800)//半径
	/*3.给列表添加点击事件*/
	local.setInfoHtmlSetCallback(function(poi){
		document.getElementById("r-result").addEventListener("click",getAddress(poi.point));
	});
}
/*经纬度转换为地址*/
function getAddress(point){
	// 创建地理编码实例      
	var myGeo = new BMap.Geocoder(); 
	// 根据坐标得到地址描述    
	myGeo.getLocation(point, function(result){      
	    if (result){      
	    alert(result.address);      
	    }      
	});
}
</script>
</html>