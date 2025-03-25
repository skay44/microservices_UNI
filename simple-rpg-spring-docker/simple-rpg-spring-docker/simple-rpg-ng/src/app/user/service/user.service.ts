import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Users } from "../model/users";

/**
 * User management service. Calls REST endpoints.
 */
@Injectable()
export class UserService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all users.
   *
   * @return list of users
   */
  getUsers(): Observable<Users> {
    return this.http.get<Users>('/api/users');
  }

  /**
   * Removes single user.
   *
   * @param uuid user's id
   */
  deleteUser(uuid: string): Observable<any> {
    return this.http.delete('/api/users/' + uuid);
  }

}
