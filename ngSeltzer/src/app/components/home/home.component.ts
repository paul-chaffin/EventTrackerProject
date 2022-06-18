import { BeersService } from './../../services/beers.service';
import { Component, OnInit } from '@angular/core';
import { Beer } from 'src/app/models/beer';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  beerList: Beer[] = [];

  constructor(private beerServ: BeersService,
    private currentRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
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
      }
    });
  }

}
