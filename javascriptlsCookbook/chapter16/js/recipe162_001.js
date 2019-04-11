function Tune(song,artist){
	var title = song;
	var artist = artist;
	this.concat = function(){
		return title + " " + artist;
	}
}


window.onload=function(){
	var happySong = new Array();
	happySong[0] = new Tune("Putting on the Ritz","Ella Fitzgerald");

	try{
		alert(happySongs[0].title);
	}catch(e){
		alert(e);
	}

	alert(happySongs[0].concat());
}
