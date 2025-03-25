import { Component, OnInit } from '@angular/core';

import {ActivatedRoute, Router, RouterLink} from '@angular/router';

import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {AsteroidForm} from '../../model/asteroid-form';
import {AsteroidService} from '../../service/asteroid.service';

@Component({
  selector: 'app-asteroid-create',
  templateUrl: './asteroid-create.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf,
    ReactiveFormsModule
  ],
  styleUrls: ['./asteroid-create.component.css']
})
export class AsteroidCreateComponent implements OnInit {

  uuid: string | undefined;

  asteroid: AsteroidForm | undefined;
  asteroidForm: FormGroup | undefined;

  constructor(
    private asteroidService: AsteroidService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
      this.asteroidForm = new FormGroup({
        name: new FormControl(),
        size: new FormControl(),
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
    console.log(this.asteroidForm!.value)
    this.asteroid = {
      name: this.asteroidForm!.controls['name'].value,
      size: this.asteroidForm!.controls['size'].value
    }
    this.asteroidService.putAsteroid(this.uuid!, this.asteroid!)
      .subscribe(() => this.router.navigate(['/asteroids']));
  }

}



