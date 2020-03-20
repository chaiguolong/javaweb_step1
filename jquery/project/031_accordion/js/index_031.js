$(function($) {
	$('.accordion').gridAccordion({
		width: 1100,
		height: 680,
		columns: 4,
		distance: 2,
		closedPanelWidth: 10,
		closedPanelHeight: 10,
		alignType: 'centerCenter',
		slideshow: true,
		panelProperties: {
			0 : {
				captionWidth: 200,
				captionHeight: 35,
				captionTop: 30,
				captionLeft: 30
			},
			4 : {
				captionWidth: 150,
				captionHeight: 100,
				captionTop: 30,
				captionLeft: 650
			},
			7 : {
				captionWidth: 310,
				captionHeight: 35,
				captionTop: 350,
				captionLeft: 40
			},
			8 : {
				captionWidth: 300,
				captionHeight: 40,
				captionTop: 150,
				captionLeft: 35
			},
			11 : {
				captionWidth: 150,
				captionHeight: 120,
				captionTop: 300,
				captionLeft: 30
			},
			14 : {
				captionWidth: 300,
				captionHeight: 40,
				captionTop: 30,
				captionLeft: 50
			},
			16 : {
				captionWidth: 150,
				captionHeight: 120,
				captionTop: 150,
				captionLeft: 10
			},
			18 : {
				captionWidth: 300,
				captionHeight: 40,
				captionTop: 130,
				captionLeft: 50
			}
		}
	});
});
