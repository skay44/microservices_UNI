import { Component, OnInit } from '@angular/core';
import { DrillService } from "../../service/drill.service";
import { ActivatedRoute, Router } from "@angular/router";
import { DrillDetails } from "../../model/drill-details";
import {NgIf} from '@angular/common';

/**
 * Preview of single colony.
 */
@Component({
  selector: 'app-drill-view',
  templateUrl: './drill-view.component.html',
  standalone: true,
  imports: [
    NgIf
  ],
  styleUrls: ['./drill-view.component.css']
})
export class DrillViewComponent implements OnInit {

  drill: DrillDetails | undefined;

  constructor(private service: DrillService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getDrill(params['uuid'])
        .subscribe(drill => this.drill = drill)
    });
  }

}


