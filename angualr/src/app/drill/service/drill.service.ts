import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Drills } from "../model/drills";
import { DrillDetails } from "../model/drill-details";
import { DrillForm } from "../model/drill-form";
import { DrillPatchForm } from "../model/drill-patch-form";


@Injectable({providedIn: 'root'})
export class DrillService {

  constructor(private http: HttpClient) {

  }

  getDrills(): Observable<Drills> {
    //console.log("ZBIERANIE KOLONII")
    return this.http.get<Drills>('/api/miningDrills');
  }

  getColoniesByEmpire(id: string): Observable<Drills>{
    return this.http.get<Drills>('/api/asteroid/' + id + '/drills');
  }

  getDrill(uuid: string): Observable<DrillDetails> {
    return this.http.get<DrillDetails>('/api/miningDrill/' + uuid);
  }

  deleteDrill(uuid: string): Observable<any> {
    return this.http.delete('/api/miningDrill/' + uuid);
  }

  putColony(uuid: string, request: DrillForm): Observable<any> {
    return this.http.put('/api/miningDrill/' + uuid, request);
  }

  patchDrill(uuid: string, request: DrillPatchForm): Observable<any> {
    console.log("zawartosc: ")
    console.log(request)
    return this.http.patch('/api/miningDrill/' + uuid, request);
  }

}
