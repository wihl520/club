/*
 	购物车功能：
 	
 		* 加数量
 		* 减数量
 		* 删除当行
 		* 小计
 		* 全选
 		* 总价和总数量
 		* 删除多个
 		* 手动输入改变价格
 */

//1、加数量

$('#cart').on('click','.addnum',function(){
	//给每一个加号绑定事件(用事件委托的方式绑定)
	var val=$(this).prev().val();
	val++;//隐式转换
//	console.log(val);
	if(val>=100){
		//库存量是100.限制最大值
		val=100;
	}
	//设置内容
	$(this).prev().val(val);
	//小计
	price($(this));//把点击当前节点当成实参传过去
	var arr=checked();//判断哪行被选中，存到该数组中
	allnum(arr);//传被选中的行的下标过去，那边做累计处理
	
	//总价
	allprice(arr);
});


//2、减数量
$('#cart').on('click','.cutnum',function(){
	//给每一个加号绑定事件(用事件委托的方式绑定)
	var val=$(this).next().val();
	val--;//隐式转换
//	console.log(val);
	if(val<=1){
		//库存量是100.限制最大值
		val=1;
	}
	//设置内容
	$(this).next().val(val);
	//小计
	price($(this));//把点击当前节点当成实参传过去
	var arr=checked();//判断哪行被选中，存到该数组中
	allnum(arr);//传被选中的行的下标过去，那边做累计处理
	
	//总价
	allprice(arr);
});


//3、小计

function price(now){
	var pri=now.parent().prev().text();//拿到对应行的单价，￥ 99.99
//	console.log(pri);
	pri=$.trim(pri);//去掉前后空格
	pri=pri.substring(2);//字符串截取，￥&nbsp;65.99  单价处理好了
//	console.log(pri);
	
	//获取数量
	var all=now.parent().find('input').val();
//	console.log(all);
	var aprice=pri*all;//小计
	now.parent().next().html('￥&nbsp;'+aprice.toFixed(2));//赋值小计,.toFixed(2)保留两个小数
}


//4、删除当行

$('#cart').on('click','.good_del',function(){
	var res=confirm('您确定要删除该商品吗？');
	if(res){
		$(this).parent().remove();
	}
	updata();
	var arr=checked();//判断哪行被选中，存到该数组中
	allnum(arr);//传被选中的行的下标过去，那边做累计处理
	
	//总价
	allprice(arr);
});


//刷新

function updata(){
	if($('.addnum').size()==0){
		$('#del').remove();
	}
}

//全选

var isCheacked=true;

$('#allchecked').on('click',function(){
	
	//attr()加普通属性      title    prop() 加有行为的属性
	if(isCheacked){
		//全选
		$('.good_check input').prop('checked','checked');
		$('#allchecked input').prop('checked','checked');
	}else{
		//不选
		$('.good_check input').removeAttr('checked');
		$('#allchecked input').removeAttr('checked');
	}
	isCheacked=!isCheacked;
	
	//点击全选的时候，数量和总价跟着变
	//总数量
	var arr=checked();//判断哪行被选中，存到该数组中
	allnum(arr);//传被选中的行的下标过去，那边做累计处理
	
	//总价
	allprice(arr);
});

//删除多行

$('#delall').on('click',function(){
	var arr=checked();//被选中的行
	console.log(arr);
	var res=confirm('您确定要删除多行吗？');
	if(res){
		//删除arr下标对应的行
		for(var i=arr.length-1;i>=0;i--){
			//从后面开始删除
			$('.good_check').eq(arr[i]).parent().remove();
		}
	}
	
	updata();
});

//循环判断哪行被选中了

function checked(){
	var arr=[];//设置一个空数组，等会被选中的就把下标存起来
	var le=$('.good_check input').size();
	for(var i=0;i<le;i++){
		if($('.good_check input').eq(i).prop('checked')){
			//不为空证明被选中了
			arr.push(i);
		}
	}
	return arr;
}


//总数量

function allnum(arr){
	var num=0;//总数量
	for(var i=0;i<arr.length;i++){
		num+=parseInt($('.nownum').eq(arr[i]).val());
	}
	
	$('#allnum').html('已选 '+num+' 件商品');
}

//总价

function allprice(arr){
	var price=0;
	for(var i=0;i<arr.length;i++){
		var nowtotal=$('.good_total').eq(arr[i]).text();
		nowtotal=$.trim(nowtotal);
		console.log(nowtotal);
		nowtotal=nowtotal.substring(2);//数据提取完成  255
		console.log(nowtotal);
		price+=nowtotal*1;
	}
	
	$('#totalprice').html('总计（不含运费）：￥'+price.toFixed(2));
}


//单行选中

$('#cart').on('click','.good_check',function(){
	var arr=checked();
	if(arr.length==$('.good_check').size()){
		//都被选中了
		$('#allchecked input').prop('checked','checked');
	}
	else{
		$('#allchecked input').removeAttr('checked');
	}
	var arr=checked();//判断哪行被选中，存到该数组中
	allnum(arr);//传被选中的行的下标过去，那边做累计处理
	
	//总价
	allprice(arr);
});

//手动输入改变总价

$('#cart').on('blur','.nownum',function(){
	price($(this));
	var arr=checked();//判断哪行被选中，存到该数组中
	allnum(arr);//传被选中的行的下标过去，那边做累计处理
	
	//总价
	allprice(arr);
});
