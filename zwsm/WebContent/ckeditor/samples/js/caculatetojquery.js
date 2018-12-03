///税率计算方法
//是否显示差价选项
function displayDiff(){
	//出让方性质为个人saleType[0] val= 1 1、普通住房     HouseType[0] val= 0   不显示差价选项
    //出让方性质为个人saleType[0] val= 1 1、非普通住房HouseType[0] val= 1   购买不足5年enoughyear[1] val= 0  不显示差价选项
    if($('input:radio[name="saleType"]:checked').val() == 1)
    {
      if($('input:radio[name="HouseType"]:checked').val() == 0)
      {
      $('#divpricediff').css("display","none")
      return;
      }
      if(($('input:radio[name="HouseType"]:checked').val() == 1) && (($('input:radio[name="enoughyears"]:checked').val() == 0)))
      {
      $('#divpricediff').css("display","none")
      return;
      }
    }
    $('#divpricediff').css("display","block")
    return;
}
	
//计算税费
function sfjs()
{
    if($('input[name="sumprice"]').val() == ''){
      alert("请输入总房价！");
      $('input[name="sumprice"]').focus();
      return;
    }
    if($('input[name="house_area"]').val() == ''){
      alert("请输入房屋建筑面积！");
      $('input[name="house_area"]').focus();
      return;
    }
    if(String(parseFloat($('input[name="sumprice"]').val()))=="NaN"){
      alert("总房价不正确！");
      $('input[name="sumprice"]').val('');
      $('input[name="sumprice"]').focus();
      return;
    }
    if(String(parseFloat($('input[name="house_area"]').val()))=="NaN"){
      alert("房屋建筑面积不正确！");
      $('input[name="house_area"]').val('');
      $('input[name="house_area"]').focus();
      return;
    }
    //总房价
    var sumprice = $('input[name="sumprice"]').val();
    //房屋建筑面积
    var house_area = $('input[name="house_area"]').val();
    //出让方交易契税
    var diff = sumprice * 560;
    
    if($('#divpricediff').css("display")=="block")
    {
      if($('input[name="pricediff"]').val() == ''){
        alert("请输入转让差价！");
        $('input[name="pricediff"]').focus();
        return;
      }
      if(String(parseFloat($('input[name="pricediff"]').val()))=="NaN"){
        alert("转让差价不正确！");
        $('input[name="pricediff"]').val('');
        $('input[name="pricediff"]').focus();
        return;
      }
      diff = $('input[name="pricediff"]').val() * 560;
    }
    
    //交易手续费
    var scale = 6;
    //非普通住房HouseType val==1
    if(($('input:radio[name="HouseType"]:checked').val() == 1))
    {
      scale = 12;
    }
    //承受方契税适用税率
    var buyScale = 0.03;
    //承受方性质为个人buyType[0] val==1 1、普通住房HouseType[0] val==0
    if(($('input:radio[name="buyType"]:checked').val() == 1) && ($('input:radio[name="HouseType"]:checked').val() == 0))
    {
        buyScale = 0.015;
    }
    
    $('#saleYHS').html(sumprice * 5);
    $('#buyYHS').html(sumprice * 5);
    $('#saleJY').html(house_area * scale * 0.5);
    $('#scale1').html(scale);
    $('#buyJY').html(house_area * scale * 0.5);
    $('#scale2').html(sumprice);
    $('#saleQS').html(sumprice * 10000 * buyScale);
    //出让方性质为个人saleType[0] 1、普通住房HouseType[0] 、购买超过5年enoughyears[1] 的免交
    if(($('input:radio[name="saleType"]:checked').val() == 1) && ($('input:radio[name="HouseType"]:checked').val() == 0)&& ($('input:radio[name="enoughyears"]:checked').val() == 1))
    {
       diff = 0;
    }
    $('#buyQS').html(diff);
    $('#total').html(85+sumprice * 10+house_area * scale+sumprice * 10000 * buyScale+diff);
    $('#divResult').attr("style","display:block"); 
}

function most(a,b,c)
{
	var result=a;
	if(b>result)result=b;
	if(c>result)result=c;
	return result;
}
	
