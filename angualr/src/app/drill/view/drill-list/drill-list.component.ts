import { Component, OnInit } from '@angular/core';
import { DrillService } from "../../service/drill.service";
import { Drills } from "../../model/drills";
import { Drill } from "../../model/drill";
import {RouterLink} from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';


@Component({
  selector: 'app-drill-list',
  templateUrl: './drill-list.component.html',
  standalone: true,
  imports: [
    RouterLink,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./drill-list.component.css']
})
export class DrillListComponent implements OnInit{

  constructor(private service: DrillService) {
  }

  miningDrills: Drills | undefined;
  d : Drill | undefined;

  ngOnInit(): void {

    this.d = { id: "2", name: "3"}
    this.miningDrills = { miningDrills: [ this.d ] }

    this.service.getDrills().subscribe(drills => this.miningDrills = drills)
  }

  onDelete(colony: Drill): void {
    this.service.deleteDrill(colony.id).subscribe(() => this.ngOnInit());
  }

}
