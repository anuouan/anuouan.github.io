// 获取页面中需要操作的HTML元素
var containerDiv = document.getElementById("container");
var fractionDiv = document.getElementById("fraction");
var timeDiv = document.getElementById("time");
var startMenuDiv = document.getElementById("startMenu");
var overMenuDiv = document.getElementById("overMenu");
var reloadMenuDiv = document.getElementById("reloadMenu");

var startBtn = document.getElementById("start");
var overBtn = document.getElementById("over");
var reloadBtn = document.getElementById("reload");

//1.点击开始按钮，隐藏按钮，并开始计时
startBtn.onclick = function(){
	//a.隐藏开始按钮（就是隐藏开始按钮所在的div）
	startMenuDiv.style.display = "none";
	
	//b.开始记时（时间进度条逐渐变短  默认宽度  180px,假设游戏时间1min,每秒减少3像素）
	var timeDivWidth = 180;
	var px = timeDivWidth/(60);  //使用进度条宽度除于游戏时间  （每 0.1s 减少 0.3像素）
	
	//每0.1s将时间进度条的宽度减少0.3像素
	var timeTask = setInterval(function(){
		//计算
		timeDivWidth = timeDivWidth - px;
		//将计算后的宽度设置给时间进度条DIV
		timeDiv.style.width = timeDivWidth+"px";
		if(timeDivWidth<=0){
			//表示游戏时间结束: 停止计时
			clearInterval(timeTask);
			//停止显示狼的循环任务
			clearInterval(showWolfsTask);
			//显示 游戏结束 和 重新开始 按钮
			overMenuDiv.style.display = "block";
			reloadMenuDiv.style.display = "block";
		}
	},100);
	
	//c.显示狼群(使用循环任务)
	wolfsGoGoGo();
}

//显示图片的洞口的坐标
var arrPos = [["98px","115px"],["17px","160px"],["15px","221px"],["30px","294px"],
["122px","274px"],["207px","296px"],["200px","212px"],["187px","142px"],["100px","192px"]];

//记录游戏分数
var score = 0; 
var showWolfsTask;

function wolfsGoGoGo(){
	showOneWolf();
	showWolfsTask = setInterval("showOneWolf()",1000);
}

function showOneWolf(){
	//1. 创建一个img标签
	var img = document.createElement("img");
	//将img标签添加为containerDiv的子标签
	containerDiv.appendChild(img);
	
	//2. 将img显示到洞口位置(随机显示到某个洞口：列出9个洞口的坐标，随机选择一个)
	var index = Math.floor( Math.random()*arrPos.length );  // 0-8
	img.style.position = "absolute";
	img.style.left = arrPos[index][0];
	img.style.top = arrPos[index][1];
	
	//3.随机产生一只狼，设置到img标签的src属性
	// 算法：产生一个0、1、2随机数,如果能被2整除则显示大灰狼，否则显示小灰灰
	var wolfIndex = Math.floor( Math.random()*3 );
	var wolfName = wolfIndex%2==0?"h":"x";
	
	
	//4.让狼有一个上升的过程 （h0---h5,  x0--x5）
	//显示图片
	var i = -1;
	var task = null; // task表示狼完全显示以后的等待任务
	var hideImgTask = null; //hideImgTask表示狼下降的循环任务
	var showImgTask = setInterval(function(){
		i++;
		img.src = "imgs/"+wolfName+i+".png";
		if(i == 5){
			//狼已经完全显示
			clearInterval(showImgTask);
			//隐藏图片 ： 等待一定的时间（500ms），如果没有对狼进行点击，则狼要消失
			var task = setTimeout(function(){
				//狼要消失（就是将图片移出,但是在移出之前需要有狼躲进洞的效果）
				var hideImgTask = setInterval(function(){
					i--;
					img.src = "imgs/"+wolfName+i+".png";
					if(i<=0){
						clearInterval(hideImgTask);
						img.remove();
					}
				},50);
			},500);
		}
	},50);
	
	
	//5.游戏计分：当img被点击，则进行计分
	img.onclick = function(){
		//a.清除任务：点击事件可能发生在狼上升、等待、下降任何一个过程
		clearInterval(showImgTask);
		clearTimeout(task);
		clearInterval(hideImgTask);
		
		//b.显示狼被打击的动画
		var j = 5;
		var hitTask = setInterval(function(){
			j++;
			img.src = "imgs/"+wolfName+j+".png";
			if(j>9){
				clearInterval(hitTask);
				img.remove();
			}
		},50);
		
		//c.计分
		if(wolfName == "h"){
			score = score+10;
		}else{
			score = score-10;
		}
		fractionDiv.innerHTML = score;
	}
	
}