function interest(){
	//等额本息法
	//月还款总额
	var loan_a=0;
	var loan_b=0;
	var loan_c=0;
	var year1;						//按揭年数
	var year2;						//公积金贷款年数
	var year3;						//消费贷款年数
	var rate_a=0;										//按揭利息
	var rate_b=0;										//公积金利息
	var rate_c=0;										//消费贷款利息
	var month1=0;
	var monthpay1=0;
	var month2=0;
	var monthpay2=0;
	var month3=0;
	var monthpay3=0;
	

	var loantotal= $('input[name="loana"]').val()*10000 + $('input[name="loanb"]').val()*10000 + $('input[name="loanc"]').val()*10000;
	$('#loantotal').text(loantotal+"元");
	if(($('input[name="loana"]').val() != 0)&&($('input[name="year1"]').val() != '')){
		loan_a=$('input[name="loana"]').val()*10000;
		year1=$('input[name="year1"]').val();						// 商业按揭年数
		if(year1<6){
			rate_a=$('input[name="rate1a"]').val()/12;
		}
		else{
			rate_a=$('input[name="rate2a"]').val()/12;
		}
		month1=year1*12;
		monthpay1=Math.round((loan_a*rate_a/100)*Math.pow((1+rate_a/100),month1)/(Math.pow((1+rate_a/100),month1)-1)*100)/100;
	}

	if(($('input[name="loanb"]').val() != 0)&&($('input[name="year2"]').val() != '')){
		loan_b=$('input[name="loanb"]').val()*10000;
		year2=$('input[name="year2"]').val();						//公积金按揭年数
		if(year2<6){
			rate_b=$('input[name="rate1b"]').val()/12;
		}
		else{
			rate_b=$('input[name="rate1b"]').val()/12;
		}
		month2=year2*12;
		monthpay2=Math.round((loan_b*rate_b/100)*Math.pow((1+rate_b/100),month2)/(Math.pow((1+rate_b/100),month2)-1)*100)/100;
	}
	//判断是否为第二套
	if($('select[name="hn"]:checked').val()!=1){
		if(($('input[name="loanc"]').val() != 0)&&($('input[name="year3"]').val() != '')){
			loan_c=$('input[name="loanc"]').val()*10000;
			year3=$('input[name="year3"]').val();						//消费按揭年数，改商业
			if(year3<4){
				rate_c=$('input[name="rate21c"]').val()/12;
			}
			else if(year3>5){
				rate_c=$('input[name="rate23c"]').val()/12;
			}
			else{
				rate_c=$('input[name="rate22c"]').val()/12;
			}
			//alert (rate_c);
			month3=year3*12;
			monthpay3=Math.round((loan_c*rate_c/100)*Math.pow((1+rate_c/100),month3)/(Math.pow((1+rate_c/100),month3)-1)*100)/100;
		}
	}
	else{
		if(($('input[name="loanc"]').val() != 0)&&($('input[name="year3"]').val() != '')){
			loan_c=$('input[name="loanc"]').val()*10000;
			year3=$('input[name="year3"]').val();					//消费按揭年数，改商业
				if(year3>5){
					rate_c=$('input[name="rate4c"]').val()/12;
				}
				else if(year3>3){
					rate_c=$('input[name="rate3c"]').val()/12;
				}
				else if(year3>1){
					rate_c=$('input[name="rate2c"]').val()/12;
				}
				else{
					rate_c=$('input[name="rate1c"]').val()/12;
				}
				//if(year3=1)
				//{rate_c=form1.rate1c.value/12;}
				//alert(year3);
				//alert (rate_c);
			month3=year3*12;
			monthpay3=Math.round((loan_c*rate_c/100)*Math.pow((1+rate_c/100),month3)/(Math.pow((1+rate_c/100),month3)-1)*100)/100;
		}
    }
	var month=most(month1,month2,month3);
	var monthpay=0;
	var returntotal=monthpay1*month1+monthpay2*month2+monthpay3*month3;
	$('#returntotal').text(Math.round(returntotal)+"元");
	$('#interesttotal').text(Math.round(returntotal-loantotal)+"元");

	var interest=0;		//当月归还利息
	var principal=0;	//当月归还本金
	var payday=new Date($('select[name="year"]').val(),$('select[name="month"]').val());
	var bgcolor='';
	var str='<table border="0" cellpadding="0" cellspacing="1" width="500" class="blackfont">';
	for(i=1;i<=month;i++){
		monthpay=0;
		interest=0;
		principal=0;
		if(($('input[name="loana"]').val() !=0 )&&($('input[name="year1"]').val()!='')&&(i<=month1)){
			interest+=loan_a*rate_a;
			monthpay+=monthpay1;
			principal+=monthpay1-loan_a*rate_a/100;
			loan_a=Math.round(loan_a*(100+rate_a)-monthpay1*100)/100;
		}
		else{
			loan_a=0;
		}

		if(($('input[name="loanb"]').val() !=0 )&&($('input[name="year2"]').val()!='')&&(i<=month2)){
			interest+=loan_b*rate_b;
			monthpay+=monthpay2;
			principal+=monthpay2-loan_b*rate_b/100;
			loan_b=Math.round(loan_b*(100+rate_b)-monthpay2*100)/100;
		}
		else{
			loan_b=0;
		}

		if(($('input[name="loanc"]').val() !=0 )&&($('input[name="year3"]').val()!='')&&(i<=month3)){
			interest+=loan_c*rate_c;
			monthpay+=monthpay3;
			principal+=monthpay3-loan_c*rate_c/100;
			loan_c=Math.round(loan_c*(100+rate_c)-monthpay3*100)/100;
		}
		else{
			loan_c=0;
		}

		interest=Math.round(interest)/100;
		principal=Math.round(principal*100)/100;
		if(i%2==0)bgcolor=' bgcolor="#CCCCCC"';
		else bgcolor='';
		str=str+'<tr'+bgcolor+'><td width="50">' +i+'</td><td width="80">' +payday.getYear()+'年'+(payday.getMonth()+1)+'月'+'</td><td width="100" class="aaa">';
        	str=str+'￥'+FormatCur(loantotal)+'</td><td width="100">' +'￥'+FormatCur(principal)+'</td><td width="70">' +'￥'+FormatCur(interest)+'</td><td width="100">' +'￥'+FormatCur(monthpay)+'</td></tr>';
		payday.setMonth(payday.getMonth()+1);
		loantotal=loan_a+loan_b+loan_c;
	}
	str=str+'</table>';
	$('#result').html('');
	$('#result').html(str);
}

