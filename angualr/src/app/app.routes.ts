import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DrillListComponent } from "./drill/view/drill-list/drill-list.component";
import { DrillViewComponent } from "./drill/view/drill-view/drill-view.component";
import { DrillEditComponent } from "./drill/view/drill-edit/drill-edit.component";
import { AsteroidListComponent } from "./asteroid/view/asteroid list/asteroid-list.component";
import { AsteroidEditComponent } from './asteroid/view/asteroid edit/asteroid-edit.component';
import { AsteroidViewComponent } from './asteroid/view/asteroid-view/asteroid-view.component';
import { AsteroidCreateComponent } from './asteroid/view/asteroid-create/asteroid-create.component';
import {DrillCreateComponent} from './drill/view/drill-create/drill-create.component';


export const routes: Routes = [
  {
    component: AsteroidEditComponent,
    path: "asteroids/:uuid/edit"
  },
  {
    component: AsteroidCreateComponent,
    path: "asteroids/create"
  },
  {
    component: AsteroidViewComponent,
    path: "asteroids/:uuid"
  },
  {
    component: DrillListComponent,
    path: "drills"
  },
  {
    component: DrillCreateComponent,
    path: "drills/create/:uuid"
  },
  {
    component: DrillViewComponent,
    path: "drills/:uuid"
  },
  {
    component: DrillEditComponent,
    path: "drills/:uuid/edit"
  },
  {
    component: AsteroidListComponent,
    path: "asteroids"
  },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
