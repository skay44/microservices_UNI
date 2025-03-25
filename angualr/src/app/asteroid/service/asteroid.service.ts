import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Asteroids } from "../model/asteroids";
import { AsteroidForm } from '../model/asteroid-form';
import { AsteroidPatchForm } from '../model/asteroid-patch-form';
import { AsteroidDetails } from '../model/asteroid-details';


@Injectable({providedIn: 'root'})
export class AsteroidService {

  constructor(private http: HttpClient) {

  }

  getAsteroids(): Observable<Asteroids> {
    return this.http.get<Asteroids>('/api/asteroids');
  }

  getAsteroid(uuid: string): Observable<AsteroidDetails> {
    return this.http.get<AsteroidDetails>('/api/asteroid/' + uuid);
  }

  deleteAsteroid(uuid: string): Observable<any> {
    return this.http.delete('/api/asteroid/' + uuid);
  }

  putAsteroid(uuid: string, request: AsteroidForm): Observable<any> {
    return this.http.put('/api/asteroid/' + uuid, request);
  }

  patchAsteroid(uuid: string, request: AsteroidPatchForm): Observable<any> {
    return this.http.patch('/api/asteroid/' + uuid, request);
  }
}
