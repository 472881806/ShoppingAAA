<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>购物车</title>
  <link rel="stylesheet" type="text/css" href="jq/res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="jq/res/layui/css/layui.css">
  <script type="text/javascript" src="jq/res/layui/layui.js"></script>
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
        <div class="sp-cart"><a href="register.jsp">注册</a></div>
      </div>
    </div>
   </div>
  

 <!-- 购物车 开始-->
  <div class="content content-nav-base shopcart-content">
  
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.jsp" class="active">所有商品</a>
            <a href="buytoday.jsp">今日团购</a>
            <a href="shopcart.jsp">购物车</a>
            <a href="user.jsp">个人中心</a>
          </div>
        </div>
      </div>
    </div>
   
   <div class="cart w1200">
     <!-- 头部 开始-->
      <div class="cart-table-th">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="allCheckked" type="checkbox" value="true">
            </div>
            <label>&nbsp;&nbsp;全选</label>
          </div>
        </div>
        
        <div class="th th-item">
          <div class="th-inner">
            商品
          </div>
        </div>
        
        <div class="th th-price">
          <div class="th-inner">
            单价
          </div>
        </div>
        
        <div class="th th-amount">
          <div class="th-inner">
            数量
          </div>
        </div>
        
        <div class="th th-sum">
          <div class="th-inner">
            小计
          </div>
        </div>
        
        <div class="th th-op">
          <div class="th-inner">
            操作
          </div>
        </div>  
      </div>
    <!-- 头部结束 -->
   
    <!-- 主体开始 -->
       <div class="OrderList">
        <div class="order-content" id="list-cont">
        <c:forEach items="${cart.cartItems }" var="entry">
          <ul class="item-content layui-clear">
        
            <li class="th th-chk">
              <div class="select-all">
                <div class="cart-checkbox">
                  <input class="CheckBoxShop check" type="checkbox" num="all" name="select-all" value="true">
                </div>
              </div>
            </li>
         
            <li class="th th-item">
              <div class="item-cont">
                <a href="javascript:;"><img src="${entry.value.product.pimage}.jpg"></a>
                <div class="text">
                  <div class="title">${entry.value.product.pname}</div>
                  
                </div>
              </div>
            </li>
            
            <li class="th th-price">
              <span class="th-su">${entry.value.product.price}</span>
            </li>
            
            <li class="th th-amount">
              <div class="box-btn layui-clear">
                <div class="less layui-btn">-</div>
                <input class="Quantity-input" type="" name="" value="${entry.value.buyNum }" disabled="disabled">
                <div class="add layui-btn">+</div>
              </div>
            </li>
            
            <li class="th th-sum">
              <span class="sum">${entry.value.subtotal }</span>
            </li>
            
            <li class="th th-op">
             
              <a href="product?method=delProFromCart&pid=${entry.value.product.pid}" class="dele-btn">删除</a>
            </li>
          </ul>
         </c:forEach>
        </div>
      </div>
   <!-- 主体结束-->
   
    <!-- 底部开始 -->
     
      <div class="FloatBarHolder layui-clear">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="" name="select-all" type="checkbox"  value="true">
            </div>
            <label>&nbsp;&nbsp;已选<span class="Selected-pieces">0</span>件</label>
          </div>
        </div>
        
        <div class="th batch-deletion">
          <span class="batch-dele-btn">批量删除</span>
        </div>
        
        <div class="th Settlement">
         
          <button class="layui-btn" onclick="addOrder()">结算</button>
        </div>
        
        <div class="th total">
          <p>应付：<span class="pieces-total">${cart.total}</span></p>
        </div>
      </div>
    
  <!-- 底部结束-->
    </div>
    
  </div>

<script type="text/javascript">
  layui.config({
    base: 'jq/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery','element','car'],function(){
    var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;
    
    
    car.init()


});
  
  function addOrder(){
	  
		location.href="Order.jsp";
	  }
</script>
</body>
</html>