import { Component, OnInit } from '@angular/core';
import { DrillService } from '../../service/drill.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { DrillForm } from '../../model/drill-form';
import { DrillPatchForm } from '../../model/drill-patch-form';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-colony-create',
  templateUrl: './drill-create.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf,
    ReactiveFormsModule
  ],
  styleUrls: ['./drill-create.component.css']
})
export class DrillCreateComponent implements OnInit {

  uuid: string | undefined;

  drill: DrillForm | undefined;
  drillForm1: FormGroup | undefined;

  constructor(
    private drillService: DrillService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.drillForm1 = new FormGroup({
        name: new FormControl(),
        size: new FormControl(),
        asteroidID: new FormControl(params['uuid']),
      });
    });

    this.uuid = this.generateJavaUUID();
  }

  generateJavaUUID(): string {
    const getRandomHex = (length: number): string => {
      let hex = '';
      for (let i = 0; i < length; i++) {
        hex += Math.floor(Math.random() * 16).toString(16);
      }
      return hex;
    };

    // UUID format: 8-4-4-4-12
    const part1 = getRandomHex(8);
    const part2 = getRandomHex(4);
    const part3 = getRandomHex(4);
    const part4 = getRandomHex(4);
    const part5 = getRandomHex(12);

    // Assemble the UUID string
    return `${part1}-${part2}-${part3}-${part4}-${part5}`;
  }

  onSubmit(): void {
    console.log(this.drillForm1!.value)
    this.drill = {
      name: this.drillForm1!.controls['name'].value,
      size: this.drillForm1!.controls['size'].value,
      asteroidID: this.drillForm1!.controls['asteroidID'].value,
    }
    this.drillService.putColony(this.uuid!, this.drill!)
      .subscribe(() => this.router.navigate(['/asteroids', this.drill!.asteroidID]));
  }

}



