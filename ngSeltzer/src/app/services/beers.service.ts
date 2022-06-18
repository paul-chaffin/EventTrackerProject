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


}
