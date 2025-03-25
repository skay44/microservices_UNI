import { Component, OnInit } from '@angular/core';
import { AsteroidService } from "../../service/asteroid.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import { AsteroidDetails } from "../../model/asteroid-details";
import {NgForOf, NgIf} from '@angular/common';
import { Drills } from '../../../drill/model/drills';
import { DrillService } from '../../../drill/service/drill.service';
import { Drill } from '../../../drill/model/drill';

/**
 * Preview of single empire.
 */
@Component({
  selector: 'app-asteroid-view',
  templateUrl: './asteroid-view.component.html',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./asteroid-view.component.css']
})
export class AsteroidViewComponent implements OnInit {

  asteroid: AsteroidDetails | undefined;
  drills: Drills | undefined;

  constructor(private service: AsteroidService, private route: ActivatedRoute, private router: Router, private colonyService: DrillService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getAsteroid(params['uuid'])
        .subscribe(asteroid => this.asteroid = asteroid)
    });
    this.route.params.subscribe(params => {
      this.colonyService.getColoniesByEmpire(params['uuid'])
        .subscribe(drills => this.drills = drills)
    });
  }

  onDelete(drills: Drill): void {
    this.colonyService.deleteDrill(drills.id).subscribe(() => this.ngOnInit());
  }

}


