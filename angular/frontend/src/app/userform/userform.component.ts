import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  user = {
    name:'Naresh',
    age:25,
     dob : new Date
  }
  users:any[] =[];
  constructor(public userService: UserService) { }

  deleteUser(id:number){
    const observable = this.userService.deleteUser(id);
    observable.subscribe((responseBody: any) => {
      console.log(responseBody);
      
    },
    (error: any) => {
      console.log(error);
    }
  );
  }

  saveUser()
  {
    this.user.dob = new Date(this.user.dob);
    console.log('clicked');
    const promise = this.userService.save(this.user);
    promise.subscribe((responsebody)=>{console.log(responsebody);
    this.users.push(responsebody);
    },
    
    (error: any) =>{console.log(error)}
    );
  }

  ngOnInit(): void {
  }

}
