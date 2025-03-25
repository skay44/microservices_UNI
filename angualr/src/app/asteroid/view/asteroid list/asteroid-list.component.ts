import { Component, OnInit } from '@angular/core';
import { Asteroids } from "../../model/asteroids";
import { Asteroid } from "../../model/asteroid";
import { AsteroidService } from "../../service/asteroid.service";
import {NgForOf, NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';


@Component({
  selector: 'app-asteroid-list',
  templateUrl: './asteroid-list.component.html',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./asteroid-list.component.css']
})
export class AsteroidListComponent implements OnInit {

  constructor(private service: AsteroidService) {
  }

  asteroids: Asteroids | undefined;

  ngOnInit(): void {
    this.service.getAsteroids().subscribe(asteroids => this.asteroids = asteroids);
  }

  onDelete(asteroid: Asteroid): void {
    this.service.deleteAsteroid(asteroid.id).subscribe(() => this.ngOnInit());
  }

}


