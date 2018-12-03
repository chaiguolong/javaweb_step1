///税率计算方法
//是否显示差价选项
  function displayDiff()
  {
    //出让方性质为个人saleType[0] 1、普通住房HouseType[0] 0  不显示差价选项
    //出让方性质为个人saleType[0] 1、非普通住房HouseType[1] 1、购买不足5年enoughyears[1] 0 不显示差价选项
    if(document.all.saleType[0].checked)
    {
      if(document.all.HouseType[0].checked)
      {
      document.getElementById("divpricediff").style.display = 'none';
      return;
      }
      else if(document.all.HouseType[1].checked && document.all.enoughyears[1].checked)
    {
      document.getElementById("divpricediff").style.display = 'none';
      return;
    }
    }
    document.getElementById("divpricediff").style.display = 'block';
    return;
  }


//计算税费
function sfjs()
{
    if(document.all.sumprice.value==''){
      alert("请输入总房价！");
      document.all.sumprice.focus();
      return;
    }
    if(document.all.house_area.value==''){
      alert("请输入房屋建筑面积！");
      document.all.house_area.focus();
      return;
    }
    if(String(parseFloat(document.all.sumprice.value))=="NaN"){
      alert("总房价不正确！");
      document.all.sumprice.value="";
      document.all.sumprice.focus();
      return;
    }
    if(String(parseFloat(document.all.house_area.value))=="NaN"){
      alert("房屋建筑面积不正确！");
      document.all.house_area.value="";
      document.all.house_area.focus();
      return;
    }
    //总房价
    var sumprice = document.all.sumprice.value;
    //房屋建筑面积
    var house_area = document.all.house_area.value;
    //出让方交易契税
    var diff = sumprice * 560;
    if(document.getElementById("divpricediff").style.display == 'block')
    {
      if(document.all.pricediff.value==''){
        alert("请输入转让差价！");
        document.all.pricediff.focus();
        return;
      }
      if(String(parseFloat(document.all.pricediff.value))=="NaN"){
        alert("转让差价不正确！");
        document.all.pricediff.value="";
        document.all.pricediff.focus();
        return;
      }
      diff = document.all.pricediff.value * 560;
    }
    //交易手续费
    var scale = 6;
    //非普通住房HouseType[1] 1
    if(document.all.HouseType[1].checked )
    {
      scale = 12;
    }
    //承受方契税适用税率
    var buyScale = 0.03;
    //承受方性质为个人buyType[0] 1、普通住房HouseType[0] 0
    if(document.all.buyType[0].checked && document.all.HouseType[0].checked)
    {
        buyScale = 0.015;
    }

    document.getElementById("saleYHS").innerHTML = sumprice * 5;
    document.getElementById("buyYHS").innerHTML = sumprice * 5;

    document.getElementById("saleJY").innerHTML = house_area * scale * 0.5;
    document.getElementById("scale1").innerHTML = scale;
    document.getElementById("buyJY").innerHTML = house_area * scale * 0.5;
    document.getElementById("scale2").innerHTML = scale;
    document.getElementById("saleQS").innerHTML = sumprice * 10000 * buyScale;
    //出让方性质为个人saleType[0] 1、普通住房HouseType[0] 、购买超过5年enoughyears[1] 的免交
    if(document.all.saleType[0].checked && document.all.HouseType[0].checked
    && document.all.enoughyears[0].checked)
    {
       diff = 0;
    }
    document.getElementById("buyQS").innerHTML = diff;
    document.getElementById("total").innerHTML = 85+sumprice * 10+house_area * scale+sumprice * 10000 * buyScale+diff;
    document.getElementById("divResult").style.display = 'block';
}

