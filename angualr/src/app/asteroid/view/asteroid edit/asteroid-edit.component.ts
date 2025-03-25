import { Component, OnInit } from '@angular/core';
import { AsteroidService } from '../../service/asteroid.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { AsteroidForm } from '../../model/asteroid-form';
import {AsteroidPatchForm} from '../../model/asteroid-patch-form';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-asteroid-edit',
  templateUrl: './asteroid-edit.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf
  ],
  styleUrls: ['./asteroid-edit.component.css']
})
export class AsteroidEditComponent implements OnInit {

  uuid: string | undefined;

  asteroid: AsteroidPatchForm | undefined;

  original: AsteroidPatchForm | undefined;

  constructor(
    private empireService: AsteroidService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.empireService.getAsteroid(params['uuid'])
        .subscribe(asteroid => {
          this.uuid = asteroid.id;
          this.asteroid = {
            name: asteroid.name,
            size: asteroid.asteroidSize
          };
          this.original = {...this.asteroid};
        });
    });
  }

  onSubmit(): void {
    this.empireService.patchAsteroid(this.uuid!, this.asteroid!)
      .subscribe(() => this.router.navigate(['/asteroids']));
  }

}



