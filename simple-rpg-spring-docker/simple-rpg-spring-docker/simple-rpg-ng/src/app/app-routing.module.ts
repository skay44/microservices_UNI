import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from "./user/view/user-list/user-list.component";
import { CharacterListComponent } from "./character/view/character-list/character-list.component";
import { CharacterViewComponent } from "./character/view/character-view/character-view.component";
import { CharacterEditComponent } from "./character/view/character-edit/character-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: UserListComponent,
    path: "users"
  },
  {
    component: CharacterListComponent,
    path: "characters"
  },
  {
    component: CharacterViewComponent,
    path: "characters/:uuid"
  }
  ,
  {
    component: CharacterEditComponent,
    path: "characters/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
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
