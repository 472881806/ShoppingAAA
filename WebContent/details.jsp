<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="jq/res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="jq/res/layui/css/layui.css">
  <script type="text/javascript" src="jq/res/layui/layui.js"></script>
  <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="index.jsp">首页</a>
      </p>
      <div class="sn-quick-menu">
       <div class="login"><a href="login.jsp">登录</a></div>
        <div class="sp-cart"><a href="shopcart.jsp">注册</a></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="母婴商城">
            <img src="jq/res/static/img/logo.png">
          </a>
        </h1>
        
        <div class="mallSearch">
          <form action="search" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
        
      </div>
    </div>
  </div>


  <div class="content content-nav-base datails-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.jsp">所有商品</a>
            <a href="shopcart.jsp">购物车</a>
            <a href="user.jsp">个人中心</a>
          </div>
        </div>
      </div>
    </div>
    <div class="data-cont-wrap w1200">
      <div class="crumb">
        <a href="index.jsp">首页</a>
        <span>></span>
        <a href="commodity.jsp">所有商品</a>
        <span>></span>
        <a href="details.jsp">产品详情</a>
      </div>
   
	      <%
	          List pros	= (List)request.getAttribute("pros");
	      	  if(pros!=null){
	      		for(int i=0;i<pros.size();i++){
	          	  Product pro = (Product)pros.get(i);
	          	  String pname = pro.getPname();
	          	  String pimage = pro.getPimage();
	          	  double price = pro.getPrice();
	        %>
            <div class="product-intro layui-clear">
            
  	          <div class="preview-wrap">
  	          	<a href="javascript:;"><img src="<%=pimage %>.jpg"></a>
  	          </div>
  	          
  	          <div class="itemInfo-wrap">
  		          <div class="itemInfo">
  			            <div class="title">
  			              <h4><%=pname %></h4>
  			              <span><i class="layui-icon layui-icon-rate-solid"></i>收藏</span>
  			            </div>
  			            
  			            <div class="summary">
  			              <p class="reference"><span>商品编号</span><p id="p_id">001</p></p>
  			              <p class="activity"><span>活动价</span><strong class="price"><i>￥</i><%=price %></strong></p>
  			              
  			            </div>
  			            
  			            <div class="choose-attrs">
              				<div class="color layui-clear"><span class="title">颜&nbsp;&nbsp;&nbsp;&nbsp;色</span> <div class="color-cont"><span class="btn">白色</span> <span class="btn active">粉色</span></div></div>
              				<div id="buyNum" class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="" name="" value="1"><span class="add btn">+</span></div></div>
           				</div>
                        
  			            <div class="choose-btns">
  			            
  			        		<a href="index.jsp">
                             <input class="layui-btn layui-btn-primary purchase-btn" type="submit" value="立即购买"/>
         					</a>
                             <a href="javascript:void(0)" onclick="addCart()">
                                 <button class="layui-btn  layui-btn-danger car-btn"><i class="layui-icon layui-icon-cart-simple"></i>加入购物车</button>  
                             </a> 
                        </div>
                        
  		          </div>
  	          </div>
        	</div>
       		<%
       		 }
      	  }else{
      		  String message = (String)request.getAttribute("message");
      		  %>
      		  <div style="color:red font-size:50px"><%=message %></div> 
      		<%
      	  }
       %>
          
       
    
<script type="text/javascript">

 function addCart(){
	 alert();
		//获得购买的商品的数量
		var buyNum = $("#buyNum").find("input").val();
		var pid=$("#p_id").text();
		
		location.href="product?method=addProductToCart&pid="+pid+"&buyNum="+buyNum;
	  }
 
 

  layui.config({
    base: 'jq/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery'],function(){
      var mm = layui.mm,$ = layui.$;
      var cur = $('.number-cont input').val();
      $('.number-cont .btn').on('click',function(){
        if($(this).hasClass('add')){
          cur++;
         
        }else{
          if(cur > 1){
            cur--;
          }  
        }
        $('.number-cont input').val(cur)
      })
      
  });
  
</script>


</body>
</html></html>