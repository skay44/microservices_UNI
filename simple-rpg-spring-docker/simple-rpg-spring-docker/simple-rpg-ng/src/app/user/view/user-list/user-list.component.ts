import { Component, OnInit } from '@angular/core';
import { Users } from "../../model/users";
import { User } from "../../model/user";
import { UserService } from "../../service/user.service";

/**
 * Navigable view with list of all users.
 */
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  /**
   * @param service users service
   */
  constructor(private service: UserService) {
  }

  /**
   * Available users.
   */
  users: Users | undefined;

  ngOnInit(): void {
    this.service.getUsers().subscribe(users => this.users = users);
  }

  /**
   * Deletes selected user.
   *
   * @param user user to be removed
   */
  onDelete(user: User): void {
    this.service.deleteUser(user.id).subscribe(() => this.ngOnInit());
  }

}