function most(a,b,c){
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

	var loantotal=form1.loana.value*10000+form1.loanb.value*10000+form1.loanc.value*10000;
	document.all.loantotal.innerText=loantotal+"元";
	if(form1.loana.value!=0&&form1.year1.value!=''){
		loan_a=form1.loana.value*10000;
		year1=form1.year1.value;						// 商业按揭年数
		if(year1<6){
			rate_a=form1.rate1a.value/12;
		}
		else{
			rate_a=form1.rate2a.value/12;
		}
		month1=year1*12;
		monthpay1=Math.round((loan_a*rate_a/100)*Math.pow((1+rate_a/100),month1)/(Math.pow((1+rate_a/100),month1)-1)*100)/100;
	}

	if(form1.loanb.value!=0&&form1.year2.value!=''){
		loan_b=form1.loanb.value*10000;
		year2=form1.year2.value;						//公积金按揭年数
		if(year2<6){
			rate_b=form1.rate1b.value/12;
		}
		else{
			rate_b=form1.rate2b.value/12;
		}
		month2=year2*12;
		monthpay2=Math.round((loan_b*rate_b/100)*Math.pow((1+rate_b/100),month2)/(Math.pow((1+rate_b/100),month2)-1)*100)/100;
	}
	//判断是否为第二套
	if(form1.hn.value!=1){
	if(form1.loanc.value!=0&&form1.year3.value!=''){
		loan_c=form1.loanc.value*10000;
		year3=form1.year3.value;						//消费按揭年数，改商业
		if(year3<4){
			rate_c=form1.rate21c.value/12;
		}
		else if(year3>5){
			rate_c=form1.rate23c.value/12;
		}
		else{
			rate_c=form1.rate22c.value/12;
		}
		//alert (rate_c);
		month3=year3*12;
		monthpay3=Math.round((loan_c*rate_c/100)*Math.pow((1+rate_c/100),month3)/(Math.pow((1+rate_c/100),month3)-1)*100)/100;
	}
	}
	else{
		if(form1.loanc.value!=0&&form1.year3.value!=''){
		loan_c=form1.loanc.value*10000;
		year3=form1.year3.value;						//消费按揭年数，改商业
		if(year3>5)
		{rate_c=form1.rate4c.value/12;}
		else if(year3>3)
		{rate_c=form1.rate3c.value/12;}
		else if(year3>1)
		{rate_c=form1.rate2c.value/12;}
		else
		{rate_c=form1.rate1c.value/12;}
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
	document.all.returntotal.innerText=Math.round(returntotal)+"元";
	document.all.interesttotal.innerText=Math.round(returntotal-loantotal)+"元";

	var interest=0;		//当月归还利息
	var principal=0;	//当月归还本金
	var payday=new Date(form1.year.value,form1.month.value);
	var bgcolor='';
	var str='<table border="0" cellpadding="0" cellspacing="1" width="500" class="blackfont">';
	for(i=1;i<=month;i++){
		monthpay=0;
		interest=0;
		principal=0;
		if(form1.loana.value!=0&&form1.year1.value!=''&&i<=month1){
			interest+=loan_a*rate_a;
			monthpay+=monthpay1;
			principal+=monthpay1-loan_a*rate_a/100;
			loan_a=Math.round(loan_a*(100+rate_a)-monthpay1*100)/100;
		}
		else{
			loan_a=0;
		}

		if(form1.loanb.value!=0&&form1.year2.value!=''&&i<=month2){
			interest+=loan_b*rate_b;
			monthpay+=monthpay2;
			principal+=monthpay2-loan_b*rate_b/100;
			loan_b=Math.round(loan_b*(100+rate_b)-monthpay2*100)/100;
		}
		else{
			loan_b=0;
		}

		if(form1.loanc.value!=0&&form1.year3.value!=''&&i<=month3){
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
		str=str+'<tr'+bgcolor+'><td width="50">' +i+'</td><td width="80">' +payday.getYear()+'年'+(payday.getMonth()+1)+'月'+'</td><td width="100">';
        	str=str+FormatCur(loantotal)+'</td><td width="100">' +FormatCur(principal)+'</td><td width="70">' +FormatCur(interest)+'</td><td width="100">' +FormatCur(monthpay)+'</td></tr>';
		payday.setMonth(payday.getMonth()+1);
		loantotal=loan_a+loan_b+loan_c;
	}
	str=str+'</table>';
	window.document.all.result.innerHTML=str;
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

	var loantotal=form1.loana.value*10000+form1.loanb.value*10000+form1.loanc.value*10000;
	document.all.loantotal.innerText=loantotal+"元";
	if(form1.loana.value!=0&&form1.year1.value!=''){
		loan_a=form1.loana.value*10000;
		year1=form1.year1.value;						//按揭年数
		if(year1<6){
			rate_a=form1.rate1a.value/12;
		}
		else{
			rate_a=form1.rate2a.value/12;
		}
		month1=year1*12;
		principala=Math.round(loan_a/month1*100)/100;	//当月归还本金
	}

	if(form1.loanb.value!=0&&form1.year2.value!=''){
		loan_b=form1.loanb.value*10000;
		year2=form1.year2.value;						//按揭年数
		if(year2<6){
			rate_b=form1.rate1b.value/12;
		}
		else{
			rate_b=form1.rate2b.value/12;
		}
		month2=year2*12;
		principalb=Math.round(loan_b/month2*100)/100;	//当月归还本金
	}

    if(form1.hn.value!=1){
	if(form1.loanc.value!=0&&form1.year3.value!=''){
		loan_c=form1.loanc.value*10000;
		year3=form1.year3.value;						//按揭年数
		if(year3<4){
			rate_c=form1.rate21c.value/12;
		}
		else if(year3>5){
			rate_c=form1.rate23c.value/12;
		}
		else{
			rate_c=form1.rate22c.value/12;
		}
		month3=year3*12;
		principalc=Math.round(loan_c/month3*100)/100;	//当月归还本金
	}
   }
   else{
	    if(form1.loanc.value!=0&&form1.year3.value!=''){
		loan_c=form1.loanc.value*10000;
		year3=form1.year3.value;						//消费按揭年数，改商业
		if(year3>5)
		{rate_c=form1.rate4c.value/12;}
		else if(year3>3)
		{rate_c=form1.rate3c.value/12;}
		else if(year3>1)
		{rate_c=form1.rate2c.value/12;}
		else
		{rate_c=form1.rate1c.value/12;}
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
	var payday=new Date(form1.year.value,form1.month.value);
	var bgcolor='';
	var monthpay=0;
	var returntotal=0;
	var str='<table border="0" cellpadding="0" cellspacing="1" width="500" class="blackfont">';
	for(i=1;i<=month;i++){
		interest=0;
		principal=0;
		if(form1.loana.value!=0&&form1.year1.value!=''&&i<=month1){
			interest+=resta*rate_a
			principal+=principala;
			resta=Math.round(resta*100-principala*100)/100;
		}
		if(form1.loanb.value!=0&&form1.year2.value!=''&&i<=month2){
			interest+=restb*rate_b
			principal+=principalb;
			restb=Math.round(restb*100-principalb*100)/100;
		}
		if(form1.loanc.value!=0&&form1.year3.value!=''&&i<=month3){
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
		str=str+FormatCur(restloan)+'</td><td width="100">' +FormatCur(principal)+'</td><td width="70">' +FormatCur(interest)+'</td><td width="100">' +FormatCur(monthpay)+'</td></tr>';
		payday.setMonth(payday.getMonth()+1);
		restloan=restloan-principal;
	}
	str=str+'</table>';
	document.all.returntotal.innerText=Math.round(returntotal)+"元";
	document.all.interesttotal.innerText=Math.round(returntotal-loantotal)+"元";
	window.document.all.result.innerHTML=str;
}

function caculate(){
	if(form1.loana_input.value==''&&form1.loanb_input.value==''&&form1.loanc_input.value==''){
		alert("商业贷款或者公积金贷款或者消费贷款\n至少必须输入一项才能进行计算！");
		form1.loana_input.focus();
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
	if(form1.loanb_input.value!=''){
		if(String(parseFloat(form1.loanb_input.value))=="NaN"){
			alert("公积金贷款金额不正确！");
			form1.loanb_input.value="";
			form1.loanb_input.focus();
			return;
		}
		if(form1.year2.value!=''){
			if(String(parseFloat(form1.year2.value))=="NaN"){
				alert("公积金贷款年限不正确！");
				form1.year2.value="";
				form1.year2.focus();
				return;
			}
			if(parseFloat(form1.year2.value)>30){
				alert("公积金贷款年限不能超过30年！");
				form1.year2.value="";
				form1.year2.focus();
				return;
			}
		}
		else{
			alert("您还没有输入公积金贷款年限！");
			form1.year2.focus();
			return;
		}
		form1.loanb.value=form1.loanb_input.value;
	}
	else{
		form1.loanb.value=0;
		form1.year2.value='';
	}

	//消费贷款校验,改为商业贷款校验
	if(form1.loanc_input.value!=''){
		if(String(parseFloat(form1.loanc_input.value))=="NaN"){
			alert("商业贷款金额不正确！");
			form1.loanc_input.value="";
			form1.loanc_input.focus();
			return;
		}
		if(form1.year3.value!=''){
			if(String(parseFloat(form1.year3.value))=="NaN"){
				alert("商业贷款年限不正确！");
				form1.year3.value="";
				form1.year3.focus();
				return;
			}
			if(parseFloat(form1.year3.value)>30){
				alert("商业贷款年限不能超过30年！");
				form1.year3.value="";
				form1.year3.focus();
				return;
			}
		}
		else{
			alert("您还没有输入商业贷款年限！");
			form1.year3.focus();
			return;
		}
		form1.loanc.value=form1.loanc_input.value;
	}
	else{
		form1.loanc.value=0;
		form1.year3.value='';
	}

	if(form1.type.value==1)interest();
	else principal();
}


function caculate2(){
	//公积金贷款校验
	if(form1.loanb_input.value!=''){
		if(String(parseFloat(form1.loanb_input.value))=="NaN"){
			alert("公积金贷款金额不正确！");
			form1.loanb_input.value="";
			form1.loanb_input.focus();
			return;
		}
		form1.loanb.value=form1.loanb_input.value;
	}
	else{
		alert("您还没有输入公积金贷款金额！");
		form1.loanb_input.focus();
		return;
	}
	if(form1.year2.value!=''){
		if(String(parseFloat(form1.year2.value))=="NaN"){
			alert("公积金贷款年限不正确！");
			form1.year2.value="";
			form1.year2.focus();
			return;
		}
		if(parseFloat(form1.year2.value)>30){
			alert("公积金贷款年限不能超过30年！");
			form1.year2.value="";
			form1.year2.focus();
			return;
		}
	}
	else{
		alert("您还没有输入公积金贷款年限！");
		form1.year2.focus();
		return;
	}

	form1.loana.value=0;
	form1.loanc.value=0;
	if(form1.type.value==1)interest();
	else principal();
}

function caculate3(){
	//消费贷款校验,更改商业贷款检测
	if(form1.loanc_input.value!=''){
		if(String(parseFloat(form1.loanc_input.value))=="NaN"){
			alert("商业贷款金额不正确！");
			form1.loanc_input.value="";
			form1.loanc_input.focus();
			return;
		}
		form1.loanc.value=form1.loanc_input.value;
	}
	else{
		alert("您还没有输入商业贷款金额！");
		form1.loanc_input.focus();
		return;
	}
	if(form1.year3.value!=''){
		if(String(parseFloat(form1.year3.value))=="NaN"){
			alert("商业贷款年限不正确！");
			form1.year3.value="";
			form1.year3.focus();
			return;
		}
		if(parseFloat(form1.year3.value)>30){
			alert("商业贷款年限不能超过30年！");
			form1.year3.value="";
			form1.year3.focus();
			return;
		}
	}
	else{
		alert("您还没有输入商业贷款年限！");
		form1.year3.focus();
		return;
	}

	form1.loana.value=0;
	form1.loanb.value=0;
	if(form1.type.value==1)interest();
	else principal();
}

function recaculate(){
	form1.reset();
	document.all.loantotal.innerText="";
	document.all.returntotal.innerText="";
	document.all.interesttotal.innerText="";
	document.all.result.innerHTML="";
}