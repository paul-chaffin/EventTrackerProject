import { Pipe, PipeTransform } from '@angular/core';
import { Beer } from '../models/beer';

@Pipe({
  name: 'pattern'
})
export class PatternPipe implements PipeTransform {

  transform(allBeerList: Beer[], pattern: string): Beer[] {
    const results: Beer[] = [];
    if (pattern === ''){
      return allBeerList;
    }

    allBeerList.forEach((beer)=> {
      let style = beer.style;
      if (style !== null){
        if (style === pattern){
          results.push(beer);
        }
      }
    })
    return results;
  }

}