function principal(){
	//等额本金法
	//月还款总额
	var loan_a=0;
	var loan_b=0;
	var loan_c=0;
	var year1;						//按揭年数
	var year2;						//公积金贷款年数
	var year3;						//消费贷款年数
	var rate_a=0;										//按揭利息
	var rate_b=0;										//公积金利息
	var rate_c=0;										//消费贷款利息
	var month1=0;
	var monthpay1=0;
	var month2=0;
	var monthpay2=0;
	var month3=0;
	var monthpay3=0;
	var principala;
	var principalb;
	var principalc;
	
	var loantotal= $('input[name="loana"]').val()*10000 + $('input[name="loanb"]').val()*10000 + $('input[name="loanc"]').val()*10000;
	$('#loantotal').text(loantotal+"元");	
	
	if(($('input[name="loana"]').val() != 0)&&($('input[name="year1"]').val() != '')){
		loan_a=$('input[name="loana"]').val()*10000;
		year1=$('input[name="year1"]').val();						// 商业按揭年数
		if(year1<6){
			rate_a=$('input[name="rate1a"]').val()/12;
		}
		else{
			rate_a=$('input[name="rate2a"]').val()/12;
		}
		month1=year1*12;
		principala=Math.round(loan_a/month1*100)/100;	//当月归还本金
	}
	
	if(($('input[name="loanb"]').val() != 0)&&($('input[name="year2"]').val() != '')){
		loan_b=$('input[name="loanb"]').val()*10000;
		year2=$('input[name="year2"]').val();						//公积金按揭年数
		if(year2<6){
			rate_b=$('input[name="rate1b"]').val()/12;
		}
		else{
			rate_b=$('input[name="rate1b"]').val()/12;
		}
		month2=year2*12;
		principalb=Math.round(loan_b/month2*100)/100;	//当月归还本金
	}
	
	if($('select[name="hn"]:checked').val()!=1){
		if(($('input[name="loanc"]').val() != 0)&&($('input[name="year3"]').val() != '')){
			loan_c=$('input[name="loanc"]').val()*10000;
			year3=$('input[name="year3"]').val();						//消费按揭年数，改商业
			if(year3<4){
				rate_c=$('input[name="rate21c"]').val()/12;
			}
			else if(year3>5){
				rate_c=$('input[name="rate23c"]').val()/12;
			}
			else{
				rate_c=$('input[name="rate22c"]').val()/12;
			}
			//alert (rate_c);
			month3=year3*12;
			principalc=Math.round(loan_c/month3*100)/100;	//当月归还本金
		}
	}
	else{
		if(($('input[name="loanc"]').val() != 0)&&($('input[name="year3"]').val() != '')){
		loan_c=$('input[name="loanc"]').val()*10000;	
		year3=$('input[name="year3"]').val();					//消费按揭年数，改商业
		if(year3>5)
		{rate_c=$('input[name="rate4c"]').val()/12;}
		else if(year3>3)
		{rate_c=$('input[name="rate3c"]').val()/12;}
		else if(year3>1)
		{rate_c=$('input[name="rate2c"]').val()/12;}
		else
		{rate_c=$('input[name="rate1c"]').val()/12;}
		//if(year3=1)
		//{rate_c=form1.rate1c.value/12;}
		//alert(year3);
		//alert (rate_c);
		month3=year3*12;
		principalc=Math.round(loan_c/month3*100)/100;	//当月归还本金
		}
    }
	
	var month=most(month1,month2,month3);
	var principal=0;
	var restloan=loantotal;
	var resta=loan_a;
	var restb=loan_b;
	var restc=loan_c;
	var interest=0;		//当月归还利息
	var payday=new Date($('select[name="year"]').val(),$('select[name="month"]').val());
	var bgcolor='';
	var monthpay=0;
	var returntotal=0;
	var str='<table border="0" cellpadding="0" cellspacing="1" width="500" class="blackfont">';
	for(i=1;i<=month;i++){
		interest=0;
		principal=0;
		if(($('input[name="loana"]').val() !=0 )&&($('input[name="year1"]').val()!='')&&(i<=month1)){
			interest+=resta*rate_a
			principal+=principala;
			resta=Math.round(resta*100-principala*100)/100;
		}
		if(($('input[name="loanb"]').val() !=0 )&&($('input[name="year2"]').val()!='')&&(i<=month2)){
			interest+=restb*rate_b
			principal+=principalb;
			restb=Math.round(restb*100-principalb*100)/100;
		}
		if(($('input[name="loanc"]').val() !=0 )&&($('input[name="year3"]').val()!='')&&(i<=month3)){
			interest+=restc*rate_c
			principal+=principalc;
			restc=Math.round(restc*100-principalc*100)/100;
		}
		interest=Math.round(interest)/100;
		monthpay=principal+interest;
		returntotal=returntotal+monthpay;
		if(i%2==0)bgcolor=' bgcolor="#CCCCCC"';
		else bgcolor='';
		str=str+'<tr'+bgcolor+'><td width="50">' +i+'</td><td width="80">' +payday.getYear()+'年'+(payday.getMonth()+1)+'月'+'</td><td width="100">';
		str=str+'￥'+FormatCur(restloan)+'</td><td width="100">' +'￥'+FormatCur(principal)+'</td><td width="70">' +'￥'+FormatCur(interest)+'</td><td width="100">' +'￥'+FormatCur(monthpay)+'</td></tr>';
		payday.setMonth(payday.getMonth()+1);
		restloan=restloan-principal;
	}
	str=str+'</table>';
	$('#returntotal').text(Math.round(returntotal)+"元");
	$('#interesttotal').text(Math.round(returntotal-loantotal)+"元");
	$('#result').html('');
	$('#result').html(str);
	
}
function caculate(){
	if(($('#loana_input').val()=='')&&($('#loanb_input').val()=='')&&($('#loanc_input').val()=='')){
		alert("商业贷款或者公积金贷款或者消费贷款\n至少必须输入一项才能进行计算！");
		$('input[name="loana_input"]').focus();
		return;
	}

	//商业贷款校验
	/*
	if(form1.loana_input.value!=''){
		if(String(parseFloat(form1.loana_input.value))=="NaN"){
			alert("商业贷款金额不正确！");
			form1.loana_input.value="";
			form1.loana_input.focus();
			return;
		}
		if(form1.year1.value!=''){
			if(String(parseFloat(form1.year1.value))=="NaN"){
				alert("商业贷款年限不正确！");
				form1.year1.value="";
				form1.year1.focus();
				return;
			}
			if(parseFloat(form1.year1.value)>30){
				alert("商业贷款年限不能超过30年！");
				form1.year1.value="";
				form1.year1.focus();
				return;
			}
		}
		else{
			alert("您还没有输入商业贷款年限！");
			form1.year1.focus();
			return;
		}
		form1.loana.value=form1.loana_input.value;
	}
	else{
		form1.loana.value=0;
		form1.year1.value='';
	}
    */
	//公积金贷款校验
	if($('#loanb_input').val()!=''){
		if(String(parseFloat($('#loanb_input').val()))=="NaN"){
			alert("公积金贷款金额不正确！");
			$('#loanb_input').val('');
			$('#loanb_input').focus();
			return;
		}
		if($('#year2').val()!=''){
			if(String(parseFloat($('#year2').val()))=="NaN"){
				alert("公积金贷款年限不正确！");
				$('#year2').val('');
				$('#year2').focus();
				return;
			}
			if(parseFloat($('#year2').val())>30){
				alert("公积金贷款年限不能超过30年！");
				$('#year2').val('');
				$('#year2').focus();
				return;
			}
		}
		else{
			alert("您还没有输入公积金贷款年限！");
			$('#year2').focus();
			return;
		}
		$('input[name="loanb"]').val($('#loanb_input').val());
	}
	else{
		$('input[name="loanb"]').val(0);
		$('#year2').val('');
	}

	//消费贷款校验,改为商业贷款校验
	if($('#loanc_input').val()!=''){
		if(String(parseFloat($('#loanc_input').val()))=="NaN"){
			alert("商业贷款金额不正确！");
			$('#loanc_input').val('');
			$('#loanc_input').focus();
			return;
		}
		if($('#year3').val()!=''){
			if(String(parseFloat($('#year3').val()))=="NaN"){
				alert("商业贷款年限不正确！");
				$('#year3').val('');
				$('#year3').focus();
				return;
			}
			if(parseFloat($('#year3').val())>30){
				alert("商业贷款年限不能超过30年！");
				$('#year3').val('');
				$('#year3').focus();
				return;
			}
		}
		else{
			alert("您还没有输入商业贷款年限！");
			$('#year3').focus();
			return;
		}
		$('input[name="loanc"]').val($('#loanc_input').val());
	}
	else{
		$('input[name="loanc"]').val(0);
		$('#year3').val('');
	}
	if($('#select7').val()==1){
		interest();
	}
	else principal();
}

