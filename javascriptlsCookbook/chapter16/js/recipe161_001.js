window.onload=function(){
	var happySong = new Array();
	happySong[0] = new Tune("Putting on the Ritz","Ella Fitzgerald");

	alert(happySong[0].concat());
}

function Tune(song,artist){
	this.title = song;
	this.artist = artist;
	this.concat = function(){
		return this.title + " " + this.artist;
	}
}
