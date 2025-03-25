import { Component, OnInit } from '@angular/core';
import { DrillService } from '../../service/drill.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { DrillForm } from '../../model/drill-form';
import { DrillPatchForm } from '../../model/drill-patch-form';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-drill-edit',
  templateUrl: './drill-edit.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf
  ],
  styleUrls: ['./drill-edit.component.css']
})
export class DrillEditComponent implements OnInit {

  uuid: string | undefined;

  drill: DrillPatchForm | undefined;

  original: DrillPatchForm | undefined;

  constructor(
    private colonyService: DrillService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.colonyService.getDrill(params['uuid'])
        .subscribe(colony => {
          this.uuid = colony.id;
          this.drill = {
            name: colony.name,
            asteroidID: colony.asteroid.id
          };
          this.original = {...this.drill};
        });
    });
  }

  onSubmit(): void {
    this.colonyService.patchDrill(this.uuid!, this.drill!)
      .subscribe(() => this.router.navigate(['/drills']));
  }

}