function caculate2(){
	//公积金贷款校验
	if($('#loanb_input').val() != ''){
		if(String(parseFloat($('#loanb_input').val()))=="NaN"){
			alert("公积金贷款金额不正确！");
			$('#loanb_input').val('');
			$('#loanb_input').focus();
			return;
		}
		$('input[name="loanb"]').val($('#loanb_input').val());
	}
	else{
		alert("您还没有输入公积金贷款金额！");
		$('#loanb_input').focus();
		return;
	}
	if($('#year2').val()!=''){
		if(String(parseFloat($('#year2').val()))=="NaN"){
			alert("公积金贷款年限不正确！");
			$('#year2').val('');
			$('#year2').focus();
			return;
		}
		if(parseFloat($('#year2').val())>30){
			alert("公积金贷款年限不能超过30年！");
			$('#year2').val('');
			$('#year2').focus();
			return;
		}
	}
	else{
		alert("您还没有输入公积金贷款年限！");
		$('#year2').focus();
		return;
	}
	$('input[name="loana"]').val(0);
	$('input[name="loanc"]').val(0);
	if($('#select7').val()==1){
		interest();
	}
	else principal();
}

function caculate3(){
	//消费贷款校验,更改商业贷款检测
	if($('#loanc_input').val()!=''){
		if(String(parseFloat($('#loanc_input').val()))=="NaN"){
			alert("商业贷款金额不正确！");
			$('#loanc_input').val('');
			$('#loanc_input').focus();
			return;
		}
		$('input[name="loanc"]').val($('#loanc_input').val());
	}
	else{
		alert("您还没有输入商业贷款金额！");
		$('#loanc_input').focus();
		return;
	}
	if($('#year3').val()!=''){
		if(String(parseFloat($('#year3').val()))=="NaN"){
			alert("商业贷款年限不正确！");
			$('#year3').val('');
			$('#year3').focus();
			return;
		}
		if(parseFloat($('#year3').val())>30){
			alert("商业贷款年限不能超过30年！");
			$('#year3').val('');
			$('#year3').focus();
			return;
		}
	}
	else{
		alert("您还没有输入商业贷款年限！");
		$('#year3').focus();
		return;
	}
	
	$('input[name="loana"]').val(0);
	$('input[name="loanb"]').val(0);
	if($('#select7').val()==1){
		interest();
	}
	else principal();
}

function recaculate(){
	$('#form1')[0].reset();
	$('#loantotal').text('');
	$('#returntotal').text('');
	$('#interesttotal').text('');
	$('#result').html('');
}                                                                           






