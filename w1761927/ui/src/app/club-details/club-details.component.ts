import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";

@Component({
  selector: 'app-club-details',
  templateUrl: './club-details.component.html',
  styleUrls: ['./club-details.component.css']
})
export class ClubDetailsComponent implements OnInit {


  clubArray: any;

  constructor(private userService: UserService) {
  }

  ngOnInit() {

    this.userService.getClubsDetails().subscribe((data1: any) => {
      this.clubArray = data1;


    })
    // this.sortUser();
    // this.sortUser1();
    // this.sortUser2();
  }

  sortUser() {

    this.userService.getSortingTableByPoints().subscribe((data2: any) => {
      this.clubArray = data2;

    })
  }

  sortUser1() {

    this.userService.getSortingTableByWins().subscribe((data3: any) => {
      this.clubArray = data3;


    })
  }
  sortUser2() {

    this.userService.getSortingTableByGoals().subscribe((data4: any) => {
      this.clubArray = data4;


    })
  }




}
