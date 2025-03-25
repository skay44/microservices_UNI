import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Characters } from "../model/characters";
import { CharacterDetails } from "../model/character-details";
import { CharacterForm } from "../model/character-form";

/**
 * Character management service. Calls REST endpoints.
 */
@Injectable()
export class CharacterService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all characters.
   *
   * @return list of characters
   */
  getCharacters(): Observable<Characters> {
    return this.http.get<Characters>('/api/characters');
  }

  /**
   * Fetches single characters.
   *
   * @param uuid character's id
   * @return single characters
   */
  getCharacter(uuid: string): Observable<CharacterDetails> {
    return this.http.get<CharacterDetails>('/api/characters/' + uuid);
  }

  /**
   * Removes single character.
   *
   * @param uuid character's id
   */
  deleteCharacter(uuid: string): Observable<any> {
    return this.http.delete('/api/characters/' + uuid);
  }

  /**
   * Updates single character.
   *
   * @param uuid character's id
   * @param request request body
   */
  putCharacter(uuid: string, request: CharacterForm): Observable<any> {
    return this.http.put('/api/characters/' + uuid, request);
  }

}
