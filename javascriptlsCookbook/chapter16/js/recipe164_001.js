function Tune(){
	var artist;
	var song;
	this.__defineGetter__("artist",function(){
		return artist
	});

	this.__defineSetter__("artist",function(val){
		artist = "By: " +val
	});

	this.__defineGetter__("song",function(){
		return "Song: " + song
	});

	this.__defineSetter__("song",function(val){
		song=val
	});

}

window.onload=function(){
	var happySong = new Tune();

	happySong.artist = "Ella Fitzgerald";
	happySong.song="Putting on the Ritz";

	alert(happySong.song + " " + happySong.artist);
}
