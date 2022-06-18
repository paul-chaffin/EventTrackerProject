import { toJSDate } from "@ng-bootstrap/ng-bootstrap/datepicker/ngb-calendar";

export class Beer {

  id: number | null;
  dateTime: string | null;
  style: string | null;
  styleTwo: string | null;
  name: string | null;
  origin: string | null;
  abv: number | null;
  purveyor: string | null;

  constructor(
    id: number | null = 0,
    dateTime: string | null = '',
    style: string | null = '',
    styleTwo: string | null = '',
    name: string | null = '',
    origin: string | null = '',
    abv: number | null = 0,
    purveyor: string | null = '',
  ){
    this.id = id;
    this.dateTime = dateTime;
    this.style = style;
    this.styleTwo = styleTwo;
    this.name = name;
    this.origin = origin;
    this.abv = abv;
    this.purveyor = purveyor;
  }

}
