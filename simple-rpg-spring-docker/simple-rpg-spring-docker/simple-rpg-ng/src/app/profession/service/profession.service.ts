import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Professions } from "../model/professions";

/**
 * Profession management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class ProfessionService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all professions.
   *
   * @return list of professions
   */
  getProfessions(): Observable<Professions> {
    return this.http.get<Professions>('/api/professions');
  }

}
