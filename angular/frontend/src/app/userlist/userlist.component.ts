import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { UserformComponent } from '../userform/userform.component';

@Component({
  selector: 'userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  users: any[] = [];

  constructor(public userservice: UserService) { }

  ngOnInit(): void {
    const observable = this.userservice.getUsers();
    observable.subscribe((usersFromServer: any) => {
      this.users = usersFromServer;
   })

  

  }}
