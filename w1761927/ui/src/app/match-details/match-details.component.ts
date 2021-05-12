import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";

@Component({
  selector: 'app-match-details',
  templateUrl: './match-details.component.html',
  styleUrls: ['./match-details.component.css']
})
export class MatchDetailsComponent  implements OnInit {

  matchArray=[];



  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getMatchDetails().subscribe((data1: any[])=>{
      this.matchArray= data1;
    })


  }

  sortUser5() {

    this.userService.getSortingMatchTable().subscribe((data2: any) => {
      this.matchArray = data2;


    })
  }
  searchUser(searchValue:string){
    this.userService.getSearchingMatchTable(searchValue).subscribe((data2: any) => {
      this.matchArray = data2;
    })
  }

  createMatch(){
    this.userService.getCreateRandomMatches().subscribe((data2: any) => {
      this.matchArray = data2;


    })
  }
}
