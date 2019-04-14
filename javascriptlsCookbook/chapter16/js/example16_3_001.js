function Book(title,author){
	var title = title;
	var author = author;
	this.getTitle = function(){
		return "Title: " + title;
	}
	this.getAuthor=function(){
		return "Author: " + author;
	}
}

function TechBook(title,author,category){
	var category = category;
	this.getCategory = function(){
		return "Technical Category: " + category;
	}

	Book.apply(this,arguments);
	this.getBook=function(){
		return this.getTitle() + " " + author + " " + this.getCategory();
	}
}

window.onload=function(){
	try {
		var img = new Image();

		Object.defineProperty(img,"geolatitude",{
			get: function(){return geolatitude;},
			set: function(val){geolatitude = val},
			enumerble: true,
			configurable: true
		});

		var props = "Image has ";
		for (var prop in img) {
			props += prop + " ";
		}
		alert(props);
	} catch (e) {
		alert(e);
	}


	try {
		TechBook.prototype = new Book();

		Object.defineProperty(TechBook,"experience",{
			get: function(){return category;},
			set: function(value){category = value;},
			enumerable: false,
			configurable: true
		});


		var val = Object.getOwnPropertyDescriptor(TechBook,"experience");
		alert(JSON.stringify(val));

		props = "TechBOok has ";
		for (var prop in TechBook) {
			props += prop + " ";
		}
		alert(props);

		Object.defineProperty(TechBook, "experience",{
			enumerable: true
		});

		props = "TechBook now has ";
		for (var prop in TechBook) {
			props += prop + " ";
		}
		alert(props);

		var newBook = new TechBook("The Javascript Cookbook","Shelley Powers","Programming");

		newBook.experience="intermediate";
		alert(newBook.experience);

		Object.defineProperty(newBook,"publisher",{
			value: "0'Reilly",
			writable: false,
			enumerable: true,
			configurable: true
		});

		newBook.publisher="Some Other";
		alert(newBook.publisher);

	} catch (e) {
		alert(e);
	}
}
