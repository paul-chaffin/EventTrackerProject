import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Beer } from 'src/app/models/beer';
import { BeersService } from 'src/app/services/beers.service';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css'],
})
export class BeerListComponent implements OnInit {
  beerList: Beer[] = [];

  selected: null | Beer = null;

  newBeer: Beer = new Beer();

  editBeer: null | Beer = null;

  showAddForm: boolean = false;

  constructor(
    private beerServ: BeersService,
    private currentRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    let idStr = this.currentRoute.snapshot.paramMap.get('id');
    if (!this.selected && idStr) {
      let idNum = Number.parseInt(idStr);
      if (!isNaN(idNum)) {
        this.beerServ.show(idNum).subscribe({
          next: (result) => {
            this.selected = result;
          },
          error: (nojoy) => {
            this.router.navigateByUrl('/beerNotFound');
          },
        });
      } else {
        this.router.navigateByUrl('/invalidBeerId');
      }
    }
    this.reload();
  }

  reload() {
    this.beerServ.index().subscribe({
      next: (beers) => {
        this.beerList = beers;
      },
      error: (err) => {
        console.error('BeerListComponent.reload: error');
        console.error(err);
      },
    });
  }

  getTotalOz(): number {
    let totalOz = 0;
    this.beerList.forEach((beer) => {
      totalOz += 12;
    });
    return totalOz;
  }

  getTotalAbv(): number {
    let totalAbv = 0;
    this.beerList.forEach((beer)=> {
      let bAbv = beer.abv;
      totalAbv += (12 * (bAbv / 100));
    })
    return totalAbv;
  }

  addBeer(beer: Beer): void {
    this.beerServ.create(beer).subscribe({
      next: (result) => {
        this.newBeer = new Beer();
        this.reload();
      },
      error: (nojoy) => {
        console.error('BeerListHttpComponent.addBeer(): error creating beer:');
        console.error(nojoy);
      },
    });
  }

  setEditBeer(toEdit: Beer) {
    this.editBeer = toEdit;
  }

  updateBeer(beer: Beer) {
    this.beerServ.update(beer).subscribe({
      next: (result) => {
        this.reload();
        this.editBeer = null;
      },
      error: (nojoy) => {
        console.error(
          'BeerListHttpComponent.updateBeer(): error updating beer:'
        );
        console.error(nojoy);
      },
    });
  }

  displayBeer(beer: Beer) {
    this.selected = beer;
  }

  displayTable() {
    this.selected = null;
  }

  deleteBeer(id: number) {
    return this.beerServ.destroy(id).subscribe({
      next: (result) => {
        this.reload();
      },
      error: (nojoy) => {
        console.error(
          'BeerListHttpComponent.deleteBeer(): error deleting beer:'
        );
        console.error(nojoy);
      },
    });
  }
}
