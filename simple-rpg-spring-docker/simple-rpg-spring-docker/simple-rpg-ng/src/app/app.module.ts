import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { UserListComponent } from './user/view/user-list/user-list.component';
import { HttpClientModule } from "@angular/common/http";
import { UserService } from "./user/service/user.service";
import { CharacterListComponent } from './character/view/character-list/character-list.component';
import { CharacterService } from './character/service/character.service';
import { CharacterViewComponent } from './character/view/character-view/character-view.component';
import { CharacterEditComponent } from './character/view/character-edit/character-edit.component';
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
    UserListComponent,
    CharacterListComponent,
    CharacterViewComponent,
    CharacterEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    CharacterService,
    UserService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
