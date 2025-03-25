import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {MainComponent} from './component/main/main.component';
import {NavComponent} from './component/nav/nav.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: true,
  imports: [NavComponent, FooterComponent, HeaderComponent, MainComponent, RouterOutlet],
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'lab5angular';
}
