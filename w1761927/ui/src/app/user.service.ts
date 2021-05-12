import { Injectable } from '@angular/core';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';
import {HttpClient, HttpParams} from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private path =  '/api/getFootBallClubs';
  private path1='/api/getMatches';
  private  path2='/api/getSortByPoints'
  private  path3='/api/getSortByWins'
  private  path4='/api/getSortByGoals'
  private  path5='/api/getMatchSortByDate'
  private  path6='/api/getsearchMatches'
  private  path7='/api/getRandomMatchPlayed'

  constructor(private http:HttpClient) { }

  public getMatchDetails(): Observable<any[]> {
    return this.http.get<any[]>(this.path1);
  }


  public getClubsDetails(): Observable<any[]> {
    return this.http.get<any[]>(this.path);
  }


  public getSortingTableByPoints(): Observable<any[]> {
    return this.http.get<any[]>(this.path2);
  }

  public getSortingTableByWins(): Observable<any[]> {
    return this.http.get<any[]>(this.path3);
  }

  public getSortingTableByGoals(): Observable<any[]> {
    return this.http.get<any[]>(this.path4);
  }
  public getSortingMatchTable(): Observable<any[]> {
    return this.http.get<any[]>(this.path5);
  }
  public getSearchingMatchTable(filterDate:string): Observable<any[]> {
   const params=new HttpParams().set("filterDate",filterDate);
    return this.http.get<any[]>(this.path6,{params});
  }
  public getCreateRandomMatches(): Observable<any[]> {
    return this.http.get<any[]>(this.path7);
  }
}
