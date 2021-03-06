import { BeersService } from './services/beers.service';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { BeerListComponent } from './components/beer-list/beer-list.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { DecimalPipe } from '@angular/common';
import { PatternPipe } from './pipes/pattern.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BeerListComponent,
    NotFoundComponent,
    NavigationComponent,
    PatternPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [
    BeersService,
    DecimalPipe,
    PatternPipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
