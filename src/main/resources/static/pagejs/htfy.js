var dqys = 0;

//判断页数 zys：总页数  dqy：当前页
function pdyes(dqy,zys){
	var html='<div class="jsgrid-pager">';
	dqy = parseInt(dqy);
	zys = parseInt(zys);
	if(dqy==1||zys==0){
		html+='<span class="jsgrid-pager-nav-button jsgrid-pager-nav-inactive-button"><a href="javascript:void(0);" onclick="fanye(1)"><i class="fa fa-angle-double-left"></i></a></span>';
		html+='<span class="jsgrid-pager-nav-button jsgrid-pager-nav-inactive-button"><a href="javascript:void(0);" onclick="fanye('+((dqy-1)<1?1:(dqy-1))+')"><i class="fa fa-angle-left"></i></a></span>';
	}else{
		html+='<span class="jsgrid-pager-nav-button"><a href="javascript:void(0);" onclick="fanye(1)"><i class="fa fa-angle-double-left"></i></a></span>';
		html+='<span class="jsgrid-pager-nav-button"><a href="javascript:void(0);" onclick="fanye('+((dqy-1)<1?1:(dqy-1))+')"><i class="fa fa-angle-left"></i></a></span>';
	}
	
	if(zys>8){
		var ks = dqy>8?(dqy-7):1;//循环从第几个开始
		var wy = parseInt(ks)+7;//循环到第几个结束
		
		for(var i=ks;i<=wy;i++){
			if(i==dqy){
				html+=' <span class="jsgrid-pager-page jsgrid-pager-current-page">'+i+'</span>';
			}else{
				html+=' <span class="jsgrid-pager-page"><a href="javascript:void(0);" onclick="fanye('+i+')">'+i+'</a></span>';
			}
		}
		if(dqy<zys)html+=' <span class="jsgrid-pager-page"><a href="javascript:void(0);" onclick="fanye('+zys+')">'+zys+'</a></span>';
	}else{
		for(var i=1;i<=zys;i++){
			if(i==dqy){
				html+=' <span class="jsgrid-pager-page jsgrid-pager-current-page">'+i+'</span>';
			}else{
				html+=' <span class="jsgrid-pager-page"><a href="javascript:void(0);" onclick="fanye('+i+')">'+i+'</a></span>';
			}
		}
	}
	if(zys==1||zys==dqy||zys==0){
		html+='<span class="jsgrid-pager-nav-button jsgrid-pager-nav-inactive-button"><a href="javascript:void(0);" onclick="fanye('+((dqy+1)>zys?zys:(dqy+1))+')"><i class="fa fa-angle-right"></i></a></span>';
		html+=' <span class="jsgrid-pager-nav-button jsgrid-pager-nav-inactive-button"><a href="javascript:void(0);" onclick="fanye('+zys+')"><i class="fa fa-angle-double-right"></i></a></span>';
	}else{
		html+='<span class="jsgrid-pager-nav-button"><a href="javascript:void(0);" onclick="fanye('+((dqy+1)>zys?zys:(dqy+1))+')"><i class="fa fa-angle-right"></i></a></span>';
		html+=' <span class="jsgrid-pager-nav-button"><a href="javascript:void(0);" onclick="fanye('+zys+')"><i class="fa fa-angle-double-right"></i></a></span>';
	}
	html +='</div>';
	$(".page").html(html);
}

function getTime(timestamp, option){
	var date = new Date(timestamp)
	var year = date.getFullYear()
	var month = date.getMonth() + 1
	var day = date.getDate()
	var week = date.getDay()
	var hour = date.getHours()
	var minute = date.getMinutes()
	var second = date.getSeconds()

	//获取 年月日 时分
	if (option == 'YY-MM-DD hh-mm')  return [year, month, day].map(formatNumber).join('.') + ' ' + [hour, minute].map(formatNumber).join(':')

	//获取 年月日
	if (option == 'YY/MM/DD') return [year, month, day].map(formatNumber).join('/')
	if (option == 'YY-MM-DD') return [year, month, day].map(formatNumber).join('-')

	//获取 年月
	if (option == 'YY-MM') return [year, month].map(formatNumber).join('-')

	//获取 年
	if (option == 'YY') return [year].map(formatNumber).toString()

	//获取 月
	if (option == 'MM') return  [mont].map(formatNumber).toString()

	//获取 日
	if (option == 'DD') return [day].map(formatNumber).toString()

	//获取 年月日 周一 至 周日
	if (option == 'YY-MM-DD Week')  return [year, month, day].map(formatNumber).join('-') + ' ' + getWeek(week)

	//获取 月日 周一 至 周日
	if (option == 'MM-DD Week')  return [month, day].map(formatNumber).join('-') + ' ' + getWeek(week)

	//获取 周一 至 周日
	if (option == 'Week')  return getWeek(week)

	//获取 时分秒
	if (option == 'hh-mm-ss') return [hour, minute, second].map(formatNumber).join(':')

	//获取 时分
	if (option == 'hh-mm') return [hour, minute].map(formatNumber).join(':')

	//获取 分秒
	if (option == 'mm-dd') return [minute, second].map(formatNumber).join(':')

	//获取 时
	if (option == 'hh')  return [hour].map(formatNumber).toString()

	//获取 分
	if (option == 'mm')  return [minute].map(formatNumber).toString()

	//获取 秒
	if (option == 'ss') return [second].map(formatNumber).toString()

	//获取 年月日

	//默认 时分秒 年月日
	return [year, month, day].map(formatNumber).join('.') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n) {
	n = n.toString()
	return n[1] ? n : '0' + n
}

function getWeek(n) {
	switch (n) {
		case 1:
			return '星期一'
		case 2:
			return '星期二'
		case 3:
			return '星期三'
		case 4:
			return '星期四'
		case 5:
			return '星期五'
		case 6:
			return '星期六'
		case 7:
			return '星期日'
	}
}