window.addEventListener('load', function(e) {
	console.log('script.js loaded');
	init();
});

function init() {
	console.log('In init()');
	//loadSeltzerList();
	//loadCoffeeList();
	loadBeerList();
	beerForm.addBeer.addEventListener('click', function(e) {
		e.preventDefault();
		console.log("beer button WORKING")
		let bName = beerForm.bName.value
		let bBrewer = beerForm.bBrewer.value
		let bStyle = beerForm.bStyle.value
		let bDetail = beerForm.bDetail.value
		let bAbv = beerForm.bAbv.value
		let bOrigin = beerForm.bOrigin.value
		let bPurveyor = beerForm.bPurveyor.value
		let beer = { name: bName, brewer: bBrewer, style: bStyle, styleTwo: bDetail, origin: bOrigin, abv: bAbv, purveyor: bPurveyor }
		addBeer(beer);
	});
}

function addBeer(beer) {
	console.log(beer);
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/beers/');
	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				loadBeerList();

			} else {
				alert("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};
	let beerJson = JSON.stringify(beer);
	xhr.send(beerJson);
}

function loadBeerList() {
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/beers/')
	xhr.onreadystatechange = function() {
		console.log('in xhr.onreadystatechange')
		if (xhr.readyState === 4) {
			console.log('readyState is 4')
			if (xhr.status === 200) {
				let list = JSON.parse(xhr.responseText);
				console.log(list);
				displayBeerList(list);
			}
		} else {
			console.log('error')
		};

	}
	xhr.send();
}

function displayBeerList(list) {
	let beerTBody = document.getElementById('beerTBody');
	beerTBody.textContent = ""
	for (let b of list) {
		console.log(b)
		let newTr = document.createElement('tr');
		let nameTd = document.createElement('td');
		let brewerTd = document.createElement('td');
		let styleTd = document.createElement('td');
		let detailTd = document.createElement('td');
		let abvTd = document.createElement('td');
		let originTd = document.createElement('td');
		let purveyorTd = document.createElement('td');
		let dtTd = document.createElement('td');
		nameTd.textContent = b.name
		brewerTd.textContent = b.brewer
		styleTd.textContent = b.style
		detailTd.textContent = b.styleTwo;
		abvTd.textContent = b.abv;
		originTd.textContent = b.origin;
		purveyorTd.textContent = b.purveyor;
		dtTd.textContent = b.dateTime;
		newTr.appendChild(nameTd);
		newTr.appendChild(brewerTd);
		newTr.appendChild(styleTd);
		newTr.appendChild(detailTd);
		newTr.appendChild(abvTd);
		newTr.appendChild(originTd);
		newTr.appendChild(purveyorTd);
		//newTr.appendChild(dtTd);
		let beer = { name: b.name, brewer: b.brewer, style: b.style, styleTwo: b.styleTwo, origin: b.origin, abv: b.abv, purveyor: b.purveyor }
		beerTBody.appendChild(newTr);

		newTr.addEventListener('click', function(e) {
			e.preventDefault();
			
			for (let i in beer) {
				let newInput = document.createElement("input")
				newInput.type = "text"
				newInput.name = i
				newInput.value = beer[i]
				updateForm.appendChild(newInput)
			}
						
	});

};
}


