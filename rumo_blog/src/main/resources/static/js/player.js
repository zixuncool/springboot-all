window.AudioContext = window.AudioContext || window.webkitAudioContext || window.mozAudioContext || window.msAudioContext;
var canvas, ctx;
var audioContext;
var file;
var fileContent;
var audioBufferSourceNode;
var analyser;

function loadSound(url) {
	var request = new XMLHttpRequest(); 
	request.open('GET', url, true); 
	request.responseType = 'arraybuffer'; 
	request.onload = function() {
		var arraybuffer = request.response;
		audioContext.decodeAudioData(arraybuffer, function(buffer) {
			start(buffer);	
		});
	}
	request.send();
}

var start = function(buffer) {
	if(audioBufferSourceNode) {
		audioBufferSourceNode.stop();
	}

	audioBufferSourceNode = audioContext.createBufferSource();
	audioBufferSourceNode.connect(analyser);
	analyser.connect(audioContext.destination);
	audioBufferSourceNode.buffer = buffer;
	audioBufferSourceNode.start(0);
	window.requestAnimationFrame(render); 
	bufferflag = buffer;
	audioBufferSourceNode.onended = function(){
	}
}



var render = function() {
	if(!flag)return;
	ctx = canvas.getContext("2d");
	ctx.strokeStyle = "#00d0ff";
	ctx.lineWidth = 2;
	gradient = ctx.createLinearGradient(0, 0, 0, 300);
	gradient.addColorStop(1, '#ff5722');
	gradient.addColorStop(0.5, '#ff0');
	gradient.addColorStop(0, '#ff5722');
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	var dataArray = new Uint8Array(analyser.frequencyBinCount);
	analyser.getByteFrequencyData(dataArray);
	var step = Math.round(dataArray.length / 60);
	for (var i = 0; i < 100; i++) {
		var energy = (dataArray[step * i] / 206.0) * 80;
		ctx.fillStyle = gradient
		ctx.fillRect(i * 10, cwidth/1.2-energy*6 , 9, 800);
	}
	window.requestAnimationFrame(render);
}

var cwidth = 800;
var flag = true;
var cflag = true;
var bufferflag ;
function loadSoundplay(obj){
	if($(obj).hasClass("active")){
		$(obj).removeClass("active").find(".fa-play-circle").removeClass("r");
		audioBufferSourceNode.stop();
		flag = false;
	}else{
		$(obj).addClass("active").find(".fa-play-circle").addClass("r");
		if(cflag){
			cflag = false;
			audioContext = new AudioContext();
			analyser = audioContext.createAnalyser();
			analyser.fftSize = 256;
			loadSound($("#audiobox").attr("src"));
			canvas = document.getElementById('visualizer');
			cwidth = canvas.width;
		}else{
			start(bufferflag);
			flag = true;
		}
	}
}

