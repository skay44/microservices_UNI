import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { AsteroidListComponent } from './asteroid/view/asteroid list/asteroid-list.component';
import { HttpClientModule } from "@angular/common/http";
import { AsteroidService } from "./asteroid/service/asteroid.service";
import { DrillListComponent } from './drill/view/drill-list/drill-list.component';
import { DrillService } from './drill/service/drill.service';
import { DrillViewComponent } from './drill/view/drill-view/drill-view.component';
import { DrillEditComponent } from './drill/view/drill-edit/drill-edit.component';
import { FormsModule } from "@angular/forms";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    AsteroidListComponent,
    DrillListComponent,
    DrillViewComponent,
    DrillEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    DrillService,
    AsteroidService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class Modulesforlater {

}

