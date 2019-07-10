<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>订单</title>
  <link rel="stylesheet" type="text/css" href="jq/res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="jq/res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7/css/bootstrap.min.css"/>
  <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
  <script type="text/javascript" src="jq/res/layui/layui.js"></script>
  <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>
  
  
   
 <!-- 购物车 开始-->
  <div class="content content-nav-base shopcart-content">
  
    
   
   <div class="cart w1200">
      <!--地址-->
        <form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">收货人姓名：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" 
						   placeholder="请输入姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">收货人电话：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="telephone" 
						   placeholder="请输入手机号">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">收货地址：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="address" 
						   placeholder="请输入地址">
				</div>
			</div>
	
		</form>
     
     
     
      <!-- 头部 开始-->
      <div class="cart-table-th">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="allCheckked" value="">
            </div>
            
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
                 
                </div>
              </div>
            </li>
         
            <li class="th th-item">
              <div class="item-cont">
                <a href="javascript:;"><img src="dbimgs/${entry.value.product.kind}/${entry.value.product.pimage}"></a>
                <div class="text">
                  <div class="title">${entry.value.product.pname}${entry.value.product.content}</div>
                  
                </div>
              </div>
            </li>
            
            <li class="th th-price">
              <span class="th-su">${entry.value.product.price}</span>
            </li>
            
            <li class="th th-amount">
              <div class="box-btn layui-clear">
                
                <input class="Quantity-input" type="" name="" value="${entry.value.buyNum }" disabled="disabled">
                
              </div>
            </li>
            
            <li class="th th-sum">
              <span class="sum">${entry.value.subtotal }</span>
            </li>
            
            
          </ul>
         </c:forEach>
        </div>
      </div>
   <!-- 主体结束-->
    
   
    <!-- 底部开始 -->
     
      <div class="FloatBarHolder layui-clear">
        
        
        
        
        <div class="th Settlement">
          <a href="javascript:void(0)">
           <button class="layui-btn" onclick="SubmitOrder()">提交订单</button>
          </a>
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
  function SubmitOrder(){
	   var buyname= $("#name").val();
	   var telephone=$("#telephone").val();
	   var address=$("#address").val();
	  
	    
	  
		location.href="product?method=submitOrder&buyname="+buyname+"&telephone="+telephone+"&address="+address;
	
	  }
</script>
</body>
</html>