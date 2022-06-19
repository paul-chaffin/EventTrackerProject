import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Beer } from '../models/beer';

@Injectable({
  providedIn: 'root'
})
export class BeersService {

  private url = environment.baseUrl + 'api/beers'

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Beer[]> {
    return this.http.get<Beer[]>(this.url).pipe(
      catchError((err: any)=>{
        console.log(err);
        return throwError(
          () => new Error(
            'BeersService.index(): error retrieving Beer list: ' + err
          )
        );
      })
    );
  }

  patternSearch(pattern: string): Observable<Beer[]> {
    return this.http.get<Beer[]>(this.url + '/style/' + pattern).pipe(
      catchError((err: any)=>{
        console.log(err);
        return throwError(
          () => new Error(
            'BeersService.patternSearch(): error retrieving Beer list: ' + err
          )
        )
      })
    )
  }

  show(id: number): Observable<Beer> {
    return this.http.get<Beer>(this.url + '/' + id).pipe(
      catchError((err: any)=>{
        console.log(err);
        return throwError(
          () => new Error(
            'BeerService.show(): error retrieving Beer with id ' + id +'. Error: ' + err
          )
        );
      })
    );
  }

  create(beer: Beer): Observable<Beer> {
    return this.http.post<Beer>(this.url, beer).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'BeerService.create(): error creating Beer: ' + err
          )
        );
      })
    );
  }

  update(beer: Beer): Observable<Beer> {

    return this.http.put<Beer>(this.url + '/' + beer.id, beer).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'BeerService.update(): error updating Beer: ' + err
          )
        );
      })
    );
    }

    destroy(id: number){
      return this.http.delete<void>(this.url +'/'+ id).pipe(
        catchError((err:any) => {
          console.log(err);
          return throwError(
            () => new Error(
              'BeerService.destroy: error deleting Beer: ' + err
            )
          )
        })
      );
    }

}
